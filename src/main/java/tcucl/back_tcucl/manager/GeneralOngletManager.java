package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.general.GeneralOngletDto;
import tcucl.back_tcucl.entity.onglet.GeneralOnglet;

public interface GeneralOngletManager {

    GeneralOnglet getGeneralOngletById(Long id);

    void updateGeneralOngletPartiel(Long id, GeneralOngletDto dto);
}
