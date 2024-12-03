package org.bouncycastle.crypto;

public interface Mac {
    int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException;

    String getAlgorithmName();

    int getMacSize();

    void init(CipherParameters cipherParameters) throws IllegalArgumentException;

    void reset();

    void update(byte b10) throws IllegalStateException;

    void update(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalStateException;
}
