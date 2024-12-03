package org.bouncycastle.math.ec.rfc8032;

import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.api.a;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.math.ec.rfc7748.X25519;
import org.bouncycastle.math.ec.rfc7748.X25519Field;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

public abstract class Ed25519 {
    private static final int[] B_x = {52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};
    private static final int[] B_y = {40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};
    private static final int COORD_INTS = 8;
    private static final int[] C_d = {56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};
    private static final int[] C_d2 = {45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};
    private static final int[] C_d4 = {23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};
    private static final byte[] DOM2_PREFIX = {83, 105, 103, 69, 100, Framer.STDERR_FRAME_PREFIX, 53, 53, Framer.STDOUT_FRAME_PREFIX, 57, 32, 110, 111, 32, 69, 100, Framer.STDERR_FRAME_PREFIX, 53, 53, Framer.STDOUT_FRAME_PREFIX, 57, 32, 99, 111, 108, 108, 105, 115, 105, 111, 110, 115};
    private static final int[] L = {1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, 268435456};
    private static final int L0 = -50998291;
    private static final int L1 = 19280294;
    private static final int L2 = 127719000;
    private static final int L3 = -6428113;
    private static final int L4 = 5343;
    private static final long M08L = 255;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;
    private static final int[] P = {-19, -1, -1, -1, -1, -1, -1, a.e.API_PRIORITY_OTHER};
    private static final int POINT_BYTES = 32;
    private static final int PRECOMP_BLOCKS = 8;
    private static final int PRECOMP_MASK = 7;
    private static final int PRECOMP_POINTS = 8;
    private static final int PRECOMP_SPACING = 8;
    private static final int PRECOMP_TEETH = 4;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 32;
    private static final int SCALAR_BYTES = 32;
    private static final int SCALAR_INTS = 8;
    public static final int SECRET_KEY_SIZE = 32;
    public static final int SIGNATURE_SIZE = 64;
    private static final int WNAF_WIDTH_BASE = 7;
    private static int[] precompBase = null;
    private static PointExt[] precompBaseTable = null;
    private static final Object precompLock = new Object();

    public static final class Algorithm {
        public static final int Ed25519 = 0;
        public static final int Ed25519ctx = 1;
        public static final int Ed25519ph = 2;
    }

    private static class F extends X25519Field {
        private F() {
        }
    }

    private static class PointAccum {

        /* renamed from: u  reason: collision with root package name */
        int[] f23949u;

        /* renamed from: v  reason: collision with root package name */
        int[] f23950v;

        /* renamed from: x  reason: collision with root package name */
        int[] f23951x;

        /* renamed from: y  reason: collision with root package name */
        int[] f23952y;

        /* renamed from: z  reason: collision with root package name */
        int[] f23953z;

        private PointAccum() {
            this.f23951x = X25519Field.create();
            this.f23952y = X25519Field.create();
            this.f23953z = X25519Field.create();
            this.f23949u = X25519Field.create();
            this.f23950v = X25519Field.create();
        }
    }

    private static class PointAffine {

        /* renamed from: x  reason: collision with root package name */
        int[] f23954x;

        /* renamed from: y  reason: collision with root package name */
        int[] f23955y;

        private PointAffine() {
            this.f23954x = X25519Field.create();
            this.f23955y = X25519Field.create();
        }
    }

    private static class PointExt {

        /* renamed from: t  reason: collision with root package name */
        int[] f23956t;

        /* renamed from: x  reason: collision with root package name */
        int[] f23957x;

        /* renamed from: y  reason: collision with root package name */
        int[] f23958y;

        /* renamed from: z  reason: collision with root package name */
        int[] f23959z;

        private PointExt() {
            this.f23957x = X25519Field.create();
            this.f23958y = X25519Field.create();
            this.f23959z = X25519Field.create();
            this.f23956t = X25519Field.create();
        }
    }

    private static class PointPrecomp {
        int[] xyd;
        int[] ymx_h;
        int[] ypx_h;

