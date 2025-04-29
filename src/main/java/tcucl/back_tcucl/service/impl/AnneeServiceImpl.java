package tcucl.back_tcucl.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.securite.AnneeSecuriteDto;
import tcucl.back_tcucl.manager.AnneeManager;
import tcucl.back_tcucl.service.AnneeService;

import java.util.List;

@Service
public class AnneeServiceImpl implements AnneeService {

    private final AnneeManager anneeManager;

    public AnneeServiceImpl(AnneeManager anneeManager) {
        this.anneeManager = anneeManager;
    }

    @Override
    public List<AnneeSecuriteDto> getAnneeSecuriteDtoByEntiteId(Long entiteId) {
        return anneeManager.findAnneesSecurityByEntiteId(entiteId);
    }
}
