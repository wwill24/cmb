package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Properties;

public class DHParameters implements CipherParameters {
    private static final int DEFAULT_MINIMUM_LENGTH = 160;

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f41506g;

    /* renamed from: j  reason: collision with root package name */
    private BigInteger f41507j;

    /* renamed from: l  reason: collision with root package name */
    private int f41508l;

    /* renamed from: m  reason: collision with root package name */
    private int f41509m;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f41510p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f41511q;
    private DHValidationParameters validation;

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, (BigInteger) null, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10) {
        this(bigInteger, bigInteger2, bigInteger3, getDefaultMParam(i10), i10, (BigInteger) null, (DHValidationParameters) null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10, int i11) {
        this(bigInteger, bigInteger2, bigInteger3, i10, i11, (BigInteger) null, (DHValidationParameters) null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10, int i11, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        if (i11 != 0) {
            if (i11 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            } else if (i11 < i10) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (i10 <= bigInteger.bitLength() || Properties.isOverrideSet("org.bouncycastle.dh.allow_unsafe_p_value")) {
            this.f41506g = bigInteger2;
            this.f41510p = bigInteger;
            this.f41511q = bigInteger3;
            this.f41509m = i10;
            this.f41508l = i11;
            this.f41507j = bigInteger4;
            this.validation = dHValidationParameters;
            return;
        }
        throw new IllegalArgumentException("unsafe p value so small specific l required");
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        this(bigInteger, bigInteger2, bigInteger3, 160, 0, bigInteger4, dHValidationParameters);
    }

    private static int getDefaultMParam(int i10) {
        if (i10 == 0) {
            return 160;
        }
        if (i10 < 160) {
            return i10;
        }
        return 160;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHParameters)) {
            return false;
        }
        DHParameters dHParameters = (DHParameters) obj;
        if (getQ() != null) {
            if (!getQ().equals(dHParameters.getQ())) {
                return false;
            }
        } else if (dHParameters.getQ() != null) {
            return false;
        }
        return dHParameters.getP().equals(this.f41510p) && dHParameters.getG().equals(this.f41506g);
    }

    public BigInteger getG() {
        return this.f41506g;
    }

    public BigInteger getJ() {
        return this.f41507j;
    }

    public int getL() {
        return this.f41508l;
    }

    public int getM() {
        return this.f41509m;
    }

    public BigInteger getP() {
        return this.f41510p;
    }

    public BigInteger getQ() {
        return this.f41511q;
    }

    public DHValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) ^ (getQ() != null ? getQ().hashCode() : 0);
    }
}
