package org.bouncycastle.crypto.digests;

import java.util.Iterator;
import java.util.Stack;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.params.Blake3Parameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class Blake3Digest implements ExtendedDigest, Memoable, Xof {
    private static final int BLOCKLEN = 64;
    private static final int CHAINING0 = 0;
    private static final int CHAINING1 = 1;
    private static final int CHAINING2 = 2;
    private static final int CHAINING3 = 3;
    private static final int CHAINING4 = 4;
    private static final int CHAINING5 = 5;
    private static final int CHAINING6 = 6;
    private static final int CHAINING7 = 7;
    private static final int CHUNKEND = 2;
    private static final int CHUNKLEN = 1024;
    private static final int CHUNKSTART = 1;
    private static final int COUNT0 = 12;
    private static final int COUNT1 = 13;
    private static final int DATALEN = 14;
    private static final int DERIVECONTEXT = 32;
    private static final int DERIVEKEY = 64;
    private static final String ERR_OUTPUTTING = "Already outputting";
    private static final int FLAGS = 15;
    private static final int[] IV = {1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225};
    private static final int IV0 = 8;
    private static final int IV1 = 9;
    private static final int IV2 = 10;
    private static final int IV3 = 11;
    private static final int KEYEDHASH = 16;
    private static final int NUMWORDS = 8;
    private static final int PARENT = 4;
    private static final int ROOT = 8;
    private static final byte[] ROTATE = {Tnaf.POW_2_WIDTH, 12, 8, 7};
    private static final int ROUNDS = 7;
    private static final byte[] SIGMA = {2, 6, 3, 10, 7, 0, 4, 13, 1, 11, 12, 5, 9, 14, 15, 8};
    private boolean outputting;
    private final byte[] theBuffer;
    private final int[] theChaining;
    private long theCounter;
    private int theCurrBytes;
    private final int theDigestLen;
    private final byte[] theIndices;
    private final int[] theK;
    private final int[] theM;
    private int theMode;
    private int theOutputDataLen;
    private int theOutputMode;
    private int thePos;
    private final Stack theStack;
    private final int[] theV;

    public Blake3Digest() {
        this(32);
    }

    public Blake3Digest(int i10) {
        this.theBuffer = new byte[64];
        this.theK = new int[8];
        this.theChaining = new int[8];
        this.theV = new int[16];
        this.theM = new int[16];
        this.theIndices = new byte[16];
        this.theStack = new Stack();
        this.theDigestLen = i10;
        init((Blake3Parameters) null);
    }

    private Blake3Digest(Blake3Digest blake3Digest) {
        this.theBuffer = new byte[64];
        this.theK = new int[8];
        this.theChaining = new int[8];
        this.theV = new int[16];
        this.theM = new int[16];
        this.theIndices = new byte[16];
        this.theStack = new Stack();
        this.theDigestLen = blake3Digest.theDigestLen;
        reset(blake3Digest);
    }

    private void adjustChaining() {
        if (this.outputting) {
            for (int i10 = 0; i10 < 8; i10++) {
                int[] iArr = this.theV;
                int i11 = i10 + 8;
                iArr[i10] = iArr[i10] ^ iArr[i11];
                iArr[i11] = iArr[i11] ^ this.theChaining[i10];
            }
            for (int i12 = 0; i12 < 16; i12++) {
                Pack.intToLittleEndian(this.theV[i12], this.theBuffer, i12 * 4);
            }
            this.thePos = 0;
            return;
        }
        for (int i13 = 0; i13 < 8; i13++) {
            int[] iArr2 = this.theChaining;
            int[] iArr3 = this.theV;
            iArr2[i13] = iArr3[i13 + 8] ^ iArr3[i13];
        }
    }

    private void adjustStack() {
        long j10 = this.theCounter;
        while (j10 > 0 && (j10 & 1) != 1) {
            System.arraycopy((int[]) this.theStack.pop(), 0, this.theM, 0, 8);
            System.arraycopy(this.theChaining, 0, this.theM, 8, 8);
            initParentBlock();
            compress();
            j10 >>= 1;
        }
        this.theStack.push(Arrays.copyOf(this.theChaining, 8));
    }

    private void compress() {
        initIndices();
        int i10 = 0;
        while (true) {
            performRound();
            if (i10 < 6) {
                permuteIndices();
                i10++;
            } else {
                adjustChaining();
                return;
            }
        }
    }

    private void compressBlock(byte[] bArr, int i10) {
        initChunkBlock(64, false);
        initM(bArr, i10);
        compress();
        if (this.theCurrBytes == 0) {
            adjustStack();
        }
    }

    private void compressFinalBlock(int i10) {
        initChunkBlock(i10, true);
        initM(this.theBuffer, 0);
        compress();
        processStack();
    }

    private void incrementBlockCount() {
        this.theCounter++;
        this.theCurrBytes = 0;
    }

    private void initChunkBlock(int i10, boolean z10) {
        int i11 = 0;
        System.arraycopy(this.theCurrBytes == 0 ? this.theK : this.theChaining, 0, this.theV, 0, 8);
        System.arraycopy(IV, 0, this.theV, 8, 4);
        int[] iArr = this.theV;
        long j10 = this.theCounter;
        iArr[12] = (int) j10;
        iArr[13] = (int) (j10 >> 32);
        iArr[14] = i10;
        int i12 = this.theMode;
        int i13 = this.theCurrBytes;
        int i14 = i12 + (i13 == 0 ? 1 : 0);
        if (z10) {
            i11 = 2;
        }
        iArr[15] = i14 + i11;
        int i15 = i13 + i10;
        this.theCurrBytes = i15;
        if (i15 >= 1024) {
            incrementBlockCount();
            int[] iArr2 = this.theV;
            iArr2[15] = iArr2[15] | 2;
        }
        if (z10 && this.theStack.isEmpty()) {
            setRoot();
        }
    }

    private void initIndices() {
        byte b10 = 0;
        while (true) {
            byte[] bArr = this.theIndices;
            if (b10 < bArr.length) {
                bArr[b10] = b10;
                b10 = (byte) (b10 + 1);
            } else {
                return;
            }
        }
    }

    private void initKey(byte[] bArr) {
        for (int i10 = 0; i10 < 8; i10++) {
            this.theK[i10] = Pack.littleEndianToInt(bArr, i10 * 4);
        }
        this.theMode = 16;
    }

    private void initKeyFromContext() {
        System.arraycopy(this.theV, 0, this.theK, 0, 8);
        this.theMode = 64;
    }

    private void initM(byte[] bArr, int i10) {
        for (int i11 = 0; i11 < 16; i11++) {
            this.theM[i11] = Pack.littleEndianToInt(bArr, (i11 * 4) + i10);
        }
    }

    private void initNullKey() {
        System.arraycopy(IV, 0, this.theK, 0, 8);
    }

    private void initParentBlock() {
        System.arraycopy(this.theK, 0, this.theV, 0, 8);
        System.arraycopy(IV, 0, this.theV, 8, 4);
        int[] iArr = this.theV;
        iArr[12] = 0;
        iArr[13] = 0;
        iArr[14] = 64;
        iArr[15] = this.theMode | 4;
    }

    private void mixG(int i10, int i11, int i12, int i13, int i14) {
        int i15 = i10 << 1;
        int[] iArr = this.theV;
        int i16 = i15 + 1;
        int i17 = iArr[i11] + iArr[i12] + this.theM[this.theIndices[i15]];
        iArr[i11] = i17;
        int i18 = iArr[i14] ^ i17;
        byte[] bArr = ROTATE;
        iArr[i14] = Integers.rotateRight(i18, bArr[0]);
        int[] iArr2 = this.theV;
        int i19 = iArr2[i13] + iArr2[i14];
        iArr2[i13] = i19;
        iArr2[i12] = Integers.rotateRight(i19 ^ iArr2[i12], bArr[1]);
        int[] iArr3 = this.theV;
        int i20 = iArr3[i11] + iArr3[i12] + this.theM[this.theIndices[i16]];
        iArr3[i11] = i20;
        iArr3[i14] = Integers.rotateRight(iArr3[i14] ^ i20, bArr[2]);
        int[] iArr4 = this.theV;
        int i21 = iArr4[i13] + iArr4[i14];
        iArr4[i13] = i21;
        iArr4[i12] = Integers.rotateRight(i21 ^ iArr4[i12], bArr[3]);
    }

    private void nextOutputBlock() {
        this.theCounter++;
        System.arraycopy(this.theChaining, 0, this.theV, 0, 8);
        System.arraycopy(IV, 0, this.theV, 8, 4);
        int[] iArr = this.theV;
        long j10 = this.theCounter;
        iArr[12] = (int) j10;
        iArr[13] = (int) (j10 >> 32);
        iArr[14] = this.theOutputDataLen;
        iArr[15] = this.theOutputMode;
        compress();
    }

    private void performRound() {
        mixG(0, 0, 4, 8, 12);
        mixG(1, 1, 5, 9, 13);
        mixG(2, 2, 6, 10, 14);
        mixG(3, 3, 7, 11, 15);
        mixG(4, 0, 5, 10, 15);
        mixG(5, 1, 6, 11, 12);
        mixG(6, 2, 7, 8, 13);
        mixG(7, 3, 4, 9, 14);
    }

    private void permuteIndices() {
        byte b10 = 0;
        while (true) {
            byte[] bArr = this.theIndices;
            if (b10 < bArr.length) {
                bArr[b10] = SIGMA[bArr[b10]];
                b10 = (byte) (b10 + 1);
            } else {
                return;
            }
        }
    }

    private void processStack() {
        while (!this.theStack.isEmpty()) {
            System.arraycopy((int[]) this.theStack.pop(), 0, this.theM, 0, 8);
            System.arraycopy(this.theChaining, 0, this.theM, 8, 8);
            initParentBlock();
            if (this.theStack.isEmpty()) {
                setRoot();
            }
            compress();
        }
    }

    private void resetBlockCount() {
        this.theCounter = 0;
        this.theCurrBytes = 0;
    }

    private void setRoot() {
        int[] iArr = this.theV;
        int i10 = iArr[15] | 8;
        iArr[15] = i10;
        this.theOutputMode = i10;
        this.theOutputDataLen = iArr[14];
        this.theCounter = 0;
        this.outputting = true;
        System.arraycopy(iArr, 0, this.theChaining, 0, 8);
    }

    public Memoable copy() {
        return new Blake3Digest(this);
    }

    public int doFinal(byte[] bArr, int i10) {
        return doFinal(bArr, i10, getDigestSize());
    }

    public int doFinal(byte[] bArr, int i10, int i11) {
        if (!this.outputting) {
            int doOutput = doOutput(bArr, i10, i11);
            reset();
            return doOutput;
        }
        throw new IllegalStateException(ERR_OUTPUTTING);
    }

    public int doOutput(byte[] bArr, int i10, int i11) {
        int i12;
        if (!this.outputting) {
            compressFinalBlock(this.thePos);
        }
        int i13 = this.thePos;
        if (i13 < 64) {
            int min = Math.min(i11, 64 - i13);
            System.arraycopy(this.theBuffer, this.thePos, bArr, i10, min);
            this.thePos += min;
            i10 += min;
            i12 = i11 - min;
        } else {
            i12 = i11;
        }
        while (i12 > 0) {
            nextOutputBlock();
            int min2 = Math.min(i12, 64);
            System.arraycopy(this.theBuffer, 0, bArr, i10, min2);
            this.thePos += min2;
            i10 += min2;
            i12 -= min2;
        }
        return i11;
    }

    public String getAlgorithmName() {
        return "BLAKE3";
    }

    public int getByteLength() {
        return 64;
    }

    public int getDigestSize() {
        return this.theDigestLen;
    }

    public void init(Blake3Parameters blake3Parameters) {
        byte[] bArr = null;
        byte[] key = blake3Parameters == null ? null : blake3Parameters.getKey();
        if (blake3Parameters != null) {
            bArr = blake3Parameters.getContext();
        }
        reset();
        if (key != null) {
            initKey(key);
            Arrays.fill(key, (byte) 0);
            return;
        }
        initNullKey();
        if (bArr != null) {
            this.theMode = 32;
            update(bArr, 0, bArr.length);
            doFinal(this.theBuffer, 0);
            initKeyFromContext();
            reset();
            return;
        }
        this.theMode = 0;
    }

    public void reset() {
        resetBlockCount();
        this.thePos = 0;
        this.outputting = false;
        Arrays.fill(this.theBuffer, (byte) 0);
    }

    public void reset(Memoable memoable) {
        Blake3Digest blake3Digest = (Blake3Digest) memoable;
        this.theCounter = blake3Digest.theCounter;
        this.theCurrBytes = blake3Digest.theCurrBytes;
        this.theMode = blake3Digest.theMode;
        this.outputting = blake3Digest.outputting;
        this.theOutputMode = blake3Digest.theOutputMode;
        this.theOutputDataLen = blake3Digest.theOutputDataLen;
        int[] iArr = blake3Digest.theChaining;
        int[] iArr2 = this.theChaining;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = blake3Digest.theK;
        int[] iArr4 = this.theK;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        int[] iArr5 = blake3Digest.theM;
        int[] iArr6 = this.theM;
        System.arraycopy(iArr5, 0, iArr6, 0, iArr6.length);
        this.theStack.clear();
        Iterator it = blake3Digest.theStack.iterator();
        while (it.hasNext()) {
            this.theStack.push(Arrays.clone((int[]) it.next()));
        }
        byte[] bArr = blake3Digest.theBuffer;
        byte[] bArr2 = this.theBuffer;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.thePos = blake3Digest.thePos;
    }

    public void update(byte b10) {
        if (!this.outputting) {
            byte[] bArr = this.theBuffer;
            if (bArr.length - this.thePos == 0) {
                compressBlock(bArr, 0);
                Arrays.fill(this.theBuffer, (byte) 0);
                this.thePos = 0;
            }
            byte[] bArr2 = this.theBuffer;
            int i10 = this.thePos;
            bArr2[i10] = b10;
            this.thePos = i10 + 1;
            return;
        }
        throw new IllegalStateException(ERR_OUTPUTTING);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037 A[LOOP:0: B:14:0x0035->B:15:0x0037, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(byte[] r5, int r6, int r7) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0050
            if (r7 != 0) goto L_0x0005
            goto L_0x0050
        L_0x0005:
            boolean r0 = r4.outputting
            if (r0 != 0) goto L_0x0048
            int r0 = r4.thePos
            r1 = 0
            if (r0 == 0) goto L_0x002f
            int r2 = 64 - r0
            if (r2 < r7) goto L_0x001d
            byte[] r1 = r4.theBuffer
            java.lang.System.arraycopy(r5, r6, r1, r0, r7)
            int r5 = r4.thePos
            int r5 = r5 + r7
        L_0x001a:
            r4.thePos = r5
            return
        L_0x001d:
            byte[] r3 = r4.theBuffer
            java.lang.System.arraycopy(r5, r6, r3, r0, r2)
            byte[] r0 = r4.theBuffer
            r4.compressBlock(r0, r1)
            r4.thePos = r1
            byte[] r0 = r4.theBuffer
            org.bouncycastle.util.Arrays.fill((byte[]) r0, (byte) r1)
            goto L_0x0030
        L_0x002f:
            r2 = r1
        L_0x0030:
            int r0 = r6 + r7
            int r0 = r0 + -64
            int r2 = r2 + r6
        L_0x0035:
            if (r2 >= r0) goto L_0x003d
            r4.compressBlock(r5, r2)
            int r2 = r2 + 64
            goto L_0x0035
        L_0x003d:
            int r7 = r7 - r2
            byte[] r0 = r4.theBuffer
            int r6 = r6 + r7
            java.lang.System.arraycopy(r5, r2, r0, r1, r6)
            int r5 = r4.thePos
            int r5 = r5 + r6
            goto L_0x001a
        L_0x0048:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Already outputting"
            r5.<init>(r6)
            throw r5
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.digests.Blake3Digest.update(byte[], int, int):void");
    }
}
