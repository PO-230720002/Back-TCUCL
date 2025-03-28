package tcucl.back_tcucl.service;

import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.Entite;


public interface EntiteService {

    Entite getEntiteById(Long id);
}
