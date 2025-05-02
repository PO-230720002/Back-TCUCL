package tcucl.back_tcucl.entity.parametre.parkingVoirie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import tcucl.back_tcucl.entity.parametre.batiment.enums.EnumBatiment_TypeBatiment;
import tcucl.back_tcucl.entity.parametre.batiment.enums.EnumBatiment_TypeStructure;
import tcucl.back_tcucl.entity.parametre.parkingVoirie.enums.EnumParkingVoirie_Type;
import tcucl.back_tcucl.entity.parametre.parkingVoirie.enums.EnumParkingVoirie_TypeStructure;

import java.util.Date;

@Entity
@Table(name = "parking_voirie")
public class ParkingVoirie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomOuAdresse;
    private Date dateConstruction;
    private Boolean emissionsGesConnues;
    private Float emissionsGesReelles; // en TCO2e/an
    private Integer valeurEnumType; // Enum correspondant au type de bâtiment
    private Float nombreM2;
    private Integer valeurEnumTypeStructure;
    private Date dateAjoutEnBase;


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

    public void setType(EnumParkingVoirie_Type valeur) {
        this.valeurEnumType = valeur.getCode();
    }

    public EnumParkingVoirie_Type getType() {
        return this.valeurEnumType != null ? EnumParkingVoirie_Type.fromCode(this.valeurEnumType) : null;
    }

    public void setTypeStructure(EnumParkingVoirie_TypeStructure valeur) {
        this.valeurEnumTypeStructure = valeur.getCode();
    }

    public EnumParkingVoirie_TypeStructure getTypeStructure() {
        return this.valeurEnumTypeStructure != null ? EnumParkingVoirie_TypeStructure.fromCode(this.valeurEnumTypeStructure) : null;
    }

    public String getNomOuAdresse() {
        return nomOuAdresse;
    }

    public void setNomOuAdresse(String nomOuAdresse) {
        this.nomOuAdresse = nomOuAdresse;
    }

    public Date getDateConstruction() {
        return dateConstruction;
    }

    public void setDateConstruction(Date dateConstruction) {
        this.dateConstruction = dateConstruction;
    }

    public Boolean getEmissionsGesConnues() {
        return emissionsGesConnues;
    }

    public void setEmissionsGesConnues(Boolean emissionsGesConnues) {
        this.emissionsGesConnues = emissionsGesConnues;
    }

    public Float getEmissionsGesReelles() {
        return emissionsGesReelles;
    }

    public void setEmissionsGesReelles(Float emissionsGesReelles) {
        this.emissionsGesReelles = emissionsGesReelles;
    }

    public Float getNombreM2() {
        return nombreM2;
    }

    public void setNombreM2(Float nombreM2) {
        this.nombreM2 = nombreM2;
    }

    public Date getDateAjoutEnBase() {
        return dateAjoutEnBase;
    }

    public void setDateAjoutEnBase(Date dateAjoutEnBase) {
        this.dateAjoutEnBase = dateAjoutEnBase;
    }
}
