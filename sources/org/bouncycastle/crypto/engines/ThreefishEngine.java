package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.TweakableBlockCipherParameters;

public class ThreefishEngine implements BlockCipher {
    public static final int BLOCKSIZE_1024 = 1024;
    public static final int BLOCKSIZE_256 = 256;
    public static final int BLOCKSIZE_512 = 512;
    private static final long C_240 = 2004413935125273122L;
    private static final int MAX_ROUNDS = 80;
    /* access modifiers changed from: private */
    public static int[] MOD17 = null;
    /* access modifiers changed from: private */
    public static int[] MOD3 = null;
    /* access modifiers changed from: private */
    public static int[] MOD5 = null;
    /* access modifiers changed from: private */
    public static int[] MOD9 = null;
    private static final int ROUNDS_1024 = 80;
    private static final int ROUNDS_256 = 72;
    private static final int ROUNDS_512 = 72;
    private static final int TWEAK_SIZE_BYTES = 16;
    private static final int TWEAK_SIZE_WORDS = 2;
    private int blocksizeBytes;
    private int blocksizeWords;
    private ThreefishCipher cipher;
    private long[] currentBlock;
    private boolean forEncryption;
    private long[] kw;

    /* renamed from: t  reason: collision with root package name */
    private long[] f41436t;

    private static final class Threefish1024Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 24;
        private static final int ROTATION_0_1 = 13;
        private static final int ROTATION_0_2 = 8;
        private static final int ROTATION_0_3 = 47;
        private static final int ROTATION_0_4 = 8;
        private static final int ROTATION_0_5 = 17;
        private static final int ROTATION_0_6 = 22;
        private static final int ROTATION_0_7 = 37;
        private static final int ROTATION_1_0 = 38;
        private static final int ROTATION_1_1 = 19;
        private static final int ROTATION_1_2 = 10;
        private static final int ROTATION_1_3 = 55;
        private static final int ROTATION_1_4 = 49;
        private static final int ROTATION_1_5 = 18;
        private static final int ROTATION_1_6 = 23;
        private static final int ROTATION_1_7 = 52;
        private static final int ROTATION_2_0 = 33;
        private static final int ROTATION_2_1 = 4;
        private static final int ROTATION_2_2 = 51;
        private static final int ROTATION_2_3 = 13;
        private static final int ROTATION_2_4 = 34;
        private static final int ROTATION_2_5 = 41;
        private static final int ROTATION_2_6 = 59;
        private static final int ROTATION_2_7 = 17;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 20;
        private static final int ROTATION_3_2 = 48;
        private static final int ROTATION_3_3 = 41;
        private static final int ROTATION_3_4 = 47;
        private static final int ROTATION_3_5 = 28;
        private static final int ROTATION_3_6 = 16;
        private static final int ROTATION_3_7 = 25;
        private static final int ROTATION_4_0 = 41;
        private static final int ROTATION_4_1 = 9;
        private static final int ROTATION_4_2 = 37;
        private static final int ROTATION_4_3 = 31;
        private static final int ROTATION_4_4 = 12;
        private static final int ROTATION_4_5 = 47;
        private static final int ROTATION_4_6 = 44;
        private static final int ROTATION_4_7 = 30;
        private static final int ROTATION_5_0 = 16;
        private static final int ROTATION_5_1 = 34;
        private static final int ROTATION_5_2 = 56;
        private static final int ROTATION_5_3 = 51;
        private static final int ROTATION_5_4 = 4;
        private static final int ROTATION_5_5 = 53;
        private static final int ROTATION_5_6 = 42;
        private static final int ROTATION_5_7 = 41;
        private static final int ROTATION_6_0 = 31;
        private static final int ROTATION_6_1 = 44;
        private static final int ROTATION_6_2 = 47;
        private static final int ROTATION_6_3 = 46;
        private static final int ROTATION_6_4 = 19;
        private static final int ROTATION_6_5 = 42;
        private static final int ROTATION_6_6 = 44;
        private static final int ROTATION_6_7 = 25;
        private static final int ROTATION_7_0 = 9;
        private static final int ROTATION_7_1 = 48;
        private static final int ROTATION_7_2 = 35;
        private static final int ROTATION_7_3 = 52;
        private static final int ROTATION_7_4 = 23;
        private static final int ROTATION_7_5 = 31;
        private static final int ROTATION_7_6 = 37;
        private static final int ROTATION_7_7 = 20;

