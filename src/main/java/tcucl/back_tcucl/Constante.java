package tcucl.back_tcucl;

public class Constante {

    private Constante() {
        // Constructeur privé pour empêcher l'instanciation
    }

    



    //MESSAGE
    public static final String MESSAGE_PREMIERE_CONNEXION = "Vous devez changer votre mot de passe.";

    //ERREUR 
    public static final String ERREUR_EMAIL_OU_MDP_INVALIDE = "L'adresse e-mail ou le mot de passe est invalide.";
    public static final String ERREUR_AUTHENTIFICATION = "Une erreur est survenue lors de la connexion";
    public static final String ERREUR_EMAIL_DEJA_PRIS = "L'adresse e-mail est déjà utilisé pour un compte : ";
    public static final String ERREUR_UTILISATEUR_NON_TROUVE = "Utilisateur non trouvé en base.";
    public static final String ERREUR_MAUVAIS_ANCIEN_MDP = "Ancien mot de passe incorrect.";
    public static final String ERREUR_UTILISATEUR_NON_TROUVE_ID = "Utilisateur introuvable avec l'Id: ";
    public static final String ERREUR_UTILISATEUR_NON_TROUVE_MAIL = "Utilisateur introuvable avec le mail : ";
    public static final String ERREUR_ENTITE_NON_TROUVE_ID = "Entite introuvable avec l'Id: ";
    public static final String ERREUR_ENTITE_EXISTE_DEJA = "L'entité existe déjà avec ce nom et ce type.";
    public static final String ERREUR_ENTITE_NON_TROUVE = "Entite non trouvée en base";
    public static final String ERREUR_NON_TROUVE_ID = " non trouvé en base avec l'id : ";
    public static final String ERREUR_INTERNE = "Une erreur interne s'est produite.";
    //AUTRE
    public static final String JETON = "jeton";
    public static final String MESSAGE = "message";
    public static final String TYPE = "type";
    public static final String BEARER = "Bearer";
    public static final String CHARACTERE_AUTORISE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
    public static final String ROLE_USER = "ROLE_USER";
    public static final Boolean PREMIERE_CONNEXION_TRUE = true;
    public static final Boolean PREMIERE_CONNEXION_FALSE = false;
    public static final Boolean SUPERADMIN_FALSE = false;
    public static final Boolean SUPERADMIN_TRUE = true;
    public static final Boolean ADMIN_FALSE = false;
    public static final Boolean ADMIN_TRUE = true;


//Message Mail
    public static final String MAIL_SUJET_INSCRIPTION_DEBUT = "Création de votre compte sur TCUCL";
    public static final String MAIL_MESSAGE_INSCRIPTION_DEBUT = "Bonjour, ";
    public static final String MAIL_MESSAGE_INSCRIPTION_MILIEU = ",\n\n" +
            "Bienvenue sur TCUCL, votre compte a été créé avec succès.\n" +
            "Pour activer votre compte, connectez-vous avec votre e-mail et ce mot de passe : ";
    public static final String MAIL_MESSAGE_INSCRIPTION_FIN = "\n\n" +
                    "Cordialement,\n" +
                    "L'équipe TCUCL";



//
    //ENDPOINTS

    //MESSAGE

    //ERREUR

    //AUTRE


}
