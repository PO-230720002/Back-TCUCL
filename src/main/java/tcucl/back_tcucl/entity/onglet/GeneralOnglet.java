package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;

@Entity
@Table(name = "general_onglet")
public class GeneralOnglet extends Onglet{

    private Integer nbSalarie;
    private Integer nbEtudiant;

    public GeneralOnglet(){
        super();
        this.nbSalarie = 0;
        this.nbEtudiant = 0;
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

    @Override
    public String getNote() {
        return super.getNote();
    }

    @Override
    public void setNote(String note) {
        super.setNote(note);
    }

    @Override
    public Boolean isEstTermine() {
        return super.isEstTermine();
    }

    @Override
    public void setEstTermine(Boolean estTermine) {
        super.setEstTermine(estTermine);
    }
}