        private PointPrecomp() {
            this.ypx_h = X25519Field.create();
            this.ymx_h = X25519Field.create();
            this.xyd = X25519Field.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[16];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[8];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[8];
        decodeScalar(bArr3, 0, iArr3);
        Nat256.mulAddTo(iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[64];
        for (int i10 = 0; i10 < 16; i10++) {
            encode32(iArr[i10], bArr4, i10 * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr, byte b10) {
        return (bArr == null && b10 == 0) || (bArr != null && bArr.length < 256);
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        X25519Field.sqr(iArr, create2);
        X25519Field.sqr(iArr2, create3);
        X25519Field.mul(create2, create3, create);
        X25519Field.sub(create3, create2, create3);
        X25519Field.mul(create, C_d, create);
        X25519Field.addOne(create);
        X25519Field.sub(create, create3, create);
        X25519Field.normalize(create);
        return X25519Field.isZero(create);
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] create4 = X25519Field.create();
        X25519Field.sqr(iArr, create2);
        X25519Field.sqr(iArr2, create3);
        X25519Field.sqr(iArr3, create4);
        X25519Field.mul(create2, create3, create);
        X25519Field.sub(create3, create2, create3);
        X25519Field.mul(create3, create4, create3);
        X25519Field.sqr(create4, create4);
        X25519Field.mul(create, C_d, create);
        X25519Field.add(create, create4, create);
        X25519Field.sub(create, create3, create);
        X25519Field.normalize(create);
        return X25519Field.isZero(create);
    }

    private static boolean checkPointVar(byte[] bArr) {
        int[] iArr = new int[8];
        decode32(bArr, 0, iArr, 0, 8);
        iArr[7] = iArr[7] & a.e.API_PRIORITY_OTHER;
        return !Nat256.gte(iArr, P);
    }

    private static boolean checkScalarVar(byte[] bArr, int[] iArr) {
        decodeScalar(bArr, 0, iArr);
        return !Nat256.gte(iArr, L);
    }

    private static byte[] copy(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return bArr2;
    }

    private static Digest createDigest() {
        return new SHA512Digest();
    }

    public static Digest createPrehash() {
        return createDigest();
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

    private static boolean decodePointVar(byte[] bArr, int i10, boolean z10, PointAffine pointAffine) {
        byte[] copy = copy(bArr, i10, 32);
        boolean z11 = false;
        if (!checkPointVar(copy)) {
            return false;
        }
        byte b10 = copy[31];
        int i11 = (b10 & 128) >>> 7;
        copy[31] = (byte) (b10 & Byte.MAX_VALUE);
        X25519Field.decode(copy, 0, pointAffine.f23955y);
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        X25519Field.sqr(pointAffine.f23955y, create);
        X25519Field.mul(C_d, create, create2);
        X25519Field.subOne(create);
        X25519Field.addOne(create2);
        if (!X25519Field.sqrtRatioVar(create, create2, pointAffine.f23954x)) {
            return false;
        }
        X25519Field.normalize(pointAffine.f23954x);
        if (i11 == 1 && X25519Field.isZeroVar(pointAffine.f23954x)) {
            return false;
        }
        int[] iArr = pointAffine.f23954x;
        if (i11 != (iArr[0] & 1)) {
            z11 = true;
        }
        if (z10 ^ z11) {
            X25519Field.negate(iArr, iArr);
        }
        return true;
    }

    private static void decodeScalar(byte[] bArr, int i10, int[] iArr) {
        decode32(bArr, i10, iArr, 0, 8);
    }

    private static void dom2(Digest digest, byte b10, byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = DOM2_PREFIX;
            int length = bArr2.length;
            int i10 = length + 2;
            int length2 = bArr.length + i10;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr3, 0, length);
            bArr3[length] = b10;
            bArr3[length + 1] = (byte) bArr.length;
            System.arraycopy(bArr, 0, bArr3, i10, bArr.length);
            digest.update(bArr3, 0, length2);
        }
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

    private static int encodePoint(PointAccum pointAccum, byte[] bArr, int i10) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        X25519Field.inv(pointAccum.f23953z, create2);
        X25519Field.mul(pointAccum.f23951x, create2, create);
        X25519Field.mul(pointAccum.f23952y, create2, create2);
        X25519Field.normalize(create);
        X25519Field.normalize(create2);
        int checkPoint = checkPoint(create, create2);
        X25519Field.encode(create2, bArr, i10);
        int i11 = (i10 + 32) - 1;
        bArr[i11] = (byte) (((create[0] & 1) << 7) | bArr[i11]);
        return checkPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i10, byte[] bArr2, int i11) {
        Digest createDigest = createDigest();
        byte[] bArr3 = new byte[createDigest.getDigestSize()];
        createDigest.update(bArr, i10, 32);
        createDigest.doFinal(bArr3, 0);
        byte[] bArr4 = new byte[32];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i11);
    }

