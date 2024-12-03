package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.DigestDerivationFunction;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ISO18033KDFParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.util.Pack;

public class BaseKDFBytesGenerator implements DigestDerivationFunction {
    private int counterStart;
    private Digest digest;
    private byte[] iv;
    private byte[] shared;

    protected BaseKDFBytesGenerator(int i10, Digest digest2) {
        this.counterStart = i10;
        this.digest = digest2;
    }

    public int generateBytes(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        byte[] bArr2 = bArr;
        int i12 = i11;
        int i13 = i10;
        if (bArr2.length - i12 >= i13) {
            long j10 = (long) i12;
            int digestSize = this.digest.getDigestSize();
            if (j10 <= 8589934591L) {
                long j11 = (long) digestSize;
                int i14 = (int) (((j10 + j11) - 1) / j11);
                byte[] bArr3 = new byte[this.digest.getDigestSize()];
                byte[] bArr4 = new byte[4];
                Pack.intToBigEndian(this.counterStart, bArr4, 0);
                int i15 = this.counterStart & -256;
                for (int i16 = 0; i16 < i14; i16++) {
                    Digest digest2 = this.digest;
                    byte[] bArr5 = this.shared;
                    digest2.update(bArr5, 0, bArr5.length);
                    this.digest.update(bArr4, 0, 4);
                    byte[] bArr6 = this.iv;
                    if (bArr6 != null) {
                        this.digest.update(bArr6, 0, bArr6.length);
                    }
                    this.digest.doFinal(bArr3, 0);
                    if (i12 > digestSize) {
                        System.arraycopy(bArr3, 0, bArr2, i13, digestSize);
                        i13 += digestSize;
                        i12 -= digestSize;
                    } else {
                        System.arraycopy(bArr3, 0, bArr2, i13, i12);
                    }
                    byte b10 = (byte) (bArr4[3] + 1);
                    bArr4[3] = b10;
                    if (b10 == 0) {
                        i15 += 256;
                        Pack.intToBigEndian(i15, bArr4, 0);
                    }
                }
                this.digest.reset();
                return (int) j10;
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
        } else if (derivationParameters instanceof ISO18033KDFParameters) {
            this.shared = ((ISO18033KDFParameters) derivationParameters).getSeed();
            this.iv = null;
        } else {
            throw new IllegalArgumentException("KDF parameters required for generator");
        }
    }
}
