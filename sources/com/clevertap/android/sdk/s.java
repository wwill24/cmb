package com.clevertap.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.facebook.internal.security.CertificateUtil;
import net.bytebuddy.utility.JavaConstant;

public final class s {
    static boolean a(Context context, String str, boolean z10) {
        return g(context).getBoolean(str, z10);
    }

    static boolean b(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        if (!cleverTapInstanceConfig.t()) {
            return a(context, s(cleverTapInstanceConfig, str), false);
        }
        boolean a10 = a(context, s(cleverTapInstanceConfig, str), false);
        if (!a10) {
            return a(context, str, false);
        }
        return a10;
    }

    public static int c(Context context, String str, int i10) {
        return g(context).getInt(str, i10);
    }

    public static int d(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, int i10) {
        if (!cleverTapInstanceConfig.t()) {
            return c(context, s(cleverTapInstanceConfig, str), i10);
        }
        int c10 = c(context, s(cleverTapInstanceConfig, str), -1000);
        if (c10 != -1000) {
            return c10;
        }
        return c(context, str, i10);
    }

    static long e(Context context, String str, String str2, long j10) {
        return h(context, str).getLong(str2, j10);
    }

    public static long f(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, int i10, String str2) {
        if (!cleverTapInstanceConfig.t()) {
            return e(context, str2, s(cleverTapInstanceConfig, str), (long) i10);
        }
        long e10 = e(context, str2, s(cleverTapInstanceConfig, str), -1000);
        if (e10 != -1000) {
            return e10;
        }
        return e(context, str2, str, (long) i10);
    }

    public static SharedPreferences g(@NonNull Context context) {
        return h(context, (String) null);
    }

    public static SharedPreferences h(@NonNull Context context, String str) {
        String str2 = "WizRocket";
        if (str != null) {
            str2 = str2 + JavaConstant.Dynamic.DEFAULT_NAME + str;
        }
        return context.getSharedPreferences(str2, 0);
    }

    public static String i(@NonNull Context context, @NonNull String str, String str2) {
        return g(context).getString(str, str2);
    }

    static String j(Context context, String str, String str2, String str3) {
        return h(context, str).getString(str2, str3);
    }

    public static String k(@NonNull Context context, @NonNull CleverTapInstanceConfig cleverTapInstanceConfig, String str, String str2) {
        if (!cleverTapInstanceConfig.t()) {
            return i(context, s(cleverTapInstanceConfig, str), str2);
        }
        String i10 = i(context, s(cleverTapInstanceConfig, str), str2);
        if (i10 != null) {
            return i10;
        }
        return i(context, str, str2);
    }

    public static void l(SharedPreferences.Editor editor) {
        try {
            editor.apply();
        } catch (Throwable th2) {
            p.r("CRITICAL: Failed to persist shared preferences!", th2);
        }
    }

    public static void m(SharedPreferences.Editor editor) {
        try {
            editor.commit();
        } catch (Throwable th2) {
            p.r("CRITICAL: Failed to persist shared preferences!", th2);
        }
    }

    public static void n(Context context, String str, int i10) {
        l(g(context).edit().putInt(str, i10));
    }

    public static void o(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, String str2) {
        l(g(context).edit().putString(s(cleverTapInstanceConfig, str), str2));
    }

    public static void p(Context context, String str, String str2) {
        l(g(context).edit().putString(str, str2));
    }

    public static void q(Context context, String str, String str2) {
        m(g(context).edit().putString(str, str2));
    }

    public static void r(Context context, String str) {
        l(g(context).edit().remove(str));
    }

    public static String s(@NonNull CleverTapInstanceConfig cleverTapInstanceConfig, @NonNull String str) {
        return str + CertificateUtil.DELIMITER + cleverTapInstanceConfig.e();
    }
}
