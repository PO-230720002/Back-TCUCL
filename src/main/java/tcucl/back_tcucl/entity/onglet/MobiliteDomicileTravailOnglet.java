package tcucl.back_tcucl.entity.onglet;


import jakarta.persistence.*;

@Entity
@Table(name = "mobilite_domicile_travail_onglet")
public class MobiliteDomicileTravailOnglet extends Onglet {


    private Integer voitureThermiqueEtudiantKm;
    private Integer voitureElectriqueEtudiantKm;
    private Integer voitureHybrideEtudiantKm;
    private Integer motoEtudiantKm;
    private Integer trainRegionalEtudiantKm;
    private Integer busEtudiantKm;
    private Integer metroTramwayEtudiantKm;
    private Integer veloEtudiantKm;
    private Integer trotinetteElectriqueEtudiantKm;
    private Integer veloElectriqueEtudiantKm;
    private Integer marcheAPiedEtudiantKm;
    private Integer nbJoursDeplacementEtudiant;

    private Integer voitureThermiqueSalarieKm;
    private Integer voitureElectriqueSalarieKm;
    private Integer voitureHybrideSalarieKm;
    private Integer motoSalarieKm;
    private Integer trainRegionalSalarieKm;
    private Integer busSalarieKm;
    private Integer metroTramwaySalarieKm;
    private Integer veloSalarieKm;
    private Integer trotinetteElectriqueSalarieKm;
    private Integer veloElectriqueSalarieKm;
    private Integer marcheAPiedSalarieKm;
    private Integer nbJoursDeplacementSalarie;


    public Integer getVoitureThermiqueEtudiantKm() {
        return voitureThermiqueEtudiantKm;
    }

    public void setVoitureThermiqueEtudiantKm(int voitureThermiqueEtudiantKm) {
        this.voitureThermiqueEtudiantKm = voitureThermiqueEtudiantKm;
    }

    public Integer getVoitureElectriqueEtudiantKm() {
        return voitureElectriqueEtudiantKm;
    }

    public void setVoitureElectriqueEtudiantKm(int voitureElectriqueEtudiantKm) {
        this.voitureElectriqueEtudiantKm = voitureElectriqueEtudiantKm;
    }

    public Integer getVoitureHybrideEtudiantKm() {
        return voitureHybrideEtudiantKm;
    }

    public void setVoitureHybrideEtudiantKm(int voitureHybrideEtudiantKm) {
        this.voitureHybrideEtudiantKm = voitureHybrideEtudiantKm;
    }

    public Integer getMotoEtudiantKm() {
        return motoEtudiantKm;
    }

    public void setMotoEtudiantKm(int motoEtudiantKm) {
        this.motoEtudiantKm = motoEtudiantKm;
    }

    public Integer getTrainRegionalEtudiantKm() {
        return trainRegionalEtudiantKm;
    }

    public void setTrainRegionalEtudiantKm(int trainRegionalEtudiantKm) {
        this.trainRegionalEtudiantKm = trainRegionalEtudiantKm;
    }

    public Integer getBusEtudiantKm() {
        return busEtudiantKm;
    }

    public void setBusEtudiantKm(int busEtudiantKm) {
        this.busEtudiantKm = busEtudiantKm;
    }

    public Integer getMetroTramwayEtudiantKm() {
        return metroTramwayEtudiantKm;
    }

    public void setMetroTramwayEtudiantKm(int metroTramwayEtudiantKm) {
        this.metroTramwayEtudiantKm = metroTramwayEtudiantKm;
    }

    public Integer getVeloEtudiantKm() {
        return veloEtudiantKm;
    }

    public void setVeloEtudiantKm(int veloEtudiantKm) {
        this.veloEtudiantKm = veloEtudiantKm;
    }

    public Integer getTrotinetteElectriqueEtudiantKm() {
        return trotinetteElectriqueEtudiantKm;
    }

    public void setTrotinetteElectriqueEtudiantKm(int trotinetteElectriqueEtudiantKm) {
        this.trotinetteElectriqueEtudiantKm = trotinetteElectriqueEtudiantKm;
    }

    public Integer getVeloElectriqueEtudiantKm() {
        return veloElectriqueEtudiantKm;
    }

