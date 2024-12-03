package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class KeyParameter implements CipherParameters {
    private byte[] key;

    public KeyParameter(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public KeyParameter(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        this.key = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
    }

    public byte[] getKey() {
        return this.key;
    }
}
