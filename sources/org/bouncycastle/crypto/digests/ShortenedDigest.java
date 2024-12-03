package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;

public class ShortenedDigest implements ExtendedDigest {
    private ExtendedDigest baseDigest;
    private int length;

    public ShortenedDigest(ExtendedDigest extendedDigest, int i10) {
        if (extendedDigest == null) {
            throw new IllegalArgumentException("baseDigest must not be null");
        } else if (i10 <= extendedDigest.getDigestSize()) {
            this.baseDigest = extendedDigest;
            this.length = i10;
        } else {
            throw new IllegalArgumentException("baseDigest output not large enough to support length");
        }
    }

    public int doFinal(byte[] bArr, int i10) {
        byte[] bArr2 = new byte[this.baseDigest.getDigestSize()];
        this.baseDigest.doFinal(bArr2, 0);
        System.arraycopy(bArr2, 0, bArr, i10, this.length);
        return this.length;
    }

    public String getAlgorithmName() {
        return this.baseDigest.getAlgorithmName() + "(" + (this.length * 8) + ")";
    }

    public int getByteLength() {
        return this.baseDigest.getByteLength();
    }

    public int getDigestSize() {
        return this.length;
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
