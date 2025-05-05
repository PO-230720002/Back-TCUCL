package tcucl.back_tcucl.entity.onglet.mobInternationale.enums;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public enum EnumMobInternationale_NomPays {
    ALBANIE(1, "Albanie", true),
    ALLEMAGNE(2, "Allemagne", true),
    ANDORRE(3, "Andorre", true),
    ARMENIE(4, "Arménie", true),
    AUTRICHE(5, "Autriche", true),
    BELGIQUE(6, "Belgique", true),
    BIELORUSSIE(7, "Biélorussie", true),
    BOSNIE_HERZEGOVINE(8, "Bosnie-Herzégovine", true),
    BULGARIE(9, "Bulgarie", true),
    CHYPRE(10, "Chypre", true),
    CROATIE(11, "Croatie", true),
    DANEMARK(12, "Danemark", true),
    ESPAGNE(13, "Espagne", true),
    ESTONIE(14, "Estonie", true),
    FINLANDE(15, "Finlande", true),
    GIBRALTAR(16, "Gibraltar", true),
    GRECE(17, "Grèce", true),
    GEORGIE(18, "Géorgie", true),
    HONGRIE(19, "Hongrie", true),
    IRLANDE(20, "Irlande", true),
    ITALIE(21, "Italie", true),
    LETTONIE(22, "Lettonie", true),
    LIECHTENSTEIN(23, "Liechtenstein", true),
    LITUANIE(24, "Lituanie", true),
    LUXEMBOURG(25, "Luxembourg", true),
    MACEDOINE_DU_NORD(26, "Macédoine du Nord", true),
    MALTE(27, "Malte", true),
    MOLDAVIE(28, "Moldavie", true),
    MONACO(29, "Monaco", true),
    MONTENEGRO(30, "Montenegro", true),
    NORVEGE(31, "Norvège", true),
    PAYS_BAS(32, "Pays-Bas", true),
    POLOGNE(33, "Pologne", true),
    PORTUGAL(34, "Portugal", true),
    ROUMANIE(35, "Roumanie", true),
    ROYAUME_UNI(36, "Royaume-Uni", true),
    REPUBLIQUE_TCHÈQUE(37, "République Tchèque", true),
    SAINT_MARIN(38, "Saint-Marin", true),
    SERBIE(39, "Serbie", true),
    SLOVAQUIE(40, "Slovaquie", true),
    SLOVENIE(41, "Slovénie", true),
    SUISSE(42, "Suisse", true),
    SUEDE(43, "Suède", true),
    TURQUIE(44, "Turquie", true),
    UKRAINE(45, "Ukraine", true),
    VATICAN(46, "Vatican", true),
    AFGHANISTAN(47, "Afghanistan", false),
    AFRIQUE_DU_SUD(48, "Afrique du Sud", false),
    ALGERIE(49, "Algérie", false),
    ANGOLA(50, "Angola", false),
    ANGUILLA(51, "Anguilla", false),
    ANTIGUA_ET_BARBUDA(52, "Antigua et Barbuda", false),
    ANTILLES_NEERLANDAISES(53, "Antilles néerlandaises", false),
    ARABIE_SAOUDITE(54, "Arabie saoudite", false),
    ARGENTINE(55, "Argentine", false),
    ARUBA(56, "Aruba", false),
    AUSTRALIE(57, "Australie", false),
    AZERBAIDJAN(58, "Azerbaïdjan", false),
    BAHAMAS(59, "Bahamas", false),
    BAHREIN(60, "Bahreïn", false),
    BANGLADESH(61, "Bangladesh", false),
    BARBADE(62, "Barbade", false),
    BELIZE(63, "Belize", false),
    BENIN(64, "Bénin", false),
    BERMUDES(65, "Bermudes", false),
    BHOUTAN(66, "Bhoutan", false),
    BIRMANIE(67, "Birmanie", false),
    BOLIVIE(68, "Bolivie", false),
    BOTSWANA(69, "Botswana", false),
    BRUNEI(70, "Brunei", false),
    BRESIL(71, "Brésil", false),
    BURKINA_FASO(72, "Burkina Faso", false),
    BURUNDI(73, "Burundi", false),
    CAMBODGE(74, "Cambodge", false),
    CAMEROUN(75, "Cameroun", false),
    CANADA(76, "Canada", false),
    CAP_VERT(77, "Cap-Vert", false),
    CHILI(78, "Chili", false),
    CHINE(79, "Chine", false),
    COLOMBIE(80, "Colombie", false),
    COMORES(81, "Comores", false),
    COOK_ILES(82, "Cook (îles)", false),
    COREE_DU_NORD(83, "Corée du Nord", false),
    COREE_DU_SUD(84, "Corée du Sud", false),
    COSTA_RICA(85, "Costa Rica", false),
    COTE_D_IVOIRE(86, "Côte d'Ivoire", false),
    CUBA(87, "Cuba", false),
    DJIBOUTI(88, "Djibouti", false),
    DOMINIQUE(89, "Dominique", false),
    EGYPTE(90, "Égypte", false),
    EMIRATS_ARABES_UNIS(91, "Émirats Arabes Unis", false),
    EQUATEUR(92, "Équateur", false),
    ERYTHREE(93, "Érythrée", false),
    ETATS_FEDERES_DE_MICRONESIE(94, "États Fédérés de Micronésie", false),
    ETATS_UNIS(95, "États-Unis", false),
    ETHIOPIE(96, "Éthiopie", false),
    FIDJI_ILES(97, "Fidji (îles)", false),
    FEROE_ILES(98, "Féroé (îles)", false),
    GABON(99, "Gabon", false),
    GAMBIE(100, "Gambie", false),
    GHANA(101, "Ghana", false),
    GRENADE(102, "Grenade", false),
    GROENLAND(103, "Groenland", false),
    GUADELOUPE(104, "Guadeloupe", false),
    GUAM(105, "Guam", false),
    GUATEMALA(106, "Guatemala", false),
    GUINEE(107, "Guinée", false),
    GUINEE_EQUATORIALE(108, "Guinée Équatoriale", false),
    GUINEE_BISSAU(109, "Guinée-Bissau", false),
    GUYANA(110, "Guyana", false),
    GEORGIE_DU_SUD_ET_ILES_SANDWICH(111, "Géorgie du Sud et îles Sandwich", false),
    HAITI(112, "Haïti", false),
    HONDURAS(113, "Honduras", false),
    HONG_KONG(114, "Hong Kong", false),
    INDE(115, "Inde", false),
    INDONESIE(116, "Indonésie", false),
    IRAN(117, "Iran", false),
    IRAQ(118, "Iraq", false),
    ISLANDE(119, "Islande", false),
    ISRAEL(120, "Israël", false),
    JAMAIQUE(121, "Jamaïque", false),
    JAPON(122, "Japon", false),
    JORDANIE(123, "Jordanie", false),
    KAZAKHSTAN(124, "Kazakhstan", false),
    KENYA(125, "Kenya", false),
    KIRGHIZISTAN(126, "Kirghizistan", false),
    KIRIBATI(127, "Kiribati", false),
    KOWEIT(128, "Koweït", false),
    LAOS(129, "Laos", false),
    LESOTHO(130, "Lesotho", false),
    LIBAN(131, "Liban", false),
    LIBYE(132, "Libye", false),
    LIBERIA(133, "Libéria", false),
    MACAO(134, "Macao", false),
    MADAGASCAR(135, "Madagascar", false),
    MALAISIE(136, "Malaisie", false),
    MALAWI(137, "Malawi", false),
    MALDIVES(138, "Maldives", false),
    MALI(139, "Mali", false),
    MALOUINES_ILES(140, "Malouines (îles)", false),
    MAROC(141, "Maroc", false),
    MARSHALL_ILES(142, "Marshall (îles)", false),
    MARTINIQUE(143, "Martinique", false),
    MAURICE_ILE(144, "Maurice (île)", false),
    MAURITANIE(145, "Mauritanie", false),
    MEXIQUE(146, "Mexique", false),
    MONGOLIE(147, "Mongolie", false),
    MONTSERRAT(148, "Montserrat", false),
    MOZAMBIQUE(149, "Mozambique", false),
    NAMIBIE(150, "Namibie", false),
    NAURU(151, "Nauru", false),
    NICARAGUA(152, "Nicaragua", false),
    NIGER(153, "Niger", false),
    NIGERIA(154, "Nigéria", false),
    NIUE(155, "Niué", false),
    NOUVELLE_CALEDONIE(156, "Nouvelle-Calédonie", false),
    NOUVELLE_ZELANDE(157, "Nouvelle-Zélande", false),
    NEPAL(158, "Népal", false),
    OMAN(159, "Oman", false),
    OUGANDA(160, "Ouganda", false),
    OUZBEKISTAN(161, "Ouzbékistan", false),
    PAKISTAN(162, "Pakistan", false),
    PALAOS(163, "Palaos", false),
    PALESTINE(164, "Palestine", false),
    PANAMA(165, "Panama", false),
    PAPOUASIE_NOUVELLE_GUINEE(166, "Papouasie-Nouvelle-Guinée", false),
    PARAGUAY(167, "Paraguay", false),
    PHILIPPINES(168, "Philippines", false),
    POLYNESIE_FRANCAISE(169, "Polynésie Française", false),
    PORTO_RICO(170, "Porto Rico", false),
    PEROU(171, "Pérou", false),
    QATAR(172, "Qatar", false),
    RWANDA(173, "Rwanda", false),
    REPUBLIQUE_CENTRAFRICAINE(174, "République Centrafricaine", false),
    REPUBLIQUE_DOMINICAINE(175, "République Dominicaine", false),
    REPUBLIQUE_DEMOCRATIQUE_DU_CONGO(176, "République Démocratique du Congo", false),
    REUNION_ILE(177, "Réunion (île)", false),
    RUSSIE(178, "Russie", false),
    SAINT_CHRISTOPHE_ET_NIEVES(179, "Saint-Christophe-et-Niévès", false),
    SAINT_VINCENT_ET_LES_GRENADINES(180, "Saint-Vincent-et-les-Grenadines", false),
    SAINTE_LUCIE(181, "Sainte-Lucie", false),
    SALOMON_ILES(182, "Salomon (îles)", false),
    SALVADOR(183, "Salvador", false),
    SAMOA_ILES(184, "Samoa (îles)", false),
    SAMOA_AMERICAINES(185, "Samoa Américaines", false),
    SAO_TOME_ET_PRINCIPE(186, "Sao Tomé-et-Principe", false),
    SEYCHELLES(187, "Seychelles", false),
    SIERRA_LEONE(188, "Sierra Leone", false),
    SINGAPOUR(189, "Singapour", false),
    SOMALIE(190, "Somalie", false),
    SOUDAN(191, "Soudan", false),
    SRI_LANKA(192, "Sri Lanka", false),
    SURINAME(193, "Suriname", false),
    SWAZILAND(194, "Swaziland", false),
    SYRIE(195, "Syrie", false),
    SENEGAL(196, "Sénégal", false),
    TADJIKISTAN(197, "Tadjikistan", false),
    TANZANIE(198, "Tanzanie", false),
    TAIWAN(199, "Taïwan", false),
    TCHAD(200, "Tchad", false),
    THAILANDE(201, "Thaïlande", false),
    TIMOR_ORIENTAL(202, "Timor Oriental", false),
    TOGO(203, "Togo", false),
    TONGA_ILES(204, "Tonga (îles)", false),
    TRINITE_ET_TOBAGO(205, "Trinité-et-Tobago", false),
    TUNISIE(206, "Tunisie", false),
    TURKMENISTAN(207, "Turkménistan", false),
    TUVALU(208, "Tuvalu", false),
    URUGUAY(209, "Uruguay", false),
    VANUATU(210, "Vanuatu", false),
    VENEZUELA(211, "Venezuela", false),
    VIETNAM(212, "Vietnam", false),
    WALLIS_ET_FUTUNA_ILES(213, "Wallis et Futuna (îles)", false),
    YEMEN(214, "Yémen", false),
    ZAMBIE(215, "Zambie", false),
    ZIMBABWE(216, "Zimbabwe", false),
    AUTRE(217, "Autre:", false);



    private final int code;
    private final String libelle;
    Boolean accessibleEnTrain;

    EnumMobInternationale_NomPays(int code, String libelle, Boolean accessibleEnTrain) {
        this.code = code;
        this.libelle = libelle;
        this.accessibleEnTrain = accessibleEnTrain;       
    }


    //LIBELLE
    public String getLibelle() {
        return libelle;
    }

    private static final Map<String, EnumMobInternationale_NomPays> LIBELLE_TO_ENUM;

    static {
        LIBELLE_TO_ENUM = Arrays.stream(values())
                .collect(Collectors.toMap(
                        e -> e.libelle, // libellé sans modification
                        e -> e
                ));
    }

    public static EnumMobInternationale_NomPays fromLibelle(String libelle) {
        try {
            if (libelle == null) return null;
            return LIBELLE_TO_ENUM.get(libelle);
        } catch (Exception e) {
            return null;
        }
    }

    //CODE

    public Integer getCode() {
        return code;
    }

    private static final Map<Integer, EnumMobInternationale_NomPays> CODE_TO_ENUM;

    static {
        CODE_TO_ENUM = Arrays.stream(values())
                .collect(Collectors.toMap(EnumMobInternationale_NomPays::getCode, e -> e));
    }

    public static EnumMobInternationale_NomPays fromCode(int code) {
        EnumMobInternationale_NomPays result = CODE_TO_ENUM.get(code);
        if (result == null) {
            throw new IllegalArgumentException("Code invalide : " + code);
        }
        return result;
    }

    //ACCESSIBLE EN TRAIN
    public Boolean getAccessibleEnTrain() {
        return accessibleEnTrain;
    }
}


