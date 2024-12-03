package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;

public class MGFParameters implements DerivationParameters {
    byte[] seed;

    public MGFParameters(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public MGFParameters(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        this.seed = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
    }

    public byte[] getSeed() {
        return this.seed;
    }
}
