package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.entity.Entite;

import java.util.List;

public interface EntiteManager {
    Entite getEntitebyId(Long id);
    Entite save(Entite entite);
    List<Entite> getAll();

    boolean existsEntiteByNomAndType(String nom, String type);
}
