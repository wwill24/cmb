package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public abstract class LongDigest implements ExtendedDigest, Memoable, EncodableDigest {
    private static final int BYTE_LENGTH = 128;
    static final long[] K = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    protected long H1;
    protected long H2;
    protected long H3;
    protected long H4;
    protected long H5;
    protected long H6;
    protected long H7;
    protected long H8;
    private long[] W;
    private long byteCount1;
    private long byteCount2;
    private int wOff;
    private byte[] xBuf;
    private int xBufOff;

    protected LongDigest() {
        this.xBuf = new byte[8];
        this.W = new long[80];
        this.xBufOff = 0;
        reset();
    }

    protected LongDigest(LongDigest longDigest) {
        this.xBuf = new byte[8];
        this.W = new long[80];
        copyIn(longDigest);
    }

    private long Ch(long j10, long j11, long j12) {
        return ((~j10) & j12) ^ (j11 & j10);
    }

    private long Maj(long j10, long j11, long j12) {
        return ((j10 & j12) ^ (j10 & j11)) ^ (j11 & j12);
    }

    private long Sigma0(long j10) {
        return (j10 >>> 7) ^ (((j10 << 63) | (j10 >>> 1)) ^ ((j10 << 56) | (j10 >>> 8)));
    }

    private long Sigma1(long j10) {
        return (j10 >>> 6) ^ (((j10 << 45) | (j10 >>> 19)) ^ ((j10 << 3) | (j10 >>> 61)));
    }

    private long Sum0(long j10) {
        return ((j10 >>> 39) | (j10 << 25)) ^ (((j10 << 36) | (j10 >>> 28)) ^ ((j10 << 30) | (j10 >>> 34)));
    }

    private long Sum1(long j10) {
        return ((j10 >>> 41) | (j10 << 23)) ^ (((j10 << 50) | (j10 >>> 14)) ^ ((j10 << 46) | (j10 >>> 18)));
    }

    private void adjustByteCounts() {
        long j10 = this.byteCount1;
        if (j10 > 2305843009213693951L) {
            this.byteCount2 += j10 >>> 61;
            this.byteCount1 = j10 & 2305843009213693951L;
        }
    }

    /* access modifiers changed from: protected */
    public void copyIn(LongDigest longDigest) {
        byte[] bArr = longDigest.xBuf;
        System.arraycopy(bArr, 0, this.xBuf, 0, bArr.length);
        this.xBufOff = longDigest.xBufOff;
        this.byteCount1 = longDigest.byteCount1;
        this.byteCount2 = longDigest.byteCount2;
        this.H1 = longDigest.H1;
        this.H2 = longDigest.H2;
        this.H3 = longDigest.H3;
        this.H4 = longDigest.H4;
        this.H5 = longDigest.H5;
        this.H6 = longDigest.H6;
        this.H7 = longDigest.H7;
        this.H8 = longDigest.H8;
        long[] jArr = longDigest.W;
        System.arraycopy(jArr, 0, this.W, 0, jArr.length);
        this.wOff = longDigest.wOff;
    }

    public void finish() {
        adjustByteCounts();
        long j10 = this.byteCount1 << 3;
        long j11 = this.byteCount2;
        byte b10 = Byte.MIN_VALUE;
        while (true) {
            update(b10);
            if (this.xBufOff != 0) {
                b10 = 0;
            } else {
                processLength(j10, j11);
                processBlock();
                return;
            }
        }
    }

    public int getByteLength() {
        return 128;
    }

    /* access modifiers changed from: protected */
    public int getEncodedStateSize() {
        return (this.wOff * 8) + 96;
    }

    /* access modifiers changed from: protected */
    public void populateState(byte[] bArr) {
        System.arraycopy(this.xBuf, 0, bArr, 0, this.xBufOff);
        Pack.intToBigEndian(this.xBufOff, bArr, 8);
        Pack.longToBigEndian(this.byteCount1, bArr, 12);
        Pack.longToBigEndian(this.byteCount2, bArr, 20);
        Pack.longToBigEndian(this.H1, bArr, 28);
        Pack.longToBigEndian(this.H2, bArr, 36);
        Pack.longToBigEndian(this.H3, bArr, 44);
        Pack.longToBigEndian(this.H4, bArr, 52);
        Pack.longToBigEndian(this.H5, bArr, 60);
        Pack.longToBigEndian(this.H6, bArr, 68);
        Pack.longToBigEndian(this.H7, bArr, 76);
        Pack.longToBigEndian(this.H8, bArr, 84);
        Pack.intToBigEndian(this.wOff, bArr, 92);
        for (int i10 = 0; i10 < this.wOff; i10++) {
            Pack.longToBigEndian(this.W[i10], bArr, (i10 * 8) + 96);
        }
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        adjustByteCounts();
        for (int i10 = 16; i10 <= 79; i10++) {
            long[] jArr = this.W;
            long Sigma1 = Sigma1(jArr[i10 - 2]);
            long[] jArr2 = this.W;
            jArr[i10] = Sigma1 + jArr2[i10 - 7] + Sigma0(jArr2[i10 - 15]) + this.W[i10 - 16];
        }
        long j10 = this.H1;
        long j11 = this.H2;
        long j12 = this.H3;
        long j13 = this.H4;
        long j14 = this.H5;
        long j15 = this.H6;
        long j16 = this.H7;
        long j17 = j15;
        long j18 = j13;
        int i11 = 0;
        long j19 = j11;
        long j20 = j12;
        long j21 = j14;
        int i12 = 0;
        long j22 = this.H8;
        long j23 = j16;
        long j24 = j10;
        long j25 = j23;
        while (i12 < 10) {
            int i13 = i12;
            long j26 = j21;
            long[] jArr3 = K;
            int i14 = i11 + 1;
            long Sum1 = j22 + Sum1(j21) + Ch(j21, j17, j25) + jArr3[i11] + this.W[i11];
            long Sum0 = Sum1 + Sum0(j24) + Maj(j24, j19, j20);
            long j27 = j18 + Sum1;
            long j28 = j27;
            int i15 = i14 + 1;
            long Sum12 = j25 + Sum1(j27) + Ch(j27, j26, j17) + jArr3[i14] + this.W[i14];
            long j29 = Sum0;
            long j30 = j20 + Sum12;
            long Sum02 = Sum12 + Sum0(Sum0) + Maj(Sum0, j24, j19);
            long Sum13 = Sum1(j30);
            long j31 = j30;
            long j32 = Sum02;
            int i16 = i15 + 1;
            long Ch = j17 + Sum13 + Ch(j30, j28, j26) + jArr3[i15] + this.W[i15];
            long j33 = j19 + Ch;
            long Sum03 = Ch + Sum0(j32) + Maj(j32, j29, j24);
            long Sum14 = Sum1(j33);
            long j34 = j33;
            long j35 = Sum03;
            int i17 = i16 + 1;
            long Ch2 = j26 + Sum14 + Ch(j33, j31, j28) + jArr3[i16] + this.W[i16];
            long j36 = j24 + Ch2;
            long Sum04 = Ch2 + Sum0(j35) + Maj(j35, j32, j29);
            long Sum15 = Sum1(j36);
            long j37 = j36;
            long j38 = Sum04;
            int i18 = i17 + 1;
            long Ch3 = j28 + Sum15 + Ch(j36, j34, j31) + jArr3[i17] + this.W[i17];
            long j39 = j35;
            long j40 = j35;
            long j41 = j29 + Ch3;
            long Sum05 = Ch3 + Sum0(j38) + Maj(j38, j39, j32);
            long Sum16 = Sum1(j41);
            long j42 = j41;
            long j43 = Sum05;
            int i19 = i18 + 1;
            long Ch4 = j31 + Sum16 + Ch(j41, j37, j34) + jArr3[i18] + this.W[i18];
            long j44 = j32 + Ch4;
            long Sum06 = Ch4 + Sum0(j43) + Maj(j43, j38, j40);
            long Sum17 = Sum1(j44);
            j25 = j44;
            long j45 = Sum06;
            int i20 = i19 + 1;
            long Ch5 = j34 + Sum17 + Ch(j44, j42, j37) + jArr3[i19] + this.W[i19];
            long j46 = j40 + Ch5;
            long j47 = j43;
            long j48 = j43;
            long j49 = j46;
            long Sum07 = Ch5 + Sum0(j45) + Maj(j45, j47, j38);
            long Sum18 = Sum1(j49);
            j17 = j49;
            j19 = Sum07;
            long Ch6 = j37 + Sum18 + Ch(j49, j25, j42) + jArr3[i20] + this.W[i20];
            long Sum08 = Ch6 + Sum0(j19) + Maj(j19, j45, j48);
            i12 = i13 + 1;
            j21 = j38 + Ch6;
            j20 = j45;
            j22 = j42;
            j18 = j48;
            i11 = i20 + 1;
            j24 = Sum08;
        }
        this.H1 += j24;
        this.H2 += j19;
        this.H3 += j20;
        this.H4 += j18;
        this.H5 += j21;
        this.H6 += j17;
        this.H7 += j25;
        this.H8 += j22;
        this.wOff = 0;
        for (int i21 = 0; i21 < 16; i21++) {
            this.W[i21] = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j10, long j11) {
        if (this.wOff > 14) {
            processBlock();
        }
        long[] jArr = this.W;
        jArr[14] = j11;
        jArr[15] = j10;
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i10) {
        this.W[this.wOff] = Pack.bigEndianToLong(bArr, i10);
        int i11 = this.wOff + 1;
        this.wOff = i11;
        if (i11 == 16) {
            processBlock();
        }
    }

    public void reset() {
        this.byteCount1 = 0;
        this.byteCount2 = 0;
        int i10 = 0;
        this.xBufOff = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.xBuf;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = 0;
            i11++;
        }
        this.wOff = 0;
        while (true) {
            long[] jArr = this.W;
            if (i10 != jArr.length) {
                jArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void restoreState(byte[] bArr) {
        int bigEndianToInt = Pack.bigEndianToInt(bArr, 8);
        this.xBufOff = bigEndianToInt;
        System.arraycopy(bArr, 0, this.xBuf, 0, bigEndianToInt);
        this.byteCount1 = Pack.bigEndianToLong(bArr, 12);
        this.byteCount2 = Pack.bigEndianToLong(bArr, 20);
        this.H1 = Pack.bigEndianToLong(bArr, 28);
        this.H2 = Pack.bigEndianToLong(bArr, 36);
        this.H3 = Pack.bigEndianToLong(bArr, 44);
        this.H4 = Pack.bigEndianToLong(bArr, 52);
        this.H5 = Pack.bigEndianToLong(bArr, 60);
        this.H6 = Pack.bigEndianToLong(bArr, 68);
        this.H7 = Pack.bigEndianToLong(bArr, 76);
        this.H8 = Pack.bigEndianToLong(bArr, 84);
        this.wOff = Pack.bigEndianToInt(bArr, 92);
        for (int i10 = 0; i10 < this.wOff; i10++) {
            this.W[i10] = Pack.bigEndianToLong(bArr, (i10 * 8) + 96);
        }
    }

    public void update(byte b10) {
        byte[] bArr = this.xBuf;
        int i10 = this.xBufOff;
        int i11 = i10 + 1;
        this.xBufOff = i11;
        bArr[i10] = b10;
        if (i11 == bArr.length) {
            processWord(bArr, 0);
            this.xBufOff = 0;
        }
        this.byteCount1++;
    }

    public void update(byte[] bArr, int i10, int i11) {
        while (this.xBufOff != 0 && i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
        while (i11 > this.xBuf.length) {
            processWord(bArr, i10);
            byte[] bArr2 = this.xBuf;
            i10 += bArr2.length;
            i11 -= bArr2.length;
            this.byteCount1 += (long) bArr2.length;
        }
        while (i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
    }
}
