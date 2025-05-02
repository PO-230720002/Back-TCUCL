package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import tcucl.back_tcucl.dto.onglet.numerique.EquipementNumeriqueDto;
import tcucl.back_tcucl.entity.parametre.numerique.EquipementNumerique;

import java.util.List;

@Entity
@Table(name = "numerique_onglet")
public class NumeriqueOnglet extends Onglet{


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipement_numerique_id")
    List<EquipementNumerique> equipementNumeriqueList;

    private Boolean useMethodSimplifiee;
    private Float TraficCloudUtilisateur;
    private Float TraficTipUtilisateur;
    private Integer PartTraficFranceEtranger;


    @AssertTrue(message = "Si useMethodSimplifiee est true, les autres champs doivent être null ou vides.")
    private Boolean isUseMethodSimplifieeValid() {
        return useMethodSimplifiee || (TraficCloudUtilisateur == null && TraficTipUtilisateur == null && PartTraficFranceEtranger == null);
    }

    public Boolean getUseMethodSimplifiee() {
        return useMethodSimplifiee;
    }

    public void setUseMethodSimplifiee(Boolean useMethodSimplifiee) {
        this.useMethodSimplifiee = useMethodSimplifiee;
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

    public void ajouterEquipementNumeriqueViaDto(EquipementNumeriqueDto equipementNumeriqueDto  ) {
        EquipementNumerique equipementNumerique = new EquipementNumerique();

        equipementNumerique.setEquipement(equipementNumeriqueDto.getEquipement());
        equipementNumerique.setNombre(equipementNumeriqueDto.getNombre());
        equipementNumerique.setDureeAmortissement(equipementNumeriqueDto.getDureeAmortissement());
        equipementNumerique.setEmissionsGesPrecisesConnues(equipementNumeriqueDto.getEmissionsGesPrecisesConnues());
        equipementNumerique.setEmissionsReellesParProduitKgCO2e(equipementNumeriqueDto.getEmissionsReellesParProduitKgCO2e());

        this.equipementNumeriqueList.add(equipementNumerique);
    }
}
