package org.bouncycastle.crypto.fpe;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.params.FPEParameters;
import org.bouncycastle.util.Properties;

public class FPEFF1Engine extends FPEEngine {
    public FPEFF1Engine() {
        this(new AESEngine());
    }

    public FPEFF1Engine(BlockCipher blockCipher) {
        super(blockCipher);
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("base cipher needs to be 128 bits");
        } else if (Properties.isOverrideSet("org.bouncycastle.fpe.disable") || Properties.isOverrideSet("org.bouncycastle.fpe.disable_ff1")) {
            throw new UnsupportedOperationException("FF1 encryption disabled");
        }
    }

    /* access modifiers changed from: protected */
    public int decryptBlock(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        byte[] bArr3;
        if (this.fpeParameters.getRadix() > 256) {
            bArr3 = FPEEngine.toByteArray(SP80038G.decryptFF1w(this.baseCipher, this.fpeParameters.getRadix(), this.fpeParameters.getTweak(), FPEEngine.toShortArray(bArr), i10, i11 / 2));
        } else {
            bArr3 = SP80038G.decryptFF1(this.baseCipher, this.fpeParameters.getRadix(), this.fpeParameters.getTweak(), bArr, i10, i11);
        }
        System.arraycopy(bArr3, 0, bArr2, i12, i11);
        return i11;
    }

    /* access modifiers changed from: protected */
    public int encryptBlock(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        byte[] bArr3;
        if (this.fpeParameters.getRadix() > 256) {
            bArr3 = FPEEngine.toByteArray(SP80038G.encryptFF1w(this.baseCipher, this.fpeParameters.getRadix(), this.fpeParameters.getTweak(), FPEEngine.toShortArray(bArr), i10, i11 / 2));
        } else {
            bArr3 = SP80038G.encryptFF1(this.baseCipher, this.fpeParameters.getRadix(), this.fpeParameters.getTweak(), bArr, i10, i11);
        }
        System.arraycopy(bArr3, 0, bArr2, i12, i11);
        return i11;
    }

    public String getAlgorithmName() {
        return "FF1";
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        this.forEncryption = z10;
        FPEParameters fPEParameters = (FPEParameters) cipherParameters;
        this.fpeParameters = fPEParameters;
        this.baseCipher.init(!fPEParameters.isUsingInverseFunction(), this.fpeParameters.getKey());
    }
}
