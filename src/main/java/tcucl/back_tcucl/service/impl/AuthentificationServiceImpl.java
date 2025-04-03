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
import tcucl.back_tcucl.entity.Utilisateur;
import tcucl.back_tcucl.exceptionPersonnalisee.MauvaisAncienMdpException;
import tcucl.back_tcucl.exceptionPersonnalisee.UtilisateurNonTrouveEmailException;
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
        try{
            utilisateur = utilisateurService.getUtilisateurParEmail(connexionDto.getEmail());
        }catch (UtilisateurNonTrouveEmailException e){
            throw new MauvaisAncienMdpException();
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(connexionDto.getEmail(), connexionDto.getMdp())
        );

        if (authentication.isAuthenticated()) {
            Map<String, Object> authData = new HashMap<>();
            authData.put(JETON, jwtUtils.generateToken(connexionDto.getEmail()));
            authData.put(TYPE, BEARER);
            if (utilisateur.getEstPremiereConnexion()) {
                authData.put(MESSAGE, MESSAGE_PREMIERE_CONNEXION);
            }
            return authData;
        }else {
            throw new MauvaisAncienMdpException();
        }

    }


}
