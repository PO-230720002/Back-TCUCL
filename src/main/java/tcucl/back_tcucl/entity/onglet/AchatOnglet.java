package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import tcucl.back_tcucl.entity.parametre.achat.AchatConsommable;
import tcucl.back_tcucl.entity.parametre.achat.AchatRestauration;
import tcucl.back_tcucl.entity.parametre.achat.AchatTextile;

import java.time.Year;

@Entity
@Table(name = "achat_onglet")
public class AchatOnglet {

    @Id
    private Long id;
    private Year annee;
    private boolean estTermine;

    @OneToOne
    private AchatConsommable achatConsommable;
    @OneToOne
    private AchatRestauration achatRestauration;
    @OneToOne
    private AchatTextile achatTextile;


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

    public AchatConsommable getAchatConsommable() {
        return achatConsommable;
    }

    public void setAchatConsommable(AchatConsommable achatConsommable) {
        this.achatConsommable = achatConsommable;
    }

    public AchatRestauration getAchatRestauration() {
        return achatRestauration;
    }

    public void setAchatRestauration(AchatRestauration achatRestauration) {
        this.achatRestauration = achatRestauration;
    }

    public AchatTextile getAchatTextile() {
        return achatTextile;
    }

    public void setAchatTextile(AchatTextile achatTextile) {
        this.achatTextile = achatTextile;
    }
}
