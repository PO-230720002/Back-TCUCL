package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.EnergieOngletDto;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_NomReseauVille;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteBois;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteFioul;
import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteGaz;

public interface EnergieOngletService {

    public EnergieOnglet getEnergieOngletById(Long id);

    public EnergieOnglet createRandomEnergieOnglet();

    public void updateEnergieOngletPartiel(Long id, EnergieOngletDto dto);
}
