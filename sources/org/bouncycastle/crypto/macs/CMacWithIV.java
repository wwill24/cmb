package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;

public class CMacWithIV extends CMac {
    public CMacWithIV(BlockCipher blockCipher) {
        super(blockCipher);
    }

    public CMacWithIV(BlockCipher blockCipher, int i10) {
        super(blockCipher, i10);
    }

    /* access modifiers changed from: package-private */
    public void validate(CipherParameters cipherParameters) {
    }
}
