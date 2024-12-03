package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

public class IESParameterSpec implements AlgorithmParameterSpec {
    private int cipherKeySize;
    private byte[] derivation;
    private byte[] encoding;
    private int macKeySize;
    private byte[] nonce;
    private boolean usePointCompression;

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i10) {
        this(bArr, bArr2, i10, -1, (byte[]) null, false);
    }

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i10, int i11, byte[] bArr3) {
        this(bArr, bArr2, i10, i11, bArr3, false);
    }

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i10, int i11, byte[] bArr3, boolean z10) {
        if (bArr != null) {
            byte[] bArr4 = new byte[bArr.length];
            this.derivation = bArr4;
            System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        } else {
            this.derivation = null;
        }
        if (bArr2 != null) {
            byte[] bArr5 = new byte[bArr2.length];
            this.encoding = bArr5;
            System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
        } else {
            this.encoding = null;
        }
        this.macKeySize = i10;
        this.cipherKeySize = i11;
        this.nonce = Arrays.clone(bArr3);
        this.usePointCompression = z10;
    }

    public int getCipherKeySize() {
        return this.cipherKeySize;
    }

    public byte[] getDerivationV() {
        return Arrays.clone(this.derivation);
    }

    public byte[] getEncodingV() {
        return Arrays.clone(this.encoding);
    }

    public int getMacKeySize() {
        return this.macKeySize;
    }

    public byte[] getNonce() {
        return Arrays.clone(this.nonce);
    }

    public boolean getPointCompression() {
        return this.usePointCompression;
    }

    public void setPointCompression(boolean z10) {
        this.usePointCompression = z10;
    }
}
