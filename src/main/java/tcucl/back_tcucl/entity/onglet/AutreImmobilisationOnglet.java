package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;

@Entity
@Table(name = "autre_immobilisation_onglet")
public class AutreImmobilisationOnglet extends Onglet {

    private Boolean installationComplete_IsEmissionGESConnues;
    private Float installationComplete_EmissionDeGes;

    private Float panneaux_PuissanceTotale;
    private Integer panneaux_DureeDeVie;
    private Boolean panneaux_IsEmissionGESConnues;
    private Float panneaux_EmissionDeGes;

    private Float onduleur_PuissanceTotale;
    private Integer onduleur_DureeDeVie;
    private Boolean onduleur_IsEmissionGESConnues;
    private Float onduleur_EmissionDeGes;


    @AssertTrue(message = "Si installationComplete_IsEmissionGESConnues est faux, installationComplete_EmissionDeGes doit être null")
    public Boolean assertInstallationEmissionGesValid() {
        return installationComplete_IsEmissionGESConnues || installationComplete_EmissionDeGes == null;
    }

    @AssertTrue(message = "Si panneaux_IsEmissionGESConnues est faux, panneaux_EmissionDeGes doit être null")
    public Boolean assertPanneauxEmissionGesValid() {
        return panneaux_IsEmissionGESConnues || panneaux_EmissionDeGes == null;
    }

    @AssertTrue(message = "Si onduleur_IsEmissionGESConnues est faux, onduleur_EmissionDeGes doit être null")
    public Boolean assertOnduleurEmissionGesValid() {
        return onduleur_IsEmissionGESConnues || onduleur_EmissionDeGes == null;
    }

    private Integer groupesElectrogenes_Nombre;
    private Float groupesElectrogenes_PoidsDuProduit;
    private Integer groupesElectrogenes_DureeAmortissement;
    private Boolean groupesElectrogenes_IsEmissionConnue;
    private Float groupesElectrogenes_EmissionReelle;

    private Integer moteurElectrique_Nombre;
    private Float moteurElectrique_PoidsDuProduit;
    private Integer moteurElectrique_DureeAmortissement;
    private Boolean moteurElectrique_IsEmissionConnue;
    private Float moteurElectrique_EmissionReelle;

    private Integer autresMachinesKg_Nombre;
    private Float autresMachinesKg_PoidsDuProduit;
    private Integer autresMachinesKg_DureeAmortissement;
    private Boolean autresMachinesKg_IsEmissionConnue;
    private Float autresMachinesKg_EmissionReelle;

    private Integer autresMachinesEur_Nombre;
    private Float autresMachinesEur_PoidsDuProduit;
    private Integer autresMachinesEur_DureeAmortissement;
    private Boolean autresMachinesEur_IsEmissionConnue;
    private Float autresMachinesEur_EmissionReelle;

    @AssertTrue(message = "Si groupesElectrogenes_IsEmissionConnue est faux, groupesElectrogenes_EmissionReelle doit être null")
    public Boolean assertGroupesElectrogenesEmissionValid() {
        return groupesElectrogenes_IsEmissionConnue || groupesElectrogenes_EmissionReelle == null;
    }

    @AssertTrue(message = "Si moteurElectrique_IsEmissionConnue est faux, moteurElectrique_EmissionReelle doit être null")
    public Boolean assertMoteurElectriqueEmissionValid() {
        return moteurElectrique_IsEmissionConnue || moteurElectrique_EmissionReelle == null;
    }

    @AssertTrue(message = "Si autresMachinesKg_IsEmissionConnue est faux, autresMachinesKg_EmissionReelle doit être null")
    public Boolean assertAutresMachinesKgEmissionValid() {
        return autresMachinesKg_IsEmissionConnue || autresMachinesKg_EmissionReelle == null;
    }

    @AssertTrue(message = "Si autresMachinesEur_IsEmissionConnue est faux, autresMachinesEur_EmissionReelle doit être null")
    public Boolean assertAutresMachinesEurEmissionValid() {
        return autresMachinesEur_IsEmissionConnue || autresMachinesEur_EmissionReelle == null;
    }


    public Boolean getInstallationComplete_IsEmissionGESConnues() {
        return installationComplete_IsEmissionGESConnues;
    }

    public void setInstallationComplete_IsEmissionGESConnues(Boolean installationComplete_IsEmissionGESConnues) {
        this.installationComplete_IsEmissionGESConnues = installationComplete_IsEmissionGESConnues;
    }

    public Float getInstallationComplete_EmissionDeGes() {
        return installationComplete_EmissionDeGes;
    }

