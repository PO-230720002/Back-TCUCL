package tcucl.back_tcucl.entity.onglet.batiment;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import tcucl.back_tcucl.entity.onglet.batiment.enums.EnumBatiment_TypeBatiment;
import tcucl.back_tcucl.entity.onglet.batiment.enums.EnumBatiment_TypeStructure;
import tcucl.back_tcucl.entity.onglet.batiment.enums.EnumBatiment_TypeTravaux;

import java.time.LocalDate;

@Entity
@Table(name = "entretien_courant")
public class EntretienCourant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateAjout;
    private String nom_adresse;
    private Integer valeurEnumTypeTravaux;
    private LocalDate dateTravaux;
    private Boolean acvRenovationRealisee;
    private Float emissionsGesReellesTCO2; // en TCO2e
    private Integer valeurEnumTypeBatiment;
    private Float surfaceConcernee;
    private Integer dureeAmortissement;

    @AssertTrue(message = "Le type de bâtiment doit être vide ou 'NA' si une ACV rénovation est réalisée.")
    public Boolean assertTypeBatimentVideSiAcv() {
        if (Boolean.TRUE.equals(acvRenovationRealisee)) {
            return valeurEnumTypeBatiment == null
                    || valeurEnumTypeBatiment == 0
                    || valeurEnumTypeBatiment.equals(EnumBatiment_TypeStructure.NA.getCode());
        }
        return true;
    }
    @AssertTrue(message = "La surface concernée doit être vide ou 0 si une ACV rénovation est réalisée.")
    public Boolean assertSurfaceVideSiAcv() {
        if (Boolean.TRUE.equals(acvRenovationRealisee)) {
            return surfaceConcernee == null || surfaceConcernee == 0;
        }
        return true;
    }
    @AssertTrue(message = "Les émissions GES réelles doivent être nulles ou 0 si aucune ACV rénovation n'est réalisée.")
    public Boolean assertEmissionVideSiPasAcv() {
        if (Boolean.FALSE.equals(acvRenovationRealisee)) {
            return emissionsGesReellesTCO2 == null || emissionsGesReellesTCO2 == 0;
        }
        return true;
    }
    @AssertTrue(message = "L'information sur la réalisation d'une ACV rénovation doit être renseignée.")
    public Boolean assertAcvRenseignee() {
        return acvRenovationRealisee != null;
    }



    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getNom_adresse() {
        return nom_adresse;
    }

    public void setNom_adresse(String nom_adresse) {
        this.nom_adresse = nom_adresse;
    }

    public LocalDate getDateTravaux() {
        return dateTravaux;
    }

    public void setDateTravaux(LocalDate dateTravaux) {
        this.dateTravaux = dateTravaux;
    }

    public Boolean getAcvRenovationRealisee() {
        return acvRenovationRealisee;
    }

    public void setAcvRenovationRealisee(Boolean acvRenovationRealisee) {
        this.acvRenovationRealisee = acvRenovationRealisee;
    }

    public Float getEmissionsGesReellesTCO2() {
        return emissionsGesReellesTCO2;
    }

    public void setEmissionsGesReellesTCO2(Float emissionsGesReelles) {
        this.emissionsGesReellesTCO2 = emissionsGesReelles;
    }


    public Float getSurfaceConcernee() {
        return surfaceConcernee;
    }

    public void setSurfaceConcernee(Float surfaceConcernee) {
        this.surfaceConcernee = surfaceConcernee;
    }

    public Integer getDureeAmortissement() {
        return dureeAmortissement;
    }

    public void setDureeAmortissement(Integer dureeAmortissement) {
        this.dureeAmortissement = dureeAmortissement;
    }


    public void setTypeTravaux(EnumBatiment_TypeTravaux valeur) {
        this.valeurEnumTypeTravaux = valeur.getCode();
    }

    public EnumBatiment_TypeTravaux getTypeTravaux() {
        return this.valeurEnumTypeTravaux != null ? EnumBatiment_TypeTravaux.fromCode(this.valeurEnumTypeTravaux) : null;
    }

    public void setTypeBatiment(EnumBatiment_TypeBatiment valeur) {
        this.valeurEnumTypeBatiment = valeur.getCode();
    }

    public EnumBatiment_TypeBatiment getTypeBatiment() {
        return this.valeurEnumTypeBatiment != null ? EnumBatiment_TypeBatiment.fromCode(this.valeurEnumTypeBatiment) : null;
    }

}


