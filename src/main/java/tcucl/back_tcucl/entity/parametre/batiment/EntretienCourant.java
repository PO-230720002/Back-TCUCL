package tcucl.back_tcucl.entity.parametre.batiment;

import jakarta.persistence.*;
import tcucl.back_tcucl.entity.onglet.BatimentImmobilisationMobilierOnglet;
import tcucl.back_tcucl.entity.parametre.batiment.enums.EnumBatiment_TypeBatiment;
import tcucl.back_tcucl.entity.parametre.batiment.enums.EnumBatiment_TypeTravaux;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "entretien_courant")
public class EntretienCourant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateAjout;
    private String nom_adresse;
    private Integer valeurEnumTypeTravaux;
    private LocalDate dateTravaux;
    private Boolean acvRenovationRealisee;
    private Float emissionsGesReellesTCO2; // en TCO2e
    private Integer valeurEnumTypeBatiment;
    private Float surfaceConcernee;
    private Integer dureeAmortissement;

    @ManyToMany(mappedBy = "entretienCourants")
    private List<BatimentImmobilisationMobilierOnglet> batimentOnglets;

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
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
        return EnumBatiment_TypeTravaux.fromCode(this.valeurEnumTypeTravaux);
    }

    public void setTypeBatiment(EnumBatiment_TypeBatiment valeur) {
        this.valeurEnumTypeBatiment = valeur.getCode();
    }

    public EnumBatiment_TypeBatiment getTypeBatiment() {
        return EnumBatiment_TypeBatiment.fromCode(this.valeurEnumTypeBatiment);
    }

}


