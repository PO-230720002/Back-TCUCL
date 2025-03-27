package tcucl.back_tcucl.service.impl;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.repository.EntiteRepository;
import tcucl.back_tcucl.service.EntiteService;

@Service
public class EntiteServiceImpl implements EntiteService {

    private EntiteRepository entiteRepository;

    @Override
    public Entite getEntiteById(Long id) {
        return entiteRepository.findEntiteBy(id);
    }
}
