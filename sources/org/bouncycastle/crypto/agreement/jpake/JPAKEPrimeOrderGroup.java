package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

public class JPAKEPrimeOrderGroup {

    /* renamed from: g  reason: collision with root package name */
    private final BigInteger f41362g;

    /* renamed from: p  reason: collision with root package name */
    private final BigInteger f41363p;

    /* renamed from: q  reason: collision with root package name */
    private final BigInteger f41364q;

    public JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, false);
    }

    JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, boolean z10) {
        JPAKEUtil.validateNotNull(bigInteger, XHTMLText.P);
        JPAKEUtil.validateNotNull(bigInteger2, XHTMLText.Q);
        JPAKEUtil.validateNotNull(bigInteger3, "g");
        if (!z10) {
            BigInteger bigInteger4 = JPAKEUtil.ONE;
            if (!bigInteger.subtract(bigInteger4).mod(bigInteger2).equals(JPAKEUtil.ZERO)) {
                throw new IllegalArgumentException("p-1 must be evenly divisible by q");
            } else if (bigInteger3.compareTo(BigInteger.valueOf(2)) == -1 || bigInteger3.compareTo(bigInteger.subtract(bigInteger4)) == 1) {
                throw new IllegalArgumentException("g must be in [2, p-1]");
            } else if (!bigInteger3.modPow(bigInteger2, bigInteger).equals(bigInteger4)) {
                throw new IllegalArgumentException("g^q mod p must equal 1");
            } else if (!bigInteger.isProbablePrime(20)) {
                throw new IllegalArgumentException("p must be prime");
            } else if (!bigInteger2.isProbablePrime(20)) {
                throw new IllegalArgumentException("q must be prime");
            }
        }
        this.f41363p = bigInteger;
        this.f41364q = bigInteger2;
        this.f41362g = bigInteger3;
    }

    public BigInteger getG() {
        return this.f41362g;
    }

    public BigInteger getP() {
        return this.f41363p;
    }

    public BigInteger getQ() {
        return this.f41364q;
    }
}
