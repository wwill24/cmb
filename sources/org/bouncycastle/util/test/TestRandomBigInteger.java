package org.bouncycastle.util.test;

import java.math.BigInteger;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.test.FixedSecureRandom;

public class TestRandomBigInteger extends FixedSecureRandom {
    public TestRandomBigInteger(int i10, byte[] bArr) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(i10, bArr)});
    }

    public TestRandomBigInteger(String str) {
        this(str, 10);
    }

    public TestRandomBigInteger(String str, int i10) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(BigIntegers.asUnsignedByteArray(new BigInteger(str, i10)))});
    }

    public TestRandomBigInteger(byte[] bArr) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(bArr)});
    }
}
