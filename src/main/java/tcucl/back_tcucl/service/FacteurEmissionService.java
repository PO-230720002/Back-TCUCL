package tcucl.back_tcucl.service;

import org.springframework.web.multipart.MultipartFile;

public interface FacteurEmissionService {

    void importFromExcel(MultipartFile file);

}
