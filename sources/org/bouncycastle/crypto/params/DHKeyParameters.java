package org.bouncycastle.crypto.params;

public class DHKeyParameters extends AsymmetricKeyParameter {
    private DHParameters params;

    protected DHKeyParameters(boolean z10, DHParameters dHParameters) {
        super(z10);
        this.params = dHParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHKeyParameters)) {
            return false;
        }
        DHParameters dHParameters = this.params;
        DHParameters parameters = ((DHKeyParameters) obj).getParameters();
        return dHParameters == null ? parameters == null : dHParameters.equals(parameters);
    }

    public DHParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        boolean z10 = !isPrivate();
        DHParameters dHParameters = this.params;
        return dHParameters != null ? z10 ^ dHParameters.hashCode() ? 1 : 0 : z10 ? 1 : 0;
    }
}
