package org.bouncycastle.crypto.prng;

public class ReversedWindowGenerator implements RandomGenerator {
    private final RandomGenerator generator;
    private byte[] window;
    private int windowCount;

    public ReversedWindowGenerator(RandomGenerator randomGenerator, int i10) {
        if (randomGenerator == null) {
            throw new IllegalArgumentException("generator cannot be null");
        } else if (i10 >= 2) {
            this.generator = randomGenerator;
            this.window = new byte[i10];
        } else {
            throw new IllegalArgumentException("windowSize must be at least 2");
        }
    }

    private void doNextBytes(byte[] bArr, int i10, int i11) {
        synchronized (this) {
            for (int i12 = 0; i12 < i11; i12++) {
                if (this.windowCount < 1) {
                    RandomGenerator randomGenerator = this.generator;
                    byte[] bArr2 = this.window;
                    randomGenerator.nextBytes(bArr2, 0, bArr2.length);
                    this.windowCount = this.window.length;
                }
                byte[] bArr3 = this.window;
                int i13 = this.windowCount - 1;
                this.windowCount = i13;
                bArr[i12 + i10] = bArr3[i13];
            }
        }
    }

    public void addSeedMaterial(long j10) {
        synchronized (this) {
            this.windowCount = 0;
            this.generator.addSeedMaterial(j10);
        }
    }

    public void addSeedMaterial(byte[] bArr) {
        synchronized (this) {
            this.windowCount = 0;
            this.generator.addSeedMaterial(bArr);
        }
    }

    public void nextBytes(byte[] bArr) {
        doNextBytes(bArr, 0, bArr.length);
    }

    public void nextBytes(byte[] bArr, int i10, int i11) {
        doNextBytes(bArr, i10, i11);
    }
}
