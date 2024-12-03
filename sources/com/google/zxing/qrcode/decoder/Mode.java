package com.google.zxing.qrcode.decoder;

import rh.a;

public enum Mode {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    private final int bits;
    private final int[] characterCountBitsForVersions;

    private Mode(int[] iArr, int i10) {
        this.characterCountBitsForVersions = iArr;
        this.bits = i10;
    }

    public int a() {
        return this.bits;
    }

    public int b(a aVar) {
        char c10;
        int f10 = aVar.f();
        if (f10 <= 9) {
            c10 = 0;
        } else if (f10 <= 26) {
            c10 = 1;
        } else {
            c10 = 2;
        }
        return this.characterCountBitsForVersions[c10];
    }
}
