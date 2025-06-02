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
    public ParkingVoirie getParkingVoirieById(Long ongletId, Long parkingId) {
        return parkingVoirieOngletManager.getParkingVoirieById(ongletId, parkingId);
    }

    @Override
    public void updateParkingVoirieOngletPartiel(Long ongletId, ParkingVoirieOngletDto parkingVoirieOngletDto) {
        parkingVoirieOngletManager.updateParkingVoirieOngletPartiel(ongletId, parkingVoirieOngletDto);
    }

    @Override
    public void ajouterParkingVoirie(Long ongletId, ParkingVoirieDto parkingVoirieDto) {
        parkingVoirieOngletManager.ajouterParkingVoirie(ongletId, parkingVoirieDto);
    }

    @Override
    public void supprimerParkingVoirie(Long ongletId, Long parkingVoirieId) {
        parkingVoirieOngletManager.supprimerParkingVoirie(ongletId, parkingVoirieId);
    }

    @Override
    public void updateParkingVoiriePartiel(Long ongletId, Long voyageId, ParkingVoirieDto parkingVoirieDto) {
        parkingVoirieOngletManager.updateParkingVoiriePartiel(ongletId, voyageId, parkingVoirieDto);
    }
}
