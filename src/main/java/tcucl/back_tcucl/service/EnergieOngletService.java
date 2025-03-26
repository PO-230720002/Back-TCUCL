package tcucl.back_tcucl.service;

import tcucl.back_tcucl.entity.onglet.EnergieOnglet;

public interface EnergieOngletService {

    public EnergieOnglet getEnergieOngletById(Long id);

    public EnergieOnglet updateEnergieOnglet(EnergieOnglet energieOnglet);

    public void setEstTermine(Long id, boolean estTermine);

    public void setConsoGaz(Long id, Float consoGaz);

    public void setConsoFioul(Long id, Float consoFioul);

    public void setConsoBois(Long id, Float consoBois);

    public void setConsoReseauVille(Long id, Float consoReseauVille);

    public void setConsoElecChauffage(Long id, Float consoElecChauffage);

    public void setConsoElecSpecifique(Long id, Float consoElecSpecifique);

    public void setConsoEau(Long id, Float consoEau);


    public void setNote(Long id, String note);

}
