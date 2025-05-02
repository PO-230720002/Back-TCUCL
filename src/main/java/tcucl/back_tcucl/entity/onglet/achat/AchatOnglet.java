package tcucl.back_tcucl.entity.onglet.achat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import tcucl.back_tcucl.entity.onglet.Onglet;

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
    public Boolean getEstTermine() {
        return super.getEstTermine();
    }

    @Override
    public void setEstTermine(Boolean estTermine) {
        super.setEstTermine(estTermine);
    }
}
