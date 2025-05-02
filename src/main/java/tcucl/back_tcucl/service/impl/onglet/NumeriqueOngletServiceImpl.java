package tcucl.back_tcucl.service.impl.onglet;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.numerique.EquipementNumeriqueDto;
import tcucl.back_tcucl.dto.onglet.numerique.NumeriqueOngletDto;
import tcucl.back_tcucl.entity.onglet.NumeriqueOnglet;
import tcucl.back_tcucl.entity.parametre.numerique.EquipementNumerique;
import tcucl.back_tcucl.manager.NumeriqueOngletManager;
import tcucl.back_tcucl.service.NumeriqueOngletService;

@Service
public class NumeriqueOngletServiceImpl implements NumeriqueOngletService {

    private final NumeriqueOngletManager numeriqueOngletManager;

    public NumeriqueOngletServiceImpl(NumeriqueOngletManager numeriqueOngletManager) {
        this.numeriqueOngletManager = numeriqueOngletManager;
    }

    @Override
    public NumeriqueOnglet getNumeriqueOngletById(Long id) {
        return numeriqueOngletManager.getNumeriqueOngletById(id);
    }

    @Override
    public EquipementNumerique getEquipementNumeriqueById(Long ongletId, Long equipementId) {
        return numeriqueOngletManager.getEquipementNumeriqueById(ongletId, equipementId);
    }

    @Override
    public void updateNumeriqueOngletPartiel(Long id, NumeriqueOngletDto numeriqueOngletDto) {
        numeriqueOngletManager.updateNumeriqueOngletPartiel(id, numeriqueOngletDto);
    }

    @Override
    public void ajouterEquipementNumerique(Long id, EquipementNumeriqueDto equipementNumeriqueDto) {
        numeriqueOngletManager.ajouterEquipementNumerique(id, equipementNumeriqueDto);
    }

    @Override
    public void supprimerEquipementNumerique(Long ongletId, Long equipementId) {
        numeriqueOngletManager.supprimerEquipementNumerique(ongletId, equipementId);
    }

    @Override
    public void updateEquipementNumeriquePartiel(Long ongletId, Long equipementId, EquipementNumeriqueDto equipementNumeriqueDto) {
        numeriqueOngletManager.updateEquipementNumeriquePartiel(ongletId, equipementId, equipementNumeriqueDto);
    }
}
