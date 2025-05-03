package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.mobInternational.MobInternationalOngletDto;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageVersUneDestinationMobInternationaleDto;
import tcucl.back_tcucl.entity.onglet.mobInternationale.MobInternationalOnglet;
import tcucl.back_tcucl.entity.onglet.mobInternationale.VoyageVersUneDestinationMobInternationale;
import tcucl.back_tcucl.exceptionPersonnalisee.OngletNonTrouveIdException;
import tcucl.back_tcucl.manager.MobInternationalOngletManager;
import tcucl.back_tcucl.repository.onglet.MobInternationalOngletRepository;

@Component
public class MobInternationalOngletManagerImpl implements MobInternationalOngletManager {

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
    public VoyageVersUneDestinationMobInternationale getVoyageById(Long ongletId, Long voyageId) {
        MobInternationalOnglet mobInternationalOnglet = getMobInternationalOngletById(ongletId);
        return mobInternationalOnglet .getVoyageVersUneDestinationMobInternationale().stream()
                .filter(m -> m.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Voyage non trouvé avec l'Id: " + voyageId));
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
            mobInternationalOnglet.getVoyageVersUneDestinationMobInternationale().clear();
            for (VoyageVersUneDestinationMobInternationaleDto voyageDto : mobInternationalOngletDto.getVoyageVersUneDestinationMobInternationale()) {
                mobInternationalOnglet.ajouterVoyageViaDto(voyageDto);
            }
        }
        mobInternationalOngletRepository.save(mobInternationalOnglet);
    }

    @Override
    public void ajouterVoyage(Long ongletId, VoyageVersUneDestinationMobInternationaleDto voyageDto) {
        MobInternationalOnglet mobInternationalOnglet = getMobInternationalOngletById(ongletId);
        mobInternationalOnglet.ajouterVoyageViaDto(voyageDto);
        mobInternationalOngletRepository.save(mobInternationalOnglet);
    }

    @Override
    public void supprimerVoyage(Long ongletId, Long voyageId) {
        MobInternationalOnglet mobInternationalOnglet = getMobInternationalOngletById(ongletId);

        VoyageVersUneDestinationMobInternationale voyage = mobInternationalOnglet .getVoyageVersUneDestinationMobInternationale()
                .stream()
                .filter(v -> v.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Voyage non trouvé avec l'id : " + voyageId));

        mobInternationalOnglet .getVoyageVersUneDestinationMobInternationale().remove(voyage);

        mobInternationalOngletRepository.save(mobInternationalOnglet);
    }

    @Override
    public void updateVoyagePartiel(Long ongletId, Long voyageId, VoyageVersUneDestinationMobInternationaleDto voyageVersUneDestinationMobInternationaleDto) {
        MobInternationalOnglet mobInternationalOnglet = getMobInternationalOngletById(ongletId);

        VoyageVersUneDestinationMobInternationale voyage = mobInternationalOnglet .getVoyageVersUneDestinationMobInternationale()
                .stream()
                .filter(v -> v.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Voyage non trouvé avec l'id : " + voyageId));


        if (voyageVersUneDestinationMobInternationaleDto.getNomPays() != null)
            voyage.setNomPays(voyageVersUneDestinationMobInternationaleDto.getNomPays());
        if (voyageVersUneDestinationMobInternationaleDto.getProsAvion() != null)
            voyage.setProsAvion(voyageVersUneDestinationMobInternationaleDto.getProsAvion());
        if (voyageVersUneDestinationMobInternationaleDto.getProsTrain() != null)
            voyage.setProsTrain(voyageVersUneDestinationMobInternationaleDto.getProsTrain());
        if (voyageVersUneDestinationMobInternationaleDto.getStagesEtudiantsAvion() != null)
            voyage.setStagesEtudiantsAvion(voyageVersUneDestinationMobInternationaleDto.getStagesEtudiantsAvion());
        if (voyageVersUneDestinationMobInternationaleDto.getStagesEtudiantsTrain() != null)
            voyage.setStagesEtudiantsTrain(voyageVersUneDestinationMobInternationaleDto.getStagesEtudiantsTrain());
        if (voyageVersUneDestinationMobInternationaleDto.getSemestresEtudiantsAvion() != null)
            voyage.setSemestresEtudiantsAvion(voyageVersUneDestinationMobInternationaleDto.getSemestresEtudiantsAvion());
        if (voyageVersUneDestinationMobInternationaleDto.getSemestresEtudiantsTrain() != null)
            voyage.setSemestresEtudiantsTrain(voyageVersUneDestinationMobInternationaleDto.getSemestresEtudiantsTrain());

        mobInternationalOnglet .getVoyageVersUneDestinationMobInternationale().add(voyage);

        mobInternationalOngletRepository.save(mobInternationalOnglet);
    }


}
