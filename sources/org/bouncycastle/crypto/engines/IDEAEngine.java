package org.bouncycastle.crypto.engines;

import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class IDEAEngine implements BlockCipher {
    private static final int BASE = 65537;
    protected static final int BLOCK_SIZE = 8;
    private static final int MASK = 65535;
    private int[] workingKey = null;

    private int bytesToWord(byte[] bArr, int i10) {
        return ((bArr[i10] << 8) & 65280) + (bArr[i10 + 1] & 255);
    }

    private int[] expandKey(byte[] bArr) {
        int i10;
        int[] iArr = new int[52];
        int i11 = 0;
        if (bArr.length < 16) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
            bArr = bArr2;
        }
        while (true) {
            if (i11 >= 8) {
                break;
            }
            iArr[i11] = bytesToWord(bArr, i11 * 2);
            i11++;
        }
        for (i10 = 8; i10 < 52; i10++) {
            int i12 = i10 & 7;
            if (i12 < 6) {
                iArr[i10] = (((iArr[i10 - 7] & Opcodes.LAND) << 9) | (iArr[i10 - 6] >> 7)) & 65535;
            } else if (i12 == 6) {
                iArr[i10] = (((iArr[i10 - 7] & Opcodes.LAND) << 9) | (iArr[i10 - 14] >> 7)) & 65535;
            } else {
                iArr[i10] = (((iArr[i10 - 15] & Opcodes.LAND) << 9) | (iArr[i10 - 14] >> 7)) & 65535;
            }
        }
        return iArr;
    }

    private int[] generateWorkingKey(boolean z10, byte[] bArr) {
        return z10 ? expandKey(bArr) : invertKey(expandKey(bArr));
    }

    private void ideaFunc(int[] iArr, byte[] bArr, int i10, byte[] bArr2, int i11) {
        int bytesToWord = bytesToWord(bArr, i10);
        int bytesToWord2 = bytesToWord(bArr, i10 + 2);
        int bytesToWord3 = bytesToWord(bArr, i10 + 4);
        int bytesToWord4 = bytesToWord(bArr, i10 + 6);
        int i12 = 0;
        int i13 = bytesToWord3;
        int i14 = bytesToWord2;
        int i15 = bytesToWord;
        int i16 = 0;
        while (i12 < 8) {
            int i17 = i16 + 1;
            int mul = mul(i15, iArr[i16]);
            int i18 = i17 + 1;
            int i19 = (i14 + iArr[i17]) & 65535;
            int i20 = i18 + 1;
            int i21 = (i13 + iArr[i18]) & 65535;
            int i22 = i20 + 1;
            int mul2 = mul(bytesToWord4, iArr[i20]);
            int i23 = i22 + 1;
            int mul3 = mul(i21 ^ mul, iArr[i22]);
            int mul4 = mul(((i19 ^ mul2) + mul3) & 65535, iArr[i23]);
            int i24 = (mul3 + mul4) & 65535;
            bytesToWord4 = mul2 ^ i24;
            i13 = i24 ^ i19;
            i12++;
            i14 = i21 ^ mul4;
            i15 = mul ^ mul4;
            i16 = i23 + 1;
        }
        int i25 = i16 + 1;
        wordToBytes(mul(i15, iArr[i16]), bArr2, i11);
        int i26 = i25 + 1;
        wordToBytes(i13 + iArr[i25], bArr2, i11 + 2);
        wordToBytes(i14 + iArr[i26], bArr2, i11 + 4);
        wordToBytes(mul(bytesToWord4, iArr[i26 + 1]), bArr2, i11 + 6);
    }

    private int[] invertKey(int[] iArr) {
        int[] iArr2 = new int[52];
        int mulInv = mulInv(iArr[0]);
        int i10 = 1;
        int addInv = addInv(iArr[1]);
        int addInv2 = addInv(iArr[2]);
        iArr2[51] = mulInv(iArr[3]);
        iArr2[50] = addInv2;
        iArr2[49] = addInv;
        int i11 = 48;
        iArr2[48] = mulInv;
        int i12 = 4;
        while (i10 < 8) {
            int i13 = i12 + 1;
            int i14 = iArr[i12];
            int i15 = i13 + 1;
            int i16 = i11 - 1;
            iArr2[i16] = iArr[i13];
            int i17 = i16 - 1;
            iArr2[i17] = i14;
            int i18 = i15 + 1;
            int mulInv2 = mulInv(iArr[i15]);
            int i19 = i18 + 1;
            int addInv3 = addInv(iArr[i18]);
            int i20 = i19 + 1;
            int addInv4 = addInv(iArr[i19]);
            int i21 = i17 - 1;
            iArr2[i21] = mulInv(iArr[i20]);
            int i22 = i21 - 1;
            iArr2[i22] = addInv3;
            int i23 = i22 - 1;
            iArr2[i23] = addInv4;
            i11 = i23 - 1;
            iArr2[i11] = mulInv2;
            i10++;
            i12 = i20 + 1;
        }
        int i24 = i12 + 1;
        int i25 = iArr[i12];
        int i26 = i24 + 1;
        int i27 = i11 - 1;
        iArr2[i27] = iArr[i24];
        int i28 = i27 - 1;
        iArr2[i28] = i25;
        int i29 = i26 + 1;
        int mulInv3 = mulInv(iArr[i26]);
        int i30 = i29 + 1;
        int addInv5 = addInv(iArr[i29]);
        int i31 = i30 + 1;
        int addInv6 = addInv(iArr[i30]);
        int i32 = i28 - 1;
        iArr2[i32] = mulInv(iArr[i31]);
        int i33 = i32 - 1;
        iArr2[i33] = addInv6;
        int i34 = i33 - 1;
        iArr2[i34] = addInv5;
        iArr2[i34 - 1] = mulInv3;
        return iArr2;
    }

    private int mul(int i10, int i11) {
        int i12;
        if (i10 == 0) {
            i12 = 65537 - i11;
        } else if (i11 == 0) {
            i12 = 65537 - i10;
        } else {
            int i13 = i10 * i11;
            int i14 = i13 & 65535;
            int i15 = i13 >>> 16;
            i12 = (i14 - i15) + (i14 < i15 ? 1 : 0);
        }
        return i12 & 65535;
    }

    private int mulInv(int i10) {
        if (i10 < 2) {
            return i10;
        }
        int i11 = 65537 / i10;
        int i12 = 65537 % i10;
        int i13 = 1;
        while (i12 != 1) {
            int i14 = i10 / i12;
            i10 %= i12;
            i13 = (i13 + (i14 * i11)) & 65535;
            if (i10 == 1) {
                return i13;
            }
            int i15 = i12 / i10;
            i12 %= i10;
            i11 = (i11 + (i15 * i13)) & 65535;
        }
        return (1 - i11) & 65535;
    }

    private void wordToBytes(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) (i10 >>> 8);
        bArr[i11 + 1] = (byte) i10;
    }

    /* access modifiers changed from: package-private */
    public int addInv(int i10) {
        return (0 - i10) & 65535;
    }

    public String getAlgorithmName() {
        return "IDEA";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(z10, ((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to IDEA init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = this.workingKey;
        if (iArr == null) {
            throw new IllegalStateException("IDEA engine not initialised");
        } else if (i10 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 + 8 <= bArr2.length) {
            ideaFunc(iArr, bArr, i10, bArr2, i11);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
