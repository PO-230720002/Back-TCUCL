package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.dechet.DechetOngletDto;
import tcucl.back_tcucl.entity.onglet.DechetOnglet;

public interface DechetOngletManager {
    DechetOnglet getDechetOngletById(Long id);

    void updateDechetOngletPartiel(Long id, DechetOngletDto dto);
}
