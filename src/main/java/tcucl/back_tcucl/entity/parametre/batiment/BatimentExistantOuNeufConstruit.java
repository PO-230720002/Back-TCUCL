package tcucl.back_tcucl.entity.parametre.batiment;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import tcucl.back_tcucl.entity.onglet.BatimentImmobilisationMobilierOnglet;
import tcucl.back_tcucl.entity.parametre.batiment.enums.EnumBatiment_TypeBatiment;
import tcucl.back_tcucl.entity.parametre.batiment.enums.EnumBatiment_TypeStructure;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "batiment_existant_ou_neuf_construit")
public class BatimentExistantOuNeufConstruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom_ou_adresse;
    private LocalDate dateConstruction;
    private LocalDate dateDerniereGrosseRenovation;
    private Boolean aCompleter;
    private Boolean acvBâtimentRealisee;
    private Float emissionsGesReellesTCO2;
    private Integer valeurEnumTypeBatiment;
    private Float surfaceEnM2;
    private Integer valeurEnumTypeStructure;

    @ManyToMany(mappedBy = "batimentExistantOuNeufConstruits")
    private List<BatimentImmobilisationMobilierOnglet> batimentOnglets;

    // Getters et Setters

    @AssertTrue(message = "Les règles de validation pour les attributs ne sont pas respectées")
    public boolean isValid() {
        // Si acvBâtimentRealisee est true, valeurEnumTypeBatiment et valeurEnumTypeStructure doivent être null ou vides (0)
        if (Boolean.TRUE.equals(acvBâtimentRealisee)) {
            return (valeurEnumTypeBatiment == null || valeurEnumTypeBatiment == 0) &&
                    (valeurEnumTypeStructure == null || valeurEnumTypeStructure == 0);
        }
        // Si acvBâtimentRealisee est false, emissionsGesReelles doit être null ou vide (0.0)
        if (Boolean.FALSE.equals(acvBâtimentRealisee)) {
            return emissionsGesReellesTCO2 == null || emissionsGesReellesTCO2 == 0.0f;
        }
        return true; // Si aucune des conditions ne s'applique, la validation est réussie
    }


    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_ou_adresse() {
        return nom_ou_adresse;
    }

    public void setNom_ou_adresse(String nom) {
        this.nom_ou_adresse = nom;
    }


    public LocalDate getDateConstruction() {
        return dateConstruction;
    }

    public void setDateConstruction(LocalDate dateConstruction) {
        this.dateConstruction = dateConstruction;
    }

    public LocalDate getDateDerniereGrosseRenovation() {
        return dateDerniereGrosseRenovation;
    }

    public void setDateDerniereGrosseRenovation(LocalDate dateDerniereGrosseRenovation) {
        this.dateDerniereGrosseRenovation = dateDerniereGrosseRenovation;
    }

    public Boolean getACompleter() {
        return aCompleter;
    }

    public void setACompleter(Boolean aCompleter) {
        this.aCompleter = aCompleter;
    }

    public Boolean getAcvBâtimentRealisee() {
        return acvBâtimentRealisee;
    }

    public void setAcvBâtimentRealisee(Boolean acvBâtimentRealisee) {
        this.acvBâtimentRealisee = acvBâtimentRealisee;
    }

    public Float getEmissionsGesReellesTCO2() {
        return emissionsGesReellesTCO2;
    }

    public void setEmissionsGesReellesTCO2(Float emissionsGesReelles) {
        this.emissionsGesReellesTCO2 = emissionsGesReelles;
    }


    public void setTypeBatiment(EnumBatiment_TypeBatiment valeur) {
        this.valeurEnumTypeBatiment = valeur.getCode();
    }

    public EnumBatiment_TypeBatiment getTypeBatiment() {
        return EnumBatiment_TypeBatiment.fromCode(this.valeurEnumTypeBatiment);
    }

    public Float getSurfaceEnM2() {
        return surfaceEnM2;
    }

    public void setSurfaceEnM2(Float surfaceEnM2) {
        this.surfaceEnM2 = surfaceEnM2;
    }

    public void setTypeStructure(EnumBatiment_TypeStructure valeur) {
        this.valeurEnumTypeStructure = valeur.getCode();
    }

    public EnumBatiment_TypeStructure getTypeStructure() {
        return EnumBatiment_TypeStructure.fromCode(this.valeurEnumTypeStructure);
    }

}
