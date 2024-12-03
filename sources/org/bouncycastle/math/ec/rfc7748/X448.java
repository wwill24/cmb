package org.bouncycastle.math.ec.rfc7748;

import java.security.SecureRandom;
import org.bouncycastle.math.ec.rfc8032.Ed448;
import org.bouncycastle.util.Arrays;

public abstract class X448 {
    private static final int C_A = 156326;
    private static final int C_A24 = 39082;
    public static final int POINT_SIZE = 56;
    public static final int SCALAR_SIZE = 56;

    private static class F extends X448Field {
        private F() {
        }
    }

    public static class Friend {
        /* access modifiers changed from: private */
        public static final Friend INSTANCE = new Friend();

        private Friend() {
        }
    }

    public static boolean calculateAgreement(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        scalarMult(bArr, i10, bArr2, i11, bArr3, i12);
        return !Arrays.areAllZeroes(bArr3, i12, 56);
    }

    private static int decode32(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        return (bArr[i12 + 1] << 24) | (bArr[i10] & 255) | ((bArr[i11] & 255) << 8) | ((bArr[i12] & 255) << Tnaf.POW_2_WIDTH);
    }

    private static void decodeScalar(byte[] bArr, int i10, int[] iArr) {
        for (int i11 = 0; i11 < 14; i11++) {
            iArr[i11] = decode32(bArr, (i11 * 4) + i10);
        }
        iArr[0] = iArr[0] & -4;
        iArr[13] = iArr[13] | Integer.MIN_VALUE;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] & 252);
        bArr[55] = (byte) (bArr[55] | 128);
    }

    public static void generatePublicKey(byte[] bArr, int i10, byte[] bArr2, int i11) {
        scalarMultBase(bArr, i10, bArr2, i11);
    }

    private static void pointDouble(int[] iArr, int[] iArr2) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        X448Field.add(iArr, iArr2, create);
        X448Field.sub(iArr, iArr2, create2);
        X448Field.sqr(create, create);
        X448Field.sqr(create2, create2);
        X448Field.mul(create, create2, iArr);
        X448Field.sub(create, create2, create);
        X448Field.mul(create, (int) C_A24, iArr2);
        X448Field.add(iArr2, create2, iArr2);
        X448Field.mul(iArr2, create, iArr2);
    }

    public static void precompute() {
        Ed448.precompute();
    }

    public static void scalarMult(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        int[] iArr = new int[14];
        decodeScalar(bArr, i10, iArr);
        int[] create = X448Field.create();
        X448Field.decode(bArr2, i11, create);
        int[] create2 = X448Field.create();
        X448Field.copy(create, 0, create2, 0);
        int[] create3 = X448Field.create();
        create3[0] = 1;
        int[] create4 = X448Field.create();
        create4[0] = 1;
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        int i13 = 447;
        int i14 = 1;
        while (true) {
            X448Field.add(create4, create5, create6);
            X448Field.sub(create4, create5, create4);
            X448Field.add(create2, create3, create5);
            X448Field.sub(create2, create3, create2);
            X448Field.mul(create6, create2, create6);
            X448Field.mul(create4, create5, create4);
            X448Field.sqr(create5, create5);
            X448Field.sqr(create2, create2);
            X448Field.sub(create5, create2, create7);
            X448Field.mul(create7, (int) C_A24, create3);
            X448Field.add(create3, create2, create3);
            X448Field.mul(create3, create7, create3);
            X448Field.mul(create2, create5, create2);
            X448Field.sub(create6, create4, create5);
            X448Field.add(create6, create4, create4);
            X448Field.sqr(create4, create4);
            X448Field.sqr(create5, create5);
            X448Field.mul(create5, create, create5);
            i13--;
            int i15 = (iArr[i13 >>> 5] >>> (i13 & 31)) & 1;
            int i16 = i14 ^ i15;
            X448Field.cswap(i16, create2, create4);
            X448Field.cswap(i16, create3, create5);
            if (i13 < 2) {
                break;
            }
            i14 = i15;
        }
        for (int i17 = 0; i17 < 2; i17++) {
            pointDouble(create2, create3);
        }
        X448Field.inv(create3, create3);
        X448Field.mul(create2, create3, create2);
        X448Field.normalize(create2);
        X448Field.encode(create2, bArr3, i12);
    }

    public static void scalarMultBase(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        Ed448.scalarMultBaseXY(Friend.INSTANCE, bArr, i10, create, create2);
        X448Field.inv(create, create);
        X448Field.mul(create, create2, create);
        X448Field.sqr(create, create);
        X448Field.normalize(create);
        X448Field.encode(create, bArr2, i11);
    }
}
