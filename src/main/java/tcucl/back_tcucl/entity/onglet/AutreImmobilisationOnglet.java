package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "autre_immobilisation_onglet")
public class AutreImmobilisationOnglet {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Integer annee;
    private Boolean estTerminee;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
