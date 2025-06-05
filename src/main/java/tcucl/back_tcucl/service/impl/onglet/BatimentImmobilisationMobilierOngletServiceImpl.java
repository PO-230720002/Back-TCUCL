package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.*;
import tcucl.back_tcucl.dto.onglet.batimentImmobilisationMobilier.BatimentImmobilisationMobilierResultatDto;
import tcucl.back_tcucl.entity.facteurEmission.FacteurEmission;
import tcucl.back_tcucl.entity.facteurEmission.FacteurEmissionParametre;
import tcucl.back_tcucl.entity.onglet.batiment.BatimentExistantOuNeufConstruit;
import tcucl.back_tcucl.entity.onglet.batiment.BatimentImmobilisationMobilierOnglet;
import tcucl.back_tcucl.entity.onglet.batiment.EntretienCourant;
import tcucl.back_tcucl.entity.onglet.batiment.MobilierElectromenager;
import tcucl.back_tcucl.entity.onglet.batiment.enums.EnumBatiment_Mobilier;
import tcucl.back_tcucl.entity.onglet.batiment.enums.EnumBatiment_TypeBatiment;
import tcucl.back_tcucl.manager.BatimentImmobilisationMobilierOngletManager;
import tcucl.back_tcucl.service.BatimentImmobilisationMobilierOngletService;
import tcucl.back_tcucl.service.FacteurEmissionService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BatimentImmobilisationMobilierOngletServiceImpl implements BatimentImmobilisationMobilierOngletService {

    private final BatimentImmobilisationMobilierOngletManager batimentImmobilisationMobilierOngletManager;

    private final FacteurEmissionService facteurEmissionService;

    public BatimentImmobilisationMobilierOngletServiceImpl(BatimentImmobilisationMobilierOngletManager batimentImmobilisationMobilierOngletManager, FacteurEmissionService facteurEmissionService) {
        this.batimentImmobilisationMobilierOngletManager = batimentImmobilisationMobilierOngletManager;
        this.facteurEmissionService = facteurEmissionService;
    }
    @Override
    public BatimentImmobilisationMobilierOnglet getBatimentImmobilisationMobilierOngletById(Long ongletId) {
        return batimentImmobilisationMobilierOngletManager.getBatimentImmobilisationMobilierOngletById(ongletId);

    }

    @Override
    public void updateBatimentImmobilisationMobilierOnglet(Long ongletId, BatimentImmobilisationMobilierOngletDto batimentImmobilisationMobilierOngletDto) {
        batimentImmobilisationMobilierOngletManager.updateBatimentImmobilisationMobilierOnglet(ongletId, batimentImmobilisationMobilierOngletDto);

    }

    @Override
    public void ajouterBatiment(Long ongletId, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto) {
        batimentImmobilisationMobilierOngletManager.ajouterBatiment(ongletId, batimentExistantOuNeufConstruitDto);
    }

    @Override
    public void supprimerBatiment(Long ongletId, Long batimentId) {
        batimentImmobilisationMobilierOngletManager.supprimerBatimentFromOnglet(ongletId, batimentId);
    }

    @Override
    public void updateBatimentPartiel(Long ongletId, Long batimentId, BatimentExistantOuNeufConstruitDto batimentExistantOuNeufConstruitDto) {
        batimentImmobilisationMobilierOngletManager.updateBatimentPartiel(ongletId, batimentId, batimentExistantOuNeufConstruitDto);

    }

    @Override
    public void ajouterEntretienCourant(Long ongletId, EntretienCourantDto entretienCourantDto) {
        batimentImmobilisationMobilierOngletManager.ajouterEntretienCourant(ongletId, entretienCourantDto);

    }

    @Override
    public void supprimerEntretienCourant(Long ongletId, Long entretienCourantId) {
        batimentImmobilisationMobilierOngletManager.supprimerEntretienCourantFromOnglet(ongletId, entretienCourantId);

    }

    @Override
    public void updateEntretienCourantPartiel(Long ongletId, Long entretienCourantId, EntretienCourantDto entretienCourantDto) {
        batimentImmobilisationMobilierOngletManager.updateEntretienCourantPartiel(ongletId, entretienCourantId, entretienCourantDto);

    }

    @Override
    public void ajouterMobilierElectromenager(Long ongletId, MobilierElectromenagerDto mobilierElectromenagerDto) {
        batimentImmobilisationMobilierOngletManager.ajouterMobilierElectromenager(ongletId, mobilierElectromenagerDto);

    }

    @Override
    public void supprimerMobilierElectromenager(Long ongletId, Long mobilierElectromenagerId) {
        batimentImmobilisationMobilierOngletManager.supprimerMobilierElectromenagerFromOnglet(ongletId, mobilierElectromenagerId);

    }

    @Override
    public void updateMobilierElectromenagerPartiel(Long ongletId, Long mobilierElectromenagerId, MobilierElectromenagerDto mobilierElectromenagerDto) {
        batimentImmobilisationMobilierOngletManager.updateMobilierElectromenagerPartiel(ongletId, mobilierElectromenagerId, mobilierElectromenagerDto);

    }

    @Override
    public BatimentImmobilisationMobilierResultatDto getBatimentImmobilisationMobilierResult(Long ongletId) {
        BatimentImmobilisationMobilierOnglet batimentImmobilisationMobilierOnglet = batimentImmobilisationMobilierOngletManager.getBatimentImmobilisationMobilierOngletById(ongletId);
        List<BatimentExistantOuNeufConstruit> batiments = batimentImmobilisationMobilierOnglet.getBatimentExistantOuNeufConstruits();
        List<EntretienCourant> entretienCourants = batimentImmobilisationMobilierOnglet.getEntretienCourants();
        List<MobilierElectromenager> mobilierElectromenagers = batimentImmobilisationMobilierOnglet.getMobilierElectromenagers();

        Map<Long, Float> emissionsParBatiment = batiments.stream()
                .collect(Collectors.toMap(
                        BatimentExistantOuNeufConstruit::getId,
                        batiment -> {

                            FacteurEmission facteurEmission = null;
                            if (batiment.getTypeBatiment() == EnumBatiment_TypeBatiment.BUREAUX) {
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.BATIMENTS_BUREAUX,
                                        batiment.getTypeStructure().toString());
                            } else if (batiment.getTypeBatiment() == EnumBatiment_TypeBatiment.ENSEIGNEMENT){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.BATIMENTS_ENSEIGNEMENT,
                                        batiment.getTypeStructure().toString());
                            } else if (batiment.getTypeBatiment() == EnumBatiment_TypeBatiment.EQUIPEMENT_SPORTIF){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.BATIMENTS_EQUIP_SPORTIF,
                                        batiment.getTypeStructure().toString());
                            } else if (batiment.getTypeBatiment() == EnumBatiment_TypeBatiment.HOPITAL){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.BATIMENTS_HOPITAL,
                                        batiment.getTypeStructure().toString());
                            } else if (batiment.getTypeBatiment() == EnumBatiment_TypeBatiment.LOGEMENT_COLLECTIF){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.BATIMENTS_LOGEMENT_COLLECTIF,
                                        batiment.getTypeStructure().toString());
                            } else if (batiment.getTypeBatiment() == EnumBatiment_TypeBatiment.RESTAURATION){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.BATIMENTS_RESTAURATION,
                                        batiment.getTypeStructure().toString());
                            } else if (batiment.getTypeBatiment() == EnumBatiment_TypeBatiment.AUTRE){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.BATIMENTS_AUTRES,
                                        batiment.getTypeStructure().toString());
                            }

                            if (Boolean.TRUE.equals(batiment.getAcvBatimentRealisee())){
                                return batiment.getEmissionsGesReellesTCO2();
                            } else {
                                if (batiment.getDateConstruction().getYear() > (batimentImmobilisationMobilierOnglet.getAnnee().getAnneeValeur() - 50) || batiment.getDateDerniereGrosseRenovation().getYear() > (batimentImmobilisationMobilierOnglet.getAnnee().getAnneeValeur() - 50)){
                                    return facteurEmission.getFacteurEmission() * batiment.getSurfaceEnM2() / (50 * 1000);
                                } else {
                                    return 0f;
                                }
                            }
                        }
                ));

        float totalPosteBatiment = emissionsParBatiment.values().stream()
                .reduce(0f, Float::sum);

        BatimentImmobilisationMobilierResultatDto resultatDto = new BatimentImmobilisationMobilierResultatDto();
        resultatDto.setTotalPosteBatiment(totalPosteBatiment);


        Map<Long, Float> emissionsParEntretienCourants = entretienCourants.stream()
                .collect(Collectors.toMap(
                        EntretienCourant::getId,
                        entretienCourant -> {
                            FacteurEmission facteurEmission = null;
                            if (entretienCourant.getTypeBatiment() == EnumBatiment_TypeBatiment.BUREAUX) {
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.ENTRETIEN_BUREAUX,
                                        entretienCourant.getTypeTravaux().toString());
                            } else if (entretienCourant.getTypeBatiment() == EnumBatiment_TypeBatiment.ENSEIGNEMENT){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.ENTRETIEN_ENSEIGNEMENT,
                                        entretienCourant.getTypeTravaux().toString());
                            } else if (entretienCourant.getTypeBatiment() == EnumBatiment_TypeBatiment.EQUIPEMENT_SPORTIF){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.ENTRETIEN_EQUIP_SPORTIF,
                                        entretienCourant.getTypeTravaux().toString());
                            } else if (entretienCourant.getTypeBatiment() == EnumBatiment_TypeBatiment.HOPITAL){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.ENTRETIEN_HOPITAL,
                                        entretienCourant.getTypeTravaux().toString());
                            } else if (entretienCourant.getTypeBatiment() == EnumBatiment_TypeBatiment.LOGEMENT_COLLECTIF){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.ENTRETIEN_LOGEMENT_COLLECTIF,
                                        entretienCourant.getTypeTravaux().toString());
                            } else if (entretienCourant.getTypeBatiment() == EnumBatiment_TypeBatiment.RESTAURATION){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.ENTRETIEN_RESTAURATION,
                                        entretienCourant.getTypeTravaux().toString());
                            } else if (entretienCourant.getTypeBatiment() == EnumBatiment_TypeBatiment.AUTRE){
                                facteurEmission = facteurEmissionService.findByCategorieAndType(
                                        FacteurEmissionParametre.ENTRETIEN_AUTRES,
                                        entretienCourant.getTypeTravaux().toString());
                            }

                            if (entretienCourant.getDateTravaux().getYear() > (batimentImmobilisationMobilierOnglet.getAnnee().getAnneeValeur() - entretienCourant.getDureeAmortissement())){
                                return facteurEmission.getFacteurEmission() * entretienCourant.getSurfaceConcernee() / (entretienCourant.getDureeAmortissement() * 1000);
                            } else {
                                return 0f;
                            }

                        }
                ));

        float totalPosteEntretien = emissionsParEntretienCourants.values().stream()
                .reduce(0f, Float::sum);
        resultatDto.setTotalPosteEntretien(totalPosteEntretien);

        Map<Long, Float> emissionsParMobilierElectromenager = mobilierElectromenagers.stream()
                .collect(Collectors.toMap(
                        MobilierElectromenager::getId,
                        mobilierElectromenager -> {
                            FacteurEmission facteurEmissionProduit = facteurEmissionService.findByCategorieAndTypeAndUnite(
                                    FacteurEmissionParametre.MOBILIER,
                                    mobilierElectromenager.getMobilier().getLibelle(),
                                    FacteurEmissionParametre.MOBILIER_.KG_CO2E_PAR_PRODUIT
                            );
                            FacteurEmission facteurEmissionKgProduit = facteurEmissionService.findByCategorieAndTypeAndUnite(
                                    FacteurEmissionParametre.MOBILIER,
                                    mobilierElectromenager.getMobilier().getLibelle(),
                                    FacteurEmissionParametre.MOBILIER_.KG_CO2E_PAR_KG_PRODUIT
                            );
                            FacteurEmission facteurEmissionAutre = facteurEmissionService.findByCategorieAndType(
                                    FacteurEmissionParametre.MOBILIER,
                                    mobilierElectromenager.getMobilier().getLibelle()
                            );

                            if (mobilierElectromenager.getDateAjout().getYear() > (batimentImmobilisationMobilierOnglet.getAnnee().getAnneeValeur() - mobilierElectromenager.getDureeAmortissement())){

                                if (mobilierElectromenager.getPoidsDuProduit()!=null || mobilierElectromenager.getPoidsDuProduit()!= 0) {
                                    return (mobilierElectromenager.getQuantite() * mobilierElectromenager.getPoidsDuProduit() * facteurEmissionKgProduit.getFacteurEmission() /1000) / mobilierElectromenager.getDureeAmortissement();
                                } else {
                                    if (mobilierElectromenager.getMobilier() == EnumBatiment_Mobilier.AUTRE_MOBILIER_EN_EUROS || (mobilierElectromenager.getMobilier() == EnumBatiment_Mobilier.AUTRE_MOBILIER_EN_TONNES)){
                                        return (facteurEmissionAutre.getFacteurEmission() * mobilierElectromenager.getQuantite() / 1000) / mobilierElectromenager.getDureeAmortissement();
                                    } else {
                                        return (facteurEmissionProduit.getFacteurEmission() * mobilierElectromenager.getQuantite() / 1000) / mobilierElectromenager.getDureeAmortissement();
                                    }
                                }
                            } else {
                                return 0f;
                            }

                        }
                ));

        float totalPosteMobilier = emissionsParMobilierElectromenager.values().stream()
                .reduce(0f, Float::sum);
        resultatDto.setTotalPosteMobilier(totalPosteMobilier);


        return resultatDto;
    }
}
