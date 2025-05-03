package tcucl.back_tcucl.exceptionPersonnalisee;

import jakarta.persistence.EntityNotFoundException;

import static tcucl.back_tcucl.Constante.ERREUR_ONGLET_NON_TROUVE_ID;

public class OngletNonTrouveId extends EntityNotFoundException {

    public OngletNonTrouveId(String onglet, Long ongletId) {
        super(onglet + ERREUR_ONGLET_NON_TROUVE_ID + ongletId);
    }
}
