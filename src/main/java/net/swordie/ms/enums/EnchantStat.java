package net.swordie.ms.enums;

/**
 * Created on 1/25/2018.
 */
public enum EnchantStat implements Comparable<EnchantStat> {
    PAD(0x1),
    MAD(0x2),
    STR(0x4),
    DEX(0x8),
    INT(0x10),
    LUK(0x20),
    PDD(0x40),
    MDD(0x80),
    MHP(0x100),
    MMP(0x200),
    ACC(0x400),
    EVA(0x800),
    JUMP(0x1000),
    SPEED(0x2000);
    
    private final int val;

    EnchantStat(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public EquipBaseStat getEquipBaseStat() {
        switch(this) {
            case PAD:
                return EquipBaseStat.iPAD;
            case MAD:
                return EquipBaseStat.iMAD;
            case STR:
                return EquipBaseStat.iStr;
            case DEX:
                return EquipBaseStat.iDex;
            case INT:
                return EquipBaseStat.iInt;
            case LUK:
                return EquipBaseStat.iLuk;
            case PDD:
                return EquipBaseStat.iPDD;
            case MDD:
                return EquipBaseStat.iMDD;
            case MHP:
                return EquipBaseStat.iMaxHP;
            case MMP:
                return EquipBaseStat.iMaxMP;
            case ACC:
                return EquipBaseStat.iACC;
            case EVA:
                return EquipBaseStat.iEVA;
            case JUMP:
                return EquipBaseStat.iJump;
            case SPEED:
                return EquipBaseStat.iSpeed;
            default:
                return null;
        }
    }

    public static EnchantStat getByEquipBaseStat(EquipBaseStat ebs) {
        switch(ebs) {
            case iPAD:
                return PAD;
            case iMAD:
                return MAD;
            case iStr:
                return STR;
            case iDex:
                return DEX;
            case iInt:
                return INT;
            case iLuk:
                return LUK;
            case iPDD:
                return PDD;
            case iMDD:
                return MDD;
            case iMaxHP:
                return MHP;
            case iMaxMP:
                return MMP;
            case iACC:
                return ACC;
            case iEVA:
                return EVA;
            case iJump:
                return JUMP;
            case iSpeed:
                return SPEED;
            default:
                return null;
        }
    }

    public boolean isAttackType() {
        return this == PAD || this == MAD;
    }

    public boolean isHpOrMp() {
        return this == MHP || this == MMP;
    }

}
