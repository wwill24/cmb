package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SM3Digest extends GeneralDigest {
    private static final int BLOCK_SIZE = 16;
    private static final int DIGEST_LENGTH = 32;
    private static final int[] T = new int[64];
    private int[] V = new int[8];
    private int[] W = new int[68];
    private int[] inwords = new int[16];
    private int xOff;

    static {
        int i10;
        int i11 = 0;
        while (true) {
            if (i11 >= 16) {
                break;
            }
            T[i11] = (2043430169 >>> (32 - i11)) | (2043430169 << i11);
            i11++;
        }
        for (i10 = 16; i10 < 64; i10++) {
            int i12 = i10 % 32;
            T[i10] = (2055708042 >>> (32 - i12)) | (2055708042 << i12);
        }
    }

    public SM3Digest() {
        reset();
    }

    public SM3Digest(SM3Digest sM3Digest) {
        super((GeneralDigest) sM3Digest);
        copyIn(sM3Digest);
    }

    private int FF0(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    private int FF1(int i10, int i11, int i12) {
        return (i10 & i12) | (i10 & i11) | (i11 & i12);
    }

    private int GG0(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    private int GG1(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    private int P0(int i10) {
        return (i10 ^ ((i10 << 9) | (i10 >>> 23))) ^ ((i10 << 17) | (i10 >>> 15));
    }

    private int P1(int i10) {
        return (i10 ^ ((i10 << 15) | (i10 >>> 17))) ^ ((i10 << 23) | (i10 >>> 9));
    }

    private void copyIn(SM3Digest sM3Digest) {
        int[] iArr = sM3Digest.V;
        int[] iArr2 = this.V;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = sM3Digest.inwords;
        int[] iArr4 = this.inwords;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        this.xOff = sM3Digest.xOff;
    }

    public Memoable copy() {
        return new SM3Digest(this);
    }

    public int doFinal(byte[] bArr, int i10) {
        finish();
        Pack.intToBigEndian(this.V, bArr, i10);
        reset();
        return 32;
    }

    public String getAlgorithmName() {
        return "SM3";
    }

    public int getDigestSize() {
        return 32;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        int i10;
        int i11 = 0;
        while (true) {
            if (i11 >= 16) {
                break;
            }
            this.W[i11] = this.inwords[i11];
            i11++;
        }
        for (int i12 = 16; i12 < 68; i12++) {
            int[] iArr = this.W;
            int i13 = iArr[i12 - 3];
            int i14 = iArr[i12 - 13];
            iArr[i12] = (P1(((i13 >>> 17) | (i13 << 15)) ^ (iArr[i12 - 16] ^ iArr[i12 - 9])) ^ ((i14 >>> 25) | (i14 << 7))) ^ this.W[i12 - 6];
        }
        int[] iArr2 = this.V;
        int i15 = iArr2[0];
        int i16 = iArr2[1];
        int i17 = iArr2[2];
        int i18 = iArr2[3];
        int i19 = iArr2[4];
        int i20 = iArr2[5];
        int i21 = iArr2[6];
        int i22 = iArr2[7];
        int i23 = 0;
        int i24 = i21;
        for (i10 = 16; i23 < i10; i10 = 16) {
            int i25 = (i15 << 12) | (i15 >>> 20);
            int i26 = i25 + i19 + T[i23];
            int i27 = (i26 << 7) | (i26 >>> 25);
            int[] iArr3 = this.W;
            int i28 = iArr3[i23];
            int i29 = (i16 << 9) | (i16 >>> 23);
            int i30 = (i20 << 19) | (i20 >>> 13);
            i23++;
            i20 = i19;
            i19 = P0(GG0(i19, i20, i24) + i22 + i27 + i28);
            i18 = i17;
            i17 = i29;
            i22 = i24;
            i24 = i30;
            i16 = i15;
            i15 = FF0(i15, i16, i17) + i18 + (i27 ^ i25) + (i28 ^ iArr3[i23 + 4]);
        }
        int i31 = i22;
        int i32 = i19;
        int i33 = i24;
        int i34 = i18;
        int i35 = i17;
        int i36 = i16;
        int i37 = i15;
        int i38 = 16;
        while (i38 < 64) {
            int i39 = (i37 << 12) | (i37 >>> 20);
            int i40 = i39 + i32 + T[i38];
            int i41 = (i40 << 7) | (i40 >>> 25);
            int[] iArr4 = this.W;
            int i42 = iArr4[i38];
            int i43 = (i20 << 19) | (i20 >>> 13);
            i38++;
            i20 = i32;
            i32 = P0(GG1(i32, i20, i33) + i31 + i41 + i42);
            i34 = i35;
            i35 = (i36 >>> 23) | (i36 << 9);
            i36 = i37;
            i37 = FF1(i37, i36, i35) + i34 + (i41 ^ i39) + (i42 ^ iArr4[i38 + 4]);
            int i44 = i43;
            i31 = i33;
            i33 = i44;
        }
        int[] iArr5 = this.V;
        iArr5[0] = i37 ^ iArr5[0];
        iArr5[1] = iArr5[1] ^ i36;
        iArr5[2] = iArr5[2] ^ i35;
        iArr5[3] = iArr5[3] ^ i34;
        iArr5[4] = iArr5[4] ^ i32;
        iArr5[5] = iArr5[5] ^ i20;
        iArr5[6] = i33 ^ iArr5[6];
        iArr5[7] = iArr5[7] ^ i31;
        this.xOff = 0;
    }

    /* access modifiers changed from: protected */
    public void processLength(long j10) {
        int i10 = this.xOff;
        if (i10 > 14) {
            this.inwords[i10] = 0;
            this.xOff = i10 + 1;
            processBlock();
        }
        while (true) {
            int i11 = this.xOff;
            if (i11 < 14) {
                this.inwords[i11] = 0;
                this.xOff = i11 + 1;
            } else {
                int[] iArr = this.inwords;
                int i12 = i11 + 1;
                iArr[i11] = (int) (j10 >>> 32);
                this.xOff = i12 + 1;
                iArr[i12] = (int) j10;
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = (bArr[i12 + 1] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i11] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[i12] & 255) << 8);
        int[] iArr = this.inwords;
        int i14 = this.xOff;
        iArr[i14] = i13;
        int i15 = i14 + 1;
        this.xOff = i15;
        if (i15 >= 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        int[] iArr = this.V;
        iArr[0] = 1937774191;
        iArr[1] = 1226093241;
        iArr[2] = 388252375;
        iArr[3] = -628488704;
        iArr[4] = -1452330820;
        iArr[5] = 372324522;
        iArr[6] = -477237683;
        iArr[7] = -1325724082;
        this.xOff = 0;
    }

    public void reset(Memoable memoable) {
        SM3Digest sM3Digest = (SM3Digest) memoable;
        super.copyIn(sM3Digest);
        copyIn(sM3Digest);
    }
}
