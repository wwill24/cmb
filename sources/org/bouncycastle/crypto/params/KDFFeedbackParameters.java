package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

public final class KDFFeedbackParameters implements DerivationParameters {
    private static final int UNUSED_R = -1;
    private final byte[] fixedInputData;
    private final byte[] iv;

    /* renamed from: ki  reason: collision with root package name */
    private final byte[] f41541ki;

    /* renamed from: r  reason: collision with root package name */
    private final int f41542r;
    private final boolean useCounter;

    private KDFFeedbackParameters(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, boolean z10) {
        if (bArr != null) {
            this.f41541ki = Arrays.clone(bArr);
            if (bArr3 == null) {
                this.fixedInputData = new byte[0];
            } else {
                this.fixedInputData = Arrays.clone(bArr3);
            }
            this.f41542r = i10;
            if (bArr2 == null) {
                this.iv = new byte[0];
            } else {
                this.iv = Arrays.clone(bArr2);
            }
            this.useCounter = z10;
            return;
        }
        throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
    }

    public static KDFFeedbackParameters createWithCounter(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10) {
        if (i10 == 8 || i10 == 16 || i10 == 24 || i10 == 32) {
            return new KDFFeedbackParameters(bArr, bArr2, bArr3, i10, true);
        }
        throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
    }

    public static KDFFeedbackParameters createWithoutCounter(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new KDFFeedbackParameters(bArr, bArr2, bArr3, -1, false);
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputData);
    }

    public byte[] getIV() {
        return this.iv;
    }

    public byte[] getKI() {
        return this.f41541ki;
    }

    public int getR() {
        return this.f41542r;
    }

    public boolean useCounter() {
        return this.useCounter;
    }
}
