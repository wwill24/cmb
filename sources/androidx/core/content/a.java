package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.core.app.j0;
import java.io.File;
import java.util.concurrent.Executor;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class a {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sLock = new Object();
    private static final Object sSync = new Object();
    private static TypedValue sTempValue;

    /* renamed from: androidx.core.content.a$a  reason: collision with other inner class name */
    static class C0035a {
        static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    static class b {
        static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    static class c {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        static Drawable b(Context context, int i10) {
            return context.getDrawable(i10);
        }

        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    static class d {
        static int a(Context context, int i10) {
            return context.getColor(i10);
        }

        static <T> T b(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    static class e {
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        static File b(Context context) {
            return context.getDataDir();
        }

        static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    static class f {
        static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
            if ((i10 & 4) != 0 && str == null) {
                return context.registerReceiver(broadcastReceiver, intentFilter, a.obtainAndCheckReceiverPermission(context), handler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i10 & 1);
        }

        static ComponentName b(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    static class g {
        static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    static class h {
        static String a(Context context) {
            return context.getAttributionTag();
        }
    }

    static class i {
        static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i10);
        }
    }

    protected a() {
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        androidx.core.util.c.d(str, "permission must be non-null");
        if (androidx.core.os.a.c() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        if (j0.b(context).a()) {
            return 0;
        }
        return -1;
    }

    public static Context createDeviceProtectedStorageContext(@NonNull Context context) {
        return e.a(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File createFilesDir(java.io.File r3) {
        /*
            java.lang.Object r0 = sSync
            monitor-enter(r0)
            boolean r1 = r3.exists()     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0022
            boolean r1 = r3.mkdirs()     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return r3
        L_0x0011:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "Unable to create files subdir "
            r1.append(r2)     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = r3.getPath()     // Catch:{ all -> 0x0024 }
            r1.append(r2)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return r3
        L_0x0024:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.a.createFilesDir(java.io.File):java.io.File");
    }

    public static String getAttributionTag(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return h.a(context);
        }
        return null;
    }

    @NonNull
    public static File getCodeCacheDir(@NonNull Context context) {
        return c.a(context);
    }

    public static int getColor(@NonNull Context context, int i10) {
        return d.a(context, i10);
    }

    public static ColorStateList getColorStateList(@NonNull Context context, int i10) {
        return androidx.core.content.res.h.d(context.getResources(), i10, context.getTheme());
    }

    public static File getDataDir(@NonNull Context context) {
        return e.b(context);
    }

    public static Drawable getDrawable(@NonNull Context context, int i10) {
        return c.b(context, i10);
    }

    @NonNull
    public static File[] getExternalCacheDirs(@NonNull Context context) {
        return b.a(context);
    }

    @NonNull
    public static File[] getExternalFilesDirs(@NonNull Context context, String str) {
        return b.b(context, str);
    }

    @NonNull
    public static Executor getMainExecutor(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return g.a(context);
        }
        return androidx.core.os.g.a(new Handler(context.getMainLooper()));
    }

    public static File getNoBackupFilesDir(@NonNull Context context) {
        return c.c(context);
    }

    @NonNull
    public static File[] getObbDirs(@NonNull Context context) {
        return b.c(context);
    }

    public static <T> T getSystemService(@NonNull Context context, @NonNull Class<T> cls) {
        return d.b(context, cls);
    }

    public static String getSystemServiceName(@NonNull Context context, @NonNull Class<?> cls) {
        return d.c(context, cls);
    }

    public static boolean isDeviceProtectedStorage(@NonNull Context context) {
        return e.c(context);
    }

    static String obtainAndCheckReceiverPermission(Context context) {
        String str = context.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (g.b(context, str) == 0) {
            return str;
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    public static Intent registerReceiver(@NonNull Context context, BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter, int i10) {
        return registerReceiver(context, broadcastReceiver, intentFilter, (String) null, (Handler) null, i10);
    }

    public static boolean startActivities(@NonNull Context context, @NonNull Intent[] intentArr) {
        return startActivities(context, intentArr, (Bundle) null);
    }

    public static void startActivity(@NonNull Context context, @NonNull Intent intent, Bundle bundle) {
        C0035a.b(context, intent, bundle);
    }

    public static void startForegroundService(@NonNull Context context, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            f.b(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static Intent registerReceiver(@NonNull Context context, BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter, String str, Handler handler, int i10) {
        int i11 = i10 & 1;
        if (i11 == 0 || (i10 & 4) == 0) {
            if (i11 != 0) {
                i10 |= 2;
            }
            int i12 = i10;
            int i13 = i12 & 2;
            if (i13 == 0 && (i12 & 4) == 0) {
                throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
            } else if (i13 != 0 && (i12 & 4) != 0) {
                throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
            } else if (androidx.core.os.a.c()) {
                return i.a(context, broadcastReceiver, intentFilter, str, handler, i12);
            } else {
                if (Build.VERSION.SDK_INT >= 26) {
                    return f.a(context, broadcastReceiver, intentFilter, str, handler, i12);
                }
                if ((i12 & 4) == 0 || str != null) {
                    return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
                }
                return context.registerReceiver(broadcastReceiver, intentFilter, obtainAndCheckReceiverPermission(context), handler);
            }
        } else {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
    }

    public static boolean startActivities(@NonNull Context context, @NonNull Intent[] intentArr, Bundle bundle) {
        C0035a.a(context, intentArr, bundle);
        return true;
    }
}
