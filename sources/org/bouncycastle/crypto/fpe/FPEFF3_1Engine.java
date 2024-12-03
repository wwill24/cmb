package org.bouncycastle.crypto.fpe;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.params.FPEParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

public class FPEFF3_1Engine extends FPEEngine {
    public FPEFF3_1Engine() {
        this(new AESEngine());
    }

    public FPEFF3_1Engine(BlockCipher blockCipher) {
        super(blockCipher);
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("base cipher needs to be 128 bits");
        } else if (Properties.isOverrideSet("org.bouncycastle.fpe.disable")) {
            throw new UnsupportedOperationException("FPE disabled");
        }
    }

    /* access modifiers changed from: protected */
    public int decryptBlock(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        byte[] bArr3;
        if (this.fpeParameters.getRadix() > 256) {
            bArr3 = FPEEngine.toByteArray(SP80038G.decryptFF3_1w(this.baseCipher, this.fpeParameters.getRadix(), this.fpeParameters.getTweak(), FPEEngine.toShortArray(bArr), i10, i11 / 2));
        } else {
            bArr3 = SP80038G.decryptFF3_1(this.baseCipher, this.fpeParameters.getRadix(), this.fpeParameters.getTweak(), bArr, i10, i11);
        }
        System.arraycopy(bArr3, 0, bArr2, i12, i11);
        return i11;
    }

    /* access modifiers changed from: protected */
    public int encryptBlock(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        byte[] bArr3;
        if (this.fpeParameters.getRadix() > 256) {
            bArr3 = FPEEngine.toByteArray(SP80038G.encryptFF3_1w(this.baseCipher, this.fpeParameters.getRadix(), this.fpeParameters.getTweak(), FPEEngine.toShortArray(bArr), i10, i11 / 2));
        } else {
            bArr3 = SP80038G.encryptFF3_1(this.baseCipher, this.fpeParameters.getRadix(), this.fpeParameters.getTweak(), bArr, i10, i11);
        }
        System.arraycopy(bArr3, 0, bArr2, i12, i11);
        return i11;
    }

    public String getAlgorithmName() {
        return "FF3-1";
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        this.forEncryption = z10;
        FPEParameters fPEParameters = (FPEParameters) cipherParameters;
        this.fpeParameters = fPEParameters;
        this.baseCipher.init(!fPEParameters.isUsingInverseFunction(), new KeyParameter(Arrays.reverse(this.fpeParameters.getKey().getKey())));
        if (this.fpeParameters.getTweak().length != 7) {
            throw new IllegalArgumentException("tweak should be 56 bits");
        }
    }
}
