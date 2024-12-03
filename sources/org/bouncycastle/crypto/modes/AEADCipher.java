package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

public interface AEADCipher {
    int doFinal(byte[] bArr, int i10) throws IllegalStateException, InvalidCipherTextException;

    String getAlgorithmName();

    byte[] getMac();

    int getOutputSize(int i10);

    int getUpdateOutputSize(int i10);

    void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException;

    void processAADByte(byte b10);

    void processAADBytes(byte[] bArr, int i10, int i11);

    int processByte(byte b10, byte[] bArr, int i10) throws DataLengthException;

    int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException;

    void reset();
}
