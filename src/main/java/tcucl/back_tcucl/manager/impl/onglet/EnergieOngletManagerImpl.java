package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.energie.EnergieOngletDto;
import tcucl.back_tcucl.entity.onglet.energie.EnergieOnglet;
import tcucl.back_tcucl.repository.onglet.EnergieOngletRepository;
import tcucl.back_tcucl.manager.EnergieOngletManager;

@Component
public class EnergieOngletManagerImpl implements EnergieOngletManager {

    private final EnergieOngletRepository energieOngletRepository;

    public EnergieOngletManagerImpl(EnergieOngletRepository energieOngletRepository) {
        this.energieOngletRepository = energieOngletRepository;
    }

    @Override
    public EnergieOnglet getEnergieOngletById(Long id) {
        return energieOngletRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("EnergieOnglet non trouvé avec l'Id: " + id));
    }

    @Override
    public void updateEnergieOngletPartiel(Long id, EnergieOngletDto dto) {
        EnergieOnglet onglet = getEnergieOngletById(id);

        if (dto.getEstTermine()){
            onglet.setEstTermine(dto.getEstTermine());
        }
        if (dto.getNote() != null) {
            onglet.setNote(dto.getNote());
        }

        if (dto.getConsoGaz() != null) {
            onglet.setConsoGaz(dto.getConsoGaz());
        }
        if (dto.getConsoFioul() != null) {
            onglet.setConsoFioul(dto.getConsoFioul());
        }
        if (dto.getConsoBois() != null) {
            onglet.setConsoBois(dto.getConsoBois());
        }
        if (dto.getConsoReseauVille() != null) {
            onglet.setConsoReseauVille(dto.getConsoReseauVille());
        }
        if (dto.getConsoElecChauffage() != null) {
            onglet.setConsoElecChauffage(dto.getConsoElecChauffage());
        }
        if (dto.getConsoElecSpecifique() != null) {
            onglet.setConsoElecSpecifique(dto.getConsoElecSpecifique());
        }
        if (dto.getConsoEau() != null) {
            onglet.setConsoEau(dto.getConsoEau());
        }
        if (dto.getNote() != null) {
            onglet.setNote(dto.getNote());
        }
        if (dto.getNomReseauVille() != null) {
            onglet.setNomReseauVille(dto.getNomReseauVille());
        }
        if (dto.getUniteBois() != null) {
            onglet.setUniteBois(dto.getUniteBois());
        }
        if (dto.getUniteFioul() != null) {
            onglet.setUniteFioul(dto.getUniteFioul());
        }
        if (dto.getUniteGaz() != null) {
            onglet.setUniteGaz(dto.getUniteGaz());
        }
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

}
