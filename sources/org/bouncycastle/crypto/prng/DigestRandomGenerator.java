package org.bouncycastle.crypto.prng;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;

public class DigestRandomGenerator implements RandomGenerator {
    private static long CYCLE_COUNT = 10;
    private Digest digest;
    private byte[] seed;
    private long seedCounter = 1;
    private byte[] state;
    private long stateCounter;

    public DigestRandomGenerator(Digest digest2) {
        this.digest = digest2;
        this.seed = new byte[digest2.getDigestSize()];
        this.state = new byte[digest2.getDigestSize()];
        this.stateCounter = 1;
    }

    private void cycleSeed() {
        digestUpdate(this.seed);
        long j10 = this.seedCounter;
        this.seedCounter = 1 + j10;
        digestAddCounter(j10);
        digestDoFinal(this.seed);
    }

    private void digestAddCounter(long j10) {
        for (int i10 = 0; i10 != 8; i10++) {
            this.digest.update((byte) ((int) j10));
            j10 >>>= 8;
        }
    }

    private void digestDoFinal(byte[] bArr) {
        this.digest.doFinal(bArr, 0);
    }

    private void digestUpdate(byte[] bArr) {
        this.digest.update(bArr, 0, bArr.length);
    }

    private void generateState() {
        long j10 = this.stateCounter;
        this.stateCounter = 1 + j10;
        digestAddCounter(j10);
        digestUpdate(this.state);
        digestUpdate(this.seed);
        digestDoFinal(this.state);
        if (this.stateCounter % CYCLE_COUNT == 0) {
            cycleSeed();
        }
    }

    public void addSeedMaterial(long j10) {
        synchronized (this) {
            digestAddCounter(j10);
            digestUpdate(this.seed);
            digestDoFinal(this.seed);
        }
    }

    public void addSeedMaterial(byte[] bArr) {
        synchronized (this) {
            if (!Arrays.isNullOrEmpty(bArr)) {
                digestUpdate(bArr);
            }
            digestUpdate(this.seed);
            digestDoFinal(this.seed);
        }
    }

    public void nextBytes(byte[] bArr) {
        nextBytes(bArr, 0, bArr.length);
    }

    public void nextBytes(byte[] bArr, int i10, int i11) {
        synchronized (this) {
            generateState();
            int i12 = i11 + i10;
            int i13 = 0;
            while (i10 != i12) {
                if (i13 == this.state.length) {
                    generateState();
                    i13 = 0;
                }
                bArr[i10] = this.state[i13];
                i10++;
                i13++;
            }
        }
    }
}
