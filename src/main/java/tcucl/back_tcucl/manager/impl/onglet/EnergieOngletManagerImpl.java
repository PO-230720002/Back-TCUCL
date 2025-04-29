package tcucl.back_tcucl.manager.impl.onglet;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.onglet.EnergieOngletUpdateDto;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_NomReseauVille;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteBois;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteFioul;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteGaz;
import tcucl.back_tcucl.repository.onglet.EnergieOngletRepository;
import tcucl.back_tcucl.manager.EnergieOngletManager;

import java.util.Random;

@Component
public class EnergieOngletManagerImpl implements EnergieOngletManager {

    private final EnergieOngletRepository energieOngletRepository;

    public EnergieOngletManagerImpl(EnergieOngletRepository energieOngletRepository) {
        this.energieOngletRepository = energieOngletRepository;
    }

    @Override
    public EnergieOnglet getEnergieOngletById(Long id) {
        return energieOngletRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("EnergieOnglet non trouvé avec l'ID : " + id));
    }

    @Override
    public EnergieOnglet createRandomEnergieOnglet() {
        EnergieOnglet energieOnglet = new EnergieOnglet();
        Random random = new Random();
        energieOnglet.setEstTermine(false);
        energieOnglet.setConsoGaz(random.nextFloat());
        energieOnglet.setConsoFioul(random.nextFloat());
        energieOnglet.setConsoBois(random.nextFloat());
        energieOnglet.setConsoReseauVille(random.nextFloat());
        energieOnglet.setConsoElecChauffage(random.nextFloat());
        energieOnglet.setConsoElecSpecifique(random.nextFloat());
        energieOnglet.setConsoEau(random.nextFloat());
        energieOnglet.setNote("Note aléatoire (mais du coup non)");

        energieOnglet.setNomReseauVille(EnumEnergie_NomReseauVille.LILLE);
        energieOnglet.setUniteBois(EnumEnergie_UniteBois.TONNE);
        energieOnglet.setUniteFioul(EnumEnergie_UniteFioul.M3);
        energieOnglet.setUniteGaz(EnumEnergie_UniteGaz.M3);

        return energieOngletRepository.save(energieOnglet);

    }

    @Override
    public EnergieOnglet updateEnergieOnglet(EnergieOnglet energieOnglet) {
        return energieOngletRepository.save(energieOnglet);
    }

    @Override
    public void updateEnergieOngletPartiel(Long id, EnergieOngletUpdateDto dto) {
        EnergieOnglet onglet = getEnergieOngletById(id);
        if (dto.getConsoGaz() != null) {
            onglet.setConsoGaz(dto.getConsoGaz());
        }
        if (dto.getConsoFioul() != null) {
            onglet.setConsoFioul(dto.getConsoFioul());
        }
        if (dto.getConsoBois() != null) {
            onglet.setConsoBois(dto.getConsoBois());
        }
        if (dto.getConsoReseauVille() != null) {
            onglet.setConsoReseauVille(dto.getConsoReseauVille());
        }
        if (dto.getConsoElecChauffage() != null) {
            onglet.setConsoElecChauffage(dto.getConsoElecChauffage());
        }
        if (dto.getConsoElecSpecifique() != null) {
            onglet.setConsoElecSpecifique(dto.getConsoElecSpecifique());
        }
        if (dto.getConsoEau() != null) {
            onglet.setConsoEau(dto.getConsoEau());
        }
        if (dto.getNote() != null) {
            onglet.setNote(dto.getNote());
        }
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

    @Override
    public void setEstTermine(Long id, boolean estTermine) {
        EnergieOnglet onglet = getEnergieOngletById(id);
        onglet.setEstTermine(estTermine);
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

    @Override
    public void setConsoGaz(Long id, Float consoGaz) {
        EnergieOnglet onglet = getEnergieOngletById(id);
        onglet.setConsoGaz(consoGaz);
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

    @Override
    public void setConsoFioul(Long id, Float consoFioul) {
        EnergieOnglet onglet = getEnergieOngletById(id);
        onglet.setConsoFioul(consoFioul);
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

    @Override
    public void setConsoBois(Long id, Float consoBois) {
        EnergieOnglet onglet = getEnergieOngletById(id);
        onglet.setConsoBois(consoBois);
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

    @Override
    public void setConsoReseauVille(Long id, Float consoReseauVille) {
        EnergieOnglet onglet = getEnergieOngletById(id);
        onglet.setConsoReseauVille(consoReseauVille);
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

    @Override
    public void setConsoElecChauffage(Long id, Float consoElecChauffage) {
        EnergieOnglet onglet = getEnergieOngletById(id);
        onglet.setConsoElecChauffage(consoElecChauffage);
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

    @Override
    public void setConsoElecSpecifique(Long id, Float consoElecSpecifique) {
        EnergieOnglet onglet = getEnergieOngletById(id);
        onglet.setConsoElecSpecifique(consoElecSpecifique);
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

    @Override
    public void setConsoEau(Long id, Float consoEau) {
        EnergieOnglet onglet = getEnergieOngletById(id);
        onglet.setConsoEau(consoEau);
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

    @Override
    public void setNote(Long id, String note) {
        EnergieOnglet onglet = getEnergieOngletById(id);
        onglet.setNote(note);
        energieOngletRepository.save(onglet); // Hibernate gère la mise à jour
    }

    @Override
    public void setNomReseauVille(Long id, EnumEnergie_NomReseauVille nomReseauVille) {
        EnergieOnglet parametreEnergie = getEnergieOngletById(id); // Récupère l'entité
        parametreEnergie.setNomReseauVille(nomReseauVille); // Modifie le champ
        updateEnergieOnglet(parametreEnergie); // Sauvegarde l'entité modifiée
    }

    @Override
    public void setUniteBois(Long id, EnumEnergie_UniteBois uniteBois) {
        EnergieOnglet parametreEnergie = getEnergieOngletById(id); // Récupère l'entité
        parametreEnergie.setUniteBois(uniteBois); // Modifie le champ
        updateEnergieOnglet(parametreEnergie); // Sauvegarde l'entité modifiée
    }

    @Override
    public void setUniteFioul(Long id, EnumEnergie_UniteFioul uniteFioul) {
        EnergieOnglet parametreEnergie = getEnergieOngletById(id); // Récupère l'entité
        parametreEnergie.setUniteFioul(uniteFioul); // Modifie le champ
        updateEnergieOnglet(parametreEnergie); // Sauvegarde l'entité modifiée
    }


    @Override
    public void setUniteGaz(Long id, EnumEnergie_UniteGaz uniteGaz) {
        EnergieOnglet parametreEnergie = getEnergieOngletById(id); // Récupère l'entité
        parametreEnergie.setUniteGaz(uniteGaz); // Modifie le champ
        updateEnergieOnglet(parametreEnergie); // Sauvegarde l'entité modifiée
    }


}
