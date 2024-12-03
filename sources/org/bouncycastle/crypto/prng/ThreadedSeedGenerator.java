package org.bouncycastle.crypto.prng;

public class ThreadedSeedGenerator {

    private class SeedGenerator implements Runnable {
        private volatile int counter;
        private volatile boolean stop;

        private SeedGenerator() {
            this.counter = 0;
            this.stop = false;
        }

        public byte[] generateSeed(int i10, boolean z10) {
            Thread thread = new Thread(this);
            byte[] bArr = new byte[i10];
            this.counter = 0;
            this.stop = false;
            thread.start();
            if (!z10) {
                i10 *= 8;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                while (this.counter == i11) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException unused) {
                    }
                }
                i11 = this.counter;
                if (z10) {
                    bArr[i12] = (byte) (i11 & 255);
                } else {
                    int i13 = i12 / 8;
                    bArr[i13] = (byte) ((bArr[i13] << 1) | (i11 & 1));
                }
            }
            this.stop = true;
            return bArr;
        }

        public void run() {
            while (!this.stop) {
                this.counter++;
            }
        }
    }

    public byte[] generateSeed(int i10, boolean z10) {
        return new SeedGenerator().generateSeed(i10, z10);
    }
}
