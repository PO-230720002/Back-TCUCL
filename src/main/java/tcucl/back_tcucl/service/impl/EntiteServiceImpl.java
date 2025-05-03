package tcucl.back_tcucl.service.impl;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.Annee;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.exceptionPersonnalisee.EntiteDejaExistantAvecNomType;
import tcucl.back_tcucl.manager.EntiteManager;
import tcucl.back_tcucl.service.EntiteService;

import java.util.List;

@Service
public class EntiteServiceImpl implements EntiteService {

    private EntiteManager entiteManager;

    public EntiteServiceImpl(EntiteManager entiteManager) {
        this.entiteManager = entiteManager;
    }

    @Override
    public Entite getEntiteById(Long entiteId) {
        return entiteManager.getEntitebyId(entiteId);
    }

    @Override
    public Entite saveEntite(Entite entite) {
        return entiteManager.save(entite);
    }

    @Override
    public Entite creerEntite(String nomEntite, String typeEntite) {
        if (!entiteManager.existsEntiteByNomAndType(nomEntite, typeEntite)) {
            Entite entite = new Entite(nomEntite, typeEntite);
            return entiteManager.save(entite);
        } else {
            throw new EntiteDejaExistantAvecNomType(nomEntite, typeEntite);
        }
    }

    @Override
    public Entite ajouterAnneeEntite(Long entiteId, Integer anneeUniversitaire) {
        Entite entiteById = entiteManager.getEntitebyId(entiteId);
        Annee annee = new Annee(anneeUniversitaire);
        annee.setEntite(entiteById);
        entiteById.getAnnees().add(annee);
        return entiteManager.save(entiteById);
    }

    @Override
    public List<Entite> getAllEntites() {
        return entiteManager.getAll();
    }

    @Override
    public Boolean existEntiteByNomEtType(String nomEntite, String typeEntite) {
        return entiteManager.existsEntiteByNomAndType(nomEntite, typeEntite);
    }
}
