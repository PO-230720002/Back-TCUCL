package tcucl.back_tcucl.entity.annee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Annee {

    @Id
    private Long id;

    @OneToOne
    private EnergieOnglet energieOnglet;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
