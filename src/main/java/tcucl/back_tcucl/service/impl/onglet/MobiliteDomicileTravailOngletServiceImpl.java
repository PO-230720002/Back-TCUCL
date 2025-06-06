package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.mobiliteDomicileTravail.MobiliteDomicileTravailOngletDto;
import tcucl.back_tcucl.dto.onglet.mobiliteDomicileTravail.MobiliteDomicileTravailResultatDto;
import tcucl.back_tcucl.entity.facteurEmission.FacteurEmissionParametre;
import tcucl.back_tcucl.entity.onglet.GeneralOnglet;
import tcucl.back_tcucl.entity.onglet.MobiliteDomicileTravailOnglet;
import tcucl.back_tcucl.exceptionPersonnalisee.AucunEtudiantEnregistre;
import tcucl.back_tcucl.exceptionPersonnalisee.AucunSalarieEnregistre;
import tcucl.back_tcucl.manager.MobiliteDomicileTravailOngletManager;
import tcucl.back_tcucl.service.FacteurEmissionService;
import tcucl.back_tcucl.service.GeneralOngletService;
import tcucl.back_tcucl.service.MobiliteDomicileTravailOngletService;

@Service
public class MobiliteDomicileTravailOngletServiceImpl implements MobiliteDomicileTravailOngletService {

    private final MobiliteDomicileTravailOngletManager mobiliteDomicileTravailOngletManager;
    private final FacteurEmissionService facteurEmissionService;
    private final GeneralOngletService generalOngletService;

    public MobiliteDomicileTravailOngletServiceImpl(MobiliteDomicileTravailOngletManager mobiliteDomicileTravailOngletManager, FacteurEmissionService facteurEmissionService, GeneralOngletService generalOngletService) {
        this.mobiliteDomicileTravailOngletManager = mobiliteDomicileTravailOngletManager;
        this.facteurEmissionService = facteurEmissionService;
        this.generalOngletService = generalOngletService;
    }

    @Override
    public MobiliteDomicileTravailOnglet getMobiliteDomicileTravailOngletById(Long ongletId) {
        return mobiliteDomicileTravailOngletManager.getMobiliteDomicileTravailOngletById(ongletId);
    }

    @Override
    public void updateMobiliteDomicileTravailOngletPartiel(Long ongletId, MobiliteDomicileTravailOngletDto mobiliteDomicileTravailOngletDto) {
        mobiliteDomicileTravailOngletManager.updateMobiliteDomicileTravailOngletPartiel(ongletId, mobiliteDomicileTravailOngletDto);
    }

