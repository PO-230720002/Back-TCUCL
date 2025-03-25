package tcucl.back_tcucl.entity.onglet;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import tcucl.back_tcucl.entity.parametre.numerique.EquipementNumerique;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "numerique_onglet")
public class NumeriqueOnglet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Year annee;
    private boolean estTermine;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "equipement_numerique_id")
    List<EquipementNumerique> equipementNumeriqueList;

    private boolean useMethodSimplifiee;
    private Float TraficCloudUtilisateur;
    private Float TraficTipUtilisateur;
    private Integer PartTraficFranceEtranger;


    @AssertTrue(message = "Si useMethodSimplifiee est true, les autres champs doivent être null ou vides.")
    private boolean isUseMethodSimplifieeValid() {
        return !useMethodSimplifiee || (TraficCloudUtilisateur == null && TraficTipUtilisateur == null && PartTraficFranceEtranger == null);
    }



}
