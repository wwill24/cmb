package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;
import org.jivesoftware.smack.datatypes.UInt32;

public class ChaChaEngine extends Salsa20Engine {
    public ChaChaEngine() {
    }

    public ChaChaEngine(int i10) {
        super(i10);
    }

    public static void chachaCore(int i10, int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i11 = 16;
        if (iArr3.length != 16) {
            throw new IllegalArgumentException();
        } else if (iArr4.length != 16) {
            throw new IllegalArgumentException();
        } else if (i10 % 2 == 0) {
            char c10 = 0;
            int i12 = iArr3[0];
            int i13 = iArr3[1];
            int i14 = iArr3[2];
            int i15 = iArr3[3];
            int i16 = iArr3[4];
            int i17 = iArr3[5];
            int i18 = iArr3[6];
            int i19 = 7;
            int i20 = iArr3[7];
            int i21 = 8;
            int i22 = iArr3[8];
            int i23 = iArr3[9];
            int i24 = iArr3[10];
            int i25 = iArr3[11];
            int i26 = 12;
            int i27 = iArr3[12];
            int i28 = iArr3[13];
            int i29 = iArr3[14];
            int i30 = iArr3[15];
            int i31 = i29;
            int i32 = i28;
            int i33 = i27;
            int i34 = i25;
            int i35 = i24;
            int i36 = i23;
            int i37 = i22;
            int i38 = i20;
            int i39 = i18;
            int i40 = i17;
            int i41 = i16;
            int i42 = i15;
            int i43 = i14;
            int i44 = i13;
            int i45 = i12;
            int i46 = i10;
            while (i46 > 0) {
                int i47 = i45 + i41;
                int rotateLeft = Integers.rotateLeft(i33 ^ i47, i11);
                int i48 = i37 + rotateLeft;
                int rotateLeft2 = Integers.rotateLeft(i41 ^ i48, i26);
                int i49 = i47 + rotateLeft2;
                int rotateLeft3 = Integers.rotateLeft(rotateLeft ^ i49, i21);
                int i50 = i48 + rotateLeft3;
                int rotateLeft4 = Integers.rotateLeft(rotateLeft2 ^ i50, i19);
                int i51 = i44 + i40;
                int rotateLeft5 = Integers.rotateLeft(i32 ^ i51, i11);
                int i52 = i36 + rotateLeft5;
                int rotateLeft6 = Integers.rotateLeft(i40 ^ i52, i26);
                int i53 = i51 + rotateLeft6;
                int rotateLeft7 = Integers.rotateLeft(rotateLeft5 ^ i53, i21);
                int i54 = i52 + rotateLeft7;
                int rotateLeft8 = Integers.rotateLeft(rotateLeft6 ^ i54, i19);
                int i55 = i43 + i39;
                int rotateLeft9 = Integers.rotateLeft(i31 ^ i55, i11);
                int i56 = i35 + rotateLeft9;
                int rotateLeft10 = Integers.rotateLeft(i39 ^ i56, i26);
                int i57 = i55 + rotateLeft10;
                int rotateLeft11 = Integers.rotateLeft(rotateLeft9 ^ i57, i21);
                int i58 = i56 + rotateLeft11;
                int rotateLeft12 = Integers.rotateLeft(rotateLeft10 ^ i58, i19);
                int i59 = i42 + i38;
                int rotateLeft13 = Integers.rotateLeft(i30 ^ i59, 16);
                int i60 = i34 + rotateLeft13;
                int rotateLeft14 = Integers.rotateLeft(i38 ^ i60, i26);
                int i61 = i59 + rotateLeft14;
                int rotateLeft15 = Integers.rotateLeft(rotateLeft13 ^ i61, 8);
                int i62 = i60 + rotateLeft15;
                int rotateLeft16 = Integers.rotateLeft(rotateLeft14 ^ i62, 7);
                int i63 = i49 + rotateLeft8;
                int rotateLeft17 = Integers.rotateLeft(rotateLeft15 ^ i63, 16);
                int i64 = i58 + rotateLeft17;
                int rotateLeft18 = Integers.rotateLeft(rotateLeft8 ^ i64, 12);
                i45 = i63 + rotateLeft18;
                i30 = Integers.rotateLeft(rotateLeft17 ^ i45, 8);
                i35 = i64 + i30;
                i40 = Integers.rotateLeft(rotateLeft18 ^ i35, 7);
                int i65 = i53 + rotateLeft12;
                int rotateLeft19 = Integers.rotateLeft(rotateLeft3 ^ i65, 16);
                int i66 = i62 + rotateLeft19;
                int rotateLeft20 = Integers.rotateLeft(rotateLeft12 ^ i66, 12);
                i44 = i65 + rotateLeft20;
                i33 = Integers.rotateLeft(rotateLeft19 ^ i44, 8);
                i34 = i66 + i33;
                i39 = Integers.rotateLeft(rotateLeft20 ^ i34, 7);
                int i67 = i57 + rotateLeft16;
                int rotateLeft21 = Integers.rotateLeft(rotateLeft7 ^ i67, 16);
                int i68 = i50 + rotateLeft21;
                int rotateLeft22 = Integers.rotateLeft(rotateLeft16 ^ i68, 12);
                i43 = i67 + rotateLeft22;
                i32 = Integers.rotateLeft(rotateLeft21 ^ i43, 8);
                i37 = i68 + i32;
                i38 = Integers.rotateLeft(rotateLeft22 ^ i37, 7);
                int i69 = i61 + rotateLeft4;
                i11 = 16;
                int rotateLeft23 = Integers.rotateLeft(rotateLeft11 ^ i69, 16);
                int i70 = i54 + rotateLeft23;
                int rotateLeft24 = Integers.rotateLeft(rotateLeft4 ^ i70, 12);
                i42 = i69 + rotateLeft24;
                i31 = Integers.rotateLeft(rotateLeft23 ^ i42, 8);
                i36 = i70 + i31;
                i41 = Integers.rotateLeft(rotateLeft24 ^ i36, 7);
                i46 -= 2;
                c10 = 0;
                i26 = 12;
                i21 = 8;
                i19 = 7;
            }
            iArr4[c10] = i45 + iArr3[c10];
            iArr4[1] = i44 + iArr3[1];
            iArr4[2] = i43 + iArr3[2];
            iArr4[3] = i42 + iArr3[3];
            iArr4[4] = i41 + iArr3[4];
            iArr4[5] = i40 + iArr3[5];
            iArr4[6] = i39 + iArr3[6];
            iArr4[7] = i38 + iArr3[7];
            iArr4[8] = i37 + iArr3[8];
            iArr4[9] = i36 + iArr3[9];
            iArr4[10] = i35 + iArr3[10];
            iArr4[11] = i34 + iArr3[11];
            iArr4[12] = i33 + iArr3[12];
            iArr4[13] = i32 + iArr3[13];
            iArr4[14] = i31 + iArr3[14];
            iArr4[15] = i30 + iArr3[15];
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    /* access modifiers changed from: protected */
    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i10 = iArr[12] + 1;
        iArr[12] = i10;
        if (i10 == 0) {
            iArr[13] = iArr[13] + 1;
        }
    }

    /* access modifiers changed from: protected */
    public void advanceCounter(long j10) {
        int i10 = (int) (j10 >>> 32);
        int i11 = (int) j10;
        if (i10 > 0) {
            int[] iArr = this.engineState;
            iArr[13] = iArr[13] + i10;
        }
        int[] iArr2 = this.engineState;
        int i12 = iArr2[12];
        int i13 = i11 + i12;
        iArr2[12] = i13;
        if (i12 != 0 && i13 < i12) {
            iArr2[13] = iArr2[13] + 1;
        }
    }

    /* access modifiers changed from: protected */
    public void generateKeyStream(byte[] bArr) {
        chachaCore(this.rounds, this.engineState, this.f41435x);
        Pack.intToLittleEndian(this.f41435x, bArr, 0);
    }

    public String getAlgorithmName() {
        return "ChaCha" + this.rounds;
    }

    /* access modifiers changed from: protected */
    public long getCounter() {
        int[] iArr = this.engineState;
        return (((long) iArr[13]) << 32) | (((long) iArr[12]) & UInt32.MAX_VALUE_LONG);
    }

    /* access modifiers changed from: protected */
    public void resetCounter() {
        int[] iArr = this.engineState;
        iArr[13] = 0;
        iArr[12] = 0;
    }

    /* access modifiers changed from: protected */
    public void retreatCounter() {
        int[] iArr = this.engineState;
        int i10 = iArr[12];
        if (i10 == 0 && iArr[13] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int i11 = i10 - 1;
        iArr[12] = i11;
        if (i11 == -1) {
            iArr[13] = iArr[13] - 1;
        }
    }

    /* access modifiers changed from: protected */
    public void retreatCounter(long j10) {
        int i10 = (int) (j10 >>> 32);
        int i11 = (int) j10;
        if (i10 != 0) {
            int[] iArr = this.engineState;
            int i12 = iArr[13];
            if ((((long) i12) & UInt32.MAX_VALUE_LONG) >= (((long) i10) & UInt32.MAX_VALUE_LONG)) {
                iArr[13] = i12 - i10;
            } else {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr2 = this.engineState;
        int i13 = iArr2[12];
        if ((((long) i13) & UInt32.MAX_VALUE_LONG) >= (UInt32.MAX_VALUE_LONG & ((long) i11))) {
            iArr2[12] = i13 - i11;
            return;
        }
        int i14 = iArr2[13];
        if (i14 != 0) {
            iArr2[13] = i14 - 1;
            iArr2[12] = i13 - i11;
            return;
        }
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    /* access modifiers changed from: protected */
    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length == 16 || bArr.length == 32) {
                packTauOrSigma(bArr.length, this.engineState, 0);
                Pack.littleEndianToInt(bArr, 0, this.engineState, 4, 4);
                Pack.littleEndianToInt(bArr, bArr.length - 16, this.engineState, 8, 4);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
            }
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 14, 2);
    }
}
