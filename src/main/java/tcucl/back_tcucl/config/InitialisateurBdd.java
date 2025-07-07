package tcucl.back_tcucl.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.CreationEntiteEtAdminDto_SuperAdmin;
import tcucl.back_tcucl.service.ApplicationParamService;
import tcucl.back_tcucl.service.EntiteService;
import tcucl.back_tcucl.service.ParametreService;

import static tcucl.back_tcucl.Constante.SUPERADMIN_TRUE;

@Component
public class InitialisateurBdd implements CommandLineRunner {

    private final ApplicationParamService applicationParamService;
    private final ParametreService parametreService;
    private final EntiteService entiteService;

    public InitialisateurBdd(ApplicationParamService applicationParamService, ParametreService parametreService, EntiteService entiteService) {
        this.applicationParamService = applicationParamService;
        this.parametreService = parametreService;

        this.entiteService = entiteService;
    }

    @Override
    public void run(String... args) {
        if (!applicationParamService.isDerniereAnneeCreee()) {
            int annee = AnneeConfig.getAnneeCourante();
            applicationParamService.setDerniereAnneeCreee(annee);
            System.out.println("Année " + annee + " enregistrée au démarrage.");
        } else {
            System.out.println("Aucune action nécessaire, année déjà créée : " + applicationParamService.getDerniereAnneeCreee());
        }

        // Création de l'entité SUPERADMIN + userTechniqueSuperAdmin SuperAdmin
        try {
            if(entiteService.getAllEntites().isEmpty()){
                parametreService.creerEntiteEtAdmin(
                        new CreationEntiteEtAdminDto_SuperAdmin(
                                "Entité SUPERADMIN",            // NomEntité
                                "SUPERADMIN",                        // Type
                                "",                                  // NomUtilisateur
                                "User Technique Super Admin",        // PrenomUtilisateur
                                "trajectoirecarbone.ucl@gmail.com",  // Mail
                                SUPERADMIN_TRUE                      // EstSuperAdmin
                        )
                );
                System.out.println("Entité SUPERADMIN créée avec succès.");
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la création de l'entité SUPERADMIN : " + e.getMessage());
        }


    }
}
