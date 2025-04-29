package tcucl.back_tcucl.manager.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.exceptionPersonnalisee.EntiteNonTrouveeIdException;
import tcucl.back_tcucl.manager.EntiteManager;
import tcucl.back_tcucl.repository.EntiteRepository;

import java.util.List;
import java.util.Optional;

@Component
public class EntiteManagerImpl implements EntiteManager {

    private final EntiteRepository entiteRepository;

    public EntiteManagerImpl(EntiteRepository entiteRepository) {
        this.entiteRepository = entiteRepository;
    }

    @Override
    public Entite getEntitebyId(Long id) {
        Optional<Entite> entite = entiteRepository.findById(id);
        if (entite.isEmpty()) {
            throw new EntiteNonTrouveeIdException(id);
        }
        return entite.get();

    }

    @Override
    public Entite save(Entite entite) {
        return entiteRepository.save(entite);
    }

    @Override
    public List<Entite> getAll() {
        return entiteRepository.findAll();
    }

    @Override
    public boolean existsEntiteByNomAndType(String nom, String type) {
        return entiteRepository.existsByNomAndType(nom, type);
    }
}
