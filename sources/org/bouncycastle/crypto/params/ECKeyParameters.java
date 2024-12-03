package org.bouncycastle.crypto.params;

public class ECKeyParameters extends AsymmetricKeyParameter {
    private final ECDomainParameters parameters;

    protected ECKeyParameters(boolean z10, ECDomainParameters eCDomainParameters) {
        super(z10);
        if (eCDomainParameters != null) {
            this.parameters = eCDomainParameters;
            return;
        }
        throw new NullPointerException("'parameters' cannot be null");
    }

    public ECDomainParameters getParameters() {
        return this.parameters;
    }
}
