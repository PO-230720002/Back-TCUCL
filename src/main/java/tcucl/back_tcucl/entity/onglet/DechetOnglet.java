package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import tcucl.back_tcucl.entity.parametre.dechet.Dechet;

@Entity
@Table(name = "dechet_onglet")
public class DechetOnglet extends Onglet {

    @OneToOne(cascade = CascadeType.ALL)
    private Dechet ordures_menageres;
    @OneToOne(cascade = CascadeType.ALL)
    private Dechet cartons;
    @OneToOne(cascade = CascadeType.ALL)
    private Dechet verre;
    @OneToOne(cascade = CascadeType.ALL)
    private Dechet metaux;
    @OneToOne(cascade = CascadeType.ALL)
    private Dechet textile;


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
