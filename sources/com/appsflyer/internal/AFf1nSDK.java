package com.appsflyer.internal;

public class AFf1nSDK {
    public static void valueOf(byte[] bArr, byte b10, long j10) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (((1 << i10) & j10) != 0) {
                bArr[i10] = (byte) (bArr[i10] ^ b10);
            }
        }
    }
}
