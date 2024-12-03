package com.leanplum.internal;

import com.leanplum.LeanplumException;
import com.leanplum.internal.Constants;
import com.leanplum.internal.Request;
import com.leanplum.monitoring.ExceptionHandler;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.beanutils.PropertyUtils;

public class Log {
    private static final int LOGGER_MAX_LEN = 4000;
    private static ExceptionListener exceptionListener = null;
    private static int level = 2;

    /* renamed from: com.leanplum.internal.Log$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$leanplum$internal$Log$LogType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.leanplum.internal.Log$LogType[] r0 = com.leanplum.internal.Log.LogType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$leanplum$internal$Log$LogType = r0
                com.leanplum.internal.Log$LogType r1 = com.leanplum.internal.Log.LogType.ERROR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$leanplum$internal$Log$LogType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.leanplum.internal.Log$LogType r1 = com.leanplum.internal.Log.LogType.INFO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$leanplum$internal$Log$LogType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.leanplum.internal.Log$LogType r1 = com.leanplum.internal.Log.LogType.DEBUG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.Log.AnonymousClass1.<clinit>():void");
        }
    }

    public interface ExceptionListener {
        void onException(Throwable th2);
    }

    public static class Level {
        public static final int DEBUG = 3;
        public static final int ERROR = 1;
        public static final int INFO = 2;
        public static final int OFF = 0;
    }

    public enum LogType {
        DEBUG,
        INFO,
        ERROR
    }

    public static void d(String str, Object... objArr) {
        log(LogType.DEBUG, str, objArr);
    }

    public static void e(String str, Object... objArr) {
        log(LogType.ERROR, str, objArr);
    }

    public static void exception(Throwable th2) {
        String str;
        String str2;
        ExceptionListener exceptionListener2 = exceptionListener;
        if (exceptionListener2 != null) {
            exceptionListener2.onException(th2);
        }
        ExceptionHandler.getInstance().reportException(th2);
        if (th2 instanceof OutOfMemoryError) {
            if (Constants.isDevelopmentModeEnabled) {
                throw ((OutOfMemoryError) th2);
            }
        } else if (!(th2 instanceof LeanplumException)) {
            e("Internal error: %s", th2.getMessage());
            try {
                str = Util.getVersionName();
            } catch (Throwable unused) {
                str = "(Unknown)";
            }
            try {
                String message = th2.getMessage();
                if (message != null) {
                    str2 = th2.toString() + " (" + message + PropertyUtils.MAPPED_DELIM2;
                } else {
                    str2 = th2.toString();
                }
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                printWriter.println(str2);
                th2.printStackTrace(printWriter);
                RequestSender.getInstance().send(RequestBuilder.withLogAction().andParam("type", Constants.Values.SDK_LOG).andParam(Constants.Params.VERSION_NAME, str).andParam("message", stringWriter.toString()).andType(Request.RequestType.IMMEDIATE).create());
            } catch (Throwable th3) {
                e("Unable to send error report: %s", th3.getMessage());
            }
        } else if (Constants.isDevelopmentModeEnabled) {
            throw ((LeanplumException) th2);
        }
    }

    private static String formatTag(LogType logType) {
        return "[Leanplum][" + logType.name() + "]";
    }

    public static int getLogLevel() {
        return level;
    }

    public static String getStackTraceString(Throwable th2) {
        return android.util.Log.getStackTraceString(th2);
    }

    private static void handleLogMessage(String str, String str2) {
        if (Constants.loggingEnabled) {
            RequestBuilder andParam = RequestBuilder.withLogAction().andParam("type", Constants.Values.SDK_LOG);
            RequestSender.getInstance().send(andParam.andParam("message", str + str2).create());
        }
    }

    public static void i(String str, Object... objArr) {
        log(LogType.INFO, str, objArr);
    }

    private static void largeLogD(String str, String str2) {
        if (str2.length() > LOGGER_MAX_LEN) {
            str2.substring(0, LOGGER_MAX_LEN);
            largeLogD(str, str2.substring(LOGGER_MAX_LEN));
        }
    }

    public static void log(LogType logType, String str, Object... objArr) {
        try {
            String formatTag = formatTag(logType);
            String format2 = String.format(str, objArr);
            int i10 = AnonymousClass1.$SwitchMap$com$leanplum$internal$Log$LogType[logType.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        if (level >= 3) {
                            largeLogD(formatTag, format2);
                        }
                    }
                    handleLogMessage(formatTag, format2);
                }
            } else if (level >= 1) {
                handleLogMessage(formatTag, format2);
            }
            int i11 = level;
            handleLogMessage(formatTag, format2);
        } catch (Throwable unused) {
        }
    }

    public static void setExceptionListener(ExceptionListener exceptionListener2) {
        exceptionListener = exceptionListener2;
    }

    public static void setLogLevel(int i10) {
        level = i10;
    }

    public static void e(String str, Throwable th2) {
        ExceptionListener exceptionListener2 = exceptionListener;
        if (exceptionListener2 != null) {
            exceptionListener2.onException(th2);
        }
        if (str == null || !str.contains("%s")) {
            LogType logType = LogType.ERROR;
            log(logType, str + "\n" + getStackTraceString(th2), new Object[0]);
            return;
        }
        log(LogType.ERROR, str, getStackTraceString(th2));
    }
}
