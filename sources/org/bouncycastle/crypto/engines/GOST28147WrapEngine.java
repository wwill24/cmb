package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.macs.GOST28147Mac;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.util.Arrays;

public class GOST28147WrapEngine implements Wrapper {
    private GOST28147Engine cipher = new GOST28147Engine();
    private GOST28147Mac mac = new GOST28147Mac();

    public String getAlgorithmName() {
        return "GOST28147Wrap";
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters;
        this.cipher.init(z10, parametersWithUKM.getParameters());
        this.mac.init(new ParametersWithIV(parametersWithUKM.getParameters(), parametersWithUKM.getUKM()));
    }

    public byte[] unwrap(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        int macSize = i11 - this.mac.getMacSize();
        byte[] bArr2 = new byte[macSize];
        this.cipher.processBlock(bArr, i10, bArr2, 0);
        this.cipher.processBlock(bArr, i10 + 8, bArr2, 8);
        this.cipher.processBlock(bArr, i10 + 16, bArr2, 16);
        this.cipher.processBlock(bArr, i10 + 24, bArr2, 24);
        byte[] bArr3 = new byte[this.mac.getMacSize()];
        this.mac.update(bArr2, 0, macSize);
        this.mac.doFinal(bArr3, 0);
        byte[] bArr4 = new byte[this.mac.getMacSize()];
        System.arraycopy(bArr, (i10 + i11) - 4, bArr4, 0, this.mac.getMacSize());
        if (Arrays.constantTimeAreEqual(bArr3, bArr4)) {
            return bArr2;
        }
        throw new IllegalStateException("mac mismatch");
    }

    public byte[] wrap(byte[] bArr, int i10, int i11) {
        this.mac.update(bArr, i10, i11);
        byte[] bArr2 = new byte[(this.mac.getMacSize() + i11)];
        this.cipher.processBlock(bArr, i10, bArr2, 0);
        this.cipher.processBlock(bArr, i10 + 8, bArr2, 8);
        this.cipher.processBlock(bArr, i10 + 16, bArr2, 16);
        this.cipher.processBlock(bArr, i10 + 24, bArr2, 24);
        this.mac.doFinal(bArr2, i11);
        return bArr2;
    }
}
