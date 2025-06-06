package tcucl.back_tcucl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tcucl.back_tcucl.config.AnneeConfig;
import tcucl.back_tcucl.dto.*;
import tcucl.back_tcucl.entity.Annee;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.entity.Utilisateur;
import tcucl.back_tcucl.exceptionPersonnalisee.AnneeUniversitaireDejaCreeException;
import tcucl.back_tcucl.service.*;

import java.util.List;

import static tcucl.back_tcucl.Constante.*;

@Service
public class ParametreServiceImpl implements ParametreService {

    private static final Logger log = LoggerFactory.getLogger(ParametreServiceImpl.class);
    private final EntiteService entiteService;
    private final UtilisateurService utilisateurService;
    private final ApplicationParamService applicationParamService;

    public ParametreServiceImpl(EntiteService entiteService, UtilisateurService utilisateurService, AuthentificationService authentificationService, ApplicationParamService applicationParamService) {
        this.entiteService = entiteService;
        this.utilisateurService = utilisateurService;
        this.applicationParamService = applicationParamService;
    }

    @Override
    public void inscrireUtilisateur(InscriptionDto_SuperAdmin inscriptionDtoSuperAdmin) {
        utilisateurService.inscrireUtilisateur(inscriptionDtoSuperAdmin);
    }

    @Override
    public void modifierEstAdmin(Long utilisateurId, Boolean estAdmin) {
        utilisateurService.modifierEstAdmin(utilisateurId, estAdmin);
    }

    @Override
    public void supprimerUtilisateur(Long utilisateurId) {
        utilisateurService.supprimerUtilisateur(utilisateurId);
    }

    @Override
    public void modifierUtilisateurParAdmin(Long utilisateurId, ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto) {
        utilisateurService.modifierUtilisateurParAdmin(utilisateurId, modificationUtilisateurParAdminDto);
    }

    @Override
    public void changePassword(ChangePasswordDto changePasswordDto) {
        utilisateurService.changePassword(changePasswordDto);
    }


    //Le transactionnal permet le rollback de l'opération si une exception est levée
    //ex: si l'inscription de l'utilisateur échoue, l'entité ne sera pas créée
    @Transactional
    @Override
    public void creerEntiteEtAdmin(CreationEntiteEtAdminDto_SuperAdmin creationEntiteEtAdminDto_superAdmin) {

        //Creation puis récupération de l'entite
        Entite entite = entiteService.creerEntite(creationEntiteEtAdminDto_superAdmin.getNom(), creationEntiteEtAdminDto_superAdmin.getType(), creationEntiteEtAdminDto_superAdmin.getEstSuperAdmin());

        //Inscription de l'utilisateur
        utilisateurService.inscrireUtilisateur(new InscriptionDto_SuperAdmin(
                creationEntiteEtAdminDto_superAdmin.getNomUtilisateur(),
                creationEntiteEtAdminDto_superAdmin.getPrenomUtilisateur(),
                creationEntiteEtAdminDto_superAdmin.getEmailUtilisateur(),
                creationEntiteEtAdminDto_superAdmin.getEstSuperAdmin() ? ADMIN_FALSE : ADMIN_TRUE,
                creationEntiteEtAdminDto_superAdmin.getEstSuperAdmin() ? SUPERADMIN_TRUE : SUPERADMIN_FALSE,
                entite.getId()
        ));
    }

    @Override
    public List<Utilisateur> getAllUtilisateurParEntiteId(Long entiteId) {
        return utilisateurService.getAllUtilisateurParEntiteId(entiteId);
    }

    @Override
    public void modifierUtilisateurParUtilisateur(Long utilisateurId, ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto) {
        utilisateurService.modifierUtilisateurParUtilisateur(utilisateurId, modificationUtilisateurParUtilisateurDto);
    }

    @Scheduled(cron = "0 1 0 1 9 *")
    @Transactional
    @Override
    public void creerAnneeSuivante() {

        int anneeUniversitaire = AnneeConfig.getAnneeCourante();

        //On vérifie si l'année universitaire courante est déjà créée
        if (applicationParamService.getDerniereAnneeCreee() == anneeUniversitaire) {
            throw new AnneeUniversitaireDejaCreeException(anneeUniversitaire);
        }

        List<Entite> entites = entiteService.getAllEntites().stream().filter(entite -> entite.getId() != 1).toList();
        for (Entite entite : entites) {

            Annee annee = new Annee(anneeUniversitaire);
            entite.addAnnee(annee); // gère la liaison bidirectionnelle

            entiteService.saveEntite(entite);
        }
        applicationParamService.setDerniereAnneeCreee(anneeUniversitaire);
        log.info("Année universitaire {} créée pour toutes les entités.", anneeUniversitaire);
    }

    @Override
    public Boolean peutCreerUneNouvelleAnnee() {
        return applicationParamService.getDerniereAnneeCreee() != AnneeConfig.getAnneeCourante();
    }

    @Override
    public List<EntiteNomIdDto> getAllEntiteNomId() {
        return entiteService.getAllEntites().stream().map(EntiteNomIdDto::new)
                .toList();
    }
}
