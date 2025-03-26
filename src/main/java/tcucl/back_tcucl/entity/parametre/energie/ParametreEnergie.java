package tcucl.back_tcucl.entity.parametre.energie;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_NomReseauVille;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteBois;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteFioul;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteGaz;

@Entity
@Table(name = "parametre_energie")
public class ParametreEnergie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // valeur stockée en base = code de l'enum,
    // valeur affichée par get = 1 valeur de l'enum
    // valeur à setter = 1 valeur de l'enum
    private Integer valeurEnumEnergieReseauVille;
    private Integer valeurEnumEnergieUniteBois;
    private Integer valeurEnumEnergieUniteFioul;
    private Integer valeurEnumEnergieUniteGaz;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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


}
