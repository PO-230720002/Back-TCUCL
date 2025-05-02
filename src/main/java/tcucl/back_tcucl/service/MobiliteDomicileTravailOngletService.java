package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.MobiliteDomicileTravailOngletDto;
import tcucl.back_tcucl.entity.onglet.MobiliteDomicileTravailOnglet;

public interface MobiliteDomicileTravailOngletService {
    public MobiliteDomicileTravailOnglet getMobiliteDomicileTravailOngletById(Long id);

    public void updateMobiliteDomicileTravailOngletPartiel(Long id, MobiliteDomicileTravailOngletDto dto);
}