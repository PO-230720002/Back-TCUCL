package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeDto;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeOngletDto;
import tcucl.back_tcucl.entity.onglet.vehicule.VehiculeOnglet;
import tcucl.back_tcucl.entity.onglet.vehicule.Vehicule;
import tcucl.back_tcucl.manager.VehiculeOngletManager;
import tcucl.back_tcucl.service.VehiculeOngletService;

@Service
public class VehiculeOngletServiceImpl implements VehiculeOngletService {

    private final VehiculeOngletManager vehiculeOngletManager;

    public VehiculeOngletServiceImpl(VehiculeOngletManager vehiculeOngletManager) {
        this.vehiculeOngletManager = vehiculeOngletManager;
    }

    @Override
    public VehiculeOnglet getVehiculeOngletById(Long idOnglet) {
        return vehiculeOngletManager.getVehiculeOngletById(idOnglet);
    }

    @Override
    public Vehicule getVehiculeById(Long idOnglet, Long idParking) {
        return vehiculeOngletManager.getVehiculeById(idOnglet, idParking);
    }

    @Override
    public void updateVehiculeOngletPartiel(Long ongletId, VehiculeOngletDto vehiculeOngletDto) {
        vehiculeOngletManager.updateVehiculeOngletPartiel(ongletId, vehiculeOngletDto);
    }

    @Override
    public void ajouterVoyage(Long ongletId, VehiculeDto vehiculeDto) {
        vehiculeOngletManager.ajouterVoyage(ongletId, vehiculeDto);
    }

    @Override
    public void supprimerVoyage(Long ongletId, Long vehiculeId) {
        vehiculeOngletManager.supprimerVoyage(ongletId, vehiculeId);
    }

    @Override
    public void updateVoyagePartiel(Long ongletId, Long voyageId, VehiculeDto vehiculeDto) {
        vehiculeOngletManager.updateVoyagePartiel(ongletId, voyageId, vehiculeDto);
    }
}
