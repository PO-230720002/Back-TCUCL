package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.general.GeneralOngletDto;
import tcucl.back_tcucl.entity.onglet.GeneralOnglet;
import tcucl.back_tcucl.manager.GeneralOngletManager;
import tcucl.back_tcucl.service.GeneralOngletService;

@Service
public class GeneralOngletServiceImpl implements GeneralOngletService {

    private final GeneralOngletManager generalOngletManager;

    public GeneralOngletServiceImpl(GeneralOngletManager generalOngletRepository) {
        this.generalOngletManager = generalOngletRepository;
    }

    @Override
    public GeneralOnglet getGeneralOngletById(Long id) {
        return generalOngletManager.getGeneralOngletById(id);
    }

    @Override
    public void updateGeneralOngletPartiel(Long id, GeneralOngletDto dto) {
        generalOngletManager.updateGeneralOngletPartiel(id, dto);
    }
}
