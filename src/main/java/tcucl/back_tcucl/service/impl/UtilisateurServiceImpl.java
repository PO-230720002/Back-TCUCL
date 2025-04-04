package tcucl.back_tcucl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import tcucl.back_tcucl.dto.*;
import tcucl.back_tcucl.exceptionPersonnalisee.EmailDejaPrisException;
import tcucl.back_tcucl.exceptionPersonnalisee.MauvaisAncienMdpException;
import tcucl.back_tcucl.manager.UtilisateurManager;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.Utilisateur;
import tcucl.back_tcucl.service.EmailService;
import tcucl.back_tcucl.service.EntiteService;
import tcucl.back_tcucl.service.UtilisateurService;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import static tcucl.back_tcucl.Constante.*;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    Logger logger = LoggerFactory.getLogger(UtilisateurServiceImpl.class);

    private final PasswordEncoder passwordEncoder;
    private final UtilisateurManager utilisateurManager;
    private final EntiteService entiteService;
    private final EmailService emailService;

    public UtilisateurServiceImpl(UtilisateurManager utilisateurManager
            , PasswordEncoder passwordEncoder, EntiteService entiteService, EmailService emailService) {
        this.utilisateurManager = utilisateurManager;
        this.passwordEncoder = passwordEncoder;
        this.entiteService = entiteService;
        this.emailService = emailService;
    }

    @Override
    public Boolean emailDejaPris(String email){
        return utilisateurManager.emailDejaPris(email);
    }

    @Override
    public void modifierUtilisateurParUtilisateur(Long id, ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto){
        if(utilisateurManager.emailDejaPris(modificationUtilisateurParUtilisateurDto.getEmail()))
        {
            throw new EmailDejaPrisException(modificationUtilisateurParUtilisateurDto.getEmail());
        }
        Utilisateur utilisateur = utilisateurManager.getUtilisateurParId(id);
        utilisateur.setNom(modificationUtilisateurParUtilisateurDto.getNom());
        utilisateur.setPrenom(modificationUtilisateurParUtilisateurDto.getPrenom());
        utilisateur.setEmail(modificationUtilisateurParUtilisateurDto.getEmail());
        utilisateurManager.save(utilisateur);
    }

    @Override
    public void modifierUtilisateurParAdmin(Long id, ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto) {
        Utilisateur utilisateur = utilisateurManager.getUtilisateurParId(id);
        utilisateur.setNom(modificationUtilisateurParAdminDto.getNom());
        utilisateur.setPrenom(modificationUtilisateurParAdminDto.getPrenom());
        utilisateur.setEmail(modificationUtilisateurParAdminDto.getEmail());
        utilisateur.setEstAdmin(modificationUtilisateurParAdminDto.isEstAdmin());
        utilisateurManager.save(utilisateur);
    }

    @Override
    public Utilisateur getUtilisateurParEmail(String email) {
        return utilisateurManager.getUtilisateurParEmail(email);
    }

    @Override
    public Utilisateur getUtilisateurParId(Long id) {
        return utilisateurManager.getUtilisateurParId(id);
    }

    @Override
    public void inscrireUtilisateur(InscriptionDto inscriptionDto){
        //Est ce que le mail est déjà pris
        String email = inscriptionDto.getEmail();
        if (utilisateurManager.emailDejaPris(email)){
            throw new EmailDejaPrisException(email);
        }

        //Génération du mot de passe aléatoire
        String mdpAleatoire = genererMdpAleatoire();
        logger.info("Mot de passe généré: " + mdpAleatoire);  // Log du mot de passe généré

        //Création de l'utilisateur
        Utilisateur nouvelUtilisateur = new Utilisateur(
                inscriptionDto.getNom(),
                inscriptionDto.getPrenom(),
                passwordEncoder.encode(mdpAleatoire),
                email,
                PREMIERE_CONNEXION_TRUE,
                ROLE_USER,
                inscriptionDto.isEstAdmin(),
                SUPERADMIN_FALSE,
                entiteService.getEntiteById(inscriptionDto.getEntiteId()));

        //envoi du mail
        emailService.sendSimpleEmail(inscriptionDto.getPrenom(), email, mdpAleatoire);
        utilisateurManager.save(nouvelUtilisateur);
    }

    @Override
    public void modifierEstAdmin(Long id, Boolean estAdmin) {
        Utilisateur utilisateur = utilisateurManager.getUtilisateurParId(id);
        utilisateur.setEstAdmin(estAdmin);
        utilisateurManager.save(utilisateur);
    }

    @Override
    public List<Utilisateur> getAllUtilisateurParEntiteId(Long entiteId) {
        return utilisateurManager.getAllUtilisateurParEntiteId(entiteId);
    }


    @Override
    public void save(Utilisateur utilisateur) {
        utilisateurManager.save(utilisateur);
    }

    @Override
    public void changePassword(ChangePasswordDto requete) {
        Utilisateur utilisateur = utilisateurManager.getUtilisateurParEmail(requete.getEmail());
        if (!passwordEncoder.matches(requete.getAncienMdp(), utilisateur.getMdp())) {
            throw new MauvaisAncienMdpException();
        }
        utilisateur.setMdp(passwordEncoder.encode(requete.getNouveauMdp()));
        utilisateur.setEstPremiereConnexion(PREMIERE_CONNEXION_FALSE);
        utilisateurManager.save(utilisateur);

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
