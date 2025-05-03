package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeDto;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeOngletDto;
import tcucl.back_tcucl.entity.onglet.vehicule.VehiculeOnglet;
import tcucl.back_tcucl.entity.onglet.vehicule.Vehicule;

public interface VehiculeOngletManager {
    VehiculeOnglet getVehiculeOngletById(Long idOnglet);

    Vehicule getVehiculeById(Long idOnglet, Long idParking);

    void updateVehiculeOngletPartiel(Long ongletId, VehiculeOngletDto vehiculeOngletDto);

    void ajouterVoyage(Long ongletId, VehiculeDto vehiculeDto);

    void supprimerVoyage(Long ongletId, Long vehiculeId);

    void updateVoyagePartiel(Long ongletId, Long voyageId, VehiculeDto vehiculeDto);
}
