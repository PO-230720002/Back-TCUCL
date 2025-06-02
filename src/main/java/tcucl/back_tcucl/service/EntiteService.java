package tcucl.back_tcucl.service;

import tcucl.back_tcucl.entity.Entite;

import java.util.List;


public interface EntiteService {

    Entite getEntiteById(Long entiteId);

    Entite saveEntite(Entite entite);

    Entite creerEntite(String nomEntite, String typeEntite);

    Entite ajouterAnneeEntite(Long entiteId, Integer anneeUniversitaire);

    List<Entite> getAllEntites();

    Boolean existEntiteByNomEtType(String nomEntite, String typeEntite);
}
