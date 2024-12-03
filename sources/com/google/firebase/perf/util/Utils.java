package com.google.firebase.perf.util;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.firebase.perf.logging.AndroidLogger;
import okhttp3.t;

public class Utils {
    private static Boolean isDebugLoggingEnabled;

    public static int bufferToInt(@NonNull byte[] bArr) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < 4 && i10 < bArr.length) {
            i11 |= (bArr[i10] & 255) << (i10 * 8);
            i10++;
        }
        return i11;
    }

    public static void checkArgument(boolean z10, String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean isDebugLoggingEnabled(@NonNull Context context) {
        Boolean bool = isDebugLoggingEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            isDebugLoggingEnabled = valueOf;
            return valueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e10) {
            AndroidLogger instance = AndroidLogger.getInstance();
            instance.debug("No perf logcat meta data found " + e10.getMessage());
            return false;
        }
    }

    public static int saturatedIntCast(long j10) {
        if (j10 > 2147483647L) {
            return a.e.API_PRIORITY_OTHER;
        }
        if (j10 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j10;
    }

    public static String stripSensitiveInfo(@NonNull String str) {
        t m10 = t.m(str);
        if (m10 != null) {
            return m10.k().H("").s("").w((String) null).f((String) null).toString();
        }
        return str;
    }

    public static String truncateURL(String str, int i10) {
        int lastIndexOf;
        if (str.length() <= i10) {
            return str;
        }
        if (str.charAt(i10) == '/') {
            return str.substring(0, i10);
        }
        t m10 = t.m(str);
        if (m10 == null) {
            return str.substring(0, i10);
        }
        if (m10.d().lastIndexOf(47) < 0 || (lastIndexOf = str.lastIndexOf(47, i10 - 1)) < 0) {
            return str.substring(0, i10);
        }
        return str.substring(0, lastIndexOf);
    }
}
