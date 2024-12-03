package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;

public class NonMemoableDigest implements ExtendedDigest {
    private ExtendedDigest baseDigest;

    public NonMemoableDigest(ExtendedDigest extendedDigest) {
        if (extendedDigest != null) {
            this.baseDigest = extendedDigest;
            return;
        }
        throw new IllegalArgumentException("baseDigest must not be null");
    }

    public int doFinal(byte[] bArr, int i10) {
        return this.baseDigest.doFinal(bArr, i10);
    }

    public String getAlgorithmName() {
        return this.baseDigest.getAlgorithmName();
    }

    public int getByteLength() {
        return this.baseDigest.getByteLength();
    }

    public int getDigestSize() {
        return this.baseDigest.getDigestSize();
    }

    public void reset() {
        this.baseDigest.reset();
    }

    public void update(byte b10) {
        this.baseDigest.update(b10);
    }

    public void update(byte[] bArr, int i10, int i11) {
        this.baseDigest.update(bArr, i10, i11);
    }
}
