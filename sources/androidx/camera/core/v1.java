package androidx.camera.core;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;

public final class v1 {

    /* renamed from: a  reason: collision with root package name */
    private static int f2926a = 3;

    public static void a(@NonNull String str, @NonNull String str2) {
        h(k(str), 3);
    }

    public static void b(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        h(k(str), 3);
    }

    public static void c(@NonNull String str, @NonNull String str2) {
        h(k(str), 6);
    }

    public static void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        h(k(str), 6);
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        h(k(str), 4);
    }

    public static boolean f(@NonNull String str) {
        return h(k(str), 3);
    }

    public static boolean g(@NonNull String str) {
        return h(k(str), 4);
    }

    private static boolean h(@NonNull String str, int i10) {
        return f2926a <= i10 || Log.isLoggable(str, i10);
    }

    static void i() {
        f2926a = 3;
    }

    static void j(int i10) {
        f2926a = i10;
    }

    @NonNull
    private static String k(@NonNull String str) {
        if (Build.VERSION.SDK_INT > 25 || 23 >= str.length()) {
            return str;
        }
        return str.substring(0, 23);
    }

    public static void l(@NonNull String str, @NonNull String str2) {
        h(k(str), 5);
    }

    public static void m(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        h(k(str), 5);
    }
}
