package org.bouncycastle.crypto.prng;

public interface RandomGenerator {
    void addSeedMaterial(long j10);

    void addSeedMaterial(byte[] bArr);

    void nextBytes(byte[] bArr);

    void nextBytes(byte[] bArr, int i10, int i11);
}
