package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

public class KeccakDigest implements ExtendedDigest {
    private static long[] KeccakRoundConstants = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
    protected int bitsInQueue;
    protected byte[] dataQueue;
    protected int fixedOutputLength;
    protected int rate;
    protected boolean squeezing;
    protected long[] state;

    public KeccakDigest() {
        this(288);
    }

    public KeccakDigest(int i10) {
        this.state = new long[25];
        this.dataQueue = new byte[192];
        init(i10);
    }

    public KeccakDigest(KeccakDigest keccakDigest) {
        long[] jArr = new long[25];
        this.state = jArr;
        this.dataQueue = new byte[192];
        long[] jArr2 = keccakDigest.state;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        byte[] bArr = keccakDigest.dataQueue;
        System.arraycopy(bArr, 0, this.dataQueue, 0, bArr.length);
        this.rate = keccakDigest.rate;
        this.bitsInQueue = keccakDigest.bitsInQueue;
        this.fixedOutputLength = keccakDigest.fixedOutputLength;
        this.squeezing = keccakDigest.squeezing;
    }

    private void KeccakAbsorb(byte[] bArr, int i10) {
        int i11 = this.rate >>> 6;
        for (int i12 = 0; i12 < i11; i12++) {
            long[] jArr = this.state;
            jArr[i12] = jArr[i12] ^ Pack.littleEndianToLong(bArr, i10);
            i10 += 8;
        }
        Hex.toHexString(dumpState()).toLowerCase();
        KeccakPermutation();
    }

    private void KeccakExtract() {
        KeccakPermutation();
        dumpState();
        Pack.longToLittleEndian(this.state, 0, this.rate >>> 6, this.dataQueue, 0);
        this.bitsInQueue = this.rate;
    }

