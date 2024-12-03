package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

public final class KDFCounterParameters implements DerivationParameters {
    private byte[] fixedInputDataCounterPrefix;
    private byte[] fixedInputDataCounterSuffix;

    /* renamed from: ki  reason: collision with root package name */
    private byte[] f41537ki;

    /* renamed from: r  reason: collision with root package name */
    private int f41538r;

    public KDFCounterParameters(byte[] bArr, byte[] bArr2, int i10) {
        this(bArr, (byte[]) null, bArr2, i10);
    }

    public KDFCounterParameters(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10) {
        if (bArr != null) {
            this.f41537ki = Arrays.clone(bArr);
            if (bArr2 == null) {
                this.fixedInputDataCounterPrefix = new byte[0];
            } else {
                this.fixedInputDataCounterPrefix = Arrays.clone(bArr2);
            }
            if (bArr3 == null) {
                this.fixedInputDataCounterSuffix = new byte[0];
            } else {
                this.fixedInputDataCounterSuffix = Arrays.clone(bArr3);
            }
            if (i10 == 8 || i10 == 16 || i10 == 24 || i10 == 32) {
                this.f41538r = i10;
                return;
            }
            throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
        }
        throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputDataCounterSuffix);
    }

    public byte[] getFixedInputDataCounterPrefix() {
        return Arrays.clone(this.fixedInputDataCounterPrefix);
    }

    public byte[] getFixedInputDataCounterSuffix() {
        return Arrays.clone(this.fixedInputDataCounterSuffix);
    }

    public byte[] getKI() {
        return this.f41537ki;
    }

    public int getR() {
        return this.f41538r;
    }
}
