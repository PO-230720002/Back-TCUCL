package tcucl.back_tcucl.entity.onglet.numerique;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import tcucl.back_tcucl.entity.onglet.numerique.enums.EnumNumerique_Equipement;

@Entity
@Table(name = "equipement_numerique")
public class EquipementNumerique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer valeurEnumEquipement;
    private Integer nombre;
    private Integer dureeAmortissement;
    private boolean emissionsGesPrecisesConnues;
    private Float emissionsReellesParProduitKgCO2e;

    @AssertTrue(message = "Si les émissions GES précises ne sont pas connues, les émissions réelles doivent être nulles.")
    private boolean isEmissionsReellesValide() {
        return emissionsGesPrecisesConnues || emissionsReellesParProduitKgCO2e == null;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getDureeAmortissement() {
        return dureeAmortissement;
    }

    public void setDureeAmortissement(int dureeAmortissement) {
        this.dureeAmortissement = dureeAmortissement;
    }

    public boolean isEmissionsGesPrecisesConnues() {
        return emissionsGesPrecisesConnues;
    }

    public void setEmissionsGesPrecisesConnues(boolean emissionsGesPrecisesConnues) {
        this.emissionsGesPrecisesConnues = emissionsGesPrecisesConnues;
    }

    public Float getEmissionsReellesParProduitKgCO2e() {
        return emissionsReellesParProduitKgCO2e;
    }

    public void setEmissionsReellesParProduitKgCO2e(Float emissionsReellesParProduitKgCO2e) {
        this.emissionsReellesParProduitKgCO2e = emissionsReellesParProduitKgCO2e;
    }

    public void setEquipement(EnumNumerique_Equipement valeur) {
        this.valeurEnumEquipement = valeur.getCode();
    }

    public EnumNumerique_Equipement getEquipement() {
        return this.valeurEnumEquipement != null ? EnumNumerique_Equipement.fromCode(this.valeurEnumEquipement) : null;
    }
}
