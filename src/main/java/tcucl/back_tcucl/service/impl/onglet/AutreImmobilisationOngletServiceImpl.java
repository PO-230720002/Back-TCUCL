package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.autreImmobilisation.AutreImmobilisationOngletDto;
import tcucl.back_tcucl.entity.onglet.AutreImmobilisationOnglet;
import tcucl.back_tcucl.manager.AutreImmobilisationOngletManager;
import tcucl.back_tcucl.service.AutreImmobilisationOngletService;

@Service
public class AutreImmobilisationOngletServiceImpl implements AutreImmobilisationOngletService {

    private final AutreImmobilisationOngletManager autreImmobilisationOngletManager;

    public AutreImmobilisationOngletServiceImpl(AutreImmobilisationOngletManager autreImmobilisationOngletManager) {
        this.autreImmobilisationOngletManager = autreImmobilisationOngletManager;
    }

    @Override
    public AutreImmobilisationOnglet getAutreImmobilisationOngletById(Long id) {
        return autreImmobilisationOngletManager.getAutreImmobilisationOngletById(id);
    }

    @Override
    public void updateAutreImmobilisationOngletPartiel(Long id, AutreImmobilisationOngletDto dto) {
        autreImmobilisationOngletManager.updateAutreImmobilisationOngletPartiel(id, dto);
    }
}
