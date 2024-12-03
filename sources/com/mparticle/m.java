package com.mparticle;

import android.annotation.TargetApi;
import android.os.StatFs;

@TargetApi(18)
public class m {
    public static long a(StatFs statFs) {
        try {
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception unused) {
            return 0;
        }
    }
}
