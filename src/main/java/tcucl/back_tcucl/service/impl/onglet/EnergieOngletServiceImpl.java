package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.EnergieOngletUpdateDto;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_NomReseauVille;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteBois;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteFioul;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteGaz;
import tcucl.back_tcucl.manager.EnergieOngletManager;
import tcucl.back_tcucl.service.EnergieOngletService;

@Service
public class EnergieOngletServiceImpl implements EnergieOngletService {

    private final EnergieOngletManager energieOngletManager;

    public EnergieOngletServiceImpl(EnergieOngletManager energieOngletManager) {
        this.energieOngletManager = energieOngletManager;
    }


    @Override
    public EnergieOnglet getEnergieOngletById(Long id) {
        return energieOngletManager.getEnergieOngletById(id);
    }

    @Override
    public EnergieOnglet createRandomEnergieOnglet() {
        return energieOngletManager.createRandomEnergieOnglet();
    }

    @Override
    public EnergieOnglet updateEnergieOnglet(EnergieOnglet energieOnglet) {
        return energieOngletManager.updateEnergieOnglet(energieOnglet);
    }

    @Override
    public void updateEnergieOngletPartiel(Long id, EnergieOngletUpdateDto dto) {
        energieOngletManager.updateEnergieOngletPartiel(id, dto);
    }

    @Override
    public void setEstTermine(Long id, boolean estTermine) {
        energieOngletManager.setEstTermine(id, estTermine);
    }

    @Override
    public void setConsoGaz(Long id, Float consoGaz) {
        energieOngletManager.setConsoGaz(id, consoGaz);
    }

    @Override
    public void setConsoFioul(Long id, Float consoFioul) {
        energieOngletManager.setConsoFioul(id, consoFioul);
    }

    @Override
    public void setConsoBois(Long id, Float consoBois) {
        energieOngletManager.setConsoBois(id, consoBois);
    }

    @Override
    public void setConsoReseauVille(Long id, Float consoReseauVille) {
        energieOngletManager.setConsoReseauVille(id, consoReseauVille);
    }

    @Override
    public void setConsoElecChauffage(Long id, Float consoElecChauffage) {
        energieOngletManager.setConsoElecChauffage(id, consoElecChauffage);
    }

    @Override
    public void setConsoElecSpecifique(Long id, Float consoElecSpecifique) {
        energieOngletManager.setConsoElecSpecifique(id, consoElecSpecifique);
    }

    @Override
    public void setConsoEau(Long id, Float consoEau) {
        energieOngletManager.setConsoEau(id, consoEau);
    }

    @Override
    public void setNote(Long id, String note) {
        energieOngletManager.setNote(id, note);
    }

    @Override
    public void setNomReseauVille(Long id, EnumEnergie_NomReseauVille nomReseauVille) {
        energieOngletManager.setNomReseauVille(id, nomReseauVille);
    }

    @Override
    public void setUniteBois(Long id, EnumEnergie_UniteBois uniteBois) {
        energieOngletManager.setUniteBois(id, uniteBois);
    }

    @Override
    public void setUniteFioul(Long id, EnumEnergie_UniteFioul uniteFioul) {
        energieOngletManager.setUniteFioul(id, uniteFioul);
    }

    @Override
    public void setUniteGaz(Long id, EnumEnergie_UniteGaz uniteGaz) {
       energieOngletManager.setUniteGaz(id, uniteGaz);
    }

}
