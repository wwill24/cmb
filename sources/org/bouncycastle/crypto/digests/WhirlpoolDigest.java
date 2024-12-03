package org.bouncycastle.crypto.digests;

import com.leanplum.internal.ResourceQualifiers;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;

public final class WhirlpoolDigest implements ExtendedDigest, Memoable {
    private static final int BITCOUNT_ARRAY_SIZE = 32;
    private static final int BYTE_LENGTH = 64;
    private static final long[] C0 = new long[256];
    private static final long[] C1 = new long[256];
    private static final long[] C2 = new long[256];
    private static final long[] C3 = new long[256];
    private static final long[] C4 = new long[256];
    private static final long[] C5 = new long[256];
    private static final long[] C6 = new long[256];
    private static final long[] C7 = new long[256];
    private static final int DIGEST_LENGTH_BYTES = 64;
    private static final short[] EIGHT;
    private static final int REDUCTION_POLYNOMIAL = 285;
    private static final int ROUNDS = 10;
    private static final int[] SBOX = {24, 35, Opcodes.IFNULL, 232, 135, Opcodes.INVOKESTATIC, 1, 79, 54, Opcodes.IF_ACMPNE, 210, 245, 121, 111, Opcodes.I2B, 82, 96, 188, Opcodes.IFLT, Opcodes.D2I, Opcodes.IF_ICMPGT, 12, 123, 53, 29, 224, 215, Opcodes.MONITORENTER, 46, 75, 254, 87, 21, 119, 55, 229, Opcodes.IF_ICMPEQ, 240, 74, 218, 88, 201, 41, 10, Opcodes.RETURN, 160, 107, Opcodes.I2L, Opcodes.ANEWARRAY, 93, 16, 244, 203, 62, 5, 103, 228, 39, 65, Opcodes.F2I, Opcodes.GOTO, 125, Opcodes.FCMPL, 216, 251, 238, 124, 102, 221, 23, 71, Opcodes.IFLE, 202, 45, Opcodes.ATHROW, 7, Opcodes.LRETURN, 90, Opcodes.LXOR, 51, 99, 2, Opcodes.TABLESWITCH, 113, 200, 25, 73, 217, 242, 227, 91, 136, Opcodes.IFNE, 38, 50, Opcodes.ARETURN, 233, 15, ResourceQualifiers.Qualifier.AnonymousClass14.DENSITY_TV, 128, 190, 205, 52, 72, 255, 122, Opcodes.D2F, 95, 32, 104, 26, Opcodes.FRETURN, Opcodes.GETFIELD, 84, 147, 34, 100, 241, 115, 18, 64, 8, Opcodes.MONITOREXIT, 236, 219, Opcodes.IF_ICMPLT, Opcodes.F2D, 61, Opcodes.DCMPL, 0, 207, 43, 118, Opcodes.IXOR, 214, 27, Opcodes.PUTFIELD, Opcodes.DRETURN, 106, 80, 69, 243, 48, 239, 63, 85, Opcodes.IF_ICMPGE, 234, 101, Opcodes.INVOKEDYNAMIC, 47, 192, 222, 28, 253, 77, Opcodes.I2C, 117, 6, Opcodes.L2D, Opcodes.GETSTATIC, 230, 14, 31, 98, 212, 168, Opcodes.FCMPG, 249, Opcodes.MULTIANEWARRAY, 37, 89, Opcodes.IINC, 114, 57, 76, 94, 120, 56, Opcodes.F2L, 209, Opcodes.IF_ACMPEQ, 226, 97, Opcodes.PUTSTATIC, 33, Opcodes.IFGE, 30, 67, Opcodes.IFNONNULL, 252, 4, 81, Opcodes.IFEQ, 109, 13, MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT, 223, 126, 36, 59, Opcodes.LOOKUPSWITCH, 206, 17, Opcodes.D2L, 78, Opcodes.INVOKESPECIAL, 235, 60, 129, Opcodes.LCMP, 247, Opcodes.INVOKEINTERFACE, 19, 44, 211, 231, 110, 196, 3, 86, 68, Opcodes.LAND, Opcodes.RET, 42, Opcodes.NEW, Opcodes.INSTANCEOF, 83, 220, 11, Opcodes.IFGT, 108, 49, 116, 246, 70, Opcodes.IRETURN, Opcodes.L2F, 20, 225, 22, 58, 105, 9, 112, Opcodes.INVOKEVIRTUAL, 208, 237, 204, 66, Opcodes.DCMPG, Opcodes.IF_ICMPLE, 40, 92, 248, 134};
    private long[] _K = new long[8];
    private long[] _L = new long[8];
    private short[] _bitCount = new short[32];
    private long[] _block = new long[8];
    private byte[] _buffer = new byte[64];
    private int _bufferPos = 0;
    private long[] _hash = new long[8];
    private final long[] _rc = new long[11];
    private long[] _state = new long[8];

