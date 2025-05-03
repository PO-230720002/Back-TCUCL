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
    public EnergieOnglet getEnergieOngletById(Long ongletId) {
        return energieOngletRepository.findById(ongletId).orElseThrow(() -> new EntityNotFoundException("EnergieOnglet non trouvé avec l'Id: " + ongletId));
    }

    @Override
    public void updateEnergieOngletPartiel(Long ongletId, EnergieOngletDto energieOngletDto) {
        EnergieOnglet onglet = getEnergieOngletById(ongletId);

        if (energieOngletDto.getEstTermine()){
            onglet.setEstTermine(energieOngletDto.getEstTermine());
        }
        if (energieOngletDto.getNote() != null) {
            onglet.setNote(energieOngletDto.getNote());
        }

        if (energieOngletDto.getConsoGaz() != null) {
            onglet.setConsoGaz(energieOngletDto.getConsoGaz());
        }
        if (energieOngletDto.getConsoFioul() != null) {
            onglet.setConsoFioul(energieOngletDto.getConsoFioul());
        }
        if (energieOngletDto.getConsoBois() != null) {
            onglet.setConsoBois(energieOngletDto.getConsoBois());
        }
        if (energieOngletDto.getConsoReseauVille() != null) {
            onglet.setConsoReseauVille(energieOngletDto.getConsoReseauVille());
        }
        if (energieOngletDto.getConsoElecChauffage() != null) {
            onglet.setConsoElecChauffage(energieOngletDto.getConsoElecChauffage());
        }
        if (energieOngletDto.getConsoElecSpecifique() != null) {
            onglet.setConsoElecSpecifique(energieOngletDto.getConsoElecSpecifique());
        }
        if (energieOngletDto.getConsoEau() != null) {
            onglet.setConsoEau(energieOngletDto.getConsoEau());
        }
        if (energieOngletDto.getNote() != null) {
            onglet.setNote(energieOngletDto.getNote());
        }
        if (energieOngletDto.getNomReseauVille() != null) {
            onglet.setNomReseauVille(energieOngletDto.getNomReseauVille());
        }
        if (energieOngletDto.getUniteBois() != null) {
            onglet.setUniteBois(energieOngletDto.getUniteBois());
        }
        if (energieOngletDto.getUniteFioul() != null) {
            onglet.setUniteFioul(energieOngletDto.getUniteFioul());
        }
        if (energieOngletDto.getUniteGaz() != null) {
            onglet.setUniteGaz(energieOngletDto.getUniteGaz());
        }
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

}
