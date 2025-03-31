package tcucl.back_tcucl.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.CreationEntiteDto;
import tcucl.back_tcucl.dto.InscriptionDto;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.entity.Utilisateur;
import tcucl.back_tcucl.service.ParametreService;
import tcucl.back_tcucl.service.AuthentificationService;
import tcucl.back_tcucl.service.EntiteService;
import tcucl.back_tcucl.service.UtilisateurService;

import static tcucl.back_tcucl.Constante.ADMIN_TRUE;
import static tcucl.back_tcucl.Constante.MDP_BIEN_MIS_A_JOUR;

@Service
public class ParametreServiceImpl implements ParametreService {

    private final EntiteService entiteService;
    private final UtilisateurService utilisateurService;

    public ParametreServiceImpl(EntiteService entiteService, UtilisateurService utilisateurService, AuthentificationService authentificationService) {
        this.entiteService = entiteService;
        this.utilisateurService = utilisateurService;
    }


    @Override
    public ResponseEntity<?> changePassword(ChangePasswordDto changePasswordDto) {
        utilisateurService.changePassword(changePasswordDto);
        return ResponseEntity.ok(MDP_BIEN_MIS_A_JOUR);
    }

    @Override
    public void ajouterEntite(CreationEntiteDto creationEntiteDto) {

        //Creation puis récupération de l'entite
        Entite entite = entiteService.saveEntite(new Entite(
                creationEntiteDto.getNom(),
                creationEntiteDto.getType()
        ));

        //Inscription de l'utilisateur
        Utilisateur utilisateur = utilisateurService.inscrireUtilisateur(new InscriptionDto(
                        creationEntiteDto.getNomUtilisateur(),
                        creationEntiteDto.getPrenomUtilisateur(),
                        creationEntiteDto.getEmailUtilisateur(),
                        ADMIN_TRUE,
                        entite.getId()
        ));
    }


}
