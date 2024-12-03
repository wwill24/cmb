package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class X923Padding implements BlockCipherPadding {
    SecureRandom random = null;

    public int addPadding(byte[] bArr, int i10) {
        byte length = (byte) (bArr.length - i10);
        while (i10 < bArr.length - 1) {
            SecureRandom secureRandom = this.random;
            if (secureRandom == null) {
                bArr[i10] = 0;
            } else {
                bArr[i10] = (byte) secureRandom.nextInt();
            }
            i10++;
        }
        bArr[i10] = length;
        return length;
    }

    public String getPaddingName() {
        return "X9.23";
    }

    public void init(SecureRandom secureRandom) throws IllegalArgumentException {
        this.random = secureRandom;
    }

    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        byte b10 = bArr[bArr.length - 1] & 255;
        if (b10 <= bArr.length) {
            return b10;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
