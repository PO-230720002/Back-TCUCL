package tcucl.back_tcucl.service;

import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.Entite;

import java.util.List;


public interface EntiteService {

    Entite getEntiteById(Long id);

    Entite saveEntite(Entite entite);

    List<Entite> getAllEntites();
}
