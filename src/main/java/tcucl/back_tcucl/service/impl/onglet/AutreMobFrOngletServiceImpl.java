package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.autreMobFr.AutreMobFrOngletDto;
import tcucl.back_tcucl.entity.onglet.AutreMobFrOnglet;
import tcucl.back_tcucl.manager.AutreMobFrOngletManager;
import tcucl.back_tcucl.service.AutreMobFrOngletService;

@Service
public class AutreMobFrOngletServiceImpl implements AutreMobFrOngletService {

    private final AutreMobFrOngletManager autreMobFrOngletManager;

    public AutreMobFrOngletServiceImpl(AutreMobFrOngletManager autreMobFrOngletManager) {
        this.autreMobFrOngletManager = autreMobFrOngletManager;
    }

    @Override
    public AutreMobFrOnglet getAutreMobFrOngletById(Long id) {
        return autreMobFrOngletManager.getAutreMobFrOngletById(id);
    }

    @Override
    public void updateAutreMobFrOngletPartiel(Long id, AutreMobFrOngletDto autreMobFrOngletDto) {
        autreMobFrOngletManager.updateAutreMobFrOngletPartiel(id, autreMobFrOngletDto);
    }
}
