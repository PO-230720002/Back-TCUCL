package tcucl.back_tcucl.exceptionPersonnalisee;

import static tcucl.back_tcucl.Constante.ERREUR_ENTITE_NON_TROUVE_ID;

public class EntiteNonTrouveeIdException extends RuntimeException {
    public EntiteNonTrouveeIdException(Long id) {
        super(ERREUR_ENTITE_NON_TROUVE_ID + id);
    }
}
