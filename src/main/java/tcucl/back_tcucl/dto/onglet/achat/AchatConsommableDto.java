package tcucl.back_tcucl.dto.onglet.achat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import tcucl.back_tcucl.entity.onglet.achat.AchatConsommable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AchatConsommableDto {

    private Long id;

    private Float papier_T;
    private Float papier_nb;
    private Float livres_T;
    private Float livres_nb;
    private Float cartonNeuf_T;
    private Float cartonRecycle_T;
    private Float petitesFournitures_Eur;
    private Float nbFeuillesImprimeesJetEncre_Nb;
    private Float nbFeuillesImprimeesToner_Nb;
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

    public Float getPapier_T() {
        return papier_T;
    }

    public void setPapier_T(Float papier_T) {
        this.papier_T = papier_T;
    }

    public Float getPapier_nb() {
        return papier_nb;
    }

    public void setPapier_nb(Float papier_nb) {
        this.papier_nb = papier_nb;
    }

    public Float getLivres_T() {
        return livres_T;
    }

    public void setLivres_T(Float livres_T) {
        this.livres_T = livres_T;
    }

    public Float getLivres_nb() {
        return livres_nb;
    }

    public void setLivres_nb(Float livres_nb) {
        this.livres_nb = livres_nb;
    }

    public Float getCartonNeuf_T() {
        return cartonNeuf_T;
    }

    public void setCartonNeuf_T(Float cartonNeuf_T) {
        this.cartonNeuf_T = cartonNeuf_T;
    }

    public Float getCartonRecycle_T() {
        return cartonRecycle_T;
    }

    public void setCartonRecycle_T(Float cartonRecycle_T) {
        this.cartonRecycle_T = cartonRecycle_T;
    }

    public Float getPetitesFournitures_Eur() {
        return petitesFournitures_Eur;
    }

    public void setPetitesFournitures_Eur(Float petitesFournitures_Eur) {
        this.petitesFournitures_Eur = petitesFournitures_Eur;
    }

    public Float getNbFeuillesImprimeesJetEncre_Nb() {
        return nbFeuillesImprimeesJetEncre_Nb;
    }

    public void setNbFeuillesImprimeesJetEncre_Nb(Float nbFeuillesImprimeesJetEncre_Nb) {
        this.nbFeuillesImprimeesJetEncre_Nb = nbFeuillesImprimeesJetEncre_Nb;
    }

    public Float getNbFeuillesImprimeesToner_Nb() {
        return nbFeuillesImprimeesToner_Nb;
    }

    public void setNbFeuillesImprimeesToner_Nb(Float nbFeuillesImprimeesToner_Nb) {
        this.nbFeuillesImprimeesToner_Nb = nbFeuillesImprimeesToner_Nb;
    }

    public Float getProduitsPharmaceutiques_Eur() {
        return produitsPharmaceutiques_Eur;
    }

    public void setProduitsPharmaceutiques_Eur(Float produitsPharmaceutiques_Eur) {
        this.produitsPharmaceutiques_Eur = produitsPharmaceutiques_Eur;
    }
}
