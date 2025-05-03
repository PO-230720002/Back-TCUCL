package tcucl.back_tcucl.manager.impl.onglet;

import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieDto;
import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieOngletDto;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirieOnglet;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirie;
import tcucl.back_tcucl.exceptionPersonnalisee.ElementNontrouveException;
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
                () -> new OngletNonTrouveIdException("ParkingVoirie", ongletId));
    }

    @Override
    public ParkingVoirie getParkingVoirieById(Long ongletId, Long parkingId) {
        ParkingVoirieOnglet parkingVoirieOnglet = getParkingVoirieOngletById(ongletId);
        return parkingVoirieOnglet.getParkingVoirieList().stream()
                .filter(p -> p.getId().equals(parkingId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("ParkingVoirie",parkingId));
                

    }

    @Override
    public void updateParkingVoirieOngletPartiel(Long ongletId, ParkingVoirieOngletDto parkingVoirieOngletDto) {
        ParkingVoirieOnglet parkingVoirieOnglet = getParkingVoirieOngletById(ongletId);

        if (parkingVoirieOngletDto.getEstTermine() != null)
            parkingVoirieOnglet.setEstTermine(parkingVoirieOngletDto.getEstTermine());
        if (parkingVoirieOngletDto.getNote() != null) parkingVoirieOnglet.setNote(parkingVoirieOngletDto.getNote());

        if (parkingVoirieOngletDto.getParkingVoirieList() != null) {
            // On supprime les ParkingVoirie existants et on les remplace par les nouveaux
            parkingVoirieOnglet.getParkingVoirieList().clear();
            for (ParkingVoirieDto parkingVoirieDto : parkingVoirieOngletDto.getParkingVoirieList()) {
                parkingVoirieOnglet.ajouterParkingVoirieViaDto(parkingVoirieDto);
            }
        }
        parkingVoirieOngletRepository.save(parkingVoirieOnglet);
    }

    @Override
    public void ajouterParkingVoirie(Long ongletId, ParkingVoirieDto parkingVoirieDto) {
        ParkingVoirieOnglet parkingVoirieOnglet = getParkingVoirieOngletById(ongletId);
        parkingVoirieOnglet.ajouterParkingVoirieViaDto(parkingVoirieDto);
        parkingVoirieOngletRepository.save(parkingVoirieOnglet);
    }

    @Override
    public void supprimerParkingVoirie(Long ongletId, Long parkingVoirieId) {
        ParkingVoirieOnglet parkingVoirieOnglet = getParkingVoirieOngletById(ongletId);

        ParkingVoirie parkingVoirie = parkingVoirieOnglet.getParkingVoirieList()
                .stream()
                .filter(v -> v.getId().equals(parkingVoirieId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("ParkingVoirie",parkingVoirieId));


        parkingVoirieOnglet.getParkingVoirieList().remove(parkingVoirie);

        parkingVoirieOngletRepository.save(parkingVoirieOnglet);
    }

    @Override
    public void updateParkingVoiriePartiel(Long ongletId, Long parkingVoirieId, ParkingVoirieDto parkingVoirieDto) {
        ParkingVoirieOnglet parkingVoirieOnglet = getParkingVoirieOngletById(ongletId);

        ParkingVoirie parkingVoirie = parkingVoirieOnglet.getParkingVoirieList()
                .stream()
                .filter(v -> v.getId().equals(parkingVoirieId))
                .findFirst()
                .orElseThrow(() -> new ElementNontrouveException("ParkingVoirie",parkingVoirieId));


        if (parkingVoirieDto.getNomOuAdresse() != null)
            parkingVoirie.setNomOuAdresse(parkingVoirieDto.getNomOuAdresse());
        if (parkingVoirieDto.getDateConstruction() != null)
            parkingVoirie.setDateConstruction(parkingVoirieDto.getDateConstruction());
        if (parkingVoirieDto.getEmissionsGesConnues() != null)
            parkingVoirie.setEmissionsGesConnues(parkingVoirieDto.getEmissionsGesConnues());
        if (parkingVoirieDto.getEmissionsGesReelles() != null)
            parkingVoirie.setEmissionsGesReelles(parkingVoirieDto.getEmissionsGesReelles());
        if (parkingVoirieDto.getType() != null) parkingVoirie.setType(parkingVoirieDto.getType());
        if (parkingVoirieDto.getTypeStructure() != null)
            parkingVoirie.setTypeStructure(parkingVoirieDto.getTypeStructure());
        if (parkingVoirieDto.getNombreM2() != null) parkingVoirie.setNombreM2(parkingVoirieDto.getNombreM2());
        if (parkingVoirieDto.getDateAjoutEnBase() != null)
            parkingVoirie.setDateAjoutEnBase(parkingVoirieDto.getDateAjoutEnBase());

        parkingVoirieOnglet.getParkingVoirieList().add(parkingVoirie);

        parkingVoirieOngletRepository.save(parkingVoirieOnglet);
    }
}
