package org.bouncycastle.crypto.params;

public class CramerShoupKeyParameters extends AsymmetricKeyParameter {
    private CramerShoupParameters params;

    protected CramerShoupKeyParameters(boolean z10, CramerShoupParameters cramerShoupParameters) {
        super(z10);
        this.params = cramerShoupParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupKeyParameters)) {
            return false;
        }
        CramerShoupParameters cramerShoupParameters = this.params;
        CramerShoupParameters parameters = ((CramerShoupKeyParameters) obj).getParameters();
        return cramerShoupParameters == null ? parameters == null : cramerShoupParameters.equals(parameters);
    }

    public CramerShoupParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        boolean z10 = !isPrivate();
        CramerShoupParameters cramerShoupParameters = this.params;
        return cramerShoupParameters != null ? z10 ^ cramerShoupParameters.hashCode() ? 1 : 0 : z10 ? 1 : 0;
    }
}
