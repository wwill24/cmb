package org.bouncycastle.crypto;

public interface BlockCipher {
    String getAlgorithmName();

    int getBlockSize();

    void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException;

    int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException;

    void reset();
}
