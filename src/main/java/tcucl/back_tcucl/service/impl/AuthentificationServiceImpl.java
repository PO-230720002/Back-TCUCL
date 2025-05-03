package tcucl.back_tcucl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.config.JwtUtils;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.ConnexionDto;
import tcucl.back_tcucl.dto.InscriptionDto;
import tcucl.back_tcucl.dto.UtilisateurDto;
import tcucl.back_tcucl.entity.Utilisateur;
import tcucl.back_tcucl.exceptionPersonnalisee.MauvaisIdentifiantsException;
import tcucl.back_tcucl.service.UtilisateurService;
import tcucl.back_tcucl.service.AuthentificationService;

import java.util.HashMap;
import java.util.Map;

import static tcucl.back_tcucl.Constante.*;

@Service
public class AuthentificationServiceImpl implements AuthentificationService {

    Logger logger = LoggerFactory.getLogger(AuthentificationServiceImpl.class);

    private final UtilisateurService utilisateurService;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthentificationServiceImpl(UtilisateurService utilisateurService,
                                       JwtUtils jwtUtils,
                                       AuthenticationManager authenticationManager
    ) {
        this.utilisateurService = utilisateurService;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    // todo à supprimer après Tests
    @Override
    public void inscription(InscriptionDto inscriptionDto) {
        utilisateurService.inscrireUtilisateur(inscriptionDto);
    }

    @Override
    public void changePassword(ChangePasswordDto changePasswordDto) {
        utilisateurService.changePassword(changePasswordDto);
    }

    @Override
    public Map<String, Object> connexion(ConnexionDto connexionDto) {
        logger.info("Connexion de l'utilisateur: " + connexionDto.getEmail());
        logger.info("mdp de l'utilisateur: " + connexionDto.getMdp());

        Utilisateur utilisateur;
        try {
            utilisateur = utilisateurService.getUtilisateurParEmail(connexionDto.getEmail());
            logger.info("Utilisateur récupéré avec succès: " + utilisateur.getEmail());
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération de l'utilisateur", e);
            throw new MauvaisIdentifiantsException();
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(connexionDto.getEmail(), connexionDto.getMdp())
            );
            logger.info("Authentification Spring Security réussie");


            if (authentication.isAuthenticated()) {
                Map<String, Object> authData = new HashMap<>();

                // si c'est sa première connexion, il n'est pas connecté
                // afin de le forcer à changer son mot de passe
                if (utilisateur.getEstPremiereConnexion()) {
                    authData.put(MESSAGE, MESSAGE_PREMIERE_CONNEXION);
                }else {
                    authData.put(JETON, jwtUtils.generateToken(connexionDto.getEmail()));
                    logger.info("Token JWT généré");

                    UtilisateurDto utilisateurDto = new UtilisateurDto(
                            utilisateur.getId(),
                            utilisateur.getNom(),
                            utilisateur.getPrenom(),
                            utilisateur.getEmail(),
                            utilisateur.getEstAdmin(),
                            utilisateur.getEntite().getNom()
                    );

                    authData.put("user", utilisateurDto);
                }

                return authData;
            } else {
                logger.error("Échec d'authentification");
                throw new MauvaisIdentifiantsException();
            }
        } catch (Exception e) {
            logger.error("Erreur lors de l'authentification", e);
            throw new MauvaisIdentifiantsException();
        }
    }



}
