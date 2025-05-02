package tcucl.back_tcucl.dto.onglet.mobInternational;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import tcucl.back_tcucl.entity.onglet.MobInternationalOnglet;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MobInternationalOngletDto {

    private Long id;
    private Boolean estTermine;
    private String note;
    private List<VoyageVersUneDestinationMobInternationaleDto> voyageVersUneDestinationMobInternationale;

    public MobInternationalOngletDto() {}

    public MobInternationalOngletDto(MobInternationalOnglet entity) {
        this.id = entity.getId();
        this.estTermine = entity.isEstTermine();
        this.note = entity.getNote();

        if (entity.getVoyageVersUneDestinationMobInternationale() != null) {
            this.voyageVersUneDestinationMobInternationale = entity.getVoyageVersUneDestinationMobInternationale().stream()
                    .map(VoyageVersUneDestinationMobInternationaleDto::new)
                    .collect(Collectors.toList());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEstTermine() {
        return estTermine;
    }

    public void setEstTermine(Boolean estTermine) {
        this.estTermine = estTermine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<VoyageVersUneDestinationMobInternationaleDto> getVoyageVersUneDestinationMobInternationale() {
        return voyageVersUneDestinationMobInternationale;
    }

    public void setVoyageVersUneDestinationMobInternationale(List<VoyageVersUneDestinationMobInternationaleDto> voyageVersUneDestinationMobInternationale) {
        this.voyageVersUneDestinationMobInternationale = voyageVersUneDestinationMobInternationale;
    }

}
