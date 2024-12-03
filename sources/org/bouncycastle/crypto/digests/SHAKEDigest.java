package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Xof;

public class SHAKEDigest extends KeccakDigest implements Xof {
    public SHAKEDigest() {
        this(128);
    }

    public SHAKEDigest(int i10) {
        super(checkBitLength(i10));
    }

    public SHAKEDigest(SHAKEDigest sHAKEDigest) {
        super((KeccakDigest) sHAKEDigest);
    }

    private static int checkBitLength(int i10) {
        if (i10 == 128 || i10 == 256) {
            return i10;
        }
        throw new IllegalArgumentException("'bitLength' " + i10 + " not supported for SHAKE");
    }

    public int doFinal(byte[] bArr, int i10) {
        return doFinal(bArr, i10, getDigestSize());
    }

    /* access modifiers changed from: protected */
    public int doFinal(byte[] bArr, int i10, byte b10, int i11) {
        return doFinal(bArr, i10, getDigestSize(), b10, i11);
    }

    public int doFinal(byte[] bArr, int i10, int i11) {
        int doOutput = doOutput(bArr, i10, i11);
        reset();
        return doOutput;
    }

    /* access modifiers changed from: protected */
    public int doFinal(byte[] bArr, int i10, int i11, byte b10, int i12) {
        if (i12 < 0 || i12 > 7) {
            throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
        }
        int i13 = (b10 & ((1 << i12) - 1)) | (15 << i12);
        int i14 = i12 + 4;
        if (i14 >= 8) {
            absorb((byte) i13);
            i14 -= 8;
            i13 >>>= 8;
        }
        if (i14 > 0) {
            absorbBits(i13, i14);
        }
        squeeze(bArr, i10, ((long) i11) * 8);
        reset();
        return i11;
    }

    public int doOutput(byte[] bArr, int i10, int i11) {
        if (!this.squeezing) {
            absorbBits(15, 4);
        }
        squeeze(bArr, i10, ((long) i11) * 8);
        return i11;
    }

    public String getAlgorithmName() {
        return "SHAKE" + this.fixedOutputLength;
    }

    public int getDigestSize() {
        return this.fixedOutputLength / 4;
    }
}
