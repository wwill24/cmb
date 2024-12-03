package org.bouncycastle.jce.provider;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KDFParameters;

public class BrokenKDF2BytesGenerator implements DerivationFunction {
    private Digest digest;
    private byte[] iv;
    private byte[] shared;

    public BrokenKDF2BytesGenerator(Digest digest2) {
        this.digest = digest2;
    }

    public int generateBytes(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        if (bArr.length - i11 >= i10) {
            long j10 = ((long) i11) * 8;
            if (j10 <= ((long) this.digest.getDigestSize()) * 8 * 2147483648L) {
                int digestSize = (int) (j10 / ((long) this.digest.getDigestSize()));
                int digestSize2 = this.digest.getDigestSize();
                byte[] bArr2 = new byte[digestSize2];
                for (int i12 = 1; i12 <= digestSize; i12++) {
                    Digest digest2 = this.digest;
                    byte[] bArr3 = this.shared;
                    digest2.update(bArr3, 0, bArr3.length);
                    this.digest.update((byte) (i12 & 255));
                    this.digest.update((byte) ((i12 >> 8) & 255));
                    this.digest.update((byte) ((i12 >> 16) & 255));
                    this.digest.update((byte) ((i12 >> 24) & 255));
                    Digest digest3 = this.digest;
                    byte[] bArr4 = this.iv;
                    digest3.update(bArr4, 0, bArr4.length);
                    this.digest.doFinal(bArr2, 0);
                    int i13 = i11 - i10;
                    if (i13 > digestSize2) {
                        System.arraycopy(bArr2, 0, bArr, i10, digestSize2);
                        i10 += digestSize2;
                    } else {
                        System.arraycopy(bArr2, 0, bArr, i10, i13);
                    }
                }
                this.digest.reset();
                return i11;
            }
            throw new IllegalArgumentException("Output length too large");
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
            this.iv = kDFParameters.getIV();
            return;
        }
        throw new IllegalArgumentException("KDF parameters required for generator");
    }
}
