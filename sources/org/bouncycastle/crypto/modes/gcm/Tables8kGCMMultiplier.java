package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.bouncycastle.util.Pack;

public class Tables8kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private long[][][] T;

    public void init(byte[] bArr) {
        if (this.T == null) {
            this.T = (long[][][]) Array.newInstance(Long.TYPE, new int[]{32, 16, 2});
        } else if (GCMUtil.areEqual(this.H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.H = bArr2;
        GCMUtil.copy(bArr, bArr2);
        for (int i10 = 0; i10 < 32; i10++) {
            long[][][] jArr = this.T;
            long[][] jArr2 = jArr[i10];
            if (i10 == 0) {
                GCMUtil.asLongs(this.H, jArr2[1]);
                long[] jArr3 = jArr2[1];
                GCMUtil.multiplyP3(jArr3, jArr3);
            } else {
                GCMUtil.multiplyP4(jArr[i10 - 1][1], jArr2[1]);
            }
            for (int i11 = 2; i11 < 16; i11 += 2) {
                GCMUtil.divideP(jArr2[i11 >> 1], jArr2[i11]);
                GCMUtil.xor(jArr2[i11], jArr2[1], jArr2[i11 + 1]);
            }
        }
    }

    public void multiplyH(byte[] bArr) {
        long j10 = 0;
        long j11 = 0;
        for (int i10 = 15; i10 >= 0; i10--) {
            long[][][] jArr = this.T;
            int i11 = i10 + i10;
            long[][] jArr2 = jArr[i11 + 1];
            byte b10 = bArr[i10];
            long[] jArr3 = jArr2[b10 & 15];
            long[] jArr4 = jArr[i11][(b10 & 240) >>> 4];
            j10 ^= jArr3[0] ^ jArr4[0];
            j11 ^= jArr4[1] ^ jArr3[1];
        }
        Pack.longToBigEndian(j10, bArr, 0);
        Pack.longToBigEndian(j11, bArr, 8);
    }
}
