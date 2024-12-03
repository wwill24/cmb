package org.bouncycastle.crypto;

public interface DerivationFunction {
    int generateBytes(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException;

    void init(DerivationParameters derivationParameters);
}
