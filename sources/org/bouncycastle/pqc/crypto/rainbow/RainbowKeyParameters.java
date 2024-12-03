package org.bouncycastle.pqc.crypto.rainbow;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class RainbowKeyParameters extends AsymmetricKeyParameter {
    private int docLength;

    public RainbowKeyParameters(boolean z10, int i10) {
        super(z10);
        this.docLength = i10;
    }

    public int getDocLength() {
        return this.docLength;
    }
}
