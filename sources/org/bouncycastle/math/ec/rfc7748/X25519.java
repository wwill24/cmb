package org.bouncycastle.math.ec.rfc7748;

import com.google.android.gms.common.api.a;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.rfc8032.Ed25519;
import org.bouncycastle.util.Arrays;

public abstract class X25519 {
    private static final int C_A = 486662;
    private static final int C_A24 = 121666;
    public static final int POINT_SIZE = 32;
    public static final int SCALAR_SIZE = 32;

    private static class F extends X25519Field {
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
        return !Arrays.areAllZeroes(bArr3, i12, 32);
    }

    private static int decode32(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        return (bArr[i12 + 1] << 24) | (bArr[i10] & 255) | ((bArr[i11] & 255) << 8) | ((bArr[i12] & 255) << Tnaf.POW_2_WIDTH);
    }

    private static void decodeScalar(byte[] bArr, int i10, int[] iArr) {
        for (int i11 = 0; i11 < 8; i11++) {
            iArr[i11] = decode32(bArr, (i11 * 4) + i10);
        }
        iArr[0] = iArr[0] & -8;
        int i12 = iArr[7] & a.e.API_PRIORITY_OTHER;
        iArr[7] = i12;
        iArr[7] = i12 | 1073741824;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] & 248);
        byte b10 = (byte) (bArr[31] & Byte.MAX_VALUE);
        bArr[31] = b10;
        bArr[31] = (byte) (b10 | 64);
    }

    public static void generatePublicKey(byte[] bArr, int i10, byte[] bArr2, int i11) {
        scalarMultBase(bArr, i10, bArr2, i11);
    }

    private static void pointDouble(int[] iArr, int[] iArr2) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        X25519Field.apm(iArr, iArr2, create, create2);
        X25519Field.sqr(create, create);
        X25519Field.sqr(create2, create2);
        X25519Field.mul(create, create2, iArr);
        X25519Field.sub(create, create2, create);
        X25519Field.mul(create, (int) C_A24, iArr2);
        X25519Field.add(iArr2, create2, iArr2);
        X25519Field.mul(iArr2, create, iArr2);
    }

    public static void precompute() {
        Ed25519.precompute();
    }

    public static void scalarMult(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        int[] iArr = new int[8];
        decodeScalar(bArr, i10, iArr);
        int[] create = X25519Field.create();
        X25519Field.decode(bArr2, i11, create);
        int[] create2 = X25519Field.create();
        X25519Field.copy(create, 0, create2, 0);
        int[] create3 = X25519Field.create();
        create3[0] = 1;
        int[] create4 = X25519Field.create();
        create4[0] = 1;
        int[] create5 = X25519Field.create();
        int[] create6 = X25519Field.create();
        int[] create7 = X25519Field.create();
        int i13 = 254;
        int i14 = 1;
        while (true) {
            X25519Field.apm(create4, create5, create6, create4);
            X25519Field.apm(create2, create3, create5, create2);
            X25519Field.mul(create6, create2, create6);
            X25519Field.mul(create4, create5, create4);
            X25519Field.sqr(create5, create5);
            X25519Field.sqr(create2, create2);
            X25519Field.sub(create5, create2, create7);
            X25519Field.mul(create7, (int) C_A24, create3);
            X25519Field.add(create3, create2, create3);
            X25519Field.mul(create3, create7, create3);
            X25519Field.mul(create2, create5, create2);
            X25519Field.apm(create6, create4, create4, create5);
            X25519Field.sqr(create4, create4);
            X25519Field.sqr(create5, create5);
            X25519Field.mul(create5, create, create5);
            i13--;
            int i15 = (iArr[i13 >>> 5] >>> (i13 & 31)) & 1;
            int i16 = i14 ^ i15;
            X25519Field.cswap(i16, create2, create4);
            X25519Field.cswap(i16, create3, create5);
            if (i13 < 3) {
                break;
            }
            i14 = i15;
        }
        for (int i17 = 0; i17 < 3; i17++) {
            pointDouble(create2, create3);
        }
        X25519Field.inv(create3, create3);
        X25519Field.mul(create2, create3, create2);
        X25519Field.normalize(create2);
        X25519Field.encode(create2, bArr3, i12);
    }

    public static void scalarMultBase(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        Ed25519.scalarMultBaseYZ(Friend.INSTANCE, bArr, i10, create, create2);
        X25519Field.apm(create2, create, create, create2);
        X25519Field.inv(create2, create2);
        X25519Field.mul(create, create2, create);
        X25519Field.normalize(create);
        X25519Field.encode(create, bArr2, i11);
    }
}
