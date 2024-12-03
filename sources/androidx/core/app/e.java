package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.NonNull;

public final class e {

    static class a {
        static <T> T a(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        static int b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        static int c(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        static String d(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    static class b {
        static int a(AppOpsManager appOpsManager, @NonNull String str, int i10, @NonNull String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i10, str2);
        }

        @NonNull
        static String b(@NonNull Context context) {
            return context.getOpPackageName();
        }

        static AppOpsManager c(@NonNull Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    public static int a(@NonNull Context context, int i10, @NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return b(context, str, str2);
        }
        AppOpsManager c10 = b.c(context);
        int a10 = b.a(c10, str, Binder.getCallingUid(), str2);
        if (a10 != 0) {
            return a10;
        }
        return b.a(c10, str, i10, b.b(context));
    }

    public static int b(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return a.c((AppOpsManager) a.a(context, AppOpsManager.class), str, str2);
    }

    public static String c(@NonNull String str) {
        return a.d(str);
    }
}
