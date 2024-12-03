package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public final class Kangaroo {
    private static final int DIGESTLEN = 32;

    static abstract class KangarooBase implements ExtendedDigest, Xof {
        private static final int BLKSIZE = 8192;
        private static final byte[] FINAL = {-1, -1, 6};
        private static final byte[] FIRST = {3, 0, 0, 0, 0, 0, 0, 0};
        private static final byte[] INTERMEDIATE = {11};
        private static final byte[] SINGLE = {7};
        private final byte[] singleByte = new byte[1];
        private boolean squeezing;
        private final int theChainLen;
        private int theCurrNode;
        private final KangarooSponge theLeaf;
        private byte[] thePersonal;
        private int theProcessed;
        private final KangarooSponge theTree;
        private long theXofLen;
        private long theXofRemaining;

        KangarooBase(int i10, int i11, int i12) {
            this.theTree = new KangarooSponge(i10, i11);
            this.theLeaf = new KangarooSponge(i10, i11);
            this.theChainLen = i10 >> 2;
            this.theXofLen = (long) i12;
            this.theXofRemaining = -1;
            buildPersonal((byte[]) null);
        }

        private void buildPersonal(byte[] bArr) {
            int length = bArr == null ? 0 : bArr.length;
            byte[] lengthEncode = lengthEncode((long) length);
            byte[] copyOf = bArr == null ? new byte[(lengthEncode.length + length)] : Arrays.copyOf(bArr, lengthEncode.length + length);
            this.thePersonal = copyOf;
            System.arraycopy(lengthEncode, 0, copyOf, length, lengthEncode.length);
        }

        private static byte[] lengthEncode(long j10) {
            byte b10;
            if (j10 != 0) {
                long j11 = j10;
                b10 = 1;
                while (true) {
                    j11 >>= 8;
                    if (j11 == 0) {
                        break;
                    }
                    b10 = (byte) (b10 + 1);
                }
            } else {
                b10 = 0;
            }
            byte[] bArr = new byte[(b10 + 1)];
            bArr[b10] = b10;
            for (int i10 = 0; i10 < b10; i10++) {
                bArr[i10] = (byte) ((int) (j10 >> (((b10 - i10) - 1) * 8)));
            }
            return bArr;
        }

        private void processData(byte[] bArr, int i10, int i11) {
            if (!this.squeezing) {
                KangarooSponge kangarooSponge = this.theCurrNode == 0 ? this.theTree : this.theLeaf;
                int i12 = 8192 - this.theProcessed;
                if (i12 >= i11) {
                    kangarooSponge.absorb(bArr, i10, i11);
                    this.theProcessed += i11;
                    return;
                }
                if (i12 > 0) {
                    kangarooSponge.absorb(bArr, i10, i12);
                    this.theProcessed += i12;
                }
                while (i12 < i11) {
                    if (this.theProcessed == 8192) {
                        switchLeaf(true);
                    }
                    int min = Math.min(i11 - i12, 8192);
                    this.theLeaf.absorb(bArr, i10 + i12, min);
                    this.theProcessed += min;
                    i12 += min;
                }
                return;
            }
            throw new IllegalStateException("attempt to absorb while squeezing");
        }

        private void switchFinal() {
            switchLeaf(false);
            byte[] lengthEncode = lengthEncode((long) this.theCurrNode);
            this.theTree.absorb(lengthEncode, 0, lengthEncode.length);
            KangarooSponge kangarooSponge = this.theTree;
            byte[] bArr = FINAL;
            kangarooSponge.absorb(bArr, 0, bArr.length);
            this.theTree.padAndSwitchToSqueezingPhase();
        }

        private void switchLeaf(boolean z10) {
            if (this.theCurrNode == 0) {
                KangarooSponge kangarooSponge = this.theTree;
                byte[] bArr = FIRST;
                kangarooSponge.absorb(bArr, 0, bArr.length);
            } else {
                KangarooSponge kangarooSponge2 = this.theLeaf;
                byte[] bArr2 = INTERMEDIATE;
                kangarooSponge2.absorb(bArr2, 0, bArr2.length);
                int i10 = this.theChainLen;
                byte[] bArr3 = new byte[i10];
                this.theLeaf.squeeze(bArr3, 0, i10);
                this.theTree.absorb(bArr3, 0, this.theChainLen);
                this.theLeaf.initSponge();
            }
            if (z10) {
                this.theCurrNode++;
            }
            this.theProcessed = 0;
        }

        private void switchSingle() {
            this.theTree.absorb(SINGLE, 0, 1);
            this.theTree.padAndSwitchToSqueezingPhase();
        }

        private void switchToSqueezing() {
            byte[] bArr = this.thePersonal;
            processData(bArr, 0, bArr.length);
            if (this.theCurrNode == 0) {
                switchSingle();
            } else {
                switchFinal();
            }
            long j10 = this.theXofLen;
            if (j10 == 0) {
                j10 = (long) getDigestSize();
            } else if (j10 == -1) {
                j10 = -2;
            }
            this.theXofRemaining = j10;
        }

        public int doFinal(byte[] bArr, int i10) {
            if (getDigestSize() != -1) {
                return doFinal(bArr, i10, getDigestSize());
            }
            throw new IllegalStateException("No defined output length");
        }

        public int doFinal(byte[] bArr, int i10, int i11) {
            if (!this.squeezing) {
                int doOutput = doOutput(bArr, i10, i11);
                reset();
                return doOutput;
            }
            throw new IllegalStateException("Already outputting");
        }

        public int doOutput(byte[] bArr, int i10, int i11) {
            if (!this.squeezing) {
                switchToSqueezing();
            }
            if (i11 >= 0) {
                long j10 = this.theXofRemaining;
                if (j10 <= 0 || ((long) i11) <= j10) {
                    this.theTree.squeeze(bArr, i10, i11);
                    return i11;
                }
            }
            throw new IllegalArgumentException("Insufficient bytes remaining");
        }

        public int getByteLength() {
            return this.theTree.theRateBytes;
        }

        public int getDigestSize() {
            long j10 = this.theXofLen;
            return j10 == 0 ? this.theChainLen >> 1 : (int) j10;
        }

        public void init(KangarooParameters kangarooParameters) {
            buildPersonal(kangarooParameters.getPersonalisation());
            long maxOutputLength = kangarooParameters.getMaxOutputLength();
            if (maxOutputLength >= -1) {
                this.theXofLen = maxOutputLength;
                reset();
                return;
            }
            throw new IllegalArgumentException("Invalid output length");
        }

        public void reset() {
            this.theTree.initSponge();
            this.theLeaf.initSponge();
            this.theCurrNode = 0;
            this.theProcessed = 0;
            this.theXofRemaining = -1;
            this.squeezing = false;
        }

        public void update(byte b10) {
            byte[] bArr = this.singleByte;
            bArr[0] = b10;
            update(bArr, 0, 1);
        }

        public void update(byte[] bArr, int i10, int i11) {
            processData(bArr, i10, i11);
        }
    }

    public static class KangarooParameters implements CipherParameters {
        /* access modifiers changed from: private */
        public long theMaxXofLen;
        /* access modifiers changed from: private */
        public byte[] thePersonal;

        public static class Builder {
            private long theMaxXofLen;
            private byte[] thePersonal;

            public KangarooParameters build() {
                KangarooParameters kangarooParameters = new KangarooParameters();
                byte[] bArr = this.thePersonal;
                if (bArr != null) {
                    byte[] unused = kangarooParameters.thePersonal = bArr;
                }
                long unused2 = kangarooParameters.theMaxXofLen = this.theMaxXofLen;
                return kangarooParameters;
            }

            public Builder setMaxOutputLen(long j10) {
                this.theMaxXofLen = j10;
                return this;
            }

            public Builder setPersonalisation(byte[] bArr) {
                this.thePersonal = Arrays.clone(bArr);
                return this;
            }
        }

        public long getMaxOutputLength() {
            return this.theMaxXofLen;
        }

        public byte[] getPersonalisation() {
            return Arrays.clone(this.thePersonal);
        }
    }

    private static class KangarooSponge {
        private static long[] KeccakRoundConstants = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
        private int bytesInQueue;
        private boolean squeezing;
        private final byte[] theQueue;
        /* access modifiers changed from: private */
        public final int theRateBytes;
        private final int theRounds;
        private final long[] theState = new long[25];

        KangarooSponge(int i10, int i11) {
            int i12 = (1600 - (i10 << 1)) >> 3;
            this.theRateBytes = i12;
            this.theRounds = i11;
            this.theQueue = new byte[i12];
            initSponge();
        }

        private void KangarooAbsorb(byte[] bArr, int i10) {
            int i11 = this.theRateBytes >> 3;
            for (int i12 = 0; i12 < i11; i12++) {
                long[] jArr = this.theState;
                jArr[i12] = jArr[i12] ^ Pack.littleEndianToLong(bArr, i10);
                i10 += 8;
            }
            KangarooPermutation();
        }

        private void KangarooExtract() {
            Pack.longToLittleEndian(this.theState, 0, this.theRateBytes >> 3, this.theQueue, 0);
        }

        private void KangarooPermutation() {
            KangarooSponge kangarooSponge = this;
            long[] jArr = kangarooSponge.theState;
            long j10 = jArr[0];
            boolean z10 = true;
            long j11 = jArr[1];
            long j12 = jArr[2];
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
            long j34 = jArr[24];
            int length = KeccakRoundConstants.length - kangarooSponge.theRounds;
            int i10 = 0;
            while (i10 < kangarooSponge.theRounds) {
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
                long j55 = j12 ^ j42;
                long j56 = j17 ^ j42;
                long j57 = j22 ^ j42;
                long j58 = j27 ^ j42;
                long j59 = j32 ^ j42;
                long j60 = j18 ^ j43;
                long j61 = j23 ^ j43;
                long j62 = j28 ^ j43;
                long j63 = j33 ^ j43;
                long j64 = j14 ^ j44;
                long j65 = j19 ^ j44;
                long j66 = j24 ^ j44;
                long j67 = j29 ^ j44;
                long j68 = j34 ^ j44;
                long j69 = (j50 << z10) | (j50 >>> 63);
                long j70 = (j51 << 44) | (j51 >>> 20);
                long j71 = j13 ^ j43;
                long j72 = (j65 << 20) | (j65 >>> 44);
                int i11 = length;
                long j73 = (j66 << 39) | (j66 >>> 25);
                long j74 = (j57 << 43) | (j57 >>> 21);
                long j75 = (j55 << 62) | (j55 >>> 2);
                long j76 = (j61 << 25) | (j61 >>> 39);
                long j77 = (j49 << 18) | (j49 >>> 46);
                long j78 = (j67 << 8) | (j67 >>> 56);
                long j79 = j48 << 41;
                long j80 = j48 >>> 23;
                long j81 = (j63 << 56) | (j63 >>> 8);
                long j82 = j79 | j80;
                long j83 = (j64 << 27) | (j64 >>> 37);
                long j84 = (j68 << 14) | (j68 >>> 50);
                long j85 = j54 << 2;
                long j86 = j54 >>> 62;
                long j87 = j76;
                long j88 = j85 | j86;
                long j89 = j60 << 55;
                long j90 = j60 >>> 9;
                long j91 = j88;
                long j92 = j89 | j90;
                long j93 = j53 << 45;
                long j94 = j53 >>> 19;
                long j95 = j92;
                long j96 = j93 | j94;
                long j97 = (j59 << 61) | (j59 >>> 3);
                long j98 = (j46 << 36) | (j46 >>> 28);
                long j99 = j62 << 21;
                long j100 = j62 >>> 43;
                long j101 = j96;
                long j102 = j99 | j100;
                long j103 = j58 << 15;
                long j104 = j58 >>> 49;
                long j105 = (j71 << 28) | (j71 >>> 36);
                long j106 = j103 | j104;
                long j107 = j52 << 10;
                long j108 = j52 >>> 54;
                long j109 = j106;
                long j110 = j107 | j108;
                long j111 = j56 << 6;
                long j112 = j56 >>> 58;
                long j113 = j110;
                long j114 = j111 | j112;
                long j115 = j47 << 3;
                long j116 = j47 >>> 61;
                long j117 = j114;
                long j118 = j115 | j116;
                long j119 = ((~j70) & j74) ^ j45;
                long j120 = ((~j74) & j102) ^ j70;
                j12 = j74 ^ ((~j102) & j84);
                long j121 = ((~j84) & j45) ^ j102;
                long j122 = ((~j45) & j70) ^ j84;
                long j123 = j105 ^ ((~j72) & j118);
                long j124 = j118;
                long j125 = ((~j124) & j101) ^ j72;
                long j126 = j121;
                long j127 = j101;
                long j128 = j122;
                long j129 = ((~j127) & j97) ^ j124;
                long j130 = j97;
                long j131 = j129;
                long j132 = j127 ^ ((~j130) & j105);
                long j133 = ((~j105) & j72) ^ j130;
                long j134 = j117;
                j20 = j69 ^ ((~j134) & j87);
                long j135 = j132;
                long j136 = j87;
                long j137 = ((~j136) & j78) ^ j134;
                long j138 = j78;
                long j139 = j133;
                long j140 = ((~j138) & j77) ^ j136;
                long j141 = j77;
                long j142 = j140;
                long j143 = j138 ^ ((~j141) & j69);
                long j144 = ((~j69) & j134) ^ j141;
                long j145 = j98;
                long j146 = j83 ^ ((~j145) & j113);
                long j147 = j143;
                long j148 = j113;
                long j149 = j144;
                long j150 = ((~j148) & j109) ^ j145;
                long j151 = j109;
                long j152 = j123;
                long j153 = j81;
                long j154 = j148 ^ ((~j151) & j81);
                long j155 = ((~j153) & j83) ^ j151;
                long j156 = ((~j83) & j145) ^ j153;
                long j157 = j95;
                j30 = j75 ^ ((~j157) & j73);
                long j158 = j73;
                long j159 = j155;
                long j160 = ((~j158) & j82) ^ j157;
                long j161 = j82;
                long j162 = j156;
                long j163 = ((~j161) & j91) ^ j158;
                long j164 = j91;
                long j165 = j161 ^ ((~j164) & j75);
                long j166 = j119 ^ KeccakRoundConstants[i11 + i10];
                i10++;
                j15 = j152;
                j22 = j142;
                j21 = j137;
                j23 = j147;
                j32 = j163;
                j31 = j160;
                j18 = j135;
                j26 = j150;
                j34 = ((~j75) & j157) ^ j164;
                j10 = j166;
                j27 = j154;
                j11 = j120;
                z10 = true;
                j33 = j165;
                j25 = j146;
                jArr = jArr;
                kangarooSponge = this;
                length = i11;
                j13 = j126;
                j14 = j128;
                j28 = j159;
                j24 = j149;
                j17 = j131;
                j16 = j125;
                long j167 = j162;
                j19 = j139;
                j29 = j167;
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

        /* access modifiers changed from: private */
        public void absorb(byte[] bArr, int i10, int i11) {
            int i12;
            if (!this.squeezing) {
                int i13 = 0;
                while (i13 < i11) {
                    int i14 = this.bytesInQueue;
                    if (i14 != 0 || i13 > i11 - this.theRateBytes) {
                        int min = Math.min(this.theRateBytes - i14, i11 - i13);
                        System.arraycopy(bArr, i10 + i13, this.theQueue, this.bytesInQueue, min);
                        int i15 = this.bytesInQueue + min;
                        this.bytesInQueue = i15;
                        i13 += min;
                        if (i15 == this.theRateBytes) {
                            KangarooAbsorb(this.theQueue, 0);
                            this.bytesInQueue = 0;
                        }
                    } else {
                        do {
                            KangarooAbsorb(bArr, i10 + i13);
                            i12 = this.theRateBytes;
                            i13 += i12;
                        } while (i13 <= i11 - i12);
                    }
                }
                return;
            }
            throw new IllegalStateException("attempt to absorb while squeezing");
        }

        /* access modifiers changed from: private */
        public void initSponge() {
            Arrays.fill(this.theState, 0);
            Arrays.fill(this.theQueue, (byte) 0);
            this.bytesInQueue = 0;
            this.squeezing = false;
        }

        /* access modifiers changed from: private */
        public void padAndSwitchToSqueezingPhase() {
            int i10 = this.bytesInQueue;
            while (true) {
                int i11 = this.theRateBytes;
                if (i10 < i11) {
                    this.theQueue[i10] = 0;
                    i10++;
                } else {
                    byte[] bArr = this.theQueue;
                    int i12 = i11 - 1;
                    bArr[i12] = (byte) (bArr[i12] ^ 128);
                    KangarooAbsorb(bArr, 0);
                    KangarooExtract();
                    this.bytesInQueue = this.theRateBytes;
                    this.squeezing = true;
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        public void squeeze(byte[] bArr, int i10, int i11) {
            if (!this.squeezing) {
                padAndSwitchToSqueezingPhase();
            }
            int i12 = 0;
            while (i12 < i11) {
                if (this.bytesInQueue == 0) {
                    KangarooPermutation();
                    KangarooExtract();
                    this.bytesInQueue = this.theRateBytes;
                }
                int min = Math.min(this.bytesInQueue, i11 - i12);
                System.arraycopy(this.theQueue, this.theRateBytes - this.bytesInQueue, bArr, i10 + i12, min);
                this.bytesInQueue -= min;
                i12 += min;
            }
        }
    }

    public static class KangarooTwelve extends KangarooBase {
        public KangarooTwelve() {
            this(32);
        }

        public KangarooTwelve(int i10) {
            super(128, 12, i10);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i10) {
            return super.doFinal(bArr, i10);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i10, int i11) {
            return super.doFinal(bArr, i10, i11);
        }

        public /* bridge */ /* synthetic */ int doOutput(byte[] bArr, int i10, int i11) {
            return super.doOutput(bArr, i10, i11);
        }

        public String getAlgorithmName() {
            return "KangarooTwelve";
        }

        public /* bridge */ /* synthetic */ int getByteLength() {
            return super.getByteLength();
        }

        public /* bridge */ /* synthetic */ int getDigestSize() {
            return super.getDigestSize();
        }

        public /* bridge */ /* synthetic */ void init(KangarooParameters kangarooParameters) {
            super.init(kangarooParameters);
        }

        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public /* bridge */ /* synthetic */ void update(byte b10) {
            super.update(b10);
        }

        public /* bridge */ /* synthetic */ void update(byte[] bArr, int i10, int i11) {
            super.update(bArr, i10, i11);
        }
    }

    public static class MarsupilamiFourteen extends KangarooBase {
        public MarsupilamiFourteen() {
            this(32);
        }

        public MarsupilamiFourteen(int i10) {
            super(256, 14, i10);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i10) {
            return super.doFinal(bArr, i10);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i10, int i11) {
            return super.doFinal(bArr, i10, i11);
        }

        public /* bridge */ /* synthetic */ int doOutput(byte[] bArr, int i10, int i11) {
            return super.doOutput(bArr, i10, i11);
        }

        public String getAlgorithmName() {
            return "MarsupilamiFourteen";
        }

        public /* bridge */ /* synthetic */ int getByteLength() {
            return super.getByteLength();
        }

        public /* bridge */ /* synthetic */ int getDigestSize() {
            return super.getDigestSize();
        }

        public /* bridge */ /* synthetic */ void init(KangarooParameters kangarooParameters) {
            super.init(kangarooParameters);
        }

        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public /* bridge */ /* synthetic */ void update(byte b10) {
            super.update(b10);
        }

        public /* bridge */ /* synthetic */ void update(byte[] bArr, int i10, int i11) {
            super.update(bArr, i10, i11);
        }
    }
}
