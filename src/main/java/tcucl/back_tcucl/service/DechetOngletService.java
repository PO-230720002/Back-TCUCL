package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.dechet.DechetOngletDto;
import tcucl.back_tcucl.entity.onglet.DechetOnglet;

public interface DechetOngletService {
    DechetOnglet getDechetOngletById(Long id);

    void updateDechetOngletPartiel(Long id, DechetOngletDto dto);

}