    private void KeccakPermutation() {
        long[] jArr = this.state;
        int i10 = 0;
        long j10 = jArr[0];
        boolean z10 = true;
        long j11 = jArr[1];
        long j12 = jArr[2];
        char c10 = 3;
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = jArr[6];
        long j17 = jArr[7];
        long j18 = jArr[8];
        long j19 = jArr[9];
        long j20 = jArr[10];
        long j21 = jArr[11];
        long j22 = jArr[12];
        long j23 = jArr[13];
        long j24 = jArr[14];
        long j25 = jArr[15];
        long j26 = jArr[16];
        long j27 = jArr[17];
        long j28 = jArr[18];
        long j29 = jArr[19];
        long j30 = jArr[20];
        long j31 = jArr[21];
        long j32 = jArr[22];
        long j33 = jArr[23];
        int i11 = 24;
        long j34 = jArr[24];
        while (i10 < i11) {
            long j35 = (((j10 ^ j15) ^ j20) ^ j25) ^ j30;
            long j36 = (((j11 ^ j16) ^ j21) ^ j26) ^ j31;
            long j37 = (((j12 ^ j17) ^ j22) ^ j27) ^ j32;
            long j38 = (((j13 ^ j18) ^ j23) ^ j28) ^ j33;
            long j39 = (((j14 ^ j19) ^ j24) ^ j29) ^ j34;
            long j40 = ((j36 << (z10 ? 1 : 0)) | (j36 >>> -1)) ^ j39;
            long j41 = ((j37 << z10) | (j37 >>> -1)) ^ j35;
            long j42 = ((j38 << z10) | (j38 >>> -1)) ^ j36;
            long j43 = ((j39 << z10) | (j39 >>> -1)) ^ j37;
            long j44 = ((j35 << z10) | (j35 >>> -1)) ^ j38;
            long j45 = j10 ^ j40;
            long j46 = j15 ^ j40;
            long j47 = j20 ^ j40;
            long j48 = j25 ^ j40;
            long j49 = j30 ^ j40;
            long j50 = j11 ^ j41;
            long j51 = j16 ^ j41;
            long j52 = j21 ^ j41;
            long j53 = j26 ^ j41;
            long j54 = j31 ^ j41;
            long j55 = j17 ^ j42;
            long j56 = j22 ^ j42;
            long j57 = j27 ^ j42;
            long j58 = j32 ^ j42;
            long j59 = j18 ^ j43;
            long j60 = j23 ^ j43;
            long j61 = j28 ^ j43;
            long j62 = j33 ^ j43;
            long j63 = j19 ^ j44;
            long j64 = j24 ^ j44;
            long j65 = j29 ^ j44;
            long j66 = j34 ^ j44;
            long j67 = (j50 << z10) | (j50 >>> 63);
            long j68 = (j51 << 44) | (j51 >>> 20);
            long j69 = j14 ^ j44;
            long j70 = (j63 << 20) | (j63 >>> 44);
            long j71 = j58 << 61;
            long j72 = j58 >>> c10;
            long j73 = j13 ^ j43;
            long j74 = j71 | j72;
            long j75 = j12 ^ j42;
            long j76 = (j64 << 39) | (j64 >>> 25);
            long j77 = (j56 << 43) | (j56 >>> 21);
            long j78 = (j75 << 62) | (j75 >>> 2);
            long j79 = (j60 << 25) | (j60 >>> 39);
            long j80 = (j49 << 18) | (j49 >>> 46);
            long j81 = (j65 << 8) | (j65 >>> 56);
            long j82 = j48 << 41;
            long j83 = j48 >>> 23;
            long j84 = (j62 << 56) | (j62 >>> 8);
            long j85 = j82 | j83;
            long j86 = (j69 << 27) | (j69 >>> 37);
            long j87 = (j66 << 14) | (j66 >>> 50);
            long j88 = j54 << 2;
            long j89 = j54 >>> 62;
            long j90 = j79;
            long j91 = j88 | j89;
            long j92 = (j59 << 55) | (j59 >>> 9);
            long j93 = j53 << 45;
            long j94 = j53 >>> 19;
            long j95 = j92;
            long j96 = j93 | j94;
            long j97 = j74;
            long j98 = (j46 << 36) | (j46 >>> 28);
            long j99 = j73 << 28;
            long j100 = j73 >>> 36;
            long j101 = j98;
            long j102 = j99 | j100;
            long j103 = j61 << 21;
            long j104 = j61 >>> 43;
            long j105 = j96;
            long j106 = j103 | j104;
            long j107 = j57 << 15;
            long j108 = j57 >>> 49;
            long j109 = j102;
            long j110 = j107 | j108;
            long j111 = j52 << 10;
            long j112 = j52 >>> 54;
            long j113 = j110;
            long j114 = j111 | j112;
            long j115 = j55 << 6;
            long j116 = j55 >>> 58;
            long j117 = j114;
            long j118 = j115 | j116;
            long j119 = j47 << 3;
            long j120 = j47 >>> 61;
            long j121 = j119 | j120;
            long j122 = ((~j68) & j77) ^ j45;
            long j123 = ((~j77) & j106) ^ j68;
            j12 = j77 ^ ((~j106) & j87);
            j13 = j106 ^ ((~j87) & j45);
            long j124 = j87 ^ ((~j45) & j68);
            long j125 = j121;
            long j126 = ((~j125) & j105) ^ j70;
            long j127 = j124;
            long j128 = j105;
            long j129 = j109 ^ ((~j70) & j121);
            long j130 = ((~j128) & j97) ^ j125;
            long j131 = j97;
            long j132 = j130;
            long j133 = j128 ^ ((~j131) & j109);
            long j134 = ((~j109) & j70) ^ j131;
            long j135 = j118;
            j20 = j67 ^ ((~j135) & j90);
            long j136 = j133;
            long j137 = j90;
            long j138 = ((~j137) & j81) ^ j135;
            long j139 = j81;
            long j140 = j134;
            long j141 = ((~j139) & j80) ^ j137;
            long j142 = j80;
            long j143 = j141;
            long j144 = j139 ^ ((~j142) & j67);
            long j145 = ((~j67) & j135) ^ j142;
            long j146 = j101;
            long j147 = j86 ^ ((~j146) & j117);
            long j148 = j144;
            long j149 = j117;
            long j150 = j145;
            long j151 = ((~j149) & j113) ^ j146;
            long j152 = j113;
            long j153 = j126;
            long j154 = j84;
            long j155 = j149 ^ ((~j152) & j84);
            long j156 = ((~j154) & j86) ^ j152;
            long j157 = ((~j86) & j146) ^ j154;
            long j158 = j95;
            long j159 = j156;
            long j160 = j76;
            long j161 = j157;
            long j162 = ((~j160) & j85) ^ j158;
            long j163 = j85;
            j30 = j78 ^ ((~j158) & j76);
            long j164 = j91;
            long j165 = j160 ^ ((~j163) & j91);
            long j166 = ((~j164) & j78) ^ j163;
            long j167 = j122 ^ KeccakRoundConstants[i10];
            i10++;
            j16 = j153;
            j22 = j143;
            j21 = j138;
            j23 = j148;
            j31 = j162;
            c10 = 3;
            j33 = j166;
            j32 = j165;
            j19 = j140;
            jArr = jArr;
            j29 = j161;
            j24 = j150;
            j17 = j132;
            j18 = j136;
            j27 = j155;
            j25 = j147;
            j14 = j127;
            j15 = j129;
            i11 = 24;
            j28 = j159;
            j26 = j151;
            long j168 = j167;
            z10 = true;
            j11 = j123;
            j34 = ((~j78) & j158) ^ j164;
            j10 = j168;
        }
        long[] jArr2 = jArr;
        jArr2[0] = j10;
        jArr2[1] = j11;
        jArr2[2] = j12;
        jArr2[3] = j13;
        jArr2[4] = j14;
        jArr2[5] = j15;
        jArr2[6] = j16;
        jArr2[7] = j17;
        jArr2[8] = j18;
        jArr2[9] = j19;
        jArr2[10] = j20;
        jArr2[11] = j21;
        jArr2[12] = j22;
        jArr2[13] = j23;
        jArr2[14] = j24;
        jArr2[15] = j25;
        jArr2[16] = j26;
        jArr2[17] = j27;
        jArr2[18] = j28;
        jArr2[19] = j29;
        jArr2[20] = j30;
        jArr2[21] = j31;
        jArr2[22] = j32;
        jArr2[23] = j33;
        jArr2[24] = j34;
    }

