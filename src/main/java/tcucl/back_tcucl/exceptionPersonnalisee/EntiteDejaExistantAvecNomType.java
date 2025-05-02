package tcucl.back_tcucl.exceptionPersonnalisee;

import static tcucl.back_tcucl.Constante.ERREUR_ENTITE_EXISTE_DEJA;

public class EntiteDejaExistantAvecNomType extends RuntimeException {
    public EntiteDejaExistantAvecNomType(String nom, String type) {
        super(ERREUR_ENTITE_EXISTE_DEJA+ "  " + nom + "  " + type);
    }
}
