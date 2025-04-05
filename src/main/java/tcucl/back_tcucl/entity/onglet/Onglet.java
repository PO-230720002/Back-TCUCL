package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Onglet {
    @Id
    private Long id;
    private String note;
    private boolean estTermine;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
