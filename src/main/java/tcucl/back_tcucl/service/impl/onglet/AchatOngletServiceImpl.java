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
    public AchatOnglet getAchatOngletById(Long id) {
        return achatOngletManager.getAchatOngletById(id);
    }

    @Override
    public void updateAchatOngletPartiel(Long id, AchatOngletDto dto) {
        achatOngletManager.updateAchatOngletPartiel(id, dto);
    }
}
