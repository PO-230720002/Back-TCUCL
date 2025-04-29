package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_NomReseauVille;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteBois;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteFioul;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteGaz;

@Entity
@Table(name = "energie_onglet")
public class EnergieOnglet extends Onglet {

    private Float ConsoGaz;
    private Float ConsoFioul;
    private Float ConsoBois;
    private Float ConsoReseauVille;
    private Float ConsoElecChauffage;
    private Float ConsoElecSpecifique;
    private Float ConsoEau;
    // valeur stockée en base = code de l'enum,
    // valeur affichée par get = 1 valeur de l'enum
    // valeur à setter = 1 valeur de l'enum
    private Integer valeurEnumEnergieReseauVille;
    private Integer valeurEnumEnergieUniteBois;
    private Integer valeurEnumEnergieUniteFioul;
    private Integer valeurEnumEnergieUniteGaz;

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

    public EnumEnergie_NomReseauVille getNomReseauVille() {
        return EnumEnergie_NomReseauVille.fromCode(this.valeurEnumEnergieReseauVille);
    }

    public void setNomReseauVille(EnumEnergie_NomReseauVille valeur) {
        this.valeurEnumEnergieReseauVille = valeur.getCode();
    }

    public EnumEnergie_UniteBois getUniteBois() {
        return EnumEnergie_UniteBois.fromCode(valeurEnumEnergieUniteBois);
    }

    public void setUniteBois(EnumEnergie_UniteBois valeur) {
        this.valeurEnumEnergieUniteBois = valeur.getCode();
    }

    public EnumEnergie_UniteFioul getUniteFioul() {
        return EnumEnergie_UniteFioul.fromCode(valeurEnumEnergieUniteFioul);
    }

    public void setUniteFioul(EnumEnergie_UniteFioul valeur) {
        this.valeurEnumEnergieUniteFioul = valeur.getCode();
    }

    public EnumEnergie_UniteGaz getUniteGaz() {
        return EnumEnergie_UniteGaz.fromCode(valeurEnumEnergieUniteGaz);
    }

    public void setUniteGaz(EnumEnergie_UniteGaz valeur) {
        this.valeurEnumEnergieUniteGaz = valeur.getCode();
    }


    @Override
    public String getNote() {
        return super.getNote();
    }

    @Override
    public void setNote(String note) {
        super.setNote(note);
    }

    @Override
    public boolean isEstTermine() {
        return super.isEstTermine();
    }

    @Override
    public void setEstTermine(boolean estTermine) {
        super.setEstTermine(estTermine);
    }
}
