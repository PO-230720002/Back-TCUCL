package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.dechet.DechetOngletDto;
import tcucl.back_tcucl.dto.onglet.numerique.NumeriqueResultatDto;
import tcucl.back_tcucl.entity.onglet.dechet.DechetOnglet;
import tcucl.back_tcucl.entity.onglet.numerique.NumeriqueOnglet;
import tcucl.back_tcucl.manager.DechetOngletManager;
import tcucl.back_tcucl.service.DechetOngletService;

@Service
public class DechetOngletServiceImpl implements DechetOngletService {

    private final DechetOngletManager dechetOngletManager;

    public DechetOngletServiceImpl(DechetOngletManager dechetOngletManager) {
        this.dechetOngletManager = dechetOngletManager;
    }

    @Override
    public DechetOnglet getDechetOngletById(Long ongletId) {
        return dechetOngletManager.getDechetOngletById(ongletId);
    }

    @Override
    public void updateDechetOngletPartiel(Long ongletId, DechetOngletDto dechetOngletDto) {
        dechetOngletManager.updateDechetOngletPartiel(ongletId, dechetOngletDto);
    }


}
