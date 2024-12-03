package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

public class X931SecureRandom extends SecureRandom {
    private final X931RNG drbg;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    X931SecureRandom(SecureRandom secureRandom, X931RNG x931rng, boolean z10) {
        this.randomSource = secureRandom;
        this.drbg = x931rng;
        this.predictionResistant = z10;
    }

    public byte[] generateSeed(int i10) {
        return EntropyUtil.generateSeed(this.drbg.getEntropySource(), i10);
    }

    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            if (this.drbg.generate(bArr, this.predictionResistant) < 0) {
                this.drbg.reseed();
                this.drbg.generate(bArr, this.predictionResistant);
            }
        }
    }

    public void setSeed(long j10) {
        synchronized (this) {
            SecureRandom secureRandom = this.randomSource;
            if (secureRandom != null) {
                secureRandom.setSeed(j10);
            }
        }
    }

    public void setSeed(byte[] bArr) {
        synchronized (this) {
            SecureRandom secureRandom = this.randomSource;
            if (secureRandom != null) {
                secureRandom.setSeed(bArr);
            }
        }
    }
}
