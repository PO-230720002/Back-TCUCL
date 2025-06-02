package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.energie.EnergieOngletDto;
import tcucl.back_tcucl.entity.onglet.energie.EnergieOnglet;
import tcucl.back_tcucl.manager.EnergieOngletManager;
import tcucl.back_tcucl.service.EnergieOngletService;

@Service
public class EnergieOngletServiceImpl implements EnergieOngletService {

    private final EnergieOngletManager energieOngletManager;

    public EnergieOngletServiceImpl(EnergieOngletManager energieOngletManager) {
        this.energieOngletManager = energieOngletManager;
    }

    @Override
    public EnergieOnglet getEnergieOngletById(Long ongletId) {
        return energieOngletManager.getEnergieOngletById(ongletId);
    }

    @Override
    public void updateEnergieOngletPartiel(Long ongletId, EnergieOngletDto energieOngletDto) {
        energieOngletManager.updateEnergieOngletPartiel(ongletId, energieOngletDto);
    }



}
