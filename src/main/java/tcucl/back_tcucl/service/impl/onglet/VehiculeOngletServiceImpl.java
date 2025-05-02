package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeDto;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeOngletDto;
import tcucl.back_tcucl.entity.onglet.VehiculeOnglet;
import tcucl.back_tcucl.entity.parametre.vehicule.Vehicule;
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
    public void updateVehiculeOngletPartiel(Long id, VehiculeOngletDto dto) {
        vehiculeOngletManager.updateVehiculeOngletPartiel(id, dto);
    }

    @Override
    public void ajouterVoyage(Long id, VehiculeDto vehiculeDto) {
        vehiculeOngletManager.ajouterVoyage(id, vehiculeDto);
    }

    @Override
    public void supprimerVoyage(Long ongletId, Long vehiculeId) {
        vehiculeOngletManager.supprimerVoyage(ongletId, vehiculeId);
    }

    @Override
    public void updateVoyagePartiel(Long ongletId, Long voyageId, VehiculeDto dto) {
        vehiculeOngletManager.updateVoyagePartiel(ongletId, voyageId, dto);
    }
}
