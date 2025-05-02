package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.MobiliteDomicileTravailOngletDto;
import tcucl.back_tcucl.entity.onglet.MobiliteDomicileTravailOnglet;
import tcucl.back_tcucl.repository.onglet.MobiliteDomicileTravailOngletRepository;
import tcucl.back_tcucl.manager.MobiliteDomicileTravailOngletManager;

@Component
public class MobiliteDomicileTravailOngletManagerImpl implements MobiliteDomicileTravailOngletManager {

    private final MobiliteDomicileTravailOngletRepository repository;

    public MobiliteDomicileTravailOngletManagerImpl(MobiliteDomicileTravailOngletRepository repository) {
        this.repository = repository;
    }

    @Override
    public MobiliteDomicileTravailOnglet getMobiliteDomicileTravailOngletById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MobiliteDomicileTravailOnglet non trouvé avec l'ID : " + id));
    }


    @Override
    public void updateMobiliteDomicileTravailOngletPartiel(Long id, MobiliteDomicileTravailOngletDto dto) {
        MobiliteDomicileTravailOnglet onglet = getMobiliteDomicileTravailOngletById(id);

        if (dto.getVoitureThermiqueEtudiantKm() != null) onglet.setVoitureThermiqueEtudiantKm(dto.getVoitureThermiqueEtudiantKm());
        if (dto.getVoitureElectriqueEtudiantKm() != null) onglet.setVoitureElectriqueEtudiantKm(dto.getVoitureElectriqueEtudiantKm());
        if (dto.getVoitureHybrideEtudiantKm() != null) onglet.setVoitureHybrideEtudiantKm(dto.getVoitureHybrideEtudiantKm());
        if (dto.getMotoEtudiantKm() != null) onglet.setMotoEtudiantKm(dto.getMotoEtudiantKm());
        if (dto.getTrainRegionalEtudiantKm() != null) onglet.setTrainRegionalEtudiantKm(dto.getTrainRegionalEtudiantKm());
        if (dto.getBusEtudiantKm() != null) onglet.setBusEtudiantKm(dto.getBusEtudiantKm());
        if (dto.getMetroTramwayEtudiantKm() != null) onglet.setMetroTramwayEtudiantKm(dto.getMetroTramwayEtudiantKm());
        if (dto.getVeloEtudiantKm() != null) onglet.setVeloEtudiantKm(dto.getVeloEtudiantKm());
        if (dto.getTrotinetteElectriqueEtudiantKm() != null) onglet.setTrotinetteElectriqueEtudiantKm(dto.getTrotinetteElectriqueEtudiantKm());
        if (dto.getVeloElectriqueEtudiantKm() != null) onglet.setVeloElectriqueEtudiantKm(dto.getVeloElectriqueEtudiantKm());
        if (dto.getMarcheAPiedEtudiantKm() != null) onglet.setMarcheAPiedEtudiantKm(dto.getMarcheAPiedEtudiantKm());
        if (dto.getNbJoursDeplacementEtudiant() != null) onglet.setNbJoursDeplacementEtudiant(dto.getNbJoursDeplacementEtudiant());

        if (dto.getVoitureThermiqueSalarieKm() != null) onglet.setVoitureThermiqueSalarieKm(dto.getVoitureThermiqueSalarieKm());
        if (dto.getVoitureElectriqueSalarieKm() != null) onglet.setVoitureElectriqueSalarieKm(dto.getVoitureElectriqueSalarieKm());
        if (dto.getVoitureHybrideSalarieKm() != null) onglet.setVoitureHybrideSalarieKm(dto.getVoitureHybrideSalarieKm());
        if (dto.getMotoSalarieKm() != null) onglet.setMotoSalarieKm(dto.getMotoSalarieKm());
        if (dto.getTrainRegionalSalarieKm() != null) onglet.setTrainRegionalSalarieKm(dto.getTrainRegionalSalarieKm());
        if (dto.getBusSalarieKm() != null) onglet.setBusSalarieKm(dto.getBusSalarieKm());
        if (dto.getMetroTramwaySalarieKm() != null) onglet.setMetroTramwaySalarieKm(dto.getMetroTramwaySalarieKm());
        if (dto.getVeloSalarieKm() != null) onglet.setVeloSalarieKm(dto.getVeloSalarieKm());
        if (dto.getTrotinetteElectriqueSalarieKm() != null) onglet.setTrotinetteElectriqueSalarieKm(dto.getTrotinetteElectriqueSalarieKm());
        if (dto.getVeloElectriqueSalarieKm() != null) onglet.setVeloElectriqueSalarieKm(dto.getVeloElectriqueSalarieKm());
        if (dto.getMarcheAPiedSalarieKm() != null) onglet.setMarcheAPiedSalarieKm(dto.getMarcheAPiedSalarieKm());
        if (dto.getNbJoursDeplacementSalarie() != null) onglet.setNbJoursDeplacementSalarie(dto.getNbJoursDeplacementSalarie());

        repository.save(onglet);
    }
}
