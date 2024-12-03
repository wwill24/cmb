package org.bouncycastle.crypto;

public interface AsymmetricBlockCipher {
    int getInputBlockSize();

    int getOutputBlockSize();

    void init(boolean z10, CipherParameters cipherParameters);

    byte[] processBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException;
}
