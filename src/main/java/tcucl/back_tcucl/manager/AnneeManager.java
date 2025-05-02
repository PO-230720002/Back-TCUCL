package tcucl.back_tcucl.manager;

import tcucl.back_tcucl.dto.securite.AnneeSecuriteDto;

import java.util.List;


public interface AnneeManager {

    List<AnneeSecuriteDto> findAnneesSecurityByEntiteId(Long entiteId);

}
