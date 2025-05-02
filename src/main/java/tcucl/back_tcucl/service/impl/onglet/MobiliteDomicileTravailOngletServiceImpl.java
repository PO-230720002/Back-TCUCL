package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.mobiliteDomicileTravail.MobiliteDomicileTravailOngletDto;
import tcucl.back_tcucl.entity.onglet.MobiliteDomicileTravailOnglet;
import tcucl.back_tcucl.manager.MobiliteDomicileTravailOngletManager;
import tcucl.back_tcucl.service.MobiliteDomicileTravailOngletService;

@Service
public class MobiliteDomicileTravailOngletServiceImpl implements MobiliteDomicileTravailOngletService {

    private final MobiliteDomicileTravailOngletManager mobiliteDomicileTravailOngletManager;

    public MobiliteDomicileTravailOngletServiceImpl(MobiliteDomicileTravailOngletManager mobiliteDomicileTravailOngletManager) {
        this.mobiliteDomicileTravailOngletManager = mobiliteDomicileTravailOngletManager;
    }

    @Override
    public MobiliteDomicileTravailOnglet getMobiliteDomicileTravailOngletById(Long id) {
        return mobiliteDomicileTravailOngletManager.getMobiliteDomicileTravailOngletById(id);
    }

    @Override
    public void updateMobiliteDomicileTravailOngletPartiel(Long id, MobiliteDomicileTravailOngletDto dto) {
        mobiliteDomicileTravailOngletManager.updateMobiliteDomicileTravailOngletPartiel(id, dto);
    }



}