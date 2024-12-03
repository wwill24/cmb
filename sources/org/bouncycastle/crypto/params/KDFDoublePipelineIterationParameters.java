package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

public final class KDFDoublePipelineIterationParameters implements DerivationParameters {
    private static final int UNUSED_R = 32;
    private final byte[] fixedInputData;

    /* renamed from: ki  reason: collision with root package name */
    private final byte[] f41539ki;

    /* renamed from: r  reason: collision with root package name */
    private final int f41540r;
    private final boolean useCounter;

    private KDFDoublePipelineIterationParameters(byte[] bArr, byte[] bArr2, int i10, boolean z10) {
        if (bArr != null) {
            this.f41539ki = Arrays.clone(bArr);
            if (bArr2 == null) {
                this.fixedInputData = new byte[0];
            } else {
                this.fixedInputData = Arrays.clone(bArr2);
            }
            if (i10 == 8 || i10 == 16 || i10 == 24 || i10 == 32) {
                this.f41540r = i10;
                this.useCounter = z10;
                return;
            }
            throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
        }
        throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
    }

    public static KDFDoublePipelineIterationParameters createWithCounter(byte[] bArr, byte[] bArr2, int i10) {
        return new KDFDoublePipelineIterationParameters(bArr, bArr2, i10, true);
    }

    public static KDFDoublePipelineIterationParameters createWithoutCounter(byte[] bArr, byte[] bArr2) {
        return new KDFDoublePipelineIterationParameters(bArr, bArr2, 32, false);
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputData);
    }

    public byte[] getKI() {
        return this.f41539ki;
    }

    public int getR() {
        return this.f41540r;
    }

    public boolean useCounter() {
        return this.useCounter;
    }
}
