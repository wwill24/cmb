package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class GOST3410Parameters implements CipherParameters {

    /* renamed from: a  reason: collision with root package name */
    private BigInteger f41530a;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f41531p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f41532q;
    private GOST3410ValidationParameters validation;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f41531p = bigInteger;
        this.f41532q = bigInteger2;
        this.f41530a = bigInteger3;
    }

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, GOST3410ValidationParameters gOST3410ValidationParameters) {
        this.f41530a = bigInteger3;
        this.f41531p = bigInteger;
        this.f41532q = bigInteger2;
        this.validation = gOST3410ValidationParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410Parameters)) {
            return false;
        }
        GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
        return gOST3410Parameters.getP().equals(this.f41531p) && gOST3410Parameters.getQ().equals(this.f41532q) && gOST3410Parameters.getA().equals(this.f41530a);
    }

    public BigInteger getA() {
        return this.f41530a;
    }

    public BigInteger getP() {
        return this.f41531p;
    }

    public BigInteger getQ() {
        return this.f41532q;
    }

    public GOST3410ValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (this.f41531p.hashCode() ^ this.f41532q.hashCode()) ^ this.f41530a.hashCode();
    }
}
