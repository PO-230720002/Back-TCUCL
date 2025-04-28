package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.batiment.BatimentExistantOuNeufConstruit;
import tcucl.back_tcucl.entity.parametre.batiment.EntretienCourant;
import tcucl.back_tcucl.entity.parametre.batiment.MobilierElectromenager;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "batiment_onglet")
public class BatimentImmobilisationMobilierOnglet extends Onglet {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "batiment_onglet_id")
    private List<BatimentExistantOuNeufConstruit> batimentExistantOuNeufConstruits = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "batiment_onglet_id")
    private List<EntretienCourant> entretienCourants = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "batiment_onglet_id")
    private List<MobilierElectromenager> mobilierElectromenagers = new ArrayList<>();


    public List<BatimentExistantOuNeufConstruit> getBatimentExistantOuNeufConstruits() {
        return batimentExistantOuNeufConstruits;
    }

    public void setBatimentExistantOuNeufConstruits(List<BatimentExistantOuNeufConstruit> batimentExistantOuNeufConstruits) {
        this.batimentExistantOuNeufConstruits = batimentExistantOuNeufConstruits;
    }

    public List<EntretienCourant> getEntretienCourants() {
        return entretienCourants;
    }

    public void setEntretienCourants(List<EntretienCourant> entretienCourants) {
        this.entretienCourants = entretienCourants;
    }

    public List<MobilierElectromenager> getMobilierElectromenagers() {
        return mobilierElectromenagers;
    }

    public void setMobilierElectromenagers(List<MobilierElectromenager> mobilierElectromenagers) {
        this.mobilierElectromenagers = mobilierElectromenagers;
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
