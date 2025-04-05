package tcucl.back_tcucl.service.impl;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.entity.NotesPermanentes;
import tcucl.back_tcucl.manager.EntiteManager;
import tcucl.back_tcucl.repository.EntiteRepository;
import tcucl.back_tcucl.service.EntiteService;

import java.util.List;

@Service
public class EntiteServiceImpl implements EntiteService {

    private EntiteManager entiteManager;

    public EntiteServiceImpl(EntiteManager entiteManager) {
        this.entiteManager = entiteManager;
    }

    @Override
    public Entite getEntiteById(Long id) {
        return entiteManager.getEntitebyId(id);
    }

    @Override
    public Entite saveEntite(Entite entite) {
        return entiteManager.save(entite);
    }

    @Override
    public Entite creerEntite(String nom, String type) {
        Entite entite = new Entite(nom, type);
        entite.setNotesPermanentes(new NotesPermanentes());
        entite.setAnnees();
    }

    @Override
    public List<Entite> getAllEntites() {
        return entiteManager.getAll();
    }
}
