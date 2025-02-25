package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.parkingVoirie.ParkingVoirie;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "parking_voirie_Onglet")
public class ParkingVoirieOnglet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Year annee;
    private boolean estTermine;

    @ManyToMany
    @JoinTable(
            name = "jointure_ParkingVoirieOnglet_ParkingVoirie",
            joinColumns = @JoinColumn(name = "onglet_id"),
            inverseJoinColumns = @JoinColumn(name = "parking_id")
    )
    private List<ParkingVoirie> parkingVoirieList;


    public Year getAnnee() {
        return annee;
    }

    public void setAnnee(Year annee) {
        this.annee = annee;
    }

    public boolean isEstTermine() {
        return estTermine;
    }

    public void setEstTermine(boolean estTermine) {
        this.estTermine = estTermine;
    }

    public List<ParkingVoirie> getParkingVoirieList() {
        return parkingVoirieList;
    }

    public void setParkingVoirieList(List<ParkingVoirie> parkingVoirieList) {
        this.parkingVoirieList = parkingVoirieList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
