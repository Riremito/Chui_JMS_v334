package net.swordie.ms.enums;

import java.util.Arrays;

public enum RuneType {
    Swiftness(0),
    Recovery(1),
    Destruction(2),
//    Thunder(3),
//    Might(4),
    Darkness(3/*5*/),
//    Riches(6),
//    Hordes(7),
//    Skill(8),
    ;

    private final byte val;

    RuneType(int val) {this.val = (byte) val;}

    public byte getVal() {return val;}

    public static RuneType getByVal(byte val) {
        return Arrays.stream(values()).filter(rt -> rt.getVal() == val).findAny().orElse(null);
    }
}
