package tcucl.back_tcucl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import tcucl.back_tcucl.dto.*;
import tcucl.back_tcucl.dto.securite.UtilisateurSecuriteDto;
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
    public Boolean isEmailDejaPris(String utilisateurEmail){
        return utilisateurManager.isEmailDejaPris(utilisateurEmail);
    }

    @Override
    public void modifierUtilisateurParUtilisateur(Long utilisateurId, ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto){
        if(utilisateurManager.isEmailDejaPris(modificationUtilisateurParUtilisateurDto.getEmail()))
        {
            throw new EmailDejaPrisException(modificationUtilisateurParUtilisateurDto.getEmail());
        }
        Utilisateur utilisateur = utilisateurManager.getUtilisateurParId(utilisateurId);
        utilisateur.setNom(modificationUtilisateurParUtilisateurDto.getNom());
        utilisateur.setPrenom(modificationUtilisateurParUtilisateurDto.getPrenom());
        utilisateur.setEmail(modificationUtilisateurParUtilisateurDto.getEmail());
        utilisateurManager.save(utilisateur);
    }

    @Override
    public void modifierUtilisateurParAdmin(Long utilisateurId, ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto) {
        if(utilisateurManager.isEmailDejaPris(modificationUtilisateurParAdminDto.getEmail()))
        {
            throw new EmailDejaPrisException(modificationUtilisateurParAdminDto.getEmail());
        }
        Utilisateur utilisateur = utilisateurManager.getUtilisateurParId(utilisateurId);
        utilisateur.setNom(modificationUtilisateurParAdminDto.getNom());
        utilisateur.setPrenom(modificationUtilisateurParAdminDto.getPrenom());
        utilisateur.setEmail(modificationUtilisateurParAdminDto.getEmail());
        utilisateur.setEstAdmin(modificationUtilisateurParAdminDto.isEstAdmin());
        utilisateurManager.save(utilisateur);
    }

    @Override
    public Utilisateur getUtilisateurParEmail(String utilisateurEmail) {
        return utilisateurManager.getUtilisateurParEmail(utilisateurEmail);
    }

    @Override
    public Utilisateur getUtilisateurParId(Long utilisateurId) {
        return utilisateurManager.getUtilisateurParId(utilisateurId);
    }

    @Override
    public void inscrireUtilisateur(InscriptionDto_SuperAdmin inscriptionDto_superAdmin){
        //Est ce que le mail est déjà pris
        String email = inscriptionDto_superAdmin.getEmail();
        if (utilisateurManager.isEmailDejaPris(email)){
            throw new EmailDejaPrisException(email);
        }

        //Génération du mot de passe aléatoire
        String mdpAleatoire = genererMdpAleatoire();
        logger.info("Mot de passe généré: " + mdpAleatoire);  // Log du mot de passe généré

        //Création de l'utilisateur
        Utilisateur nouvelUtilisateur = new Utilisateur(
                inscriptionDto_superAdmin.getNom(),
                inscriptionDto_superAdmin.getPrenom(),
                passwordEncoder.encode(mdpAleatoire),
                email,
                PREMIERE_CONNEXION_TRUE,
                ROLE_USER,
                inscriptionDto_superAdmin.isEstAdmin(),
                inscriptionDto_superAdmin.isEstSuperAdmin(),
                entiteService.getEntiteById(inscriptionDto_superAdmin.getEntiteId()));

        //envoi du mail
        emailService.sendSimpleEmail(inscriptionDto_superAdmin.getPrenom(), email, mdpAleatoire);
        utilisateurManager.save(nouvelUtilisateur);
    }


    @Override
    public void modifierEstAdmin(Long utilisateurId, Boolean estAdmin) {
        Utilisateur utilisateur = utilisateurManager.getUtilisateurParId(utilisateurId);
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
    public void changePassword(ChangePasswordDto changePasswordDto) {
        Utilisateur utilisateur = utilisateurManager.getUtilisateurParEmail(changePasswordDto.getEmail());
        if (!passwordEncoder.matches(changePasswordDto.getAncienMdp(), utilisateur.getMdp())) {
            throw new MauvaisAncienMdpException();
        }
        utilisateur.setMdp(passwordEncoder.encode(changePasswordDto.getNouveauMdp()));
        utilisateur.setEstPremiereConnexion(PREMIERE_CONNEXION_FALSE);
        utilisateurManager.save(utilisateur);

    }

    @Override
    public UtilisateurSecuriteDto findUtilisateurSecuriteDtoByEmail(String utilisateurEmail) {
        return utilisateurManager.findUtilisateurSecurityDTOByEmail(utilisateurEmail);
    }

    @Override
    public void supprimerUtilisateur(Long utilisateurId) {
        utilisateurManager.supprimerUtilisateur(utilisateurId);
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
