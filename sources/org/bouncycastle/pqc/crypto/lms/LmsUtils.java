package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

class LmsUtils {
    LmsUtils() {
    }

    static void byteArray(byte[] bArr, int i10, int i11, Digest digest) {
        digest.update(bArr, i10, i11);
    }

    static void byteArray(byte[] bArr, Digest digest) {
        digest.update(bArr, 0, bArr.length);
    }

    static int calculateStrength(LMSParameters lMSParameters) {
        if (lMSParameters != null) {
            LMSigParameters lMSigParam = lMSParameters.getLMSigParam();
            return (1 << lMSigParam.getH()) * lMSigParam.getM();
        }
        throw new NullPointerException("lmsParameters cannot be null");
    }

    static void u16str(short s10, Digest digest) {
        digest.update((byte) (s10 >>> 8));
        digest.update((byte) s10);
    }

    static void u32str(int i10, Digest digest) {
        digest.update((byte) (i10 >>> 24));
        digest.update((byte) (i10 >>> 16));
        digest.update((byte) (i10 >>> 8));
        digest.update((byte) i10);
    }
}
