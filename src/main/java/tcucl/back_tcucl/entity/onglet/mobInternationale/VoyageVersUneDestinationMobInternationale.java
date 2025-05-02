package tcucl.back_tcucl.entity.onglet.mobInternationale;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import tcucl.back_tcucl.entity.onglet.mobInternationale.enums.EnumMobInternationale_NomPays;

import java.util.Set;

@Entity
@Table(name = "voyage_mob_internationale")
public class VoyageVersUneDestinationMobInternationale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer valeurEnumMobInternationale_NomPays;
    private Integer prosAvion;
    private Integer prosTrain;
    private Integer stagesEtudiantsAvion;
    private Integer stagesEtudiantsTrain;
    private Integer semestresEtudiantsAvion;
    private Integer semestresEtudiantsTrain;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public EnumMobInternationale_NomPays getNomPays() {
        return this.valeurEnumMobInternationale_NomPays != null ? EnumMobInternationale_NomPays.fromCode(this.valeurEnumMobInternationale_NomPays) : null;
    }

    public void setNomPays(EnumMobInternationale_NomPays valeur) {
        this.valeurEnumMobInternationale_NomPays = valeur.getCode();
    }

    public Integer getProsAvion() {

        return prosAvion;
    }

    public void setProsAvion(int prosAvion) {
        this.prosAvion = prosAvion;
    }

    public Integer getProsTrain() {
        return prosTrain;
    }

    public void setProsTrain(int prosTrain) {
        this.prosTrain = prosTrain;
    }

    public Integer getStagesEtudiantsAvion() {
        return stagesEtudiantsAvion;
    }

    public void setStagesEtudiantsAvion(int stagesEtudiantsAvion) {
        this.stagesEtudiantsAvion = stagesEtudiantsAvion;
    }

    public Integer getStagesEtudiantsTrain() {
        return stagesEtudiantsTrain;
    }

    public void setStagesEtudiantsTrain(int stagesEtudiantsTrain) {
        this.stagesEtudiantsTrain = stagesEtudiantsTrain;
    }

    public Integer getSemestresEtudiantsAvion() {
        return semestresEtudiantsAvion;
    }

    public void setSemestresEtudiantsAvion(int semestresEtudiantsAvion) {
        this.semestresEtudiantsAvion = semestresEtudiantsAvion;
    }

    public Integer getSemestresEtudiantsTrain() {
        return semestresEtudiantsTrain;
    }

    public void setSemestresEtudiantsTrain(int semestresEtudiantsTrain) {
        this.semestresEtudiantsTrain = semestresEtudiantsTrain;
    }


    @AssertTrue(message = "Les champs train ne doivent pas être remplis pour ce pays.")
    public boolean isTrainExistForThisDestination() {
        if (PAYS_PAS_DE_TRAJET_EN_TRAIN.contains(valeurEnumMobInternationale_NomPays)) {
            return prosTrain == 0 && stagesEtudiantsTrain == 0 && semestresEtudiantsTrain == 0;
        }
        return true;
    }

