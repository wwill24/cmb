package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS5S1ParametersGenerator extends PBEParametersGenerator {
    private Digest digest;

    public PKCS5S1ParametersGenerator(Digest digest2) {
        this.digest = digest2;
    }

    private byte[] generateDerivedKey() {
        int digestSize = this.digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        Digest digest2 = this.digest;
        byte[] bArr2 = this.password;
        digest2.update(bArr2, 0, bArr2.length);
        Digest digest3 = this.digest;
        byte[] bArr3 = this.salt;
        digest3.update(bArr3, 0, bArr3.length);
        this.digest.doFinal(bArr, 0);
        for (int i10 = 1; i10 < this.iterationCount; i10++) {
            this.digest.update(bArr, 0, digestSize);
            this.digest.doFinal(bArr, 0);
        }
        return bArr;
    }

    public CipherParameters generateDerivedMacParameters(int i10) {
        return generateDerivedParameters(i10);
    }

    public CipherParameters generateDerivedParameters(int i10) {
        int i11 = i10 / 8;
        if (i11 <= this.digest.getDigestSize()) {
            return new KeyParameter(generateDerivedKey(), 0, i11);
        }
        throw new IllegalArgumentException("Can't generate a derived key " + i11 + " bytes long.");
    }

    public CipherParameters generateDerivedParameters(int i10, int i11) {
        int i12 = i10 / 8;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        if (i14 <= this.digest.getDigestSize()) {
            byte[] generateDerivedKey = generateDerivedKey();
            return new ParametersWithIV(new KeyParameter(generateDerivedKey, 0, i12), generateDerivedKey, i12, i13);
        }
        throw new IllegalArgumentException("Can't generate a derived key " + i14 + " bytes long.");
    }
}
