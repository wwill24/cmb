package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.BigIntegers;

public class RandomDSAKCalculator implements DSAKCalculator {
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f41555q;
    private SecureRandom random;

    public void init(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        throw new IllegalStateException("Operation not supported");
    }

    public void init(BigInteger bigInteger, SecureRandom secureRandom) {
        this.f41555q = bigInteger;
        this.random = secureRandom;
    }

    public boolean isDeterministic() {
        return false;
    }

    public BigInteger nextK() {
        int bitLength = this.f41555q.bitLength();
        while (true) {
            BigInteger createRandomBigInteger = BigIntegers.createRandomBigInteger(bitLength, this.random);
            if (!createRandomBigInteger.equals(ZERO) && createRandomBigInteger.compareTo(this.f41555q) < 0) {
                return createRandomBigInteger;
            }
        }
    }
}
