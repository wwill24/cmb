package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class PKCS7Padding implements BlockCipherPadding {
    public int addPadding(byte[] bArr, int i10) {
        byte length = (byte) (bArr.length - i10);
        while (i10 < bArr.length) {
            bArr[i10] = length;
            i10++;
        }
        return length;
    }

    public String getPaddingName() {
        return "PKCS7";
    }

    public void init(SecureRandom secureRandom) throws IllegalArgumentException {
    }

    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        byte b10 = bArr[bArr.length - 1] & 255;
        byte b11 = (byte) b10;
        boolean z10 = (b10 > bArr.length) | (b10 == 0);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            z10 |= (bArr.length - i10 <= b10) & (bArr[i10] != b11);
        }
        if (!z10) {
            return b10;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
