package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Year;

@Entity
@Table(name = "achat_onglet")
public class AchatOnglet {

    @Id
    private Long id;
    private Year annee;
    private boolean estTermine;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