    private static int getWindow4(int[] iArr, int i10) {
        return (iArr[i10 >>> 3] >>> ((i10 & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] iArr, int i10) {
        int i11;
        int[] iArr2 = new int[16];
        int i12 = 0;
        int i13 = 8;
        int i14 = 16;
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
        byte[] bArr = new byte[253];
        int i18 = 32 - i10;
        int i19 = 0;
        int i20 = 0;
        while (i12 < 16) {
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

    private static void implSign(Digest digest, byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, byte[] bArr4, byte b10, byte[] bArr5, int i11, int i12, byte[] bArr6, int i13) {
        dom2(digest, b10, bArr4);
        digest.update(bArr, 32, 32);
        digest.update(bArr5, i11, i12);
        digest.doFinal(bArr, 0);
        byte[] reduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[32];
        scalarMultBaseEncoded(reduceScalar, bArr7, 0);
        dom2(digest, b10, bArr4);
        digest.update(bArr7, 0, 32);
        digest.update(bArr3, i10, 32);
        digest.update(bArr5, i11, i12);
        digest.doFinal(bArr, 0);
        byte[] calculateS = calculateS(reduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i13, 32);
        System.arraycopy(calculateS, 0, bArr6, i13 + 32, 32);
    }

    private static void implSign(byte[] bArr, int i10, byte[] bArr2, byte b10, byte[] bArr3, int i11, int i12, byte[] bArr4, int i13) {
        if (checkContextVar(bArr2, b10)) {
            Digest createDigest = createDigest();
            byte[] bArr5 = new byte[createDigest.getDigestSize()];
            byte[] bArr6 = bArr;
            int i14 = i10;
            createDigest.update(bArr, i10, 32);
            createDigest.doFinal(bArr5, 0);
            byte[] bArr7 = new byte[32];
            pruneScalar(bArr5, 0, bArr7);
            byte[] bArr8 = new byte[32];
            scalarMultBaseEncoded(bArr7, bArr8, 0);
            implSign(createDigest, bArr5, bArr7, bArr8, 0, bArr2, b10, bArr3, i11, i12, bArr4, i13);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static void implSign(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte b10, byte[] bArr4, int i12, int i13, byte[] bArr5, int i14) {
        if (checkContextVar(bArr3, b10)) {
            Digest createDigest = createDigest();
            byte[] bArr6 = new byte[createDigest.getDigestSize()];
            byte[] bArr7 = bArr;
            int i15 = i10;
            createDigest.update(bArr, i10, 32);
            createDigest.doFinal(bArr6, 0);
            byte[] bArr8 = new byte[32];
            pruneScalar(bArr6, 0, bArr8);
            implSign(createDigest, bArr6, bArr8, bArr2, i11, bArr3, b10, bArr4, i12, i13, bArr5, i14);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean implVerify(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte b10, byte[] bArr4, int i12, int i13) {
        byte[] bArr5 = bArr;
        int i14 = i10;
        byte[] bArr6 = bArr2;
        int i15 = i11;
        if (checkContextVar(bArr3, b10)) {
            byte[] copy = copy(bArr, i10, 32);
            byte[] copy2 = copy(bArr, i14 + 32, 32);
            if (!checkPointVar(copy)) {
                return false;
            }
            int[] iArr = new int[8];
            if (!checkScalarVar(copy2, iArr)) {
                return false;
            }
            PointAffine pointAffine = new PointAffine();
            if (!decodePointVar(bArr6, i15, true, pointAffine)) {
                return false;
            }
            Digest createDigest = createDigest();
            byte[] bArr7 = new byte[createDigest.getDigestSize()];
            dom2(createDigest, b10, bArr3);
            createDigest.update(copy, 0, 32);
            createDigest.update(bArr6, i15, 32);
            createDigest.update(bArr4, i12, i13);
            createDigest.doFinal(bArr7, 0);
            int[] iArr2 = new int[8];
            decodeScalar(reduceScalar(bArr7), 0, iArr2);
            PointAccum pointAccum = new PointAccum();
            scalarMultStrausVar(iArr, iArr2, pointAffine, pointAccum);
            byte[] bArr8 = new byte[32];
            return encodePoint(pointAccum, bArr8, 0) != 0 && Arrays.areEqual(bArr8, copy);
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean isNeutralElementVar(int[] iArr, int[] iArr2) {
        return X25519Field.isZeroVar(iArr) && X25519Field.isOneVar(iArr2);
    }

    private static boolean isNeutralElementVar(int[] iArr, int[] iArr2, int[] iArr3) {
        return X25519Field.isZeroVar(iArr) && X25519Field.areEqualVar(iArr2, iArr3);
    }

    private static void pointAdd(PointExt pointExt, PointAccum pointAccum) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] create4 = X25519Field.create();
        int[] iArr = pointAccum.f23949u;
        int[] create5 = X25519Field.create();
        int[] create6 = X25519Field.create();
        int[] iArr2 = pointAccum.f23950v;
        X25519Field.apm(pointAccum.f23952y, pointAccum.f23951x, create2, create);
        X25519Field.apm(pointExt.f23958y, pointExt.f23957x, create4, create3);
        X25519Field.mul(create, create3, create);
        X25519Field.mul(create2, create4, create2);
        X25519Field.mul(pointAccum.f23949u, pointAccum.f23950v, create3);
        X25519Field.mul(create3, pointExt.f23956t, create3);
        X25519Field.mul(create3, C_d2, create3);
        X25519Field.mul(pointAccum.f23953z, pointExt.f23959z, create4);
        X25519Field.add(create4, create4, create4);
        X25519Field.apm(create2, create, iArr2, iArr);
        X25519Field.apm(create4, create3, create6, create5);
        X25519Field.carry(create6);
        X25519Field.mul(iArr, create5, pointAccum.f23951x);
        X25519Field.mul(create6, iArr2, pointAccum.f23952y);
        X25519Field.mul(create5, create6, pointAccum.f23953z);
    }

    private static void pointAdd(PointExt pointExt, PointExt pointExt2) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] create4 = X25519Field.create();
        int[] create5 = X25519Field.create();
        int[] create6 = X25519Field.create();
        int[] create7 = X25519Field.create();
        int[] create8 = X25519Field.create();
        X25519Field.apm(pointExt.f23958y, pointExt.f23957x, create2, create);
        X25519Field.apm(pointExt2.f23958y, pointExt2.f23957x, create4, create3);
        X25519Field.mul(create, create3, create);
        X25519Field.mul(create2, create4, create2);
        X25519Field.mul(pointExt.f23956t, pointExt2.f23956t, create3);
        X25519Field.mul(create3, C_d2, create3);
        X25519Field.mul(pointExt.f23959z, pointExt2.f23959z, create4);
        X25519Field.add(create4, create4, create4);
        X25519Field.apm(create2, create, create8, create5);
        X25519Field.apm(create4, create3, create7, create6);
        X25519Field.carry(create7);
        X25519Field.mul(create5, create6, pointExt2.f23957x);
        X25519Field.mul(create7, create8, pointExt2.f23958y);
        X25519Field.mul(create6, create7, pointExt2.f23959z);
        X25519Field.mul(create5, create8, pointExt2.f23956t);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointAccum pointAccum) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] iArr = pointAccum.f23949u;
        int[] create4 = X25519Field.create();
        int[] create5 = X25519Field.create();
        int[] iArr2 = pointAccum.f23950v;
        X25519Field.apm(pointAccum.f23952y, pointAccum.f23951x, create2, create);
        X25519Field.mul(create, pointPrecomp.ymx_h, create);
        X25519Field.mul(create2, pointPrecomp.ypx_h, create2);
        X25519Field.mul(pointAccum.f23949u, pointAccum.f23950v, create3);
        X25519Field.mul(create3, pointPrecomp.xyd, create3);
        X25519Field.apm(create2, create, iArr2, iArr);
        X25519Field.apm(pointAccum.f23953z, create3, create5, create4);
        X25519Field.carry(create5);
        X25519Field.mul(iArr, create4, pointAccum.f23951x);
        X25519Field.mul(create5, iArr2, pointAccum.f23952y);
        X25519Field.mul(create4, create5, pointAccum.f23953z);
    }

    private static void pointAddVar(boolean z10, PointExt pointExt, PointAccum pointAccum) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] create4 = X25519Field.create();
        int[] iArr5 = pointAccum.f23949u;
        int[] create5 = X25519Field.create();
        int[] create6 = X25519Field.create();
        int[] iArr6 = pointAccum.f23950v;
        if (z10) {
            iArr = create3;
            iArr4 = create4;
            iArr3 = create5;
            iArr2 = create6;
        } else {
            iArr4 = create3;
            iArr = create4;
            iArr2 = create5;
            iArr3 = create6;
        }
        X25519Field.apm(pointAccum.f23952y, pointAccum.f23951x, create2, create);
        X25519Field.apm(pointExt.f23958y, pointExt.f23957x, iArr, iArr4);
        X25519Field.mul(create, create3, create);
        X25519Field.mul(create2, create4, create2);
        X25519Field.mul(pointAccum.f23949u, pointAccum.f23950v, create3);
        X25519Field.mul(create3, pointExt.f23956t, create3);
        X25519Field.mul(create3, C_d2, create3);
        X25519Field.mul(pointAccum.f23953z, pointExt.f23959z, create4);
        X25519Field.add(create4, create4, create4);
        X25519Field.apm(create2, create, iArr6, iArr5);
        X25519Field.apm(create4, create3, iArr3, iArr2);
        X25519Field.carry(iArr3);
        X25519Field.mul(iArr5, create5, pointAccum.f23951x);
        X25519Field.mul(create6, iArr6, pointAccum.f23952y);
        X25519Field.mul(create5, create6, pointAccum.f23953z);
    }

    private static void pointAddVar(boolean z10, PointExt pointExt, PointExt pointExt2, PointExt pointExt3) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        PointExt pointExt4 = pointExt;
        PointExt pointExt5 = pointExt2;
        PointExt pointExt6 = pointExt3;
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] create4 = X25519Field.create();
        int[] create5 = X25519Field.create();
        int[] create6 = X25519Field.create();
        int[] create7 = X25519Field.create();
        int[] create8 = X25519Field.create();
        if (z10) {
            iArr4 = create3;
            iArr3 = create4;
            iArr2 = create6;
            iArr = create7;
        } else {
            iArr3 = create3;
            iArr4 = create4;
            iArr = create6;
            iArr2 = create7;
        }
        X25519Field.apm(pointExt4.f23958y, pointExt4.f23957x, create2, create);
        X25519Field.apm(pointExt5.f23958y, pointExt5.f23957x, iArr4, iArr3);
        X25519Field.mul(create, create3, create);
        X25519Field.mul(create2, create4, create2);
        X25519Field.mul(pointExt4.f23956t, pointExt5.f23956t, create3);
        X25519Field.mul(create3, C_d2, create3);
        X25519Field.mul(pointExt4.f23959z, pointExt5.f23959z, create4);
        X25519Field.add(create4, create4, create4);
        X25519Field.apm(create2, create, create8, create5);
        X25519Field.apm(create4, create3, iArr2, iArr);
        X25519Field.carry(iArr2);
        X25519Field.mul(create5, create6, pointExt6.f23957x);
        int[] iArr5 = create7;
        X25519Field.mul(iArr5, create8, pointExt6.f23958y);
        X25519Field.mul(create6, iArr5, pointExt6.f23959z);
        X25519Field.mul(create5, create8, pointExt6.f23956t);
    }

