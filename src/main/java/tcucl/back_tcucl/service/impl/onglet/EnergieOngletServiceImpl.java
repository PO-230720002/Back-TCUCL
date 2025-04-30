package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.EnergieOngletDto;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;
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
    public void updateEnergieOngletPartiel(Long id, EnergieOngletDto dto) {
        energieOngletManager.updateEnergieOngletPartiel(id, dto);
    }

    @Override
    public EnergieOnglet createRandomEnergieOnglet() {
        return energieOngletManager.createRandomEnergieOnglet();
    }


}
