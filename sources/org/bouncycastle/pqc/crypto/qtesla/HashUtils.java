package org.bouncycastle.pqc.crypto.qtesla;

import org.bouncycastle.crypto.digests.CSHAKEDigest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

class HashUtils {
    static final int SECURE_HASH_ALGORITHM_KECCAK_128_RATE = 168;
    static final int SECURE_HASH_ALGORITHM_KECCAK_256_RATE = 136;

    HashUtils() {
    }

    static void customizableSecureHashAlgorithmKECCAK128Simple(byte[] bArr, int i10, int i11, short s10, byte[] bArr2, int i12, int i13) {
        CSHAKEDigest cSHAKEDigest = new CSHAKEDigest(128, (byte[]) null, new byte[]{(byte) s10, (byte) (s10 >> 8)});
        cSHAKEDigest.update(bArr2, i12, i13);
        cSHAKEDigest.doFinal(bArr, i10, i11);
    }

    static void customizableSecureHashAlgorithmKECCAK256Simple(byte[] bArr, int i10, int i11, short s10, byte[] bArr2, int i12, int i13) {
        CSHAKEDigest cSHAKEDigest = new CSHAKEDigest(256, (byte[]) null, new byte[]{(byte) s10, (byte) (s10 >> 8)});
        cSHAKEDigest.update(bArr2, i12, i13);
        cSHAKEDigest.doFinal(bArr, i10, i11);
    }

    static void secureHashAlgorithmKECCAK128(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        sHAKEDigest.update(bArr2, i12, i13);
        sHAKEDigest.doFinal(bArr, i10, i11);
    }

    static void secureHashAlgorithmKECCAK256(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.update(bArr2, i12, i13);
        sHAKEDigest.doFinal(bArr, i10, i11);
    }
}
