package org.bouncycastle.crypto.modes.gcm;

public interface GCMExponentiator {
    void exponentiateX(long j10, byte[] bArr);

    void init(byte[] bArr);
}
