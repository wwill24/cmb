package org.bouncycastle.crypto.prng.drbg;

public interface SP80090DRBG {
    int generate(byte[] bArr, byte[] bArr2, boolean z10);

    int getBlockSize();

    void reseed(byte[] bArr);
}
