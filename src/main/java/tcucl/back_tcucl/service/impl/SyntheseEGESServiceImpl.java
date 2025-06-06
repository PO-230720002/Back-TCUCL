package tcucl.back_tcucl.service.impl;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.ListIdDto;
import tcucl.back_tcucl.dto.SyntheseEGESResultatDto;
import tcucl.back_tcucl.service.*;


@Service
public class SyntheseEGESServiceImpl implements SyntheseEGESService {

    private final AnneeService anneeService;

    private final GeneralOngletService generalOngletService;

    private final EnergieOngletService energieOngletService;

    private final AchatOngletService achatOngletService;

    private final AutreImmobilisationOngletService autreImmobilisationOngletService;

    private final AutreMobFrOngletService autreMobFrOngletService;

    private final BatimentImmobilisationMobilierOngletService batimentImmobilisationMobilierOngletService;

    private final DechetOngletService dechetOngletService;

    private final EmissionFugitiveOngletService emissionFugitiveOngletService;

    private final MobiliteDomicileTravailOngletService mobiliteDomicileTravailOngletService;

    private final MobInternationalOngletService mobInternationalOngletService;

    private final NumeriqueOngletService numeriqueOngletService;

    private final ParkingVoirieOngletService parkingVoirieOngletService;

    private final VehiculeOngletService vehiculeOngletService;

    public SyntheseEGESServiceImpl(AnneeService anneeService, GeneralOngletService generalOngletService, EnergieOngletService energieOngletService, AchatOngletService achatOngletService, AutreImmobilisationOngletService autreImmobilisationOngletService, AutreMobFrOngletService autreMobFrOngletService, BatimentImmobilisationMobilierOngletService batimentImmobilisationMobilierOngletService, DechetOngletService dechetOngletService, EmissionFugitiveOngletService emissionFugitiveOngletService, MobiliteDomicileTravailOngletService mobiliteDomicileTravailOngletService, MobInternationalOngletService mobInternationalOngletService, NumeriqueOngletService numeriqueOngletService, ParkingVoirieOngletService parkingVoirieOngletService, VehiculeOngletService vehiculeOngletService) {
        this.anneeService = anneeService;
        this.generalOngletService = generalOngletService;
        this.energieOngletService = energieOngletService;
        this.achatOngletService = achatOngletService;
        this.autreImmobilisationOngletService = autreImmobilisationOngletService;
        this.autreMobFrOngletService = autreMobFrOngletService;
        this.batimentImmobilisationMobilierOngletService = batimentImmobilisationMobilierOngletService;
        this.dechetOngletService = dechetOngletService;
        this.emissionFugitiveOngletService = emissionFugitiveOngletService;
        this.mobiliteDomicileTravailOngletService = mobiliteDomicileTravailOngletService;
        this.mobInternationalOngletService = mobInternationalOngletService;
        this.numeriqueOngletService = numeriqueOngletService;
        this.parkingVoirieOngletService = parkingVoirieOngletService;
        this.vehiculeOngletService = vehiculeOngletService;
    }


