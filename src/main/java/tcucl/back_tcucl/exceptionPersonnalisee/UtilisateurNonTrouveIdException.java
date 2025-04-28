package tcucl.back_tcucl.exceptionPersonnalisee;

import static tcucl.back_tcucl.Constante.ERREUR_UTILISATEUR_NON_TROUVE_ID;

public class UtilisateurNonTrouveIdException extends RuntimeException{

    public UtilisateurNonTrouveIdException(Long Id) {
        super(ERREUR_UTILISATEUR_NON_TROUVE_ID + Id);
    }
}
