package org.bouncycastle.crypto;

public interface Signer {
    byte[] generateSignature() throws CryptoException, DataLengthException;

    void init(boolean z10, CipherParameters cipherParameters);

    void reset();

    void update(byte b10);

    void update(byte[] bArr, int i10, int i11);

    boolean verifySignature(byte[] bArr);
}
