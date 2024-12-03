package org.bouncycastle.pqc.crypto.newhope;

class Reduce {
    static final int QInv = 12287;
    static final int RLog = 18;
    static final int RMask = 262143;

    Reduce() {
    }

    static short barrett(short s10) {
        short s11 = s10 & 65535;
        return (short) (s11 - (((s11 * 5) >>> 16) * 12289));
    }

    static short montgomery(int i10) {
        return (short) (((((i10 * QInv) & RMask) * 12289) + i10) >>> 18);
    }
}
