package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.autreImmobilisation.AutreImmobilisationOngletDto;
import tcucl.back_tcucl.entity.onglet.AutreImmobilisationOnglet;
import tcucl.back_tcucl.manager.AutreImmobilisationOngletManager;
import tcucl.back_tcucl.repository.onglet.AutreImmobilisationOngletRepository;

@Component
public class AutreImmobilisationOngletManagerImpl implements AutreImmobilisationOngletManager {

    private final AutreImmobilisationOngletRepository autreImmobilisationOngletRepository;

    public AutreImmobilisationOngletManagerImpl(AutreImmobilisationOngletRepository autreImmobilisationOngletRepository) {
        this.autreImmobilisationOngletRepository = autreImmobilisationOngletRepository;
    }

    @Override
    public AutreImmobilisationOnglet getAutreImmobilisationOngletById(Long id) {
        return autreImmobilisationOngletRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AutreImmobilisationOnglet non trouvé avec l'Id: " + id));
    }

    @Override
    public void updateAutreImmobilisationOngletPartiel(Long id, AutreImmobilisationOngletDto dto) {
        AutreImmobilisationOnglet onglet = getAutreImmobilisationOngletById(id);

        // Installation complète
        if (dto.getInstallationComplete_IsEmissionGESConnues() != null)
            onglet.setInstallationComplete_IsEmissionGESConnues(dto.getInstallationComplete_IsEmissionGESConnues());
        if (dto.getInstallationComplete_EmissionDeGes() != null)
            onglet.setInstallationComplete_EmissionDeGes(dto.getInstallationComplete_EmissionDeGes());

        // Panneaux
        if (dto.getPanneaux_PuissanceTotale() != null)
            onglet.setPanneaux_PuissanceTotale(dto.getPanneaux_PuissanceTotale());
        if (dto.getPanneaux_DureeDeVie() != null)
            onglet.setPanneaux_DureeDeVie(dto.getPanneaux_DureeDeVie());
        if (dto.getPanneaux_IsEmissionGESConnues() != null)
            onglet.setPanneaux_IsEmissionGESConnues(dto.getPanneaux_IsEmissionGESConnues());
        if (dto.getPanneaux_EmissionDeGes() != null)
            onglet.setPanneaux_EmissionDeGes(dto.getPanneaux_EmissionDeGes());

        // Onduleur
        if (dto.getOnduleur_PuissanceTotale() != null)
            onglet.setOnduleur_PuissanceTotale(dto.getOnduleur_PuissanceTotale());
        if (dto.getOnduleur_DureeDeVie() != null)
            onglet.setOnduleur_DureeDeVie(dto.getOnduleur_DureeDeVie());
        if (dto.getOnduleur_IsEmissionGESConnues() != null)
            onglet.setOnduleur_IsEmissionGESConnues(dto.getOnduleur_IsEmissionGESConnues());
        if (dto.getOnduleur_EmissionDeGes() != null)
            onglet.setOnduleur_EmissionDeGes(dto.getOnduleur_EmissionDeGes());

        // Groupes électrogènes
        if (dto.getGroupesElectrogenes_Nombre() != null)
            onglet.setGroupesElectrogenes_Nombre(dto.getGroupesElectrogenes_Nombre());
        if (dto.getGroupesElectrogenes_PoidsDuProduit() != null)
            onglet.setGroupesElectrogenes_PoidsDuProduit(dto.getGroupesElectrogenes_PoidsDuProduit());
        if (dto.getGroupesElectrogenes_DureeAmortissement() != null)
            onglet.setGroupesElectrogenes_DureeAmortissement(dto.getGroupesElectrogenes_DureeAmortissement());
        if (dto.getGroupesElectrogenes_IsEmissionConnue() != null)
            onglet.setGroupesElectrogenes_IsEmissionConnue(dto.getGroupesElectrogenes_IsEmissionConnue());
        if (dto.getGroupesElectrogenes_EmissionReelle() != null)
            onglet.setGroupesElectrogenes_EmissionReelle(dto.getGroupesElectrogenes_EmissionReelle());

        // Moteur électrique
        if (dto.getMoteurElectrique_Nombre() != null)
            onglet.setMoteurElectrique_Nombre(dto.getMoteurElectrique_Nombre());
        if (dto.getMoteurElectrique_PoidsDuProduit() != null)
            onglet.setMoteurElectrique_PoidsDuProduit(dto.getMoteurElectrique_PoidsDuProduit());
        if (dto.getMoteurElectrique_DureeAmortissement() != null)
            onglet.setMoteurElectrique_DureeAmortissement(dto.getMoteurElectrique_DureeAmortissement());
        if (dto.getMoteurElectrique_IsEmissionConnue() != null)
            onglet.setMoteurElectrique_IsEmissionConnue(dto.getMoteurElectrique_IsEmissionConnue());
        if (dto.getMoteurElectrique_EmissionReelle() != null)
            onglet.setMoteurElectrique_EmissionReelle(dto.getMoteurElectrique_EmissionReelle());

        // Autres machines (Kg)
        if (dto.getAutresMachinesKg_Nombre() != null)
            onglet.setAutresMachinesKg_Nombre(dto.getAutresMachinesKg_Nombre());
        if (dto.getAutresMachinesKg_PoidsDuProduit() != null)
            onglet.setAutresMachinesKg_PoidsDuProduit(dto.getAutresMachinesKg_PoidsDuProduit());
        if (dto.getAutresMachinesKg_DureeAmortissement() != null)
            onglet.setAutresMachinesKg_DureeAmortissement(dto.getAutresMachinesKg_DureeAmortissement());
        if (dto.getAutresMachinesKg_IsEmissionConnue() != null)
            onglet.setAutresMachinesKg_IsEmissionConnue(dto.getAutresMachinesKg_IsEmissionConnue());
        if (dto.getAutresMachinesKg_EmissionReelle() != null)
            onglet.setAutresMachinesKg_EmissionReelle(dto.getAutresMachinesKg_EmissionReelle());

        // Autres machines (Eur)
        if (dto.getAutresMachinesEur_Nombre() != null)
            onglet.setAutresMachinesEur_Nombre(dto.getAutresMachinesEur_Nombre());
        if (dto.getAutresMachinesEur_PoidsDuProduit() != null)
            onglet.setAutresMachinesEur_PoidsDuProduit(dto.getAutresMachinesEur_PoidsDuProduit());
        if (dto.getAutresMachinesEur_DureeAmortissement() != null)
            onglet.setAutresMachinesEur_DureeAmortissement(dto.getAutresMachinesEur_DureeAmortissement());
        if (dto.getAutresMachinesEur_IsEmissionConnue() != null)
            onglet.setAutresMachinesEur_IsEmissionConnue(dto.getAutresMachinesEur_IsEmissionConnue());
        if (dto.getAutresMachinesEur_EmissionReelle() != null)
            onglet.setAutresMachinesEur_EmissionReelle(dto.getAutresMachinesEur_EmissionReelle());

        autreImmobilisationOngletRepository.save(onglet);
    }

}
