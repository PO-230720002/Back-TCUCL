package tcucl.back_tcucl.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public void inscrireUtilisateur(InscriptionDto inscriptionDto) {
        utilisateurService.inscrireUtilisateur(inscriptionDto);
    }

    @Override
    public void modifierEstAdmin(Long id, Boolean estAdmin) {
        utilisateurService.modifierEstAdmin(id, estAdmin);
    }

    @Override
    public void supprimerUtilisateur(Long id) {
        utilisateurService.supprimerUtilisateur(id);
    }

    @Override
    public void modifierUtilisateurParAdmin(Long id, ModificationUtilisateurParAdminDto modificationUtilisateurParAdminDto) {
        utilisateurService.modifierUtilisateurParAdmin(id, modificationUtilisateurParAdminDto);
    }

    @Override
    public void changePassword(ChangePasswordDto changePasswordDto) {
        utilisateurService.changePassword(changePasswordDto);
    }


    @Override
    public void ajouterAnneeEntite(Long entiteId, Integer anneeUniversitaire) {
        entiteService.ajouterAnneeEntite(entiteId, anneeUniversitaire);
    }

    @Transactional
    @Override
    public void creerEntiteEtAdmin(CreationEntiteEtAdminDto creationEntiteEtAdminDto) {
//todo check dto pas null + faire transactionnal de tout le proccessus
        //Creation puis récupération de l'entite
        Entite entite = entiteService.creerEntite(creationEntiteEtAdminDto.getNom(), creationEntiteEtAdminDto.getType());

        //Inscription de l'utilisateur
        utilisateurService.inscrireUtilisateur(new InscriptionDto(
                        creationEntiteEtAdminDto.getNomUtilisateur(),
                        creationEntiteEtAdminDto.getPrenomUtilisateur(),
                        creationEntiteEtAdminDto.getEmailUtilisateur(),
                        ADMIN_TRUE,
                        entite.getId()
        ));
    }


    @Override
    public List<UtilisateurDto> getAllUtilisateurParEntiteId(Long idEntite) {
        return utilisateurService.getAllUtilisateurParEntiteId(idEntite).stream().map(this::utilisateurToUtilisateurDto).toList();
    }

    @Override
    public void modifierUtilisateurParUtilisateur(Long id, ModificationUtilisateurParUtilisateurDto modificationUtilisateurParUtilisateurDto) {
        utilisateurService.modifierUtilisateurParUtilisateur(id, modificationUtilisateurParUtilisateurDto);
    }

    private UtilisateurDto utilisateurToUtilisateurDto(Utilisateur utilisateur){
        return new UtilisateurDto(
                utilisateur.getId(),
                utilisateur.getNom(),
                utilisateur.getPrenom(),
                utilisateur.getEmail(),
                utilisateur.getEstAdmin(),
                utilisateur.getEntite().getNom()
        );
    }
}
