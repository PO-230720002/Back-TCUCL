package tcucl.back_tcucl.manager.impl;

import org.springframework.stereotype.Component;
import tcucl.back_tcucl.dto.securite.UtilisateurSecuriteDto;
import tcucl.back_tcucl.manager.UtilisateurManager;
import tcucl.back_tcucl.entity.Utilisateur;
import tcucl.back_tcucl.exceptionPersonnalisee.UtilisateurNonTrouveIdException;
import tcucl.back_tcucl.exceptionPersonnalisee.UtilisateurNonTrouveEmailException;
import tcucl.back_tcucl.repository.UtilisateurRepository;

import java.util.List;
import java.util.Optional;


@Component
public class UtilisateurManagerImpl implements UtilisateurManager {

    UtilisateurRepository utilisateurRepository;

    public UtilisateurManagerImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Utilisateur getUtilisateurParId(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if(utilisateur.isEmpty()){
            throw new UtilisateurNonTrouveIdException(id);
        }
        return utilisateur.get();
    }

    @Override
    public Utilisateur getUtilisateurParEmail(String email) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(email);
        if(utilisateur.isEmpty()){
            throw new UtilisateurNonTrouveEmailException(email);
        }
        return utilisateur.get();
    }

    @Override
    public List<Utilisateur> getAllUtilisateurParEntiteId(Long entiteId) {
        return utilisateurRepository.findAllByEntiteId(entiteId);
    }

    @Override
    public boolean emailDejaPris(String email){
        return utilisateurRepository.existsUtilisateurByEmail(email);
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public UtilisateurSecuriteDto findUtilisateurSecurityDTOByEmail(String email) {
        Optional<UtilisateurSecuriteDto> utilisateur = utilisateurRepository.findUtilisateurSecurityDTOByEmail(email);
        if(utilisateur.isEmpty()){
            throw new UtilisateurNonTrouveEmailException(email);
        }
        return utilisateur.get();
    }
}
