package tcucl.back_tcucl.manager.impl.onglet;

import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.autreImmobilisation.AutreImmobilisationOngletDto;
import tcucl.back_tcucl.entity.onglet.AutreImmobilisationOnglet;
import tcucl.back_tcucl.exceptionPersonnalisee.OngletNonTrouveIdException;
import tcucl.back_tcucl.manager.AutreImmobilisationOngletManager;
import tcucl.back_tcucl.repository.onglet.AutreImmobilisationOngletRepository;

@Component
public class AutreImmobilisationOngletManagerImpl implements AutreImmobilisationOngletManager {

    private final AutreImmobilisationOngletRepository autreImmobilisationOngletRepository;

    public AutreImmobilisationOngletManagerImpl(AutreImmobilisationOngletRepository autreImmobilisationOngletRepository) {
        this.autreImmobilisationOngletRepository = autreImmobilisationOngletRepository;
    }

    @Override
    public AutreImmobilisationOnglet getAutreImmobilisationOngletById(Long ongletId) {
        return autreImmobilisationOngletRepository.findById(ongletId).orElseThrow(() -> new OngletNonTrouveIdException("AutreImmobilisationOnglet",ongletId));
    }

    @Override
    public void updateAutreImmobilisationOngletPartiel(Long ongletId, AutreImmobilisationOngletDto autreImmobilisationOngletDto) {
        AutreImmobilisationOnglet autreImmobilisationOngletById = getAutreImmobilisationOngletById(ongletId);

        if (autreImmobilisationOngletDto.getNote() != null) {
            autreImmobilisationOngletById.setNote(autreImmobilisationOngletDto.getNote());
        }
        if (autreImmobilisationOngletDto.getEstTermine() != null) {
            autreImmobilisationOngletById.setEstTermine(autreImmobilisationOngletDto.getEstTermine());
        }

        // Installation complète
        if (autreImmobilisationOngletDto.getInstallationComplete_IsEmissionGESConnues() != null)
            autreImmobilisationOngletById.setInstallationComplete_IsEmissionGESConnues(autreImmobilisationOngletDto.getInstallationComplete_IsEmissionGESConnues());
        if (autreImmobilisationOngletDto.getInstallationComplete_EmissionDeGes() != null)
            autreImmobilisationOngletById.setInstallationComplete_EmissionDeGes(autreImmobilisationOngletDto.getInstallationComplete_EmissionDeGes());

        // Panneaux
        if (autreImmobilisationOngletDto.getPanneaux_PuissanceTotale() != null)
            autreImmobilisationOngletById.setPanneaux_PuissanceTotale(autreImmobilisationOngletDto.getPanneaux_PuissanceTotale());
        if (autreImmobilisationOngletDto.getPanneaux_DureeDeVie() != null)
            autreImmobilisationOngletById.setPanneaux_DureeDeVie(autreImmobilisationOngletDto.getPanneaux_DureeDeVie());
        if (autreImmobilisationOngletDto.getPanneaux_IsEmissionGESConnues() != null)
            autreImmobilisationOngletById.setPanneaux_IsEmissionGESConnues(autreImmobilisationOngletDto.getPanneaux_IsEmissionGESConnues());
        if (autreImmobilisationOngletDto.getPanneaux_EmissionDeGes() != null)
            autreImmobilisationOngletById.setPanneaux_EmissionDeGes(autreImmobilisationOngletDto.getPanneaux_EmissionDeGes());

        // Onduleur
        if (autreImmobilisationOngletDto.getOnduleur_PuissanceTotale() != null)
            autreImmobilisationOngletById.setOnduleur_PuissanceTotale(autreImmobilisationOngletDto.getOnduleur_PuissanceTotale());
        if (autreImmobilisationOngletDto.getOnduleur_DureeDeVie() != null)
            autreImmobilisationOngletById.setOnduleur_DureeDeVie(autreImmobilisationOngletDto.getOnduleur_DureeDeVie());
        if (autreImmobilisationOngletDto.getOnduleur_IsEmissionGESConnues() != null)
            autreImmobilisationOngletById.setOnduleur_IsEmissionGESConnues(autreImmobilisationOngletDto.getOnduleur_IsEmissionGESConnues());
        if (autreImmobilisationOngletDto.getOnduleur_EmissionDeGes() != null)
            autreImmobilisationOngletById.setOnduleur_EmissionDeGes(autreImmobilisationOngletDto.getOnduleur_EmissionDeGes());

        // Groupes électrogènes
        if (autreImmobilisationOngletDto.getGroupesElectrogenes_Nombre() != null)
            autreImmobilisationOngletById.setGroupesElectrogenes_Nombre(autreImmobilisationOngletDto.getGroupesElectrogenes_Nombre());
        if (autreImmobilisationOngletDto.getGroupesElectrogenes_PoidsDuProduit() != null)
            autreImmobilisationOngletById.setGroupesElectrogenes_PoidsDuProduit(autreImmobilisationOngletDto.getGroupesElectrogenes_PoidsDuProduit());
        if (autreImmobilisationOngletDto.getGroupesElectrogenes_DureeAmortissement() != null)
            autreImmobilisationOngletById.setGroupesElectrogenes_DureeAmortissement(autreImmobilisationOngletDto.getGroupesElectrogenes_DureeAmortissement());
        if (autreImmobilisationOngletDto.getGroupesElectrogenes_IsEmissionConnue() != null)
            autreImmobilisationOngletById.setGroupesElectrogenes_IsEmissionConnue(autreImmobilisationOngletDto.getGroupesElectrogenes_IsEmissionConnue());
        if (autreImmobilisationOngletDto.getGroupesElectrogenes_EmissionReelle() != null)
            autreImmobilisationOngletById.setGroupesElectrogenes_EmissionReelle(autreImmobilisationOngletDto.getGroupesElectrogenes_EmissionReelle());

        // Moteur électrique
        if (autreImmobilisationOngletDto.getMoteurElectrique_Nombre() != null)
            autreImmobilisationOngletById.setMoteurElectrique_Nombre(autreImmobilisationOngletDto.getMoteurElectrique_Nombre());
        if (autreImmobilisationOngletDto.getMoteurElectrique_PoidsDuProduit() != null)
            autreImmobilisationOngletById.setMoteurElectrique_PoidsDuProduit(autreImmobilisationOngletDto.getMoteurElectrique_PoidsDuProduit());
        if (autreImmobilisationOngletDto.getMoteurElectrique_DureeAmortissement() != null)
            autreImmobilisationOngletById.setMoteurElectrique_DureeAmortissement(autreImmobilisationOngletDto.getMoteurElectrique_DureeAmortissement());
        if (autreImmobilisationOngletDto.getMoteurElectrique_IsEmissionConnue() != null)
            autreImmobilisationOngletById.setMoteurElectrique_IsEmissionConnue(autreImmobilisationOngletDto.getMoteurElectrique_IsEmissionConnue());
        if (autreImmobilisationOngletDto.getMoteurElectrique_EmissionReelle() != null)
            autreImmobilisationOngletById.setMoteurElectrique_EmissionReelle(autreImmobilisationOngletDto.getMoteurElectrique_EmissionReelle());

        // Autres machines (Kg)
        if (autreImmobilisationOngletDto.getAutresMachinesKg_Nombre() != null)
            autreImmobilisationOngletById.setAutresMachinesKg_Nombre(autreImmobilisationOngletDto.getAutresMachinesKg_Nombre());
        if (autreImmobilisationOngletDto.getAutresMachinesKg_PoidsDuProduit() != null)
            autreImmobilisationOngletById.setAutresMachinesKg_PoidsDuProduit(autreImmobilisationOngletDto.getAutresMachinesKg_PoidsDuProduit());
        if (autreImmobilisationOngletDto.getAutresMachinesKg_DureeAmortissement() != null)
            autreImmobilisationOngletById.setAutresMachinesKg_DureeAmortissement(autreImmobilisationOngletDto.getAutresMachinesKg_DureeAmortissement());
        if (autreImmobilisationOngletDto.getAutresMachinesKg_IsEmissionConnue() != null)
            autreImmobilisationOngletById.setAutresMachinesKg_IsEmissionConnue(autreImmobilisationOngletDto.getAutresMachinesKg_IsEmissionConnue());
        if (autreImmobilisationOngletDto.getAutresMachinesKg_EmissionReelle() != null)
            autreImmobilisationOngletById.setAutresMachinesKg_EmissionReelle(autreImmobilisationOngletDto.getAutresMachinesKg_EmissionReelle());

        // Autres machines (Eur)
        if (autreImmobilisationOngletDto.getAutresMachinesEur_Nombre() != null)
            autreImmobilisationOngletById.setAutresMachinesEur_Nombre(autreImmobilisationOngletDto.getAutresMachinesEur_Nombre());
        if (autreImmobilisationOngletDto.getAutresMachinesEur_PoidsDuProduit() != null)
            autreImmobilisationOngletById.setAutresMachinesEur_PoidsDuProduit(autreImmobilisationOngletDto.getAutresMachinesEur_PoidsDuProduit());
        if (autreImmobilisationOngletDto.getAutresMachinesEur_DureeAmortissement() != null)
            autreImmobilisationOngletById.setAutresMachinesEur_DureeAmortissement(autreImmobilisationOngletDto.getAutresMachinesEur_DureeAmortissement());
        if (autreImmobilisationOngletDto.getAutresMachinesEur_IsEmissionConnue() != null)
            autreImmobilisationOngletById.setAutresMachinesEur_IsEmissionConnue(autreImmobilisationOngletDto.getAutresMachinesEur_IsEmissionConnue());
        if (autreImmobilisationOngletDto.getAutresMachinesEur_EmissionReelle() != null)
            autreImmobilisationOngletById.setAutresMachinesEur_EmissionReelle(autreImmobilisationOngletDto.getAutresMachinesEur_EmissionReelle());

        autreImmobilisationOngletRepository.save(autreImmobilisationOngletById);
    }

}
