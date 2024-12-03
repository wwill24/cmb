package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.MGFParameters;

public class MGF1BytesGenerator implements DerivationFunction {
    private Digest digest;
    private int hLen;
    private byte[] seed;

    public MGF1BytesGenerator(Digest digest2) {
        this.digest = digest2;
        this.hLen = digest2.getDigestSize();
    }

    private void ItoOSP(int i10, byte[] bArr) {
        bArr[0] = (byte) (i10 >>> 24);
        bArr[1] = (byte) (i10 >>> 16);
        bArr[2] = (byte) (i10 >>> 8);
        bArr[3] = (byte) (i10 >>> 0);
    }

    public int generateBytes(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        int i12;
        if (bArr.length - i11 >= i10) {
            byte[] bArr2 = new byte[this.hLen];
            byte[] bArr3 = new byte[4];
            this.digest.reset();
            if (i11 > this.hLen) {
                i12 = 0;
                do {
                    ItoOSP(i12, bArr3);
                    Digest digest2 = this.digest;
                    byte[] bArr4 = this.seed;
                    digest2.update(bArr4, 0, bArr4.length);
                    this.digest.update(bArr3, 0, 4);
                    this.digest.doFinal(bArr2, 0);
                    int i13 = this.hLen;
                    System.arraycopy(bArr2, 0, bArr, (i12 * i13) + i10, i13);
                    i12++;
                } while (i12 < i11 / this.hLen);
            } else {
                i12 = 0;
            }
            if (this.hLen * i12 < i11) {
                ItoOSP(i12, bArr3);
                Digest digest3 = this.digest;
                byte[] bArr5 = this.seed;
                digest3.update(bArr5, 0, bArr5.length);
                this.digest.update(bArr3, 0, 4);
                this.digest.doFinal(bArr2, 0);
                int i14 = this.hLen;
                System.arraycopy(bArr2, 0, bArr, i10 + (i12 * i14), i11 - (i12 * i14));
            }
            return i11;
        }
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof MGFParameters) {
            this.seed = ((MGFParameters) derivationParameters).getSeed();
            return;
        }
        throw new IllegalArgumentException("MGF parameters required for MGF1Generator");
    }
}
