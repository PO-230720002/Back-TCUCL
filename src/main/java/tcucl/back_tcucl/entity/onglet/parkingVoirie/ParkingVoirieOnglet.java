package tcucl.back_tcucl.entity.onglet.parkingVoirie;

import jakarta.persistence.*;
import tcucl.back_tcucl.dto.onglet.parkingVoirie.ParkingVoirieDto;
import tcucl.back_tcucl.entity.onglet.Onglet;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parking_voirie_onglet")
public class ParkingVoirieOnglet extends Onglet {

    @OneToMany
    @JoinColumn(name = "parking_voirie_onglet_id")
    private List<ParkingVoirie> parkingVoirieList;

    public ParkingVoirieOnglet() {
        this.parkingVoirieList = new ArrayList<>();
    }

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
    public Boolean getEstTermine() {
        return super.getEstTermine();
    }

    @Override
    public void setEstTermine(Boolean estTermine) {
        super.setEstTermine(estTermine);
    }

    public void ajouterParkingVoirieViaDto(ParkingVoirieDto parkingVoirieDto) {
        ParkingVoirie parkingVoirie = new ParkingVoirie();
        parkingVoirie.setNomOuAdresse(parkingVoirieDto.getNomOuAdresse());
        parkingVoirie.setDateConstruction(parkingVoirieDto.getDateConstruction());
        parkingVoirie.setEmissionsGesConnues(parkingVoirieDto.getEmissionsGesConnues());
        parkingVoirie.setEmissionsGesReelles(parkingVoirieDto.getEmissionsGesReelles());
        parkingVoirie.setType(parkingVoirieDto.getType());
        parkingVoirie.setNombreM2(parkingVoirieDto.getNombreM2());
        parkingVoirie.setTypeStructure(parkingVoirieDto.getTypeStructure());
        parkingVoirie.setDateAjoutEnBase(parkingVoirieDto.getDateAjoutEnBase());

        this.parkingVoirieList.add(parkingVoirie);
    }
}
