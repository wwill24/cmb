package org.bouncycastle.crypto;

public interface KeyEncapsulation {
    CipherParameters decrypt(byte[] bArr, int i10, int i11, int i12);

    CipherParameters encrypt(byte[] bArr, int i10, int i11);

    void init(CipherParameters cipherParameters);
}