        public Threefish1024Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        /* JADX WARNING: type inference failed for: r77v0, types: [long[]] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void decryptBlock(long[] r76, long[] r77) {
            /*
                r75 = this;
                r0 = r75
                long[] r1 = r0.kw
                long[] r2 = r0.f41437t
                int[] r3 = org.bouncycastle.crypto.engines.ThreefishEngine.MOD17
                int[] r4 = org.bouncycastle.crypto.engines.ThreefishEngine.MOD3
                int r5 = r1.length
                r6 = 33
                if (r5 != r6) goto L_0x04fa
                int r5 = r2.length
                r6 = 5
                if (r5 != r6) goto L_0x04f4
                r5 = 0
                r7 = r76[r5]
                r9 = 1
                r10 = r76[r9]
                r12 = 2
                r13 = r76[r12]
                r15 = 3
                r16 = r76[r15]
                r15 = 4
                r18 = r76[r15]
                r20 = r76[r6]
                r22 = 6
                r23 = r76[r22]
                r25 = 7
                r26 = r76[r25]
                r12 = 8
                r28 = r76[r12]
                r5 = 9
                r30 = r76[r5]
                r12 = 10
                r32 = r76[r12]
                r34 = 11
                r35 = r76[r34]
                r12 = 12
                r37 = r76[r12]
                r6 = 13
                r39 = r76[r6]
                r41 = 14
                r42 = r76[r41]
                r44 = 15
                r45 = r76[r44]
                r12 = 19
            L_0x0052:
                if (r12 < r9) goto L_0x046c
                r47 = r3[r12]
                r48 = r4[r12]
                int r49 = r47 + 1
                r50 = r1[r49]
                long r7 = r7 - r50
                int r50 = r47 + 2
                r51 = r1[r50]
                long r10 = r10 - r51
                int r51 = r47 + 3
                r52 = r1[r51]
                long r13 = r13 - r52
                int r52 = r47 + 4
                r53 = r1[r52]
                r55 = r10
                long r9 = r16 - r53
                int r11 = r47 + 5
                r16 = r1[r11]
                long r5 = r18 - r16
                int r16 = r47 + 6
                r18 = r1[r16]
                r54 = r3
                r57 = r4
                long r3 = r20 - r18
                int r17 = r47 + 7
                r18 = r1[r17]
                r58 = r9
                long r9 = r23 - r18
                int r18 = r47 + 8
                r19 = r1[r18]
                r60 = r3
                long r3 = r26 - r19
                int r19 = r47 + 9
                r20 = r1[r19]
                r23 = r3
                long r3 = r28 - r20
                int r20 = r47 + 10
                r26 = r1[r20]
                r28 = r3
                long r3 = r30 - r26
                int r21 = r47 + 11
                r26 = r1[r21]
                r30 = r3
                long r3 = r32 - r26
                int r26 = r47 + 12
                r32 = r1[r26]
                r62 = r3
                long r3 = r35 - r32
                int r27 = r47 + 13
                r32 = r1[r27]
                r64 = r5
                long r5 = r37 - r32
                int r32 = r47 + 14
                r35 = r1[r32]
                int r33 = r48 + 1
                r37 = r2[r33]
                long r35 = r35 + r37
                r37 = r5
                long r5 = r39 - r35
                int r35 = r47 + 15
                r39 = r1[r35]
                int r36 = r48 + 2
                r66 = r2[r36]
                long r39 = r39 + r66
                r66 = r5
                long r5 = r42 - r39
                int r36 = r47 + 16
                r39 = r1[r36]
                r68 = r1
                long r0 = (long) r12
                long r39 = r39 + r0
                r42 = 1
                long r39 = r39 + r42
                r42 = r0
                long r0 = r45 - r39
                r15 = 9
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r15, r7)
                long r7 = r7 - r0
                r15 = 48
                long r3 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r3, r15, r13)
                long r13 = r13 - r3
                r15 = 35
                r70 = r11
                r69 = r12
                r11 = r66
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r15, r9)
                long r9 = r9 - r11
                r15 = 52
                r66 = r2
                r39 = r3
                r2 = r64
                r73 = r11
                r11 = r30
                r30 = r73
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r15, r2)
                long r2 = r2 - r11
                r4 = 23
                r45 = r11
                r11 = r55
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r4, r5)
                long r5 = r5 - r11
                r4 = 31
                r55 = r5
                r5 = r60
                r73 = r0
                r0 = r28
                r28 = r73
                long r5 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r5, r4, r0)
                long r0 = r0 - r5
                r15 = 37
                r60 = r5
                r4 = r58
                r58 = r0
                r0 = r62
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r15, r0)
                long r0 = r0 - r4
                r6 = 20
                r62 = r0
                r0 = r23
                r23 = r9
                r9 = r37
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r9)
                long r9 = r9 - r0
                r6 = 31
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r7)
                long r7 = r7 - r0
                r6 = 44
                r37 = r0
                r0 = r60
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r13)
                long r13 = r13 - r0
                r6 = 47
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r2)
                long r2 = r2 - r4
                r6 = 46
                r64 = r0
                r0 = r23
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r0)
                long r0 = r0 - r11
                r23 = r11
                r11 = r28
                r6 = 19
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r9)
                long r9 = r9 - r11
                r6 = 42
                r28 = r4
                r4 = r30
                r30 = r9
                r9 = r55
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r6 = 44
                r55 = r9
                r9 = r39
                r39 = r2
                r2 = r58
                long r9 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r2)
                long r2 = r2 - r9
                r6 = 25
                r58 = r2
                r2 = r45
                r45 = r11
                r11 = r62
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r11)
                long r11 = r11 - r2
                r6 = 16
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r7)
                long r7 = r7 - r2
                r6 = 34
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r13)
                long r13 = r13 - r4
                r6 = 56
                long r9 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r0)
                long r0 = r0 - r9
                r6 = 51
                r62 = r4
                r4 = r39
                r39 = r9
                r9 = r45
                long r9 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r4)
                long r4 = r4 - r9
                r45 = r9
                r9 = r37
                r6 = 4
                long r9 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r11)
                long r11 = r11 - r9
                r6 = 53
                r37 = r11
                r11 = r28
                r28 = r2
                r2 = r30
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r2)
                long r2 = r2 - r11
                r6 = 42
                r30 = r2
                r2 = r64
                r73 = r0
                r0 = r55
                r55 = r73
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r0)
                long r0 = r0 - r2
                r6 = 41
                r64 = r0
                r0 = r23
                r23 = r9
                r9 = r58
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r9)
                long r9 = r9 - r0
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r7)
                long r7 = r7 - r0
                r6 = 9
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r13)
                long r13 = r13 - r11
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r15, r4)
                long r4 = r4 - r2
                r71 = r2
                r2 = r55
                r6 = 31
                r73 = r4
                r4 = r23
                r23 = r73
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r2)
                long r2 = r2 - r4
                r55 = r4
                r4 = r28
                r6 = 12
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r28 = r4
                r4 = r39
                r6 = 47
                r73 = r9
                r9 = r37
                r37 = r73
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r6 = 44
                r39 = r4
                r4 = r62
                r73 = r9
                r9 = r30
                r30 = r73
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r6 = 30
                r62 = r4
                r4 = r45
                r45 = r9
                r9 = r64
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r64 = r68[r47]
                long r7 = r7 - r64
                r64 = r68[r49]
                long r0 = r0 - r64
                r49 = r68[r50]
                long r13 = r13 - r49
                r49 = r68[r51]
                long r11 = r11 - r49
                r49 = r68[r52]
                r51 = r11
                long r11 = r23 - r49
                r23 = r68[r70]
                r49 = r0
                long r0 = r71 - r23
                r23 = r68[r16]
                long r2 = r2 - r23
                r16 = r68[r17]
                r23 = r0
                long r0 = r55 - r16
                r16 = r68[r18]
                r55 = r0
                long r0 = r37 - r16
                r16 = r68[r19]
                r18 = r0
                long r0 = r28 - r16
                r16 = r68[r20]
                r28 = r0
                long r0 = r30 - r16
                r16 = r68[r21]
                r20 = r0
                long r0 = r39 - r16
                r16 = r68[r26]
                r30 = r11
                long r11 = r45 - r16
                r16 = r68[r27]
                r26 = r66[r48]
                long r16 = r16 + r26
                r26 = r11
                long r11 = r62 - r16
                r16 = r68[r32]
                r32 = r66[r33]
                long r16 = r16 + r32
                long r9 = r9 - r16
                r16 = r68[r35]
                long r16 = r16 + r42
                long r4 = r4 - r16
                r6 = 5
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r7)
                long r7 = r7 - r4
                r6 = 20
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r13)
                long r13 = r13 - r0
                r6 = 48
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r2)
                long r2 = r2 - r11
                r16 = r0
                r0 = r30
                r6 = 41
                r73 = r11
                r11 = r28
                r28 = r73
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r0)
                long r0 = r0 - r11
                r30 = r11
                r11 = r49
                r6 = 47
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r9)
                long r9 = r9 - r11
                r6 = 28
                r32 = r9
                r9 = r23
                r73 = r4
                r4 = r18
                r18 = r73
                long r9 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r4)
                long r4 = r4 - r9
                r23 = r4
                r4 = r51
                r6 = 16
                r73 = r2
                r2 = r20
                r20 = r73
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r2)
                long r2 = r2 - r4
                r6 = 25
                r35 = r2
                r2 = r55
                r73 = r11
                r11 = r26
                r26 = r73
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r11)
                long r11 = r11 - r2
                r6 = 33
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r7)
                long r7 = r7 - r2
                r6 = 4
                long r9 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r13)
                long r13 = r13 - r9
                r6 = 51
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r0)
                long r0 = r0 - r4
                r37 = r9
                r9 = r20
                r6 = 13
                r20 = r4
                r4 = r26
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r6 = 34
                r26 = r4
                r4 = r18
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r11)
                long r11 = r11 - r4
                r18 = r11
                r11 = r28
                r6 = 41
                r28 = r2
                r2 = r32
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r2)
                long r2 = r2 - r11
                r6 = 59
                r32 = r2
                r2 = r16
                r16 = r0
                r0 = r23
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r0)
                long r0 = r0 - r2
                r6 = 17
                r23 = r0
                r0 = r30
                r30 = r4
                r4 = r35
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r4)
                long r4 = r4 - r0
                r6 = 38
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r7)
                long r7 = r7 - r0
                r6 = 19
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r13)
                long r13 = r13 - r11
                r6 = 10
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r9)
                long r9 = r9 - r2
                r6 = 55
                r35 = r11
                r11 = r16
                r16 = r2
                r2 = r30
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r11)
                long r11 = r11 - r2
                r6 = 49
                r30 = r2
                r2 = r28
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r4)
                long r4 = r4 - r2
                r6 = 18
                r28 = r4
                r4 = r20
                r73 = r0
                r0 = r18
                r18 = r73
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r0)
                long r0 = r0 - r4
                r6 = 23
                r20 = r0
                r0 = r37
                r73 = r2
                r2 = r32
                r32 = r73
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r2)
                long r2 = r2 - r0
                r6 = 52
                r37 = r2
                r2 = r26
                r73 = r9
                r9 = r23
                r23 = r73
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r9)
                long r9 = r9 - r2
                r6 = 24
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r7)
                long r7 = r7 - r2
                r6 = 13
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r13)
                long r13 = r13 - r4
                r6 = 8
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r11)
                long r11 = r11 - r0
                r26 = r7
                r6 = r23
                r8 = 47
                r23 = r0
                r0 = r32
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r8, r6)
                long r6 = r6 - r0
                r32 = r0
                r0 = r18
                r8 = 8
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r8, r9)
                long r8 = r9 - r0
                r10 = 17
                r18 = r0
                r0 = r16
                r16 = r2
                r2 = r28
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r10, r2)
                long r2 = r2 - r0
                r10 = 22
                r28 = r0
                r0 = r35
                r73 = r2
                r2 = r20
                r20 = r73
                long r39 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r10, r2)
                long r0 = r2 - r39
                r2 = r30
                r30 = r0
                r0 = r37
                long r45 = org.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r15, r0)
                long r42 = r0 - r45
                int r0 = r69 + -2
                r35 = r28
                r37 = r30
                r3 = r54
                r2 = r66
                r1 = r68
                r15 = 4
                r28 = r8
                r30 = r18
                r9 = 1
                r18 = r11
                r10 = r16
                r12 = r0
                r16 = r4
                r4 = r57
                r5 = 9
                r0 = r75
                r73 = r26
                r26 = r32
                r32 = r20
                r20 = r23
                r23 = r6
                r7 = r73
                goto L_0x0052
            L_0x046c:
                r68 = r1
                r66 = r2
                r0 = 0
                r1 = r68[r0]
                long r7 = r7 - r1
                r0 = 1
                r1 = r68[r0]
                long r10 = r10 - r1
                r0 = 2
                r1 = r68[r0]
                long r13 = r13 - r1
                r0 = 3
                r1 = r68[r0]
                long r16 = r16 - r1
                r0 = 4
                r1 = r68[r0]
                long r18 = r18 - r1
                r0 = 5
                r1 = r68[r0]
                long r20 = r20 - r1
                r0 = r68[r22]
                long r23 = r23 - r0
                r0 = r68[r25]
                long r26 = r26 - r0
                r0 = 8
                r1 = r68[r0]
                long r28 = r28 - r1
                r0 = 9
                r1 = r68[r0]
                long r30 = r30 - r1
                r0 = 10
                r1 = r68[r0]
                long r32 = r32 - r1
                r0 = r68[r34]
                long r35 = r35 - r0
                r0 = 12
                r1 = r68[r0]
                long r37 = r37 - r1
                r0 = 13
                r1 = r68[r0]
                r0 = 0
                r3 = r66[r0]
                long r1 = r1 + r3
                long r39 = r39 - r1
                r1 = r68[r41]
                r3 = 1
                r4 = r66[r3]
                long r1 = r1 + r4
                long r42 = r42 - r1
                r1 = r68[r44]
                long r45 = r45 - r1
                r77[r0] = r7
                r77[r3] = r10
                r0 = 2
                r77[r0] = r13
                r0 = 3
                r77[r0] = r16
                r0 = 4
                r77[r0] = r18
                r0 = 5
                r77[r0] = r20
                r77[r22] = r23
                r77[r25] = r26
                r0 = 8
                r77[r0] = r28
                r0 = 9
                r77[r0] = r30
                r0 = 10
                r77[r0] = r32
                r77[r34] = r35
                r0 = 12
                r77[r0] = r37
                r0 = 13
                r77[r0] = r39
                r77[r41] = r42
                r77[r44] = r45
                return
            L_0x04f4:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            L_0x04fa:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.engines.ThreefishEngine.Threefish1024Cipher.decryptBlock(long[], long[]):void");
        }

        /* JADX WARNING: type inference failed for: r87v0, types: [long[]] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void encryptBlock(long[] r86, long[] r87) {
            /*
                r85 = this;
                r0 = r85
                long[] r1 = r0.kw
                long[] r2 = r0.f41437t
                int[] r3 = org.bouncycastle.crypto.engines.ThreefishEngine.MOD17
                int[] r4 = org.bouncycastle.crypto.engines.ThreefishEngine.MOD3
                int r5 = r1.length
                r6 = 33
                if (r5 != r6) goto L_0x04cb
                int r5 = r2.length
                r6 = 5
                if (r5 != r6) goto L_0x04c5
                r5 = 0
                r7 = r86[r5]
                r9 = 1
                r10 = r86[r9]
                r12 = 2
                r13 = r86[r12]
                r15 = 3
                r16 = r86[r15]
                r15 = 4
                r19 = r86[r15]
                r21 = r86[r6]
                r23 = 6
                r24 = r86[r23]
                r26 = 7
                r27 = r86[r26]
                r6 = 8
                r30 = r86[r6]
                r6 = 9
                r33 = r86[r6]
                r6 = 10
                r36 = r86[r6]
                r38 = 11
                r39 = r86[r38]
                r6 = 12
                r42 = r86[r6]
                r6 = 13
                r45 = r86[r6]
                r47 = 14
                r48 = r86[r47]
                r50 = 15
                r51 = r86[r50]
                r53 = r1[r5]
                long r7 = r7 + r53
                r53 = r1[r9]
                long r10 = r10 + r53
                r53 = r1[r12]
                long r13 = r13 + r53
                r18 = 3
                r53 = r1[r18]
                long r16 = r16 + r53
                r53 = r1[r15]
                long r19 = r19 + r53
                r29 = 5
                r53 = r1[r29]
                long r21 = r21 + r53
                r53 = r1[r23]
                long r24 = r24 + r53
                r53 = r1[r26]
                long r27 = r27 + r53
                r32 = 8
                r53 = r1[r32]
                long r30 = r30 + r53
                r35 = 9
                r53 = r1[r35]
                long r33 = r33 + r53
                r41 = 10
                r53 = r1[r41]
                long r36 = r36 + r53
                r53 = r1[r38]
                long r39 = r39 + r53
                r44 = 12
                r53 = r1[r44]
                long r42 = r42 + r53
                r53 = r1[r6]
                r55 = r2[r5]
                long r53 = r53 + r55
                long r45 = r45 + r53
                r53 = r1[r47]
                r55 = r2[r9]
                long r53 = r53 + r55
                long r48 = r48 + r53
                r53 = r1[r50]
                long r51 = r51 + r53
                r5 = r16
                r57 = r21
                r59 = r27
                r61 = r33
                r63 = r39
                r65 = r45
                r67 = r51
            L_0x00b2:
                r12 = 20
                if (r9 >= r12) goto L_0x0486
                r27 = r3[r9]
                r28 = r4[r9]
                r12 = 24
                long r7 = r7 + r10
                long r10 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r12, r7)
                long r13 = r13 + r5
                r12 = 13
                long r5 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r12, r13)
                r12 = r1
                r33 = r3
                r34 = r4
                r3 = r57
                long r0 = r19 + r3
                r15 = 8
                long r3 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r3, r15, r0)
                r40 = r9
                r45 = r10
                r51 = r12
                r9 = r59
                long r11 = r24 + r9
                r15 = 47
                long r9 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r9, r15, r11)
                r52 = r2
                r19 = r3
                r53 = r5
                r2 = r61
                long r4 = r30 + r2
                r6 = 8
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r4)
                r6 = 17
                r24 = r4
                r55 = r9
                r4 = r63
                long r9 = r36 + r4
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r4, r6, r9)
                r6 = 22
                r57 = r0
                r30 = r9
                r9 = r65
                long r0 = r42 + r9
                long r9 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r9, r6, r0)
                r36 = r0
                r59 = r4
                r0 = r67
                long r4 = r48 + r0
                r6 = 37
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r4)
                r6 = 38
                long r7 = r7 + r2
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r7)
                r6 = 19
                long r13 = r13 + r9
                long r9 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r9, r6, r13)
                long r11 = r11 + r59
                r48 = r2
                r2 = r59
                r6 = 10
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r11)
                r6 = 55
                r59 = r2
                long r2 = r57 + r0
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r2)
                r6 = 49
                r57 = r9
                long r9 = r30 + r55
                r30 = r0
                r0 = r55
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r9)
                r6 = 18
                r55 = r9
                long r9 = r36 + r53
                r36 = r11
                r11 = r53
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r11, r6, r9)
                r6 = 23
                long r4 = r4 + r19
                r53 = r9
                r9 = r19
                long r9 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r9, r6, r4)
                r6 = 52
                r19 = r4
                long r4 = r24 + r45
                r24 = r2
                r2 = r45
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r4)
                r6 = 33
                long r7 = r7 + r0
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r7)
                long r13 = r13 + r9
                r6 = 4
                long r9 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r9, r6, r13)
                r6 = 51
                r45 = r0
                long r0 = r24 + r11
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r11, r6, r0)
                r24 = r11
                long r11 = r36 + r2
                r6 = 13
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r11)
                r6 = 34
                r36 = r9
                long r9 = r53 + r30
                r53 = r2
                r2 = r30
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r9)
                r30 = r9
                long r9 = r19 + r57
                r6 = 41
                r19 = r0
                r0 = r57
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r9)
                r15 = 59
                long r4 = r4 + r59
                r61 = r7
                r6 = r59
                long r6 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r15, r4)
                r15 = 17
                r58 = r9
                long r8 = r55 + r48
                r55 = r11
                r10 = r48
                long r10 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r15, r8)
                r48 = r8
                long r8 = r61 + r2
                r15 = 5
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r15, r8)
                long r13 = r13 + r6
                r15 = 20
                long r6 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r15, r13)
                r15 = 48
                r60 = r13
                long r12 = r55 + r0
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r15, r12)
                long r14 = r19 + r10
                r19 = r2
                r2 = 41
                long r10 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r2, r14)
                long r2 = r58 + r53
                r55 = r0
                r0 = r53
                r53 = r6
                r6 = 47
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r2)
                r6 = 28
                long r4 = r4 + r36
                r58 = r2
                r2 = r36
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r4)
                long r6 = r48 + r24
                r36 = r10
                r10 = 16
                r48 = r4
                r4 = r24
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r4, r10, r6)
                r11 = 25
                r24 = r6
                long r6 = r30 + r45
                r30 = r12
                r12 = r45
                long r11 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r11, r6)
                r45 = r51[r27]
                long r8 = r8 + r45
                int r13 = r27 + 1
                r45 = r51[r13]
                long r0 = r0 + r45
                int r45 = r27 + 2
                r62 = r51[r45]
                long r60 = r60 + r62
                int r46 = r27 + 3
                r62 = r51[r46]
                long r4 = r4 + r62
                int r62 = r27 + 4
                r63 = r51[r62]
                long r14 = r14 + r63
                int r63 = r27 + 5
                r64 = r51[r63]
                long r2 = r2 + r64
                int r64 = r27 + 6
                r65 = r51[r64]
                long r30 = r30 + r65
                int r65 = r27 + 7
                r66 = r51[r65]
                long r11 = r11 + r66
                int r66 = r27 + 8
                r67 = r51[r66]
                long r48 = r48 + r67
                int r67 = r27 + 9
                r68 = r51[r67]
                r70 = r11
                long r10 = r36 + r68
                int r12 = r27 + 10
                r36 = r51[r12]
                long r24 = r24 + r36
                int r36 = r27 + 11
                r68 = r51[r36]
                r72 = r12
                r37 = r13
                long r12 = r53 + r68
                int r53 = r27 + 12
                r68 = r51[r53]
                long r6 = r6 + r68
                int r54 = r27 + 13
                r68 = r51[r54]
                r73 = r52[r28]
                long r68 = r68 + r73
                r73 = r6
                long r6 = r55 + r68
                int r55 = r27 + 14
                r68 = r51[r55]
                int r56 = r28 + 1
                r75 = r52[r56]
                long r68 = r68 + r75
                long r58 = r58 + r68
                int r68 = r27 + 15
                r75 = r51[r68]
                r77 = r6
                r79 = r12
                r6 = r40
                long r12 = (long) r6
                long r75 = r75 + r12
                long r6 = r19 + r75
                long r8 = r8 + r0
                r19 = r12
                r12 = 41
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r12, r8)
                r12 = r8
                long r8 = r60 + r4
                r60 = r0
                r0 = 9
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r4, r0, r8)
                long r14 = r14 + r2
                r0 = 37
                long r1 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r0, r14)
                r75 = r1
                long r0 = r30 + r70
                r2 = 31
                r30 = r4
                r3 = r70
                long r3 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r3, r2, r0)
                r70 = r3
                long r2 = r48 + r10
                r4 = 12
                long r10 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r4, r2)
                r48 = r6
                long r5 = r24 + r79
                r24 = r2
                r2 = r79
                r7 = 47
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r7, r5)
                r7 = 44
                r79 = r5
                long r4 = r73 + r77
                r73 = r14
                r14 = r77
                long r6 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r7, r4)
                r14 = 30
                r77 = r4
                long r4 = r58 + r48
                r58 = r0
                r0 = r48
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r14, r4)
                long r12 = r12 + r10
                r14 = 16
                long r10 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r14, r12)
                r14 = 34
                long r8 = r8 + r6
                long r6 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r14, r8)
                r14 = 56
                r48 = r10
                long r10 = r58 + r2
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r14, r10)
                r14 = 51
                r58 = r2
                long r2 = r73 + r0
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r14, r2)
                long r14 = r79 + r70
                r73 = r6
                r6 = r70
                r70 = r0
                r0 = 4
                long r6 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r0, r14)
                r0 = 53
                r79 = r14
                long r14 = r77 + r30
                r77 = r10
                r10 = r30
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r0, r14)
                r10 = 42
                long r4 = r4 + r75
                r30 = r14
                r14 = r75
                long r10 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r10, r4)
                long r14 = r24 + r60
                r24 = r4
                r4 = r60
                r60 = r0
                r0 = 41
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r4, r0, r14)
                long r12 = r12 + r6
                r4 = 31
                long r6 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r4, r12)
                r4 = 44
                long r8 = r8 + r10
                long r10 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r4, r8)
                long r2 = r2 + r60
                r75 = r6
                r5 = r60
                r7 = 47
                long r5 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r7, r2)
                r7 = 46
                r60 = r5
                long r4 = r77 + r0
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r7, r4)
                r6 = 19
                r77 = r10
                long r10 = r30 + r70
                r30 = r0
                r0 = r70
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r10)
                r6 = 42
                r70 = r10
                long r10 = r24 + r73
                r24 = r2
                r2 = r73
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r10)
                r6 = 44
                long r14 = r14 + r58
                r73 = r10
                r10 = r58
                long r6 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r6, r14)
                r10 = 25
                r57 = r14
                long r14 = r79 + r48
                r79 = r2
                r2 = r48
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r10, r14)
                long r12 = r12 + r0
                r10 = 9
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r10, r12)
                r10 = 48
                long r8 = r8 + r6
                long r6 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r10, r8)
                r10 = 35
                long r4 = r4 + r79
                r48 = r0
                r0 = r79
                long r0 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r10, r4)
                r10 = 52
                r79 = r0
                long r0 = r24 + r2
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r10, r0)
                r10 = 23
                r24 = r6
                long r6 = r73 + r30
                r73 = r2
                r2 = r30
                long r2 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r10, r6)
                long r10 = r57 + r77
                r57 = r4
                r30 = r6
                r6 = r77
                r4 = 31
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r4, r10)
                long r14 = r14 + r60
                r42 = r10
                r6 = r60
                r10 = 37
                long r6 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r10, r14)
                long r10 = r70 + r75
                r70 = r4
                r59 = r14
                r14 = r75
                r4 = 20
                long r4 = org.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r4, r10)
                r14 = r51[r37]
                long r12 = r12 + r14
                r14 = r51[r45]
                long r2 = r2 + r14
                r14 = r51[r46]
                long r8 = r8 + r14
                r14 = r51[r62]
                long r6 = r6 + r14
                r14 = r51[r63]
                long r0 = r0 + r14
                r14 = r51[r64]
                long r14 = r70 + r14
                r45 = r51[r65]
                long r45 = r57 + r45
                r57 = r51[r66]
                long r4 = r4 + r57
                r57 = r51[r67]
                long r42 = r42 + r57
                r57 = r51[r72]
                long r61 = r73 + r57
                r36 = r51[r36]
                long r36 = r59 + r36
                r57 = r51[r53]
                long r63 = r24 + r57
                r24 = r51[r54]
                long r10 = r10 + r24
                r24 = r51[r55]
                r53 = r52[r56]
                long r24 = r24 + r53
                long r65 = r79 + r24
                r24 = r51[r68]
                r22 = 2
                int r28 = r28 + 2
                r53 = r52[r28]
                long r24 = r24 + r53
                long r24 = r30 + r24
                r28 = 16
                int r27 = r27 + 16
                r27 = r51[r27]
                long r27 = r27 + r19
                r19 = 1
                long r27 = r27 + r19
                long r67 = r48 + r27
                int r19 = r40 + 2
                r59 = r4
                r5 = r6
                r57 = r14
                r48 = r24
                r4 = r34
                r30 = r42
                r24 = r45
                r15 = 4
                r42 = r10
                r10 = r2
                r3 = r33
                r2 = r52
                r81 = r0
                r0 = r85
                r1 = r51
                r83 = r8
                r9 = r19
                r19 = r81
                r7 = r12
                r13 = r83
                goto L_0x00b2
            L_0x0486:
                r15 = r5
                r11 = r10
                r27 = r57
                r45 = r59
                r2 = r61
                r4 = r63
                r9 = r65
                r0 = r67
                r6 = 0
                r87[r6] = r7
                r6 = 1
                r87[r6] = r11
                r6 = 2
                r87[r6] = r13
                r6 = 3
                r87[r6] = r15
                r6 = 4
                r87[r6] = r19
                r6 = 5
                r87[r6] = r27
                r87[r23] = r24
                r87[r26] = r45
                r6 = 8
                r87[r6] = r30
                r6 = 9
                r87[r6] = r2
                r2 = 10
                r87[r2] = r36
                r87[r38] = r4
                r2 = 12
                r87[r2] = r42
                r2 = 13
                r87[r2] = r9
                r87[r47] = r48
                r87[r50] = r0
                return
            L_0x04c5:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            L_0x04cb:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.engines.ThreefishEngine.Threefish1024Cipher.encryptBlock(long[], long[]):void");
        }
    }

    private static final class Threefish256Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 14;
        private static final int ROTATION_0_1 = 16;
        private static final int ROTATION_1_0 = 52;
        private static final int ROTATION_1_1 = 57;
        private static final int ROTATION_2_0 = 23;
        private static final int ROTATION_2_1 = 40;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 37;
        private static final int ROTATION_4_0 = 25;
        private static final int ROTATION_4_1 = 33;
        private static final int ROTATION_5_0 = 46;
        private static final int ROTATION_5_1 = 12;
        private static final int ROTATION_6_0 = 58;
        private static final int ROTATION_6_1 = 22;
        private static final int ROTATION_7_0 = 32;
        private static final int ROTATION_7_1 = 32;

        public Threefish256Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        /* access modifiers changed from: package-private */
        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.f41437t;
            int[] access$000 = ThreefishEngine.MOD5;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                boolean z10 = false;
                long j10 = jArr[0];
                long j11 = jArr[1];
                long j12 = jArr[2];
                long j13 = jArr[3];
                int i10 = 17;
                for (int i11 = 1; i10 >= i11; i11 = 1) {
                    int i12 = access$000[i10];
                    int i13 = access$100[i10];
                    int i14 = i12 + 1;
                    long j14 = j10 - jArr3[i14];
                    int i15 = i12 + 2;
                    int i16 = i13 + 1;
                    long j15 = j11 - (jArr3[i15] + jArr4[i16]);
                    int i17 = i12 + 3;
                    long j16 = j12 - (jArr3[i17] + jArr4[i13 + 2]);
                    long j17 = (long) i10;
                    long xorRotr = ThreefishEngine.xorRotr(j13 - ((jArr3[i12 + 4] + j17) + 1), 32, j14);
                    long j18 = j14 - xorRotr;
                    int[] iArr = access$000;
                    long xorRotr2 = ThreefishEngine.xorRotr(j15, 32, j16);
                    long j19 = j16 - xorRotr2;
                    long xorRotr3 = ThreefishEngine.xorRotr(xorRotr2, 58, j18);
                    long j20 = j18 - xorRotr3;
                    long xorRotr4 = ThreefishEngine.xorRotr(xorRotr, 22, j19);
                    long j21 = j19 - xorRotr4;
                    long xorRotr5 = ThreefishEngine.xorRotr(xorRotr4, 46, j20);
                    long j22 = j20 - xorRotr5;
                    long xorRotr6 = ThreefishEngine.xorRotr(xorRotr3, 12, j21);
                    long j23 = j21 - xorRotr6;
                    long xorRotr7 = ThreefishEngine.xorRotr(xorRotr6, 25, j22);
                    long xorRotr8 = ThreefishEngine.xorRotr(xorRotr5, 33, j23);
                    long j24 = (j22 - xorRotr7) - jArr3[i12];
                    long j25 = xorRotr7 - (jArr3[i14] + jArr4[i13]);
                    long j26 = (j23 - xorRotr8) - (jArr3[i15] + jArr4[i16]);
                    long xorRotr9 = ThreefishEngine.xorRotr(xorRotr8 - (jArr3[i17] + j17), 5, j24);
                    long j27 = j24 - xorRotr9;
                    long xorRotr10 = ThreefishEngine.xorRotr(j25, 37, j26);
                    long j28 = j26 - xorRotr10;
                    long xorRotr11 = ThreefishEngine.xorRotr(xorRotr10, 23, j27);
                    long j29 = j27 - xorRotr11;
                    long xorRotr12 = ThreefishEngine.xorRotr(xorRotr9, 40, j28);
                    long j30 = j28 - xorRotr12;
                    long xorRotr13 = ThreefishEngine.xorRotr(xorRotr12, 52, j29);
                    long j31 = j29 - xorRotr13;
                    long xorRotr14 = ThreefishEngine.xorRotr(xorRotr11, 57, j30);
                    long j32 = j30 - xorRotr14;
                    long xorRotr15 = ThreefishEngine.xorRotr(xorRotr14, 14, j31);
                    j10 = j31 - xorRotr15;
                    j13 = ThreefishEngine.xorRotr(xorRotr13, 16, j32);
                    j12 = j32 - j13;
                    i10 -= 2;
                    j11 = xorRotr15;
                    access$000 = iArr;
                    access$100 = access$100;
                    z10 = false;
                }
                char c10 = z10;
                long j33 = j11 - (jArr3[1] + jArr4[c10]);
                long j34 = j12 - (jArr3[2] + jArr4[1]);
                jArr2[c10] = j10 - jArr3[c10];
                jArr2[1] = j33;
                jArr2[2] = j34;
                jArr2[3] = j13 - jArr3[3];
            } else {
                throw new IllegalArgumentException();
            }
        }

        /* access modifiers changed from: package-private */
        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.f41437t;
            int[] access$000 = ThreefishEngine.MOD5;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j10 = jArr[0];
                long j11 = jArr[1];
                long j12 = jArr[2];
                long j13 = jArr[3];
                long j14 = j10 + jArr3[0];
                long j15 = j11 + jArr3[1] + jArr4[0];
                long j16 = j12 + jArr3[2] + jArr4[1];
                int i10 = 1;
                long j17 = j13 + jArr3[3];
                while (i10 < 18) {
                    int i11 = access$000[i10];
                    int i12 = access$100[i10];
                    long j18 = j14 + j15;
                    long rotlXor = ThreefishEngine.rotlXor(j15, 14, j18);
                    long j19 = j16 + j17;
                    long rotlXor2 = ThreefishEngine.rotlXor(j17, 16, j19);
                    long j20 = j18 + rotlXor2;
                    long rotlXor3 = ThreefishEngine.rotlXor(rotlXor2, 52, j20);
                    long j21 = j19 + rotlXor;
                    long rotlXor4 = ThreefishEngine.rotlXor(rotlXor, 57, j21);
                    long j22 = j20 + rotlXor4;
                    long rotlXor5 = ThreefishEngine.rotlXor(rotlXor4, 23, j22);
                    long j23 = j21 + rotlXor3;
                    long rotlXor6 = ThreefishEngine.rotlXor(rotlXor3, 40, j23);
                    long j24 = j22 + rotlXor6;
                    long rotlXor7 = ThreefishEngine.rotlXor(rotlXor6, 5, j24);
                    long j25 = j23 + rotlXor5;
                    long rotlXor8 = ThreefishEngine.rotlXor(rotlXor5, 37, j25);
                    long j26 = j24 + jArr3[i11];
                    int i13 = i11 + 1;
                    long j27 = rotlXor8 + jArr3[i13] + jArr4[i12];
                    int i14 = i11 + 2;
                    int i15 = i12 + 1;
                    long j28 = j25 + jArr3[i14] + jArr4[i15];
                    int i16 = i11 + 3;
                    int[] iArr = access$000;
                    long j29 = (long) i10;
                    long j30 = rotlXor7 + jArr3[i16] + j29;
                    long j31 = j26 + j27;
                    long rotlXor9 = ThreefishEngine.rotlXor(j27, 25, j31);
                    long j32 = j28 + j30;
                    long rotlXor10 = ThreefishEngine.rotlXor(j30, 33, j32);
                    long j33 = j31 + rotlXor10;
                    long rotlXor11 = ThreefishEngine.rotlXor(rotlXor10, 46, j33);
                    long j34 = j32 + rotlXor9;
                    long rotlXor12 = ThreefishEngine.rotlXor(rotlXor9, 12, j34);
                    long j35 = j33 + rotlXor12;
                    long rotlXor13 = ThreefishEngine.rotlXor(rotlXor12, 58, j35);
                    long j36 = j34 + rotlXor11;
                    long rotlXor14 = ThreefishEngine.rotlXor(rotlXor11, 22, j36);
                    long j37 = j35 + rotlXor14;
                    long rotlXor15 = ThreefishEngine.rotlXor(rotlXor14, 32, j37);
                    long j38 = j36 + rotlXor13;
                    long rotlXor16 = ThreefishEngine.rotlXor(rotlXor13, 32, j38);
                    j14 = j37 + jArr3[i13];
                    j15 = rotlXor16 + jArr3[i14] + jArr4[i15];
                    j16 = j38 + jArr3[i16] + jArr4[i12 + 2];
                    j17 = rotlXor15 + jArr3[i11 + 4] + j29 + 1;
                    i10 += 2;
                    access$000 = iArr;
                    access$100 = access$100;
                }
                jArr2[0] = j14;
                jArr2[1] = j15;
                jArr2[2] = j16;
                jArr2[3] = j17;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static final class Threefish512Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 46;
        private static final int ROTATION_0_1 = 36;
        private static final int ROTATION_0_2 = 19;
        private static final int ROTATION_0_3 = 37;
        private static final int ROTATION_1_0 = 33;
        private static final int ROTATION_1_1 = 27;
        private static final int ROTATION_1_2 = 14;
        private static final int ROTATION_1_3 = 42;
        private static final int ROTATION_2_0 = 17;
        private static final int ROTATION_2_1 = 49;
        private static final int ROTATION_2_2 = 36;
        private static final int ROTATION_2_3 = 39;
        private static final int ROTATION_3_0 = 44;
        private static final int ROTATION_3_1 = 9;
        private static final int ROTATION_3_2 = 54;
        private static final int ROTATION_3_3 = 56;
        private static final int ROTATION_4_0 = 39;
        private static final int ROTATION_4_1 = 30;
        private static final int ROTATION_4_2 = 34;
        private static final int ROTATION_4_3 = 24;
        private static final int ROTATION_5_0 = 13;
        private static final int ROTATION_5_1 = 50;
        private static final int ROTATION_5_2 = 10;
        private static final int ROTATION_5_3 = 17;
        private static final int ROTATION_6_0 = 25;
        private static final int ROTATION_6_1 = 29;
        private static final int ROTATION_6_2 = 39;
        private static final int ROTATION_6_3 = 43;
        private static final int ROTATION_7_0 = 8;
        private static final int ROTATION_7_1 = 35;
        private static final int ROTATION_7_2 = 56;
        private static final int ROTATION_7_3 = 22;

        protected Threefish512Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.f41437t;
            int[] access$200 = ThreefishEngine.MOD9;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                boolean z10 = false;
                long j10 = jArr[0];
                int i10 = 1;
                long j11 = jArr[1];
                long j12 = jArr[2];
                long j13 = jArr[3];
                long j14 = jArr[4];
                long j15 = jArr[5];
                long j16 = jArr[6];
                long j17 = jArr[7];
                int i11 = 17;
                while (i11 >= i10) {
                    int i12 = access$200[i11];
                    int i13 = access$100[i11];
                    int i14 = i12 + 1;
                    long j18 = j10 - jArr3[i14];
                    int i15 = i12 + 2;
                    long j19 = j11 - jArr3[i15];
                    int i16 = i12 + 3;
                    long j20 = j12 - jArr3[i16];
                    int i17 = i12 + 4;
                    long j21 = j13 - jArr3[i17];
                    int i18 = i12 + 5;
                    long j22 = j14 - jArr3[i18];
                    int i19 = i12 + 6;
                    int i20 = i13 + 1;
                    long j23 = j15 - (jArr3[i19] + jArr4[i20]);
                    int i21 = i12 + 7;
                    int[] iArr = access$200;
                    int[] iArr2 = access$100;
                    long j24 = j16 - (jArr3[i21] + jArr4[i13 + 2]);
                    long[] jArr5 = jArr3;
                    long j25 = (long) i11;
                    long j26 = j25;
                    int i22 = i11;
                    long j27 = j21;
                    long xorRotr = ThreefishEngine.xorRotr(j19, 8, j24);
                    long j28 = j24 - xorRotr;
                    long xorRotr2 = ThreefishEngine.xorRotr(j17 - ((jArr3[i12 + 8] + j25) + 1), 35, j18);
                    long j29 = j18 - xorRotr2;
                    long j30 = xorRotr2;
                    long j31 = j20;
                    long xorRotr3 = ThreefishEngine.xorRotr(j23, 56, j31);
                    long j32 = j31 - xorRotr3;
                    long xorRotr4 = ThreefishEngine.xorRotr(j27, 22, j22);
                    long j33 = j22 - xorRotr4;
                    long xorRotr5 = ThreefishEngine.xorRotr(xorRotr, 25, j33);
                    long j34 = j33 - xorRotr5;
                    long xorRotr6 = ThreefishEngine.xorRotr(xorRotr4, 29, j28);
                    long j35 = j28 - xorRotr6;
                    long xorRotr7 = ThreefishEngine.xorRotr(xorRotr3, 39, j29);
                    long j36 = xorRotr6;
                    long j37 = j30;
                    long j38 = j29 - xorRotr7;
                    long j39 = j32;
                    long xorRotr8 = ThreefishEngine.xorRotr(j37, 43, j39);
                    long j40 = j39 - xorRotr8;
                    long xorRotr9 = ThreefishEngine.xorRotr(xorRotr5, 13, j40);
                    long j41 = j40 - xorRotr9;
                    long xorRotr10 = ThreefishEngine.xorRotr(xorRotr8, 50, j34);
                    long j42 = j34 - xorRotr10;
                    long xorRotr11 = ThreefishEngine.xorRotr(xorRotr7, 10, j35);
                    long j43 = j35 - xorRotr11;
                    long j44 = xorRotr10;
                    long j45 = j38;
                    long xorRotr12 = ThreefishEngine.xorRotr(j36, 17, j45);
                    long j46 = j45 - xorRotr12;
                    long xorRotr13 = ThreefishEngine.xorRotr(xorRotr9, 39, j46);
                    long xorRotr14 = ThreefishEngine.xorRotr(xorRotr12, 30, j41);
                    long xorRotr15 = ThreefishEngine.xorRotr(xorRotr11, 34, j42);
                    long j47 = j42 - xorRotr15;
                    long j48 = xorRotr15;
                    long xorRotr16 = ThreefishEngine.xorRotr(j44, 24, j43);
                    long j49 = (j46 - xorRotr13) - jArr5[i12];
                    long j50 = xorRotr13 - jArr5[i14];
                    long j51 = (j41 - xorRotr14) - jArr5[i15];
                    long j52 = xorRotr14 - jArr5[i16];
                    long j53 = j47 - jArr5[i17];
                    long j54 = j52;
                    long j55 = (j43 - xorRotr16) - (jArr5[i19] + jArr4[i20]);
                    long xorRotr17 = ThreefishEngine.xorRotr(j50, 44, j55);
                    long j56 = j55 - xorRotr17;
                    long xorRotr18 = ThreefishEngine.xorRotr(xorRotr16 - (jArr5[i21] + j26), 9, j49);
                    long j57 = j49 - xorRotr18;
                    long xorRotr19 = ThreefishEngine.xorRotr(j48 - (jArr5[i18] + jArr4[i13]), 54, j51);
                    long j58 = j51 - xorRotr19;
                    long xorRotr20 = ThreefishEngine.xorRotr(j54, 56, j53);
                    long j59 = j53 - xorRotr20;
                    long xorRotr21 = ThreefishEngine.xorRotr(xorRotr17, 17, j59);
                    long j60 = j59 - xorRotr21;
                    long xorRotr22 = ThreefishEngine.xorRotr(xorRotr20, 49, j56);
                    long j61 = j56 - xorRotr22;
                    long xorRotr23 = ThreefishEngine.xorRotr(xorRotr19, 36, j57);
                    long j62 = j57 - xorRotr23;
                    long j63 = j58;
                    long xorRotr24 = ThreefishEngine.xorRotr(xorRotr18, 39, j63);
                    long j64 = j63 - xorRotr24;
                    long xorRotr25 = ThreefishEngine.xorRotr(xorRotr21, 33, j64);
                    long j65 = j64 - xorRotr25;
                    long xorRotr26 = ThreefishEngine.xorRotr(xorRotr24, 27, j60);
                    long j66 = j60 - xorRotr26;
                    long xorRotr27 = ThreefishEngine.xorRotr(xorRotr23, 14, j61);
                    long[] jArr6 = jArr4;
                    long j67 = j62;
                    long xorRotr28 = ThreefishEngine.xorRotr(xorRotr22, 42, j67);
                    long j68 = j67 - xorRotr28;
                    long xorRotr29 = ThreefishEngine.xorRotr(xorRotr25, 46, j68);
                    long j69 = j68 - xorRotr29;
                    j13 = ThreefishEngine.xorRotr(xorRotr28, 36, j65);
                    long xorRotr30 = ThreefishEngine.xorRotr(xorRotr27, 19, j66);
                    j14 = j66 - xorRotr30;
                    long j70 = j61 - xorRotr27;
                    j17 = ThreefishEngine.xorRotr(xorRotr26, 37, j70);
                    j16 = j70 - j17;
                    j12 = j65 - j13;
                    j11 = xorRotr29;
                    j15 = xorRotr30;
                    i11 = i22 - 2;
                    access$100 = iArr2;
                    jArr3 = jArr5;
                    z10 = false;
                    i10 = 1;
                    j10 = j69;
                    jArr4 = jArr6;
                    access$200 = iArr;
                }
                long[] jArr7 = jArr3;
                long[] jArr8 = jArr4;
                char c10 = z10;
                long j71 = j10 - jArr7[c10];
                long j72 = j11 - jArr7[1];
                long j73 = j12 - jArr7[2];
                long j74 = j13 - jArr7[3];
                long j75 = j14 - jArr7[4];
                long j76 = j16 - (jArr7[6] + jArr8[1]);
                jArr2[c10] = j71;
                jArr2[1] = j72;
                jArr2[2] = j73;
                jArr2[3] = j74;
                jArr2[4] = j75;
                jArr2[5] = j15 - (jArr7[5] + jArr8[c10]);
                jArr2[6] = j76;
                jArr2[7] = j17 - jArr7[7];
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.f41437t;
            int[] access$200 = ThreefishEngine.MOD9;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j10 = jArr[0];
                long j11 = jArr[1];
                long j12 = jArr[2];
                long j13 = jArr[3];
                long j14 = jArr[4];
                long j15 = jArr[5];
                long j16 = jArr[6];
                long j17 = jArr[7];
                long j18 = j10 + jArr3[0];
                long j19 = j11 + jArr3[1];
                long j20 = j12 + jArr3[2];
                long j21 = j13 + jArr3[3];
                long j22 = j14 + jArr3[4];
                long j23 = j15 + jArr3[5] + jArr4[0];
                long j24 = j16 + jArr3[6] + jArr4[1];
                int i10 = 1;
                long j25 = j21;
                long j26 = j23;
                long j27 = j17 + jArr3[7];
                while (i10 < 18) {
                    int i11 = access$200[i10];
                    int i12 = access$100[i10];
                    long j28 = j18 + j19;
                    long rotlXor = ThreefishEngine.rotlXor(j19, 46, j28);
                    long j29 = j20 + j25;
                    long rotlXor2 = ThreefishEngine.rotlXor(j25, 36, j29);
                    long[] jArr5 = jArr3;
                    int[] iArr = access$200;
                    long j30 = j26;
                    long j31 = j22 + j30;
                    long rotlXor3 = ThreefishEngine.rotlXor(j30, 19, j31);
                    long j32 = rotlXor2;
                    int i13 = i10;
                    long j33 = j27;
                    long j34 = j24 + j33;
                    long rotlXor4 = ThreefishEngine.rotlXor(j33, 37, j34);
                    long j35 = j29 + rotlXor;
                    long rotlXor5 = ThreefishEngine.rotlXor(rotlXor, 33, j35);
                    long j36 = j31 + rotlXor4;
                    long rotlXor6 = ThreefishEngine.rotlXor(rotlXor4, 27, j36);
                    long j37 = j34 + rotlXor3;
                    long rotlXor7 = ThreefishEngine.rotlXor(rotlXor3, 14, j37);
                    long j38 = rotlXor6;
                    long j39 = j28 + j32;
                    long rotlXor8 = ThreefishEngine.rotlXor(j32, 42, j39);
                    long j40 = j36 + rotlXor5;
                    long rotlXor9 = ThreefishEngine.rotlXor(rotlXor5, 17, j40);
                    long j41 = j37 + rotlXor8;
                    long rotlXor10 = ThreefishEngine.rotlXor(rotlXor8, 49, j41);
                    long j42 = j39 + rotlXor7;
                    long rotlXor11 = ThreefishEngine.rotlXor(rotlXor7, 36, j42);
                    int i14 = i11;
                    long j43 = j35 + j38;
                    long j44 = j40;
                    long rotlXor12 = ThreefishEngine.rotlXor(j38, 39, j43);
                    long j45 = j41 + rotlXor9;
                    long rotlXor13 = ThreefishEngine.rotlXor(rotlXor9, 44, j45);
                    long j46 = j42 + rotlXor12;
                    long rotlXor14 = ThreefishEngine.rotlXor(rotlXor12, 9, j46);
                    long j47 = j43 + rotlXor11;
                    long rotlXor15 = ThreefishEngine.rotlXor(rotlXor11, 54, j47);
                    long j48 = rotlXor14;
                    long j49 = j44 + rotlXor10;
                    long rotlXor16 = ThreefishEngine.rotlXor(rotlXor10, 56, j49);
                    long j50 = j46 + jArr5[i14];
                    int i15 = i14 + 1;
                    long j51 = rotlXor13 + jArr5[i15];
                    int i16 = i14 + 2;
                    long j52 = j47 + jArr5[i16];
                    int i17 = i14 + 3;
                    long j53 = rotlXor16 + jArr5[i17];
                    int i18 = i14 + 4;
                    long j54 = j49 + jArr5[i18];
                    int i19 = i14 + 5;
                    long j55 = rotlXor15 + jArr5[i19] + jArr4[i12];
                    int i20 = i14 + 6;
                    int i21 = i12 + 1;
                    int i22 = i14 + 7;
                    long j56 = j45 + jArr5[i20] + jArr4[i21];
                    long j57 = (long) i13;
                    long j58 = j57;
                    long j59 = j48 + jArr5[i22] + j57;
                    long j60 = j50 + j51;
                    long rotlXor17 = ThreefishEngine.rotlXor(j51, 39, j60);
                    long j61 = j52 + j53;
                    long rotlXor18 = ThreefishEngine.rotlXor(j53, 30, j61);
                    long j62 = j54 + j55;
                    long rotlXor19 = ThreefishEngine.rotlXor(j55, 34, j62);
                    long j63 = j60;
                    long j64 = j56 + j59;
                    long rotlXor20 = ThreefishEngine.rotlXor(j59, 24, j64);
                    long j65 = j61 + rotlXor17;
                    long rotlXor21 = ThreefishEngine.rotlXor(rotlXor17, 13, j65);
                    long j66 = j62 + rotlXor20;
                    long rotlXor22 = ThreefishEngine.rotlXor(rotlXor20, 50, j66);
                    long j67 = j64 + rotlXor19;
                    long rotlXor23 = ThreefishEngine.rotlXor(rotlXor19, 10, j67);
                    long j68 = rotlXor22;
                    long j69 = j63 + rotlXor18;
                    long rotlXor24 = ThreefishEngine.rotlXor(rotlXor18, 17, j69);
                    long j70 = j66 + rotlXor21;
                    long rotlXor25 = ThreefishEngine.rotlXor(rotlXor21, 25, j70);
                    long j71 = j67 + rotlXor24;
                    long rotlXor26 = ThreefishEngine.rotlXor(rotlXor24, 29, j71);
                    long j72 = j69 + rotlXor23;
                    long rotlXor27 = ThreefishEngine.rotlXor(rotlXor23, 39, j72);
                    long j73 = j65 + j68;
                    long j74 = j70;
                    long rotlXor28 = ThreefishEngine.rotlXor(j68, 43, j73);
                    long j75 = j71 + rotlXor25;
                    long rotlXor29 = ThreefishEngine.rotlXor(rotlXor25, 8, j75);
                    long j76 = j72 + rotlXor28;
                    long rotlXor30 = ThreefishEngine.rotlXor(rotlXor28, 35, j76);
                    long j77 = j73 + rotlXor27;
                    long rotlXor31 = ThreefishEngine.rotlXor(rotlXor27, 56, j77);
                    long j78 = rotlXor30;
                    long j79 = j74 + rotlXor26;
                    long rotlXor32 = ThreefishEngine.rotlXor(rotlXor26, 22, j79);
                    long j80 = j76 + jArr5[i15];
                    j19 = rotlXor29 + jArr5[i16];
                    long j81 = j77 + jArr5[i17];
                    long j82 = rotlXor32 + jArr5[i18];
                    long j83 = j79 + jArr5[i19];
                    long j84 = rotlXor31 + jArr5[i20] + jArr4[i21];
                    j24 = j75 + jArr5[i22] + jArr4[i12 + 2];
                    j27 = j78 + jArr5[i14 + 8] + j58 + 1;
                    j22 = j83;
                    j26 = j84;
                    access$200 = iArr;
                    access$100 = access$100;
                    jArr3 = jArr5;
                    long j85 = j80;
                    i10 = i13 + 2;
                    j25 = j82;
                    j20 = j81;
                    j18 = j85;
                }
                jArr2[0] = j18;
                jArr2[1] = j19;
                jArr2[2] = j20;
                jArr2[3] = j25;
                jArr2[4] = j22;
                jArr2[5] = j26;
                jArr2[6] = j24;
                jArr2[7] = j27;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static abstract class ThreefishCipher {
        protected final long[] kw;

        /* renamed from: t  reason: collision with root package name */
        protected final long[] f41437t;

        protected ThreefishCipher(long[] jArr, long[] jArr2) {
            this.kw = jArr;
            this.f41437t = jArr2;
        }

        /* access modifiers changed from: package-private */
        public abstract void decryptBlock(long[] jArr, long[] jArr2);

        /* access modifiers changed from: package-private */
        public abstract void encryptBlock(long[] jArr, long[] jArr2);
    }

    static {
        int[] iArr = new int[80];
        MOD9 = iArr;
        MOD17 = new int[iArr.length];
        MOD5 = new int[iArr.length];
        MOD3 = new int[iArr.length];
        int i10 = 0;
        while (true) {
            int[] iArr2 = MOD9;
            if (i10 < iArr2.length) {
                MOD17[i10] = i10 % 17;
                iArr2[i10] = i10 % 9;
                MOD5[i10] = i10 % 5;
                MOD3[i10] = i10 % 3;
                i10++;
            } else {
                return;
            }
        }
    }

    public ThreefishEngine(int i10) {
        ThreefishCipher threefishCipher;
        long[] jArr = new long[5];
        this.f41436t = jArr;
        int i11 = i10 / 8;
        this.blocksizeBytes = i11;
        int i12 = i11 / 8;
        this.blocksizeWords = i12;
        this.currentBlock = new long[i12];
        long[] jArr2 = new long[((i12 * 2) + 1)];
        this.kw = jArr2;
        if (i10 == 256) {
            threefishCipher = new Threefish256Cipher(jArr2, jArr);
        } else if (i10 == 512) {
            threefishCipher = new Threefish512Cipher(jArr2, jArr);
        } else if (i10 == 1024) {
            threefishCipher = new Threefish1024Cipher(jArr2, jArr);
        } else {
            throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
        }
        this.cipher = threefishCipher;
    }

    public static long bytesToWord(byte[] bArr, int i10) {
        if (i10 + 8 <= bArr.length) {
            int i11 = i10 + 1;
            int i12 = i11 + 1;
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            return ((((long) bArr[i16 + 1]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i11]) & 255) << 8) | ((((long) bArr[i12]) & 255) << 16) | ((((long) bArr[i13]) & 255) << 24) | ((((long) bArr[i14]) & 255) << 32) | ((((long) bArr[i15]) & 255) << 40) | ((((long) bArr[i16]) & 255) << 48);
        }
        throw new IllegalArgumentException();
    }

    static long rotlXor(long j10, int i10, long j11) {
        return ((j10 >>> (-i10)) | (j10 << i10)) ^ j11;
    }

    private void setKey(long[] jArr) {
        if (jArr.length == this.blocksizeWords) {
            long j10 = C_240;
            int i10 = 0;
            while (true) {
                int i11 = this.blocksizeWords;
                if (i10 < i11) {
                    long[] jArr2 = this.kw;
                    long j11 = jArr[i10];
                    jArr2[i10] = j11;
                    j10 ^= j11;
                    i10++;
                } else {
                    long[] jArr3 = this.kw;
                    jArr3[i11] = j10;
                    System.arraycopy(jArr3, 0, jArr3, i11 + 1, i11);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeWords + " words)");
        }
    }

    private void setTweak(long[] jArr) {
        if (jArr.length == 2) {
            long[] jArr2 = this.f41436t;
            long j10 = jArr[0];
            jArr2[0] = j10;
            long j11 = jArr[1];
            jArr2[1] = j11;
            jArr2[2] = j10 ^ j11;
            jArr2[3] = j10;
            jArr2[4] = j11;
            return;
        }
        throw new IllegalArgumentException("Tweak must be 2 words.");
    }

    public static void wordToBytes(long j10, byte[] bArr, int i10) {
        if (i10 + 8 <= bArr.length) {
            int i11 = i10 + 1;
            bArr[i10] = (byte) ((int) j10);
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((int) (j10 >> 8));
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((int) (j10 >> 16));
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((int) (j10 >> 24));
            int i15 = i14 + 1;
            bArr[i14] = (byte) ((int) (j10 >> 32));
            int i16 = i15 + 1;
            bArr[i15] = (byte) ((int) (j10 >> 40));
            bArr[i16] = (byte) ((int) (j10 >> 48));
            bArr[i16 + 1] = (byte) ((int) (j10 >> 56));
            return;
        }
        throw new IllegalArgumentException();
    }

    static long xorRotr(long j10, int i10, long j11) {
        long j12 = j10 ^ j11;
        return (j12 << (-i10)) | (j12 >>> i10);
    }

    public String getAlgorithmName() {
        return "Threefish-" + (this.blocksizeBytes * 8);
    }

    public int getBlockSize() {
        return this.blocksizeBytes;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] bArr;
        byte[] bArr2;
        long[] jArr;
        long[] jArr2 = null;
        if (cipherParameters instanceof TweakableBlockCipherParameters) {
            TweakableBlockCipherParameters tweakableBlockCipherParameters = (TweakableBlockCipherParameters) cipherParameters;
            bArr2 = tweakableBlockCipherParameters.getKey().getKey();
            bArr = tweakableBlockCipherParameters.getTweak();
        } else if (cipherParameters instanceof KeyParameter) {
            bArr2 = ((KeyParameter) cipherParameters).getKey();
            bArr = null;
        } else {
            throw new IllegalArgumentException("Invalid parameter passed to Threefish init - " + cipherParameters.getClass().getName());
        }
        if (bArr2 == null) {
            jArr = null;
        } else if (bArr2.length == this.blocksizeBytes) {
            int i10 = this.blocksizeWords;
            jArr = new long[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                jArr[i11] = bytesToWord(bArr2, i11 * 8);
            }
        } else {
            throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeBytes + " bytes)");
        }
        if (bArr != null) {
            if (bArr.length == 16) {
                jArr2 = new long[]{bytesToWord(bArr, 0), bytesToWord(bArr, 8)};
            } else {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
        }
        init(z10, jArr, jArr2);
    }

    public void init(boolean z10, long[] jArr, long[] jArr2) {
        this.forEncryption = z10;
        if (jArr != null) {
            setKey(jArr);
        }
        if (jArr2 != null) {
            setTweak(jArr2);
        }
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        int i12 = this.blocksizeBytes;
        if (i10 + i12 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        } else if (i12 + i11 <= bArr2.length) {
            int i13 = 0;
            for (int i14 = 0; i14 < this.blocksizeBytes; i14 += 8) {
                this.currentBlock[i14 >> 3] = bytesToWord(bArr, i10 + i14);
            }
            long[] jArr = this.currentBlock;
            processBlock(jArr, jArr);
            while (true) {
                int i15 = this.blocksizeBytes;
                if (i13 >= i15) {
                    return i15;
                }
                wordToBytes(this.currentBlock[i13 >> 3], bArr2, i11 + i13);
                i13 += 8;
            }
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public int processBlock(long[] jArr, long[] jArr2) throws DataLengthException, IllegalStateException {
        long[] jArr3 = this.kw;
        int i10 = this.blocksizeWords;
        if (jArr3[i10] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        } else if (jArr.length != i10) {
            throw new DataLengthException("Input buffer too short");
        } else if (jArr2.length == i10) {
            if (this.forEncryption) {
                this.cipher.encryptBlock(jArr, jArr2);
            } else {
                this.cipher.decryptBlock(jArr, jArr2);
            }
            return this.blocksizeWords;
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public void reset() {
    }
}
