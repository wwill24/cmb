package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

public class NoekeonEngine implements BlockCipher {
    private static final int SIZE = 16;
    private static final byte[] roundConstants = {Byte.MIN_VALUE, 27, 54, 108, -40, -85, 77, -102, 47, 94, PSSSigner.TRAILER_IMPLICIT, 99, -58, -105, 53, 106, -44};
    private boolean _forEncryption;
    private boolean _initialised = false;

    /* renamed from: k  reason: collision with root package name */
    private final int[] f41431k = new int[4];

    private int decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i12 = i11;
        int bigEndianToInt = Pack.bigEndianToInt(bArr, i10);
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr3, i10 + 4);
        int bigEndianToInt3 = Pack.bigEndianToInt(bArr3, i10 + 8);
        int bigEndianToInt4 = Pack.bigEndianToInt(bArr3, i10 + 12);
        int[] iArr = this.f41431k;
        int i13 = iArr[0];
        int i14 = iArr[1];
        int i15 = iArr[2];
        int i16 = iArr[3];
        int i17 = 16;
        while (true) {
            byte b10 = bigEndianToInt ^ bigEndianToInt3;
            byte rotateLeft = b10 ^ (Integers.rotateLeft(b10, 8) ^ Integers.rotateLeft(b10, 24));
            byte b11 = bigEndianToInt2 ^ i14;
            byte b12 = bigEndianToInt4 ^ i16;
            byte b13 = b11 ^ b12;
            byte rotateLeft2 = (Integers.rotateLeft(b13, 24) ^ Integers.rotateLeft(b13, 8)) ^ b13;
            byte b14 = b11 ^ rotateLeft;
            byte b15 = (bigEndianToInt3 ^ i15) ^ rotateLeft2;
            byte b16 = b12 ^ rotateLeft;
            byte b17 = ((bigEndianToInt ^ i13) ^ rotateLeft2) ^ (roundConstants[i17] & 255);
            i17--;
            if (i17 < 0) {
                Pack.intToBigEndian((int) b17, bArr4, i12);
                Pack.intToBigEndian((int) b14, bArr4, i12 + 4);
                Pack.intToBigEndian((int) b15, bArr4, i12 + 8);
                Pack.intToBigEndian((int) b16, bArr4, i12 + 12);
                return 16;
            }
            int rotateLeft3 = Integers.rotateLeft(b14, 1);
            int rotateLeft4 = Integers.rotateLeft(b15, 5);
            int rotateLeft5 = Integers.rotateLeft(b16, 2);
            byte b18 = rotateLeft3 ^ (rotateLeft5 | rotateLeft4);
            int i18 = ~b18;
            byte b19 = b17 ^ (rotateLeft4 & i18);
            byte b20 = (rotateLeft4 ^ (i18 ^ rotateLeft5)) ^ b19;
            byte b21 = b18 ^ (b19 | b20);
            bigEndianToInt2 = Integers.rotateLeft(b21, 31);
            bigEndianToInt3 = Integers.rotateLeft(b20, 27);
            int rotateLeft6 = Integers.rotateLeft(b19, 30);
            bigEndianToInt = rotateLeft5 ^ (b20 & b21);
            bigEndianToInt4 = rotateLeft6;
        }
    }

    private int encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i12 = i11;
        int bigEndianToInt = Pack.bigEndianToInt(bArr, i10);
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr3, i10 + 4);
        int bigEndianToInt3 = Pack.bigEndianToInt(bArr3, i10 + 8);
        int bigEndianToInt4 = Pack.bigEndianToInt(bArr3, i10 + 12);
        int[] iArr = this.f41431k;
        int i13 = 0;
        int i14 = iArr[0];
        int i15 = iArr[1];
        int i16 = iArr[2];
        int i17 = iArr[3];
        while (true) {
            byte b10 = bigEndianToInt ^ (roundConstants[i13] & 255);
            byte b11 = b10 ^ bigEndianToInt3;
            byte rotateLeft = b11 ^ (Integers.rotateLeft(b11, 8) ^ Integers.rotateLeft(b11, 24));
            byte b12 = bigEndianToInt2 ^ i15;
            byte b13 = bigEndianToInt4 ^ i17;
            byte b14 = b12 ^ b13;
            byte rotateLeft2 = b14 ^ (Integers.rotateLeft(b14, 24) ^ Integers.rotateLeft(b14, 8));
            byte b15 = (b10 ^ i14) ^ rotateLeft2;
            byte b16 = b12 ^ rotateLeft;
            byte b17 = (bigEndianToInt3 ^ i16) ^ rotateLeft2;
            byte b18 = b13 ^ rotateLeft;
            i13++;
            if (i13 > 16) {
                Pack.intToBigEndian((int) b15, bArr4, i12);
                Pack.intToBigEndian((int) b16, bArr4, i12 + 4);
                Pack.intToBigEndian((int) b17, bArr4, i12 + 8);
                Pack.intToBigEndian((int) b18, bArr4, i12 + 12);
                return 16;
            }
            int rotateLeft3 = Integers.rotateLeft(b16, 1);
            int rotateLeft4 = Integers.rotateLeft(b17, 5);
            int rotateLeft5 = Integers.rotateLeft(b18, 2);
            byte b19 = rotateLeft3 ^ (rotateLeft5 | rotateLeft4);
            int i18 = ~b19;
            byte b20 = b15 ^ (rotateLeft4 & i18);
            byte b21 = (rotateLeft4 ^ (i18 ^ rotateLeft5)) ^ b20;
            byte b22 = b19 ^ (b20 | b21);
            bigEndianToInt2 = Integers.rotateLeft(b22, 31);
            bigEndianToInt3 = Integers.rotateLeft(b21, 27);
            int rotateLeft6 = Integers.rotateLeft(b20, 30);
            bigEndianToInt = rotateLeft5 ^ (b21 & b22);
            bigEndianToInt4 = rotateLeft6;
        }
    }

    public String getAlgorithmName() {
        return "Noekeon";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                Pack.bigEndianToInt(key, 0, this.f41431k, 0, 4);
                if (!z10) {
                    int[] iArr = this.f41431k;
                    int i10 = iArr[0];
                    int i11 = iArr[1];
                    int i12 = iArr[2];
                    int i13 = iArr[3];
                    int i14 = i10 ^ i12;
                    int rotateLeft = i14 ^ (Integers.rotateLeft(i14, 8) ^ Integers.rotateLeft(i14, 24));
                    int i15 = i11 ^ i13;
                    int rotateLeft2 = (Integers.rotateLeft(i15, 8) ^ Integers.rotateLeft(i15, 24)) ^ i15;
                    int i16 = i11 ^ rotateLeft;
                    int i17 = i13 ^ rotateLeft;
                    int[] iArr2 = this.f41431k;
                    iArr2[0] = i10 ^ rotateLeft2;
                    iArr2[1] = i16;
                    iArr2[2] = i12 ^ rotateLeft2;
                    iArr2[3] = i17;
                }
                this._forEncryption = z10;
                this._initialised = true;
                return;
            }
            throw new IllegalArgumentException("Key length not 128 bits.");
        }
        throw new IllegalArgumentException("invalid parameter passed to Noekeon init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (!this._initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i10 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 <= bArr2.length - 16) {
            return this._forEncryption ? encryptBlock(bArr, i10, bArr2, i11) : decryptBlock(bArr, i10, bArr2, i11);
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
