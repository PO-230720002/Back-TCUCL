package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import tcucl.back_tcucl.entity.parametre.numerique.EquipementNumerique;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "numerique_onglet")
public class NumeriqueOnglet extends Onglet{


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "equipement_numerique_id")
    List<EquipementNumerique> equipementNumeriqueList;

    private boolean useMethodSimplifiee;
    private Float TraficCloudUtilisateur;
    private Float TraficTipUtilisateur;
    private Integer PartTraficFranceEtranger;


    @AssertTrue(message = "Si useMethodSimplifiee est true, les autres champs doivent être null ou vides.")
    private boolean isUseMethodSimplifieeValid() {
        return useMethodSimplifiee || (TraficCloudUtilisateur == null && TraficTipUtilisateur == null && PartTraficFranceEtranger == null);
    }

    public Float getTraficCloudUtilisateur() {
        return TraficCloudUtilisateur;
    }

    public void setTraficCloudUtilisateur(Float traficCloudUtilisateur) {
        TraficCloudUtilisateur = traficCloudUtilisateur;
    }

    public Float getTraficTipUtilisateur() {
        return TraficTipUtilisateur;
    }

    public void setTraficTipUtilisateur(Float traficTipUtilisateur) {
        TraficTipUtilisateur = traficTipUtilisateur;
    }

    public Integer getPartTraficFranceEtranger() {
        return PartTraficFranceEtranger;
    }

    public void setPartTraficFranceEtranger(Integer partTraficFranceEtranger) {
        PartTraficFranceEtranger = partTraficFranceEtranger;
    }

    public List<EquipementNumerique> getEquipementNumeriqueList() {
        return equipementNumeriqueList;
    }

    public void setEquipementNumeriqueList(List<EquipementNumerique> equipementNumeriqueList) {
        this.equipementNumeriqueList = equipementNumeriqueList;
    }
}