    private static PointExt pointCopy(PointAccum pointAccum) {
        PointExt pointExt = new PointExt();
        X25519Field.copy(pointAccum.f23951x, 0, pointExt.f23957x, 0);
        X25519Field.copy(pointAccum.f23952y, 0, pointExt.f23958y, 0);
        X25519Field.copy(pointAccum.f23953z, 0, pointExt.f23959z, 0);
        X25519Field.mul(pointAccum.f23949u, pointAccum.f23950v, pointExt.f23956t);
        return pointExt;
    }

    private static PointExt pointCopy(PointAffine pointAffine) {
        PointExt pointExt = new PointExt();
        X25519Field.copy(pointAffine.f23954x, 0, pointExt.f23957x, 0);
        X25519Field.copy(pointAffine.f23955y, 0, pointExt.f23958y, 0);
        pointExtendXY(pointExt);
        return pointExt;
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointCopy(PointAffine pointAffine, PointAccum pointAccum) {
        X25519Field.copy(pointAffine.f23954x, 0, pointAccum.f23951x, 0);
        X25519Field.copy(pointAffine.f23955y, 0, pointAccum.f23952y, 0);
        pointExtendXY(pointAccum);
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        X25519Field.copy(pointExt.f23957x, 0, pointExt2.f23957x, 0);
        X25519Field.copy(pointExt.f23958y, 0, pointExt2.f23958y, 0);
        X25519Field.copy(pointExt.f23959z, 0, pointExt2.f23959z, 0);
        X25519Field.copy(pointExt.f23956t, 0, pointExt2.f23956t, 0);
    }

    private static void pointDouble(PointAccum pointAccum) {
        int[] create = X25519Field.create();
        int[] create2 = X25519Field.create();
        int[] create3 = X25519Field.create();
        int[] iArr = pointAccum.f23949u;
        int[] create4 = X25519Field.create();
        int[] create5 = X25519Field.create();
        int[] iArr2 = pointAccum.f23950v;
        X25519Field.sqr(pointAccum.f23951x, create);
        X25519Field.sqr(pointAccum.f23952y, create2);
        X25519Field.sqr(pointAccum.f23953z, create3);
        X25519Field.add(create3, create3, create3);
        X25519Field.apm(create, create2, iArr2, create5);
        X25519Field.add(pointAccum.f23951x, pointAccum.f23952y, iArr);
        X25519Field.sqr(iArr, iArr);
        X25519Field.sub(iArr2, iArr, iArr);
        X25519Field.add(create3, create5, create4);
        X25519Field.carry(create4);
        X25519Field.mul(iArr, create4, pointAccum.f23951x);
        X25519Field.mul(create5, iArr2, pointAccum.f23952y);
        X25519Field.mul(create4, create5, pointAccum.f23953z);
    }

    private static void pointExtendXY(PointAccum pointAccum) {
        X25519Field.one(pointAccum.f23953z);
        X25519Field.copy(pointAccum.f23951x, 0, pointAccum.f23949u, 0);
        X25519Field.copy(pointAccum.f23952y, 0, pointAccum.f23950v, 0);
    }

    private static void pointExtendXY(PointExt pointExt) {
        X25519Field.one(pointExt.f23959z);
        X25519Field.mul(pointExt.f23957x, pointExt.f23958y, pointExt.f23956t);
    }

    private static void pointLookup(int i10, int i11, PointPrecomp pointPrecomp) {
        int i12 = i10 * 8 * 3 * 10;
        for (int i13 = 0; i13 < 8; i13++) {
            int i14 = ((i13 ^ i11) - 1) >> 31;
            X25519Field.cmov(i14, precompBase, i12, pointPrecomp.ypx_h, 0);
            int i15 = i12 + 10;
            X25519Field.cmov(i14, precompBase, i15, pointPrecomp.ymx_h, 0);
            int i16 = i15 + 10;
            X25519Field.cmov(i14, precompBase, i16, pointPrecomp.xyd, 0);
            i12 = i16 + 10;
        }
    }

    private static void pointLookup(int[] iArr, int i10, PointExt pointExt) {
        int i11 = i10 * 40;
        X25519Field.copy(iArr, i11, pointExt.f23957x, 0);
        int i12 = i11 + 10;
        X25519Field.copy(iArr, i12, pointExt.f23958y, 0);
        int i13 = i12 + 10;
        X25519Field.copy(iArr, i13, pointExt.f23959z, 0);
        X25519Field.copy(iArr, i13 + 10, pointExt.f23956t, 0);
    }

    private static void pointLookup(int[] iArr, int i10, int[] iArr2, PointExt pointExt) {
        int window4 = getWindow4(iArr, i10);
        int i11 = (window4 >>> 3) ^ 1;
        int i12 = (window4 ^ (-i11)) & 7;
        int i13 = 0;
        for (int i14 = 0; i14 < 8; i14++) {
            int i15 = ((i14 ^ i12) - 1) >> 31;
            X25519Field.cmov(i15, iArr2, i13, pointExt.f23957x, 0);
            int i16 = i13 + 10;
            X25519Field.cmov(i15, iArr2, i16, pointExt.f23958y, 0);
            int i17 = i16 + 10;
            X25519Field.cmov(i15, iArr2, i17, pointExt.f23959z, 0);
            int i18 = i17 + 10;
            X25519Field.cmov(i15, iArr2, i18, pointExt.f23956t, 0);
            i13 = i18 + 10;
        }
        X25519Field.cnegate(i11, pointExt.f23957x);
        X25519Field.cnegate(i11, pointExt.f23956t);
    }

    private static int[] pointPrecompute(PointAffine pointAffine, int i10) {
        PointExt pointCopy = pointCopy(pointAffine);
        PointExt pointCopy2 = pointCopy(pointCopy);
        pointAdd(pointCopy, pointCopy2);
        int[] createTable = X25519Field.createTable(i10 * 4);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            X25519Field.copy(pointCopy.f23957x, 0, createTable, i11);
            int i13 = i11 + 10;
            X25519Field.copy(pointCopy.f23958y, 0, createTable, i13);
            int i14 = i13 + 10;
            X25519Field.copy(pointCopy.f23959z, 0, createTable, i14);
            int i15 = i14 + 10;
            X25519Field.copy(pointCopy.f23956t, 0, createTable, i15);
            i11 = i15 + 10;
            i12++;
            if (i12 == i10) {
                return createTable;
            }
            pointAdd(pointCopy2, pointCopy);
        }
    }

