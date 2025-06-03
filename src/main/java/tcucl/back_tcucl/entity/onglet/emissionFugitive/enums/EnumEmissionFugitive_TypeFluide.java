package tcucl.back_tcucl.entity.onglet.emissionFugitive.enums;

public enum EnumEmissionFugitive_TypeFluide {
    CH4(0),
    N20(1),
    R134a(2),
    R404a(3),
    R407a(4),
    R407c(5),
    R410a(6),
    R417a(7),
    R422a(8),
    R422d(9),
    R427a(10),
    R507(11),
    R507a(12),
    HFC_125(13),
    HFC_134(14),
    HFC_134a(15),
    HFC_143(16),
    HFC_143a(17),
    HFC_152a(18),
    HFC_227ea(19),
    HFC_23(20),
    HFC_236fa(21),
    HFC_245ca(22),
    HFC_32(23),
    HFC_41(24),
    HFC_43_10mee(25),
    PERFLUOROBUTANE_R3110(26),
    PERFLUOROMETHANE_R14(27),
    PERFLUOROPROPANE_R218(28),
    PERFLUOROPENTANE_R4112(29),
    PERFLUOROCYCLOBUTANE_R318(30),
    PERFLUOROETHANE_R116(31),
    PERFLUOROHEXANE_R5114(32),
    SF6(33),
    NF3(34),
    R11_CFC_HORS_KYOTO(35),
    R12_CFC_HORS_KYOTO(36),
    R113(37),
    R114(38),
    R115(39),
    R122(40),
    R122a(41),
    R123(42),
    R123a(43),
    R124(44),
    R13(45),
    R132c(46),
    R141b(47),
    R142b(48),
    R21(49),
    R225ca(50),
    R225cb(51),
    R502_CFC_HORS_KYOTO(52),
    R22_HCFC_HORS_KYOTO(53),
    R401a_HCFC_HORS_KYOTO(54),
    R408a_HCFC_HORS_KYOTO(55),
    TETRACHLOROMETHANE(56),
    NOx(57),
    BROMURE_DE_METHYLE(58),
    CHLOROFORME_DE_METHYLE(59),
    HALON_1211(60),
    HALON_1301(61),
    HALON_2402(62),
    DICHLOROMETHANE(63);

    private final int code;

    EnumEmissionFugitive_TypeFluide(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static EnumEmissionFugitive_TypeFluide fromCode(int code) {
        for (EnumEmissionFugitive_TypeFluide e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Code invalide : " + code);
    }
}
