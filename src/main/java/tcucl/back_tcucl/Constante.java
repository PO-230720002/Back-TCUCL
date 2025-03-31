package tcucl.back_tcucl;

public class Constante {

    private Constante() {
        // Constructeur privé pour empêcher l'instanciation
    }
    
//    GENERAL
    public static final String ID = "/{id}";
    
       

//  AUTHENTIFICATION 
    //ENDPOINTS
    public static final String AUTH = "/auth";
    public static final String CONNEXION = "/connexion";
    public static final String INSCRIPTION = "/inscription";
    public static final String INSCRIPTION2 = "/inscription2";
    public static final String CHANGE_MDP = "/change-mdp";
    public static final String UTILISATEUR_ENTITE = "/utilisateur-entite";
    public static final String MODIFIER_UTILISATEUR_UTILISATEUR = "/modifier-utilisateur-utilisateur";
    public static final String MODIFIER_UTILISATEUR_ADMIN = "/modifier-utilisateur-admin";
    public static final String MODIFIER_EST_ADMIN = "/modifier-est-admin";




    //MESSAGE
    public static final String MDP_BIEN_MIS_A_JOUR = "Le mot de passe a bien été mis à jour.";
    public static final String MESSAGE_PREMIERE_CONNEXION = "Vous devez changer votre mot de passe.";
    public static final String UTILISATEUR_BIEN_ENREGISTRE = "Le compte utilisateur a bien créé.";

    //ERREUR 
    public static final String ERREUR_EMAIL_OU_MDP_INVALIDE = "L'adresse e-mail ou le mot de passe est invalide.";
    public static final String ERREUR_EMAIL_DEJA_PRIS = "L'adresse e-mail est déjà utilisé pour un compte : ";
    public static final String ERREUR_UTILISATEUR_NON_TROUVE = "Utilisateur non trouvé en base.";
    public static final String ERREUR_MAUVAIS_ANCIEN_MDP = "Ancien mot de passe incorrect.";
    public static final String ERREUR_UTILISATEUR_NON_TROUVE_ID = "Utilisateur introuvable avec l'ID : ";
    public static final String ERREUR_UTILISATEUR_NON_TROUVE_MAIL = "Utilisateur introuvable avec le mail : ";
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





//ENERGIE ONGLET
    //ENDPOINTS
    public static final String ENERGIE_ONGLET = "/energieonglet";
    public static final String EST_TERMINE = "/estTermine";
    public static final String CREATE_RANDOM = "/createRandom";
    public static final String CONSO_GAZ = "/consoGaz";
    public static final String CONSO_FIOUL = "/consoFioul";
    public static final String CONSO_BOIS = "/consoBois";
    public static final String CONSO_RESEAU_VILLE = "/consoReseauVille";
    public static final String CONSO_ELEC_CHAUFFAGE = "/consoElecChauffage";
    public static final String CONSO_ELEC_SPECIFIQUE = "/consoElecSpecifique";
    public static final String CONSO_EAU = "/consoEau";
    public static final String NOTE = "/note";

    //MESSAGE
    //ERREUR
    //AUTRE

//PARAMETRE ENERGIE
    //ENDPOINTS
    public static final String PARAMETRE_ENERGIE = "/parametreEnergie";
    public static final String RESEAU_VILLE = "/reseauVille";
    public static final String UNITE_GAZ = "/uniteGaz";
    public static final String UNITE_FIOUL = "/uniteFioul";
    public static final String UNITE_BOIS = "/uniteBois";

    //MESSAGE

    //ERREUR 

    //AUTRE


//ADMINISTRATION
    //ENDPOINTS
    public static final String ADMINISTRATION = "/administration";
    public static final String ENTITE = "/entite";
    public static final String UTILISATEUR = "/utilisateur";

    //MESSAGE

    //ERREUR

    //AUTRE


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
