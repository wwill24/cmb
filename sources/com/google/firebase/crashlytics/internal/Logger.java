package com.google.firebase.crashlytics.internal;

import android.util.Log;

public class Logger {
    static final Logger DEFAULT_LOGGER = new Logger(TAG);
    public static final String TAG = "FirebaseCrashlytics";
    private int logLevel = 4;
    private final String tag;

    public Logger(String str) {
        this.tag = str;
    }

    private boolean canLog(int i10) {
        return this.logLevel <= i10 || Log.isLoggable(this.tag, i10);
    }

    public static Logger getLogger() {
        return DEFAULT_LOGGER;
    }

    public void d(String str, Throwable th2) {
        canLog(3);
    }

    public void e(String str, Throwable th2) {
        canLog(6);
    }

    public void i(String str, Throwable th2) {
        canLog(4);
    }

    public void log(int i10, String str) {
        log(i10, str, false);
    }

    public void v(String str, Throwable th2) {
        canLog(2);
    }

    public void w(String str, Throwable th2) {
        canLog(5);
    }

    public void d(String str) {
        d(str, (Throwable) null);
    }

    public void e(String str) {
        e(str, (Throwable) null);
    }

    public void i(String str) {
        i(str, (Throwable) null);
    }

    public void log(int i10, String str, boolean z10) {
        if (z10 || canLog(i10)) {
            Log.println(i10, this.tag, str);
        }
    }

    public void v(String str) {
        v(str, (Throwable) null);
    }

    public void w(String str) {
        w(str, (Throwable) null);
    }
}
