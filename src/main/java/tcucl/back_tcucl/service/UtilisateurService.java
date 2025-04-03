package tcucl.back_tcucl.service;


import tcucl.back_tcucl.dto.*;
import tcucl.back_tcucl.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    void modifierEstAdmin(Long id, Boolean estAdmin);

    void changePassword(ChangePasswordDto requete);

    void save(Utilisateur utilisateur);

    void modifierUtilisateurParUtilisateur(Long id, ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto);

    void modifierUtilisateurParAdmin(Long id, ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto);

    void inscrireUtilisateur(InscriptionDto inscriptionDto);

    Utilisateur getUtilisateurParEmail(String email);

    Utilisateur getUtilisateurParId(Long id);

    List<Utilisateur> getAllUtilisateurParEntiteId(Long entiteId);

    Boolean emailDejaPris(String email);

}
