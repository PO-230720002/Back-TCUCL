package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.achat.AchatOngletDto;
import tcucl.back_tcucl.entity.onglet.achat.AchatOnglet;
import tcucl.back_tcucl.manager.AchatOngletManager;
import tcucl.back_tcucl.service.AchatOngletService;

@Service
public class AchatOngletServiceImpl implements AchatOngletService {

    private final AchatOngletManager achatOngletManager;

    public AchatOngletServiceImpl(AchatOngletManager achatOngletManager) {
        this.achatOngletManager = achatOngletManager;
    }

    @Override
    public AchatOnglet getAchatOngletById(Long ongletId) {
        return achatOngletManager.getAchatOngletById(ongletId);
    }

    @Override
    public void updateAchatOngletPartiel(Long ongletId, AchatOngletDto achatOngletDto) {
        achatOngletManager.updateAchatOngletPartiel(ongletId, achatOngletDto);
    }
}
