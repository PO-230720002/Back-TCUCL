package tcucl.back_tcucl.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_NomReseauVille;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteBois;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteFioul;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteGaz;
import tcucl.back_tcucl.repository.parametre.ParametreEnergieRepository;
import tcucl.back_tcucl.service.ParametreEnergieOngletService;


@Service
public class ParametreEnergieOngletServiceImpl implements ParametreEnergieOngletService {

    private final ParametreEnergieRepository repository;

    public ParametreEnergieOngletServiceImpl(ParametreEnergieRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void setNomReseauVille(Long id, String nomReseauVille) {
        int updated = repository.setReseauVille(id, EnumEnergie_NomReseauVille.valueOf(nomReseauVille).getCode());
        if (updated == 0) {
            throw new EntityNotFoundException("ParametreEnergie non trouvé avec l'ID : " + id);
        }
    }

    @Transactional
    public void setUniteBois(Long id, String uniteBois) {
        int updated = repository.setUniteBois(id, EnumEnergie_UniteBois.valueOf(uniteBois).getCode());
        if (updated == 0) {
            throw new EntityNotFoundException("ParametreEnergie non trouvé avec l'ID : " + id);
        }
    }

    @Transactional
    public void setUniteFioul(Long id, String uniteFioul) {
        int updated = repository.setUniteFioul(id, EnumEnergie_UniteFioul.valueOf(uniteFioul).getCode());
        if (updated == 0) {
            throw new EntityNotFoundException("ParametreEnergie non trouvé avec l'ID : " + id);
        }
    }

    @Transactional
    public void setUniteGaz(Long id, String uniteGaz) {
        int updated = repository.setUniteGaz(id, EnumEnergie_UniteGaz.valueOf(uniteGaz).getCode());
        if (updated == 0) {
            throw new EntityNotFoundException("ParametreEnergie non trouvé avec l'ID : " + id);
        }
    }

    
}
