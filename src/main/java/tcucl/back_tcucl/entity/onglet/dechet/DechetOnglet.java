package tcucl.back_tcucl.entity.onglet.dechet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import tcucl.back_tcucl.entity.onglet.Onglet;

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



    public Dechet getOrdures_menageres() {
        return ordures_menageres;
    }

    public void setOrdures_menageres(Dechet ordures_menageres) {
        this.ordures_menageres = ordures_menageres;
    }

    public Dechet getCartons() {
        return cartons;
    }

    public void setCartons(Dechet cartons) {
        this.cartons = cartons;
    }

    public Dechet getVerre() {
        return verre;
    }

    public void setVerre(Dechet verre) {
        this.verre = verre;
    }

    public Dechet getMetaux() {
        return metaux;
    }

    public void setMetaux(Dechet metaux) {
        this.metaux = metaux;
    }

    public Dechet getTextile() {
        return textile;
    }

    public void setTextile(Dechet textile) {
        this.textile = textile;
    }

    
}
