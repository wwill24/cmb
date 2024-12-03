package org.bouncycastle.crypto.digests;

public class SHA3Digest extends KeccakDigest {
    public SHA3Digest() {
        this(256);
    }

    public SHA3Digest(int i10) {
        super(checkBitLength(i10));
    }

    public SHA3Digest(SHA3Digest sHA3Digest) {
        super((KeccakDigest) sHA3Digest);
    }

    private static int checkBitLength(int i10) {
        if (i10 == 224 || i10 == 256 || i10 == 384 || i10 == 512) {
            return i10;
        }
        throw new IllegalArgumentException("'bitLength' " + i10 + " not supported for SHA-3");
    }

    public int doFinal(byte[] bArr, int i10) {
        absorbBits(2, 2);
        return super.doFinal(bArr, i10);
    }

    /* access modifiers changed from: protected */
    public int doFinal(byte[] bArr, int i10, byte b10, int i11) {
        if (i11 < 0 || i11 > 7) {
            throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
        }
        int i12 = (b10 & ((1 << i11) - 1)) | (2 << i11);
        int i13 = i11 + 2;
        if (i13 >= 8) {
            absorb((byte) i12);
            i13 -= 8;
            i12 >>>= 8;
        }
        return super.doFinal(bArr, i10, (byte) i12, i13);
    }

    public String getAlgorithmName() {
        return "SHA3-" + this.fixedOutputLength;
    }
}
