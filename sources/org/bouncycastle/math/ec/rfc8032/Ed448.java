package org.bouncycastle.math.ec.rfc8032;

import com.facebook.appevents.UserDataStore;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.math.ec.rfc7748.X448;
import org.bouncycastle.math.ec.rfc7748.X448Field;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;

public abstract class Ed448 {
    private static final int[] B_x = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};
    private static final int[] B_y = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};
    private static final int COORD_INTS = 14;
    private static final int C_d = -39081;
    private static final byte[] DOM4_PREFIX = {83, 105, 103, 69, 100, 52, 52, 56};
    private static final int[] L = {-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, 1073741823};
    private static final int L4_0 = 43969588;
    private static final int L4_1 = 30366549;
    private static final int L4_2 = 163752818;
    private static final int L4_3 = 258169998;
    private static final int L4_4 = 96434764;
    private static final int L4_5 = 227822194;
    private static final int L4_6 = 149865618;
    private static final int L4_7 = 550336261;
    private static final int L_0 = 78101261;
    private static final int L_1 = 141809365;
    private static final int L_2 = 175155932;
    private static final int L_3 = 64542499;
    private static final int L_4 = 158326419;
    private static final int L_5 = 191173276;
    private static final int L_6 = 104575268;
    private static final int L_7 = 137584065;
    private static final long M26L = 67108863;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;
    private static final int[] P = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    private static final int POINT_BYTES = 57;
    private static final int PRECOMP_BLOCKS = 5;
    private static final int PRECOMP_MASK = 15;
    private static final int PRECOMP_POINTS = 16;
    private static final int PRECOMP_SPACING = 18;
    private static final int PRECOMP_TEETH = 5;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 57;
    private static final int SCALAR_BYTES = 57;
    private static final int SCALAR_INTS = 14;
    public static final int SECRET_KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private static final int WNAF_WIDTH_BASE = 7;
    private static int[] precompBase = null;
    private static PointExt[] precompBaseTable = null;
    private static final Object precompLock = new Object();

    public static final class Algorithm {
        public static final int Ed448 = 0;
        public static final int Ed448ph = 1;
    }

    private static class F extends X448Field {
        private F() {
        }
    }

    private static class PointExt {

        /* renamed from: x  reason: collision with root package name */
        int[] f23960x;

        /* renamed from: y  reason: collision with root package name */
        int[] f23961y;

        /* renamed from: z  reason: collision with root package name */
        int[] f23962z;

        private PointExt() {
            this.f23960x = X448Field.create();
            this.f23961y = X448Field.create();
            this.f23962z = X448Field.create();
        }
    }

    private static class PointPrecomp {

        /* renamed from: x  reason: collision with root package name */
        int[] f23963x;

        /* renamed from: y  reason: collision with root package name */
        int[] f23964y;

        private PointPrecomp() {
            this.f23963x = X448Field.create();
            this.f23964y = X448Field.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[28];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[14];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[14];
        decodeScalar(bArr3, 0, iArr3);
        Nat.mulAddTo(14, iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[114];
        for (int i10 = 0; i10 < 28; i10++) {
            encode32(iArr[i10], bArr4, i10 * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr) {
        return bArr != null && bArr.length < 256;
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        X448Field.sqr(iArr, create2);
        X448Field.sqr(iArr2, create3);
        X448Field.mul(create2, create3, create);
        X448Field.add(create2, create3, create2);
        X448Field.mul(create, 39081, create);
        X448Field.subOne(create);
        X448Field.add(create, create2, create);
        X448Field.normalize(create);
        return X448Field.isZero(create);
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        X448Field.sqr(iArr, create2);
        X448Field.sqr(iArr2, create3);
        X448Field.sqr(iArr3, create4);
        X448Field.mul(create2, create3, create);
        X448Field.add(create2, create3, create2);
        X448Field.mul(create2, create4, create2);
        X448Field.sqr(create4, create4);
        X448Field.mul(create, 39081, create);
        X448Field.sub(create, create4, create);
        X448Field.add(create, create2, create);
        X448Field.normalize(create);
        return X448Field.isZero(create);
    }

    private static boolean checkPointVar(byte[] bArr) {
        if ((bArr[56] & Byte.MAX_VALUE) != 0) {
            return false;
        }
        int[] iArr = new int[14];
        decode32(bArr, 0, iArr, 0, 14);
        return !Nat.gte(14, iArr, P);
    }

    private static boolean checkScalarVar(byte[] bArr, int[] iArr) {
        if (bArr[56] != 0) {
            return false;
        }
        decodeScalar(bArr, 0, iArr);
        return !Nat.gte(14, iArr, L);
    }

    private static byte[] copy(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return bArr2;
    }

    public static Xof createPrehash() {
        return createXof();
    }

    private static Xof createXof() {
        return new SHAKEDigest(256);
    }

    private static int decode16(byte[] bArr, int i10) {
        return ((bArr[i10 + 1] & 255) << 8) | (bArr[i10] & 255);
    }

    private static int decode24(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        return ((bArr[i11 + 1] & 255) << Tnaf.POW_2_WIDTH) | (bArr[i10] & 255) | ((bArr[i11] & 255) << 8);
    }

    private static int decode32(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        return (bArr[i12 + 1] << 24) | (bArr[i10] & 255) | ((bArr[i11] & 255) << 8) | ((bArr[i12] & 255) << Tnaf.POW_2_WIDTH);
    }

    private static void decode32(byte[] bArr, int i10, int[] iArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            iArr[i11 + i13] = decode32(bArr, (i13 * 4) + i10);
        }
    }

    private static boolean decodePointVar(byte[] bArr, int i10, boolean z10, PointExt pointExt) {
        byte[] copy = copy(bArr, i10, 57);
        boolean z11 = false;
        if (!checkPointVar(copy)) {
            return false;
        }
        byte b10 = copy[56];
        int i11 = (b10 & 128) >>> 7;
        copy[56] = (byte) (b10 & Byte.MAX_VALUE);
        X448Field.decode(copy, 0, pointExt.f23961y);
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        X448Field.sqr(pointExt.f23961y, create);
        X448Field.mul(create, 39081, create2);
        X448Field.negate(create, create);
        X448Field.addOne(create);
        X448Field.addOne(create2);
        if (!X448Field.sqrtRatioVar(create, create2, pointExt.f23960x)) {
            return false;
        }
        X448Field.normalize(pointExt.f23960x);
        if (i11 == 1 && X448Field.isZeroVar(pointExt.f23960x)) {
            return false;
        }
        int[] iArr = pointExt.f23960x;
        if (i11 != (iArr[0] & 1)) {
            z11 = true;
        }
        if (z10 ^ z11) {
            X448Field.negate(iArr, iArr);
        }
        pointExtendXY(pointExt);
        return true;
    }

    private static void decodeScalar(byte[] bArr, int i10, int[] iArr) {
        decode32(bArr, i10, iArr, 0, 14);
    }

    private static void dom4(Xof xof, byte b10, byte[] bArr) {
        byte[] bArr2 = DOM4_PREFIX;
        int length = bArr2.length;
        int i10 = length + 2;
        int length2 = bArr.length + i10;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        bArr3[length] = b10;
        bArr3[length + 1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr3, i10, bArr.length);
        xof.update(bArr3, 0, length2);
    }

    private static void encode24(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        bArr[i12 + 1] = (byte) (i10 >>> 16);
    }

    private static void encode32(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 16);
        bArr[i13 + 1] = (byte) (i10 >>> 24);
    }

    private static void encode56(long j10, byte[] bArr, int i10) {
        encode32((int) j10, bArr, i10);
        encode24((int) (j10 >>> 32), bArr, i10 + 4);
    }

    private static int encodePoint(PointExt pointExt, byte[] bArr, int i10) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        X448Field.inv(pointExt.f23962z, create2);
        X448Field.mul(pointExt.f23960x, create2, create);
        X448Field.mul(pointExt.f23961y, create2, create2);
        X448Field.normalize(create);
        X448Field.normalize(create2);
        int checkPoint = checkPoint(create, create2);
        X448Field.encode(create2, bArr, i10);
        bArr[(i10 + 57) - 1] = (byte) ((create[0] & 1) << 7);
        return checkPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i10, byte[] bArr2, int i11) {
        Xof createXof = createXof();
        byte[] bArr3 = new byte[114];
        createXof.update(bArr, i10, 57);
        createXof.doFinal(bArr3, 0, 114);
        byte[] bArr4 = new byte[57];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i11);
    }

    private static int getWindow4(int[] iArr, int i10) {
        return (iArr[i10 >>> 3] >>> ((i10 & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] iArr, int i10) {
        int i11;
        int[] iArr2 = new int[28];
        int i12 = 0;
        int i13 = 14;
        int i14 = 28;
        int i15 = 0;
        while (true) {
            i13--;
            if (i13 < 0) {
                break;
            }
            int i16 = iArr[i13];
            int i17 = i14 - 1;
            iArr2[i17] = (i15 << 16) | (i16 >>> 16);
            i14 = i17 - 1;
            iArr2[i14] = i16;
            i15 = i16;
        }
        byte[] bArr = new byte[447];
        int i18 = 32 - i10;
        int i19 = 0;
        int i20 = 0;
        while (i12 < 28) {
            int i21 = iArr2[i12];
            while (i11 < 16) {
                int i22 = i21 >>> i11;
                if ((i22 & 1) == i20) {
                    i11++;
                } else {
                    int i23 = (i22 | 1) << i18;
                    bArr[(i12 << 4) + i11] = (byte) (i23 >> i18);
                    i11 += i10;
                    i20 = i23 >>> 31;
                }
            }
            i12++;
            i19 = i11 - 16;
        }
        return bArr;
    }

    private static void implSign(Xof xof, byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, byte[] bArr4, byte b10, byte[] bArr5, int i11, int i12, byte[] bArr6, int i13) {
        dom4(xof, b10, bArr4);
        xof.update(bArr, 57, 57);
        xof.update(bArr5, i11, i12);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] reduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(reduceScalar, bArr7, 0);
        dom4(xof, b10, bArr4);
        xof.update(bArr7, 0, 57);
        xof.update(bArr3, i10, 57);
        xof.update(bArr5, i11, i12);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] calculateS = calculateS(reduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i13, 57);
        System.arraycopy(calculateS, 0, bArr6, i13 + 57, 57);
    }

    private static void implSign(byte[] bArr, int i10, byte[] bArr2, byte b10, byte[] bArr3, int i11, int i12, byte[] bArr4, int i13) {
        if (checkContextVar(bArr2)) {
            Xof createXof = createXof();
            byte[] bArr5 = new byte[114];
            byte[] bArr6 = bArr;
            int i14 = i10;
            createXof.update(bArr, i10, 57);
            createXof.doFinal(bArr5, 0, 114);
            byte[] bArr7 = new byte[57];
            pruneScalar(bArr5, 0, bArr7);
            byte[] bArr8 = new byte[57];
            scalarMultBaseEncoded(bArr7, bArr8, 0);
            implSign(createXof, bArr5, bArr7, bArr8, 0, bArr2, b10, bArr3, i11, i12, bArr4, i13);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static void implSign(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte b10, byte[] bArr4, int i12, int i13, byte[] bArr5, int i14) {
        if (checkContextVar(bArr3)) {
            Xof createXof = createXof();
            byte[] bArr6 = new byte[114];
            byte[] bArr7 = bArr;
            int i15 = i10;
            createXof.update(bArr, i10, 57);
            createXof.doFinal(bArr6, 0, 114);
            byte[] bArr8 = new byte[57];
            pruneScalar(bArr6, 0, bArr8);
            implSign(createXof, bArr6, bArr8, bArr2, i11, bArr3, b10, bArr4, i12, i13, bArr5, i14);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean implVerify(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte b10, byte[] bArr4, int i12, int i13) {
        byte[] bArr5 = bArr;
        int i14 = i10;
        byte[] bArr6 = bArr2;
        int i15 = i11;
        if (checkContextVar(bArr3)) {
            byte[] copy = copy(bArr, i14, 57);
            byte[] copy2 = copy(bArr, i14 + 57, 57);
            if (!checkPointVar(copy)) {
                return false;
            }
            int[] iArr = new int[14];
            if (!checkScalarVar(copy2, iArr)) {
                return false;
            }
            PointExt pointExt = new PointExt();
            if (!decodePointVar(bArr6, i15, true, pointExt)) {
                return false;
            }
            Xof createXof = createXof();
            byte[] bArr7 = new byte[114];
            dom4(createXof, b10, bArr3);
            createXof.update(copy, 0, 57);
            createXof.update(bArr6, i15, 57);
            createXof.update(bArr4, i12, i13);
            createXof.doFinal(bArr7, 0, 114);
            int[] iArr2 = new int[14];
            decodeScalar(reduceScalar(bArr7), 0, iArr2);
            PointExt pointExt2 = new PointExt();
            scalarMultStrausVar(iArr, iArr2, pointExt, pointExt2);
            byte[] bArr8 = new byte[57];
            return encodePoint(pointExt2, bArr8, 0) != 0 && Arrays.areEqual(bArr8, copy);
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean isNeutralElementVar(int[] iArr, int[] iArr2, int[] iArr3) {
        return X448Field.isZeroVar(iArr) && X448Field.areEqualVar(iArr2, iArr3);
    }

    private static void pointAdd(PointExt pointExt, PointExt pointExt2) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        int[] create8 = X448Field.create();
        X448Field.mul(pointExt.f23962z, pointExt2.f23962z, create);
        X448Field.sqr(create, create2);
        X448Field.mul(pointExt.f23960x, pointExt2.f23960x, create3);
        X448Field.mul(pointExt.f23961y, pointExt2.f23961y, create4);
        X448Field.mul(create3, create4, create5);
        X448Field.mul(create5, 39081, create5);
        X448Field.add(create2, create5, create6);
        X448Field.sub(create2, create5, create7);
        X448Field.add(pointExt.f23960x, pointExt.f23961y, create2);
        X448Field.add(pointExt2.f23960x, pointExt2.f23961y, create5);
        X448Field.mul(create2, create5, create8);
        X448Field.add(create4, create3, create2);
        X448Field.sub(create4, create3, create5);
        X448Field.carry(create2);
        X448Field.sub(create8, create2, create8);
        X448Field.mul(create8, create, create8);
        X448Field.mul(create5, create, create5);
        X448Field.mul(create6, create8, pointExt2.f23960x);
        X448Field.mul(create5, create7, pointExt2.f23961y);
        X448Field.mul(create6, create7, pointExt2.f23962z);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointExt pointExt) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        X448Field.sqr(pointExt.f23962z, create);
        X448Field.mul(pointPrecomp.f23963x, pointExt.f23960x, create2);
        X448Field.mul(pointPrecomp.f23964y, pointExt.f23961y, create3);
        X448Field.mul(create2, create3, create4);
        X448Field.mul(create4, 39081, create4);
        X448Field.add(create, create4, create5);
        X448Field.sub(create, create4, create6);
        X448Field.add(pointPrecomp.f23963x, pointPrecomp.f23964y, create);
        X448Field.add(pointExt.f23960x, pointExt.f23961y, create4);
        X448Field.mul(create, create4, create7);
        X448Field.add(create3, create2, create);
        X448Field.sub(create3, create2, create4);
        X448Field.carry(create);
        X448Field.sub(create7, create, create7);
        X448Field.mul(create7, pointExt.f23962z, create7);
        X448Field.mul(create4, pointExt.f23962z, create4);
        X448Field.mul(create5, create7, pointExt.f23960x);
        X448Field.mul(create4, create6, pointExt.f23961y);
        X448Field.mul(create5, create6, pointExt.f23962z);
    }

    private static void pointAddVar(boolean z10, PointExt pointExt, PointExt pointExt2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        int[] create8 = X448Field.create();
        if (z10) {
            X448Field.sub(pointExt.f23961y, pointExt.f23960x, create8);
            iArr2 = create2;
            iArr3 = create5;
            iArr4 = create6;
            iArr = create7;
        } else {
            X448Field.add(pointExt.f23961y, pointExt.f23960x, create8);
            iArr3 = create2;
            iArr2 = create5;
            iArr = create6;
            iArr4 = create7;
        }
        X448Field.mul(pointExt.f23962z, pointExt2.f23962z, create);
        X448Field.sqr(create, create2);
        X448Field.mul(pointExt.f23960x, pointExt2.f23960x, create3);
        X448Field.mul(pointExt.f23961y, pointExt2.f23961y, create4);
        X448Field.mul(create3, create4, create5);
        X448Field.mul(create5, 39081, create5);
        X448Field.add(create2, create5, iArr);
        X448Field.sub(create2, create5, iArr4);
        X448Field.add(pointExt2.f23960x, pointExt2.f23961y, create5);
        X448Field.mul(create8, create5, create8);
        X448Field.add(create4, create3, iArr3);
        X448Field.sub(create4, create3, iArr2);
        X448Field.carry(iArr3);
        X448Field.sub(create8, create2, create8);
        X448Field.mul(create8, create, create8);
        X448Field.mul(create5, create, create5);
        X448Field.mul(create6, create8, pointExt2.f23960x);
        X448Field.mul(create5, create7, pointExt2.f23961y);
        X448Field.mul(create6, create7, pointExt2.f23962z);
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        X448Field.copy(pointExt.f23960x, 0, pointExt2.f23960x, 0);
        X448Field.copy(pointExt.f23961y, 0, pointExt2.f23961y, 0);
        X448Field.copy(pointExt.f23962z, 0, pointExt2.f23962z, 0);
    }

    private static void pointDouble(PointExt pointExt) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        X448Field.add(pointExt.f23960x, pointExt.f23961y, create);
        X448Field.sqr(create, create);
        X448Field.sqr(pointExt.f23960x, create2);
        X448Field.sqr(pointExt.f23961y, create3);
        X448Field.add(create2, create3, create4);
        X448Field.carry(create4);
        X448Field.sqr(pointExt.f23962z, create5);
        X448Field.add(create5, create5, create5);
        X448Field.carry(create5);
        X448Field.sub(create4, create5, create6);
        X448Field.sub(create, create4, create);
        X448Field.sub(create2, create3, create2);
        X448Field.mul(create, create6, pointExt.f23960x);
        X448Field.mul(create4, create2, pointExt.f23961y);
        X448Field.mul(create4, create6, pointExt.f23962z);
    }

    private static void pointExtendXY(PointExt pointExt) {
        X448Field.one(pointExt.f23962z);
    }

    private static void pointLookup(int i10, int i11, PointPrecomp pointPrecomp) {
        int i12 = i10 * 16 * 2 * 16;
        for (int i13 = 0; i13 < 16; i13++) {
            int i14 = ((i13 ^ i11) - 1) >> 31;
            X448Field.cmov(i14, precompBase, i12, pointPrecomp.f23963x, 0);
            int i15 = i12 + 16;
            X448Field.cmov(i14, precompBase, i15, pointPrecomp.f23964y, 0);
            i12 = i15 + 16;
        }
    }

    private static void pointLookup(int[] iArr, int i10, int[] iArr2, PointExt pointExt) {
        int window4 = getWindow4(iArr, i10);
        int i11 = (window4 >>> 3) ^ 1;
        int i12 = (window4 ^ (-i11)) & 7;
        int i13 = 0;
        for (int i14 = 0; i14 < 8; i14++) {
            int i15 = ((i14 ^ i12) - 1) >> 31;
            X448Field.cmov(i15, iArr2, i13, pointExt.f23960x, 0);
            int i16 = i13 + 16;
            X448Field.cmov(i15, iArr2, i16, pointExt.f23961y, 0);
            int i17 = i16 + 16;
            X448Field.cmov(i15, iArr2, i17, pointExt.f23962z, 0);
            i13 = i17 + 16;
        }
        X448Field.cnegate(i11, pointExt.f23960x);
    }

    private static int[] pointPrecompute(PointExt pointExt, int i10) {
        PointExt pointCopy = pointCopy(pointExt);
        PointExt pointCopy2 = pointCopy(pointCopy);
        pointDouble(pointCopy2);
        int[] createTable = X448Field.createTable(i10 * 3);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            X448Field.copy(pointCopy.f23960x, 0, createTable, i11);
            int i13 = i11 + 16;
            X448Field.copy(pointCopy.f23961y, 0, createTable, i13);
            int i14 = i13 + 16;
            X448Field.copy(pointCopy.f23962z, 0, createTable, i14);
            i11 = i14 + 16;
            i12++;
            if (i12 == i10) {
                return createTable;
            }
            pointAdd(pointCopy2, pointCopy);
        }
    }

    private static PointExt[] pointPrecomputeVar(PointExt pointExt, int i10) {
        PointExt pointCopy = pointCopy(pointExt);
        pointDouble(pointCopy);
        PointExt[] pointExtArr = new PointExt[i10];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i11 = 1; i11 < i10; i11++) {
            PointExt pointCopy2 = pointCopy(pointExtArr[i11 - 1]);
            pointExtArr[i11] = pointCopy2;
            pointAddVar(false, pointCopy, pointCopy2);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointExt pointExt) {
        X448Field.zero(pointExt.f23960x);
        X448Field.one(pointExt.f23961y);
        X448Field.one(pointExt.f23962z);
    }

    public static void precompute() {
        synchronized (precompLock) {
            if (precompBase == null) {
                PointExt pointExt = new PointExt();
                X448Field.copy(B_x, 0, pointExt.f23960x, 0);
                X448Field.copy(B_y, 0, pointExt.f23961y, 0);
                pointExtendXY(pointExt);
                precompBaseTable = pointPrecomputeVar(pointExt, 32);
                precompBase = X448Field.createTable(160);
                int i10 = 0;
                for (int i11 = 0; i11 < 5; i11++) {
                    PointExt[] pointExtArr = new PointExt[5];
                    PointExt pointExt2 = new PointExt();
                    pointSetNeutral(pointExt2);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= 5) {
                            break;
                        }
                        pointAddVar(true, pointExt, pointExt2);
                        pointDouble(pointExt);
                        pointExtArr[i12] = pointCopy(pointExt);
                        if (i11 + i12 != 8) {
                            for (int i13 = 1; i13 < 18; i13++) {
                                pointDouble(pointExt);
                            }
                        }
                        i12++;
                    }
                    PointExt[] pointExtArr2 = new PointExt[16];
                    pointExtArr2[0] = pointExt2;
                    int i14 = 1;
                    for (int i15 = 0; i15 < 4; i15++) {
                        int i16 = 1 << i15;
                        int i17 = 0;
                        while (i17 < i16) {
                            PointExt pointCopy = pointCopy(pointExtArr2[i14 - i16]);
                            pointExtArr2[i14] = pointCopy;
                            pointAddVar(false, pointExtArr[i15], pointCopy);
                            i17++;
                            i14++;
                        }
                    }
                    int[] createTable = X448Field.createTable(16);
                    int[] create = X448Field.create();
                    X448Field.copy(pointExtArr2[0].f23962z, 0, create, 0);
                    X448Field.copy(create, 0, createTable, 0);
                    int i18 = 0;
                    while (true) {
                        i18++;
                        if (i18 >= 16) {
                            break;
                        }
                        X448Field.mul(create, pointExtArr2[i18].f23962z, create);
                        X448Field.copy(create, 0, createTable, i18 * 16);
                    }
                    X448Field.invVar(create, create);
                    int i19 = i18 - 1;
                    int[] create2 = X448Field.create();
                    while (i19 > 0) {
                        int i20 = i19 - 1;
                        X448Field.copy(createTable, i20 * 16, create2, 0);
                        X448Field.mul(create2, create, create2);
                        X448Field.copy(create2, 0, createTable, i19 * 16);
                        X448Field.mul(create, pointExtArr2[i19].f23962z, create);
                        i19 = i20;
                    }
                    X448Field.copy(create, 0, createTable, 0);
                    for (int i21 = 0; i21 < 16; i21++) {
                        PointExt pointExt3 = pointExtArr2[i21];
                        X448Field.copy(createTable, i21 * 16, pointExt3.f23962z, 0);
                        int[] iArr = pointExt3.f23960x;
                        X448Field.mul(iArr, pointExt3.f23962z, iArr);
                        int[] iArr2 = pointExt3.f23961y;
                        X448Field.mul(iArr2, pointExt3.f23962z, iArr2);
                        X448Field.copy(pointExt3.f23960x, 0, precompBase, i10);
                        int i22 = i10 + 16;
                        X448Field.copy(pointExt3.f23961y, 0, precompBase, i22);
                        i10 = i22 + 16;
                    }
                }
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i10, byte[] bArr2) {
        System.arraycopy(bArr, i10, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | 128);
        bArr2[56] = 0;
    }

    private static byte[] reduceScalar(byte[] bArr) {
        byte[] bArr2 = bArr;
        long decode24 = ((long) (decode24(bArr2, 4) << 4)) & 4294967295L;
        long decode32 = ((long) decode32(bArr2, 7)) & 4294967295L;
        long decode242 = ((long) (decode24(bArr2, 11) << 4)) & 4294967295L;
        long decode322 = ((long) decode32(bArr2, 14)) & 4294967295L;
        long decode243 = ((long) (decode24(bArr2, 18) << 4)) & 4294967295L;
        long decode323 = ((long) decode32(bArr2, 21)) & 4294967295L;
        long decode244 = ((long) (decode24(bArr2, 25) << 4)) & 4294967295L;
        long decode324 = ((long) decode32(bArr2, 28)) & 4294967295L;
        long decode245 = ((long) (decode24(bArr2, 32) << 4)) & 4294967295L;
        long decode325 = ((long) decode32(bArr2, 35)) & 4294967295L;
        long decode246 = ((long) (decode24(bArr2, 39) << 4)) & 4294967295L;
        long decode326 = ((long) decode32(bArr2, 42)) & 4294967295L;
        long decode247 = ((long) (decode24(bArr2, 46) << 4)) & 4294967295L;
        long decode327 = ((long) decode32(bArr2, 49)) & 4294967295L;
        long decode248 = ((long) (decode24(bArr2, 53) << 4)) & 4294967295L;
        long decode249 = ((long) (decode24(bArr2, 74) << 4)) & 4294967295L;
        long decode328 = ((long) decode32(bArr2, 77)) & 4294967295L;
        long decode2410 = ((long) (decode24(bArr2, 81) << 4)) & 4294967295L;
        long decode329 = ((long) decode32(bArr2, 84)) & 4294967295L;
        long decode2411 = ((long) (decode24(bArr2, 88) << 4)) & 4294967295L;
        long decode3210 = ((long) decode32(bArr2, 91)) & 4294967295L;
        long decode2412 = ((long) (decode24(bArr2, 95) << 4)) & 4294967295L;
        long decode3211 = ((long) decode32(bArr2, 98)) & 4294967295L;
        long decode2413 = ((long) (decode24(bArr2, 102) << 4)) & 4294967295L;
        long decode3212 = ((long) decode32(bArr2, 105)) & 4294967295L;
        long decode2414 = ((long) (decode24(bArr2, 109) << 4)) & 4294967295L;
        long decode16 = ((long) decode16(bArr2, 112)) & 4294967295L;
        long j10 = decode2410 + (decode16 * 550336261);
        long j11 = decode2414 + (decode3212 >>> 28);
        long j12 = decode3212 & M28L;
        long decode3213 = (((long) decode32(bArr2, 56)) & 4294967295L) + (decode16 * 43969588) + (j11 * 30366549);
        long decode2415 = (((long) (decode24(bArr2, 60) << 4)) & 4294967295L) + (decode16 * 30366549) + (j11 * 163752818);
        long decode3214 = (((long) decode32(bArr2, 63)) & 4294967295L) + (decode16 * 163752818) + (j11 * 258169998);
        long decode2416 = (((long) (decode24(bArr2, 67) << 4)) & 4294967295L) + (decode16 * 258169998) + (j11 * 96434764);
        long j13 = decode328 + (decode16 * 149865618) + (j11 * 550336261);
        long j14 = decode2413 + (decode3211 >>> 28);
        long j15 = decode3211 & M28L;
        long decode3215 = (((long) decode32(bArr2, 70)) & 4294967295L) + (decode16 * 96434764) + (j11 * 227822194) + (j12 * 149865618) + (j14 * 550336261);
        long j16 = decode2412 + (decode3210 >>> 28);
        long j17 = decode3210 & M28L;
        long j18 = decode3214 + (j12 * 96434764) + (j14 * 227822194) + (j15 * 149865618) + (j16 * 550336261);
        long j19 = decode2415 + (j12 * 258169998) + (j14 * 96434764) + (j15 * 227822194) + (j16 * 149865618) + (j17 * 550336261);
        long j20 = decode2411 + (decode329 >>> 28);
        long j21 = decode329 & M28L;
        long j22 = decode249 + (decode16 * 227822194) + (j11 * 149865618) + (j12 * 550336261) + (decode3215 >>> 28);
        long j23 = decode3215 & M28L;
        long j24 = j13 + (j22 >>> 28);
        long j25 = j22 & M28L;
        long j26 = j10 + (j24 >>> 28);
        long j27 = j24 & M28L;
        long j28 = j21 + (j26 >>> 28);
        long j29 = j26 & M28L;
        long j30 = decode244 + (j29 * 43969588);
        long j31 = decode324 + (j28 * 43969588) + (j29 * 30366549);
        long j32 = decode245 + (j20 * 43969588) + (j28 * 30366549) + (j29 * 163752818);
        long j33 = decode325 + (j17 * 43969588) + (j20 * 30366549) + (j28 * 163752818) + (j29 * 258169998);
        long j34 = decode246 + (j16 * 43969588) + (j17 * 30366549) + (j20 * 163752818) + (j28 * 258169998) + (j29 * 96434764);
        long j35 = decode326 + (j15 * 43969588) + (j16 * 30366549) + (j17 * 163752818) + (j20 * 258169998) + (j28 * 96434764) + (j29 * 227822194);
        long j36 = decode327 + (j12 * 43969588) + (j14 * 30366549) + (j15 * 163752818) + (j16 * 258169998) + (j17 * 96434764) + (j20 * 227822194) + (j28 * 149865618) + (j29 * 550336261);
        long j37 = j18 + (j19 >>> 28);
        long j38 = j19 & M28L;
        long j39 = decode2416 + (j12 * 227822194) + (j14 * 149865618) + (j15 * 550336261) + (j37 >>> 28);
        long j40 = j37 & M28L;
        long j41 = j23 + (j39 >>> 28);
        long j42 = j39 & M28L;
        long j43 = j25 + (j41 >>> 28);
        long j44 = j41 & M28L;
        long j45 = decode322 + (j44 * 43969588);
        long j46 = decode243 + (j43 * 43969588) + (j44 * 30366549);
        long j47 = decode323 + (j27 * 43969588) + (j43 * 30366549) + (j44 * 163752818);
        long j48 = j30 + (j27 * 30366549) + (j43 * 163752818) + (j44 * 258169998);
        long j49 = j31 + (j27 * 163752818) + (j43 * 258169998) + (j44 * 96434764);
        long j50 = j32 + (j27 * 258169998) + (j43 * 96434764) + (j44 * 227822194);
        long j51 = j34 + (j27 * 227822194) + (j43 * 149865618) + (j44 * 550336261);
        long j52 = decode242 + (j42 * 43969588);
        long j53 = j45 + (j42 * 30366549);
        long j54 = j46 + (j42 * 163752818);
        long j55 = j47 + (j42 * 258169998);
        long j56 = j48 + (j42 * 96434764);
        long j57 = j49 + (j42 * 227822194);
        long j58 = j50 + (j42 * 149865618);
        long j59 = j33 + (j27 * 96434764) + (j43 * 227822194) + (j44 * 149865618) + (j42 * 550336261);
        long j60 = decode248 + (j11 * 43969588) + (j12 * 30366549) + (j14 * 163752818) + (j15 * 258169998) + (j16 * 96434764) + (j17 * 227822194) + (j20 * 149865618) + (j28 * 550336261) + (j36 >>> 28);
        long j61 = j36 & M28L;
        long j62 = decode3213 + (j12 * 163752818) + (j14 * 258169998) + (j15 * 96434764) + (j16 * 227822194) + (j17 * 149865618) + (j20 * 550336261) + (j60 >>> 28);
        long j63 = j60 & M28L;
        long j64 = j38 + (j62 >>> 28);
        long j65 = j62 & M28L;
        long j66 = j40 + (j64 >>> 28);
        long j67 = j64 & M28L;
        long j68 = decode32 + (j66 * 43969588);
        long j69 = j52 + (j66 * 30366549);
        long j70 = j53 + (j66 * 163752818);
        long j71 = j54 + (j66 * 258169998);
        long j72 = j55 + (j66 * 96434764);
        long j73 = j56 + (j66 * 227822194);
        long j74 = j58 + (j66 * 550336261);
        long j75 = j63 & M26L;
        long j76 = (j65 * 4) + (j63 >>> 26) + 1;
        long decode3216 = (((long) decode32(bArr2, 0)) & 4294967295L) + (78101261 * j76);
        long j77 = j68 + (30366549 * j67) + (175155932 * j76);
        long j78 = j69 + (163752818 * j67) + (64542499 * j76);
        long j79 = j70 + (258169998 * j67) + (158326419 * j76);
        long j80 = j71 + (96434764 * j67) + (191173276 * j76);
        long j81 = j73 + (149865618 * j67) + (j76 * 137584065);
        long j82 = decode24 + (43969588 * j67) + (141809365 * j76) + (decode3216 >>> 28);
        long j83 = decode3216 & M28L;
        long j84 = j77 + (j82 >>> 28);
        long j85 = j82 & M28L;
        long j86 = j78 + (j84 >>> 28);
        long j87 = j84 & M28L;
        long j88 = j79 + (j86 >>> 28);
        long j89 = j86 & M28L;
        long j90 = j80 + (j88 >>> 28);
        long j91 = j88 & M28L;
        long j92 = j72 + (227822194 * j67) + (104575268 * j76) + (j90 >>> 28);
        long j93 = j90 & M28L;
        long j94 = j81 + (j92 >>> 28);
        long j95 = j92 & M28L;
        long j96 = j57 + (j66 * 149865618) + (j67 * 550336261) + (j94 >>> 28);
        long j97 = j94 & M28L;
        long j98 = j74 + (j96 >>> 28);
        long j99 = j96 & M28L;
        long j100 = j59 + (j98 >>> 28);
        long j101 = j98 & M28L;
        long j102 = j51 + (j100 >>> 28);
        long j103 = j100 & M28L;
        long j104 = j35 + (j27 * 149865618) + (j43 * 550336261) + (j102 >>> 28);
        long j105 = j102 & M28L;
        long j106 = decode247 + (j14 * 43969588) + (j15 * 30366549) + (j16 * 163752818) + (j17 * 258169998) + (j20 * 96434764) + (j28 * 227822194) + (j29 * 149865618) + (j27 * 550336261) + (j104 >>> 28);
        long j107 = j104 & M28L;
        long j108 = j61 + (j106 >>> 28);
        long j109 = j106 & M28L;
        long j110 = j75 + (j108 >>> 28);
        long j111 = j108 & M28L;
        long j112 = j110 & M26L;
        long j113 = (j110 >>> 26) - 1;
        long j114 = j83 - (j113 & 78101261);
        long j115 = (j85 - (j113 & 141809365)) + (j114 >> 28);
        long j116 = j114 & M28L;
        long j117 = (j87 - (j113 & 175155932)) + (j115 >> 28);
        long j118 = j115 & M28L;
        long j119 = (j89 - (j113 & 64542499)) + (j117 >> 28);
        long j120 = j117 & M28L;
        long j121 = (j91 - (j113 & 158326419)) + (j119 >> 28);
        long j122 = j119 & M28L;
        long j123 = (j93 - (j113 & 191173276)) + (j121 >> 28);
        long j124 = j121 & M28L;
        long j125 = (j95 - (j113 & 104575268)) + (j123 >> 28);
        long j126 = j123 & M28L;
        long j127 = (j97 - (j113 & 137584065)) + (j125 >> 28);
        long j128 = j125 & M28L;
        long j129 = j99 + (j127 >> 28);
        long j130 = j127 & M28L;
        long j131 = j101 + (j129 >> 28);
        long j132 = j129 & M28L;
        long j133 = j103 + (j131 >> 28);
        long j134 = j131 & M28L;
        long j135 = j105 + (j133 >> 28);
        long j136 = j133 & M28L;
        long j137 = j107 + (j135 >> 28);
        long j138 = j135 & M28L;
        long j139 = j109 + (j137 >> 28);
        long j140 = j137 & M28L;
        long j141 = j111 + (j139 >> 28);
        long j142 = j139 & M28L;
        long j143 = j141 & M28L;
        byte[] bArr3 = new byte[57];
        encode56((j118 << 28) | j116, bArr3, 0);
        encode56((j122 << 28) | j120, bArr3, 7);
        encode56(j124 | (j126 << 28), bArr3, 14);
        encode56(j128 | (j130 << 28), bArr3, 21);
        encode56(j132 | (j134 << 28), bArr3, 28);
        encode56(j136 | (j138 << 28), bArr3, 35);
        encode56(j140 | (j142 << 28), bArr3, 42);
        encode56(((j112 + (j141 >> 28)) << 28) | j143, bArr3, 49);
        return bArr3;
    }

    private static void scalarMult(byte[] bArr, PointExt pointExt, PointExt pointExt2) {
        int[] iArr = new int[14];
        decodeScalar(bArr, 0, iArr);
        Nat.shiftDownBits(14, iArr, 2, 0);
        Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr);
        Nat.shiftDownBit(14, iArr, 1);
        int[] pointPrecompute = pointPrecompute(pointExt, 8);
        PointExt pointExt3 = new PointExt();
        pointLookup(iArr, 111, pointPrecompute, pointExt2);
        for (int i10 = 110; i10 >= 0; i10--) {
            for (int i11 = 0; i11 < 4; i11++) {
                pointDouble(pointExt2);
            }
            pointLookup(iArr, i10, pointPrecompute, pointExt3);
            pointAdd(pointExt3, pointExt2);
        }
        for (int i12 = 0; i12 < 2; i12++) {
            pointDouble(pointExt2);
        }
    }

    private static void scalarMultBase(byte[] bArr, PointExt pointExt) {
        precompute();
        int[] iArr = new int[15];
        decodeScalar(bArr, 0, iArr);
        iArr[14] = Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr) + 4;
        Nat.shiftDownBit(15, iArr, 0);
        PointPrecomp pointPrecomp = new PointPrecomp();
        pointSetNeutral(pointExt);
        int i10 = 17;
        while (true) {
            int i11 = i10;
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = 0;
                for (int i14 = 0; i14 < 5; i14++) {
                    i13 = (i13 & (~(1 << i14))) ^ ((iArr[i11 >>> 5] >>> (i11 & 31)) << i14);
                    i11 += 18;
                }
                int i15 = (i13 >>> 4) & 1;
                pointLookup(i12, ((-i15) ^ i13) & 15, pointPrecomp);
                X448Field.cnegate(i15, pointPrecomp.f23963x);
                pointAddPrecomp(pointPrecomp, pointExt);
            }
            i10--;
            if (i10 >= 0) {
                pointDouble(pointExt);
            } else {
                return;
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i10) {
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr, pointExt);
        if (encodePoint(pointExt, bArr2, i10) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseXY(X448.Friend friend, byte[] bArr, int i10, int[] iArr, int[] iArr2) {
        if (friend != null) {
            byte[] bArr2 = new byte[57];
            pruneScalar(bArr, i10, bArr2);
            PointExt pointExt = new PointExt();
            scalarMultBase(bArr2, pointExt);
            if (checkPoint(pointExt.f23960x, pointExt.f23961y, pointExt.f23962z) != 0) {
                X448Field.copy(pointExt.f23960x, 0, iArr, 0);
                X448Field.copy(pointExt.f23961y, 0, iArr2, 0);
                return;
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("This method is only for use by X448");
    }

    private static void scalarMultOrderVar(PointExt pointExt, PointExt pointExt2) {
        byte[] wnafVar = getWnafVar(L, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i10 = 446;
        while (true) {
            byte b10 = wnafVar[i10];
            if (b10 != 0) {
                int i11 = b10 >> 31;
                boolean z10 = true;
                int i12 = (b10 ^ i11) >>> 1;
                if (i11 == 0) {
                    z10 = false;
                }
                pointAddVar(z10, pointPrecomputeVar[i12], pointExt2);
            }
            i10--;
            if (i10 >= 0) {
                pointDouble(pointExt2);
            } else {
                return;
            }
        }
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointExt pointExt, PointExt pointExt2) {
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i10 = 446;
        while (true) {
            byte b10 = wnafVar[i10];
            boolean z10 = false;
            if (b10 != 0) {
                int i11 = b10 >> 31;
                pointAddVar(i11 != 0, precompBaseTable[(b10 ^ i11) >>> 1], pointExt2);
            }
            byte b11 = wnafVar2[i10];
            if (b11 != 0) {
                int i12 = b11 >> 31;
                int i13 = (b11 ^ i12) >>> 1;
                if (i12 != 0) {
                    z10 = true;
                }
                pointAddVar(z10, pointPrecomputeVar[i13], pointExt2);
            }
            i10--;
            if (i10 >= 0) {
                pointDouble(pointExt2);
            } else {
                return;
            }
        }
    }

    public static void sign(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, int i13, byte[] bArr5, int i14) {
        implSign(bArr, i10, bArr2, i11, bArr3, (byte) 0, bArr4, i12, i13, bArr5, i14);
    }

    public static void sign(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, int i11, int i12, byte[] bArr4, int i13) {
        implSign(bArr, i10, bArr2, (byte) 0, bArr3, i11, i12, bArr4, i13);
    }

    public static void signPrehash(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, Xof xof, byte[] bArr4, int i12) {
        byte[] bArr5 = new byte[64];
        if (64 == xof.doFinal(bArr5, 0, 64)) {
            implSign(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i12);
            return;
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static void signPrehash(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, byte[] bArr5, int i13) {
        implSign(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, i12, 64, bArr5, i13);
    }

    public static void signPrehash(byte[] bArr, int i10, byte[] bArr2, Xof xof, byte[] bArr3, int i11) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            implSign(bArr, i10, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i11);
            return;
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static void signPrehash(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, int i11, byte[] bArr4, int i12) {
        implSign(bArr, i10, bArr2, (byte) 1, bArr3, i11, 64, bArr4, i12);
    }

    public static boolean validatePublicKeyFull(byte[] bArr, int i10) {
        PointExt pointExt = new PointExt();
        if (!decodePointVar(bArr, i10, false, pointExt)) {
            return false;
        }
        X448Field.normalize(pointExt.f23960x);
        X448Field.normalize(pointExt.f23961y);
        X448Field.normalize(pointExt.f23962z);
        if (isNeutralElementVar(pointExt.f23960x, pointExt.f23961y, pointExt.f23962z)) {
            return false;
        }
        PointExt pointExt2 = new PointExt();
        scalarMultOrderVar(pointExt, pointExt2);
        X448Field.normalize(pointExt2.f23960x);
        X448Field.normalize(pointExt2.f23961y);
        X448Field.normalize(pointExt2.f23962z);
        return isNeutralElementVar(pointExt2.f23960x, pointExt2.f23961y, pointExt2.f23962z);
    }

    public static boolean validatePublicKeyPartial(byte[] bArr, int i10) {
        return decodePointVar(bArr, i10, false, new PointExt());
    }

    public static boolean verify(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, int i13) {
        return implVerify(bArr, i10, bArr2, i11, bArr3, (byte) 0, bArr4, i12, i13);
    }

    public static boolean verifyPrehash(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, Xof xof) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            return implVerify(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static boolean verifyPrehash(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12) {
        return implVerify(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, i12, 64);
    }
}
