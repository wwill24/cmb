package org.bouncycastle.crypto.modes.gcm;

public class BasicGCMExponentiator implements GCMExponentiator {

    /* renamed from: x  reason: collision with root package name */
    private long[] f41493x;

    public void exponentiateX(long j10, byte[] bArr) {
        long[] oneAsLongs = GCMUtil.oneAsLongs();
        if (j10 > 0) {
            long[] jArr = new long[2];
            GCMUtil.copy(this.f41493x, jArr);
            do {
                if ((1 & j10) != 0) {
                    GCMUtil.multiply(oneAsLongs, jArr);
                }
                GCMUtil.square(jArr, jArr);
                j10 >>>= 1;
            } while (j10 > 0);
        }
        GCMUtil.asBytes(oneAsLongs, bArr);
    }

    public void init(byte[] bArr) {
        this.f41493x = GCMUtil.asLongs(bArr);
    }
}
