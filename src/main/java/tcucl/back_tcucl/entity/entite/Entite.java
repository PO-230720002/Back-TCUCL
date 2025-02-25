package tcucl.back_tcucl.entity.entite;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.NotesPermanentes;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @OneToOne
    private NotesPermanentes notesPermanentes;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public NotesPermanentes getNotesPermanentes() {
        return notesPermanentes;
    }

    public void setNotesPermanentes(NotesPermanentes notesPermanentes) {
        this.notesPermanentes = notesPermanentes;
    }
}
