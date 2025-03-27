package tcucl.back_tcucl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.config.JwtUtils;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.ConnexionDto;
import tcucl.back_tcucl.dto.InscriptionDto;
import tcucl.back_tcucl.entity.Utilisateur;
import tcucl.back_tcucl.repository.UserRepository;
import tcucl.back_tcucl.service.EmailService;
import tcucl.back_tcucl.service.EntiteService;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static tcucl.back_tcucl.controller.ControllerConstants.*;

@RestController
@RequestMapping(AUTH)
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;
    private final EntiteService entiteService;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtils jwtUtils,
                          AuthenticationManager authenticationManager,
                          EmailService emailService, EntiteService entiteService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.emailService = emailService;
        this.entiteService = entiteService;
    }

    @PostMapping(INSCRIPTION)
    public ResponseEntity<?> register(@RequestParam InscriptionDto inscriptionDto) {

        //Est ce que le mail est déjà pris
        if (userRepository.findByEmail(inscriptionDto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(ERREUR_EMAIL_DEJA_PRIS);
        }

        //Génération du mot de passe aléatoire
        String mdpAleatoire = genererMdpAleatoire();
        logger.info("Mot de passe généré: " + mdpAleatoire);  // Log du mot de passe généré

        //Création de l'utilisateur
        Utilisateur nouvelUtilisateur = new Utilisateur(
                inscriptionDto.getNom(),
                inscriptionDto.getPrenom(),
                passwordEncoder.encode(mdpAleatoire),
                inscriptionDto.getEmail(),
                PREMIERE_CONNEXION_TRUE,
                ROLE_USER,
                inscriptionDto.isEstAdmin(),
                SUPERADMIN_FALSE,
                entiteService.getEntiteById(inscriptionDto.getEntiteId()));

        emailService.sendSimpleEmail(inscriptionDto.getPrenom(), inscriptionDto.getEmail(), mdpAleatoire);
        return ResponseEntity.ok(userRepository.save(nouvelUtilisateur));
    }

    @PostMapping(CONNEXION)
    public ResponseEntity<?> login(@RequestBody ConnexionDto connexionDto) {
        try {
            Optional<Utilisateur> optionalUser = userRepository.findByUsername(connexionDto.getEmail());
            if (optionalUser.isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ERREUR_EMAIL_OU_MDP_INVALIDE);
            }
            Utilisateur authenticatedUtilisateur = optionalUser.get();
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(connexionDto.getEmail(), connexionDto.getMdp())
            );

            if (authentication.isAuthenticated()) {
                Map<String, Object> authData = new HashMap<>();
                authData.put(JETON, jwtUtils.generateToken(connexionDto.getEmail()));
                authData.put(TYPE, BEARER);

                if (authenticatedUtilisateur.getEstPremiereConnexion()) {
                    authData.put(MESSAGE, MESSAGE_PREMIERE_CONNEXION);
                }
                return ResponseEntity.ok(authData);
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ERREUR_EMAIL_OU_MDP_INVALIDE);
        } catch (AuthenticationException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ERREUR_EMAIL_OU_MDP_INVALIDE);
        }
    }

    @PostMapping(CHANGE_PASSWORD)
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto requete) {

        Optional<Utilisateur> optionalUtilisateur = userRepository.findByEmail(requete.getEmail());
        if (optionalUtilisateur.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ERREUR_UTILISATEUR_NON_TROUVE);
        }

        Utilisateur utilisateur = optionalUtilisateur.get();

        if (!passwordEncoder.matches(requete.getAncienMdp(), utilisateur.getMdp())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ERREUR_MAUVAIS_ANCIEN_MDP);
        }

        utilisateur.setMdp(passwordEncoder.encode(requete.getNouveauMdp()));
        utilisateur.setEstPremiereConnexion(false);
        userRepository.save(utilisateur);

        return ResponseEntity.ok(MDP_BIEN_MIS_A_JOUR);
    }

    private String genererMdpAleatoire() {
        String characters = CHARACTERE_AUTORISE;
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();
    }
}

