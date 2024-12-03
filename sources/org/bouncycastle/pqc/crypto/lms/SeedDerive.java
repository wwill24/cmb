package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

class SeedDerive {
    private final byte[] I;
    private final Digest digest;

    /* renamed from: j  reason: collision with root package name */
    private int f24004j;
    private final byte[] masterSeed;

    /* renamed from: q  reason: collision with root package name */
    private int f24005q;

    public SeedDerive(byte[] bArr, byte[] bArr2, Digest digest2) {
        this.I = bArr;
        this.masterSeed = bArr2;
        this.digest = digest2;
    }

    public void deriveSeed(byte[] bArr, boolean z10) {
        deriveSeed(bArr, z10, 0);
    }

    public void deriveSeed(byte[] bArr, boolean z10, int i10) {
        deriveSeed(bArr, i10);
        if (z10) {
            this.f24004j++;
        }
    }

    public byte[] deriveSeed(byte[] bArr, int i10) {
        if (bArr.length >= this.digest.getDigestSize()) {
            Digest digest2 = this.digest;
            byte[] bArr2 = this.I;
            digest2.update(bArr2, 0, bArr2.length);
            this.digest.update((byte) (this.f24005q >>> 24));
            this.digest.update((byte) (this.f24005q >>> 16));
            this.digest.update((byte) (this.f24005q >>> 8));
            this.digest.update((byte) this.f24005q);
            this.digest.update((byte) (this.f24004j >>> 8));
            this.digest.update((byte) this.f24004j);
            this.digest.update((byte) -1);
            Digest digest3 = this.digest;
            byte[] bArr3 = this.masterSeed;
            digest3.update(bArr3, 0, bArr3.length);
            this.digest.doFinal(bArr, i10);
            return bArr;
        }
        throw new IllegalArgumentException("target length is less than digest size.");
    }

    public byte[] getI() {
        return this.I;
    }

    public int getJ() {
        return this.f24004j;
    }

    public byte[] getMasterSeed() {
        return this.masterSeed;
    }

    public int getQ() {
        return this.f24005q;
    }

    public void setJ(int i10) {
        this.f24004j = i10;
    }

    public void setQ(int i10) {
        this.f24005q = i10;
    }
}
