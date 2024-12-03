package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA512Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 64;

    public SHA512Digest() {
    }

    public SHA512Digest(SHA512Digest sHA512Digest) {
        super(sHA512Digest);
    }

    public SHA512Digest(byte[] bArr) {
        restoreState(bArr);
    }

    public Memoable copy() {
        return new SHA512Digest(this);
    }

    public int doFinal(byte[] bArr, int i10) {
        finish();
        Pack.longToBigEndian(this.H1, bArr, i10);
        Pack.longToBigEndian(this.H2, bArr, i10 + 8);
        Pack.longToBigEndian(this.H3, bArr, i10 + 16);
        Pack.longToBigEndian(this.H4, bArr, i10 + 24);
        Pack.longToBigEndian(this.H5, bArr, i10 + 32);
        Pack.longToBigEndian(this.H6, bArr, i10 + 40);
        Pack.longToBigEndian(this.H7, bArr, i10 + 48);
        Pack.longToBigEndian(this.H8, bArr, i10 + 56);
        reset();
        return 64;
    }

    public String getAlgorithmName() {
        return "SHA-512";
    }

    public int getDigestSize() {
        return 64;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[getEncodedStateSize()];
        super.populateState(bArr);
        return bArr;
    }

    public void reset() {
        super.reset();
        this.H1 = 7640891576956012808L;
        this.H2 = -4942790177534073029L;
        this.H3 = 4354685564936845355L;
        this.H4 = -6534734903238641935L;
        this.H5 = 5840696475078001361L;
        this.H6 = -7276294671716946913L;
        this.H7 = 2270897969802886507L;
        this.H8 = 6620516959819538809L;
    }

    public void reset(Memoable memoable) {
        copyIn((SHA512Digest) memoable);
    }
}
