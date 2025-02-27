package tcucl.back_tcucl.entity;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.annee.Annee;

import java.util.List;

@Entity
@Table(name = "entitee")
public class Entitee {

    @Id
    private Long id;
    private String nom;

    @OneToMany
    private List<NotesPermanentes> notesPermanentes;

    @OneToMany
    private List<Annee> annees;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<NotesPermanentes> getNotesPermanentes() {
        return notesPermanentes;
    }

    public void setNotesPermanentes(List<NotesPermanentes> notesPermanentes) {
        this.notesPermanentes = notesPermanentes;
    }

    public List<Annee> getAnnees() {
        return annees;
    }

    public void setAnnees(List<Annee> annees) {
        this.annees = annees;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
