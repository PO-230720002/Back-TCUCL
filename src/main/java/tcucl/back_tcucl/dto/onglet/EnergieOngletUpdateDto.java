package tcucl.back_tcucl.dto.onglet;

import com.fasterxml.jackson.annotation.JsonInclude;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_NomReseauVille;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteBois;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteFioul;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteGaz;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnergieOngletUpdateDto {
    private Boolean estTermine;
    private Float consoGaz;
    private Float consoFioul;
    private Float consoBois;
    private Float consoReseauVille;
    private Float consoElecChauffage;
    private Float consoElecSpecifique;
    private Float consoEau;
    private String note;
    private EnumEnergie_NomReseauVille nomReseauVille;
    private EnumEnergie_UniteBois uniteBois;
    private EnumEnergie_UniteFioul uniteFioul;
    private EnumEnergie_UniteGaz uniteGaz;


    public Boolean getEstTermine() {
        return estTermine;
    }

    public void setEstTermine(Boolean estTermine) {
        this.estTermine = estTermine;
    }

    public Float getConsoGaz() {
        return consoGaz;
    }

    public void setConsoGaz(Float consoGaz) {
        this.consoGaz = consoGaz;
    }

    public Float getConsoFioul() {
        return consoFioul;
    }

    public void setConsoFioul(Float consoFioul) {
        this.consoFioul = consoFioul;
    }

    public Float getConsoBois() {
        return consoBois;
    }

    public void setConsoBois(Float consoBois) {
        this.consoBois = consoBois;
    }

    public Float getConsoReseauVille() {
        return consoReseauVille;
    }

    public void setConsoReseauVille(Float consoReseauVille) {
        this.consoReseauVille = consoReseauVille;
    }

    public Float getConsoElecChauffage() {
        return consoElecChauffage;
    }

    public void setConsoElecChauffage(Float consoElecChauffage) {
        this.consoElecChauffage = consoElecChauffage;
    }

    public Float getConsoElecSpecifique() {
        return consoElecSpecifique;
    }

    public void setConsoElecSpecifique(Float consoElecSpecifique) {
        this.consoElecSpecifique = consoElecSpecifique;
    }

    public Float getConsoEau() {
        return consoEau;
    }

    public void setConsoEau(Float consoEau) {
        this.consoEau = consoEau;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public EnumEnergie_NomReseauVille getNomReseauVille() {
        return nomReseauVille;
    }

    public void setNomReseauVille(EnumEnergie_NomReseauVille nomReseauVille) {
        this.nomReseauVille = nomReseauVille;
    }

    public EnumEnergie_UniteBois getUniteBois() {
        return uniteBois;
    }

    public void setUniteBois(EnumEnergie_UniteBois uniteBois) {
        this.uniteBois = uniteBois;
    }

    public EnumEnergie_UniteFioul getUniteFioul() {
        return uniteFioul;
    }

    public void setUniteFioul(EnumEnergie_UniteFioul uniteFioul) {
        this.uniteFioul = uniteFioul;
    }

    public EnumEnergie_UniteGaz getUniteGaz() {
        return uniteGaz;
    }

    public void setUniteGaz(EnumEnergie_UniteGaz uniteGaz) {
        this.uniteGaz = uniteGaz;
    }
}