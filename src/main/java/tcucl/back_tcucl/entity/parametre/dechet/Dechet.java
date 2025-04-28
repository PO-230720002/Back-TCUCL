package tcucl.back_tcucl.entity.parametre.dechet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import tcucl.back_tcucl.entity.parametre.dechet.enums.EnumDechet_Traitement;

@Entity
@Table(name = "dechet")
public class Dechet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int valeurEnumTraitement;
    private int quantiteTonne;

    public int getQuantiteTonne() {
        return quantiteTonne;
    }

    public void setQuantiteTonne(int quantiteTonne) {
        this.quantiteTonne = quantiteTonne;
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
