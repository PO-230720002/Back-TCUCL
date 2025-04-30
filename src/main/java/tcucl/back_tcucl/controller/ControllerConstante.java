package tcucl.back_tcucl.controller;

public class ControllerConstante {

    public ControllerConstante() {
    }

    //    GENERAL
    public static final String REST_ID = "/{id}";

    //   ------------         AUTH          ------------
    public static final String REST_AUTH = "/auth";
    //Endpoints
    public static final String REST_INSCRIPTION2 = "/inscription2";
    public static final String REST_CONNEXION = "/connexion";
    public static final String REST_CHANGE_MDP_PREMIERE_CONNEXION = "/change-mdp-premiere-connexion";
    //messages
    public static final String REST_MESSAGE_MDP_BIEN_MIS_A_JOUR_PREMIERE_CONNEXION = "Le mot de passe a bien été mis à jour lors de sa première connexion.";


    //   ------------       PARAMETRE       ------------
    public static final String REST_PARAMETRE = "/parametre";
    //Endpoints
    public static final String REST_MODIFIER_UTILISATEUR_UTILISATEUR = "/modifier-utilisateur-utilisateur";
    public static final String REST_CHANGE_MDP = "/change-mdp";
    public static final String REST_INSCRIRE_UTILISATEUR = "/inscription-utilisateur";
    public static final String REST_SUPPRIMER_UTILISATEUR = "/supprimer-utilisateur";
    public static final String REST_MODIFIER_UTILISATEUR_ADMIN = "/modifier-utilisateur-admin";
    public static final String REST_MODIFIER_EST_ADMIN = "/modifier-est-admin";
    public static final String REST_CREER_ENTITE = "/creer-entite";
    public static final String REST_IMPORT_FACTEURS_EMISSION = "/import-facteurs-emission";
    public static final String REST_UTILISATEUR_ENTITE = "/utilisateur-entite";
    //messages
    public static final String REST_MESSAGE_UTILISATEUR_BIEN_INSCRIT = "Le compte utilisateur a bien créé.";
    public static final String REST_MESSAGE_UTILISATEUR_MODIFIE = "L'utilisateur a été correctement mis à jour.";
    public static final String REST_MESSAGE_UTILISATEUR_SUPPRIME = "L'utilisateur a été correctement supprimé.";
    public static final String REST_MESSAGE_MDP_BIEN_MIS_A_JOUR = "Le mot de passe a bien été mis à jour.";
    public static final String REST_MESSAGE_CHANGE_STATUT_ADMIN = "Le statut administrateur de l'utilisateur a bien été mis à jour.";
    public static final String REST_MESSAGE_ENTITE_CREEE = "L'entité a bien été créé.";
    public static final String REST_MESSAGE_ANNEE_ENTITE_AJOUTEE = "L'année a bien été ajoutée à l'entité.";
    public static final String REST_MESSAGE_IMPORT_FACTEURS_EMISSION = "Importation réussie.";

    //   *******************************************
    //   ------------      ONGLET       ------------
    //   *******************************************

    //   ------------       Energie       ------------
    public static final String REST_ENERGIE_ONGLET = "/energieonglet";

    //   ---------    Emission Fugitive   ----------
    public static final String REST_EMISSION_FUGITIVE_ONGLET = "/emissionFugitive";
    public static final String REST_MACHINE_ID = "/machineId";
    public static final String REST_MACHINE = "/machine";


    //   ---------    Autre Mobilité FR   ----------
    public static final String REST_AUTRE_MOB_FR = "/autreMobFr";

}
