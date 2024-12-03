package org.bouncycastle.crypto.params;

public class IESWithCipherParameters extends IESParameters {
    private int cipherKeySize;

    public IESWithCipherParameters(byte[] bArr, byte[] bArr2, int i10, int i11) {
        super(bArr, bArr2, i10);
        this.cipherKeySize = i11;
    }

    public int getCipherKeySize() {
        return this.cipherKeySize;
    }
}