    public void setInstallationComplete_EmissionDeGes(Float installationComplete_EmissionDeGes) {
        this.installationComplete_EmissionDeGes = installationComplete_EmissionDeGes;
    }

    public Float getPanneaux_PuissanceTotale() {
        return panneaux_PuissanceTotale;
    }

    public void setPanneaux_PuissanceTotale(Float panneaux_PuissanceTotale) {
        this.panneaux_PuissanceTotale = panneaux_PuissanceTotale;
    }

    public Integer getPanneaux_DureeDeVie() {
        return panneaux_DureeDeVie;
    }

    public void setPanneaux_DureeDeVie(Integer panneaux_DureeDeVie) {
        this.panneaux_DureeDeVie = panneaux_DureeDeVie;
    }

    public Boolean getPanneaux_IsEmissionGESConnues() {
        return panneaux_IsEmissionGESConnues;
    }

    public void setPanneaux_IsEmissionGESConnues(Boolean panneaux_IsEmissionGESConnues) {
        this.panneaux_IsEmissionGESConnues = panneaux_IsEmissionGESConnues;
    }

    public Float getPanneaux_EmissionDeGes() {
        return panneaux_EmissionDeGes;
    }

    public void setPanneaux_EmissionDeGes(Float panneaux_EmissionDeGes) {
        this.panneaux_EmissionDeGes = panneaux_EmissionDeGes;
    }

    public Float getOnduleur_PuissanceTotale() {
        return onduleur_PuissanceTotale;
    }

    public void setOnduleur_PuissanceTotale(Float onduleur_PuissanceTotale) {
        this.onduleur_PuissanceTotale = onduleur_PuissanceTotale;
    }

    public Integer getOnduleur_DureeDeVie() {
        return onduleur_DureeDeVie;
    }

    public void setOnduleur_DureeDeVie(Integer onduleur_DureeDeVie) {
        this.onduleur_DureeDeVie = onduleur_DureeDeVie;
    }

    public Boolean getOnduleur_IsEmissionGESConnues() {
        return onduleur_IsEmissionGESConnues;
    }

    public void setOnduleur_IsEmissionGESConnues(Boolean onduleur_IsEmissionGESConnues) {
        this.onduleur_IsEmissionGESConnues = onduleur_IsEmissionGESConnues;
    }

    public Float getOnduleur_EmissionDeGes() {
        return onduleur_EmissionDeGes;
    }

    public void setOnduleur_EmissionDeGes(Float onduleur_EmissionDeGes) {
        this.onduleur_EmissionDeGes = onduleur_EmissionDeGes;
    }

    public Integer getGroupesElectrogenes_Nombre() {
        return groupesElectrogenes_Nombre;
    }

    public void setGroupesElectrogenes_Nombre(Integer groupesElectrogenes_Nombre) {
        this.groupesElectrogenes_Nombre = groupesElectrogenes_Nombre;
    }

    public Float getGroupesElectrogenes_PoidsDuProduit() {
        return groupesElectrogenes_PoidsDuProduit;
    }

    public void setGroupesElectrogenes_PoidsDuProduit(Float groupesElectrogenes_PoidsDuProduit) {
        this.groupesElectrogenes_PoidsDuProduit = groupesElectrogenes_PoidsDuProduit;
    }

    public Integer getGroupesElectrogenes_DureeAmortissement() {
        return groupesElectrogenes_DureeAmortissement;
    }

    public void setGroupesElectrogenes_DureeAmortissement(Integer groupesElectrogenes_DureeAmortissement) {
        this.groupesElectrogenes_DureeAmortissement = groupesElectrogenes_DureeAmortissement;
    }

    public Boolean getGroupesElectrogenes_IsEmissionConnue() {
        return groupesElectrogenes_IsEmissionConnue;
    }

    public void setGroupesElectrogenes_IsEmissionConnue(Boolean groupesElectrogenes_IsEmissionConnue) {
        this.groupesElectrogenes_IsEmissionConnue = groupesElectrogenes_IsEmissionConnue;
    }

    public Float getGroupesElectrogenes_EmissionReelle() {
        return groupesElectrogenes_EmissionReelle;
    }

    public void setGroupesElectrogenes_EmissionReelle(Float groupesElectrogenes_EmissionReelle) {
        this.groupesElectrogenes_EmissionReelle = groupesElectrogenes_EmissionReelle;
    }

    public Integer getMoteurElectrique_Nombre() {
        return moteurElectrique_Nombre;
    }

    public void setMoteurElectrique_Nombre(Integer moteurElectrique_Nombre) {
        this.moteurElectrique_Nombre = moteurElectrique_Nombre;
    }

    public Float getMoteurElectrique_PoidsDuProduit() {
        return moteurElectrique_PoidsDuProduit;
    }

