package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.dechet.DechetOngletDto;
import tcucl.back_tcucl.entity.onglet.dechet.DechetOnglet;

public interface DechetOngletService {
    DechetOnglet getDechetOngletById(Long ongletId);

    void updateDechetOngletPartiel(Long ongletId, DechetOngletDto dto);

}
