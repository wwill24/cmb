package com.appsflyer.internal;

import org.jivesoftware.smack.datatypes.UInt32;

public final class AFf1gSDK {
    static long[] AFKeystoreWrapper(int i10, int i11) {
        long[] jArr = new long[4];
        jArr[0] = (((long) i11) & UInt32.MAX_VALUE_LONG) | ((((long) i10) & UInt32.MAX_VALUE_LONG) << 32);
        for (int i12 = 1; i12 < 4; i12++) {
            long j10 = jArr[i12 - 1];
            jArr[i12] = ((j10 ^ (j10 >> 30)) * 1812433253) + ((long) i12);
        }
        return jArr;
    }
}
