package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentExistantOuNeufConstruitDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.EntretienCourantDto;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.MobilierElectromenagerDto;
import tcucl.back_tcucl.entity.parametre.batiment.BatimentExistantOuNeufConstruit;
import tcucl.back_tcucl.entity.parametre.batiment.EntretienCourant;
import tcucl.back_tcucl.entity.parametre.batiment.MobilierElectromenager;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "batiment_onglet")
public class BatimentImmobilisationMobilierOnglet extends Onglet {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "batiment_onglet_id")
    private List<BatimentExistantOuNeufConstruit> batimentsExistantOuNeufConstruits = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "batiment_onglet_id")
    private List<EntretienCourant> entretiensCourants = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "batiment_onglet_id")
    private List<MobilierElectromenager> mobiliersElectromenagers = new ArrayList<>();


    public List<BatimentExistantOuNeufConstruit> getBatimentExistantOuNeufConstruits() {
        return batimentsExistantOuNeufConstruits;
    }

    public void setBatimentExistantOuNeufConstruits(List<BatimentExistantOuNeufConstruit> batimentExistantOuNeufConstruits) {
        this.batimentsExistantOuNeufConstruits = batimentExistantOuNeufConstruits;
    }

    public List<EntretienCourant> getEntretienCourants() {
        return entretiensCourants;
    }

    public void setEntretienCourants(List<EntretienCourant> entretienCourants) {
        this.entretiensCourants = entretienCourants;
    }

    public List<MobilierElectromenager> getMobilierElectromenagers() {
        return mobiliersElectromenagers;
    }

    public void setMobilierElectromenagers(List<MobilierElectromenager> mobilierElectromenagers) {
        this.mobiliersElectromenagers = mobilierElectromenagers;
    }

    public void ajouterBatimentViaDto(BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto) {
        BatimentExistantOuNeufConstruit batimentExistantOuNeufConstruit = new BatimentExistantOuNeufConstruit();

        batimentExistantOuNeufConstruit.setNom_ou_adresse(batimentExistantOuNeufConstruitDto.getNom_ou_adresse());
        batimentExistantOuNeufConstruit.setDateConstruction(batimentExistantOuNeufConstruitDto.getDateConstruction());
        batimentExistantOuNeufConstruit.setDateDerniereGrosseRenovation(batimentExistantOuNeufConstruitDto.getDateDerniereGrosseRenovation());
        batimentExistantOuNeufConstruit.setACompleter(batimentExistantOuNeufConstruitDto.getACompleter());
        batimentExistantOuNeufConstruit.setAcvBatimentRealisee(batimentExistantOuNeufConstruitDto.getAcvBatimentRealisee());
        batimentExistantOuNeufConstruit.setEmissionsGesReellesTCO2(batimentExistantOuNeufConstruitDto.getEmissionsGesReellesTCO2());
        batimentExistantOuNeufConstruit.setTypeBatiment(batimentExistantOuNeufConstruitDto.getTypeBatiment());
        batimentExistantOuNeufConstruit.setSurfaceEnM2(batimentExistantOuNeufConstruitDto.getSurfaceEnM2());
        batimentExistantOuNeufConstruit.setTypeStructure(batimentExistantOuNeufConstruitDto.getTypeStructure());

        this.batimentsExistantOuNeufConstruits.add(batimentExistantOuNeufConstruit);
    }

    public void ajouterEntretienCourantViaDto(EntretienCourantDto entretienCourantDto) {
        EntretienCourant entretienCourant = new EntretienCourant();

        entretienCourant.setDateAjout(entretienCourantDto.getDateAjout());
        entretienCourant.setNom_adresse(entretienCourantDto.getNom_adresse());
        entretienCourant.setTypeTravaux(entretienCourantDto.getTypeTravaux());
        entretienCourant.setDateTravaux(entretienCourantDto.getDateTravaux());
        entretienCourant.setAcvRenovationRealisee(entretienCourantDto.getAcvRenovationRealisee());
        entretienCourant.setEmissionsGesReellesTCO2(entretienCourantDto.getEmissionsGesReellesTCO2());
        entretienCourant.setTypeBatiment(entretienCourantDto.getTypeBatiment());
        entretienCourant.setSurfaceConcernee(entretienCourantDto.getSurfaceConcernee());
        entretienCourant.setDureeAmortissement(entretienCourantDto.getDureeAmortissement());

        this.entretiensCourants.add(entretienCourant);
    }
    public void ajouterMobilierElectromenagerViaDto(MobilierElectromenagerDto mobilierElectromenagerDto) {
        MobilierElectromenager mobilierElectromenager = new MobilierElectromenager();

        mobilierElectromenager.setDateAjout(mobilierElectromenagerDto.getDateAjout());
        mobilierElectromenager.setMobilier(mobilierElectromenagerDto.getMobilier());
        mobilierElectromenager.setQuantite(mobilierElectromenagerDto.getQuantite());
        mobilierElectromenager.setPoidsDuProduit(mobilierElectromenagerDto.getPoidsDuProduit());
        mobilierElectromenager.setDureeAmortissement(mobilierElectromenagerDto.getDureeAmortissement());
        mobilierElectromenager.setEmissionGesPrecisesConnues(mobilierElectromenagerDto.getEmissionGesPrecisesConnues());
        mobilierElectromenager.setEmissionsGesReelleskgCO2(mobilierElectromenagerDto.getEmissionsGesReelleskgCO2());

        this.mobiliersElectromenagers.add(mobilierElectromenager);
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
    public Boolean getEstTermine() {
        return super.getEstTermine();
    }

    @Override
    public void setEstTermine(Boolean estTermine) {
        super.setEstTermine(estTermine);
    }
}
