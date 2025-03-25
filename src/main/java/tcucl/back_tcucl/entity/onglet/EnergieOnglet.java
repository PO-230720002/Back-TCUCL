package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.energie.ParametreEnergie;

import java.time.Year;

@Entity
@Table(name = "energie")
public class EnergieOnglet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Year annee;
    private boolean estTermine;
    @OneToOne
    @JoinColumn(name = "parametre_energie_id")
    private ParametreEnergie parametreEnergie;

    private Float ConsoGaz;
    private Float ConsoFioul;
    private Float ConsoBois;
    private Float ConsoReseauVille;
    private Float ConsoElecChauffage;
    private Float ConsoElecSpecifique;
    private Float ConsoEau;
    private String note;




    public boolean isEstTermine() {
        return estTermine;
    }

    public void setEstTermine(boolean estTermine) {
        this.estTermine = estTermine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Float getConsoEau() {
        return ConsoEau;
    }

    public void setConsoEau(Float consoEau) {
        ConsoEau = consoEau;
    }

    public Float getConsoElecSpecifique() {
        return ConsoElecSpecifique;
    }

    public void setConsoElecSpecifique(Float consoElecSpecifique) {
        ConsoElecSpecifique = consoElecSpecifique;
    }

    public Float getConsoElecChauffage() {
        return ConsoElecChauffage;
    }

    public void setConsoElecChauffage(Float consoElecChauffage) {
        ConsoElecChauffage = consoElecChauffage;
    }

    public Float getConsoReseauVille() {
        return ConsoReseauVille;
    }

    public void setConsoReseauVille(Float consoReseauVille) {
        ConsoReseauVille = consoReseauVille;
    }

    public Float getConsoBois() {
        return ConsoBois;
    }

    public void setConsoBois(Float consoBois) {
        ConsoBois = consoBois;
    }

    public Float getConsoFioul() {
        return ConsoFioul;
    }

    public void setConsoFioul(Float consoFioul) {
        ConsoFioul = consoFioul;
    }

    public Float getConsoGaz() {
        return ConsoGaz;
    }

    public void setConsoGaz(Float consoGaz) {
        ConsoGaz = consoGaz;
    }

    public Year getAnnee() {
        return annee;
    }

    public void setAnnee(Year annee) {
        this.annee = annee;
    }

    public ParametreEnergie getParametreEnergie() {
        return parametreEnergie;
    }

    public void setParametreEnergie(ParametreEnergie parametreEnergie) {
        this.parametreEnergie = parametreEnergie;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
