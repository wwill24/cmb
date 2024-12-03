package org.bouncycastle.pqc.math.linearalgebra;

import com.facebook.appevents.AppEventsConstants;
import java.math.BigInteger;
import java.security.SecureRandom;
import net.bytebuddy.asm.Advice;
import org.bouncycastle.util.Arrays;
import org.jivesoftware.smack.datatypes.UInt32;

public class GF2nONBElement extends GF2nElement {
    private static final int MAXLONG = 64;
    private static final long[] mBitmask = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, 4503599627370496L, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L, 2305843009213693952L, 4611686018427387904L, Long.MIN_VALUE};
    private static final int[] mIBY64 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    private static final long[] mMaxmask = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, 2147483647L, UInt32.MAX_VALUE_LONG, 8589934591L, 17179869183L, 34359738367L, 68719476735L, 137438953471L, 274877906943L, 549755813887L, 1099511627775L, 2199023255551L, 4398046511103L, 8796093022207L, 17592186044415L, 35184372088831L, 70368744177663L, 140737488355327L, 281474976710655L, 562949953421311L, 1125899906842623L, 2251799813685247L, 4503599627370495L, 9007199254740991L, 18014398509481983L, 36028797018963967L, 72057594037927935L, 144115188075855871L, 288230376151711743L, 576460752303423487L, 1152921504606846975L, 2305843009213693951L, 4611686018427387903L, Long.MAX_VALUE, -1};
    private int mBit;
    private int mLength;
    private long[] mPol;

    public GF2nONBElement(GF2nONBElement gF2nONBElement) {
        GF2nField gF2nField = gF2nONBElement.mField;
        this.mField = gF2nField;
        this.mDegree = gF2nField.getDegree();
        this.mLength = ((GF2nONBField) this.mField).getONBLength();
        this.mBit = ((GF2nONBField) this.mField).getONBBit();
        this.mPol = new long[this.mLength];
        assign(gF2nONBElement.getElement());
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, BigInteger bigInteger) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = new long[this.mLength];
        assign(bigInteger);
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, SecureRandom secureRandom) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        int i10 = this.mLength;
        long[] jArr = new long[i10];
        this.mPol = jArr;
        if (i10 > 1) {
            for (int i11 = 0; i11 < this.mLength - 1; i11++) {
                this.mPol[i11] = secureRandom.nextLong();
            }
            this.mPol[this.mLength - 1] = secureRandom.nextLong() >>> (64 - this.mBit);
            return;
        }
        jArr[0] = secureRandom.nextLong();
        long[] jArr2 = this.mPol;
        jArr2[0] = jArr2[0] >>> (64 - this.mBit);
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, byte[] bArr) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = new long[this.mLength];
        assign(bArr);
    }

    private GF2nONBElement(GF2nONBField gF2nONBField, long[] jArr) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = jArr;
    }

    public static GF2nONBElement ONE(GF2nONBField gF2nONBField) {
        int oNBLength = gF2nONBField.getONBLength();
        long[] jArr = new long[oNBLength];
        int i10 = 0;
        while (true) {
            int i11 = oNBLength - 1;
            if (i10 < i11) {
                jArr[i10] = -1;
                i10++;
            } else {
                jArr[i11] = mMaxmask[gF2nONBField.getONBBit() - 1];
                return new GF2nONBElement(gF2nONBField, jArr);
            }
        }
    }

    public static GF2nONBElement ZERO(GF2nONBField gF2nONBField) {
        return new GF2nONBElement(gF2nONBField, new long[gF2nONBField.getONBLength()]);
    }

    private void assign(BigInteger bigInteger) {
        assign(bigInteger.toByteArray());
    }

    private void assign(byte[] bArr) {
        this.mPol = new long[this.mLength];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            long[] jArr = this.mPol;
            int i11 = i10 >>> 3;
            jArr[i11] = jArr[i11] | ((((long) bArr[(bArr.length - 1) - i10]) & 255) << ((i10 & 7) << 3));
        }
    }

    private void assign(long[] jArr) {
        System.arraycopy(jArr, 0, this.mPol, 0, this.mLength);
    }

    private long[] getElement() {
        long[] jArr = this.mPol;
        long[] jArr2 = new long[jArr.length];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        return jArr2;
    }

    private long[] getElementReverseOrder() {
        long[] jArr = new long[this.mPol.length];
        int i10 = 0;
        while (true) {
            int i11 = this.mDegree;
            if (i10 >= i11) {
                return jArr;
            }
            if (testBit((i11 - i10) - 1)) {
                int i12 = i10 >>> 6;
                jArr[i12] = jArr[i12] | mBitmask[i10 & 63];
            }
            i10++;
        }
    }

    public GFElement add(GFElement gFElement) throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.addToThis(gFElement);
        return gF2nONBElement;
    }

    public void addToThis(GFElement gFElement) throws RuntimeException {
        if (gFElement instanceof GF2nONBElement) {
            GF2nONBElement gF2nONBElement = (GF2nONBElement) gFElement;
            if (this.mField.equals(gF2nONBElement.mField)) {
                for (int i10 = 0; i10 < this.mLength; i10++) {
                    long[] jArr = this.mPol;
                    jArr[i10] = jArr[i10] ^ gF2nONBElement.mPol[i10];
                }
                return;
            }
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }

    /* access modifiers changed from: package-private */
    public void assignOne() {
        int i10 = 0;
        while (true) {
            int i11 = this.mLength;
            if (i10 < i11 - 1) {
                this.mPol[i10] = -1;
                i10++;
            } else {
                this.mPol[i11 - 1] = mMaxmask[this.mBit - 1];
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void assignZero() {
        this.mPol = new long[this.mLength];
    }

    public Object clone() {
        return new GF2nONBElement(this);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nONBElement)) {
            return false;
        }
        GF2nONBElement gF2nONBElement = (GF2nONBElement) obj;
        for (int i10 = 0; i10 < this.mLength; i10++) {
            if (this.mPol[i10] != gF2nONBElement.mPol[i10]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mPol);
    }

    public GF2nElement increase() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.increaseThis();
        return gF2nONBElement;
    }

    public void increaseThis() {
        addToThis(ONE((GF2nONBField) this.mField));
    }

    public GFElement invert() throws ArithmeticException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.invertThis();
        return gF2nONBElement;
    }

    public void invertThis() throws ArithmeticException {
        if (!isZero()) {
            int i10 = 31;
            boolean z10 = false;
            while (!z10 && i10 >= 0) {
                if ((((long) (this.mDegree - 1)) & mBitmask[i10]) != 0) {
                    z10 = true;
                }
                i10--;
            }
            ZERO((GF2nONBField) this.mField);
            GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
            int i11 = 1;
            for (int i12 = (i10 + 1) - 1; i12 >= 0; i12--) {
                GF2nElement gF2nElement = (GF2nElement) gF2nONBElement.clone();
                for (int i13 = 1; i13 <= i11; i13++) {
                    gF2nElement.squareThis();
                }
                gF2nONBElement.multiplyThisBy(gF2nElement);
                i11 <<= 1;
                if ((((long) (this.mDegree - 1)) & mBitmask[i12]) != 0) {
                    gF2nONBElement.squareThis();
                    gF2nONBElement.multiplyThisBy(this);
                    i11++;
                }
            }
            gF2nONBElement.squareThis();
            return;
        }
        throw new ArithmeticException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isOne() {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            r2 = r0
            r3 = r1
        L_0x0004:
            int r4 = r8.mLength
            int r5 = r4 + -1
            if (r2 >= r5) goto L_0x0020
            if (r3 == 0) goto L_0x0020
            if (r3 == 0) goto L_0x001c
            long[] r3 = r8.mPol
            r4 = r3[r2]
            r6 = -1
            long r3 = r4 & r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x001c
            r3 = r1
            goto L_0x001d
        L_0x001c:
            r3 = r0
        L_0x001d:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0020:
            if (r3 == 0) goto L_0x003b
            if (r3 == 0) goto L_0x003a
            long[] r2 = r8.mPol
            int r4 = r4 - r1
            r3 = r2[r4]
            long[] r2 = mMaxmask
            int r5 = r8.mBit
            int r6 = r5 + -1
            r6 = r2[r6]
            long r3 = r3 & r6
            int r5 = r5 - r1
            r5 = r2[r5]
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x003a
            r0 = r1
        L_0x003a:
            r3 = r0
        L_0x003b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.math.linearalgebra.GF2nONBElement.isOne():boolean");
    }

    public boolean isZero() {
        boolean z10 = true;
        for (int i10 = 0; i10 < this.mLength && z10; i10++) {
            z10 = z10 && (this.mPol[i10] & -1) == 0;
        }
        return z10;
    }

    public GFElement multiply(GFElement gFElement) throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.multiplyThisBy(gFElement);
        return gF2nONBElement;
    }

    public void multiplyThisBy(GFElement gFElement) throws RuntimeException {
        boolean z10;
        int i10;
        boolean z11;
        boolean z12;
        boolean z13;
        GFElement gFElement2 = gFElement;
        if (gFElement2 instanceof GF2nONBElement) {
            GF2nONBElement gF2nONBElement = (GF2nONBElement) gFElement2;
            if (!this.mField.equals(gF2nONBElement.mField)) {
                throw new RuntimeException();
            } else if (equals(gFElement)) {
                squareThis();
            } else {
                long[] jArr = this.mPol;
                long[] jArr2 = gF2nONBElement.mPol;
                int i11 = this.mLength;
                long[] jArr3 = new long[i11];
                int[][] iArr = ((GF2nONBField) this.mField).mMult;
                int i12 = i11 - 1;
                long[] jArr4 = mBitmask;
                long j10 = jArr4[63];
                long j11 = jArr4[this.mBit - 1];
                int i13 = 0;
                int i14 = 0;
                while (i14 < this.mDegree) {
                    int i15 = i13;
                    int i16 = i15;
                    while (i15 < this.mDegree) {
                        int[] iArr2 = mIBY64;
                        int i17 = iArr2[i15];
                        int[] iArr3 = iArr[i15];
                        int i18 = iArr3[i13];
                        int i19 = iArr2[i18];
                        int i20 = i18 & 63;
                        long j12 = jArr[i17];
                        long[] jArr5 = mBitmask;
                        if ((j12 & jArr5[i15 & 63]) != 0) {
                            if ((jArr2[i19] & jArr5[i20]) != 0) {
                                i16 ^= 1;
                            }
                            int i21 = iArr3[1];
                            if (i21 != -1) {
                                if ((jArr2[iArr2[i21]] & jArr5[i21 & 63]) != 0) {
                                    i16 ^= 1;
                                }
                            }
                        }
                        i15++;
                        i13 = 0;
                    }
                    int i22 = mIBY64[i14];
                    int i23 = i14 & 63;
                    if (i16 != 0) {
                        jArr3[i22] = jArr3[i22] ^ mBitmask[i23];
                    }
                    if (this.mLength > 1) {
                        boolean z14 = (jArr[i12] & 1) == 1;
                        int i24 = i12 - 1;
                        int i25 = i24;
                        while (i25 >= 0) {
                            long j13 = jArr[i25];
                            boolean z15 = (j13 & 1) != 0;
                            long j14 = j13 >>> 1;
                            jArr[i25] = j14;
                            if (z14) {
                                jArr[i25] = j14 ^ j10;
                            }
                            i25--;
                            z14 = z15;
                        }
                        long j15 = jArr[i12] >>> 1;
                        jArr[i12] = j15;
                        if (z14) {
                            jArr[i12] = j15 ^ j11;
                        }
                        boolean z16 = (jArr2[i12] & 1) == 1;
                        while (i24 >= 0) {
                            long j16 = jArr2[i24];
                            boolean z17 = (j16 & 1) != 0;
                            long j17 = j16 >>> 1;
                            jArr2[i24] = j17;
                            if (z16) {
                                jArr2[i24] = j17 ^ j10;
                            }
                            i24--;
                            z16 = z17;
                        }
                        long j18 = jArr2[i12] >>> 1;
                        jArr2[i12] = j18;
                        if (z16) {
                            jArr2[i12] = j18 ^ j11;
                        }
                        i10 = 0;
                        z10 = true;
                    } else {
                        i10 = 0;
                        long j19 = jArr[0];
                        if ((j19 & 1) == 1) {
                            z12 = true;
                            z11 = true;
                        } else {
                            z11 = false;
                            z12 = true;
                        }
                        long j20 = j19 >>> (z12 ? 1 : 0);
                        jArr[0] = j20;
                        if (z11) {
                            jArr[0] = j20 ^ j11;
                        }
                        long j21 = jArr2[0];
                        if ((j21 & 1) == 1) {
                            z10 = true;
                            z13 = true;
                        } else {
                            z13 = false;
                            z10 = true;
                        }
                        long j22 = j21 >>> (z10 ? 1 : 0);
                        jArr2[0] = j22;
                        if (z13) {
                            jArr2[0] = j22 ^ j11;
                        }
                    }
                    i14++;
                    i13 = i10;
                    boolean z18 = z10;
                }
                assign(jArr3);
            }
        } else {
            throw new RuntimeException("The elements have different representation: not yet implemented");
        }
    }

    /* access modifiers changed from: package-private */
    public void reverseOrder() {
        this.mPol = getElementReverseOrder();
    }

    public GF2nElement solveQuadraticEquation() throws RuntimeException {
        int i10;
        int i11 = 1;
        if (trace() != 1) {
            long j10 = mBitmask[63];
            long[] jArr = new long[this.mLength];
            int i12 = 0;
            long j11 = 0;
            while (true) {
                i10 = this.mLength;
                if (i12 >= i10 - 1) {
                    break;
                }
                for (int i13 = i11; i13 < 64; i13++) {
                    long[] jArr2 = mBitmask;
                    long j12 = jArr2[i13];
                    long j13 = this.mPol[i12];
                    if (((j12 & j13) == 0 || (j11 & jArr2[i13 - 1]) == 0) && !((j13 & j12) == 0 && (j11 & jArr2[i13 - 1]) == 0)) {
                        j11 ^= j12;
                    }
                }
                jArr[i12] = j11;
                int i14 = ((j11 & j10) > 0 ? 1 : ((j11 & j10) == 0 ? 0 : -1));
                j11 = ((i14 == 0 || (1 & this.mPol[i12 + 1]) != 1) && !(i14 == 0 && (this.mPol[i12 + 1] & 1) == 0)) ? 1 : 0;
                i12++;
                i11 = 1;
            }
            int i15 = this.mDegree & 63;
            long j14 = this.mPol[i10 - 1];
            for (int i16 = 1; i16 < i15; i16++) {
                long[] jArr3 = mBitmask;
                long j15 = jArr3[i16];
                if (((j15 & j14) == 0 || (jArr3[i16 - 1] & j11) == 0) && !((j15 & j14) == 0 && (jArr3[i16 - 1] & j11) == 0)) {
                    j11 ^= j15;
                }
            }
            jArr[this.mLength - 1] = j11;
            return new GF2nONBElement((GF2nONBField) this.mField, jArr);
        }
        throw new RuntimeException();
    }

    public GF2nElement square() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.squareThis();
        return gF2nONBElement;
    }

    public GF2nElement squareRoot() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.squareRootThis();
        return gF2nONBElement;
    }

    public void squareRootThis() {
        long[] element = getElement();
        int i10 = this.mLength - 1;
        int i11 = this.mBit - 1;
        long j10 = mBitmask[63];
        boolean z10 = (element[0] & 1) != 0;
        int i12 = i10;
        while (i12 >= 0) {
            long j11 = element[i12];
            boolean z11 = (j11 & 1) != 0;
            long j12 = j11 >>> 1;
            element[i12] = j12;
            if (z10) {
                if (i12 == i10) {
                    element[i12] = j12 ^ mBitmask[i11];
                } else {
                    element[i12] = j12 ^ j10;
                }
            }
            i12--;
            z10 = z11;
        }
        assign(element);
    }

    public void squareThis() {
        long[] element = getElement();
        int i10 = this.mLength - 1;
        int i11 = this.mBit - 1;
        long[] jArr = mBitmask;
        long j10 = jArr[63];
        boolean z10 = false;
        boolean z11 = (element[i10] & jArr[i11]) != 0;
        int i12 = 0;
        while (i12 < i10) {
            long j11 = element[i12];
            boolean z12 = (j11 & j10) != 0;
            long j12 = j11 << 1;
            element[i12] = j12;
            if (z11) {
                element[i12] = 1 ^ j12;
            }
            i12++;
            z11 = z12;
        }
        long j13 = element[i10];
        long[] jArr2 = mBitmask;
        if ((jArr2[i11] & j13) != 0) {
            z10 = true;
        }
        long j14 = j13 << 1;
        element[i10] = j14;
        if (z11) {
            element[i10] = j14 ^ 1;
        }
        if (z10) {
            element[i10] = jArr2[i11 + 1] ^ element[i10];
        }
        assign(element);
    }

    /* access modifiers changed from: package-private */
    public boolean testBit(int i10) {
        return i10 >= 0 && i10 <= this.mDegree && (this.mPol[i10 >>> 6] & mBitmask[i10 & 63]) != 0;
    }

    public boolean testRightmostBit() {
        return (this.mPol[this.mLength - 1] & mBitmask[this.mBit - 1]) != 0;
    }

    public byte[] toByteArray() {
        int i10 = ((this.mDegree - 1) >> 3) + 1;
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = (i11 & 7) << 3;
            bArr[(i10 - i11) - 1] = (byte) ((int) ((this.mPol[i11 >>> 3] & (255 << i12)) >>> i12));
        }
        return bArr;
    }

    public BigInteger toFlexiBigInt() {
        return new BigInteger(1, toByteArray());
    }

    public String toString() {
        return toString(16);
    }

    public String toString(int i10) {
        StringBuilder sb2;
        String str;
        long[] element = getElement();
        int i11 = this.mBit;
        String str2 = "";
        if (i10 == 2) {
            while (true) {
                i11--;
                if (i11 < 0) {
                    break;
                }
                if ((element[element.length - 1] & (1 << i11)) == 0) {
                    str = str2 + "0";
                } else {
                    str = str2 + AppEventsConstants.EVENT_PARAM_VALUE_YES;
                }
                str2 = str;
            }
            for (int length = element.length - 2; length >= 0; length--) {
                for (int i12 = 63; i12 >= 0; i12--) {
                    if ((element[length] & mBitmask[i12]) == 0) {
                        sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append("0");
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    }
                    str2 = sb2.toString();
                }
            }
        } else if (i10 == 16) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};
            for (int length2 = element.length - 1; length2 >= 0; length2--) {
                str2 = ((((((((((((((((str2 + cArr[((int) (element[length2] >>> 60)) & 15]) + cArr[((int) (element[length2] >>> 56)) & 15]) + cArr[((int) (element[length2] >>> 52)) & 15]) + cArr[((int) (element[length2] >>> 48)) & 15]) + cArr[((int) (element[length2] >>> 44)) & 15]) + cArr[((int) (element[length2] >>> 40)) & 15]) + cArr[((int) (element[length2] >>> 36)) & 15]) + cArr[((int) (element[length2] >>> 32)) & 15]) + cArr[((int) (element[length2] >>> 28)) & 15]) + cArr[((int) (element[length2] >>> 24)) & 15]) + cArr[((int) (element[length2] >>> 20)) & 15]) + cArr[((int) (element[length2] >>> 16)) & 15]) + cArr[((int) (element[length2] >>> 12)) & 15]) + cArr[((int) (element[length2] >>> 8)) & 15]) + cArr[((int) (element[length2] >>> 4)) & 15]) + cArr[((int) element[length2]) & 15]) + " ";
            }
        }
        return str2;
    }

    public int trace() {
        int i10 = this.mLength - 1;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            for (int i13 = 0; i13 < 64; i13++) {
                if ((this.mPol[i12] & mBitmask[i13]) != 0) {
                    i11 ^= 1;
                }
            }
        }
        int i14 = this.mBit;
        for (int i15 = 0; i15 < i14; i15++) {
            if ((this.mPol[i10] & mBitmask[i15]) != 0) {
                i11 ^= 1;
            }
        }
        return i11;
    }
}
