package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;

public class RIPEMD256Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 32;
    private int H0;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int H6;
    private int H7;
    private int[] X = new int[16];
    private int xOff;

    public RIPEMD256Digest() {
        reset();
    }

    public RIPEMD256Digest(RIPEMD256Digest rIPEMD256Digest) {
        super((GeneralDigest) rIPEMD256Digest);
        copyIn(rIPEMD256Digest);
    }

    private int F1(int i10, int i11, int i12, int i13, int i14, int i15) {
        return RL(i10 + f1(i11, i12, i13) + i14, i15);
    }

    private int F2(int i10, int i11, int i12, int i13, int i14, int i15) {
        return RL(i10 + f2(i11, i12, i13) + i14 + 1518500249, i15);
    }

    private int F3(int i10, int i11, int i12, int i13, int i14, int i15) {
        return RL(i10 + f3(i11, i12, i13) + i14 + 1859775393, i15);
    }

    private int F4(int i10, int i11, int i12, int i13, int i14, int i15) {
        return RL(((i10 + f4(i11, i12, i13)) + i14) - 1894007588, i15);
    }

    private int FF1(int i10, int i11, int i12, int i13, int i14, int i15) {
        return RL(i10 + f1(i11, i12, i13) + i14, i15);
    }

    private int FF2(int i10, int i11, int i12, int i13, int i14, int i15) {
        return RL(i10 + f2(i11, i12, i13) + i14 + 1836072691, i15);
    }

    private int FF3(int i10, int i11, int i12, int i13, int i14, int i15) {
        return RL(i10 + f3(i11, i12, i13) + i14 + 1548603684, i15);
    }

    private int FF4(int i10, int i11, int i12, int i13, int i14, int i15) {
        return RL(i10 + f4(i11, i12, i13) + i14 + 1352829926, i15);
    }

    private int RL(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    private void copyIn(RIPEMD256Digest rIPEMD256Digest) {
        super.copyIn(rIPEMD256Digest);
        this.H0 = rIPEMD256Digest.H0;
        this.H1 = rIPEMD256Digest.H1;
        this.H2 = rIPEMD256Digest.H2;
        this.H3 = rIPEMD256Digest.H3;
        this.H4 = rIPEMD256Digest.H4;
        this.H5 = rIPEMD256Digest.H5;
        this.H6 = rIPEMD256Digest.H6;
        this.H7 = rIPEMD256Digest.H7;
        int[] iArr = rIPEMD256Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = rIPEMD256Digest.xOff;
    }

    private int f1(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    private int f2(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    private int f3(int i10, int i11, int i12) {
        return (i10 | (~i11)) ^ i12;
    }

    private int f4(int i10, int i11, int i12) {
        return (i10 & i12) | (i11 & (~i12));
    }

    private void unpackWord(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        bArr[i11 + 1] = (byte) (i10 >>> 8);
        bArr[i11 + 2] = (byte) (i10 >>> 16);
        bArr[i11 + 3] = (byte) (i10 >>> 24);
    }

    public Memoable copy() {
        return new RIPEMD256Digest(this);
    }

    public int doFinal(byte[] bArr, int i10) {
        finish();
        unpackWord(this.H0, bArr, i10);
        unpackWord(this.H1, bArr, i10 + 4);
        unpackWord(this.H2, bArr, i10 + 8);
        unpackWord(this.H3, bArr, i10 + 12);
        unpackWord(this.H4, bArr, i10 + 16);
        unpackWord(this.H5, bArr, i10 + 20);
        unpackWord(this.H6, bArr, i10 + 24);
        unpackWord(this.H7, bArr, i10 + 28);
        reset();
        return 32;
    }

    public String getAlgorithmName() {
        return "RIPEMD256";
    }

    public int getDigestSize() {
        return 32;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        int i10 = this.H0;
        int i11 = this.H1;
        int i12 = this.H2;
        int i13 = this.H3;
        int i14 = this.H4;
        int i15 = this.H5;
        int i16 = this.H6;
        int i17 = this.H7;
        int F1 = F1(i10, i11, i12, i13, this.X[0], 11);
        int F12 = F1(i13, F1, i11, i12, this.X[1], 14);
        int F13 = F1(i12, F12, F1, i11, this.X[2], 15);
        int F14 = F1(i11, F13, F12, F1, this.X[3], 12);
        int F15 = F1(F1, F14, F13, F12, this.X[4], 5);
        int F16 = F1(F12, F15, F14, F13, this.X[5], 8);
        int F17 = F1(F13, F16, F15, F14, this.X[6], 7);
        int F18 = F1(F14, F17, F16, F15, this.X[7], 9);
        int F19 = F1(F15, F18, F17, F16, this.X[8], 11);
        int F110 = F1(F16, F19, F18, F17, this.X[9], 13);
        int F111 = F1(F17, F110, F19, F18, this.X[10], 14);
        int F112 = F1(F18, F111, F110, F19, this.X[11], 15);
        int F113 = F1(F19, F112, F111, F110, this.X[12], 6);
        int F114 = F1(F110, F113, F112, F111, this.X[13], 7);
        int F115 = F1(F111, F114, F113, F112, this.X[14], 9);
        int F116 = F1(F112, F115, F114, F113, this.X[15], 8);
        int FF4 = FF4(i14, i15, i16, i17, this.X[5], 8);
        int FF42 = FF4(i17, FF4, i15, i16, this.X[14], 9);
        int FF43 = FF4(i16, FF42, FF4, i15, this.X[7], 9);
        int FF44 = FF4(i15, FF43, FF42, FF4, this.X[0], 11);
        int FF45 = FF4(FF4, FF44, FF43, FF42, this.X[9], 13);
        int FF46 = FF4(FF42, FF45, FF44, FF43, this.X[2], 15);
        int FF47 = FF4(FF43, FF46, FF45, FF44, this.X[11], 15);
        int FF48 = FF4(FF44, FF47, FF46, FF45, this.X[4], 5);
        int FF49 = FF4(FF45, FF48, FF47, FF46, this.X[13], 7);
        int FF410 = FF4(FF46, FF49, FF48, FF47, this.X[6], 7);
        int FF411 = FF4(FF47, FF410, FF49, FF48, this.X[15], 8);
        int FF412 = FF4(FF48, FF411, FF410, FF49, this.X[8], 11);
        int FF413 = FF4(FF49, FF412, FF411, FF410, this.X[1], 14);
        int FF414 = FF4(FF410, FF413, FF412, FF411, this.X[10], 14);
        int FF415 = FF4(FF411, FF414, FF413, FF412, this.X[3], 12);
        int FF416 = FF4(FF412, FF415, FF414, FF413, this.X[12], 6);
        int F2 = F2(FF413, F116, F115, F114, this.X[7], 7);
        int F22 = F2(F114, F2, F116, F115, this.X[4], 6);
        int F23 = F2(F115, F22, F2, F116, this.X[13], 8);
        int F24 = F2(F116, F23, F22, F2, this.X[1], 13);
        int F25 = F2(F2, F24, F23, F22, this.X[10], 11);
        int F26 = F2(F22, F25, F24, F23, this.X[6], 9);
        int F27 = F2(F23, F26, F25, F24, this.X[15], 7);
        int F28 = F2(F24, F27, F26, F25, this.X[3], 15);
        int F29 = F2(F25, F28, F27, F26, this.X[12], 7);
        int F210 = F2(F26, F29, F28, F27, this.X[0], 12);
        int F211 = F2(F27, F210, F29, F28, this.X[9], 15);
        int F212 = F2(F28, F211, F210, F29, this.X[5], 9);
        int F213 = F2(F29, F212, F211, F210, this.X[2], 11);
        int F214 = F2(F210, F213, F212, F211, this.X[14], 7);
        int F215 = F2(F211, F214, F213, F212, this.X[11], 13);
        int F216 = F2(F212, F215, F214, F213, this.X[8], 12);
        int FF3 = FF3(F113, FF416, FF415, FF414, this.X[6], 9);
        int FF32 = FF3(FF414, FF3, FF416, FF415, this.X[11], 13);
        int FF33 = FF3(FF415, FF32, FF3, FF416, this.X[3], 15);
        int FF34 = FF3(FF416, FF33, FF32, FF3, this.X[7], 7);
        int FF35 = FF3(FF3, FF34, FF33, FF32, this.X[0], 12);
        int FF36 = FF3(FF32, FF35, FF34, FF33, this.X[13], 8);
        int FF37 = FF3(FF33, FF36, FF35, FF34, this.X[5], 9);
        int FF38 = FF3(FF34, FF37, FF36, FF35, this.X[10], 11);
        int FF39 = FF3(FF35, FF38, FF37, FF36, this.X[14], 7);
        int FF310 = FF3(FF36, FF39, FF38, FF37, this.X[15], 7);
        int FF311 = FF3(FF37, FF310, FF39, FF38, this.X[8], 12);
        int FF312 = FF3(FF38, FF311, FF310, FF39, this.X[12], 7);
        int FF313 = FF3(FF39, FF312, FF311, FF310, this.X[4], 6);
        int FF314 = FF3(FF310, FF313, FF312, FF311, this.X[9], 15);
        int FF315 = FF3(FF311, FF314, FF313, FF312, this.X[1], 13);
        int FF316 = FF3(FF312, FF315, FF314, FF313, this.X[2], 11);
        int F3 = F3(F213, FF316, F215, F214, this.X[3], 11);
        int F32 = F3(F214, F3, FF316, F215, this.X[10], 13);
        int F33 = F3(F215, F32, F3, FF316, this.X[14], 6);
        int F34 = F3(FF316, F33, F32, F3, this.X[4], 7);
        int F35 = F3(F3, F34, F33, F32, this.X[9], 14);
        int F36 = F3(F32, F35, F34, F33, this.X[15], 9);
        int F37 = F3(F33, F36, F35, F34, this.X[8], 13);
        int F38 = F3(F34, F37, F36, F35, this.X[1], 15);
        int F39 = F3(F35, F38, F37, F36, this.X[2], 14);
        int F310 = F3(F36, F39, F38, F37, this.X[7], 8);
        int F311 = F3(F37, F310, F39, F38, this.X[0], 13);
        int F312 = F3(F38, F311, F310, F39, this.X[6], 6);
        int F313 = F3(F39, F312, F311, F310, this.X[13], 5);
        int F314 = F3(F310, F313, F312, F311, this.X[11], 12);
        int F315 = F3(F311, F314, F313, F312, this.X[5], 7);
        int F316 = F3(F312, F315, F314, F313, this.X[12], 5);
        int FF2 = FF2(FF313, F216, FF315, FF314, this.X[15], 9);
        int FF22 = FF2(FF314, FF2, F216, FF315, this.X[5], 7);
        int FF23 = FF2(FF315, FF22, FF2, F216, this.X[1], 15);
        int FF24 = FF2(F216, FF23, FF22, FF2, this.X[3], 11);
        int FF25 = FF2(FF2, FF24, FF23, FF22, this.X[7], 8);
        int FF26 = FF2(FF22, FF25, FF24, FF23, this.X[14], 6);
        int FF27 = FF2(FF23, FF26, FF25, FF24, this.X[6], 6);
        int FF28 = FF2(FF24, FF27, FF26, FF25, this.X[9], 14);
        int FF29 = FF2(FF25, FF28, FF27, FF26, this.X[11], 12);
        int FF210 = FF2(FF26, FF29, FF28, FF27, this.X[8], 13);
        int FF211 = FF2(FF27, FF210, FF29, FF28, this.X[12], 5);
        int FF212 = FF2(FF28, FF211, FF210, FF29, this.X[2], 14);
        int FF213 = FF2(FF29, FF212, FF211, FF210, this.X[10], 13);
        int FF214 = FF2(FF210, FF213, FF212, FF211, this.X[0], 13);
        int FF215 = FF2(FF211, FF214, FF213, FF212, this.X[4], 7);
        int FF216 = FF2(FF212, FF215, FF214, FF213, this.X[13], 5);
        int F4 = F4(F313, F316, FF215, F314, this.X[1], 11);
        int F42 = F4(F314, F4, F316, FF215, this.X[9], 12);
        int F43 = F4(FF215, F42, F4, F316, this.X[11], 14);
        int F44 = F4(F316, F43, F42, F4, this.X[10], 15);
        int F45 = F4(F4, F44, F43, F42, this.X[0], 14);
        int F46 = F4(F42, F45, F44, F43, this.X[8], 15);
        int F47 = F4(F43, F46, F45, F44, this.X[12], 9);
        int F48 = F4(F44, F47, F46, F45, this.X[4], 8);
        int F49 = F4(F45, F48, F47, F46, this.X[13], 9);
        int F410 = F4(F46, F49, F48, F47, this.X[3], 14);
        int F411 = F4(F47, F410, F49, F48, this.X[7], 5);
        int F412 = F4(F48, F411, F410, F49, this.X[15], 6);
        int F413 = F4(F49, F412, F411, F410, this.X[14], 8);
        int F414 = F4(F410, F413, F412, F411, this.X[5], 6);
        int F415 = F4(F411, F414, F413, F412, this.X[6], 5);
        int F416 = F4(F412, F415, F414, F413, this.X[2], 12);
        int FF1 = FF1(FF213, FF216, F315, FF214, this.X[8], 15);
        int FF12 = FF1(FF214, FF1, FF216, F315, this.X[6], 5);
        int FF13 = FF1(F315, FF12, FF1, FF216, this.X[4], 8);
        int FF14 = FF1(FF216, FF13, FF12, FF1, this.X[1], 11);
        int FF15 = FF1(FF1, FF14, FF13, FF12, this.X[3], 14);
        int FF16 = FF1(FF12, FF15, FF14, FF13, this.X[11], 14);
        int FF17 = FF1(FF13, FF16, FF15, FF14, this.X[15], 6);
        int FF18 = FF1(FF14, FF17, FF16, FF15, this.X[0], 14);
        int FF19 = FF1(FF15, FF18, FF17, FF16, this.X[5], 6);
        int FF110 = FF1(FF16, FF19, FF18, FF17, this.X[12], 9);
        int FF111 = FF1(FF17, FF110, FF19, FF18, this.X[2], 12);
        int FF112 = FF1(FF18, FF111, FF110, FF19, this.X[13], 9);
        int FF113 = FF1(FF19, FF112, FF111, FF110, this.X[9], 12);
        int FF114 = FF1(FF110, FF113, FF112, FF111, this.X[7], 5);
        int FF115 = FF1(FF111, FF114, FF113, FF112, this.X[10], 15);
        int FF116 = FF1(FF112, FF115, FF114, FF113, this.X[14], 8);
        this.H0 += F413;
        this.H1 += F416;
        this.H2 += F415;
        this.H3 += FF114;
        this.H4 += FF113;
        this.H5 += FF116;
        this.H6 += FF115;
        this.H7 += F414;
        this.xOff = 0;
        int i18 = 0;
        while (true) {
            int[] iArr = this.X;
            if (i18 != iArr.length) {
                iArr[i18] = 0;
                i18++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j10) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (-1 & j10);
        iArr[15] = (int) (j10 >>> 32);
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i10) {
        int[] iArr = this.X;
        int i11 = this.xOff;
        int i12 = i11 + 1;
        this.xOff = i12;
        iArr[i11] = ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
        if (i12 == 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        this.H0 = 1732584193;
        this.H1 = -271733879;
        this.H2 = -1732584194;
        this.H3 = 271733878;
        this.H4 = 1985229328;
        this.H5 = -19088744;
        this.H6 = -1985229329;
        this.H7 = 19088743;
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
        copyIn((RIPEMD256Digest) memoable);
    }
}
