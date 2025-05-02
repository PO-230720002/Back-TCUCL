package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.mobiliteDomicileTravail.MobiliteDomicileTravailOngletDto;
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
                .orElseThrow(() -> new EntityNotFoundException("MobiliteDomicileTravailOnglet non trouvé avec l'Id: " + id));
    }


    @Override
    public void updateMobiliteDomicileTravailOngletPartiel(Long id, MobiliteDomicileTravailOngletDto dto) {
        MobiliteDomicileTravailOnglet mobiliteDomicileTravailOnglet = getMobiliteDomicileTravailOngletById(id);

        if (dto.getEstTermine() != null) mobiliteDomicileTravailOnglet.setEstTermine(dto.getEstTermine());
        if (dto.getNote() != null) mobiliteDomicileTravailOnglet.setNote(dto.getNote());

        if (dto.getVoitureThermiqueEtudiantKm() != null) mobiliteDomicileTravailOnglet.setVoitureThermiqueEtudiantKm(dto.getVoitureThermiqueEtudiantKm());
        if (dto.getVoitureElectriqueEtudiantKm() != null) mobiliteDomicileTravailOnglet.setVoitureElectriqueEtudiantKm(dto.getVoitureElectriqueEtudiantKm());
        if (dto.getVoitureHybrideEtudiantKm() != null) mobiliteDomicileTravailOnglet.setVoitureHybrideEtudiantKm(dto.getVoitureHybrideEtudiantKm());
        if (dto.getMotoEtudiantKm() != null) mobiliteDomicileTravailOnglet.setMotoEtudiantKm(dto.getMotoEtudiantKm());
        if (dto.getTrainRegionalEtudiantKm() != null) mobiliteDomicileTravailOnglet.setTrainRegionalEtudiantKm(dto.getTrainRegionalEtudiantKm());
        if (dto.getBusEtudiantKm() != null) mobiliteDomicileTravailOnglet.setBusEtudiantKm(dto.getBusEtudiantKm());
        if (dto.getMetroTramwayEtudiantKm() != null) mobiliteDomicileTravailOnglet.setMetroTramwayEtudiantKm(dto.getMetroTramwayEtudiantKm());
        if (dto.getVeloEtudiantKm() != null) mobiliteDomicileTravailOnglet.setVeloEtudiantKm(dto.getVeloEtudiantKm());
        if (dto.getTrottinetteElectriqueEtudiantKm() != null) mobiliteDomicileTravailOnglet.setTrottinetteElectriqueEtudiantKm(dto.getTrottinetteElectriqueEtudiantKm());
        if (dto.getVeloElectriqueEtudiantKm() != null) mobiliteDomicileTravailOnglet.setVeloElectriqueEtudiantKm(dto.getVeloElectriqueEtudiantKm());
        if (dto.getMarcheAPiedEtudiantKm() != null) mobiliteDomicileTravailOnglet.setMarcheAPiedEtudiantKm(dto.getMarcheAPiedEtudiantKm());
        if (dto.getNbJoursDeplacementEtudiant() != null) mobiliteDomicileTravailOnglet.setNbJoursDeplacementEtudiant(dto.getNbJoursDeplacementEtudiant());

        if (dto.getVoitureThermiqueSalarieKm() != null) mobiliteDomicileTravailOnglet.setVoitureThermiqueSalarieKm(dto.getVoitureThermiqueSalarieKm());
        if (dto.getVoitureElectriqueSalarieKm() != null) mobiliteDomicileTravailOnglet.setVoitureElectriqueSalarieKm(dto.getVoitureElectriqueSalarieKm());
        if (dto.getVoitureHybrideSalarieKm() != null) mobiliteDomicileTravailOnglet.setVoitureHybrideSalarieKm(dto.getVoitureHybrideSalarieKm());
        if (dto.getMotoSalarieKm() != null) mobiliteDomicileTravailOnglet.setMotoSalarieKm(dto.getMotoSalarieKm());
        if (dto.getTrainRegionalSalarieKm() != null) mobiliteDomicileTravailOnglet.setTrainRegionalSalarieKm(dto.getTrainRegionalSalarieKm());
        if (dto.getBusSalarieKm() != null) mobiliteDomicileTravailOnglet.setBusSalarieKm(dto.getBusSalarieKm());
        if (dto.getMetroTramwaySalarieKm() != null) mobiliteDomicileTravailOnglet.setMetroTramwaySalarieKm(dto.getMetroTramwaySalarieKm());
        if (dto.getVeloSalarieKm() != null) mobiliteDomicileTravailOnglet.setVeloSalarieKm(dto.getVeloSalarieKm());
        if (dto.getTrottinetteElectriqueSalarieKm() != null) mobiliteDomicileTravailOnglet.setTrottinetteElectriqueSalarieKm(dto.getTrottinetteElectriqueSalarieKm());
        if (dto.getVeloElectriqueSalarieKm() != null) mobiliteDomicileTravailOnglet.setVeloElectriqueSalarieKm(dto.getVeloElectriqueSalarieKm());
        if (dto.getMarcheAPiedSalarieKm() != null) mobiliteDomicileTravailOnglet.setMarcheAPiedSalarieKm(dto.getMarcheAPiedSalarieKm());
        if (dto.getNbJoursDeplacementSalarie() != null) mobiliteDomicileTravailOnglet.setNbJoursDeplacementSalarie(dto.getNbJoursDeplacementSalarie());

        repository.save(mobiliteDomicileTravailOnglet);
    }
}