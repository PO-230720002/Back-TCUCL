package tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import tcucl.back_tcucl.entity.onglet.batiment.MobilierElectromenager;
import tcucl.back_tcucl.entity.onglet.batiment.enums.EnumBatiment_Mobilier;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MobilierElectromenagerDto {

    private Long id;
    private Date dateAjout;
    private EnumBatiment_Mobilier mobilier;
    private Integer quantite;
    private Float poidsDuProduit;
    private Integer dureeAmortissement;
    private Boolean emissionGesPrecisesConnues;
    private Float emissionsGesReelleskgCO2;

    public MobilierElectromenagerDto() {
    }

    public MobilierElectromenagerDto(MobilierElectromenager entity) {
        this.id = entity.getId();
        this.dateAjout = entity.getDateAjout();
        this.mobilier = entity.getMobilier();
        this.quantite = entity.getQuantite();
        this.poidsDuProduit = entity.getPoidsDuProduit();
        this.dureeAmortissement = entity.getDureeAmortissement();
        this.emissionGesPrecisesConnues = entity.isEmissionGesPrecisesConnues();
        this.emissionsGesReelleskgCO2 = entity.getEmissionsGesReelleskgCO2();
    }

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

    public EnumBatiment_Mobilier getMobilier() {
        return mobilier;
    }

    public void setMobilier(EnumBatiment_Mobilier mobilier) {
        this.mobilier = mobilier;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Float getPoidsDuProduit() {
        return poidsDuProduit;
    }

    public void setPoidsDuProduit(Float poidsDuProduit) {
        this.poidsDuProduit = poidsDuProduit;
    }

    public Integer getDureeAmortissement() {
        return dureeAmortissement;
    }

    public void setDureeAmortissement(Integer dureeAmortissement) {
        this.dureeAmortissement = dureeAmortissement;
    }

    public Boolean getEmissionGesPrecisesConnues() {
        return emissionGesPrecisesConnues;
    }

    public void setEmissionGesPrecisesConnues(Boolean emissionGesPrecisesConnues) {
        this.emissionGesPrecisesConnues = emissionGesPrecisesConnues;
    }

    public Float getEmissionsGesReelleskgCO2() {
        return emissionsGesReelleskgCO2;
    }

    public void setEmissionsGesReelleskgCO2(Float emissionsGesReelleskgCO2) {
        this.emissionsGesReelleskgCO2 = emissionsGesReelleskgCO2;
    }
}
