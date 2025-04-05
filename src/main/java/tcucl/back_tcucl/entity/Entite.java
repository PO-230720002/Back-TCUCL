package tcucl.back_tcucl.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "entite")
public class Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type;

    @OneToOne
    @JoinColumn(name = "notes_permanentes_id")
    private NotesPermanentes notesPermanentes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "annee_id")
    private List<Annee> annees;


    public Entite(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }

    public Entite() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Annee> getAnnees() {
        return annees;
    }

    public void setAnnees(List<Annee> annees) {
        this.annees = annees;
    }

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
