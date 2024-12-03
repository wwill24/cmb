package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import io.sentry.SentryLevel;
import io.sentry.h0;
import java.util.List;

final class j0 {
    @SuppressLint({"NewApi"})
    static ApplicationInfo a(Context context, long j10, i0 i0Var) throws PackageManager.NameNotFoundException {
        if (i0Var.d() >= 33) {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(j10));
        }
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
    }

    @SuppressLint({"NewApi"})
    static PackageInfo b(Context context, int i10, h0 h0Var, i0 i0Var) {
        try {
            if (i0Var.d() >= 33) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of((long) i10));
            }
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i10);
        } catch (Throwable th2) {
            h0Var.b(SentryLevel.ERROR, "Error getting package info.", th2);
            return null;
        }
    }

    static PackageInfo c(Context context, h0 h0Var, i0 i0Var) {
        return b(context, 0, h0Var, i0Var);
    }

    @SuppressLint({"NewApi"})
    static String d(PackageInfo packageInfo, i0 i0Var) {
        if (i0Var.d() >= 28) {
            return Long.toString(packageInfo.getLongVersionCode());
        }
        return e(packageInfo);
    }

    private static String e(PackageInfo packageInfo) {
        return Integer.toString(packageInfo.versionCode);
    }

    static boolean f(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Object systemService = context.getSystemService("activity");
            if (!(systemService instanceof ActivityManager) || (runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses()) == null) {
                return false;
            }
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == myPid) {
                    if (next.importance == 100) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