    public void setVeloElectriqueEtudiantKm(int veloElectriqueEtudiantKm) {
        this.veloElectriqueEtudiantKm = veloElectriqueEtudiantKm;
    }

    public Integer getMarcheAPiedEtudiantKm() {
        return marcheAPiedEtudiantKm;
    }

    public void setMarcheAPiedEtudiantKm(int marcheAPiedEtudiantKm) {
        this.marcheAPiedEtudiantKm = marcheAPiedEtudiantKm;
    }

    public Integer getVoitureThermiqueSalarieKm() {
        return voitureThermiqueSalarieKm;
    }

    public void setVoitureThermiqueSalarieKm(int voitureThermiqueSalarieKm) {
        this.voitureThermiqueSalarieKm = voitureThermiqueSalarieKm;
    }

    public Integer getVoitureElectriqueSalarieKm() {
        return voitureElectriqueSalarieKm;
    }

    public void setVoitureElectriqueSalarieKm(int voitureElectriqueSalarieKm) {
        this.voitureElectriqueSalarieKm = voitureElectriqueSalarieKm;
    }

    public Integer getVoitureHybrideSalarieKm() {
        return voitureHybrideSalarieKm;
    }

    public void setVoitureHybrideSalarieKm(int voitureHybrideSalarieKm) {
        this.voitureHybrideSalarieKm = voitureHybrideSalarieKm;
    }

    public Integer getMotoSalarieKm() {
        return motoSalarieKm;
    }

    public void setMotoSalarieKm(int motoSalarieKm) {
        this.motoSalarieKm = motoSalarieKm;
    }

    public Integer getTrainRegionalSalarieKm() {
        return trainRegionalSalarieKm;
    }

    public void setTrainRegionalSalarieKm(int trainRegionalSalarieKm) {
        this.trainRegionalSalarieKm = trainRegionalSalarieKm;
    }

    public Integer getBusSalarieKm() {
        return busSalarieKm;
    }

    public void setBusSalarieKm(int busSalarieKm) {
        this.busSalarieKm = busSalarieKm;
    }

    public Integer getMetroTramwaySalarieKm() {
        return metroTramwaySalarieKm;
    }

    public void setMetroTramwaySalarieKm(int metroTramwaySalarieKm) {
        this.metroTramwaySalarieKm = metroTramwaySalarieKm;
    }

    public Integer getVeloSalarieKm() {
        return veloSalarieKm;
    }

    public void setVeloSalarieKm(int veloSalarieKm) {
        this.veloSalarieKm = veloSalarieKm;
    }

    public Integer getTrotinetteElectriqueSalarieKm() {
        return trotinetteElectriqueSalarieKm;
    }

    public void setTrotinetteElectriqueSalarieKm(int trotinetteElectriqueSalarieKm) {
        this.trotinetteElectriqueSalarieKm = trotinetteElectriqueSalarieKm;
    }

    public Integer getVeloElectriqueSalarieKm() {
        return veloElectriqueSalarieKm;
    }

    public void setVeloElectriqueSalarieKm(int veloElectriqueSalarieKm) {
        this.veloElectriqueSalarieKm = veloElectriqueSalarieKm;
    }

    public Integer getMarcheAPiedSalarieKm() {
        return marcheAPiedSalarieKm;
    }

    public void setMarcheAPiedSalarieKm(int marcheAPiedSalarieKm) {
        this.marcheAPiedSalarieKm = marcheAPiedSalarieKm;
    }

    public Integer getNbJoursDeplacementEtudiant() {
        return nbJoursDeplacementEtudiant;
    }

    public void setNbJoursDeplacementEtudiant(int nbJoursDeplacementEtudiant) {
        this.nbJoursDeplacementEtudiant = nbJoursDeplacementEtudiant;
    }

    public Integer getNbJoursDeplacementSalarie() {
        return nbJoursDeplacementSalarie;
    }

    public void setNbJoursDeplacementSalarie(int nbJoursDeplacementSalarie) {
        this.nbJoursDeplacementSalarie = nbJoursDeplacementSalarie;
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
    public boolean isEstTermine() {
        return super.isEstTermine();
    }

    @Override
    public void setEstTermine(boolean estTermine) {
        super.setEstTermine(estTermine);
    }
}
