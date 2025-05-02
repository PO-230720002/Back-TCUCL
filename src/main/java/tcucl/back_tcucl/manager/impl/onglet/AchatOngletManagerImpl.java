package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.achat.AchatConsommableDto;
import tcucl.back_tcucl.dto.onglet.achat.AchatOngletDto;
import tcucl.back_tcucl.dto.onglet.achat.AchatRestaurationDto;
import tcucl.back_tcucl.dto.onglet.achat.AchatTextileDto;
import tcucl.back_tcucl.entity.onglet.AchatOnglet;
import tcucl.back_tcucl.entity.parametre.achat.AchatConsommable;
import tcucl.back_tcucl.entity.parametre.achat.AchatRestauration;
import tcucl.back_tcucl.entity.parametre.achat.AchatTextile;
import tcucl.back_tcucl.manager.AchatOngletManager;
import tcucl.back_tcucl.repository.onglet.AchatOngletRepository;

@Component
public class AchatOngletManagerImpl implements AchatOngletManager {
    
    private final AchatOngletRepository achatOngletRepository;

    public AchatOngletManagerImpl(AchatOngletRepository achatOngletRepository) {
        this.achatOngletRepository = achatOngletRepository;
    }


    @Override
    public AchatOnglet getAchatOngletById(Long id) {
        return achatOngletRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AchatOnglet non trouvé avec l'Id: " + id));
    }



