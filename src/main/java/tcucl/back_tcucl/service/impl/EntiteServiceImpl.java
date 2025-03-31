package tcucl.back_tcucl.service.impl;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.repository.EntiteRepository;
import tcucl.back_tcucl.service.EntiteService;

import java.util.List;

@Service
public class EntiteServiceImpl implements EntiteService {

    private EntiteRepository entiteRepository;

    public EntiteServiceImpl(EntiteRepository entiteRepository) {
        this.entiteRepository = entiteRepository;
    }

    @Override
    public Entite getEntiteById(Long id) {
        return entiteRepository.findEntiteById(id);
    }

    @Override
    public Entite saveEntite(Entite entite) {
        return entiteRepository.save(entite);
    }

    @Override
    public List<Entite> getAllEntites() {
        return entiteRepository.findAll();
    }
}
