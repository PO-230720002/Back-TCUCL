package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeDto;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeOngletDto;
import tcucl.back_tcucl.entity.onglet.vehicule.VehiculeOnglet;
import tcucl.back_tcucl.entity.onglet.vehicule.Vehicule;
import tcucl.back_tcucl.manager.VehiculeOngletManager;
import tcucl.back_tcucl.repository.onglet.VehiculeOngletRepository;

@Component
public class VehiculeOngletManagerImpl implements VehiculeOngletManager {
    
    private final VehiculeOngletRepository vehiculeOngletRepository;

    public VehiculeOngletManagerImpl(VehiculeOngletRepository vehiculeOngletRepository) {
        this.vehiculeOngletRepository = vehiculeOngletRepository;
    }

    @Override
    public VehiculeOnglet getVehiculeOngletById(Long idOnglet) {
        return vehiculeOngletRepository.findById(idOnglet).orElseThrow(
                () -> new EntityNotFoundException("VehiculeOnglet non trouvée avec l'id: " + idOnglet));
    }

    @Override
    public Vehicule getVehiculeById(Long idOnglet, Long idVehicule) {
        VehiculeOnglet onglet = getVehiculeOngletById(idOnglet);
        return onglet.getVehiculeList().stream()
                .filter(p -> p.getId().equals(idVehicule))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Vehicule non trouvé avec l'Id: " + idVehicule));

    }

    @Override
    public void updateVehiculeOngletPartiel(Long id, VehiculeOngletDto dto) {
        VehiculeOnglet vehiculeOnglet = getVehiculeOngletById(id);

        if (dto.getEstTermine() != null) vehiculeOnglet.setEstTermine(dto.getEstTermine());
        if (dto.getNote() != null) vehiculeOnglet.setNote(dto.getNote());

        if (dto.getVehiculeList() != null) {
            // On supprime les voyages existants et on les remplace par les nouveaux
            vehiculeOnglet.getVehiculeList().clear();
            for (VehiculeDto vehiculeDto : dto.getVehiculeList()) {
                vehiculeOnglet.ajouterVehiculeViaDto(vehiculeDto);
            }
        }
        vehiculeOngletRepository.save(vehiculeOnglet);
    }

    @Override
    public void ajouterVoyage(Long id, VehiculeDto vehiculeDto) {
        VehiculeOnglet vehiculeOnglet = getVehiculeOngletById(id);
        if (vehiculeDto != null) {
            vehiculeOnglet.ajouterVehiculeViaDto(vehiculeDto);
            vehiculeOngletRepository.save(vehiculeOnglet);
        } else {
            throw new EntityNotFoundException("VehiculeOnglet non trouvé avec l'Id: " + id);
        }
    }

    @Override
    public void supprimerVoyage(Long ongletId, Long vehiculeId) {
        VehiculeOnglet ongletById = vehiculeOngletRepository.getReferenceById(ongletId);

        Vehicule vehicule = ongletById.getVehiculeList()
                .stream()
                .filter(v -> v.getId().equals(vehiculeId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Vehicule non trouvé avec l'id : " + vehiculeId));

        ongletById.getVehiculeList().remove(vehicule);

        vehiculeOngletRepository.save(ongletById);
    }

    @Override
    public void updateVoyagePartiel(Long ongletId, Long voyageId, VehiculeDto dto) {
        VehiculeOnglet onglet = vehiculeOngletRepository.getReferenceById(ongletId);

        Vehicule vehicule = onglet.getVehiculeList()
                .stream()
                .filter(v -> v.getId().equals(voyageId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Voyage non trouvé avec l'id : " + voyageId));

        if (dto.getModeleOuImmatriculation() != null) {
            vehicule.setModeleOuImmatriculation(dto.getModeleOuImmatriculation());
        }
        if (dto.getTypeVehicule() != null) {
            vehicule.setTypeVehicule(dto.getTypeVehicule());
        }
        if (dto.getNombreKilometresParVoitureMoyen() != null) {
            vehicule.setNombreKilometresParVoitureMoyen(dto.getNombreKilometresParVoitureMoyen());
        }
        if (dto.getNombreVehiculesIdentiques() != null) {
            vehicule.setNombreVehiculesIdentiques(dto.getNombreVehiculesIdentiques());
        }
        if (dto.getDateAjoutEnBase() != null) {
            vehicule.setDateAjoutEnBase(dto.getDateAjoutEnBase());
        }
        
        onglet.getVehiculeList().add(vehicule);

        vehiculeOngletRepository.save(onglet);
    }
}

