package com.facebook.stetho.common;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogRedirector {
    private static volatile Logger sLogger;

    public interface Logger {
        boolean isLoggable(String str, int i10);

        void log(int i10, String str, String str2);
    }

    public static void d(String str, String str2, Throwable th2) {
        d(str, str2 + "\n" + formatThrowable(th2));
    }

    public static void e(String str, String str2, Throwable th2) {
        e(str, str2 + "\n" + formatThrowable(th2));
    }

    private static String formatThrowable(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace();
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void i(String str, String str2, Throwable th2) {
        i(str, str2 + "\n" + formatThrowable(th2));
    }

    public static boolean isLoggable(String str, int i10) {
        Logger logger = sLogger;
        if (logger != null) {
            return logger.isLoggable(str, i10);
        }
        return Log.isLoggable(str, i10);
    }

    private static void log(int i10, String str, String str2) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(i10, str, str2);
        } else {
            Log.println(i10, str, str2);
        }
    }

    public static void setLogger(Logger logger) {
        Util.throwIfNull(logger);
        Util.throwIfNotNull(sLogger);
        sLogger = logger;
    }

    public static void v(String str, String str2, Throwable th2) {
        v(str, str2 + "\n" + formatThrowable(th2));
    }

    public static void w(String str, String str2, Throwable th2) {
        w(str, str2 + "\n" + formatThrowable(th2));
    }

    public static void d(String str, String str2) {
        log(3, str, str2);
    }

    public static void e(String str, String str2) {
        log(6, str, str2);
    }

    public static void i(String str, String str2) {
        log(4, str, str2);
    }

    public static void v(String str, String str2) {
        log(2, str, str2);
    }

    public static void w(String str, String str2) {
        log(5, str, str2);
    }
}