    @Override
    public void updateAchatOngletPartiel(Long id, AchatOngletDto dto) {
        AchatOnglet onglet = getAchatOngletById(id);

        if (dto.getEstTermine() != null) {
            onglet.setEstTermine(dto.getEstTermine());
        }
        if (dto.getNote() != null) {
            onglet.setNote(dto.getNote());
        }

        // --- AchatConsommable ---
        if (dto.getAchatConsommable() != null) {
            AchatConsommable cible = onglet.getAchatConsommable();
            if (cible == null) {
                cible = new AchatConsommable();
                onglet.setAchatConsommable(cible);
            }
            AchatConsommableDto source = dto.getAchatConsommable();
            if (source.getPapier_T() != null) cible.setPapier_T(source.getPapier_T());
            if (source.getPapier_nb() != null) cible.setPapier_nb(source.getPapier_nb());
            if (source.getLivres_T() != null) cible.setLivres_T(source.getLivres_T());
            if (source.getLivres_nb() != null) cible.setLivres_nb(source.getLivres_nb());
            if (source.getCartonNeuf_T() != null) cible.setCartonNeuf_T(source.getCartonNeuf_T());
            if (source.getCartonRecycle_T() != null) cible.setCartonRecycle_T(source.getCartonRecycle_T());
            if (source.getPetitesFournitures_Eur() != null) cible.setPetitesFournitures_Eur(source.getPetitesFournitures_Eur());
            if (source.getNbFeuillesImprimeesJetEncre_Nb() != null) cible.setNbFeuillesImprimeesJetEncre_Nb(source.getNbFeuillesImprimeesJetEncre_Nb());
            if (source.getNbFeuillesImprimeesToner_Nb() != null) cible.setNbFeuillesImprimeesToner_Nb(source.getNbFeuillesImprimeesToner_Nb());
            if (source.getProduitsPharmaceutiques_Eur() != null) cible.setProduitsPharmaceutiques_Eur(source.getProduitsPharmaceutiques_Eur());
        }

        // --- AchatRestauration ---
        if (dto.getAchatRestauration() != null) {
            AchatRestauration cible = onglet.getAchatRestauration();
            if (cible == null) {
                cible = new AchatRestauration();
                onglet.setAchatRestauration(cible);
            }
            AchatRestaurationDto source = dto.getAchatRestauration();
            if (source.getMethode() != null) cible.setMethodeCalcul(source.getMethode());
            if (source.getMethodeRapideNombrePersonnesServiesRegimeClassique() != null)
                cible.setMethodeRapideNombrePersonnesServiesRegimeClassique(source.getMethodeRapideNombrePersonnesServiesRegimeClassique());
            if (source.getMethodeRapideNombrePersonnesServiesRegimeFlexitarien() != null)
                cible.setMethodeRapideNombrePersonnesServiesRegimeFlexitarien(source.getMethodeRapideNombrePersonnesServiesRegimeFlexitarien());
            if (source.getNombreRepasServisDominanteAnimaleBoeuf() != null) cible.setNombreRepasServisDominanteAnimaleBoeuf(source.getNombreRepasServisDominanteAnimaleBoeuf());
            if (source.getNombreRepasServisDominanteAnimalePoulet() != null) cible.setNombreRepasServisDominanteAnimalePoulet(source.getNombreRepasServisDominanteAnimalePoulet());
            if (source.getNombreRepasServisDominanteVegetaleBoeuf() != null) cible.setNombreRepasServisDominanteVegetaleBoeuf(source.getNombreRepasServisDominanteVegetaleBoeuf());
            if (source.getNombreRepasServisDominanteVegetalePoulet() != null) cible.setNombreRepasServisDominanteVegetalePoulet(source.getNombreRepasServisDominanteVegetalePoulet());
            if (source.getNombreRepasServisDominanteClassiqueBoeuf() != null) cible.setNombreRepasServisDominanteClassiqueBoeuf(source.getNombreRepasServisDominanteClassiqueBoeuf());
            if (source.getNombreRepasServisDominanteClassiquePoulet() != null) cible.setNombreRepasServisDominanteClassiquePoulet(source.getNombreRepasServisDominanteClassiquePoulet());
            if (source.getNombreRepasServisRepasMoyen() != null) cible.setNombreRepasServisRepasMoyen(source.getNombreRepasServisRepasMoyen());
            if (source.getNombreRepasServisRepasVegetarien() != null) cible.setNombreRepasServisRepasVegetarien(source.getNombreRepasServisRepasVegetarien());
            if (source.getBoeufAgneauMouton_Tonnes() != null) cible.setBoeufAgneauMouton_Tonnes(source.getBoeufAgneauMouton_Tonnes());
            if (source.getPoulet_Tonnes() != null) cible.setPoulet_Tonnes(source.getPoulet_Tonnes());
            if (source.getCafe_Tonnes() != null) cible.setCafe_Tonnes(source.getCafe_Tonnes());
            if (source.getChocolat_Tonnes() != null) cible.setChocolat_Tonnes(source.getChocolat_Tonnes());
            if (source.getBeurre_Tonnes() != null) cible.setBeurre_Tonnes(source.getBeurre_Tonnes());
            if (source.getViandesMoyenne_Tonnes() != null) cible.setViandesMoyenne_Tonnes(source.getViandesMoyenne_Tonnes());
            if (source.getProduitsSucresMoyenne_Tonnes() != null) cible.setProduitsSucresMoyenne_Tonnes(source.getProduitsSucresMoyenne_Tonnes());
            if (source.getPoissonsMoyenne_Tonnes() != null) cible.setPoissonsMoyenne_Tonnes(source.getPoissonsMoyenne_Tonnes());
            if (source.getFromagesMoyenne_Tonnes() != null) cible.setFromagesMoyenne_Tonnes(source.getFromagesMoyenne_Tonnes());
            if (source.getOleagineuxMoyenne_Tonnes() != null) cible.setOleagineuxMoyenne_Tonnes(source.getOleagineuxMoyenne_Tonnes());
            if (source.getMatieresGrassesMoyenne_Tonnes() != null) cible.setMatieresGrassesMoyenne_Tonnes(source.getMatieresGrassesMoyenne_Tonnes());
            if (source.getBoissonsMoyenne_Tonnes() != null) cible.setBoissonsMoyenne_Tonnes(source.getBoissonsMoyenne_Tonnes());
            if (source.getOeufs_Tonnes() != null) cible.setOeufs_Tonnes(source.getOeufs_Tonnes());
            if (source.getCerealesMoyenne_Tonnes() != null) cible.setCerealesMoyenne_Tonnes(source.getCerealesMoyenne_Tonnes());
            if (source.getLegumesMoyenne_Tonnes() != null) cible.setLegumesMoyenne_Tonnes(source.getLegumesMoyenne_Tonnes());
            if (source.getFruitsMoyenne_Tonnes() != null) cible.setFruitsMoyenne_Tonnes(source.getFruitsMoyenne_Tonnes());
            if (source.getLegumineuseMoyenne_Tonnes() != null) cible.setLegumineuseMoyenne_Tonnes(source.getLegumineuseMoyenne_Tonnes());
        }

        // --- AchatTextile ---
        if (dto.getAchatTextile() != null) {
            AchatTextile cible = onglet.getAchatTextile();
            if (cible == null) {
                cible = new AchatTextile();
                onglet.setAchatTextile(cible);
            }
            AchatTextileDto source = dto.getAchatTextile();
            if (source.getChemise_nb() != null) cible.setChemise_nb(source.getChemise_nb());
            if (source.getPolaire_nb() != null) cible.setPolaire_nb(source.getPolaire_nb());
            if (source.getPull_Acrylique_nb() != null) cible.setPull_Acrylique_nb(source.getPull_Acrylique_nb());
            if (source.getPull_Coton_nb() != null) cible.setPull_Coton_nb(source.getPull_Coton_nb());
            if (source.getT_shirt_polyester_nb() != null) cible.setT_shirt_polyester_nb(source.getT_shirt_polyester_nb());
            if (source.getJean_nb() != null) cible.setJean_nb(source.getJean_nb());
            if (source.getSweat_nb() != null) cible.setSweat_nb(source.getSweat_nb());
            if (source.getVeste_Anorak_nb() != null) cible.setVeste_Anorak_nb(source.getVeste_Anorak_nb());
            if (source.getManteau_nb() != null) cible.setManteau_nb(source.getManteau_nb());
            if (source.getChaussure_nb() != null) cible.setChaussure_nb(source.getChaussure_nb());
        }

        achatOngletRepository.save(onglet); // Hibernate mettra à jour en cascade
    }

}
