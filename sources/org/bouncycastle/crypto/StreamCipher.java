package org.bouncycastle.crypto;

public interface StreamCipher {
    String getAlgorithmName();

    void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException;

    int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException;

    void reset();

    byte returnByte(byte b10);
}
