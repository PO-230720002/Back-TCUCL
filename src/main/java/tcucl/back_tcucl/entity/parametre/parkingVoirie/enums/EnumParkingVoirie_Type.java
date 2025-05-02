package tcucl.back_tcucl.entity.parametre.parkingVoirie.enums;

import tcucl.back_tcucl.entity.parametre.energie.enums.EnumEnergie_UniteGaz;

public enum EnumParkingVoirie_Type {
    PARKING(0),
    VOIRIE(1);

    private final int code;

    EnumParkingVoirie_Type(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static EnumParkingVoirie_Type fromCode(int code) {
        for (EnumParkingVoirie_Type e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("Code invalide : " + code);
    }
}
