package com.appsflyer;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.appsflyer.internal.AFb1iSDK;
import com.appsflyer.internal.AFb1uSDK;
import com.appsflyer.internal.AFb1zSDK;

public class AFLogger {
    private static final long valueOf = System.currentTimeMillis();

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        
        private int AFKeystoreWrapper;

        private LogLevel(int i10) {
            this.AFKeystoreWrapper = i10;
        }

        public final int getLevel() {
            return this.AFKeystoreWrapper;
        }
    }

    private static boolean AFInAppEventType(LogLevel logLevel) {
        if (logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return true;
        }
        return false;
    }

    @NonNull
    private static String AFKeystoreWrapper(String str, boolean z10) {
        if (str == null) {
            str = "null";
        }
        if (!z10 && LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder("(");
        sb2.append(System.currentTimeMillis() - valueOf);
        sb2.append(") [");
        sb2.append(Thread.currentThread().getName());
        sb2.append("] ");
        sb2.append(str);
        return sb2.toString();
    }

    public static void afDebugLog(String str) {
        if (AFInAppEventType(LogLevel.DEBUG)) {
            AFKeystoreWrapper(str, false);
        }
        AFb1uSDK.AFInAppEventType().values("D", AFKeystoreWrapper(str, true));
    }

    public static void afErrorLog(String str, Throwable th2, boolean z10, boolean z11, boolean z12) {
        long j10;
        if (str == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(th2.getClass().getSimpleName());
            sb2.append(" at ");
            sb2.append(th2.getStackTrace()[0].toString());
            str = sb2.toString();
        }
        if (AFInAppEventType(LogLevel.ERROR)) {
            AFKeystoreWrapper(str, false);
        }
        AFb1uSDK.AFInAppEventType().values(th2);
        Application application = AFb1iSDK.AFKeystoreWrapper;
        if (application != null) {
            SharedPreferences.Editor edit = AFb1zSDK.AFInAppEventType((Context) application).edit();
            Application application2 = AFb1iSDK.AFKeystoreWrapper;
            if (application2 == null) {
                j10 = -1;
            } else {
                j10 = AFb1zSDK.AFInAppEventType((Context) application2).getLong("exception_number", 0);
            }
            edit.putLong("exception_number", j10 + 1).apply();
        }
        if (z12) {
            AFb1zSDK.AFInAppEventType().AFInAppEventParameterName().onInstallConversionDataLoadedNative().AFInAppEventParameterName(th2, str);
        }
    }

    public static void afErrorLogForExcManagerOnly(String str, Throwable th2) {
        afErrorLogForExcManagerOnly(str, th2, false);
    }

    public static void afInfoLog(String str, boolean z10) {
        if (AFInAppEventType(LogLevel.INFO)) {
            AFKeystoreWrapper(str, false);
        }
        if (z10) {
            AFb1uSDK.AFInAppEventType().values("I", AFKeystoreWrapper(str, true));
        }
    }

    public static void afRDLog(String str) {
        if (AFInAppEventType(LogLevel.VERBOSE)) {
            AFKeystoreWrapper(str, false);
        }
        AFb1uSDK.AFInAppEventType().values("V", AFKeystoreWrapper(str, true));
    }

    public static void afWarnLog(String str) {
        values(str);
    }

    public static void valueOf(String str) {
        if (!valueOf()) {
            AFKeystoreWrapper(str, false);
        }
        AFb1uSDK.AFInAppEventType().values("F", str);
    }

    public static void values(String str) {
        if (AFInAppEventType(LogLevel.WARNING)) {
            AFKeystoreWrapper(str, false);
        }
        AFb1uSDK.AFInAppEventType().values("W", AFKeystoreWrapper(str, true));
    }

    public static void afErrorLogForExcManagerOnly(String str, Throwable th2, boolean z10) {
        afErrorLog(str, th2, false, false, !z10);
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    private static boolean valueOf() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void afErrorLog(String str, Throwable th2) {
        afErrorLog(str, th2, true, false, true);
    }

    public static void afErrorLog(String str, Throwable th2, boolean z10) {
        afErrorLog(str, th2, true, z10, true);
    }

    public static void afErrorLog(String str, Throwable th2, boolean z10, boolean z11) {
        afErrorLog(str, th2, true, z10, z11);
    }

    @Deprecated
    public static void afErrorLog(Throwable th2) {
        afErrorLogForExcManagerOnly("Unknown", th2);
    }
}
