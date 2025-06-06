package tcucl.back_tcucl.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.InscriptionDto_SuperAdmin;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.manager.UtilisateurManager;
import tcucl.back_tcucl.service.EntiteService;
import tcucl.back_tcucl.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    private final UtilisateurManager utilisateurManager;
    private final EntiteService entiteService;

    public PermissionServiceImpl(UtilisateurManager utilisateurManager, EntiteService entiteService) {
        this.utilisateurManager = utilisateurManager;
        this.entiteService = entiteService;
    }

    @Override
    public boolean utilisateurPeutModifierUtilisateur(Authentication authentication, Long UtilisateurId) {
        return authentication.getName().equals(utilisateurManager.getUtilisateurParId(UtilisateurId).getEmail());
    }

    @Override
    public boolean utilisateurOuAdminPeutChangerMdp(Authentication authentication, ChangePasswordDto changePasswordDto) {
        return authentication.getName().equals(changePasswordDto.getEmail());
    }

    @Override
    public boolean adminPeutInscrireUtilisateur(Authentication authentication, InscriptionDto_SuperAdmin inscriptionDtoSuperAdmin) {
        return estAdminDeEntite(authentication.getName(), inscriptionDtoSuperAdmin.getEntiteId());
    }

    @Override
    public boolean adminPeutModifierUtilisateur(Authentication authentication, Long utilisateurId) {
        return estAdminDe(authentication.getName(), utilisateurId);
    }

    @Override
    public boolean adminPeutModifierEstAdmin(Authentication authentication, Long utilisateurId){
        return estAdminDe(authentication.getName(), utilisateurId);
    }

    @Override
    public boolean adminPeutAccéderAEntite(Authentication authentication, Long entiteId){
        return estAdminDeEntite(authentication.getName(),entiteId);
    }

    @Override
    public boolean adminPeutSupprimerUtilisateur(Authentication authentication, Long utilisateurId){
        return estAdminDe(authentication.getName(), utilisateurId);
    }

    @Override
    public boolean adminPeutAjouterAnneeEntite(Authentication authentication, Long entiteId) {
        return estAdminDeEntite(authentication.getName(),entiteId);
    }

    private boolean estAdminDe(String adminEmail, String utilisateurEmail) {
        Entite entiteAdmin = utilisateurManager.getUtilisateurParEmail(adminEmail).getEntite();
        Entite entiteUtilisateur = utilisateurManager.getUtilisateurParEmail(utilisateurEmail).getEntite();
        return entiteUtilisateur==entiteAdmin;
    }

    private boolean estAdminDe(String adminEmail, Long utilisateurId) {
        Entite entiteAdmin = utilisateurManager.getUtilisateurParEmail(adminEmail).getEntite();
        Entite entiteUtilisateur = utilisateurManager.getUtilisateurParId(utilisateurId).getEntite();
        return entiteUtilisateur==entiteAdmin;
    }

    private boolean estAdminDeEntite(String adminEmail, Long entiteId){
        Entite entiteAdmin = utilisateurManager.getUtilisateurParEmail(adminEmail).getEntite();
        Entite entiteCible = entiteService.getEntiteById(entiteId);
        return entiteAdmin == entiteCible;
    }
}