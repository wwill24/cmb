package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class DSAParameters implements CipherParameters {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f41516g;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f41517p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f41518q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f41516g = bigInteger3;
        this.f41517p = bigInteger;
        this.f41518q = bigInteger2;
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f41516g = bigInteger3;
        this.f41517p = bigInteger;
        this.f41518q = bigInteger2;
        this.validation = dSAValidationParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        return dSAParameters.getP().equals(this.f41517p) && dSAParameters.getQ().equals(this.f41518q) && dSAParameters.getG().equals(this.f41516g);
    }

    public BigInteger getG() {
        return this.f41516g;
    }

    public BigInteger getP() {
        return this.f41517p;
    }

    public BigInteger getQ() {
        return this.f41518q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }
}
