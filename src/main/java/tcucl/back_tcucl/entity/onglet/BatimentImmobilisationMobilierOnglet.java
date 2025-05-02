package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.batiment.BatimentExistantOuNeufConstruit;
import tcucl.back_tcucl.entity.parametre.batiment.EntretienCourant;
import tcucl.back_tcucl.entity.parametre.batiment.MobilierElectromenager;

import java.time.Year;
import java.util.List;

@Entity
@TableGenerator(name = "batiment")
public class BatimentImmobilisationMobilierOnglet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Year annee;
    private boolean estTermine;

    @ManyToMany
    @JoinTable(
            name = "jointure_BatimentImmobilisationMobilierOnglet_BatimentExistantOuNeufConstruit",
            joinColumns = @JoinColumn(name = "onglet_id"),
            inverseJoinColumns = @JoinColumn(name = "batiment_id")
    )
    private List<BatimentExistantOuNeufConstruit> batimentExistantOuNeufConstruits;

    @ManyToMany
    @JoinTable(
            name = "jointure_BatimentImmobilisationMobilierOnglet_EntretienCourant",
            joinColumns = @JoinColumn(name = "onglet_id"),
            inverseJoinColumns = @JoinColumn(name = "entretien_id")
    )
    private List<EntretienCourant> entretienCourants;

    @ManyToMany
    @JoinTable(
            name = "jointure_BatimentImmobilisationMobilierOnglet_MobilierElectromenager",
            joinColumns = @JoinColumn(name = "onglet_id"),
            inverseJoinColumns = @JoinColumn(name = "mobilier_id")
    )
    private List<MobilierElectromenager> mobilierElectromenagers;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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
}
