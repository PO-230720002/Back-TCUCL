package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.mobiliteDomicileTravail.MobiliteDomicileTravailOngletDto;
import tcucl.back_tcucl.entity.onglet.MobiliteDomicileTravailOnglet;

public interface MobiliteDomicileTravailOngletService {
    public MobiliteDomicileTravailOnglet getMobiliteDomicileTravailOngletById(Long ongletId);

    public void updateMobiliteDomicileTravailOngletPartiel(Long ongletId, MobiliteDomicileTravailOngletDto dto);
}