package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class ISO7816d4Padding implements BlockCipherPadding {
    public int addPadding(byte[] bArr, int i10) {
        int length = bArr.length - i10;
        bArr[i10] = Byte.MIN_VALUE;
        while (true) {
            i10++;
            if (i10 >= bArr.length) {
                return length;
            }
            bArr[i10] = 0;
        }
    }

    public String getPaddingName() {
        return "ISO7816-4";
    }

    public void init(SecureRandom secureRandom) throws IllegalArgumentException {
    }

    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        int length = bArr.length - 1;
        while (length > 0 && bArr[length] == 0) {
            length--;
        }
        if (bArr[length] == Byte.MIN_VALUE) {
            return bArr.length - length;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
