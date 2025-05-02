package tcucl.back_tcucl.dto.onglet.vehicule;

import tcucl.back_tcucl.entity.parametre.vehicule.Vehicule;
import tcucl.back_tcucl.entity.parametre.vehicule.enums.EnumVehicule_Type;

import java.util.Date;

public class VehiculeDto {

    private Long id;
    private String modeleOuImmatriculation;
    private EnumVehicule_Type typeVehicule;
    private Integer nombreVehiculesIdentiques;
    private Float nombreKilometresParVoitureMoyen;
    private Date dateAjoutEnBase;

    public VehiculeDto() {
    }

    public VehiculeDto(Vehicule entity) {
        this.id = entity.getId();
        this.modeleOuImmatriculation = entity.getModeleOuImmatriculation();
        this.typeVehicule = entity.getTypeVehicule();
        this.nombreVehiculesIdentiques = entity.getNombreVehiculesIdentiques();
        this.nombreKilometresParVoitureMoyen = entity.getNombreKilometresParVoitureMoyen();
        this.dateAjoutEnBase = entity.getDateAjoutEnBase();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModeleOuImmatriculation() {
        return modeleOuImmatriculation;
    }

    public void setModeleOuImmatriculation(String modeleOuImmatriculation) {
        this.modeleOuImmatriculation = modeleOuImmatriculation;
    }

    public EnumVehicule_Type getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(EnumVehicule_Type typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public Integer getNombreVehiculesIdentiques() {
        return nombreVehiculesIdentiques;
    }

    public void setNombreVehiculesIdentiques(Integer nombreVehiculesIdentiques) {
        this.nombreVehiculesIdentiques = nombreVehiculesIdentiques;
    }

    public Float getNombreKilometresParVoitureMoyen() {
        return nombreKilometresParVoitureMoyen;
    }

    public void setNombreKilometresParVoitureMoyen(Float nombreKilometresParVoitureMoyen) {
        this.nombreKilometresParVoitureMoyen = nombreKilometresParVoitureMoyen;
    }

    public Date getDateAjoutEnBase() {
        return dateAjoutEnBase;
    }

    public void setDateAjoutEnBase(Date dateAjoutEnBase) {
        this.dateAjoutEnBase = dateAjoutEnBase;
    }
}
