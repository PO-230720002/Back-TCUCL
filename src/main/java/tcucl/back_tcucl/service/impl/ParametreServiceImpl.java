package tcucl.back_tcucl.service.impl;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.*;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.entity.Utilisateur;
import tcucl.back_tcucl.service.ParametreService;
import tcucl.back_tcucl.service.AuthentificationService;
import tcucl.back_tcucl.service.EntiteService;
import tcucl.back_tcucl.service.UtilisateurService;

import java.util.List;

import static tcucl.back_tcucl.Constante.ADMIN_TRUE;

@Service
public class ParametreServiceImpl implements ParametreService {

    private final EntiteService entiteService;
    private final UtilisateurService utilisateurService;

    public ParametreServiceImpl(EntiteService entiteService, UtilisateurService utilisateurService, AuthentificationService authentificationService) {
        this.entiteService = entiteService;
        this.utilisateurService = utilisateurService;
    }


    @Override
    public void changePassword(ChangePasswordDto changePasswordDto) {
        utilisateurService.changePassword(changePasswordDto);
    }

    @Override
    public void ajouterEntite(CreationEntiteDto creationEntiteDto) {

        //Creation puis récupération de l'entite
        Entite entite = entiteService.saveEntite(new Entite(
                creationEntiteDto.getNom(),
                creationEntiteDto.getType()
        ));

        //Inscription de l'utilisateur
        utilisateurService.inscrireUtilisateur(new InscriptionDto(
                        creationEntiteDto.getNomUtilisateur(),
                        creationEntiteDto.getPrenomUtilisateur(),
                        creationEntiteDto.getEmailUtilisateur(),
                        ADMIN_TRUE,
                        entite.getId()
        ));
    }


    @Override
    public List<UtilisateurDto> getAllUtilisateurParEntiteId(Long idEntite) {
        return utilisateurService.getAllUtilisateurParEntiteId(idEntite).stream().map(this::utilisateurToUtilisateurDto).toList();
    }

    private UtilisateurDto utilisateurToUtilisateurDto(Utilisateur utilisateur){
        return new UtilisateurDto(
                utilisateur.getId(),
                utilisateur.getNom(),
                utilisateur.getPrenom(),
                utilisateur.getEmail(),
                utilisateur.getEstAdmin(),
                utilisateur.getEstSuperAdmin()
        );
    }
}
