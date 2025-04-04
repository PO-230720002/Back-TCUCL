package tcucl.back_tcucl.service;

import org.springframework.security.core.Authentication;
import tcucl.back_tcucl.dto.ChangePasswordDto;

public interface PermissionService {


    boolean utilisateurPeutModifierUtilisateur(Authentication authentication, Long UtilisateurId);

    boolean utlisateurOuAdminPeutChangerMdp(Authentication authentication, ChangePasswordDto changePasswordDto);
}
