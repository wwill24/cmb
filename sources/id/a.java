package id;

import android.os.Build;
import android.util.Log;

public final class a {
    private static String a(String str, String str2) {
        String str3 = str + str2;
        if (str3.length() > 23) {
            return str3.substring(0, 23);
        }
        return str3;
    }

    public static void b(String str, String str2, Object obj) {
        if (Log.isLoggable(e(str), 3)) {
            String.format(str2, new Object[]{obj});
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (Log.isLoggable(e(str), 3)) {
            String.format(str2, objArr);
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        Log.isLoggable(e(str), 6);
    }

    private static String e(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return a("TRuntime.", str);
        }
        return "TRuntime." + str;
    }

    public static void f(String str, String str2, Object obj) {
        if (Log.isLoggable(e(str), 4)) {
            String.format(str2, new Object[]{obj});
        }
    }

    public static void g(String str, String str2, Object obj) {
        if (Log.isLoggable(e(str), 5)) {
            String.format(str2, new Object[]{obj});
        }
    }
}
