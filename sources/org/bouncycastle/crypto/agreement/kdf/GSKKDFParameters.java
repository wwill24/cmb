package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.crypto.DerivationParameters;

public class GSKKDFParameters implements DerivationParameters {
    private final byte[] nonce;
    private final int startCounter;

    /* renamed from: z  reason: collision with root package name */
    private final byte[] f41369z;

    public GSKKDFParameters(byte[] bArr, int i10) {
        this(bArr, i10, (byte[]) null);
    }

    public GSKKDFParameters(byte[] bArr, int i10, byte[] bArr2) {
        this.f41369z = bArr;
        this.startCounter = i10;
        this.nonce = bArr2;
    }

    public byte[] getNonce() {
        return this.nonce;
    }

    public int getStartCounter() {
        return this.startCounter;
    }

    public byte[] getZ() {
        return this.f41369z;
    }
}
