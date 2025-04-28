package tcucl.back_tcucl.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "entite")
public class Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notes_permanentes_id")
    private NotesPermanentes notesPermanentes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "annee_id")
    private List<Annee> annees;


    public Entite(String nom, String type) {
        this.nom = nom;
        this.type = type;
        this.notesPermanentes = new NotesPermanentes();
        this.annees = new ArrayList<>(Collections.singletonList(new Annee()));
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

    public void addAnnee(Annee annee) {
        if (annee == null) {
            this.annees = new ArrayList<>();
        }
        this.annees.add(annee);
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
