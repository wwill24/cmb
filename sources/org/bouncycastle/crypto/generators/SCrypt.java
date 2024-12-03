package org.bouncycastle.crypto.generators;

import com.google.android.gms.common.api.a;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.engines.Salsa20Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

public class SCrypt {
    private SCrypt() {
    }

    private static void BlockMix(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i10) {
        System.arraycopy(iArr, iArr.length - 16, iArr2, 0, 16);
        int length = iArr.length >>> 1;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = i10 * 2; i13 > 0; i13--) {
            Xor(iArr2, iArr, i11, iArr3);
            Salsa20Engine.salsaCore(8, iArr3, iArr2);
            System.arraycopy(iArr2, 0, iArr4, i12, 16);
            i12 = (length + i11) - i12;
            i11 += 16;
        }
    }

    private static void Clear(byte[] bArr) {
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    private static void Clear(int[] iArr) {
        if (iArr != null) {
            Arrays.fill(iArr, 0);
        }
    }

    private static void ClearAll(int[][] iArr) {
        for (int[] Clear : iArr) {
            Clear(Clear);
        }
    }

    private static byte[] MFcrypt(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13) {
        int i14 = i11 * 128;
        byte[] SingleIterationPBKDF2 = SingleIterationPBKDF2(bArr, bArr2, i12 * i14);
        int[] iArr = null;
        try {
            int length = SingleIterationPBKDF2.length >>> 2;
            iArr = new int[length];
            Pack.littleEndianToInt(SingleIterationPBKDF2, 0, iArr);
            int i15 = i10 * i11;
            int i16 = 0;
            while (i10 - i16 > 2 && i15 > 1024) {
                i16++;
                i15 >>>= 1;
            }
            int i17 = i14 >>> 2;
            for (int i18 = 0; i18 < length; i18 += i17) {
                SMix(iArr, i18, i10, i16, i11);
            }
            Pack.intToLittleEndian(iArr, SingleIterationPBKDF2, 0);
            return SingleIterationPBKDF2(bArr, SingleIterationPBKDF2, i13);
        } finally {
            Clear(SingleIterationPBKDF2);
            Clear(iArr);
        }
    }

    private static void SMix(int[] iArr, int i10, int i11, int i12, int i13) {
        int[] iArr2 = iArr;
        int i14 = i10;
        int i15 = i11;
        int i16 = i13;
        int i17 = i15 >>> i12;
        int i18 = 1 << i12;
        int i19 = i17 - 1;
        int numberOfTrailingZeros = Integers.numberOfTrailingZeros(i11) - i12;
        int i20 = i16 * 32;
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[i20];
        int[] iArr6 = new int[i20];
        int[][] iArr7 = new int[i18][];
        try {
            System.arraycopy(iArr2, i14, iArr6, 0, i20);
            int i21 = 0;
            while (i21 < i18) {
                int[] iArr8 = new int[(i17 * i20)];
                iArr7[i21] = iArr8;
                int i22 = i18;
                int i23 = 0;
                int i24 = 0;
                while (i24 < i17) {
                    System.arraycopy(iArr6, 0, iArr8, i23, i20);
                    int i25 = i23 + i20;
                    BlockMix(iArr6, iArr3, iArr4, iArr5, i16);
                    System.arraycopy(iArr5, 0, iArr8, i25, i20);
                    i23 = i25 + i20;
                    BlockMix(iArr5, iArr3, iArr4, iArr6, i16);
                    i24 += 2;
                    i17 = i17;
                }
                int i26 = i17;
                i21++;
                int[] iArr9 = iArr;
                i18 = i22;
            }
            int i27 = i15 - 1;
            for (int i28 = 0; i28 < i15; i28++) {
                int i29 = iArr6[i20 - 16] & i27;
                System.arraycopy(iArr7[i29 >>> numberOfTrailingZeros], (i29 & i19) * i20, iArr5, 0, i20);
                Xor(iArr5, iArr6, 0, iArr5);
                BlockMix(iArr5, iArr3, iArr4, iArr6, i16);
            }
            System.arraycopy(iArr6, 0, iArr, i14, i20);
            ClearAll(iArr7);
            ClearAll(new int[][]{iArr6, iArr3, iArr4, iArr5});
        } catch (Throwable th2) {
            ClearAll(iArr7);
            ClearAll(new int[][]{iArr6, iArr3, iArr4, iArr5});
            throw th2;
        }
    }

    private static byte[] SingleIterationPBKDF2(byte[] bArr, byte[] bArr2, int i10) {
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA256Digest());
        pKCS5S2ParametersGenerator.init(bArr, bArr2, 1);
        return ((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedMacParameters(i10 * 8)).getKey();
    }

    private static void Xor(int[] iArr, int[] iArr2, int i10, int[] iArr3) {
        for (int length = iArr3.length - 1; length >= 0; length--) {
            iArr3[length] = iArr[length] ^ iArr2[i10 + length];
        }
    }

    public static byte[] generate(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13) {
        if (bArr == null) {
            throw new IllegalArgumentException("Passphrase P must be provided.");
        } else if (bArr2 == null) {
            throw new IllegalArgumentException("Salt S must be provided.");
        } else if (i10 <= 1 || !isPowerOf2(i10)) {
            throw new IllegalArgumentException("Cost parameter N must be > 1 and a power of 2");
        } else if (i11 == 1 && i10 >= 65536) {
            throw new IllegalArgumentException("Cost parameter N must be > 1 and < 65536.");
        } else if (i11 >= 1) {
            int i14 = a.e.API_PRIORITY_OTHER / ((i11 * 128) * 8);
            if (i12 < 1 || i12 > i14) {
                throw new IllegalArgumentException("Parallelisation parameter p must be >= 1 and <= " + i14 + " (based on block size r of " + i11 + ")");
            } else if (i13 >= 1) {
                return MFcrypt(bArr, bArr2, i10, i11, i12, i13);
            } else {
                throw new IllegalArgumentException("Generated key length dkLen must be >= 1.");
            }
        } else {
            throw new IllegalArgumentException("Block size r must be >= 1.");
        }
    }

    private static boolean isPowerOf2(int i10) {
        return (i10 & (i10 + -1)) == 0;
    }
}
