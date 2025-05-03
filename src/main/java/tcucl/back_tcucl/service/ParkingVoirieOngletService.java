package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieDto;
import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieOngletDto;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirieOnglet;
import tcucl.back_tcucl.entity.onglet.parkingVoirie.ParkingVoirie;

public interface ParkingVoirieOngletService {

    ParkingVoirieOnglet getParkingVoirieOngletById(Long ongletId);

    ParkingVoirie getParkingVoirieById(Long idOnglet, Long idParking);

    void updateParkingVoirieOngletPartiel(Long ongletId, ParkingVoirieOngletDto dto);

    void ajouterVoyage(Long ongletId, ParkingVoirieDto parkingVoirieDto);

    void supprimerVoyage(Long ongletId, Long parkingVoirieId);

    void updateVoyagePartiel(Long ongletId, Long voyageId, ParkingVoirieDto dto);
    
    
}
