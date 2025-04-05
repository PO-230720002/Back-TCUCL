package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.vehicule.Vehicule;

import java.util.List;

@Entity
@Table(name = "vehicule_onglet")
public class VehiculeOnglet extends Onglet{

    @ManyToMany
    @JoinTable(
            name = "jointure_VehiculeOnglet_Vehicule",
            joinColumns = @JoinColumn(name = "onglet_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicule_id")
    )
    private List<Vehicule> vehiculeList;



    public List<Vehicule> getVehiculeList() {
        return vehiculeList;
    }

    public void setVehiculeList(List<Vehicule> vehiculeList) {
        this.vehiculeList = vehiculeList;
    }
}
