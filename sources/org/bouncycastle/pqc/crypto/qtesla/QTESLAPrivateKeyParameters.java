package org.bouncycastle.pqc.crypto.qtesla;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

public final class QTESLAPrivateKeyParameters extends AsymmetricKeyParameter {
    private byte[] privateKey;
    private int securityCategory;

    public QTESLAPrivateKeyParameters(int i10, byte[] bArr) {
        super(true);
        if (bArr.length == QTESLASecurityCategory.getPrivateSize(i10)) {
            this.securityCategory = i10;
            this.privateKey = Arrays.clone(bArr);
            return;
        }
        throw new IllegalArgumentException("invalid key size for security category");
    }

    public byte[] getSecret() {
        return Arrays.clone(this.privateKey);
    }

    public int getSecurityCategory() {
        return this.securityCategory;
    }
}
