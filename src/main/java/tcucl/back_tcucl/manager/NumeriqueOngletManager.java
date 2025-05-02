package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.numerique.EquipementNumeriqueDto;
import tcucl.back_tcucl.dto.onglet.numerique.NumeriqueOngletDto;
import tcucl.back_tcucl.entity.onglet.NumeriqueOnglet;
import tcucl.back_tcucl.entity.parametre.numerique.EquipementNumerique;

public interface NumeriqueOngletManager {
    NumeriqueOnglet getNumeriqueOngletById(Long id);

    EquipementNumerique getEquipementNumeriqueById(Long ongletId, Long equipementId);

    void updateNumeriqueOngletPartiel(Long id, NumeriqueOngletDto dto);

    void ajouterEquipementNumerique(Long id, EquipementNumeriqueDto equipementNumeriqueDto);

    void supprimerEquipementNumerique(Long ongletId, Long equipementId);

    void updateEquipementNumeriquePartiel(Long ongletId, Long equipementId, EquipementNumeriqueDto equipementNumeriqueDto);
}
