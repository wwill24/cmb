package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class ISO10126d2Padding implements BlockCipherPadding {
    SecureRandom random;

    public int addPadding(byte[] bArr, int i10) {
        byte length = (byte) (bArr.length - i10);
        while (i10 < bArr.length - 1) {
            bArr[i10] = (byte) this.random.nextInt();
            i10++;
        }
        bArr[i10] = length;
        return length;
    }

    public String getPaddingName() {
        return "ISO10126-2";
    }

    public void init(SecureRandom secureRandom) throws IllegalArgumentException {
        this.random = CryptoServicesRegistrar.getSecureRandom(secureRandom);
    }

    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        byte b10 = bArr[bArr.length - 1] & 255;
        if (b10 <= bArr.length) {
            return b10;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
