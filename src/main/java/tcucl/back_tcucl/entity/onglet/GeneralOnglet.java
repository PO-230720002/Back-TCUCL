package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GeneralOnglet extends Onglet{

    private Integer nbSalarie;
    private Integer nbEtudiant;

    public GeneralOnglet(){;
    }

    public Integer getNbSalarie() {
        return nbSalarie;
    }

    public void setNbSalarie(Integer nbSalarie) {
        this.nbSalarie = nbSalarie;
    }

    public Integer getNbEtudiant() {
        return nbEtudiant;
    }

    public void setNbEtudiant(Integer nbEtudiant) {
        this.nbEtudiant = nbEtudiant;
    }
}
