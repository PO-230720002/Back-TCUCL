package tcucl.back_tcucl.exceptionPersonnalisee;

import jakarta.persistence.EntityNotFoundException;

import static tcucl.back_tcucl.Constante.ERREUR_ENTITE_NON_TROUVE_ID;

public class EntiteNonTrouveeIdException extends EntityNotFoundException {
    public EntiteNonTrouveeIdException(Long entiteId) {
        super(ERREUR_ENTITE_NON_TROUVE_ID + entiteId);
    }
}
