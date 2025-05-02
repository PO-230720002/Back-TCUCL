package tcucl.back_tcucl.dto.onglet.mobInternational;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import tcucl.back_tcucl.entity.parametre.mobInternationale.VoyageVersUneDestinationMobInternationale;
import tcucl.back_tcucl.entity.parametre.mobInternationale.enums.EnumMobInternationale_NomPays;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoyageVersUneDestinationMobInternationaleDto {

    private Long id;
    private EnumMobInternationale_NomPays nomPays;
    private Integer prosAvion;
    private Integer prosTrain;
    private Integer stagesEtudiantsAvion;
    private Integer stagesEtudiantsTrain;
    private Integer semestresEtudiantsAvion;
    private Integer semestresEtudiantsTrain;

    public VoyageVersUneDestinationMobInternationaleDto() {}

    public VoyageVersUneDestinationMobInternationaleDto(VoyageVersUneDestinationMobInternationale entity) {
        this.id = entity.getId();
        this.nomPays = entity.getNomPays();
        this.prosAvion = entity.getProsAvion();
        this.prosTrain = entity.getProsTrain();
        this.stagesEtudiantsAvion = entity.getStagesEtudiantsAvion();
        this.stagesEtudiantsTrain = entity.getStagesEtudiantsTrain();
        this.semestresEtudiantsAvion = entity.getSemestresEtudiantsAvion();
        this.semestresEtudiantsTrain = entity.getSemestresEtudiantsTrain();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumMobInternationale_NomPays getNomPays() {
        return nomPays;
    }

    public void setNomPays(EnumMobInternationale_NomPays nomPays) {
        this.nomPays = nomPays;
    }

    public Integer getProsAvion() {
        return prosAvion;
    }

    public void setProsAvion(Integer prosAvion) {
        this.prosAvion = prosAvion;
    }

    public Integer getProsTrain() {
        return prosTrain;
    }

    public void setProsTrain(Integer prosTrain) {
        this.prosTrain = prosTrain;
    }

    public Integer getStagesEtudiantsAvion() {
        return stagesEtudiantsAvion;
    }

    public void setStagesEtudiantsAvion(Integer stagesEtudiantsAvion) {
        this.stagesEtudiantsAvion = stagesEtudiantsAvion;
    }

    public Integer getStagesEtudiantsTrain() {
        return stagesEtudiantsTrain;
    }

    public void setStagesEtudiantsTrain(Integer stagesEtudiantsTrain) {
        this.stagesEtudiantsTrain = stagesEtudiantsTrain;
    }

    public Integer getSemestresEtudiantsAvion() {
        return semestresEtudiantsAvion;
    }

    public void setSemestresEtudiantsAvion(Integer semestresEtudiantsAvion) {
        this.semestresEtudiantsAvion = semestresEtudiantsAvion;
    }

    public Integer getSemestresEtudiantsTrain() {
        return semestresEtudiantsTrain;
    }

    public void setSemestresEtudiantsTrain(Integer semestresEtudiantsTrain) {
        this.semestresEtudiantsTrain = semestresEtudiantsTrain;
    }

}
