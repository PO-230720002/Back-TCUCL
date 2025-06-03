package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeResultatDto;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeDto;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeOngletDto;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeResultatDto;
import tcucl.back_tcucl.entity.facteurEmission.FacteurEmission;
import tcucl.back_tcucl.entity.facteurEmission.FacteurEmissionParametre;
import tcucl.back_tcucl.entity.onglet.vehicule.Vehicule;
import tcucl.back_tcucl.entity.onglet.vehicule.VehiculeOnglet;
import tcucl.back_tcucl.entity.onglet.vehicule.enums.EnumVehicule_Type;
import tcucl.back_tcucl.entity.onglet.vehicule.VehiculeOnglet;
import tcucl.back_tcucl.entity.onglet.vehicule.Vehicule;
import tcucl.back_tcucl.manager.VehiculeOngletManager;
import tcucl.back_tcucl.service.VehiculeOngletService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public VehiculeResultatDto getVehiculeResult(Long ongletId) {
        VehiculeOnglet vehiculeOnglet = vehiculeOngletManager.getVehiculeOngletById(ongletId);
        List<Vehicule> vehicules = vehiculeOnglet.getVehiculeList();

        Map<Long, Float> emissionsParVehicules = vehicules.stream()
                .collect(Collectors.toMap(
                        Vehicule::getId,
                        vehicule -> {
                            float emissionGesVehiculesFabrication = 0f;
                            float emissionGesVehiculesUtilisation = 0f;

                            if (vehicule.getTypeVehicule() == EnumVehicule_Type.VEHICULE_ELECTRIQUE) {
                                emissionGesVehiculesFabrication = vehicule.getNombreKilometresParVoitureMoyen() * vehicule.getNombreVehiculesIdentiques() * 0.096f / 1000f;
                                emissionGesVehiculesUtilisation = vehicule.getNombreKilometresParVoitureMoyen() * vehicule.getNombreVehiculesIdentiques() * 0.022f / 1000f;
                            } else if (vehicule.getTypeVehicule() == EnumVehicule_Type.VEHICULE_THERMIQUE) {
                                emissionGesVehiculesFabrication = vehicule.getNombreKilometresParVoitureMoyen() * vehicule.getNombreVehiculesIdentiques() * 0.026f / 1000f;
                                emissionGesVehiculesUtilisation = vehicule.getNombreKilometresParVoitureMoyen() * vehicule.getNombreVehiculesIdentiques() * 0.192f / 1000f;
                            } else if (vehicule.getTypeVehicule() == EnumVehicule_Type.VEHICULE_HYBRIDE){
                                emissionGesVehiculesFabrication = vehicule.getNombreKilometresParVoitureMoyen() * vehicule.getNombreVehiculesIdentiques() * 0.051f / 1000f;
                                emissionGesVehiculesUtilisation = vehicule.getNombreKilometresParVoitureMoyen() * vehicule.getNombreVehiculesIdentiques() * 0.138f / 1000f;

                            }
                            return emissionGesVehiculesFabrication + emissionGesVehiculesUtilisation;
                        }
                ));

        float total = emissionsParVehicules.values().stream()
                .reduce(0f, Float::sum);

        VehiculeResultatDto resultatDto = new VehiculeResultatDto();
        resultatDto.setEmissionGESVehicule(emissionsParVehicules);
        resultatDto.setTotalEmissionGES(total);

        return resultatDto;
    }
}
