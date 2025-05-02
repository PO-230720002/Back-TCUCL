package tcucl.back_tcucl.service.impl;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.Annee;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.entity.NotesPermanentes;
import tcucl.back_tcucl.exceptionPersonnalisee.EntiteDejaExistantAvecNomType;
import tcucl.back_tcucl.exceptionPersonnalisee.EntiteNonTrouveeIdException;
import tcucl.back_tcucl.manager.EntiteManager;
import tcucl.back_tcucl.repository.EntiteRepository;
import tcucl.back_tcucl.service.EntiteService;

import java.util.List;

@Service
public class EntiteServiceImpl implements EntiteService {

    private EntiteManager entiteManager;

    public EntiteServiceImpl(EntiteManager entiteManager) {
        this.entiteManager = entiteManager;
    }

    @Override
    public Entite getEntiteById(Long id) {
        return entiteManager.getEntitebyId(id);
    }

    @Override
    public Entite saveEntite(Entite entite) {
        return entiteManager.save(entite);
    }

    @Override
    public Entite creerEntite(String nom, String type) {
        if (!entiteManager.existsEntiteByNomAndType(nom, type)) {
            Entite entite = new Entite(nom, type);
            return entiteManager.save(entite);
        } else {
            throw new EntiteDejaExistantAvecNomType(nom, type);
        }
    }

    @Override
    public Entite ajouterAnneeEntite(Long entiteId, Integer anneeUniversitaire) {
        Entite entite = entiteManager.getEntitebyId(entiteId);
        Annee annee = new Annee(anneeUniversitaire);
        annee.setEntite(entite);
        entite.getAnnees().add(annee);
        return entiteManager.save(entite);
    }

    @Override
    public List<Entite> getAllEntites() {
        return entiteManager.getAll();
    }


}
