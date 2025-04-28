package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.parkingVoirie.ParkingVoirie;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "parking_voirie_onglet")
public class ParkingVoirieOnglet extends Onglet{

    @OneToMany
    @JoinColumn(name = "parking_voirie_onglet_id")
    private List<ParkingVoirie> parkingVoirieList;



    public List<ParkingVoirie> getParkingVoirieList() {
        return parkingVoirieList;
    }

    public void setParkingVoirieList(List<ParkingVoirie> parkingVoirieList) {
        this.parkingVoirieList = parkingVoirieList;
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
    public boolean isEstTermine() {
        return super.isEstTermine();
    }

    @Override
    public void setEstTermine(boolean estTermine) {
        super.setEstTermine(estTermine);
    }
}
