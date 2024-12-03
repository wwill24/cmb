package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithID implements CipherParameters {

    /* renamed from: id  reason: collision with root package name */
    private byte[] f41545id;
    private CipherParameters parameters;

    public ParametersWithID(CipherParameters cipherParameters, byte[] bArr) {
        this.parameters = cipherParameters;
        this.f41545id = bArr;
    }

    public byte[] getID() {
        return this.f41545id;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
