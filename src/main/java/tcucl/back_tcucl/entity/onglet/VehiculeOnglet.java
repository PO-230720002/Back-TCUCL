package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.dto.onglet.vehicule.VehiculeDto;
import tcucl.back_tcucl.entity.parametre.vehicule.Vehicule;

import java.util.List;

@Entity
@Table(name = "vehicule_onglet")
public class VehiculeOnglet extends Onglet{

    @OneToMany
    @JoinColumn(name = "vehicule_onglet_id")
    private List<Vehicule> vehiculeList;

    public List<Vehicule> getVehiculeList() {
        return vehiculeList;
    }

    public void setVehiculeList(List<Vehicule> vehiculeList) {
        this.vehiculeList = vehiculeList;
    }

    @Override
    public String getNote() {
        return super.getNote();
    }

    @Override
    public void setNote(String note) {
        super.setNote(note);
    }

    @Override
    public Boolean getEstTermine() {
        return super.getEstTermine();
    }

    @Override
    public void setEstTermine(Boolean estTermine) {
        super.setEstTermine(estTermine);
    }

    public void ajouterVehiculeViaDto(VehiculeDto vehiculeDto) {
        Vehicule vehicule = new Vehicule();
        vehicule.setModeleOuImmatriculation(vehiculeDto.getModeleOuImmatriculation());
        vehicule.setTypeVehicule(vehiculeDto.getTypeVehicule());
        vehicule.setNombreKilometresParVoitureMoyen(vehiculeDto.getNombreKilometresParVoitureMoyen());
        vehicule.setNombreVehiculesIdentiques(vehiculeDto.getNombreVehiculesIdentiques());
        vehicule.setDateAjoutEnBase(vehiculeDto.getDateAjoutEnBase());
        this.vehiculeList.add(vehicule);

    }
}
