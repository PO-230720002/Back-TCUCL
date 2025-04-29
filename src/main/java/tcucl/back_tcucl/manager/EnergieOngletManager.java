package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.EnergieOngletUpdateDto;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_NomReseauVille;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteBois;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteFioul;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteGaz;

public interface EnergieOngletManager {

    public EnergieOnglet getEnergieOngletById(Long id);

    public EnergieOnglet createRandomEnergieOnglet();

    public EnergieOnglet updateEnergieOnglet(EnergieOnglet energieOnglet);

    public void updateEnergieOngletPartiel(Long id, EnergieOngletUpdateDto dto);

    public void setEstTermine(Long id, boolean estTermine);

    public void setConsoGaz(Long id, Float consoGaz);

    public void setConsoFioul(Long id, Float consoFioul);

    public void setConsoBois(Long id, Float consoBois);

    public void setConsoReseauVille(Long id, Float consoReseauVille);

    public void setConsoElecChauffage(Long id, Float consoElecChauffage);

    public void setConsoElecSpecifique(Long id, Float consoElecSpecifique);

    public void setConsoEau(Long id, Float consoEau);

    public void setNote(Long id, String note);

    public void setNomReseauVille(Long id, EnumEnergie_NomReseauVille nomReseauVille);

    public void setUniteBois(Long id, EnumEnergie_UniteBois uniteBois);

    public void setUniteFioul(Long id, EnumEnergie_UniteFioul uniteFioul);

    public void setUniteGaz(Long id, EnumEnergie_UniteGaz uniteGaz);
}

