package org.bouncycastle.pqc.crypto.newhope;

import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.util.Pack;

class Poly {
    Poly() {
    }

    static void add(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i10 = 0; i10 < 1024; i10++) {
            sArr3[i10] = Reduce.barrett((short) (sArr[i10] + sArr2[i10]));
        }
    }

    static void fromBytes(short[] sArr, byte[] bArr) {
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = i10 * 7;
            byte b10 = bArr[i11 + 1] & 255;
            byte b11 = bArr[i11 + 3] & 255;
            byte b12 = bArr[i11 + 5] & 255;
            int i12 = i10 * 4;
            sArr[i12 + 0] = (short) ((bArr[i11 + 0] & 255) | ((b10 & 63) << 8));
            sArr[i12 + 1] = (short) ((b10 >>> 6) | ((bArr[i11 + 2] & 255) << 2) | ((b11 & 15) << 10));
            sArr[i12 + 2] = (short) ((b11 >>> 4) | ((bArr[i11 + 4] & 255) << 4) | ((b12 & 3) << 12));
            sArr[i12 + 3] = (short) (((bArr[i11 + 6] & 255) << 6) | (b12 >>> 2));
        }
    }

    static void fromNTT(short[] sArr) {
        NTT.bitReverse(sArr);
        NTT.core(sArr, Precomp.OMEGAS_INV_MONTGOMERY);
        NTT.mulCoefficients(sArr, Precomp.PSIS_INV_MONTGOMERY);
    }

    static void getNoise(short[] sArr, byte[] bArr, byte b10) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = b10;
        byte[] bArr3 = new byte[Opcodes.ACC_SYNTHETIC];
        ChaCha20.process(bArr, bArr2, bArr3, 0, Opcodes.ACC_SYNTHETIC);
        for (int i10 = 0; i10 < 1024; i10++) {
            int bigEndianToInt = Pack.bigEndianToInt(bArr3, i10 * 4);
            int i11 = 0;
            for (int i12 = 0; i12 < 8; i12++) {
                i11 += (bigEndianToInt >> i12) & 16843009;
            }
            sArr[i10] = (short) (((((i11 >>> 24) + (i11 >>> 0)) & 255) + 12289) - (((i11 >>> 16) + (i11 >>> 8)) & 255));
        }
    }

    private static short normalize(short s10) {
        short barrett = Reduce.barrett(s10);
        int i10 = barrett - 12289;
        return (short) (((barrett ^ i10) & (i10 >> 31)) ^ i10);
    }

    static void pointWise(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i10 = 0; i10 < 1024; i10++) {
            sArr3[i10] = Reduce.montgomery((sArr[i10] & 65535) * (65535 & Reduce.montgomery((sArr2[i10] & 65535) * 3186)));
        }
    }

    static void toBytes(byte[] bArr, short[] sArr) {
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = i10 * 4;
            short normalize = normalize(sArr[i11 + 0]);
            short normalize2 = normalize(sArr[i11 + 1]);
            short normalize3 = normalize(sArr[i11 + 2]);
            short normalize4 = normalize(sArr[i11 + 3]);
            int i12 = i10 * 7;
            bArr[i12 + 0] = (byte) normalize;
            bArr[i12 + 1] = (byte) ((normalize >> 8) | (normalize2 << 6));
            bArr[i12 + 2] = (byte) (normalize2 >> 2);
            bArr[i12 + 3] = (byte) ((normalize2 >> 10) | (normalize3 << 4));
            bArr[i12 + 4] = (byte) (normalize3 >> 4);
            bArr[i12 + 5] = (byte) ((normalize3 >> 12) | (normalize4 << 2));
            bArr[i12 + 6] = (byte) (normalize4 >> 6);
        }
    }

    static void toNTT(short[] sArr) {
        NTT.mulCoefficients(sArr, Precomp.PSIS_BITREV_MONTGOMERY);
        NTT.core(sArr, Precomp.OMEGAS_MONTGOMERY);
    }

    static void uniform(short[] sArr, byte[] bArr) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        sHAKEDigest.update(bArr, 0, bArr.length);
        int i10 = 0;
        while (true) {
            byte[] bArr2 = new byte[256];
            sHAKEDigest.doOutput(bArr2, 0, 256);
            int i11 = 0;
            while (true) {
                if (i11 < 256) {
                    byte b10 = (bArr2[i11] & 255) | ((bArr2[i11 + 1] & 255) << 8);
                    if (b10 < 61445) {
                        int i12 = i10 + 1;
                        sArr[i10] = (short) b10;
                        if (i12 != 1024) {
                            i10 = i12;
                        } else {
                            return;
                        }
                    }
                    i11 += 2;
                }
            }
        }
    }
}
