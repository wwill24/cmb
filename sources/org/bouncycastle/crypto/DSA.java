package org.bouncycastle.crypto;

import java.math.BigInteger;

public interface DSA {
    BigInteger[] generateSignature(byte[] bArr);

    void init(boolean z10, CipherParameters cipherParameters);

    boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2);
}