    private static PointExt[] pointPrecomputeVar(PointExt pointExt, int i10) {
        PointExt pointExt2 = new PointExt();
        pointAddVar(false, pointExt, pointExt, pointExt2);
        PointExt[] pointExtArr = new PointExt[i10];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i11 = 1; i11 < i10; i11++) {
            PointExt pointExt3 = pointExtArr[i11 - 1];
            PointExt pointExt4 = new PointExt();
            pointExtArr[i11] = pointExt4;
            pointAddVar(false, pointExt3, pointExt2, pointExt4);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointAccum pointAccum) {
        X25519Field.zero(pointAccum.f23951x);
        X25519Field.one(pointAccum.f23952y);
        X25519Field.one(pointAccum.f23953z);
        X25519Field.zero(pointAccum.f23949u);
        X25519Field.one(pointAccum.f23950v);
    }

    private static void pointSetNeutral(PointExt pointExt) {
        X25519Field.zero(pointExt.f23957x);
        X25519Field.one(pointExt.f23958y);
        X25519Field.one(pointExt.f23959z);
        X25519Field.zero(pointExt.f23956t);
    }

    public static void precompute() {
        int i10;
        synchronized (precompLock) {
            if (precompBase == null) {
                PointExt pointExt = new PointExt();
                int[] iArr = B_x;
                X25519Field.copy(iArr, 0, pointExt.f23957x, 0);
                int[] iArr2 = B_y;
                X25519Field.copy(iArr2, 0, pointExt.f23958y, 0);
                pointExtendXY(pointExt);
                precompBaseTable = pointPrecomputeVar(pointExt, 32);
                PointAccum pointAccum = new PointAccum();
                X25519Field.copy(iArr, 0, pointAccum.f23951x, 0);
                X25519Field.copy(iArr2, 0, pointAccum.f23952y, 0);
                pointExtendXY(pointAccum);
                precompBase = X25519Field.createTable(192);
                int i11 = 0;
                for (int i12 = 0; i12 < 8; i12++) {
                    PointExt[] pointExtArr = new PointExt[4];
                    PointExt pointExt2 = new PointExt();
                    pointSetNeutral(pointExt2);
                    int i13 = 0;
                    while (true) {
                        i10 = 1;
                        if (i13 >= 4) {
                            break;
                        }
                        pointAddVar(true, pointExt2, pointCopy(pointAccum), pointExt2);
                        pointDouble(pointAccum);
                        pointExtArr[i13] = pointCopy(pointAccum);
                        if (i12 + i13 != 10) {
                            while (i10 < 8) {
                                pointDouble(pointAccum);
                                i10++;
                            }
                        }
                        i13++;
                    }
                    PointExt[] pointExtArr2 = new PointExt[8];
                    pointExtArr2[0] = pointExt2;
                    int i14 = 0;
                    int i15 = 1;
                    while (i14 < 3) {
                        int i16 = i10 << i14;
                        int i17 = 0;
                        while (i17 < i16) {
                            PointExt pointExt3 = pointExtArr2[i15 - i16];
                            PointExt pointExt4 = pointExtArr[i14];
                            PointExt pointExt5 = new PointExt();
                            pointExtArr2[i15] = pointExt5;
                            pointAddVar(false, pointExt3, pointExt4, pointExt5);
                            i17++;
                            i15++;
                        }
                        i14++;
                        i10 = 1;
                    }
                    int[] createTable = X25519Field.createTable(8);
                    int[] create = X25519Field.create();
                    X25519Field.copy(pointExtArr2[0].f23959z, 0, create, 0);
                    X25519Field.copy(create, 0, createTable, 0);
                    int i18 = 0;
                    while (true) {
                        i18++;
                        if (i18 >= 8) {
                            break;
                        }
                        X25519Field.mul(create, pointExtArr2[i18].f23959z, create);
                        X25519Field.copy(create, 0, createTable, i18 * 10);
                    }
                    X25519Field.add(create, create, create);
                    X25519Field.invVar(create, create);
                    int i19 = i18 - 1;
                    int[] create2 = X25519Field.create();
                    while (i19 > 0) {
                        int i20 = i19 - 1;
                        X25519Field.copy(createTable, i20 * 10, create2, 0);
                        X25519Field.mul(create2, create, create2);
                        X25519Field.copy(create2, 0, createTable, i19 * 10);
                        X25519Field.mul(create, pointExtArr2[i19].f23959z, create);
                        i19 = i20;
                    }
                    X25519Field.copy(create, 0, createTable, 0);
                    for (int i21 = 0; i21 < 8; i21++) {
                        PointExt pointExt6 = pointExtArr2[i21];
                        int[] create3 = X25519Field.create();
                        int[] create4 = X25519Field.create();
                        X25519Field.copy(createTable, i21 * 10, create4, 0);
                        X25519Field.mul(pointExt6.f23957x, create4, create3);
                        X25519Field.mul(pointExt6.f23958y, create4, create4);
                        PointPrecomp pointPrecomp = new PointPrecomp();
                        X25519Field.apm(create4, create3, pointPrecomp.ypx_h, pointPrecomp.ymx_h);
                        X25519Field.mul(create3, create4, pointPrecomp.xyd);
                        int[] iArr3 = pointPrecomp.xyd;
                        X25519Field.mul(iArr3, C_d4, iArr3);
                        X25519Field.normalize(pointPrecomp.ypx_h);
                        X25519Field.normalize(pointPrecomp.ymx_h);
                        X25519Field.copy(pointPrecomp.ypx_h, 0, precompBase, i11);
                        int i22 = i11 + 10;
                        X25519Field.copy(pointPrecomp.ymx_h, 0, precompBase, i22);
                        int i23 = i22 + 10;
                        X25519Field.copy(pointPrecomp.xyd, 0, precompBase, i23);
                        i11 = i23 + 10;
                    }
                }
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i10, byte[] bArr2) {
        System.arraycopy(bArr, i10, bArr2, 0, 32);
        bArr2[0] = (byte) (bArr2[0] & 248);
        byte b10 = (byte) (bArr2[31] & Byte.MAX_VALUE);
        bArr2[31] = b10;
        bArr2[31] = (byte) (b10 | 64);
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
        long decode325 = ((long) decode32(bArr2, 49)) & 4294967295L;
        long decode245 = ((long) (decode24(bArr2, 53) << 4)) & 4294967295L;
        long decode326 = ((long) decode32(bArr2, 56)) & 4294967295L;
        long decode246 = ((long) (decode24(bArr2, 60) << 4)) & 4294967295L;
        long j10 = ((long) bArr2[63]) & M08L;
        long decode247 = (((long) (decode24(bArr2, 46) << 4)) & 4294967295L) - (j10 * 5343);
        long j11 = decode246 + (decode326 >> 28);
        long j12 = decode326 & M28L;
        long j13 = decode324 - (j11 * -50998291);
        long decode248 = ((((long) (decode24(bArr2, 32) << 4)) & 4294967295L) - (j10 * -50998291)) - (j11 * 19280294);
        long decode327 = ((((long) decode32(bArr2, 35)) & 4294967295L) - (j10 * 19280294)) - (j11 * 127719000);
        long decode328 = ((((long) decode32(bArr2, 42)) & 4294967295L) - (j10 * -6428113)) - (j11 * 5343);
        long j14 = decode244 - (j12 * -50998291);
        long decode249 = (((((long) (decode24(bArr2, 39) << 4)) & 4294967295L) - (j10 * 127719000)) - (j11 * -6428113)) - (j12 * 5343);
        long j15 = decode245 + (decode325 >> 28);
        long j16 = decode325 & M28L;
        long j17 = (decode327 - (j12 * -6428113)) - (j15 * 5343);
        long j18 = ((decode248 - (j12 * 127719000)) - (j15 * -6428113)) - (j16 * 5343);
        long j19 = decode247 + (decode328 >> 28);
        long j20 = (decode328 & M28L) + (decode249 >> 28);
        long j21 = decode242 - (j20 * -50998291);
        long j22 = (decode322 - (j19 * -50998291)) - (j20 * 19280294);
        long j23 = ((decode243 - (j16 * -50998291)) - (j19 * 19280294)) - (j20 * 127719000);
        long j24 = (((j14 - (j15 * 19280294)) - (j16 * 127719000)) - (j19 * -6428113)) - (j20 * 5343);
        long j25 = (decode249 & M28L) + (j17 >> 28);
        long j26 = j17 & M28L;
        long j27 = decode32 - (j25 * -50998291);
        long j28 = j21 - (j25 * 19280294);
        long j29 = j22 - (j25 * 127719000);
        long j30 = ((((decode323 - (j15 * -50998291)) - (j16 * 19280294)) - (j19 * 127719000)) - (j20 * -6428113)) - (j25 * 5343);
        long j31 = j26 + (j18 >> 28);
        long j32 = j18 & M28L;
        long j33 = j27 - (j31 * 19280294);
        long j34 = j28 - (j31 * 127719000);
        long j35 = j29 - (j31 * -6428113);
        long j36 = (j23 - (j25 * -6428113)) - (j31 * 5343);
        long j37 = ((((j13 - (j12 * 19280294)) - (j15 * 127719000)) - (j16 * -6428113)) - (j19 * 5343)) + (j24 >> 28);
        long j38 = j24 & M28L;
        long j39 = j37 & M28L;
        long j40 = j39 >>> 27;
        long j41 = j32 + (j37 >> 28) + j40;
        long decode329 = (((long) decode32(bArr2, 0)) & 4294967295L) - (j41 * -50998291);
        long j42 = ((decode24 - (j31 * -50998291)) - (j41 * 19280294)) + (decode329 >> 28);
        long j43 = decode329 & M28L;
        long j44 = (j33 - (j41 * 127719000)) + (j42 >> 28);
        long j45 = j42 & M28L;
        long j46 = (j34 - (j41 * -6428113)) + (j44 >> 28);
        long j47 = j44 & M28L;
        long j48 = (j35 - (j41 * 5343)) + (j46 >> 28);
        long j49 = j46 & M28L;
        long j50 = j36 + (j48 >> 28);
        long j51 = j48 & M28L;
        long j52 = j30 + (j50 >> 28);
        long j53 = j50 & M28L;
        long j54 = j38 + (j52 >> 28);
        long j55 = j52 & M28L;
        long j56 = j39 + (j54 >> 28);
        long j57 = j54 & M28L;
        long j58 = j56 >> 28;
        long j59 = j56 & M28L;
        long j60 = j58 - j40;
        long j61 = j43 + (j60 & -50998291);
        long j62 = j45 + (j60 & 19280294) + (j61 >> 28);
        long j63 = j61 & M28L;
        long j64 = j47 + (j60 & 127719000) + (j62 >> 28);
        long j65 = j62 & M28L;
        long j66 = j49 + (j60 & -6428113) + (j64 >> 28);
        long j67 = j64 & M28L;
        long j68 = j51 + (j60 & 5343) + (j66 >> 28);
        long j69 = j66 & M28L;
        long j70 = j53 + (j68 >> 28);
        long j71 = j68 & M28L;
        long j72 = j55 + (j70 >> 28);
        long j73 = j70 & M28L;
        long j74 = j57 + (j72 >> 28);
        long j75 = j72 & M28L;
        long j76 = j74 & M28L;
        byte[] bArr3 = new byte[32];
        encode56(j63 | (j65 << 28), bArr3, 0);
        encode56((j69 << 28) | j67, bArr3, 7);
        encode56(j71 | (j73 << 28), bArr3, 14);
        encode56(j75 | (j76 << 28), bArr3, 21);
        encode32((int) (j59 + (j74 >> 28)), bArr3, 28);
        return bArr3;
    }

    private static void scalarMult(byte[] bArr, PointAffine pointAffine, PointAccum pointAccum) {
        int[] iArr = new int[8];
        decodeScalar(bArr, 0, iArr);
        Nat.shiftDownBits(8, iArr, 3, 1);
        Nat.cadd(8, (~iArr[0]) & 1, iArr, L, iArr);
        Nat.shiftDownBit(8, iArr, 0);
        int[] pointPrecompute = pointPrecompute(pointAffine, 8);
        PointExt pointExt = new PointExt();
        pointCopy(pointAffine, pointAccum);
        pointLookup(pointPrecompute, 7, pointExt);
        pointAdd(pointExt, pointAccum);
        int i10 = 62;
        while (true) {
            pointLookup(iArr, i10, pointPrecompute, pointExt);
            pointAdd(pointExt, pointAccum);
            pointDouble(pointAccum);
            pointDouble(pointAccum);
            pointDouble(pointAccum);
            i10--;
            if (i10 >= 0) {
                pointDouble(pointAccum);
            } else {
                return;
            }
        }
    }

    private static void scalarMultBase(byte[] bArr, PointAccum pointAccum) {
        precompute();
        int[] iArr = new int[8];
        decodeScalar(bArr, 0, iArr);
        Nat.cadd(8, (~iArr[0]) & 1, iArr, L, iArr);
        Nat.shiftDownBit(8, iArr, 1);
        for (int i10 = 0; i10 < 8; i10++) {
            iArr[i10] = Interleave.shuffle2(iArr[i10]);
        }
        PointPrecomp pointPrecomp = new PointPrecomp();
        pointSetNeutral(pointAccum);
        int i11 = 28;
        while (true) {
            for (int i12 = 0; i12 < 8; i12++) {
                int i13 = iArr[i12] >>> i11;
                int i14 = (i13 >>> 3) & 1;
                pointLookup(i12, (i13 ^ (-i14)) & 7, pointPrecomp);
                X25519Field.cswap(i14, pointPrecomp.ypx_h, pointPrecomp.ymx_h);
                X25519Field.cnegate(i14, pointPrecomp.xyd);
                pointAddPrecomp(pointPrecomp, pointAccum);
            }
            i11 -= 4;
            if (i11 >= 0) {
                pointDouble(pointAccum);
            } else {
                return;
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i10) {
        PointAccum pointAccum = new PointAccum();
        scalarMultBase(bArr, pointAccum);
        if (encodePoint(pointAccum, bArr2, i10) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseYZ(X25519.Friend friend, byte[] bArr, int i10, int[] iArr, int[] iArr2) {
        if (friend != null) {
            byte[] bArr2 = new byte[32];
            pruneScalar(bArr, i10, bArr2);
            PointAccum pointAccum = new PointAccum();
            scalarMultBase(bArr2, pointAccum);
            if (checkPoint(pointAccum.f23951x, pointAccum.f23952y, pointAccum.f23953z) != 0) {
                X25519Field.copy(pointAccum.f23952y, 0, iArr, 0);
                X25519Field.copy(pointAccum.f23953z, 0, iArr2, 0);
                return;
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("This method is only for use by X25519");
    }

    private static void scalarMultOrderVar(PointAffine pointAffine, PointAccum pointAccum) {
        byte[] wnafVar = getWnafVar(L, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointCopy(pointAffine), 8);
        pointSetNeutral(pointAccum);
        int i10 = 252;
        while (true) {
            byte b10 = wnafVar[i10];
            if (b10 != 0) {
                int i11 = b10 >> 31;
                boolean z10 = true;
                int i12 = (b10 ^ i11) >>> 1;
                if (i11 == 0) {
                    z10 = false;
                }
                pointAddVar(z10, pointPrecomputeVar[i12], pointAccum);
            }
            i10--;
            if (i10 >= 0) {
                pointDouble(pointAccum);
            } else {
                return;
            }
        }
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointAffine pointAffine, PointAccum pointAccum) {
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointCopy(pointAffine), 8);
        pointSetNeutral(pointAccum);
        int i10 = 252;
        while (true) {
            byte b10 = wnafVar[i10];
            boolean z10 = false;
            if (b10 != 0) {
                int i11 = b10 >> 31;
                pointAddVar(i11 != 0, precompBaseTable[(b10 ^ i11) >>> 1], pointAccum);
            }
            byte b11 = wnafVar2[i10];
            if (b11 != 0) {
                int i12 = b11 >> 31;
                int i13 = (b11 ^ i12) >>> 1;
                if (i12 != 0) {
                    z10 = true;
                }
                pointAddVar(z10, pointPrecomputeVar[i13], pointAccum);
            }
            i10--;
            if (i10 >= 0) {
                pointDouble(pointAccum);
            } else {
                return;
            }
        }
    }

    public static void sign(byte[] bArr, int i10, byte[] bArr2, int i11, int i12, byte[] bArr3, int i13) {
        implSign(bArr, i10, (byte[]) null, (byte) 0, bArr2, i11, i12, bArr3, i13);
    }

    public static void sign(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12, int i13, byte[] bArr4, int i14) {
        implSign(bArr, i10, bArr2, i11, (byte[]) null, (byte) 0, bArr3, i12, i13, bArr4, i14);
    }

    public static void sign(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, int i13, byte[] bArr5, int i14) {
        implSign(bArr, i10, bArr2, i11, bArr3, (byte) 0, bArr4, i12, i13, bArr5, i14);
    }

    public static void sign(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, int i11, int i12, byte[] bArr4, int i13) {
        implSign(bArr, i10, bArr2, (byte) 0, bArr3, i11, i12, bArr4, i13);
    }

    public static void signPrehash(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, Digest digest, byte[] bArr4, int i12) {
        byte[] bArr5 = new byte[64];
        if (64 == digest.doFinal(bArr5, 0)) {
            implSign(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i12);
            return;
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static void signPrehash(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, byte[] bArr5, int i13) {
        implSign(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, i12, 64, bArr5, i13);
    }

    public static void signPrehash(byte[] bArr, int i10, byte[] bArr2, Digest digest, byte[] bArr3, int i11) {
        byte[] bArr4 = new byte[64];
        if (64 == digest.doFinal(bArr4, 0)) {
            implSign(bArr, i10, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i11);
            return;
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static void signPrehash(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, int i11, byte[] bArr4, int i12) {
        implSign(bArr, i10, bArr2, (byte) 1, bArr3, i11, 64, bArr4, i12);
    }

    public static boolean validatePublicKeyFull(byte[] bArr, int i10) {
        PointAffine pointAffine = new PointAffine();
        if (!decodePointVar(bArr, i10, false, pointAffine)) {
            return false;
        }
        X25519Field.normalize(pointAffine.f23954x);
        X25519Field.normalize(pointAffine.f23955y);
        if (isNeutralElementVar(pointAffine.f23954x, pointAffine.f23955y)) {
            return false;
        }
        PointAccum pointAccum = new PointAccum();
        scalarMultOrderVar(pointAffine, pointAccum);
        X25519Field.normalize(pointAccum.f23951x);
        X25519Field.normalize(pointAccum.f23952y);
        X25519Field.normalize(pointAccum.f23953z);
        return isNeutralElementVar(pointAccum.f23951x, pointAccum.f23952y, pointAccum.f23953z);
    }

    public static boolean validatePublicKeyPartial(byte[] bArr, int i10) {
        return decodePointVar(bArr, i10, false, new PointAffine());
    }

    public static boolean verify(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12, int i13) {
        return implVerify(bArr, i10, bArr2, i11, (byte[]) null, (byte) 0, bArr3, i12, i13);
    }

    public static boolean verify(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12, int i13) {
        return implVerify(bArr, i10, bArr2, i11, bArr3, (byte) 0, bArr4, i12, i13);
    }

    public static boolean verifyPrehash(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, Digest digest) {
        byte[] bArr4 = new byte[64];
        if (64 == digest.doFinal(bArr4, 0)) {
            return implVerify(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static boolean verifyPrehash(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4, int i12) {
        return implVerify(bArr, i10, bArr2, i11, bArr3, (byte) 1, bArr4, i12, 64);
    }
}
