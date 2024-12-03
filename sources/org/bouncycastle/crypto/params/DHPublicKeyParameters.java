package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Integers;

public class DHPublicKeyParameters extends DHKeyParameters {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    /* renamed from: y  reason: collision with root package name */
    private BigInteger f41513y;

    public DHPublicKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(false, dHParameters);
        this.f41513y = validate(bigInteger, dHParameters);
    }

    private static int legendre(BigInteger bigInteger, BigInteger bigInteger2) {
        int bitLength = bigInteger2.bitLength();
        int[] fromBigInteger = Nat.fromBigInteger(bitLength, bigInteger);
        int[] fromBigInteger2 = Nat.fromBigInteger(bitLength, bigInteger2);
        int length = fromBigInteger2.length;
        int i10 = 0;
        while (true) {
            int i11 = fromBigInteger[0];
            if (i11 == 0) {
                Nat.shiftDownWord(length, fromBigInteger, 0);
            } else {
                int numberOfTrailingZeros = Integers.numberOfTrailingZeros(i11);
                if (numberOfTrailingZeros > 0) {
                    Nat.shiftDownBits(length, fromBigInteger, numberOfTrailingZeros, 0);
                    int i12 = fromBigInteger2[0];
                    i10 ^= (numberOfTrailingZeros << 1) & (i12 ^ (i12 >>> 1));
                }
                int compare = Nat.compare(length, fromBigInteger, fromBigInteger2);
                if (compare == 0) {
                    break;
                }
                if (compare < 0) {
                    i10 ^= fromBigInteger[0] & fromBigInteger2[0];
                    int[] iArr = fromBigInteger2;
                    fromBigInteger2 = fromBigInteger;
                    fromBigInteger = iArr;
                }
                while (true) {
                    int i13 = length - 1;
                    if (fromBigInteger[i13] != 0) {
                        break;
                    }
                    length = i13;
                }
                Nat.sub(length, fromBigInteger, fromBigInteger2, fromBigInteger);
            }
        }
        if (Nat.isOne(length, fromBigInteger2)) {
            return 1 - (i10 & 2);
        }
        return 0;
    }

    private BigInteger validate(BigInteger bigInteger, DHParameters dHParameters) {
        if (bigInteger != null) {
            BigInteger p10 = dHParameters.getP();
            BigInteger bigInteger2 = TWO;
            if (bigInteger.compareTo(bigInteger2) < 0 || bigInteger.compareTo(p10.subtract(bigInteger2)) > 0) {
                throw new IllegalArgumentException("invalid DH public key");
            }
            BigInteger q10 = dHParameters.getQ();
            if (q10 == null) {
                return bigInteger;
            }
            if (!p10.testBit(0) || p10.bitLength() - 1 != q10.bitLength() || !p10.shiftRight(1).equals(q10)) {
                if (ONE.equals(bigInteger.modPow(q10, p10))) {
                    return bigInteger;
                }
            } else if (1 == legendre(bigInteger, p10)) {
                return bigInteger;
            }
            throw new IllegalArgumentException("Y value does not appear to be in correct group");
        }
        throw new NullPointerException("y value cannot be null");
    }

    public boolean equals(Object obj) {
        return (obj instanceof DHPublicKeyParameters) && ((DHPublicKeyParameters) obj).getY().equals(this.f41513y) && super.equals(obj);
    }

    public BigInteger getY() {
        return this.f41513y;
    }

    public int hashCode() {
        return this.f41513y.hashCode() ^ super.hashCode();
    }
}
