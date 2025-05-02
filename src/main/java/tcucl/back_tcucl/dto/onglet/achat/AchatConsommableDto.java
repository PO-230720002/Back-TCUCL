package tcucl.back_tcucl.dto.onglet.achat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import tcucl.back_tcucl.entity.onglet.achat.AchatConsommable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AchatConsommableDto {

    private Long id;

    private Integer papier_T;
    private Integer papier_nb;
    private Integer livres_T;
    private Integer livres_nb;
    private Integer cartonNeuf_T;
    private Integer cartonRecycle_T;
    private Float petitesFournitures_Eur;
    private Integer nbFeuillesImprimeesJetEncre_Nb;
    private Integer nbFeuillesImprimeesToner_Nb;
    private Float produitsPharmaceutiques_Eur;

    public AchatConsommableDto() {
    }

    public AchatConsommableDto(AchatConsommable entity) {
        this.id = entity.getId();
        this.papier_T = entity.getPapier_T();
        this.papier_nb = entity.getPapier_nb();
        this.livres_T = entity.getLivres_T();
        this.livres_nb = entity.getLivres_nb();
        this.cartonNeuf_T = entity.getCartonNeuf_T();
        this.cartonRecycle_T = entity.getCartonRecycle_T();
        this.petitesFournitures_Eur = entity.getPetitesFournitures_Eur();
        this.nbFeuillesImprimeesJetEncre_Nb = entity.getNbFeuillesImprimeesJetEncre_Nb();
        this.nbFeuillesImprimeesToner_Nb = entity.getNbFeuillesImprimeesToner_Nb();
        this.produitsPharmaceutiques_Eur = entity.getProduitsPharmaceutiques_Eur();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPapier_T() {
        return papier_T;
    }

    public void setPapier_T(Integer papier_T) {
        this.papier_T = papier_T;
    }

    public Integer getPapier_nb() {
        return papier_nb;
    }

    public void setPapier_nb(Integer papier_nb) {
        this.papier_nb = papier_nb;
    }

    public Integer getLivres_T() {
        return livres_T;
    }

    public void setLivres_T(Integer livres_T) {
        this.livres_T = livres_T;
    }

    public Integer getLivres_nb() {
        return livres_nb;
    }

    public void setLivres_nb(Integer livres_nb) {
        this.livres_nb = livres_nb;
    }

    public Integer getCartonNeuf_T() {
        return cartonNeuf_T;
    }

    public void setCartonNeuf_T(Integer cartonNeuf_T) {
        this.cartonNeuf_T = cartonNeuf_T;
    }

    public Integer getCartonRecycle_T() {
        return cartonRecycle_T;
    }

    public void setCartonRecycle_T(Integer cartonRecycle_T) {
        this.cartonRecycle_T = cartonRecycle_T;
    }

    public Float getPetitesFournitures_Eur() {
        return petitesFournitures_Eur;
    }

    public void setPetitesFournitures_Eur(Float petitesFournitures_Eur) {
        this.petitesFournitures_Eur = petitesFournitures_Eur;
    }

    public Integer getNbFeuillesImprimeesJetEncre_Nb() {
        return nbFeuillesImprimeesJetEncre_Nb;
    }

    public void setNbFeuillesImprimeesJetEncre_Nb(Integer nbFeuillesImprimeesJetEncre_Nb) {
        this.nbFeuillesImprimeesJetEncre_Nb = nbFeuillesImprimeesJetEncre_Nb;
    }

    public Integer getNbFeuillesImprimeesToner_Nb() {
        return nbFeuillesImprimeesToner_Nb;
    }

    public void setNbFeuillesImprimeesToner_Nb(Integer nbFeuillesImprimeesToner_Nb) {
        this.nbFeuillesImprimeesToner_Nb = nbFeuillesImprimeesToner_Nb;
    }

    public Float getProduitsPharmaceutiques_Eur() {
        return produitsPharmaceutiques_Eur;
    }

    public void setProduitsPharmaceutiques_Eur(Float produitsPharmaceutiques_Eur) {
        this.produitsPharmaceutiques_Eur = produitsPharmaceutiques_Eur;
    }
}
