package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.achat.AchatOngletDto;
import tcucl.back_tcucl.entity.onglet.AchatOnglet;

public interface AchatOngletService {

    AchatOnglet getAchatOngletById(Long id);

    void updateAchatOngletPartiel(Long id, AchatOngletDto dto);
}
