package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.mobInternational.MobInternationalOngletDto;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageDto;
import tcucl.back_tcucl.entity.onglet.emissionFugitive.EmissionFugitiveOnglet;
import tcucl.back_tcucl.entity.onglet.mobInternationale.MobInternationalOnglet;
import tcucl.back_tcucl.entity.onglet.mobInternationale.Voyage;
import tcucl.back_tcucl.exceptionPersonnalisee.ElementNontrouveException;
import tcucl.back_tcucl.exceptionPersonnalisee.OngletNonTrouveIdException;
import tcucl.back_tcucl.exceptionPersonnalisee.ValidationCustomException;
import tcucl.back_tcucl.exceptionPersonnalisee.VoyageDejaExistantException;
import tcucl.back_tcucl.manager.MobInternationalOngletManager;
import tcucl.back_tcucl.repository.onglet.MobInternationalOngletRepository;

import java.util.Set;

@Component
public class MobInternationalOngletManagerImpl implements MobInternationalOngletManager {

    @Autowired
    private Validator validator;
    
    private final MobInternationalOngletRepository mobInternationalOngletRepository;

    public MobInternationalOngletManagerImpl(MobInternationalOngletRepository mobInternationalOngletRepository) {
        this.mobInternationalOngletRepository = mobInternationalOngletRepository;
    }

    @Override
    public MobInternationalOnglet getMobInternationalOngletById(Long ongletId) {
        return mobInternationalOngletRepository.findById(ongletId).orElseThrow(
                () -> new OngletNonTrouveIdException("MobInternational", ongletId));
    }

    @Override
    public Voyage getVoyageById(Long ongletId, Long voyageId) {
        MobInternationalOnglet mobInternationalOnglet = getMobInternationalOngletById(ongletId);
        return mobInternationalOnglet.getVoyage().stream()
                .filter(m -> m.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("Voyage", voyageId));
    }

    @Override
    public void updateMobInternationalOngletPartiel(Long ongletId, MobInternationalOngletDto mobInternationalOngletDto) {
        MobInternationalOnglet mobInternationalOnglet = getMobInternationalOngletById(ongletId);

        if (mobInternationalOngletDto.getEstTermine() != null)
            mobInternationalOnglet.setEstTermine(mobInternationalOngletDto.getEstTermine());
        if (mobInternationalOngletDto.getNote() != null)
            mobInternationalOnglet.setNote(mobInternationalOngletDto.getNote());

        if (mobInternationalOngletDto.getVoyageVersUneDestinationMobInternationale() != null) {
            // On supprime les voyages existants et on les remplace par les nouveaux
            mobInternationalOnglet.getVoyage().clear();
            for (VoyageDto voyageDto : mobInternationalOngletDto.getVoyageVersUneDestinationMobInternationale()) {
                mobInternationalOnglet.ajouterVoyageViaDto(voyageDto);
            }
        }
        
        Set<ConstraintViolation<MobInternationalOnglet>> violations = validator.validate(mobInternationalOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        mobInternationalOngletRepository.save(mobInternationalOnglet);
    }

    @Override
    public void ajouterVoyage(Long ongletId, VoyageDto voyageDto) {
        MobInternationalOnglet mobInternationalOnglet = getMobInternationalOngletById(ongletId);

        // Vérification si le voyage existe déjà
        Voyage existingVoyage = mobInternationalOnglet.getVoyage()
                .stream()
                .filter(v -> v.getNomPays().equals(voyageDto.getNomPays()))
                .findFirst()
                .orElse(null);

        if(existingVoyage != null) {
            throw new VoyageDejaExistantException(voyageDto.getNomPays());
        }else{
            mobInternationalOnglet.ajouterVoyageViaDto(voyageDto);
            
        Set<ConstraintViolation<MobInternationalOnglet>> violations = validator.validate(mobInternationalOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        mobInternationalOngletRepository.save(mobInternationalOnglet);
        }

    }

    @Override
    public void supprimerVoyage(Long ongletId, Long voyageId) {
        MobInternationalOnglet mobInternationalOnglet = getMobInternationalOngletById(ongletId);

        Voyage voyage = mobInternationalOnglet.getVoyage()
                .stream()
                .filter(v -> v.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("Voyage", voyageId));

        mobInternationalOnglet.getVoyage().remove(voyage);

        
        Set<ConstraintViolation<MobInternationalOnglet>> violations = validator.validate(mobInternationalOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        mobInternationalOngletRepository.save(mobInternationalOnglet);
    }

    @Override
    public void updateVoyagePartiel(Long ongletId, Long voyageId, VoyageDto voyageDto) {
        MobInternationalOnglet mobInternationalOnglet = getMobInternationalOngletById(ongletId);

        Voyage voyage = mobInternationalOnglet.getVoyage()
                .stream()
                .filter(v -> v.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("Voyage", voyageId));

        if (voyageDto.getProsAvion() != null)
            voyage.setProsAvion(voyageDto.getProsAvion());
        if (voyageDto.getProsTrain() != null)
            voyage.setProsTrain(voyageDto.getProsTrain());
        if (voyageDto.getStagesEtudiantsAvion() != null)
            voyage.setStagesEtudiantsAvion(voyageDto.getStagesEtudiantsAvion());
        if (voyageDto.getStagesEtudiantsTrain() != null)
            voyage.setStagesEtudiantsTrain(voyageDto.getStagesEtudiantsTrain());
        if (voyageDto.getSemestresEtudiantsAvion() != null)
            voyage.setSemestresEtudiantsAvion(voyageDto.getSemestresEtudiantsAvion());
        if (voyageDto.getSemestresEtudiantsTrain() != null)
            voyage.setSemestresEtudiantsTrain(voyageDto.getSemestresEtudiantsTrain());

        mobInternationalOnglet.getVoyage().add(voyage);

        
        Set<ConstraintViolation<MobInternationalOnglet>> violations = validator.validate(mobInternationalOnglet);
        if(!violations.isEmpty()) {
            throw new ValidationCustomException(violations);
        }
        mobInternationalOngletRepository.save(mobInternationalOnglet);
    }


}
