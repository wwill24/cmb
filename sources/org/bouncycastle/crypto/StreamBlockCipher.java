package org.bouncycastle.crypto;

public abstract class StreamBlockCipher implements BlockCipher, StreamCipher {
    private final BlockCipher cipher;

    protected StreamBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
    }

    /* access modifiers changed from: protected */
    public abstract byte calculateByte(byte b10);

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        int i13 = i10 + i11;
        if (i13 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        } else if (i12 + i11 <= bArr2.length) {
            while (i10 < i13) {
                bArr2[i12] = calculateByte(bArr[i10]);
                i12++;
                i10++;
            }
            return i11;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final byte returnByte(byte b10) {
        return calculateByte(b10);
    }
}
