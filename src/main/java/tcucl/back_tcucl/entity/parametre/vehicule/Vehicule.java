package tcucl.back_tcucl.entity.parametre.vehicule;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.onglet.VehiculeOnglet;
import tcucl.back_tcucl.entity.parametre.vehicule.enums.EnumVehicule_Type;

import java.util.List;


@Entity
@Table(name = "vehicule")
public class Vehicule {


    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String modeleOuImmatriculation;
    private Integer valeurEnumTypeVehicule;
    private Integer nombreVehiculesIdentiques;
    private Float nombreKilometresParVoitureMoyen;

    @ManyToMany(mappedBy = "vehiculeList")
    private List<VehiculeOnglet> vehiculeOnglets;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getModeleOuImmatriculation() {
        return modeleOuImmatriculation;
    }

    public void setModeleOuImmatriculation(String modeleOuImmatriculation) {
        this.modeleOuImmatriculation = modeleOuImmatriculation;
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

    // Getter et Setter pour EnumVehicule_Type
    public void setTypeVehicule(EnumVehicule_Type valeur) {
        this.valeurEnumTypeVehicule = (valeur != null) ? valeur.getCode() : null;
    }

    public EnumVehicule_Type getTypeVehicule() {
        return (valeurEnumTypeVehicule != null) ? EnumVehicule_Type.fromCode(valeurEnumTypeVehicule) : null;
    }

}
