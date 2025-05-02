package tcucl.back_tcucl.entity.onglet.emissionFugitive.enums;

public enum EnumEmissionFugitive_TypeMachine {
    ARMOIRE(0),
    DRV(1),
    EAU_GLACEE_MOINS_50KW(2),
    EAU_GLACEE_PLUS_50KW(3),
    INCONNU(4),
    NA(5);

    private final int code;

    EnumEmissionFugitive_TypeMachine(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static EnumEmissionFugitive_TypeMachine fromCode(int code) {
        for (EnumEmissionFugitive_TypeMachine e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Code invalide : " + code);
    }
}
