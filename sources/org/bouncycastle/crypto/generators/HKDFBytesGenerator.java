package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.HKDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;

public class HKDFBytesGenerator implements DerivationFunction {
    private byte[] currentT;
    private int generatedBytes;
    private HMac hMacHash;
    private int hashLen;
    private byte[] info;

    public HKDFBytesGenerator(Digest digest) {
        this.hMacHash = new HMac(digest);
        this.hashLen = digest.getDigestSize();
    }

    private void expandNext() throws DataLengthException {
        int i10 = this.generatedBytes;
        int i11 = this.hashLen;
        int i12 = (i10 / i11) + 1;
        if (i12 < 256) {
            if (i10 != 0) {
                this.hMacHash.update(this.currentT, 0, i11);
            }
            HMac hMac = this.hMacHash;
            byte[] bArr = this.info;
            hMac.update(bArr, 0, bArr.length);
            this.hMacHash.update((byte) i12);
            this.hMacHash.doFinal(this.currentT, 0);
            return;
        }
        throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
    }

    private KeyParameter extract(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            this.hMacHash.init(new KeyParameter(new byte[this.hashLen]));
        } else {
            this.hMacHash.init(new KeyParameter(bArr));
        }
        this.hMacHash.update(bArr2, 0, bArr2.length);
        byte[] bArr3 = new byte[this.hashLen];
        this.hMacHash.doFinal(bArr3, 0);
        return new KeyParameter(bArr3);
    }

    public int generateBytes(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        int i12 = this.generatedBytes;
        int i13 = i12 + i11;
        int i14 = this.hashLen;
        if (i13 <= i14 * 255) {
            if (i12 % i14 == 0) {
                expandNext();
            }
            int i15 = this.generatedBytes;
            int i16 = this.hashLen;
            int i17 = i15 % i16;
            int min = Math.min(i16 - (i15 % i16), i11);
            System.arraycopy(this.currentT, i17, bArr, i10, min);
            this.generatedBytes += min;
            int i18 = i11 - min;
            while (true) {
                i10 += min;
                if (i18 <= 0) {
                    return i11;
                }
                expandNext();
                min = Math.min(this.hashLen, i18);
                System.arraycopy(this.currentT, 0, bArr, i10, min);
                this.generatedBytes += min;
                i18 -= min;
            }
        } else {
            throw new DataLengthException("HKDF may only be used for 255 * HashLen bytes of output");
        }
    }

    public Digest getDigest() {
        return this.hMacHash.getUnderlyingDigest();
    }

    public void init(DerivationParameters derivationParameters) {
        KeyParameter keyParameter;
        HMac hMac;
        if (derivationParameters instanceof HKDFParameters) {
            HKDFParameters hKDFParameters = (HKDFParameters) derivationParameters;
            if (hKDFParameters.skipExtract()) {
                hMac = this.hMacHash;
                keyParameter = new KeyParameter(hKDFParameters.getIKM());
            } else {
                hMac = this.hMacHash;
                keyParameter = extract(hKDFParameters.getSalt(), hKDFParameters.getIKM());
            }
            hMac.init(keyParameter);
            this.info = hKDFParameters.getInfo();
            this.generatedBytes = 0;
            this.currentT = new byte[this.hashLen];
            return;
        }
        throw new IllegalArgumentException("HKDF parameters required for HKDFBytesGenerator");
    }
}
