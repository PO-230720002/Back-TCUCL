package tcucl.back_tcucl.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.InscriptionDto;
import tcucl.back_tcucl.dto.ModificationUtilisateurParAdminDto;
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
    public boolean utlisateurOuAdminPeutChangerMdp(Authentication authentication, ChangePasswordDto changePasswordDto) {
        return authentication.getName().equals(changePasswordDto.getEmail()) ||
               estAdminDe(authentication.getName(), changePasswordDto.getEmail());
    }

    @Override
    public boolean adminPeutInscrireUtilisateur(Authentication authentication, InscriptionDto inscriptionDto) {
        return estAdminDe(authentication.getName(),inscriptionDto.getEmail());
    }

    @Override
    public boolean adminPeutModifierUtilisateur(Authentication authentication, ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto){
        return  estAdminDe(authentication.getName(), modificationUtilisateurParAdminDto.getEmail());
    }

    @Override
    public boolean adminPeutModifierEstAdmin(Authentication authentication, Long idUtilisateur){
        return estAdminDe(authentication.getName(), idUtilisateur);
    }

    @Override
    public boolean adminPeutAccéderAEntite(Authentication authentication, Long idEntite){
        return estAdminDeEntite(authentication.getName(), idEntite);
    }

    @Override
    public boolean adminPeutSupprimerUtilisateur(Authentication authentication, Long idUtilisateur){
        return estAdminDe(authentication.getName(), idUtilisateur);
    }

    @Override
    public boolean adminPeutAjouterAnneeEntite(Authentication authentication, Long idEntite) {
        return estAdminDeEntite(authentication.getName(), idEntite);
    }

    private boolean estAdminDe(String adminEmail, String utilisateurEmail) {
        Entite entiteAdmin = utilisateurManager.getUtilisateurParEmail(adminEmail).getEntite();
        Entite entiteUtilisateur = utilisateurManager.getUtilisateurParEmail(utilisateurEmail).getEntite();
        return entiteUtilisateur==entiteAdmin;
    }

    private boolean estAdminDe(String adminEmail, Long idUtilisateur) {
        Entite entiteAdmin = utilisateurManager.getUtilisateurParEmail(adminEmail).getEntite();
        Entite entiteUtilisateur = utilisateurManager.getUtilisateurParId(idUtilisateur).getEntite();
        return entiteUtilisateur==entiteAdmin;
    }

    private boolean estAdminDeEntite(String adminEmail, Long idEntite){
        Entite entiteAdmin = utilisateurManager.getUtilisateurParEmail(adminEmail).getEntite();
        Entite entiteCible = entiteService.getEntiteById(idEntite);
        return entiteAdmin == entiteCible;
    }
}