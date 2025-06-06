package tcucl.back_tcucl.service;

import org.springframework.security.core.Authentication;
import tcucl.back_tcucl.dto.ChangePasswordDto;
import tcucl.back_tcucl.dto.InscriptionDto_SuperAdmin;


public interface PermissionService {


    boolean adminPeutAjouterAnneeEntite(Authentication authentication, Long entiteId);

    boolean utilisateurPeutModifierUtilisateur(Authentication authentication, Long UtilisateurId);

    boolean utilisateurOuAdminPeutChangerMdp(Authentication authentication, ChangePasswordDto changePasswordDto);

    boolean adminPeutInscrireUtilisateur(Authentication authentication, InscriptionDto_SuperAdmin inscriptionDtoSuperAdmin);

    boolean adminPeutModifierUtilisateur(Authentication authentication, Long utilisateurId);

    boolean adminPeutModifierEstAdmin(Authentication authentication, Long utilisateurId);

    boolean adminPeutAccéderAEntite(Authentication authentication, Long entiteId);

    boolean adminPeutSupprimerUtilisateur(Authentication authentication, Long utilisateurId);
}
