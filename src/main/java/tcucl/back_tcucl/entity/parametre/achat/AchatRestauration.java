package tcucl.back_tcucl.entity.parametre.achat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import tcucl.back_tcucl.entity.parametre.achat.enums.EnumAchatRestauration_Methode;

@Entity
@Table(name = "achat_restauration")
public class AchatRestauration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer EnumValeur_Methode;
    private Integer methodeRapideNombrePersonnesServiesRegimeClassique;
    private Integer methodeRapideNombrePersonnesServiesRegimeFlexitarien;

    private Integer nombreRepasServisDominanteAnimaleBoeuf;
    private Integer nombreRepasServisDominanteAnimalePoulet;
    private Integer nombreRepasServisDominanteVegetaleBoeuf;
    private Integer nombreRepasServisDominanteVegetalePoulet;
    private Integer nombreRepasServisDominanteClassiqueBoeuf;
    private Integer nombreRepasServisDominanteClassiquePoulet;
    private Integer nombreRepasServisRepasMoyen;
    private Integer nombreRepasServisRepasVegetarien;

    private Float boeufAgneauMouton_Tonnes;
    private Float poulet_Tonnes;
    private Float cafe_Tonnes;
    private Float chocolat_Tonnes;
    private Float beurre_Tonnes;
    private Float viandesMoyenne_Tonnes;
    private Float produitsSucresMoyenne_Tonnes;
    private Float poissonsMoyenne_Tonnes;
    private Float fromagesMoyenne_Tonnes;
    private Float oleagineuxMoyenne_Tonnes;
    private Float matieresGrassesMoyenne_Tonnes;
    private Float boissonsMoyenne_Tonnes;
    private Float oeufs_Tonnes;
    private Float cerealesMoyenne_Tonnes;
    private Float legumesMoyenne_Tonnes;
    private Float fruitsMoyenne_Tonnes;
    private Float legumineuseMoyenne_Tonnes;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMethodeCalcul(EnumAchatRestauration_Methode valeur) {
        this.EnumValeur_Methode = valeur.getCode();
    }

    public EnumAchatRestauration_Methode getMethodeCalcul() {
        return EnumAchatRestauration_Methode.fromCode(this.EnumValeur_Methode);
    }

    public Integer getMethodeRapideNombrePersonnesServiesRegimeClassique() {
        return methodeRapideNombrePersonnesServiesRegimeClassique;
    }

    public void setMethodeRapideNombrePersonnesServiesRegimeClassique(Integer methodeRapideNombrePersonnesServiesRegimeClassique) {
        this.methodeRapideNombrePersonnesServiesRegimeClassique = methodeRapideNombrePersonnesServiesRegimeClassique;
    }

    public Integer getMethodeRapideNombrePersonnesServiesRegimeFlexitarien() {
        return methodeRapideNombrePersonnesServiesRegimeFlexitarien;
    }

    public void setMethodeRapideNombrePersonnesServiesRegimeFlexitarien(Integer methodeRapideNombrePersonnesServiesRegimeFlexitarien) {
        this.methodeRapideNombrePersonnesServiesRegimeFlexitarien = methodeRapideNombrePersonnesServiesRegimeFlexitarien;
    }

    public Integer getNombreRepasServisDominanteAnimaleBoeuf() {
        return nombreRepasServisDominanteAnimaleBoeuf;
    }

    public void setNombreRepasServisDominanteAnimaleBoeuf(Integer nombreRepasServisDominanteAnimaleBoeuf) {
        this.nombreRepasServisDominanteAnimaleBoeuf = nombreRepasServisDominanteAnimaleBoeuf;
    }

    public Integer getNombreRepasServisDominanteAnimalePoulet() {
        return nombreRepasServisDominanteAnimalePoulet;
    }

    public void setNombreRepasServisDominanteAnimalePoulet(Integer nombreRepasServisDominanteAnimalePoulet) {
        this.nombreRepasServisDominanteAnimalePoulet = nombreRepasServisDominanteAnimalePoulet;
    }

    public Integer getNombreRepasServisDominanteVegetaleBoeuf() {
        return nombreRepasServisDominanteVegetaleBoeuf;
    }

    public void setNombreRepasServisDominanteVegetaleBoeuf(Integer nombreRepasServisDominanteVegetaleBoeuf) {
        this.nombreRepasServisDominanteVegetaleBoeuf = nombreRepasServisDominanteVegetaleBoeuf;
    }

    public Integer getNombreRepasServisDominanteVegetalePoulet() {
        return nombreRepasServisDominanteVegetalePoulet;
    }

    public void setNombreRepasServisDominanteVegetalePoulet(Integer nombreRepasServisDominanteVegetalePoulet) {
        this.nombreRepasServisDominanteVegetalePoulet = nombreRepasServisDominanteVegetalePoulet;
    }

    public Integer getNombreRepasServisDominanteClassiqueBoeuf() {
        return nombreRepasServisDominanteClassiqueBoeuf;
    }

    public void setNombreRepasServisDominanteClassiqueBoeuf(Integer nombreRepasServisDominanteClassiqueBoeuf) {
        this.nombreRepasServisDominanteClassiqueBoeuf = nombreRepasServisDominanteClassiqueBoeuf;
    }

    public Integer getNombreRepasServisDominanteClassiquePoulet() {
        return nombreRepasServisDominanteClassiquePoulet;
    }

    public void setNombreRepasServisDominanteClassiquePoulet(Integer nombreRepasServisDominanteClassiquePoulet) {
        this.nombreRepasServisDominanteClassiquePoulet = nombreRepasServisDominanteClassiquePoulet;
    }

    public Integer getNombreRepasServisRepasMoyen() {
        return nombreRepasServisRepasMoyen;
    }

    public void setNombreRepasServisRepasMoyen(Integer nombreRepasServisRepasMoyen) {
        this.nombreRepasServisRepasMoyen = nombreRepasServisRepasMoyen;
    }

    public Integer getNombreRepasServisRepasVegetarien() {
        return nombreRepasServisRepasVegetarien;
    }

    public void setNombreRepasServisRepasVegetarien(Integer nombreRepasServisRepasVegetarien) {
        this.nombreRepasServisRepasVegetarien = nombreRepasServisRepasVegetarien;
    }

    public Float getBoeufAgneauMouton_Tonnes() {
        return boeufAgneauMouton_Tonnes;
    }

    public void setBoeufAgneauMouton_Tonnes(Float boeufAgneauMouton_Tonnes) {
        this.boeufAgneauMouton_Tonnes = boeufAgneauMouton_Tonnes;
    }

    public Float getPoulet_Tonnes() {
        return poulet_Tonnes;
    }

    public void setPoulet_Tonnes(Float poulet_Tonnes) {
        this.poulet_Tonnes = poulet_Tonnes;
    }

    public Float getCafe_Tonnes() {
        return cafe_Tonnes;
    }

    public void setCafe_Tonnes(Float cafe_Tonnes) {
        this.cafe_Tonnes = cafe_Tonnes;
    }

    public Float getChocolat_Tonnes() {
        return chocolat_Tonnes;
    }

    public void setChocolat_Tonnes(Float chocolat_Tonnes) {
        this.chocolat_Tonnes = chocolat_Tonnes;
    }

    public Float getBeurre_Tonnes() {
        return beurre_Tonnes;
    }

    public void setBeurre_Tonnes(Float beurre_Tonnes) {
        this.beurre_Tonnes = beurre_Tonnes;
    }

    public Float getViandesMoyenne_Tonnes() {
        return viandesMoyenne_Tonnes;
    }

    public void setViandesMoyenne_Tonnes(Float viandesMoyenne_Tonnes) {
        this.viandesMoyenne_Tonnes = viandesMoyenne_Tonnes;
    }

    public Float getProduitsSucresMoyenne_Tonnes() {
        return produitsSucresMoyenne_Tonnes;
    }

    public void setProduitsSucresMoyenne_Tonnes(Float produitsSucresMoyenne_Tonnes) {
        this.produitsSucresMoyenne_Tonnes = produitsSucresMoyenne_Tonnes;
    }

    public Float getPoissonsMoyenne_Tonnes() {
        return poissonsMoyenne_Tonnes;
    }

    public void setPoissonsMoyenne_Tonnes(Float poissonsMoyenne_Tonnes) {
        this.poissonsMoyenne_Tonnes = poissonsMoyenne_Tonnes;
    }

    public Float getFromagesMoyenne_Tonnes() {
        return fromagesMoyenne_Tonnes;
    }

    public void setFromagesMoyenne_Tonnes(Float fromagesMoyenne_Tonnes) {
        this.fromagesMoyenne_Tonnes = fromagesMoyenne_Tonnes;
    }

    public Float getOleagineuxMoyenne_Tonnes() {
        return oleagineuxMoyenne_Tonnes;
    }

    public void setOleagineuxMoyenne_Tonnes(Float oleagineuxMoyenne_Tonnes) {
        this.oleagineuxMoyenne_Tonnes = oleagineuxMoyenne_Tonnes;
    }

    public Float getMatieresGrassesMoyenne_Tonnes() {
        return matieresGrassesMoyenne_Tonnes;
    }

    public void setMatieresGrassesMoyenne_Tonnes(Float matieresGrassesMoyenne_Tonnes) {
        this.matieresGrassesMoyenne_Tonnes = matieresGrassesMoyenne_Tonnes;
    }

    public Float getBoissonsMoyenne_Tonnes() {
        return boissonsMoyenne_Tonnes;
    }

    public void setBoissonsMoyenne_Tonnes(Float boissonsMoyenne_Tonnes) {
        this.boissonsMoyenne_Tonnes = boissonsMoyenne_Tonnes;
    }

    public Float getOeufs_Tonnes() {
        return oeufs_Tonnes;
    }

    public void setOeufs_Tonnes(Float oeufs_Tonnes) {
        this.oeufs_Tonnes = oeufs_Tonnes;
    }

    public Float getCerealesMoyenne_Tonnes() {
        return cerealesMoyenne_Tonnes;
    }

    public void setCerealesMoyenne_Tonnes(Float cerealesMoyenne_Tonnes) {
        this.cerealesMoyenne_Tonnes = cerealesMoyenne_Tonnes;
    }

    public Float getLegumesMoyenne_Tonnes() {
        return legumesMoyenne_Tonnes;
    }

    public void setLegumesMoyenne_Tonnes(Float legumesMoyenne_Tonnes) {
        this.legumesMoyenne_Tonnes = legumesMoyenne_Tonnes;
    }

    public Float getFruitsMoyenne_Tonnes() {
        return fruitsMoyenne_Tonnes;
    }

    public void setFruitsMoyenne_Tonnes(Float fruitsMoyenne_Tonnes) {
        this.fruitsMoyenne_Tonnes = fruitsMoyenne_Tonnes;
    }

    public Float getLegumineuseMoyenne_Tonnes() {
        return legumineuseMoyenne_Tonnes;
    }

    public void setLegumineuseMoyenne_Tonnes(Float legumineuseMoyenne_Tonnes) {
        this.legumineuseMoyenne_Tonnes = legumineuseMoyenne_Tonnes;
    }
}
