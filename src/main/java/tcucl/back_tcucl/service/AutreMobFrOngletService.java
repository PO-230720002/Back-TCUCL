package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.AutreMobFrOngletDto;
import tcucl.back_tcucl.entity.onglet.AutreMobFrOnglet;

public interface AutreMobFrOngletService {
    AutreMobFrOnglet getAutreMobFrOngletById(Long id);

    void updateAutreMobFrOngletPartiel(Long id, AutreMobFrOngletDto autreMobFrOngletDto);
}
