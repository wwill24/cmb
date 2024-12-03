package org.bouncycastle.crypto.modes.kgcm;

import java.lang.reflect.Array;

public class Tables4kKGCMMultiplier_128 implements KGCMMultiplier {
    private long[][] T;

    public void init(long[] jArr) {
        long[][] jArr2 = this.T;
        if (jArr2 == null) {
            this.T = (long[][]) Array.newInstance(Long.TYPE, new int[]{256, 2});
        } else if (KGCMUtil_128.equal(jArr, jArr2[1])) {
            return;
        }
        KGCMUtil_128.copy(jArr, this.T[1]);
        for (int i10 = 2; i10 < 256; i10 += 2) {
            long[][] jArr3 = this.T;
            KGCMUtil_128.multiplyX(jArr3[i10 >> 1], jArr3[i10]);
            long[][] jArr4 = this.T;
            KGCMUtil_128.add(jArr4[i10], jArr4[1], jArr4[i10 + 1]);
        }
    }

    public void multiplyH(long[] jArr) {
        long[] jArr2 = new long[2];
        KGCMUtil_128.copy(this.T[((int) (jArr[1] >>> 56)) & 255], jArr2);
        for (int i10 = 14; i10 >= 0; i10--) {
            KGCMUtil_128.multiplyX8(jArr2, jArr2);
            KGCMUtil_128.add(this.T[((int) (jArr[i10 >>> 3] >>> ((i10 & 7) << 3))) & 255], jArr2, jArr2);
        }
        KGCMUtil_128.copy(jArr2, jArr);
    }
}
