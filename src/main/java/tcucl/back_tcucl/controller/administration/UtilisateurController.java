package tcucl.back_tcucl.controller.administration;

import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.service.UtilisateurService;

import static tcucl.back_tcucl.Constante.*;

@RestController
@RequestMapping(ADMINISTRATION + UTILISATEUR)
public class UtilisateurController {

    private final UtilisateurService utilisateurService;


    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }







}
