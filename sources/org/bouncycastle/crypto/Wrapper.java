package org.bouncycastle.crypto;

public interface Wrapper {
    String getAlgorithmName();

    void init(boolean z10, CipherParameters cipherParameters);

    byte[] unwrap(byte[] bArr, int i10, int i11) throws InvalidCipherTextException;

    byte[] wrap(byte[] bArr, int i10, int i11);
}