//    EXEMPLE UTILISATION VALIDATOR DANS UN CONTROLEUR
//    @PostMapping("/test")
//    public ResponseEntity<?> test(@Valid @RequestBody VOYAGEMOBETC, BindingResult result) { binding -> stock le résulat de la validation
//        if (result.hasErrors()) {
//            return ResponseEntity.badRequest().body(result.getAllErrors());
//        }
//        return ResponseEntity.ok("Tout est bon !");
//    }

    private static final Set<Integer> PAYS_PAS_DE_TRAJET_EN_TRAIN = Set.of(
            EnumMobInternationale_NomPays.ALBANIE.getCode(),
            EnumMobInternationale_NomPays.BULGARIE.getCode(),
            EnumMobInternationale_NomPays.CROATIE.getCode(),
            EnumMobInternationale_NomPays.ESTONIE.getCode(),
            EnumMobInternationale_NomPays.FINLANDE.getCode(),
            EnumMobInternationale_NomPays.GRECE.getCode(),
            EnumMobInternationale_NomPays.HONGRIE.getCode(),
            EnumMobInternationale_NomPays.IRLANDE.getCode(),
            EnumMobInternationale_NomPays.ISLANDE.getCode(),
            EnumMobInternationale_NomPays.LETTONIE.getCode(),
            EnumMobInternationale_NomPays.LITUANIE.getCode(),
            EnumMobInternationale_NomPays.MACEDOINE.getCode(),
            EnumMobInternationale_NomPays.NORVEGE.getCode(),
            EnumMobInternationale_NomPays.POLOGNE.getCode(),
            EnumMobInternationale_NomPays.ROUMANIE.getCode(),
            EnumMobInternationale_NomPays.SLOVAQUIE.getCode(),
            EnumMobInternationale_NomPays.SLOVENIE.getCode(),
            EnumMobInternationale_NomPays.SUEDE.getCode(),
            EnumMobInternationale_NomPays.AFRIQUE_DU_SUD.getCode(),
            EnumMobInternationale_NomPays.ALGERIE.getCode(),
            EnumMobInternationale_NomPays.ANGOLA.getCode(),
            EnumMobInternationale_NomPays.ARABIE_SAOUDITE.getCode(),
            EnumMobInternationale_NomPays.ARGENTINE.getCode(),
            EnumMobInternationale_NomPays.AUSTRALIE.getCode(),
            EnumMobInternationale_NomPays.AZERBAIDJAN.getCode(),
            EnumMobInternationale_NomPays.BAHREIN.getCode(),
            EnumMobInternationale_NomPays.BANGLADESH.getCode(),
            EnumMobInternationale_NomPays.BENIN.getCode(),
            EnumMobInternationale_NomPays.BOLIVIE.getCode(),
            EnumMobInternationale_NomPays.BRESIL.getCode(),
            EnumMobInternationale_NomPays.BURKINA_FASO.getCode(),
            EnumMobInternationale_NomPays.CAMBODGE.getCode(),
            EnumMobInternationale_NomPays.CAMEROUN.getCode(),
            EnumMobInternationale_NomPays.CANADA.getCode(),
            EnumMobInternationale_NomPays.CHILI.getCode(),
            EnumMobInternationale_NomPays.CHINE.getCode(),
            EnumMobInternationale_NomPays.CHYPRE.getCode(),
            EnumMobInternationale_NomPays.COLOMBIE.getCode(),
            EnumMobInternationale_NomPays.CONGO.getCode(),
            EnumMobInternationale_NomPays.COMORES.getCode(),
            EnumMobInternationale_NomPays.COREE_DU_SUD.getCode(),
            EnumMobInternationale_NomPays.COSTA_RICA.getCode(),
            EnumMobInternationale_NomPays.COTE_DIVOIRE.getCode(),
            EnumMobInternationale_NomPays.EGYPTE.getCode(),
            EnumMobInternationale_NomPays.EMIRATS_ARABES_UNIS.getCode(),
            EnumMobInternationale_NomPays.EQUATEUR.getCode(),
            EnumMobInternationale_NomPays.ETATS_UNIS.getCode(),
            EnumMobInternationale_NomPays.ETHIOPIE.getCode(),
            EnumMobInternationale_NomPays.GUATEMALA.getCode(),
            EnumMobInternationale_NomPays.FIDJI.getCode(),
            EnumMobInternationale_NomPays.GABON.getCode(),
            EnumMobInternationale_NomPays.GEORGIE.getCode(),
            EnumMobInternationale_NomPays.GHANA.getCode(),
            EnumMobInternationale_NomPays.HONG_KONG.getCode(),
            EnumMobInternationale_NomPays.INDE.getCode(),
            EnumMobInternationale_NomPays.INDONESIE.getCode(),
            EnumMobInternationale_NomPays.ISRAEL.getCode(),
            EnumMobInternationale_NomPays.JAPON.getCode(),
            EnumMobInternationale_NomPays.JORDANIE.getCode(),
            EnumMobInternationale_NomPays.KAZAKHSTAN.getCode(),
            EnumMobInternationale_NomPays.KIRGHIZISTAN.getCode(),
            EnumMobInternationale_NomPays.KENYA.getCode(),
            EnumMobInternationale_NomPays.LAOS.getCode(),
            EnumMobInternationale_NomPays.KOSOVO.getCode(),
            EnumMobInternationale_NomPays.LIBAN.getCode(),
            EnumMobInternationale_NomPays.MADAGASCAR.getCode(),
            EnumMobInternationale_NomPays.MALAISIE.getCode(),
            EnumMobInternationale_NomPays.MALI.getCode(),
            EnumMobInternationale_NomPays.MALTE.getCode(),
            EnumMobInternationale_NomPays.MAROC.getCode(),
            EnumMobInternationale_NomPays.MAURICE.getCode(),
            EnumMobInternationale_NomPays.MAURITANIE.getCode(),
            EnumMobInternationale_NomPays.MEXIQUE.getCode(),
            EnumMobInternationale_NomPays.MONGOLIE.getCode(),
            EnumMobInternationale_NomPays.MOZAMBIQUE.getCode(),
            EnumMobInternationale_NomPays.NAMIBIE.getCode(),
            EnumMobInternationale_NomPays.NEPAL.getCode(),
            EnumMobInternationale_NomPays.NICARAGUA.getCode(),
            EnumMobInternationale_NomPays.NIGERIA.getCode(),
            EnumMobInternationale_NomPays.NOUVELLE_ZELANDE.getCode(),
            EnumMobInternationale_NomPays.PANAMA.getCode(),
            EnumMobInternationale_NomPays.PEROU.getCode(),
            EnumMobInternationale_NomPays.PHILIPPINES.getCode(),
            EnumMobInternationale_NomPays.POLYNESIE_FRANCAISE.getCode(),
            EnumMobInternationale_NomPays.QATAR.getCode(),
            EnumMobInternationale_NomPays.REPUBLIQUE_DOMINICAINE.getCode(),
            EnumMobInternationale_NomPays.REPUBLIQUE_CENTRAFRICAINE.getCode(),
            EnumMobInternationale_NomPays.REPUBLIQUE_TCHEQUE.getCode(),
            EnumMobInternationale_NomPays.RWANDA.getCode(),
            EnumMobInternationale_NomPays.RUSSIE.getCode(),
            EnumMobInternationale_NomPays.SENEGAL.getCode(),
            EnumMobInternationale_NomPays.SINGAPOUR.getCode(),
            EnumMobInternationale_NomPays.SRI_LANKA.getCode(),
            EnumMobInternationale_NomPays.TAIWAN.getCode(),
            EnumMobInternationale_NomPays.THAILANDE.getCode(),
            EnumMobInternationale_NomPays.TOGO.getCode(),
            EnumMobInternationale_NomPays.TUNISIE.getCode(),
            EnumMobInternationale_NomPays.TURQUIE.getCode(),
            EnumMobInternationale_NomPays.UKRAINE.getCode(),
            EnumMobInternationale_NomPays.URUGUAY.getCode(),
            EnumMobInternationale_NomPays.VIETNAM.getCode(),
            EnumMobInternationale_NomPays.ZIMBABWE.getCode()
    );
}
