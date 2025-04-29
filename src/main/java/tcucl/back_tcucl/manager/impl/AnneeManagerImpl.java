package tcucl.back_tcucl.manager.impl;

import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.securite.AnneeSecuriteDto;
import tcucl.back_tcucl.manager.AnneeManager;
import tcucl.back_tcucl.repository.AnneeRepository;

import java.util.List;

@Component
public class AnneeManagerImpl implements AnneeManager {

    private final AnneeRepository anneeRepository;

    public AnneeManagerImpl(AnneeRepository anneeRepository) {
        this.anneeRepository = anneeRepository;
    }

    @Override
    public List<AnneeSecuriteDto> findAnneesSecurityByEntiteId(Long entiteId) {
        return anneeRepository.findAnneesSecurityByEntiteId(entiteId);
    }
}