    @Override
    public MobiliteDomicileTravailResultatDto getMobiliteDomicileTravailResultat(Long ongletId) {
        MobiliteDomicileTravailOnglet mobiliteOnglet = mobiliteDomicileTravailOngletManager.getMobiliteDomicileTravailOngletById(ongletId);
        MobiliteDomicileTravailResultatDto mobiliteResultatDto = new MobiliteDomicileTravailResultatDto();

        Integer voitureThermiqueEtudiantKm = mobiliteOnglet.getVoitureThermiqueEtudiantKm();
        Integer voitureThermiqueSalarieKm = mobiliteOnglet.getVoitureThermiqueSalarieKm();
        Float facteurEmissionVoitureThermique = facteurEmissionService.findByCategorieAndType(
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL,
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL_.VOITURE_THERMIQUE)
                .getFacteurEmission();

        mobiliteResultatDto.setEmissionGesVoitureThermique((float)
                (voitureThermiqueEtudiantKm + voitureThermiqueSalarieKm) * facteurEmissionVoitureThermique / 1000
        );

        Integer voitureElectriqueEtudiantKm = mobiliteOnglet.getVoitureElectriqueEtudiantKm();
        Integer voitureElectriqueSalarieKm = mobiliteOnglet.getVoitureElectriqueSalarieKm();
        Float facteurEmissionVoitureElectrique = facteurEmissionService.findByCategorieAndType(
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL,
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL_.VOITURE_ELECTRIQUE)
                .getFacteurEmission();

        mobiliteResultatDto.setEmissionGesVoitureElectrique((float)
                (voitureElectriqueEtudiantKm + voitureElectriqueSalarieKm) * facteurEmissionVoitureElectrique / 1000
        );

        Integer voitureHybrideEtudiantKm = mobiliteOnglet.getVoitureHybrideEtudiantKm();
        Integer voitureHybrideSalarieKm = mobiliteOnglet.getVoitureHybrideSalarieKm();
        Float facteurEmissionVoitureHybride = facteurEmissionService.findByCategorieAndType(
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL,
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL_.VOITURE_HYBRIDE)
                .getFacteurEmission();

        mobiliteResultatDto.setEmissionGesVoitureHybride((float)
                (voitureHybrideEtudiantKm + voitureHybrideSalarieKm) * facteurEmissionVoitureHybride / 1000
        );

        Integer motoEtudiantKm = mobiliteOnglet.getMotoEtudiantKm();
        Integer motoSalarieKm = mobiliteOnglet.getMotoSalarieKm();
        Float facteurEmissionMoto = facteurEmissionService.findByCategorieAndType(
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL,
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL_.MOTO)
                .getFacteurEmission();

        mobiliteResultatDto.setEmissionGesMoto((float)
                (motoEtudiantKm + motoSalarieKm) * facteurEmissionMoto / 1000
        );

        Integer trainRegionalEtudiantKm = mobiliteOnglet.getTrainRegionalEtudiantKm();
        Integer trainRegionalSalarieKm = mobiliteOnglet.getTrainRegionalSalarieKm();
        Float facteurEmissionTrainRegional = facteurEmissionService.findByCategorieAndType(
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL,
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL_.TRAIN_REGIONAL)
                .getFacteurEmission();

        mobiliteResultatDto.setEmissionGesTrainRegional((float)
                (trainRegionalEtudiantKm + trainRegionalSalarieKm) * facteurEmissionTrainRegional / 1000
        );

        Integer busEtudiantKm = mobiliteOnglet.getBusEtudiantKm();
        Integer busSalarieKm = mobiliteOnglet.getBusSalarieKm();
        Float facteurEmissionBus = facteurEmissionService.findByCategorieAndType(
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL,
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL_.BUS)
                .getFacteurEmission();

        mobiliteResultatDto.setEmissionGesBus((float)
                (busEtudiantKm + busSalarieKm) * facteurEmissionBus / 1000
        );

        Integer metroTramwayEtudiantKm = mobiliteOnglet.getMetroTramwayEtudiantKm();
        Integer metroTramwaySalarieKm = mobiliteOnglet.getMetroTramwaySalarieKm();
        Float facteurEmissionMetroTramway = facteurEmissionService.findByCategorieAndType(
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL,
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL_.METRO_TRAMWAY)
                .getFacteurEmission();

        mobiliteResultatDto.setEmissionGesMetroTramway((float)
                (metroTramwayEtudiantKm + metroTramwaySalarieKm) * facteurEmissionMetroTramway / 1000
        );

        Integer veloEtudiantKm = mobiliteOnglet.getVeloEtudiantKm();
        Integer veloSalarieKm = mobiliteOnglet.getVeloSalarieKm();
        Float facteurEmissionVelo = facteurEmissionService.findByCategorieAndType(
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL,
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL_.VELO)
                .getFacteurEmission();

        mobiliteResultatDto.setEmissionGesVelo((float)
                (veloEtudiantKm + veloSalarieKm) * facteurEmissionVelo / 1000
        );

        Integer trottinetteElectriqueEtudiantKm = mobiliteOnglet.getTrottinetteElectriqueEtudiantKm();
        Integer trottinetteElectriqueSalarieKm = mobiliteOnglet.getTrottinetteElectriqueSalarieKm();
        Float facteurEmissionTrotinetteElectrique = facteurEmissionService.findByCategorieAndType(
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL,
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL_.TROTTINETTE_ELECTRIQUE)
                .getFacteurEmission();

        mobiliteResultatDto.setEmissionGesTrotinetteElectrique((float)
                (trottinetteElectriqueEtudiantKm + trottinetteElectriqueSalarieKm) * facteurEmissionTrotinetteElectrique / 1000
        );

        Integer veloElectriqueEtudiantKm = mobiliteOnglet.getVeloElectriqueEtudiantKm();
        Integer veloElectriqueSalarieKm = mobiliteOnglet.getVeloElectriqueSalarieKm();
        Float facteurEmissionVeloElectrique = facteurEmissionService.findByCategorieAndType(
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL,
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL_.VELO_ELECTRIQUE)
                .getFacteurEmission();

        mobiliteResultatDto.setEmissionGesVeloElectrique((float)
                (veloElectriqueEtudiantKm + veloElectriqueSalarieKm) * facteurEmissionVeloElectrique / 1000
        );

        Integer marcheAPiedEtudiantKm = mobiliteOnglet.getMarcheAPiedEtudiantKm();
        Integer marcheAPiedSalarieKm = mobiliteOnglet.getMarcheAPiedSalarieKm();
        Float facteurEmissionMarcheAPied = facteurEmissionService.findByCategorieAndType(
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL,
                        FacteurEmissionParametre.MOBILITE_DOMICILE_TRAVAIL_.MARCHE_A_PIED)
                .getFacteurEmission();

        mobiliteResultatDto.setEmissionGesMarcheAPied((float)
                (marcheAPiedEtudiantKm + marcheAPiedSalarieKm) * facteurEmissionMarcheAPied / 1000
        );

//        Integer nbSalarie = generalOngletService.getGeneralOngletById(ongletGeneralId).getNbSalarie();
//        Integer nbEtudiant = generalOngletService.getGeneralOngletById(ongletGeneralId).getNbEtudiant();

        GeneralOnglet ongletDeClass = mobiliteOnglet.getOngletDeClass(GeneralOnglet.class);
        Float nbSalarie = (float) ongletDeClass.getNbSalarie();
        Float nbEtudiant = (float) ongletDeClass.getNbEtudiant();

        Float totalEmissionEtudiants =
                (mobiliteOnglet.getVoitureThermiqueEtudiantKm() * facteurEmissionVoitureThermique
                        + mobiliteOnglet.getVoitureElectriqueEtudiantKm() * facteurEmissionVoitureElectrique
                        + mobiliteOnglet.getVoitureHybrideEtudiantKm() * facteurEmissionVoitureHybride
                        + mobiliteOnglet.getMotoEtudiantKm() * facteurEmissionMoto
                        + mobiliteOnglet.getTrainRegionalEtudiantKm() * facteurEmissionTrainRegional
                        + mobiliteOnglet.getBusEtudiantKm() * facteurEmissionBus
                        + mobiliteOnglet.getMetroTramwayEtudiantKm() * facteurEmissionMetroTramway
                        + mobiliteOnglet.getVeloEtudiantKm() * facteurEmissionVelo
                        + mobiliteOnglet.getTrottinetteElectriqueEtudiantKm() * facteurEmissionTrotinetteElectrique
                        + mobiliteOnglet.getVeloElectriqueEtudiantKm() * facteurEmissionVeloElectrique
                        + mobiliteOnglet.getMarcheAPiedEtudiantKm() * facteurEmissionMarcheAPied) / 1000;

        mobiliteResultatDto.setTotalEtudiants(totalEmissionEtudiants);

        Float totalEmissionSalaries =
                (mobiliteOnglet.getVoitureThermiqueSalarieKm() * facteurEmissionVoitureThermique +
                        mobiliteOnglet.getVoitureElectriqueSalarieKm() * facteurEmissionVoitureElectrique +
                        mobiliteOnglet.getVoitureHybrideSalarieKm() * facteurEmissionVoitureHybride +
                        mobiliteOnglet.getMotoSalarieKm() * facteurEmissionMoto +
                        mobiliteOnglet.getTrainRegionalSalarieKm() * facteurEmissionTrainRegional +
                        mobiliteOnglet.getBusSalarieKm() * facteurEmissionBus +
                        mobiliteOnglet.getMetroTramwaySalarieKm() * facteurEmissionMetroTramway +
                        mobiliteOnglet.getVeloSalarieKm() * facteurEmissionVelo +
                        mobiliteOnglet.getTrottinetteElectriqueSalarieKm() * facteurEmissionTrotinetteElectrique +
                        mobiliteOnglet.getVeloElectriqueSalarieKm() * facteurEmissionVeloElectrique +
                        mobiliteOnglet.getMarcheAPiedSalarieKm() * facteurEmissionMarcheAPied) / 1000;

        mobiliteResultatDto.setTotalSalaries(totalEmissionSalaries);

        mobiliteResultatDto.setNombreDeJoursDeDeplacementEtudiants((float) mobiliteOnglet.getNbJoursDeplacementEtudiant());
        mobiliteResultatDto.setNombreDeJoursDeDeplacementSalaries((float) mobiliteOnglet.getNbJoursDeplacementSalarie());

        Float sommeDistanceSalarie = (float) mobiliteOnglet.getVoitureThermiqueSalarieKm() +
                mobiliteOnglet.getVoitureElectriqueSalarieKm() +
                mobiliteOnglet.getVoitureHybrideSalarieKm() +
                mobiliteOnglet.getMotoSalarieKm() +
                mobiliteOnglet.getTrainRegionalSalarieKm() +
                mobiliteOnglet.getBusSalarieKm() +
                mobiliteOnglet.getMetroTramwaySalarieKm() +
                mobiliteOnglet.getVeloSalarieKm() +
                mobiliteOnglet.getTrottinetteElectriqueSalarieKm() +
                mobiliteOnglet.getVeloElectriqueSalarieKm() +
                mobiliteOnglet.getMarcheAPiedSalarieKm();
        Float sommeDistanceEtudiant = (float) mobiliteOnglet.getVoitureThermiqueEtudiantKm() +
                mobiliteOnglet.getVoitureElectriqueEtudiantKm() +
                mobiliteOnglet.getVoitureHybrideEtudiantKm() +
                mobiliteOnglet.getMotoEtudiantKm() +
                mobiliteOnglet.getTrainRegionalEtudiantKm() +
                mobiliteOnglet.getBusEtudiantKm() +
                mobiliteOnglet.getMetroTramwayEtudiantKm() +
                mobiliteOnglet.getVeloEtudiantKm() +
                mobiliteOnglet.getTrottinetteElectriqueEtudiantKm() +
                mobiliteOnglet.getVeloElectriqueEtudiantKm() +
                mobiliteOnglet.getMarcheAPiedEtudiantKm();


        if (nbSalarie == 0) {
            throw new AucunSalarieEnregistre();
        }

        if (nbEtudiant == 0) {
            throw new AucunEtudiantEnregistre();

        }

        mobiliteResultatDto.setDistanceAnnuelleParUsagerSalaries(sommeDistanceSalarie / nbSalarie);
        mobiliteResultatDto.setDistanceAnnuelleParUsagerEtudiants(sommeDistanceEtudiant / nbEtudiant);

        mobiliteResultatDto.setDistanceDomicileTravailMoyenneSalaries(
                mobiliteResultatDto.getDistanceAnnuelleParUsagerSalaries() / (
                        mobiliteOnglet.getNbJoursDeplacementSalarie() * 2
                )
        );
        mobiliteResultatDto.setDistanceDomicileTravailMoyenneEtudiants(
                mobiliteResultatDto.getDistanceAnnuelleParUsagerEtudiants() / (
                        mobiliteOnglet.getNbJoursDeplacementEtudiant() * 2
                )
        );


        mobiliteResultatDto.setPartModaleVoitureThermiqueSalaries((float)
                (mobiliteOnglet.getVoitureThermiqueSalarieKm()
                        + mobiliteOnglet.getVoitureHybrideEtudiantKm()
                        + mobiliteOnglet.getMotoSalarieKm()) / sommeDistanceSalarie
        );
        mobiliteResultatDto.setPartModaleVoitureThermiqueEtudiants((float)
                (mobiliteOnglet.getVoitureThermiqueEtudiantKm()
                        + mobiliteOnglet.getVoitureHybrideEtudiantKm()
                        + mobiliteOnglet.getMotoEtudiantKm()) / sommeDistanceEtudiant
        );

        mobiliteResultatDto.setPartModaleVoitureElectriqueSalaries((float)
                (mobiliteOnglet.getVoitureElectriqueSalarieKm()) / sommeDistanceSalarie
        );
        mobiliteResultatDto.setPartModaleVoitureElectriqueEtudiants((float)
                (mobiliteOnglet.getVoitureElectriqueEtudiantKm()) / sommeDistanceEtudiant
        );

        mobiliteResultatDto.setPartModaleModesDouxSalaries((float)
                (mobiliteOnglet.getTrainRegionalSalarieKm()
                        + mobiliteOnglet.getBusSalarieKm()
                        + mobiliteOnglet.getMetroTramwaySalarieKm()
                        + mobiliteOnglet.getVeloSalarieKm()
                        + mobiliteOnglet.getTrottinetteElectriqueSalarieKm()
                        + mobiliteOnglet.getVeloElectriqueSalarieKm()
                        + mobiliteOnglet.getMarcheAPiedSalarieKm()) / sommeDistanceSalarie
        );
        mobiliteResultatDto.setPartModaleModesDouxEtudiants((float)
                (mobiliteOnglet.getTrainRegionalEtudiantKm()
                        + mobiliteOnglet.getBusEtudiantKm()
                        + mobiliteOnglet.getMetroTramwayEtudiantKm()
                        + mobiliteOnglet.getVeloEtudiantKm()
                        + mobiliteOnglet.getTrottinetteElectriqueEtudiantKm()
                        + mobiliteOnglet.getVeloElectriqueEtudiantKm()
                        + mobiliteOnglet.getMarcheAPiedEtudiantKm()) / sommeDistanceEtudiant
        );

        mobiliteResultatDto.setIntensiteCarboneMoyenSalaries(
                mobiliteResultatDto.totalSalaries*1000000f/sommeDistanceSalarie
        );
        mobiliteResultatDto.setIntensiteCarboneMoyenEtudiants(
                mobiliteResultatDto.totalEtudiants*1000000f/sommeDistanceEtudiant
        );


        return mobiliteResultatDto;
    }


}