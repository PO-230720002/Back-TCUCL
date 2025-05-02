package tcucl.back_tcucl.entity.parametre.parkingVoirie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import tcucl.back_tcucl.entity.onglet.ParkingVoirieOnglet;
import tcucl.back_tcucl.entity.parametre.batiment.enums.EnumBatiment_TypeBatiment;
import tcucl.back_tcucl.entity.parametre.batiment.enums.EnumBatiment_TypeStructure;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "parking_voirie")
public class ParkingVoirie {
    @Id
    private Long id;

    private String nomOuAdresse;
    private Date dateConstruction;
    private Boolean emissionsGesConnues;
    private Float emissionsGesReelles; // en TCO2e/an
    private Integer valeurEnumType; // Enum correspondant au type de bâtiment
    private Float nombreM2;
    private Integer valeurEnumTypeStructure;

    @ManyToMany(mappedBy = "parkingVoirieList")
    private List<ParkingVoirieOnglet> parkingVoirieOnglets;

    @AssertTrue(message = "Incohérence dans les émissions de GES et les types")
    public boolean isValidEmissionsAndTypes() {
        if (Boolean.TRUE.equals(emissionsGesConnues)) {
            // Si emissionsGesConnues est vrai, les types doivent être vides ou nuls
            return valeurEnumType == null && valeurEnumTypeStructure == null;
        } else {
            // Si emissionsGesConnues est faux, emissionsGesReelles doit être vide ou nul
            return emissionsGesReelles == null;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setType(EnumBatiment_TypeBatiment valeur) {
        this.valeurEnumType = valeur.getCode();
    }

    public EnumBatiment_TypeBatiment getType() {
        return EnumBatiment_TypeBatiment.fromCode(this.valeurEnumType);
    }

    public void setTypeStructure(EnumBatiment_TypeStructure valeur) {
        this.valeurEnumTypeStructure = valeur.getCode();
    }

    public EnumBatiment_TypeStructure getTypeStructure() {
        return EnumBatiment_TypeStructure.fromCode(this.valeurEnumTypeStructure);
    }

}
