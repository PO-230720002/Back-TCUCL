package tcucl.back_tcucl.controller.administration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.dto.CreationEntiteDto;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.service.ParametreService;
import tcucl.back_tcucl.service.EntiteService;

import static tcucl.back_tcucl.Constante.*;

@RestController
@RequestMapping(ADMINISTRATION)
public class EntiteController {

    private final EntiteService entiteService;
    private final ParametreService parametreService;

    public EntiteController(EntiteService entiteService, ParametreService parametreService) {
        this.entiteService = entiteService;
        this.parametreService = parametreService;
    }

    @GetMapping
    public ResponseEntity<?> getAllEntite() {
        return ResponseEntity.ok(entiteService.getAllEntites());
    }





    @PostMapping(ID)
    public ResponseEntity<?> saveEntite(Entite entite) {
        return ResponseEntity.ok(entiteService.saveEntite(entite));
    }


}
