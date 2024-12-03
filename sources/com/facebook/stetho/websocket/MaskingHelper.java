package com.facebook.stetho.websocket;

class MaskingHelper {
    MaskingHelper() {
    }

    public static void unmask(byte[] bArr, byte[] bArr2, int i10, int i11) {
        int i12 = 0;
        while (true) {
            int i13 = i11 - 1;
            if (i11 > 0) {
                bArr2[i10] = (byte) (bArr[i12 % bArr.length] ^ bArr2[i10]);
                i10++;
                i11 = i13;
                i12++;
            } else {
                return;
            }
        }
    }
}
