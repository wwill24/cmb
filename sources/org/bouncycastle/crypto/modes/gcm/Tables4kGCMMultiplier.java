package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.bouncycastle.util.Pack;

public class Tables4kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private long[][] T;

    public void init(byte[] bArr) {
        if (this.T == null) {
            this.T = (long[][]) Array.newInstance(Long.TYPE, new int[]{256, 2});
        } else if (GCMUtil.areEqual(this.H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.H = bArr2;
        GCMUtil.copy(bArr, bArr2);
        GCMUtil.asLongs(this.H, this.T[1]);
        long[] jArr = this.T[1];
        GCMUtil.multiplyP7(jArr, jArr);
        for (int i10 = 2; i10 < 256; i10 += 2) {
            long[][] jArr2 = this.T;
            GCMUtil.divideP(jArr2[i10 >> 1], jArr2[i10]);
            long[][] jArr3 = this.T;
            GCMUtil.xor(jArr3[i10], jArr3[1], jArr3[i10 + 1]);
        }
    }

    public void multiplyH(byte[] bArr) {
        byte[] bArr2 = bArr;
        long[] jArr = this.T[bArr2[15] & 255];
        long j10 = jArr[0];
        long j11 = jArr[1];
        for (int i10 = 14; i10 >= 0; i10--) {
            long[] jArr2 = this.T[bArr2[i10] & 255];
            long j12 = j11 << 56;
            j11 = ((j11 >>> 8) | (j10 << 56)) ^ jArr2[1];
            j10 = (((((j10 >>> 8) ^ jArr2[0]) ^ j12) ^ (j12 >>> 1)) ^ (j12 >>> 2)) ^ (j12 >>> 7);
        }
        Pack.longToBigEndian(j10, bArr2, 0);
        Pack.longToBigEndian(j11, bArr2, 8);
    }
}
