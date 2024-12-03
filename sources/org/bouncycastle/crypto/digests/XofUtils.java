package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Arrays;

public class XofUtils {
    static byte[] encode(byte b10) {
        return Arrays.concatenate(leftEncode(8), new byte[]{b10});
    }

    static byte[] encode(byte[] bArr, int i10, int i11) {
        return bArr.length == i11 ? Arrays.concatenate(leftEncode((long) (i11 * 8)), bArr) : Arrays.concatenate(leftEncode((long) (i11 * 8)), Arrays.copyOfRange(bArr, i10, i11 + i10));
    }

    public static byte[] leftEncode(long j10) {
        long j11 = j10;
        byte b10 = 1;
        while (true) {
            j11 >>= 8;
            if (j11 == 0) {
                break;
            }
            b10 = (byte) (b10 + 1);
        }
        byte[] bArr = new byte[(b10 + 1)];
        bArr[0] = b10;
        for (int i10 = 1; i10 <= b10; i10++) {
            bArr[i10] = (byte) ((int) (j10 >> ((b10 - i10) * 8)));
        }
        return bArr;
    }

    public static byte[] rightEncode(long j10) {
        long j11 = j10;
        byte b10 = 1;
        while (true) {
            j11 >>= 8;
            if (j11 == 0) {
                break;
            }
            b10 = (byte) (b10 + 1);
        }
        byte[] bArr = new byte[(b10 + 1)];
        bArr[b10] = b10;
        for (int i10 = 0; i10 < b10; i10++) {
            bArr[i10] = (byte) ((int) (j10 >> (((b10 - i10) - 1) * 8)));
        }
        return bArr;
    }
}
