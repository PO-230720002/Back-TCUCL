package tcucl.back_tcucl.entity.onglet.achat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "achat_consommable")
public class AchatConsommable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Float papier_T = 0f;
    private Float papier_nb = 0f;
    private Float livres_T = 0f;
    private Float livres_nb = 0f;
    private Float cartonNeuf_T = 0f;
    private Float cartonRecycle_T = 0f;
    private Float petitesFournitures_Eur = 0f;
    private Float nbFeuillesImprimeesJetEncre_Nb = 0f;
    private Float nbFeuillesImprimeesToner_Nb = 0f;
    private Float produitsPharmaceutiques_Eur = 0f;

    public AchatConsommable() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
