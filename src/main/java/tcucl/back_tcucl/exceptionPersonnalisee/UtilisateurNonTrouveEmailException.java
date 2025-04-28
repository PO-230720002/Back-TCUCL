package tcucl.back_tcucl.exceptionPersonnalisee;


import static tcucl.back_tcucl.Constante.ERREUR_UTILISATEUR_NON_TROUVE_MAIL;

public class UtilisateurNonTrouveEmailException extends RuntimeException{

    public UtilisateurNonTrouveEmailException(String mail) {
        super(ERREUR_UTILISATEUR_NON_TROUVE_MAIL + mail);
    }
}
