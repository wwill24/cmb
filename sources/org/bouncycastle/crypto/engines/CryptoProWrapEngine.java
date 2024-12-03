package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.modes.GCFBBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.util.Pack;

public class CryptoProWrapEngine extends GOST28147WrapEngine {
    private static boolean bitSet(byte b10, int i10) {
        return (b10 & (1 << i10)) != 0;
    }

    private static byte[] cryptoProDiversify(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i10 = 0; i10 != 8; i10++) {
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 != 8; i13++) {
                int littleEndianToInt = Pack.littleEndianToInt(bArr, i13 * 4);
                if (bitSet(bArr2[i10], i13)) {
                    i11 += littleEndianToInt;
                } else {
                    i12 += littleEndianToInt;
                }
            }
            byte[] bArr4 = new byte[8];
            Pack.intToLittleEndian(i11, bArr4, 0);
            Pack.intToLittleEndian(i12, bArr4, 4);
            GCFBBlockCipher gCFBBlockCipher = new GCFBBlockCipher(new GOST28147Engine());
            gCFBBlockCipher.init(true, new ParametersWithIV(new ParametersWithSBox(new KeyParameter(bArr), bArr3), bArr4));
            gCFBBlockCipher.processBlock(bArr, 0, bArr, 0);
            gCFBBlockCipher.processBlock(bArr, 8, bArr, 8);
            gCFBBlockCipher.processBlock(bArr, 16, bArr, 16);
            gCFBBlockCipher.processBlock(bArr, 24, bArr, 24);
        }
        return bArr;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        byte[] bArr;
        KeyParameter keyParameter;
        ParametersWithUKM parametersWithUKM;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        ParametersWithUKM parametersWithUKM2 = (ParametersWithUKM) cipherParameters;
        if (parametersWithUKM2.getParameters() instanceof ParametersWithSBox) {
            keyParameter = (KeyParameter) ((ParametersWithSBox) parametersWithUKM2.getParameters()).getParameters();
            bArr = ((ParametersWithSBox) parametersWithUKM2.getParameters()).getSBox();
        } else {
            bArr = null;
            keyParameter = (KeyParameter) parametersWithUKM2.getParameters();
        }
        KeyParameter keyParameter2 = new KeyParameter(cryptoProDiversify(keyParameter.getKey(), parametersWithUKM2.getUKM(), bArr));
        if (bArr != null) {
            ParametersWithSBox parametersWithSBox = new ParametersWithSBox(keyParameter2, bArr);
            byte[] ukm = parametersWithUKM2.getUKM();
        } else {
            parametersWithUKM = new ParametersWithUKM(keyParameter2, parametersWithUKM2.getUKM());
        }
        super.init(z10, parametersWithUKM);
    }
}
