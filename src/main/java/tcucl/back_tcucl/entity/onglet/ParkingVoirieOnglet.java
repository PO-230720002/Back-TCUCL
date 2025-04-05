package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.parkingVoirie.ParkingVoirie;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "parking_voirie_Onglet")
public class ParkingVoirieOnglet extends Onglet{

    @ManyToMany
    @JoinTable(
            name = "jointure_ParkingVoirieOnglet_ParkingVoirie",
            joinColumns = @JoinColumn(name = "onglet_id"),
            inverseJoinColumns = @JoinColumn(name = "parking_id")
    )
    private List<ParkingVoirie> parkingVoirieList;



    public List<ParkingVoirie> getParkingVoirieList() {
        return parkingVoirieList;
    }

    public void setParkingVoirieList(List<ParkingVoirie> parkingVoirieList) {
        this.parkingVoirieList = parkingVoirieList;
    }

}
