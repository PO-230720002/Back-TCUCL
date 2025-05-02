package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.onglet.autreImmobilisation.AutreImmobilisationOngletDto;
import tcucl.back_tcucl.entity.onglet.AutreImmobilisationOnglet;

public interface AutreImmobilisationOngletManager {
    AutreImmobilisationOnglet getAutreImmobilisationOngletById(Long id);

    void updateAutreImmobilisationOngletPartiel(Long id, AutreImmobilisationOngletDto dto);
}
