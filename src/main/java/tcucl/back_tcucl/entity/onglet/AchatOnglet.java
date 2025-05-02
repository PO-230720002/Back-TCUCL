package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import tcucl.back_tcucl.entity.parametre.achat.AchatConsommable;
import tcucl.back_tcucl.entity.parametre.achat.AchatRestauration;
import tcucl.back_tcucl.entity.parametre.achat.AchatTextile;

@Entity
@Table(name = "achat_onglet")
public class AchatOnglet extends Onglet {


    @OneToOne(cascade = CascadeType.ALL)
    private AchatConsommable achatConsommable;
    @OneToOne(cascade = CascadeType.ALL)
    private AchatRestauration achatRestauration;
    @OneToOne(cascade = CascadeType.ALL)
    private AchatTextile achatTextile;


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

    @Override
    public String getNote() {
        return super.getNote();
    }

    @Override
    public void setNote(String note) {
        super.setNote(note);
    }

    @Override
    public Boolean isEstTermine() {
        return super.isEstTermine();
    }

    @Override
    public void setEstTermine(Boolean estTermine) {
        super.setEstTermine(estTermine);
    }
}
