package tcucl.back_tcucl.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.InscriptionDto;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.manager.UtilisateurManager;
import tcucl.back_tcucl.repository.EntiteRepository;
import tcucl.back_tcucl.service.PermissionService;

@Service("permissionService") // Le nom ici doit correspondre à ce qu'on utilise dans SpEL
public class PermissionServiceImpl implements PermissionService {

    private final UtilisateurManager utilisateurManager;
    private final EntiteRepository entiteRepository;

    public PermissionServiceImpl(UtilisateurManager utilisateurManager, EntiteRepository entiteRepository) {
        this.utilisateurManager = utilisateurManager;
        this.entiteRepository = entiteRepository;
    }

    @Override
    public boolean utilisateurPeutModifierUtilisateur(Authentication authentication, Long UtilisateurId) {
        return authentication.getName().equals(utilisateurManager.getUtilisateurParId(UtilisateurId).getEmail());
    }

    @Override
    public boolean utlisateurOuAdminPeutChangerMdp(Authentication authentication, ChangePasswordDto changePasswordDto) {
        return authentication.getName().equals(changePasswordDto.getEmail()) ||
               estAdminDe(authentication.getName(), changePasswordDto.getEmail());
    }

    @Override
    public boolean AdminPeutInscrireUtilisateur(String emailUtilisateur, InscriptionDto inscriptionDto) {
        //TODO
        // créer le manager EntiteManager afin de ne pas avoir à faire de .get()
        return entiteRepository.findById(inscriptionDto.getEntiteId()).get() == utilisateurManager.getUtilisateurParEmail(emailUtilisateur).getEntite()


    }


    private boolean estAdminDe(String adminEmail, String utilisateurEmail) {
        Entite entiteAdmin = utilisateurManager.getUtilisateurParEmail(adminEmail).getEntite();
        Entite entiteUtilisateur = utilisateurManager.getUtilisateurParEmail(utilisateurEmail).getEntite();
        return entiteUtilisateur==entiteAdmin;

    }
}