    private void init(int i10) {
        if (i10 == 128 || i10 == 224 || i10 == 256 || i10 == 288 || i10 == 384 || i10 == 512) {
            initSponge(1600 - (i10 << 1));
            return;
        }
        throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
    }

    private void initSponge(int i10) {
        if (i10 <= 0 || i10 >= 1600 || i10 % 64 != 0) {
            throw new IllegalStateException("invalid rate value");
        }
        this.rate = i10;
        int i11 = 0;
        while (true) {
            long[] jArr = this.state;
            if (i11 < jArr.length) {
                jArr[i11] = 0;
                i11++;
            } else {
                Arrays.fill(this.dataQueue, (byte) 0);
                this.bitsInQueue = 0;
                this.squeezing = false;
                this.fixedOutputLength = (1600 - i10) / 2;
                return;
            }
        }
    }

    private void padAndSwitchToSqueezingPhase() {
        byte[] bArr = this.dataQueue;
        int i10 = this.bitsInQueue;
        int i11 = i10 >>> 3;
        bArr[i11] = (byte) (bArr[i11] | ((byte) (1 << (i10 & 7))));
        int i12 = i10 + 1;
        this.bitsInQueue = i12;
        if (i12 == this.rate) {
            KeccakAbsorb(bArr, 0);
        } else {
            int i13 = i12 >>> 6;
            int i14 = i12 & 63;
            int i15 = 0;
            for (int i16 = 0; i16 < i13; i16++) {
                long[] jArr = this.state;
                jArr[i16] = jArr[i16] ^ Pack.littleEndianToLong(this.dataQueue, i15);
                i15 += 8;
            }
            dumpState();
            if (i14 > 0) {
                long[] jArr2 = this.state;
                jArr2[i13] = (((1 << i14) - 1) & Pack.littleEndianToLong(this.dataQueue, i15)) ^ jArr2[i13];
            }
        }
        long[] jArr3 = this.state;
        int i17 = (this.rate - 1) >>> 6;
        jArr3[i17] = jArr3[i17] ^ Long.MIN_VALUE;
        this.bitsInQueue = 0;
        this.squeezing = true;
    }

