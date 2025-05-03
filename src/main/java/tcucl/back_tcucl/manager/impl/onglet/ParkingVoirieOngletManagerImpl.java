package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieDto;
import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieOngletDto;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirieOnglet;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirie;
import tcucl.back_tcucl.exceptionPersonnalisee.OngletNonTrouveIdException;
import tcucl.back_tcucl.manager.ParkingVoirieOngletManager;
import tcucl.back_tcucl.repository.onglet.ParkingVoirieOngletRepository;

@Component
public class ParkingVoirieOngletManagerImpl implements ParkingVoirieOngletManager {
    
    private final ParkingVoirieOngletRepository parkingVoirieOngletRepository;

    public ParkingVoirieOngletManagerImpl(ParkingVoirieOngletRepository parkingVoirieOngletRepository) {
        this.parkingVoirieOngletRepository = parkingVoirieOngletRepository;
    }

    @Override
    public ParkingVoirieOnglet getParkingVoirieOngletById(Long ongletId) {
        return parkingVoirieOngletRepository.findById(ongletId).orElseThrow(
                () -> new OngletNonTrouveIdException("ParkingVoirie",ongletId));
    }

    @Override
    public ParkingVoirie getParkingVoirieById(Long idOnglet, Long idParking) {
        ParkingVoirieOnglet onglet = getParkingVoirieOngletById(idOnglet);
        return onglet.getParkingVoirieList().stream()
                .filter(p -> p.getId().equals(idParking))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Parking non trouvé avec l'Id: " + idParking));

    }

    @Override
    public void updateParkingVoirieOngletPartiel(Long ongletId, ParkingVoirieOngletDto parkingVoirieOngletDto) {
        ParkingVoirieOnglet parkingVoirieOnglet = getParkingVoirieOngletById(ongletId);

        if (parkingVoirieOngletDto.getEstTermine() != null) parkingVoirieOnglet.setEstTermine(parkingVoirieOngletDto.getEstTermine());
        if (parkingVoirieOngletDto.getNote() != null) parkingVoirieOnglet.setNote(parkingVoirieOngletDto.getNote());

        if (parkingVoirieOngletDto.getParkingVoirieList() != null) {
            // On supprime les voyages existants et on les remplace par les nouveaux
            parkingVoirieOnglet.getParkingVoirieList().clear();
            for (ParkingVoirieDto parkingVoirieDto : parkingVoirieOngletDto.getParkingVoirieList()) {
                parkingVoirieOnglet.ajouterParkingVoirieViaDto(parkingVoirieDto);
            }
        }
        parkingVoirieOngletRepository.save(parkingVoirieOnglet);
    }

    @Override
    public void ajouterVoyage(Long ongletId, ParkingVoirieDto parkingVoirieDto) {
        ParkingVoirieOnglet parkingVoirieOnglet = getParkingVoirieOngletById(ongletId);
        if (parkingVoirieDto != null) {
            parkingVoirieOnglet.ajouterParkingVoirieViaDto(parkingVoirieDto);
            parkingVoirieOngletRepository.save(parkingVoirieOnglet);
        } else {
            throw new EntityNotFoundException("ParkingVoirieOnglet non trouvé avec l'Id: " + ongletId);
        }
    }

    @Override
    public void supprimerVoyage(Long ongletId, Long parkingVoirieId) {
        ParkingVoirieOnglet ongletById = parkingVoirieOngletRepository.getReferenceById(ongletId);

        ParkingVoirie parkingVoirie = ongletById.getParkingVoirieList()
                .stream()
                .filter(v -> v.getId().equals(parkingVoirieId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("ParkingVoirie non trouvé avec l'id : " + parkingVoirieId));

        ongletById.getParkingVoirieList().remove(parkingVoirie);

        parkingVoirieOngletRepository.save(ongletById);
    }

    @Override
    public void updateVoyagePartiel(Long ongletId, Long voyageId, ParkingVoirieDto parkingVoirieDto) {
        ParkingVoirieOnglet onglet = parkingVoirieOngletRepository.getReferenceById(ongletId);

        ParkingVoirie parkingVoirie = onglet.getParkingVoirieList()
                .stream()
                .filter(v -> v.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Voyage non trouvé avec l'id : " + voyageId));


        if (parkingVoirieDto.getNomOuAdresse() != null) parkingVoirie.setNomOuAdresse(parkingVoirieDto.getNomOuAdresse());
        if (parkingVoirieDto.getDateConstruction() != null) parkingVoirie.setDateConstruction(parkingVoirieDto.getDateConstruction());
        if (parkingVoirieDto.getEmissionsGesConnues() != null) parkingVoirie.setEmissionsGesConnues(parkingVoirieDto.getEmissionsGesConnues());
        if (parkingVoirieDto.getEmissionsGesReelles() != null) parkingVoirie.setEmissionsGesReelles(parkingVoirieDto.getEmissionsGesReelles());
        if (parkingVoirieDto.getType() != null) parkingVoirie.setType(parkingVoirieDto.getType());
        if (parkingVoirieDto.getTypeStructure() != null) parkingVoirie.setTypeStructure(parkingVoirieDto.getTypeStructure());
        if (parkingVoirieDto.getNombreM2() != null) parkingVoirie.setNombreM2(parkingVoirieDto.getNombreM2());
        if (parkingVoirieDto.getDateAjoutEnBase() != null) parkingVoirie.setDateAjoutEnBase(parkingVoirieDto.getDateAjoutEnBase());

        onglet.getParkingVoirieList().add(parkingVoirie);

        parkingVoirieOngletRepository.save(onglet);
    }
}
