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
    public VehiculeOnglet getVehiculeOngletById(Long ongletId) {
        return vehiculeOngletManager.getVehiculeOngletById(ongletId);
    }

    @Override
    public Vehicule getVehiculeById(Long ongletId, Long parkingId) {
        return vehiculeOngletManager.getVehiculeById(ongletId, parkingId);
    }

    @Override
    public void updateVehiculeOngletPartiel(Long ongletId, VehiculeOngletDto vehiculeOngletDto) {
        vehiculeOngletManager.updateVehiculeOngletPartiel(ongletId, vehiculeOngletDto);
    }

    @Override
    public void ajouterVehicule(Long ongletId, VehiculeDto vehiculeDto) {
        vehiculeOngletManager.ajouterVehicule(ongletId, vehiculeDto);
    }

    @Override
    public void supprimerVehicule(Long ongletId, Long vehiculeId) {
        vehiculeOngletManager.supprimerVehicule(ongletId, vehiculeId);
    }

    @Override
    public void updateVehiculePartiel(Long ongletId, Long voyageId, VehiculeDto vehiculeDto) {
        vehiculeOngletManager.updateVehiculePartiel(ongletId, voyageId, vehiculeDto);
    }
}