    /* access modifiers changed from: protected */
    public void absorb(byte b10) {
        int i10 = this.bitsInQueue;
        if (i10 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.squeezing) {
            byte[] bArr = this.dataQueue;
            bArr[i10 >>> 3] = b10;
            int i11 = i10 + 8;
            this.bitsInQueue = i11;
            if (i11 == this.rate) {
                KeccakAbsorb(bArr, 0);
                this.bitsInQueue = 0;
            }
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    /* access modifiers changed from: protected */
    public void absorb(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15 = this.bitsInQueue;
        if (i15 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.squeezing) {
            int i16 = i15 >>> 3;
            int i17 = this.rate >>> 3;
            int i18 = i17 - i16;
            if (i11 < i18) {
                System.arraycopy(bArr, i10, this.dataQueue, i16, i11);
                i14 = this.bitsInQueue + (i11 << 3);
            } else {
                if (i16 > 0) {
                    System.arraycopy(bArr, i10, this.dataQueue, i16, i18);
                    i12 = i18 + 0;
                    KeccakAbsorb(this.dataQueue, 0);
                } else {
                    i12 = 0;
                }
                while (true) {
                    i13 = i11 - i12;
                    if (i13 < i17) {
                        break;
                    }
                    KeccakAbsorb(bArr, i10 + i12);
                    i12 += i17;
                }
                System.arraycopy(bArr, i10 + i12, this.dataQueue, 0, i13);
                i14 = i13 << 3;
            }
            this.bitsInQueue = i14;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    /* access modifiers changed from: protected */
    public void absorbBits(int i10, int i11) {
        if (i11 < 1 || i11 > 7) {
            throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
        }
        int i12 = this.bitsInQueue;
        if (i12 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.squeezing) {
            this.dataQueue[i12 >>> 3] = (byte) (i10 & ((1 << i11) - 1));
            this.bitsInQueue = i12 + i11;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public int doFinal(byte[] bArr, int i10) {
        squeeze(bArr, i10, (long) this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    /* access modifiers changed from: protected */
    public int doFinal(byte[] bArr, int i10, byte b10, int i11) {
        if (i11 > 0) {
            absorbBits(b10, i11);
        }
        squeeze(bArr, i10, (long) this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    /* access modifiers changed from: protected */
    public byte[] dumpState() {
        byte[] bArr = new byte[(this.state.length * 8)];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            long[] jArr = this.state;
            if (i10 == jArr.length) {
                return bArr;
            }
            Pack.longToLittleEndian(jArr[i10], bArr, i11);
            i11 += 8;
            i10++;
        }
    }

    public String getAlgorithmName() {
        return "Keccak-" + this.fixedOutputLength;
    }

    public int getByteLength() {
        return this.rate / 8;
    }

    public int getDigestSize() {
        return this.fixedOutputLength / 8;
    }

    public void reset() {
        init(this.fixedOutputLength);
    }

    /* access modifiers changed from: protected */
    public void squeeze(byte[] bArr, int i10, long j10) {
        if (!this.squeezing) {
            padAndSwitchToSqueezingPhase();
        }
        dumpState();
        long j11 = 0;
        if (j10 % 8 == 0) {
            while (j11 < j10) {
                if (this.bitsInQueue == 0) {
                    KeccakExtract();
                }
                int min = (int) Math.min((long) this.bitsInQueue, j10 - j11);
                System.arraycopy(this.dataQueue, (this.rate - this.bitsInQueue) / 8, bArr, ((int) (j11 / 8)) + i10, min / 8);
                this.bitsInQueue -= min;
                j11 += (long) min;
            }
            dumpState();
            return;
        }
        throw new IllegalStateException("outputLength not a multiple of 8");
    }

    public void update(byte b10) {
        absorb(b10);
    }

    public void update(byte[] bArr, int i10, int i11) {
        absorb(bArr, i10, i11);
    }
}
