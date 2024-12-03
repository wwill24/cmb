package org.bouncycastle.jcajce.spec;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;

public class DHDomainParameterSpec extends DHParameterSpec {

    /* renamed from: j  reason: collision with root package name */
    private final BigInteger f23855j;

    /* renamed from: m  reason: collision with root package name */
    private final int f23856m;

    /* renamed from: q  reason: collision with root package name */
    private final BigInteger f23857q;
    private DHValidationParameters validationParameters;

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, (BigInteger) null, 0);
    }

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10) {
        this(bigInteger, bigInteger2, bigInteger3, (BigInteger) null, i10);
    }

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i10) {
        this(bigInteger, bigInteger2, bigInteger3, bigInteger4, 0, i10);
    }

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i10, int i11) {
        super(bigInteger, bigInteger3, i11);
        this.f23857q = bigInteger2;
        this.f23855j = bigInteger4;
        this.f23856m = i10;
    }

    public DHDomainParameterSpec(DHParameters dHParameters) {
        this(dHParameters.getP(), dHParameters.getQ(), dHParameters.getG(), dHParameters.getJ(), dHParameters.getM(), dHParameters.getL());
        this.validationParameters = dHParameters.getValidationParameters();
    }

    public DHParameters getDomainParameters() {
        return new DHParameters(getP(), getG(), this.f23857q, this.f23856m, getL(), this.f23855j, this.validationParameters);
    }

    public BigInteger getJ() {
        return this.f23855j;
    }

    public int getM() {
        return this.f23856m;
    }

    public BigInteger getQ() {
        return this.f23857q;
    }
}
