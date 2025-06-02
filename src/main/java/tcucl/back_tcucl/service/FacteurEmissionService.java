package tcucl.back_tcucl.service;

import org.springframework.web.multipart.MultipartFile;
import tcucl.back_tcucl.entity.FacteurEmission;

public interface FacteurEmissionService {

    void importFromExcel(MultipartFile file);


    FacteurEmission findByCategorieAndTypeAndUnite(String categorie, String type, String unite);
}
