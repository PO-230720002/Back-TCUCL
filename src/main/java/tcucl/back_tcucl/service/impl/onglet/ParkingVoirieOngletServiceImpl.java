package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieDto;
import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieOngletDto;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirieOnglet;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirie;
import tcucl.back_tcucl.manager.ParkingVoirieOngletManager;
import tcucl.back_tcucl.service.ParkingVoirieOngletService;

@Service
public class ParkingVoirieOngletServiceImpl implements ParkingVoirieOngletService {

    private final ParkingVoirieOngletManager parkingVoirieOngletManager;

    public ParkingVoirieOngletServiceImpl(ParkingVoirieOngletManager parkingVoirieOngletManager) {
        this.parkingVoirieOngletManager = parkingVoirieOngletManager;
    }

    @Override
    public ParkingVoirieOnglet getParkingVoirieOngletById(Long ongletId) {
        return parkingVoirieOngletManager.getParkingVoirieOngletById(ongletId);
    }

    @Override
    public ParkingVoirie getParkingVoirieById(Long idOnglet, Long idParking) {
        return parkingVoirieOngletManager.getParkingVoirieById(idOnglet, idParking);
    }

    @Override
    public void updateParkingVoirieOngletPartiel(Long ongletId, ParkingVoirieOngletDto parkingVoirieOngletDto) {
        parkingVoirieOngletManager.updateParkingVoirieOngletPartiel(ongletId, parkingVoirieOngletDto);
    }

    @Override
    public void ajouterVoyage(Long ongletId, ParkingVoirieDto parkingVoirieDto) {
        parkingVoirieOngletManager.ajouterVoyage(ongletId, parkingVoirieDto);
    }

    @Override
    public void supprimerVoyage(Long ongletId, Long parkingVoirieId) {
        parkingVoirieOngletManager.supprimerVoyage(ongletId, parkingVoirieId);
    }

    @Override
    public void updateVoyagePartiel(Long ongletId, Long voyageId, ParkingVoirieDto parkingVoirieDto) {
        parkingVoirieOngletManager.updateVoyagePartiel(ongletId, voyageId, parkingVoirieDto);
    }
}
