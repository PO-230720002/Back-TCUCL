package tcucl.back_tcucl.entity.parametre.emissionFugitive;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import tcucl.back_tcucl.entity.onglet.EmissionFugitiveOnglet;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.enums.EnumEmissionFugitive_TypeFluide;
import tcucl.back_tcucl.entity.parametre.emissionFugitive.enums.EnumEmissionFugitive_TypeMachine;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_NomReseauVille;

import java.util.List;

@Entity
@Table(name = "machine_emission_fugitive")
public class MachineEmissionFugitive {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomMachine;
    private String descriptionMachine;
    private Integer valeurEnumTypeFluide;
    private Float quantiteFluideKg;
    private boolean tauxDeFuiteConnu;
    private Float tauxDeFuite;
    private Integer valeurEnumTypeMachine;

    @ManyToMany(mappedBy = "machinesEmissionFugitive")
    private List<EmissionFugitiveOnglet> emissionFugitiveOnglets;


    @AssertTrue(message = "Les règles de validation ne sont pas respectées.")
    public boolean isValid() {
        if (tauxDeFuiteConnu) {
            // Si tauxDeFuiteConnu est true, valeurEnumTypeMachine doit être vide
            if (valeurEnumTypeMachine != null) {
                return false;
            }
        } else {
            // Si tauxDeFuiteConnu est false, tauxDeFuite doit être vide (null ou 0)
            if (tauxDeFuite != null && tauxDeFuite != 0.0f) {
                return false;
            }
        }
        return true;
    }


    public EnumEmissionFugitive_TypeMachine getTypeMachine() {
        return EnumEmissionFugitive_TypeMachine.fromCode(this.valeurEnumTypeMachine);
    }

    public void setTypeMachine(EnumEmissionFugitive_TypeMachine valeur) {
        this.valeurEnumTypeMachine = valeur.getCode();
    }


    public EnumEmissionFugitive_TypeFluide getTypeFluide() {
        return EnumEmissionFugitive_TypeFluide.fromCode(this.valeurEnumTypeFluide);
    }

    public void setTypeFluide(EnumEmissionFugitive_TypeFluide valeur) {
        this.valeurEnumTypeFluide = valeur.getCode();
    }




    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescriptionMachine() {
        return descriptionMachine;
    }

    public void setDescriptionMachine(String descriptionMachine) {
        this.descriptionMachine = descriptionMachine;
    }

    public String getNomMachine() {
        return nomMachine;
    }

    public void setNomMachine(String nomMachine) {
        this.nomMachine = nomMachine;
    }

    public Float getQuantiteFluideKg() {
        return quantiteFluideKg;
    }

    public void setQuantiteFluideKg(Float quantiteFluideKg) {
        this.quantiteFluideKg = quantiteFluideKg;
    }

    public boolean isTauxDeFuiteConnu() {
        return tauxDeFuiteConnu;
    }

    public void setTauxDeFuiteConnu(boolean tauxDeFuiteConnu) {
        this.tauxDeFuiteConnu = tauxDeFuiteConnu;
    }

    public Float getTauxDeFuite() {
        return tauxDeFuite;
    }

    public void setTauxDeFuite(Float tauxDeFuite) {
        this.tauxDeFuite = tauxDeFuite;
    }
}
