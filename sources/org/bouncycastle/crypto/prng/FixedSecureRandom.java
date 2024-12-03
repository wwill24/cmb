package org.bouncycastle.crypto.prng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

public class FixedSecureRandom extends SecureRandom {
    private byte[] _data;
    private int _index;
    private int _intPad;

    public FixedSecureRandom(boolean z10, byte[] bArr) {
        this(z10, new byte[][]{bArr});
    }

    public FixedSecureRandom(boolean z10, byte[][] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        while (i10 != bArr.length) {
            try {
                byteArrayOutputStream.write(bArr[i10]);
                i10++;
            } catch (IOException unused) {
                throw new IllegalArgumentException("can't save value array.");
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this._data = byteArray;
        if (z10) {
            this._intPad = byteArray.length % 4;
        }
    }

    public FixedSecureRandom(byte[] bArr) {
        this(false, new byte[][]{bArr});
    }

    public FixedSecureRandom(byte[][] bArr) {
        this(false, bArr);
    }

    private int nextValue() {
        byte[] bArr = this._data;
        int i10 = this._index;
        this._index = i10 + 1;
        return bArr[i10] & 255;
    }

    public byte[] generateSeed(int i10) {
        byte[] bArr = new byte[i10];
        nextBytes(bArr);
        return bArr;
    }

    public boolean isExhausted() {
        return this._index == this._data.length;
    }

    public void nextBytes(byte[] bArr) {
        System.arraycopy(this._data, this._index, bArr, 0, bArr.length);
        this._index += bArr.length;
    }

    public int nextInt() {
        int nextValue = (nextValue() << 24) | 0 | (nextValue() << 16);
        int i10 = this._intPad;
        if (i10 == 2) {
            this._intPad = i10 - 1;
        } else {
            nextValue |= nextValue() << 8;
        }
        int i11 = this._intPad;
        if (i11 != 1) {
            return nextValue | nextValue();
        }
        this._intPad = i11 - 1;
        return nextValue;
    }

    public long nextLong() {
        return (((long) nextValue()) << 56) | 0 | (((long) nextValue()) << 48) | (((long) nextValue()) << 40) | (((long) nextValue()) << 32) | (((long) nextValue()) << 24) | (((long) nextValue()) << 16) | (((long) nextValue()) << 8) | ((long) nextValue());
    }
}
