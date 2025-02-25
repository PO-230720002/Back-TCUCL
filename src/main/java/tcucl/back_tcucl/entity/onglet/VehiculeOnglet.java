package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.vehicule.Vehicule;

import java.util.List;

@Entity
@Table(name = "vehicule_onglet")
public class VehiculeOnglet {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Integer annee;
    private Boolean estTerminee;

    @ManyToMany
    @JoinTable(
            name = "jointure_VehiculeOnglet_Vehicule",
            joinColumns = @JoinColumn(name = "onglet_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicule_id")
    )
    private List<Vehicule> vehiculeList;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Boolean getEstTerminee() {
        return estTerminee;
    }

    public void setEstTerminee(Boolean estTerminee) {
        this.estTerminee = estTerminee;
    }

    public List<Vehicule> getVehiculeList() {
        return vehiculeList;
    }

    public void setVehiculeList(List<Vehicule> vehiculeList) {
        this.vehiculeList = vehiculeList;
    }
}
