package org.bouncycastle.crypto.modes.gcm;

import java.util.Vector;

public class Tables1kGCMExponentiator implements GCMExponentiator {
    private Vector lookupPowX2;

    private void ensureAvailable(int i10) {
        int size = this.lookupPowX2.size() - 1;
        if (size < i10) {
            long[] jArr = (long[]) this.lookupPowX2.elementAt(size);
            while (true) {
                long[] jArr2 = new long[2];
                GCMUtil.square(jArr, jArr2);
                this.lookupPowX2.addElement(jArr2);
                size++;
                if (size < i10) {
                    jArr = jArr2;
                } else {
                    return;
                }
            }
        }
    }

    public void exponentiateX(long j10, byte[] bArr) {
        long[] oneAsLongs = GCMUtil.oneAsLongs();
        int i10 = 0;
        while (j10 > 0) {
            if ((1 & j10) != 0) {
                ensureAvailable(i10);
                GCMUtil.multiply(oneAsLongs, (long[]) this.lookupPowX2.elementAt(i10));
            }
            i10++;
            j10 >>>= 1;
        }
        GCMUtil.asBytes(oneAsLongs, bArr);
    }

    public void init(byte[] bArr) {
        long[] asLongs = GCMUtil.asLongs(bArr);
        Vector vector = this.lookupPowX2;
        if (vector == null || 0 == GCMUtil.areEqual(asLongs, (long[]) vector.elementAt(0))) {
            Vector vector2 = new Vector(8);
            this.lookupPowX2 = vector2;
            vector2.addElement(asLongs);
        }
    }
}
