package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.mobInternational.MobInternationalOngletDto;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageVersUneDestinationMobInternationaleDto;
import tcucl.back_tcucl.entity.onglet.MobInternationalOnglet;
import tcucl.back_tcucl.entity.parametre.mobInternationale.VoyageVersUneDestinationMobInternationale;
import tcucl.back_tcucl.manager.MobInternationalOngletManager;
import tcucl.back_tcucl.repository.onglet.MobInternationalOngletRepository;

@Component
public class MobInternationalOngletManagerImpl implements MobInternationalOngletManager {

    private final MobInternationalOngletRepository mobInternationalOngletRepository;

    public MobInternationalOngletManagerImpl(MobInternationalOngletRepository mobInternationalOngletRepository) {
        this.mobInternationalOngletRepository = mobInternationalOngletRepository;
    }

    @Override
    public MobInternationalOnglet getMobInternationalOngletById(Long id) {
        return mobInternationalOngletRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("MobInternationalOnglet non trouvé avec l'ID : " + id));
    }

    @Override
    public VoyageVersUneDestinationMobInternationale getVoyageById(Long ongletId, Long voyageId) {
        MobInternationalOnglet onglet = getMobInternationalOngletById(ongletId);
        return onglet.getVoyageVersUneDestinationMobInternationale().stream()
                .filter(m -> m.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Voyage non trouvé avec l'ID: " + voyageId));
    }

    @Override
    public void updateMobInternationalOngletPartiel(Long id, MobInternationalOngletDto dto) {
        MobInternationalOnglet mobInternationalOnglet = mobInternationalOngletRepository.getReferenceById(id);

        if (dto.getEstTermine() != null) mobInternationalOnglet.setEstTermine(dto.getEstTermine());
        if (dto.getNote() != null) mobInternationalOnglet.setNote(dto.getNote());

        if (dto.getVoyageVersUneDestinationMobInternationale() != null) {
            // On supprime les voyages existants et on les remplace par les nouveaux
            mobInternationalOnglet.getVoyageVersUneDestinationMobInternationale().clear();
            for (VoyageVersUneDestinationMobInternationaleDto voyageDto : dto.getVoyageVersUneDestinationMobInternationale()) {
                mobInternationalOnglet.ajouterVoyageViaDto(voyageDto);
            }
        }
        mobInternationalOngletRepository.save(mobInternationalOnglet);
    }

    @Override
    public void ajouterVoyage(Long id, VoyageVersUneDestinationMobInternationaleDto voyageDto) {
        MobInternationalOnglet mobInternationalOnglet = getMobInternationalOngletById(id);
        if (voyageDto != null) {
            mobInternationalOnglet.ajouterVoyageViaDto(voyageDto);
            mobInternationalOngletRepository.save(mobInternationalOnglet);
        } else {
            throw new EntityNotFoundException("MobInternationalOnglet non trouvé avec l'Id: " + id);
        }
    }

    @Override
    public void supprimerVoyage(Long ongletId, Long voyageId) {
        MobInternationalOnglet ongletById = mobInternationalOngletRepository.getReferenceById(ongletId);

        VoyageVersUneDestinationMobInternationale voyage = ongletById.getVoyageVersUneDestinationMobInternationale()
                .stream()
                .filter(v -> v.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Voyage non trouvé avec l'id : " + voyageId));

        ongletById.getVoyageVersUneDestinationMobInternationale().remove(voyage);

        mobInternationalOngletRepository.save(ongletById);
    }

    @Override
    public void updateVoyagePartiel(Long ongletId, Long voyageId, VoyageVersUneDestinationMobInternationaleDto dto) {
        MobInternationalOnglet onglet = mobInternationalOngletRepository.getReferenceById(ongletId);

        VoyageVersUneDestinationMobInternationale voyage = onglet.getVoyageVersUneDestinationMobInternationale()
                .stream()
                .filter(v -> v.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Voyage non trouvé avec l'id : " + voyageId));


        if (dto.getNomPays() != null) voyage.setNomPays(dto.getNomPays());
        if (dto.getProsAvion() != null) voyage.setProsAvion(dto.getProsAvion());
        if (dto.getProsTrain() != null) voyage.setProsTrain(dto.getProsTrain());
        if (dto.getStagesEtudiantsAvion() != null) voyage.setStagesEtudiantsAvion(dto.getStagesEtudiantsAvion());
        if (dto.getStagesEtudiantsTrain() != null) voyage.setStagesEtudiantsTrain(dto.getStagesEtudiantsTrain());
        if (dto.getSemestresEtudiantsAvion() != null)
            voyage.setSemestresEtudiantsAvion(dto.getSemestresEtudiantsAvion());
        if (dto.getSemestresEtudiantsTrain() != null)
            voyage.setSemestresEtudiantsTrain(dto.getSemestresEtudiantsTrain());

        onglet.getVoyageVersUneDestinationMobInternationale().add(voyage);

        mobInternationalOngletRepository.save(onglet);
    }


}
