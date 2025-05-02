package tcucl.back_tcucl.service.impl;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.dechet.DechetOngletDto;
import tcucl.back_tcucl.entity.onglet.DechetOnglet;
import tcucl.back_tcucl.manager.DechetOngletManager;
import tcucl.back_tcucl.service.DechetOngletService;

@Service
public class DechetOngletServiceImpl implements DechetOngletService {

    private final DechetOngletManager dechetOngletManager;

    public DechetOngletServiceImpl(DechetOngletManager dechetOngletManager) {
        this.dechetOngletManager = dechetOngletManager;
    }

    @Override
    public DechetOnglet getDechetOngletById(Long id) {
        return dechetOngletManager.getDechetOngletById(id);
    }

    @Override
    public void updateDechetOngletPartiel(Long id, DechetOngletDto dto) {
        dechetOngletManager.updateDechetOngletPartiel(id, dto);
    }
}
