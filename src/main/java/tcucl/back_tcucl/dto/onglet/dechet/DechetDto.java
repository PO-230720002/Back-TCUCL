package tcucl.back_tcucl.dto.onglet.dechet;

import tcucl.back_tcucl.entity.parametre.dechet.Dechet;
import tcucl.back_tcucl.entity.parametre.dechet.enums.EnumDechet_Traitement;

public class DechetDto {

    private Long id;
    private EnumDechet_Traitement traitement;
    private Integer quantiteTonne;

    public DechetDto() {
    }

    public DechetDto(Dechet entity) {
        this.id = entity.getId();
        this.traitement = entity.getTraitement();
        this.quantiteTonne = entity.getQuantiteTonne();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumDechet_Traitement getTraitement() {
        return traitement;
    }

    public void setTraitement(EnumDechet_Traitement traitement) {
        this.traitement = traitement;
    }

    public Integer getQuantiteTonne() {
        return quantiteTonne;
    }

    public void setQuantiteTonne(Integer quantiteTonne) {
        this.quantiteTonne = quantiteTonne;
    }
}
