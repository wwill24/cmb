package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KDFParameters;

public class ConcatenationKDFGenerator implements DerivationFunction {
    private Digest digest;
    private int hLen;
    private byte[] otherInfo;
    private byte[] shared;

    public ConcatenationKDFGenerator(Digest digest2) {
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
        int i13;
        if (bArr.length - i11 >= i10) {
            byte[] bArr2 = new byte[this.hLen];
            byte[] bArr3 = new byte[4];
            this.digest.reset();
            int i14 = 1;
            if (i11 > this.hLen) {
                i12 = 0;
                while (true) {
                    ItoOSP(i14, bArr3);
                    this.digest.update(bArr3, 0, 4);
                    Digest digest2 = this.digest;
                    byte[] bArr4 = this.shared;
                    digest2.update(bArr4, 0, bArr4.length);
                    Digest digest3 = this.digest;
                    byte[] bArr5 = this.otherInfo;
                    digest3.update(bArr5, 0, bArr5.length);
                    this.digest.doFinal(bArr2, 0);
                    System.arraycopy(bArr2, 0, bArr, i10 + i12, this.hLen);
                    int i15 = this.hLen;
                    i12 += i15;
                    i13 = i14 + 1;
                    if (i14 >= i11 / i15) {
                        break;
                    }
                    i14 = i13;
                }
                i14 = i13;
            } else {
                i12 = 0;
            }
            if (i12 < i11) {
                ItoOSP(i14, bArr3);
                this.digest.update(bArr3, 0, 4);
                Digest digest4 = this.digest;
                byte[] bArr6 = this.shared;
                digest4.update(bArr6, 0, bArr6.length);
                Digest digest5 = this.digest;
                byte[] bArr7 = this.otherInfo;
                digest5.update(bArr7, 0, bArr7.length);
                this.digest.doFinal(bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i10 + i12, i11 - i12);
            }
            return i11;
        }
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.shared = kDFParameters.getSharedSecret();
            this.otherInfo = kDFParameters.getIV();
            return;
        }
        throw new IllegalArgumentException("KDF parameters required for generator");
    }
}
