package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.EnergieOngletDto;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;

public interface EnergieOngletManager {

    public EnergieOnglet getEnergieOngletById(Long id);

    public EnergieOnglet createRandomEnergieOnglet();

    public EnergieOnglet updateEnergieOnglet(EnergieOnglet energieOnglet);

    public void updateEnergieOngletPartiel(Long id, EnergieOngletDto dto);

}

