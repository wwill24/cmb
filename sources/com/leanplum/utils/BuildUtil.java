package com.leanplum.utils;

import android.content.Context;
import android.os.Build;

public class BuildUtil {
    private static int targetSdk = -1;

    public static int createIntentFlags(int i10) {
        return i10 | 67108864;
    }

    private static int getTargetSdkVersion(Context context) {
        if (targetSdk == -1 && context != null) {
            targetSdk = context.getApplicationInfo().targetSdkVersion;
        }
        return targetSdk;
    }

    public static boolean isNotificationChannelSupported(Context context) {
        return Build.VERSION.SDK_INT >= 26 && getTargetSdkVersion(context) >= 26;
    }

    public static boolean shouldDisableTrampolines(Context context) {
        return Build.VERSION.SDK_INT >= 31 && getTargetSdkVersion(context) >= 31;
    }
}
