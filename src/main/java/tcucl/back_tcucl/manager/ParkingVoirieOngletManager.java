package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieDto;
import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieOngletDto;
import tcucl.back_tcucl.entity.onglet.ParkingVoirieOnglet;
import tcucl.back_tcucl.entity.parametre.parkingVoirie.ParkingVoirie;

public interface ParkingVoirieOngletManager {
    ParkingVoirieOnglet getParkingVoirieOngletById(Long id);

    ParkingVoirie getParkingVoirieById(Long idOnglet, Long idParking);

    void updateParkingVoirieOngletPartiel(Long id, ParkingVoirieOngletDto dto);

    void ajouterVoyage(Long id, ParkingVoirieDto parkingVoirieDto);

    void supprimerVoyage(Long ongletId, Long parkingVoirieId);

    void updateVoyagePartiel(Long ongletId, Long voyageId, ParkingVoirieDto dto);
}
