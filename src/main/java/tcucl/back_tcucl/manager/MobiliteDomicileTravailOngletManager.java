package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.MobiliteDomicileTravailOngletDto;
import tcucl.back_tcucl.entity.onglet.MobiliteDomicileTravailOnglet;

public interface MobiliteDomicileTravailOngletManager {

    MobiliteDomicileTravailOnglet getMobiliteDomicileTravailOngletById(Long id);

    void updateMobiliteDomicileTravailOngletPartiel(Long id, MobiliteDomicileTravailOngletDto dto);

}
