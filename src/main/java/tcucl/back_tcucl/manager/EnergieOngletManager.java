package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.energie.EnergieOngletDto;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;

public interface EnergieOngletManager {

    public EnergieOnglet getEnergieOngletById(Long id);

    public void updateEnergieOngletPartiel(Long id, EnergieOngletDto dto);

}

