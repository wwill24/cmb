package org.bouncycastle.crypto;

public interface SkippingCipher {
    long getPosition();

    long seekTo(long j10);

    long skip(long j10);
}
