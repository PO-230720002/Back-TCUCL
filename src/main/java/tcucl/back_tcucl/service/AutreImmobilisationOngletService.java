package tcucl.back_tcucl.service;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.onglet.autreImmobilisation.AutreImmobilisationOngletDto;
import tcucl.back_tcucl.entity.onglet.AutreImmobilisationOnglet;

@Service
public interface AutreImmobilisationOngletService {

    AutreImmobilisationOnglet getAutreImmobilisationOngletById(Long id);

    void updateAutreImmobilisationOngletPartiel(Long id, AutreImmobilisationOngletDto dto);
}
