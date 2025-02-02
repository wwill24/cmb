package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

public class HKDFParameters implements DerivationParameters {
    private final byte[] ikm;
    private final byte[] info;
    private final byte[] salt;
    private final boolean skipExpand;

    private HKDFParameters(byte[] bArr, boolean z10, byte[] bArr2, byte[] bArr3) {
        if (bArr != null) {
            this.ikm = Arrays.clone(bArr);
            this.skipExpand = z10;
            if (bArr2 == null || bArr2.length == 0) {
                this.salt = null;
            } else {
                this.salt = Arrays.clone(bArr2);
            }
            if (bArr3 == null) {
                this.info = new byte[0];
            } else {
                this.info = Arrays.clone(bArr3);
            }
        } else {
            throw new IllegalArgumentException("IKM (input keying material) should not be null");
        }
    }

    public HKDFParameters(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this(bArr, false, bArr2, bArr3);
    }

    public static HKDFParameters defaultParameters(byte[] bArr) {
        return new HKDFParameters(bArr, false, (byte[]) null, (byte[]) null);
    }

    public static HKDFParameters skipExtractParameters(byte[] bArr, byte[] bArr2) {
        return new HKDFParameters(bArr, true, (byte[]) null, bArr2);
    }

    public byte[] getIKM() {
        return Arrays.clone(this.ikm);
    }

    public byte[] getInfo() {
        return Arrays.clone(this.info);
    }

    public byte[] getSalt() {
        return Arrays.clone(this.salt);
    }

    public boolean skipExtract() {
        return this.skipExpand;
    }
}
