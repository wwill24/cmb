package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA256Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 32;
    static final int[] K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int H6;
    private int H7;
    private int H8;
    private int[] X = new int[64];
    private int xOff;

    public SHA256Digest() {
        reset();
    }

    public SHA256Digest(SHA256Digest sHA256Digest) {
        super((GeneralDigest) sHA256Digest);
        copyIn(sHA256Digest);
    }

    public SHA256Digest(byte[] bArr) {
        super(bArr);
        this.H1 = Pack.bigEndianToInt(bArr, 16);
        this.H2 = Pack.bigEndianToInt(bArr, 20);
        this.H3 = Pack.bigEndianToInt(bArr, 24);
        this.H4 = Pack.bigEndianToInt(bArr, 28);
        this.H5 = Pack.bigEndianToInt(bArr, 32);
        this.H6 = Pack.bigEndianToInt(bArr, 36);
        this.H7 = Pack.bigEndianToInt(bArr, 40);
        this.H8 = Pack.bigEndianToInt(bArr, 44);
        this.xOff = Pack.bigEndianToInt(bArr, 48);
        for (int i10 = 0; i10 != this.xOff; i10++) {
            this.X[i10] = Pack.bigEndianToInt(bArr, (i10 * 4) + 52);
        }
    }

    private static int Ch(int i10, int i11, int i12) {
        return ((~i10) & i12) ^ (i11 & i10);
    }

    private static int Maj(int i10, int i11, int i12) {
        return ((i10 ^ i11) & i12) | (i10 & i11);
    }

    private static int Sum0(int i10) {
        return ((i10 << 10) | (i10 >>> 22)) ^ (((i10 >>> 2) | (i10 << 30)) ^ ((i10 >>> 13) | (i10 << 19)));
    }

    private static int Sum1(int i10) {
        return ((i10 << 7) | (i10 >>> 25)) ^ (((i10 >>> 6) | (i10 << 26)) ^ ((i10 >>> 11) | (i10 << 21)));
    }

    private static int Theta0(int i10) {
        return (i10 >>> 3) ^ (((i10 >>> 7) | (i10 << 25)) ^ ((i10 >>> 18) | (i10 << 14)));
    }

    private static int Theta1(int i10) {
        return (i10 >>> 10) ^ (((i10 >>> 17) | (i10 << 15)) ^ ((i10 >>> 19) | (i10 << 13)));
    }

    private void copyIn(SHA256Digest sHA256Digest) {
        super.copyIn(sHA256Digest);
        this.H1 = sHA256Digest.H1;
        this.H2 = sHA256Digest.H2;
        this.H3 = sHA256Digest.H3;
        this.H4 = sHA256Digest.H4;
        this.H5 = sHA256Digest.H5;
        this.H6 = sHA256Digest.H6;
        this.H7 = sHA256Digest.H7;
        this.H8 = sHA256Digest.H8;
        int[] iArr = sHA256Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA256Digest.xOff;
    }

    public Memoable copy() {
        return new SHA256Digest(this);
    }

    public int doFinal(byte[] bArr, int i10) {
        finish();
        Pack.intToBigEndian(this.H1, bArr, i10);
        Pack.intToBigEndian(this.H2, bArr, i10 + 4);
        Pack.intToBigEndian(this.H3, bArr, i10 + 8);
        Pack.intToBigEndian(this.H4, bArr, i10 + 12);
        Pack.intToBigEndian(this.H5, bArr, i10 + 16);
        Pack.intToBigEndian(this.H6, bArr, i10 + 20);
        Pack.intToBigEndian(this.H7, bArr, i10 + 24);
        Pack.intToBigEndian(this.H8, bArr, i10 + 28);
        reset();
        return 32;
    }

    public String getAlgorithmName() {
        return "SHA-256";
    }

    public int getDigestSize() {
        return 32;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[((this.xOff * 4) + 52)];
        super.populateState(bArr);
        Pack.intToBigEndian(this.H1, bArr, 16);
        Pack.intToBigEndian(this.H2, bArr, 20);
        Pack.intToBigEndian(this.H3, bArr, 24);
        Pack.intToBigEndian(this.H4, bArr, 28);
        Pack.intToBigEndian(this.H5, bArr, 32);
        Pack.intToBigEndian(this.H6, bArr, 36);
        Pack.intToBigEndian(this.H7, bArr, 40);
        Pack.intToBigEndian(this.H8, bArr, 44);
        Pack.intToBigEndian(this.xOff, bArr, 48);
        for (int i10 = 0; i10 != this.xOff; i10++) {
            Pack.intToBigEndian(this.X[i10], bArr, (i10 * 4) + 52);
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        for (int i10 = 16; i10 <= 63; i10++) {
            int[] iArr = this.X;
            int Theta1 = Theta1(iArr[i10 - 2]);
            int[] iArr2 = this.X;
            iArr[i10] = Theta1 + iArr2[i10 - 7] + Theta0(iArr2[i10 - 15]) + this.X[i10 - 16];
        }
        int i11 = this.H1;
        int i12 = this.H2;
        int i13 = this.H3;
        int i14 = this.H4;
        int i15 = this.H5;
        int i16 = this.H6;
        int i17 = this.H7;
        int i18 = this.H8;
        int i19 = 0;
        for (int i20 = 0; i20 < 8; i20++) {
            int Sum1 = Sum1(i15) + Ch(i15, i16, i17);
            int[] iArr3 = K;
            int i21 = i18 + Sum1 + iArr3[i19] + this.X[i19];
            int i22 = i14 + i21;
            int Sum0 = i21 + Sum0(i11) + Maj(i11, i12, i13);
            int i23 = i19 + 1;
            int Sum12 = i17 + Sum1(i22) + Ch(i22, i15, i16) + iArr3[i23] + this.X[i23];
            int i24 = i13 + Sum12;
            int Sum02 = Sum12 + Sum0(Sum0) + Maj(Sum0, i11, i12);
            int i25 = i23 + 1;
            int Sum13 = i16 + Sum1(i24) + Ch(i24, i22, i15) + iArr3[i25] + this.X[i25];
            int i26 = i12 + Sum13;
            int Sum03 = Sum13 + Sum0(Sum02) + Maj(Sum02, Sum0, i11);
            int i27 = i25 + 1;
            int Sum14 = i15 + Sum1(i26) + Ch(i26, i24, i22) + iArr3[i27] + this.X[i27];
            int i28 = i11 + Sum14;
            int Sum04 = Sum14 + Sum0(Sum03) + Maj(Sum03, Sum02, Sum0);
            int i29 = i27 + 1;
            int Sum15 = i22 + Sum1(i28) + Ch(i28, i26, i24) + iArr3[i29] + this.X[i29];
            i18 = Sum0 + Sum15;
            i14 = Sum15 + Sum0(Sum04) + Maj(Sum04, Sum03, Sum02);
            int i30 = i29 + 1;
            int Sum16 = i24 + Sum1(i18) + Ch(i18, i28, i26) + iArr3[i30] + this.X[i30];
            i17 = Sum02 + Sum16;
            i13 = Sum16 + Sum0(i14) + Maj(i14, Sum04, Sum03);
            int i31 = i30 + 1;
            int Sum17 = i26 + Sum1(i17) + Ch(i17, i18, i28) + iArr3[i31] + this.X[i31];
            i16 = Sum03 + Sum17;
            i12 = Sum17 + Sum0(i13) + Maj(i13, i14, Sum04);
            int i32 = i31 + 1;
            int Sum18 = i28 + Sum1(i16) + Ch(i16, i17, i18) + iArr3[i32] + this.X[i32];
            i15 = Sum04 + Sum18;
            i11 = Sum18 + Sum0(i12) + Maj(i12, i13, i14);
            i19 = i32 + 1;
        }
        this.H1 += i11;
        this.H2 += i12;
        this.H3 += i13;
        this.H4 += i14;
        this.H5 += i15;
        this.H6 += i16;
        this.H7 += i17;
        this.H8 += i18;
        this.xOff = 0;
        for (int i33 = 0; i33 < 16; i33++) {
            this.X[i33] = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j10) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (j10 >>> 32);
        iArr[15] = (int) (j10 & -1);
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
        this.H1 = 1779033703;
        this.H2 = -1150833019;
        this.H3 = 1013904242;
        this.H4 = -1521486534;
        this.H5 = 1359893119;
        this.H6 = -1694144372;
        this.H7 = 528734635;
        this.H8 = 1541459225;
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
        copyIn((SHA256Digest) memoable);
    }
}
