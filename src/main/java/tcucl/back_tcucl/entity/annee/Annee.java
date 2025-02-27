package tcucl.back_tcucl.entity.annee;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.NotesPermanentes;

import java.time.Year;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Annee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Year annee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Year getAnnee() {
        return annee;
    }

    public void setAnnee(Year annee) {
        this.annee = annee;
    }
}
