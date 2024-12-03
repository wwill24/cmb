package org.bouncycastle.util.encoders;

import net.bytebuddy.jar.asm.Opcodes;

public class UTF8 {
    private static final byte C_CR1 = 1;
    private static final byte C_CR2 = 2;
    private static final byte C_CR3 = 3;
    private static final byte C_ILL = 0;
    private static final byte C_L2A = 4;
    private static final byte C_L3A = 5;
    private static final byte C_L3B = 6;
    private static final byte C_L3C = 7;
    private static final byte C_L4A = 8;
    private static final byte C_L4B = 9;
    private static final byte C_L4C = 10;
    private static final byte S_CS1 = 0;
    private static final byte S_CS2 = 16;
    private static final byte S_CS3 = 32;
    private static final byte S_END = -1;
    private static final byte S_ERR = -2;
    private static final byte S_P3A = 48;
    private static final byte S_P3B = 64;
    private static final byte S_P4A = 80;
    private static final byte S_P4B = 96;
    private static final short[] firstUnitTable = new short[128];
    private static final byte[] transitionTable;

    static {
        byte[] bArr = new byte[112];
        transitionTable = bArr;
        byte[] bArr2 = new byte[128];
        fill(bArr2, 0, 15, (byte) 1);
        fill(bArr2, 16, 31, (byte) 2);
        fill(bArr2, 32, 63, C_CR3);
        fill(bArr2, 64, 65, (byte) 0);
        fill(bArr2, 66, 95, (byte) 4);
        fill(bArr2, 96, 96, C_L3A);
        fill(bArr2, 97, 108, C_L3B);
        fill(bArr2, 109, 109, C_L3C);
        fill(bArr2, 110, 111, C_L3B);
        fill(bArr2, 112, 112, (byte) 8);
        fill(bArr2, 113, 115, (byte) 9);
        fill(bArr2, 116, 116, (byte) 10);
        fill(bArr2, 117, Opcodes.LAND, (byte) 0);
        fill(bArr, 0, bArr.length - 1, S_ERR);
        fill(bArr, 8, 11, S_END);
        fill(bArr, 24, 27, (byte) 0);
        fill(bArr, 40, 43, (byte) 16);
        fill(bArr, 58, 59, (byte) 0);
        fill(bArr, 72, 73, (byte) 0);
        fill(bArr, 89, 91, (byte) 16);
        fill(bArr, 104, 104, (byte) 16);
        byte[] bArr3 = {0, 0, 0, 0, 31, 15, 15, 15, C_L3C, C_L3C, C_L3C};
        byte[] bArr4 = {S_ERR, S_ERR, S_ERR, S_ERR, 0, S_P3A, 16, S_P3B, S_P4A, S_CS3, S_P4B};
        for (int i10 = 0; i10 < 128; i10++) {
            byte b10 = bArr2[i10];
            firstUnitTable[i10] = (short) (bArr4[b10] | ((bArr3[b10] & i10) << 8));
        }
    }

    private static void fill(byte[] bArr, int i10, int i11, byte b10) {
        while (i10 <= i11) {
            bArr[i10] = b10;
            i10++;
        }
    }

    public static int transcodeToUTF16(byte[] bArr, char[] cArr) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < bArr.length) {
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            if (b10 < 0) {
                short s10 = firstUnitTable[b10 & Byte.MAX_VALUE];
                int i13 = s10 >>> 8;
                byte b11 = (byte) s10;
                while (b11 >= 0) {
                    if (i12 >= bArr.length) {
                        return -1;
                    }
                    int i14 = i12 + 1;
                    byte b12 = bArr[i12];
                    i13 = (i13 << 6) | (b12 & 63);
                    b11 = transitionTable[b11 + ((b12 & S_END) >>> 4)];
                    i12 = i14;
                }
                if (b11 == -2) {
                    return -1;
                }
                if (i13 <= 65535) {
                    if (i11 >= cArr.length) {
                        return -1;
                    }
                    cArr[i11] = (char) i13;
                    i11++;
                } else if (i11 >= cArr.length - 1) {
                    return -1;
                } else {
                    int i15 = i11 + 1;
                    cArr[i11] = (char) ((i13 >>> 10) + 55232);
                    i11 = i15 + 1;
                    cArr[i15] = (char) (56320 | (i13 & 1023));
                }
                i10 = i12;
            } else if (i11 >= cArr.length) {
                return -1;
            } else {
                cArr[i11] = (char) b10;
                i10 = i12;
                i11++;
            }
        }
        return i11;
    }
}
