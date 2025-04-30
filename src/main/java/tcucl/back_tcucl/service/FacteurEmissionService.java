package tcucl.back_tcucl.service;

import org.springframework.web.multipart.MultipartFile;

public interface FacteurEmissionService {
    String importFromExcel(MultipartFile file);

}