    @Override
    public SyntheseEGESResultatDto getSyntheseEGESResultat(Long entiteId, Integer annee) {
        ListIdDto onglets = anneeService.getongletIdListForEntiteAndAnnee(entiteId, annee);
        SyntheseEGESResultatDto syntheseEGESResultatDto = new SyntheseEGESResultatDto();
        Long generalOngletId = onglets.getGeneralOnglet();
        Integer nbEtudiant = generalOngletService.getGeneralOngletById(generalOngletId).getNbEtudiant();
        Integer nbSalarie = generalOngletService.getGeneralOngletById(generalOngletId).getNbSalarie();

        // Emission fugitives
        Long emissionFugitiveOngletId = onglets.getEmissionFugitiveOnglet();
        Float emissionFugitivesGlobal = emissionFugitiveOngletService
                .getEmissionFugitiveResult(emissionFugitiveOngletId)
                .getTotalEmissionGES();
        syntheseEGESResultatDto.setEmissionFugitivesGlobal(emissionFugitivesGlobal);
        syntheseEGESResultatDto.setEmissionFugitivesParUsager(syntheseEGESResultatDto.getEmissionFugitivesGlobal() * 1000 / (nbEtudiant + nbSalarie));

        // Energie
        Long energieOngletId = onglets.getEnergieOnglet();
        Float energieGlobal = energieOngletService
                .getEnergieResultat(energieOngletId)
                .getTotalPosteFluides();
        syntheseEGESResultatDto.setEnergieGlobal(energieGlobal);
        syntheseEGESResultatDto.setEnergieParUsager(syntheseEGESResultatDto.getEnergieGlobal() * 1000 / (nbEtudiant + nbSalarie));

        // Mobilité domicile travail
        Long mobiliteDomicileTravailOngletId = onglets.getMobiliteDomicileTravailOnglet();
        Float mobiliteDomicileTravailGlobal = mobiliteDomicileTravailOngletService
                .getMobiliteDomicileTravailResultat(mobiliteDomicileTravailOngletId)
                .getTotalPosteMobiliteFrance();
        syntheseEGESResultatDto.setMobiliteDomicileTravailGlobal(mobiliteDomicileTravailGlobal);
        syntheseEGESResultatDto.setMobiliteDomicileTravailParUsager(syntheseEGESResultatDto.getMobiliteDomicileTravailGlobal() * 1000 / (nbEtudiant + nbSalarie));

        // Autre mobilité France
        Long autreMobFrOngletId = onglets.getAutreMobFrOnglet();
        Long vehiculeOngletId = onglets.getVehiculeOnglet();

        Float autreMobiliteFrGlobal = autreMobFrOngletService
                .getAutreMobFrResultat(autreMobFrOngletId)
                .getTotalPosteMobiliteFrance()
                + vehiculeOngletService
                .getVehiculeResult(vehiculeOngletId)
                .getTotalEmissionGES();
        syntheseEGESResultatDto.setAutreMobiliteFrGlobal(autreMobiliteFrGlobal);
        syntheseEGESResultatDto.setAutreMobiliteFrParUsager(syntheseEGESResultatDto.getAutreMobiliteFrGlobal() * 1000 / (nbEtudiant + nbSalarie));

        // Mobilité internationale
        Long mobInternationalOngletId = onglets.getMobInternationalOnglet();
        Float mobiliteInternationalGlobal = mobInternationalOngletService
                .getMobInternationalResultat(mobInternationalOngletId)
                .getEmissionGesProEurope()
                + mobInternationalOngletService
                .getMobInternationalResultat(mobInternationalOngletId)
                .getEmissionGesStageEurope()
                + mobInternationalOngletService
                .getMobInternationalResultat(mobInternationalOngletId)
                .getEmissionGesSemestreEurope()
                + mobInternationalOngletService
                .getMobInternationalResultat(mobInternationalOngletId)
                .getEmissionGesProHorsEurope()
                + mobInternationalOngletService
                .getMobInternationalResultat(mobInternationalOngletId)
                .getEmissionGesStagesHorsEurope()
                + mobInternationalOngletService
                .getMobInternationalResultat(mobInternationalOngletId)
                .getEmissionGesSemestresHorsEurope();
        syntheseEGESResultatDto.setMobiliteInternationalGlobal(mobiliteInternationalGlobal);
        syntheseEGESResultatDto.setMobiliteInternationalParUsager(syntheseEGESResultatDto.getMobiliteInternationalGlobal() * 1000 / (nbEtudiant + nbSalarie));

        // Immobilisation bâtiment mobilier (incluant parking)
        Long batimentImmobilisationMobilierOngletId = onglets.getBatimentImmobilisationMobilierOnglet();
        Long parkingVoirieOngletId = onglets.getParkingVoirieOnglet();

        Float batimentParkingGlobal = batimentImmobilisationMobilierOngletService
                .getBatimentImmobilisationMobilierResult(batimentImmobilisationMobilierOngletId)
                .getTotalPosteBatiment()
                + batimentImmobilisationMobilierOngletService
                .getBatimentImmobilisationMobilierResult(batimentImmobilisationMobilierOngletId)
                .getTotalPosteEntretien()
                + batimentImmobilisationMobilierOngletService
                .getBatimentImmobilisationMobilierResult(batimentImmobilisationMobilierOngletId)
                .getTotalPosteMobilier()
                + parkingVoirieOngletService
                .getParkingVoirieResult(parkingVoirieOngletId)
                .getTotalEmissionGES();
        syntheseEGESResultatDto.setBatimentParkingGlobal(batimentParkingGlobal);
        syntheseEGESResultatDto.setBatimentParkingParUsager(syntheseEGESResultatDto.getBatimentParkingGlobal() * 1000 / (nbEtudiant + nbSalarie));

        // Numérique
        Long numeriqueOngletId = onglets.getNumeriqueOnglet();
        Float numeriqueGlobal = numeriqueOngletService
                .getNumeriqueResultat(numeriqueOngletId)
                .getTotalNumerique();
        syntheseEGESResultatDto.setNumeriqueGlobal(numeriqueGlobal);
        syntheseEGESResultatDto.setNumeriqueParUsager(syntheseEGESResultatDto.getNumeriqueGlobal() * 1000 / (nbEtudiant + nbSalarie));

        // Autres immobilisations
        Long autreImmobilisationOngletId = onglets.getAutreImmobilisationOnglet();
        Float autreImmobilisationGlobal = autreImmobilisationOngletService
                .getAutreImmobilisationResultat(autreImmobilisationOngletId)
                .getTotalPostePhotovoltaique()
                + autreImmobilisationOngletService
                .getAutreImmobilisationResultat(autreImmobilisationOngletId)
                .getTotalPosteBatiment();
        syntheseEGESResultatDto.setAutreImmobilisationGlobal(autreImmobilisationGlobal);
        syntheseEGESResultatDto.setAutreImmobilisationParUsager(syntheseEGESResultatDto.getAutreImmobilisationGlobal() * 1000 / (nbEtudiant + nbSalarie));

        // Achats
        Long achatOngletId = onglets.getAchatOnglet();
        Float achatGlobal = achatOngletService
                .getAchatResultat(achatOngletId)
                .getTotalPosteAchat()
                + achatOngletService
                .getAchatResultat(achatOngletId)
                .getTotalPosteTextile()
                + achatOngletService
                .getAchatResultat(achatOngletId)
                .getTotalPosteRestauration();
        syntheseEGESResultatDto.setAchatGlobal(achatGlobal);
        syntheseEGESResultatDto.setAchatParUsager(syntheseEGESResultatDto.getAchatGlobal() * 1000 / (nbEtudiant + nbSalarie));

        // Déchets
        Long dechetOngletId = onglets.getDechetOnglet();
        Float dechetGlobal = dechetOngletService
                .getDechetResultat(dechetOngletId)
                .getTotalProduit();
        syntheseEGESResultatDto.setDechetGlobal(dechetGlobal);
        syntheseEGESResultatDto.setDechetParUsager(syntheseEGESResultatDto.getDechetGlobal() * 1000 / (nbEtudiant + nbSalarie));

        syntheseEGESResultatDto.setBilanCarboneTotalGlobal(syntheseEGESResultatDto.getEmissionFugitivesGlobal()
                + syntheseEGESResultatDto.getEnergieGlobal()
                + syntheseEGESResultatDto.getMobiliteDomicileTravailGlobal()
                + syntheseEGESResultatDto.getAutreMobiliteFrGlobal()
                + syntheseEGESResultatDto.getMobiliteInternationalGlobal()
                + syntheseEGESResultatDto.getBatimentParkingGlobal()
                + syntheseEGESResultatDto.getNumeriqueGlobal()
                + syntheseEGESResultatDto.getAutreImmobilisationGlobal()
                + syntheseEGESResultatDto.getAchatGlobal()
                + syntheseEGESResultatDto.getDechetGlobal());

        syntheseEGESResultatDto.setBilanCarboneTotalParUsager(syntheseEGESResultatDto.getEmissionFugitivesParUsager()
                + syntheseEGESResultatDto.getEnergieParUsager()
                + syntheseEGESResultatDto.getMobiliteDomicileTravailParUsager()
                + syntheseEGESResultatDto.getAutreMobiliteFrParUsager()
                + syntheseEGESResultatDto.getMobiliteInternationalParUsager()
                + syntheseEGESResultatDto.getBatimentParkingParUsager()
                + syntheseEGESResultatDto.getNumeriqueParUsager()
                + syntheseEGESResultatDto.getAutreImmobilisationParUsager()
                + syntheseEGESResultatDto.getAchatParUsager()
                + syntheseEGESResultatDto.getDechetParUsager());

        syntheseEGESResultatDto.setEmissionDirecteMoteurThermique(vehiculeOngletService.getVehiculeResult(vehiculeOngletId).getTotalEmissionGESPetrole());
        syntheseEGESResultatDto.setEmissionDirecteFugitives(emissionFugitiveOngletService.getEmissionFugitiveResult(emissionFugitiveOngletId).getTotalEmissionGES());
        syntheseEGESResultatDto.setEmissionIndirecteConsoVapeurChaleurFroid(energieOngletService.getEnergieResultat(energieOngletId).getConsoReseauVille());
        syntheseEGESResultatDto.setAchatProduitOuService(achatOngletService.getAchatResultat(achatOngletId).getTotalPosteAchat()
                + achatOngletService.getAchatResultat(achatOngletId).getTotalPosteTextile()
                + achatOngletService.getAchatResultat(achatOngletId).getTotalPosteRestauration()
                + energieOngletService.getEnergieResultat(energieOngletId).getConsoEau());
        syntheseEGESResultatDto.setImmobilisationBien(batimentImmobilisationMobilierOngletService.getBatimentImmobilisationMobilierResult(batimentImmobilisationMobilierOngletId).getTotalPosteBatiment()
                + batimentImmobilisationMobilierOngletService.getBatimentImmobilisationMobilierResult(batimentImmobilisationMobilierOngletId).getTotalPosteMobilier()
                + batimentImmobilisationMobilierOngletService.getBatimentImmobilisationMobilierResult(batimentImmobilisationMobilierOngletId).getTotalPosteEntretien()
                + parkingVoirieOngletService.getParkingVoirieResult(parkingVoirieOngletId).getTotalEmissionGES()
                + numeriqueOngletService.getNumeriqueResultat(numeriqueOngletId).getTotalNumerique()
                + autreImmobilisationOngletService.getAutreImmobilisationResultat(autreImmobilisationOngletId).getTotalPostePhotovoltaique()
                + autreImmobilisationOngletService.getAutreImmobilisationResultat(autreImmobilisationOngletId).getTotalPosteBatiment()
                + vehiculeOngletService.getVehiculeResult(vehiculeOngletId).getTotalEmissionGESFabrication());
        syntheseEGESResultatDto.setDechet(dechetOngletService.getDechetResultat(dechetOngletId).getTotalProduit());
        syntheseEGESResultatDto.setDeplacementProfessionnel(autreMobFrOngletService.getAutreMobFrResultat(autreMobFrOngletId).getTotalPosteMobiliteFrance() + mobiliteInternationalGlobal);
        syntheseEGESResultatDto.setDeplacementDomicileTravail(mobiliteDomicileTravailOngletService.getMobiliteDomicileTravailResultat(mobiliteDomicileTravailOngletId).getTotalPosteMobiliteFrance());

        syntheseEGESResultatDto.setBilanCarboneTotalScope(syntheseEGESResultatDto.getEmissionDirecteCombustion()
                + syntheseEGESResultatDto.getEmissionDirecteMoteurThermique()
                + syntheseEGESResultatDto.getEmissionDirecteFugitives()
                + syntheseEGESResultatDto.getEmissionIndirecteConsoElec()
                + syntheseEGESResultatDto.getEmissionIndirecteConsoVapeurChaleurFroid()
                + syntheseEGESResultatDto.getEmissionNonIncluseDansDirectOuIndirecte()
                + syntheseEGESResultatDto.getAchatProduitOuService()
                + syntheseEGESResultatDto.getImmobilisationBien()
                + syntheseEGESResultatDto.getDechet()
                + syntheseEGESResultatDto.getDeplacementProfessionnel()
                + syntheseEGESResultatDto.getDeplacementDomicileTravail());

        syntheseEGESResultatDto.setEmissionEvitee(dechetOngletService.getDechetResultat(dechetOngletId).getTotalEvite());

        return syntheseEGESResultatDto;
    }

}