    static {
        short[] sArr = new short[32];
        EIGHT = sArr;
        sArr[31] = 8;
    }

    public WhirlpoolDigest() {
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = SBOX[i10];
            int maskWithReductionPolynomial = maskWithReductionPolynomial(i11 << 1);
            int maskWithReductionPolynomial2 = maskWithReductionPolynomial(maskWithReductionPolynomial << 1);
            int i12 = maskWithReductionPolynomial2 ^ i11;
            int maskWithReductionPolynomial3 = maskWithReductionPolynomial(maskWithReductionPolynomial2 << 1);
            int i13 = maskWithReductionPolynomial3 ^ i11;
            int i14 = i11;
            C0[i10] = packIntoLong(i11, i14, maskWithReductionPolynomial2, i11, maskWithReductionPolynomial3, i12, maskWithReductionPolynomial, i13);
            int i15 = i11;
            C1[i10] = packIntoLong(i13, i14, i15, maskWithReductionPolynomial2, i11, maskWithReductionPolynomial3, i12, maskWithReductionPolynomial);
            int i16 = i11;
            C2[i10] = packIntoLong(maskWithReductionPolynomial, i13, i15, i16, maskWithReductionPolynomial2, i11, maskWithReductionPolynomial3, i12);
            int i17 = i11;
            C3[i10] = packIntoLong(i12, maskWithReductionPolynomial, i13, i16, i17, maskWithReductionPolynomial2, i11, maskWithReductionPolynomial3);
            int i18 = i11;
            C4[i10] = packIntoLong(maskWithReductionPolynomial3, i12, maskWithReductionPolynomial, i13, i17, i18, maskWithReductionPolynomial2, i11);
            int i19 = i11;
            C5[i10] = packIntoLong(i11, maskWithReductionPolynomial3, i12, maskWithReductionPolynomial, i13, i18, i19, maskWithReductionPolynomial2);
            int i20 = i11;
            C6[i10] = packIntoLong(maskWithReductionPolynomial2, i11, maskWithReductionPolynomial3, i12, maskWithReductionPolynomial, i13, i19, i20);
            C7[i10] = packIntoLong(i11, maskWithReductionPolynomial2, i11, maskWithReductionPolynomial3, i12, maskWithReductionPolynomial, i13, i20);
        }
        this._rc[0] = 0;
        for (int i21 = 1; i21 <= 10; i21++) {
            int i22 = (i21 - 1) * 8;
            this._rc[i21] = (((((((C0[i22] & -72057594037927936L) ^ (C1[i22 + 1] & 71776119061217280L)) ^ (C2[i22 + 2] & 280375465082880L)) ^ (C3[i22 + 3] & 1095216660480L)) ^ (C4[i22 + 4] & 4278190080L)) ^ (C5[i22 + 5] & 16711680)) ^ (C6[i22 + 6] & 65280)) ^ (C7[i22 + 7] & 255);
        }
    }

    public WhirlpoolDigest(WhirlpoolDigest whirlpoolDigest) {
        reset(whirlpoolDigest);
    }

    private long bytesToLongFromBuffer(byte[] bArr, int i10) {
        return (((long) bArr[i10 + 7]) & 255) | ((((long) bArr[i10 + 0]) & 255) << 56) | ((((long) bArr[i10 + 1]) & 255) << 48) | ((((long) bArr[i10 + 2]) & 255) << 40) | ((((long) bArr[i10 + 3]) & 255) << 32) | ((((long) bArr[i10 + 4]) & 255) << 24) | ((((long) bArr[i10 + 5]) & 255) << 16) | ((((long) bArr[i10 + 6]) & 255) << 8);
    }

    private void convertLongToByteArray(long j10, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < 8; i11++) {
            bArr[i10 + i11] = (byte) ((int) ((j10 >> (56 - (i11 * 8))) & 255));
        }
    }

    private byte[] copyBitLength() {
        byte[] bArr = new byte[32];
        for (int i10 = 0; i10 < 32; i10++) {
            bArr[i10] = (byte) (this._bitCount[i10] & 255);
        }
        return bArr;
    }

    private void finish() {
        byte[] copyBitLength = copyBitLength();
        byte[] bArr = this._buffer;
        int i10 = this._bufferPos;
        int i11 = i10 + 1;
        this._bufferPos = i11;
        bArr[i10] = (byte) (bArr[i10] | 128);
        if (i11 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        if (this._bufferPos > 32) {
            while (this._bufferPos != 0) {
                update((byte) 0);
            }
        }
        while (this._bufferPos <= 32) {
            update((byte) 0);
        }
        System.arraycopy(copyBitLength, 0, this._buffer, 32, copyBitLength.length);
        processFilledBuffer(this._buffer, 0);
    }

    private void increment() {
        int i10 = 0;
        for (int length = this._bitCount.length - 1; length >= 0; length--) {
            short[] sArr = this._bitCount;
            int i11 = (sArr[length] & 255) + EIGHT[length] + i10;
            i10 = i11 >>> 8;
            sArr[length] = (short) (i11 & 255);
        }
    }

    private int maskWithReductionPolynomial(int i10) {
        return ((long) i10) >= 256 ? i10 ^ REDUCTION_POLYNOMIAL : i10;
    }

    private long packIntoLong(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        return (((((((((long) i11) << 48) ^ (((long) i10) << 56)) ^ (((long) i12) << 40)) ^ (((long) i13) << 32)) ^ (((long) i14) << 24)) ^ (((long) i15) << 16)) ^ (((long) i16) << 8)) ^ ((long) i17);
    }

    private void processFilledBuffer(byte[] bArr, int i10) {
        for (int i11 = 0; i11 < this._state.length; i11++) {
            this._block[i11] = bytesToLongFromBuffer(this._buffer, i11 * 8);
        }
        processBlock();
        this._bufferPos = 0;
        Arrays.fill(this._buffer, (byte) 0);
    }

    public Memoable copy() {
        return new WhirlpoolDigest(this);
    }

    public int doFinal(byte[] bArr, int i10) {
        finish();
        for (int i11 = 0; i11 < 8; i11++) {
            convertLongToByteArray(this._hash[i11], bArr, (i11 * 8) + i10);
        }
        reset();
        return getDigestSize();
    }

    public String getAlgorithmName() {
        return "Whirlpool";
    }

    public int getByteLength() {
        return 64;
    }

    public int getDigestSize() {
        return 64;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        long[] jArr;
        for (int i10 = 0; i10 < 8; i10++) {
            long[] jArr2 = this._state;
            long j10 = this._block[i10];
            long[] jArr3 = this._K;
            long j11 = this._hash[i10];
            jArr3[i10] = j11;
            jArr2[i10] = j10 ^ j11;
        }
        int i11 = 1;
        while (i11 <= 10) {
            int i12 = 0;
            while (i12 < 8) {
                long[] jArr4 = this._L;
                jArr4[i12] = 0;
                long[] jArr5 = C0;
                long[] jArr6 = this._K;
                long j12 = jArr5[((int) (jArr6[(i12 + 0) & 7] >>> 56)) & 255] ^ 0;
                jArr4[i12] = j12;
                long j13 = j12 ^ C1[((int) (jArr6[(i12 - 1) & 7] >>> 48)) & 255];
                jArr4[i12] = j13;
                long j14 = j13 ^ C2[((int) (jArr6[(i12 - 2) & 7] >>> 40)) & 255];
                jArr4[i12] = j14;
                long j15 = j14 ^ C3[((int) (jArr6[(i12 - 3) & 7] >>> 32)) & 255];
                jArr4[i12] = j15;
                long j16 = j15 ^ C4[((int) (jArr6[(i12 - 4) & 7] >>> 24)) & 255];
                jArr4[i12] = j16;
                long j17 = j16 ^ C5[((int) (jArr6[(i12 - 5) & 7] >>> 16)) & 255];
                jArr4[i12] = j17;
                long j18 = j17 ^ C6[((int) (jArr6[(i12 - 6) & 7] >>> 8)) & 255];
                jArr4[i12] = j18;
                jArr4[i12] = j18 ^ C7[((int) jArr6[(i12 - 7) & 7]) & 255];
                i12++;
                i11 = i11;
            }
            int i13 = i11;
            long[] jArr7 = this._L;
            long[] jArr8 = this._K;
            System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
            long[] jArr9 = this._K;
            jArr9[0] = jArr9[0] ^ this._rc[i13];
            int i14 = 0;
            while (true) {
                jArr = this._L;
                if (i14 >= 8) {
                    break;
                }
                long j19 = this._K[i14];
                jArr[i14] = j19;
                long[] jArr10 = C0;
                long[] jArr11 = this._state;
                long j20 = j19 ^ jArr10[((int) (jArr11[(i14 + 0) & 7] >>> 56)) & 255];
                jArr[i14] = j20;
                long j21 = j20 ^ C1[((int) (jArr11[(i14 - 1) & 7] >>> 48)) & 255];
                jArr[i14] = j21;
                long j22 = j21 ^ C2[((int) (jArr11[(i14 - 2) & 7] >>> 40)) & 255];
                jArr[i14] = j22;
                long j23 = j22 ^ C3[((int) (jArr11[(i14 - 3) & 7] >>> 32)) & 255];
                jArr[i14] = j23;
                long j24 = j23 ^ C4[((int) (jArr11[(i14 - 4) & 7] >>> 24)) & 255];
                jArr[i14] = j24;
                long j25 = j24 ^ C5[((int) (jArr11[(i14 - 5) & 7] >>> 16)) & 255];
                jArr[i14] = j25;
                long j26 = j25 ^ C6[((int) (jArr11[(i14 - 6) & 7] >>> 8)) & 255];
                jArr[i14] = j26;
                jArr[i14] = j26 ^ C7[((int) jArr11[(i14 - 7) & 7]) & 255];
                i14++;
            }
            long[] jArr12 = this._state;
            System.arraycopy(jArr, 0, jArr12, 0, jArr12.length);
            i11 = i13 + 1;
        }
        for (int i15 = 0; i15 < 8; i15++) {
            long[] jArr13 = this._hash;
            jArr13[i15] = jArr13[i15] ^ (this._state[i15] ^ this._block[i15]);
        }
    }

    public void reset() {
        this._bufferPos = 0;
        Arrays.fill(this._bitCount, 0);
        Arrays.fill(this._buffer, (byte) 0);
        Arrays.fill(this._hash, 0);
        Arrays.fill(this._K, 0);
        Arrays.fill(this._L, 0);
        Arrays.fill(this._block, 0);
        Arrays.fill(this._state, 0);
    }

    public void reset(Memoable memoable) {
        WhirlpoolDigest whirlpoolDigest = (WhirlpoolDigest) memoable;
        long[] jArr = whirlpoolDigest._rc;
        long[] jArr2 = this._rc;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        byte[] bArr = whirlpoolDigest._buffer;
        byte[] bArr2 = this._buffer;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this._bufferPos = whirlpoolDigest._bufferPos;
        short[] sArr = whirlpoolDigest._bitCount;
        short[] sArr2 = this._bitCount;
        System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
        long[] jArr3 = whirlpoolDigest._hash;
        long[] jArr4 = this._hash;
        System.arraycopy(jArr3, 0, jArr4, 0, jArr4.length);
        long[] jArr5 = whirlpoolDigest._K;
        long[] jArr6 = this._K;
        System.arraycopy(jArr5, 0, jArr6, 0, jArr6.length);
        long[] jArr7 = whirlpoolDigest._L;
        long[] jArr8 = this._L;
        System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
        long[] jArr9 = whirlpoolDigest._block;
        long[] jArr10 = this._block;
        System.arraycopy(jArr9, 0, jArr10, 0, jArr10.length);
        long[] jArr11 = whirlpoolDigest._state;
        long[] jArr12 = this._state;
        System.arraycopy(jArr11, 0, jArr12, 0, jArr12.length);
    }

    public void update(byte b10) {
        byte[] bArr = this._buffer;
        int i10 = this._bufferPos;
        bArr[i10] = b10;
        int i11 = i10 + 1;
        this._bufferPos = i11;
        if (i11 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        increment();
    }

    public void update(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
    }
}
