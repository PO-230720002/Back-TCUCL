package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieDto;
import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieOngletDto;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirieOnglet;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirie;
import tcucl.back_tcucl.manager.ParkingVoirieOngletManager;
import tcucl.back_tcucl.repository.onglet.ParkingVoirieOngletRepository;

@Component
public class ParkingVoirieOngletManagerImpl implements ParkingVoirieOngletManager {
    
    private final ParkingVoirieOngletRepository parkingVoirieOngletRepository;

    public ParkingVoirieOngletManagerImpl(ParkingVoirieOngletRepository parkingVoirieOngletRepository) {
        this.parkingVoirieOngletRepository = parkingVoirieOngletRepository;
    }

    @Override
    public ParkingVoirieOnglet getParkingVoirieOngletById(Long idOnglet) {
        return parkingVoirieOngletRepository.findById(idOnglet).orElseThrow(
                () -> new EntityNotFoundException("ParkingVoirieOnglet non trouvée avec l'id: " + idOnglet));
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
    public void updateParkingVoirieOngletPartiel(Long id, ParkingVoirieOngletDto dto) {
        ParkingVoirieOnglet parkingVoirieOnglet = getParkingVoirieOngletById(id);

        if (dto.getEstTermine() != null) parkingVoirieOnglet.setEstTermine(dto.getEstTermine());
        if (dto.getNote() != null) parkingVoirieOnglet.setNote(dto.getNote());

        if (dto.getParkingVoirieList() != null) {
            // On supprime les voyages existants et on les remplace par les nouveaux
            parkingVoirieOnglet.getParkingVoirieList().clear();
            for (ParkingVoirieDto parkingVoirieDto : dto.getParkingVoirieList()) {
                parkingVoirieOnglet.ajouterParkingVoirieViaDto(parkingVoirieDto);
            }
        }
        parkingVoirieOngletRepository.save(parkingVoirieOnglet);
    }

    @Override
    public void ajouterVoyage(Long id, ParkingVoirieDto parkingVoirieDto) {
        ParkingVoirieOnglet parkingVoirieOnglet = getParkingVoirieOngletById(id);
        if (parkingVoirieDto != null) {
            parkingVoirieOnglet.ajouterParkingVoirieViaDto(parkingVoirieDto);
            parkingVoirieOngletRepository.save(parkingVoirieOnglet);
        } else {
            throw new EntityNotFoundException("ParkingVoirieOnglet non trouvé avec l'Id: " + id);
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
    public void updateVoyagePartiel(Long ongletId, Long voyageId, ParkingVoirieDto dto) {
        ParkingVoirieOnglet onglet = parkingVoirieOngletRepository.getReferenceById(ongletId);

        ParkingVoirie parkingVoirie = onglet.getParkingVoirieList()
                .stream()
                .filter(v -> v.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Voyage non trouvé avec l'id : " + voyageId));


        if (dto.getNomOuAdresse() != null) parkingVoirie.setNomOuAdresse(dto.getNomOuAdresse());
        if (dto.getDateConstruction() != null) parkingVoirie.setDateConstruction(dto.getDateConstruction());
        if (dto.getEmissionsGesConnues() != null) parkingVoirie.setEmissionsGesConnues(dto.getEmissionsGesConnues());
        if (dto.getEmissionsGesReelles() != null) parkingVoirie.setEmissionsGesReelles(dto.getEmissionsGesReelles());
        if (dto.getType() != null) parkingVoirie.setType(dto.getType());
        if (dto.getTypeStructure() != null) parkingVoirie.setTypeStructure(dto.getTypeStructure());
        if (dto.getNombreM2() != null) parkingVoirie.setNombreM2(dto.getNombreM2());
        if (dto.getDateAjoutEnBase() != null) parkingVoirie.setDateAjoutEnBase(dto.getDateAjoutEnBase());

        onglet.getParkingVoirieList().add(parkingVoirie);

        parkingVoirieOngletRepository.save(onglet);
    }
}
