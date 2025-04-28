package tcucl.back_tcucl.exceptionPersonnalisee;

import static tcucl.back_tcucl.Constante.ERREUR_EMAIL_DEJA_PRIS;

public class EmailDejaPrisException extends RuntimeException{

    public EmailDejaPrisException(String mail) {
        super(ERREUR_EMAIL_DEJA_PRIS + mail);
    }
}
