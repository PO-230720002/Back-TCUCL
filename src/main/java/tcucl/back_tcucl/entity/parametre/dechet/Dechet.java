package tcucl.back_tcucl.entity.parametre.dechet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import tcucl.back_tcucl.entity.parametre.dechet.enums.EnumDechet_Traitement;

@Entity
@Table(name = "dechet")
public class Dechet {

    @Id
    private Long id;

    private int valeurEnumTraitement;
    private int QuantiteTonne;

    public int getQuantiteTonne() {

        return QuantiteTonne;
    }

    public void setQuantiteTonne(int quantiteTonne) {
        QuantiteTonne = quantiteTonne;
    }

    public void setTraitement(EnumDechet_Traitement valeur) {
        this.valeurEnumTraitement = valeur.getCode();
    }

    public EnumDechet_Traitement getTraitement() {
        return EnumDechet_Traitement.fromCode(this.valeurEnumTraitement);
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
