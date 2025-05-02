package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.numerique.EquipementNumeriqueDto;
import tcucl.back_tcucl.dto.onglet.numerique.NumeriqueOngletDto;
import tcucl.back_tcucl.entity.onglet.NumeriqueOnglet;
import tcucl.back_tcucl.entity.parametre.numerique.EquipementNumerique;
import tcucl.back_tcucl.manager.NumeriqueOngletManager;
import tcucl.back_tcucl.repository.onglet.NumeriqueOngletRepository;

@Component
public class NumeriqueOngletManagerImpl implements NumeriqueOngletManager {

    public final NumeriqueOngletRepository numeriqueOngletRepository;

    public NumeriqueOngletManagerImpl(NumeriqueOngletRepository numeriqueOngletRepository) {
        this.numeriqueOngletRepository = numeriqueOngletRepository;
    }

    @Override
    public NumeriqueOnglet getNumeriqueOngletById(Long id) {
        return numeriqueOngletRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("NumeriqueOnglet non trouvé avec l'Id : " + id));
    }

    @Override
    public EquipementNumerique getEquipementNumeriqueById(Long ongletId, Long equipementId) {
        NumeriqueOnglet onglet = getNumeriqueOngletById(ongletId);
        return onglet.getEquipementNumeriqueList().stream()
                .filter(m -> m.getId().equals(equipementId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Equipement Numérique non trouvé avec l'Id: " + equipementId));
    }

    @Override
    public void updateNumeriqueOngletPartiel(Long id, NumeriqueOngletDto dto) {
        NumeriqueOnglet numeriqueOnglet = getNumeriqueOngletById(id);

        if (dto.getEstTermine() != null) numeriqueOnglet.setEstTermine(dto.getEstTermine());
        if (dto.getNote() != null) numeriqueOnglet.setNote(dto.getNote());

        if (dto.getUseMethodSimplifiee() != null) numeriqueOnglet.setUseMethodSimplifiee(dto.getUseMethodSimplifiee());
        if (dto.getTraficCloudUtilisateur() != null) numeriqueOnglet.setTraficCloudUtilisateur(dto.getTraficCloudUtilisateur());
        if (dto.getTraficTipUtilisateur() != null) numeriqueOnglet.setTraficTipUtilisateur(dto.getTraficTipUtilisateur());
        if (dto.getPartTraficFranceEtranger() != null) numeriqueOnglet.setPartTraficFranceEtranger(dto.getPartTraficFranceEtranger());


        if (dto.getEquipementNumeriqueList() != null) {
            // On supprime les equipementNumeriques existants et on les remplace par les nouveaux
            numeriqueOnglet.getEquipementNumeriqueList().clear();
            for (EquipementNumeriqueDto equipementNumeriqueDto : dto.getEquipementNumeriqueList()) {
                numeriqueOnglet.ajouterEquipementNumeriqueViaDto(equipementNumeriqueDto);
            }
        }
        numeriqueOngletRepository.save(numeriqueOnglet);
    }

    @Override
    public void ajouterEquipementNumerique(Long id, EquipementNumeriqueDto equipementNumeriqueDto) {
        NumeriqueOnglet numeriqueOnglet = getNumeriqueOngletById(id);
        if (equipementNumeriqueDto != null) {
            numeriqueOnglet.ajouterEquipementNumeriqueViaDto(equipementNumeriqueDto);
            numeriqueOngletRepository.save(numeriqueOnglet);
        } else {
            throw new EntityNotFoundException("NumeriqueOnglet non trouvé avec l'Id: " + id);
        }
    }

    @Override
    public void supprimerEquipementNumerique(Long ongletId, Long equipementId) {
        NumeriqueOnglet ongletById = getNumeriqueOngletById(ongletId);

        EquipementNumerique equipementNumerique = ongletById.getEquipementNumeriqueList()
                .stream()
                .filter(v -> v.getId().equals(equipementId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Equipement Numérique non trouvé avec l'id : " + equipementId));

        ongletById.getEquipementNumeriqueList().remove(equipementNumerique);

        numeriqueOngletRepository.save(ongletById);
    }

    @Override
    public void updateEquipementNumeriquePartiel(Long ongletId, Long equipementId, EquipementNumeriqueDto equipementNumeriqueDto) {
        NumeriqueOnglet onglet = getNumeriqueOngletById(ongletId);

        EquipementNumerique equipementNumerique = onglet.getEquipementNumeriqueList()
                .stream()
                .filter(v -> v.getId().equals(equipementId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Equipement Numérique non trouvé avec l'id : " + equipementId));

        if (equipementNumeriqueDto.getEquipement() != null) equipementNumerique.setEquipement(equipementNumeriqueDto.getEquipement());
        if (equipementNumeriqueDto.getNombre() != null) equipementNumerique.setNombre(equipementNumeriqueDto.getNombre());
        if (equipementNumeriqueDto.getDureeAmortissement() != null) equipementNumerique.setDureeAmortissement(equipementNumeriqueDto.getDureeAmortissement());
        if (equipementNumeriqueDto.getEmissionsGesPrecisesConnues() != null) equipementNumerique.setEmissionsGesPrecisesConnues(equipementNumeriqueDto.getEmissionsGesPrecisesConnues());
        if (equipementNumeriqueDto.getEmissionsReellesParProduitKgCO2e() != null) equipementNumerique.setEmissionsReellesParProduitKgCO2e(equipementNumeriqueDto.getEmissionsReellesParProduitKgCO2e());

        onglet.getEquipementNumeriqueList().add(equipementNumerique);

        numeriqueOngletRepository.save(onglet);
    }
}
