package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA1Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 20;
    private static final int Y1 = 1518500249;
    private static final int Y2 = 1859775393;
    private static final int Y3 = -1894007588;
    private static final int Y4 = -899497514;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int[] X = new int[80];
    private int xOff;

    public SHA1Digest() {
        reset();
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super((GeneralDigest) sHA1Digest);
        copyIn(sHA1Digest);
    }

    public SHA1Digest(byte[] bArr) {
        super(bArr);
        this.H1 = Pack.bigEndianToInt(bArr, 16);
        this.H2 = Pack.bigEndianToInt(bArr, 20);
        this.H3 = Pack.bigEndianToInt(bArr, 24);
        this.H4 = Pack.bigEndianToInt(bArr, 28);
        this.H5 = Pack.bigEndianToInt(bArr, 32);
        this.xOff = Pack.bigEndianToInt(bArr, 36);
        for (int i10 = 0; i10 != this.xOff; i10++) {
            this.X[i10] = Pack.bigEndianToInt(bArr, (i10 * 4) + 40);
        }
    }

    private void copyIn(SHA1Digest sHA1Digest) {
        this.H1 = sHA1Digest.H1;
        this.H2 = sHA1Digest.H2;
        this.H3 = sHA1Digest.H3;
        this.H4 = sHA1Digest.H4;
        this.H5 = sHA1Digest.H5;
        int[] iArr = sHA1Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA1Digest.xOff;
    }

    private int f(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    private int g(int i10, int i11, int i12) {
        return (i10 & i12) | (i10 & i11) | (i11 & i12);
    }

    private int h(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    public Memoable copy() {
        return new SHA1Digest(this);
    }

    public int doFinal(byte[] bArr, int i10) {
        finish();
        Pack.intToBigEndian(this.H1, bArr, i10);
        Pack.intToBigEndian(this.H2, bArr, i10 + 4);
        Pack.intToBigEndian(this.H3, bArr, i10 + 8);
        Pack.intToBigEndian(this.H4, bArr, i10 + 12);
        Pack.intToBigEndian(this.H5, bArr, i10 + 16);
        reset();
        return 20;
    }

    public String getAlgorithmName() {
        return "SHA-1";
    }

    public int getDigestSize() {
        return 20;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[((this.xOff * 4) + 40)];
        super.populateState(bArr);
        Pack.intToBigEndian(this.H1, bArr, 16);
        Pack.intToBigEndian(this.H2, bArr, 20);
        Pack.intToBigEndian(this.H3, bArr, 24);
        Pack.intToBigEndian(this.H4, bArr, 28);
        Pack.intToBigEndian(this.H5, bArr, 32);
        Pack.intToBigEndian(this.xOff, bArr, 36);
        for (int i10 = 0; i10 != this.xOff; i10++) {
            Pack.intToBigEndian(this.X[i10], bArr, (i10 * 4) + 40);
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        for (int i10 = 16; i10 < 80; i10++) {
            int[] iArr = this.X;
            int i11 = ((iArr[i10 - 3] ^ iArr[i10 - 8]) ^ iArr[i10 - 14]) ^ iArr[i10 - 16];
            iArr[i10] = (i11 >>> 31) | (i11 << 1);
        }
        int i12 = this.H1;
        int i13 = this.H2;
        int i14 = this.H3;
        int i15 = this.H4;
        int i16 = this.H5;
        int i17 = 0;
        int i18 = 0;
        while (i17 < 4) {
            int i19 = i18 + 1;
            int f10 = i16 + ((i12 << 5) | (i12 >>> 27)) + f(i13, i14, i15) + this.X[i18] + Y1;
            int i20 = (i13 >>> 2) | (i13 << 30);
            int i21 = i19 + 1;
            int f11 = i15 + ((f10 << 5) | (f10 >>> 27)) + f(i12, i20, i14) + this.X[i19] + Y1;
            int i22 = (i12 >>> 2) | (i12 << 30);
            int i23 = i21 + 1;
            int f12 = i14 + ((f11 << 5) | (f11 >>> 27)) + f(f10, i22, i20) + this.X[i21] + Y1;
            i16 = (f10 >>> 2) | (f10 << 30);
            int i24 = i23 + 1;
            i13 = i20 + ((f12 << 5) | (f12 >>> 27)) + f(f11, i16, i22) + this.X[i23] + Y1;
            i15 = (f11 >>> 2) | (f11 << 30);
            i12 = i22 + ((i13 << 5) | (i13 >>> 27)) + f(f12, i15, i16) + this.X[i24] + Y1;
            i14 = (f12 >>> 2) | (f12 << 30);
            i17++;
            i18 = i24 + 1;
        }
        int i25 = 0;
        while (i25 < 4) {
            int i26 = i18 + 1;
            int h10 = i16 + ((i12 << 5) | (i12 >>> 27)) + h(i13, i14, i15) + this.X[i18] + Y2;
            int i27 = (i13 >>> 2) | (i13 << 30);
            int i28 = i26 + 1;
            int h11 = i15 + ((h10 << 5) | (h10 >>> 27)) + h(i12, i27, i14) + this.X[i26] + Y2;
            int i29 = (i12 >>> 2) | (i12 << 30);
            int i30 = i28 + 1;
            int h12 = i14 + ((h11 << 5) | (h11 >>> 27)) + h(h10, i29, i27) + this.X[i28] + Y2;
            i16 = (h10 >>> 2) | (h10 << 30);
            int i31 = i30 + 1;
            i13 = i27 + ((h12 << 5) | (h12 >>> 27)) + h(h11, i16, i29) + this.X[i30] + Y2;
            i15 = (h11 >>> 2) | (h11 << 30);
            i12 = i29 + ((i13 << 5) | (i13 >>> 27)) + h(h12, i15, i16) + this.X[i31] + Y2;
            i14 = (h12 >>> 2) | (h12 << 30);
            i25++;
            i18 = i31 + 1;
        }
        int i32 = 0;
        while (i32 < 4) {
            int i33 = i18 + 1;
            int g10 = i16 + ((i12 << 5) | (i12 >>> 27)) + g(i13, i14, i15) + this.X[i18] + Y3;
            int i34 = (i13 >>> 2) | (i13 << 30);
            int i35 = i33 + 1;
            int g11 = i15 + ((g10 << 5) | (g10 >>> 27)) + g(i12, i34, i14) + this.X[i33] + Y3;
            int i36 = (i12 >>> 2) | (i12 << 30);
            int i37 = i35 + 1;
            int g12 = i14 + ((g11 << 5) | (g11 >>> 27)) + g(g10, i36, i34) + this.X[i35] + Y3;
            i16 = (g10 >>> 2) | (g10 << 30);
            int i38 = i37 + 1;
            i13 = i34 + ((g12 << 5) | (g12 >>> 27)) + g(g11, i16, i36) + this.X[i37] + Y3;
            i15 = (g11 >>> 2) | (g11 << 30);
            i12 = i36 + ((i13 << 5) | (i13 >>> 27)) + g(g12, i15, i16) + this.X[i38] + Y3;
            i14 = (g12 >>> 2) | (g12 << 30);
            i32++;
            i18 = i38 + 1;
        }
        int i39 = 0;
        while (i39 <= 3) {
            int i40 = i18 + 1;
            int h13 = i16 + ((i12 << 5) | (i12 >>> 27)) + h(i13, i14, i15) + this.X[i18] + Y4;
            int i41 = (i13 >>> 2) | (i13 << 30);
            int i42 = i40 + 1;
            int h14 = i15 + ((h13 << 5) | (h13 >>> 27)) + h(i12, i41, i14) + this.X[i40] + Y4;
            int i43 = (i12 >>> 2) | (i12 << 30);
            int i44 = i42 + 1;
            int h15 = i14 + ((h14 << 5) | (h14 >>> 27)) + h(h13, i43, i41) + this.X[i42] + Y4;
            i16 = (h13 >>> 2) | (h13 << 30);
            int i45 = i44 + 1;
            i13 = i41 + ((h15 << 5) | (h15 >>> 27)) + h(h14, i16, i43) + this.X[i44] + Y4;
            i15 = (h14 >>> 2) | (h14 << 30);
            i12 = i43 + ((i13 << 5) | (i13 >>> 27)) + h(h15, i15, i16) + this.X[i45] + Y4;
            i14 = (h15 >>> 2) | (h15 << 30);
            i39++;
            i18 = i45 + 1;
        }
        this.H1 += i12;
        this.H2 += i13;
        this.H3 += i14;
        this.H4 += i15;
        this.H5 += i16;
        this.xOff = 0;
        for (int i46 = 0; i46 < 16; i46++) {
            this.X[i46] = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j10) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (j10 >>> 32);
        iArr[15] = (int) j10;
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = (bArr[i12 + 1] & 255) | (bArr[i10] << 24) | ((bArr[i11] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[i12] & 255) << 8);
        int[] iArr = this.X;
        int i14 = this.xOff;
        iArr[i14] = i13;
        int i15 = i14 + 1;
        this.xOff = i15;
        if (i15 == 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
        this.H5 = -1009589776;
        this.xOff = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.X;
            if (i10 != iArr.length) {
                iArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        super.copyIn(sHA1Digest);
        copyIn(sHA1Digest);
    }
}