    public void setMoteurElectrique_PoidsDuProduit(Float moteurElectrique_PoidsDuProduit) {
        this.moteurElectrique_PoidsDuProduit = moteurElectrique_PoidsDuProduit;
    }

    public Integer getMoteurElectrique_DureeAmortissement() {
        return moteurElectrique_DureeAmortissement;
    }

    public void setMoteurElectrique_DureeAmortissement(Integer moteurElectrique_DureeAmortissement) {
        this.moteurElectrique_DureeAmortissement = moteurElectrique_DureeAmortissement;
    }

    public Boolean getMoteurElectrique_IsEmissionConnue() {
        return moteurElectrique_IsEmissionConnue;
    }

    public void setMoteurElectrique_IsEmissionConnue(Boolean moteurElectrique_IsEmissionConnue) {
        this.moteurElectrique_IsEmissionConnue = moteurElectrique_IsEmissionConnue;
    }

    public Float getMoteurElectrique_EmissionReelle() {
        return moteurElectrique_EmissionReelle;
    }

    public void setMoteurElectrique_EmissionReelle(Float moteurElectrique_EmissionReelle) {
        this.moteurElectrique_EmissionReelle = moteurElectrique_EmissionReelle;
    }

    public Integer getAutresMachinesKg_Nombre() {
        return autresMachinesKg_Nombre;
    }

    public void setAutresMachinesKg_Nombre(Integer autresMachinesKg_Nombre) {
        this.autresMachinesKg_Nombre = autresMachinesKg_Nombre;
    }

    public Float getAutresMachinesKg_PoidsDuProduit() {
        return autresMachinesKg_PoidsDuProduit;
    }

    public void setAutresMachinesKg_PoidsDuProduit(Float autresMachinesKg_PoidsDuProduit) {
        this.autresMachinesKg_PoidsDuProduit = autresMachinesKg_PoidsDuProduit;
    }

    public Integer getAutresMachinesKg_DureeAmortissement() {
        return autresMachinesKg_DureeAmortissement;
    }

    public void setAutresMachinesKg_DureeAmortissement(Integer autresMachinesKg_DureeAmortissement) {
        this.autresMachinesKg_DureeAmortissement = autresMachinesKg_DureeAmortissement;
    }

    public Boolean getAutresMachinesKg_IsEmissionConnue() {
        return autresMachinesKg_IsEmissionConnue;
    }

    public void setAutresMachinesKg_IsEmissionConnue(Boolean autresMachinesKg_IsEmissionConnue) {
        this.autresMachinesKg_IsEmissionConnue = autresMachinesKg_IsEmissionConnue;
    }

    public Float getAutresMachinesKg_EmissionReelle() {
        return autresMachinesKg_EmissionReelle;
    }

    public void setAutresMachinesKg_EmissionReelle(Float autresMachinesKg_EmissionReelle) {
        this.autresMachinesKg_EmissionReelle = autresMachinesKg_EmissionReelle;
    }

    public Integer getAutresMachinesEur_Nombre() {
        return autresMachinesEur_Nombre;
    }

    public void setAutresMachinesEur_Nombre(Integer autresMachinesEur_Nombre) {
        this.autresMachinesEur_Nombre = autresMachinesEur_Nombre;
    }

    public Float getAutresMachinesEur_PoidsDuProduit() {
        return autresMachinesEur_PoidsDuProduit;
    }

    public void setAutresMachinesEur_PoidsDuProduit(Float autresMachinesEur_PoidsDuProduit) {
        this.autresMachinesEur_PoidsDuProduit = autresMachinesEur_PoidsDuProduit;
    }

    public Integer getAutresMachinesEur_DureeAmortissement() {
        return autresMachinesEur_DureeAmortissement;
    }

    public void setAutresMachinesEur_DureeAmortissement(Integer autresMachinesEur_DureeAmortissement) {
        this.autresMachinesEur_DureeAmortissement = autresMachinesEur_DureeAmortissement;
    }

    public Boolean getAutresMachinesEur_IsEmissionConnue() {
        return autresMachinesEur_IsEmissionConnue;
    }

    public void setAutresMachinesEur_IsEmissionConnue(Boolean autresMachinesEur_IsEmissionConnue) {
        this.autresMachinesEur_IsEmissionConnue = autresMachinesEur_IsEmissionConnue;
    }

    public Float getAutresMachinesEur_EmissionReelle() {
        return autresMachinesEur_EmissionReelle;
    }

    public void setAutresMachinesEur_EmissionReelle(Float autresMachinesEur_EmissionReelle) {
        this.autresMachinesEur_EmissionReelle = autresMachinesEur_EmissionReelle;
    }

    
}
