package tcucl.back_tcucl.service;

import tcucl.back_tcucl.dto.onglet.energie.EnergieOngletDto;
import tcucl.back_tcucl.entity.onglet.energie.EnergieOnglet;

public interface EnergieOngletService {

    public EnergieOnglet getEnergieOngletById(Long id);

    public EnergieOnglet createRandomEnergieOnglet();

    public void updateEnergieOngletPartiel(Long id, EnergieOngletDto dto);
}
