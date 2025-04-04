package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import tcucl.back_tcucl.entity.parametre.dechet.Dechet;

@Entity
@Table(name = "dechet_onglet")
public class DechetOnglet {
    @Id
    private Long id;

    @OneToOne
    private Dechet ordures_menageres;
    @OneToOne
    private Dechet cartons;
    @OneToOne
    private Dechet verre;
    @OneToOne
    private Dechet metaux;
    @OneToOne
    private Dechet textile;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
