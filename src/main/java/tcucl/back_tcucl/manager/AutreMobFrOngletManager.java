package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.AutreMobFrOngletDto;
import tcucl.back_tcucl.entity.onglet.AutreMobFrOnglet;

public interface AutreMobFrOngletManager {

    AutreMobFrOnglet getAutreMobFrOngletById(Long id);

    void updateAutreMobFrOngletPartiel(Long id, AutreMobFrOngletDto autreMobFrOngletDto);
}
