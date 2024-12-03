package com.mparticle.internal;

import android.util.Log;
import com.mparticle.MParticle;

public class Logger {
    public static final MParticle.LogLevel DEFAULT_MIN_LOG_LEVEL;
    private static AbstractLogHandler logHandler = new DefaultLogHandler();
    private static boolean sExplicitlySet = false;
    /* access modifiers changed from: private */
    public static MParticle.LogLevel sMinLogLevel;

    /* renamed from: com.mparticle.internal.Logger$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mparticle$MParticle$LogLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mparticle.MParticle$LogLevel[] r0 = com.mparticle.MParticle.LogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mparticle$MParticle$LogLevel = r0
                com.mparticle.MParticle$LogLevel r1 = com.mparticle.MParticle.LogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mparticle$MParticle$LogLevel     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mparticle.MParticle$LogLevel r1 = com.mparticle.MParticle.LogLevel.WARNING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$mparticle$MParticle$LogLevel     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mparticle.MParticle$LogLevel r1 = com.mparticle.MParticle.LogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$mparticle$MParticle$LogLevel     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mparticle.MParticle$LogLevel r1 = com.mparticle.MParticle.LogLevel.VERBOSE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$mparticle$MParticle$LogLevel     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mparticle.MParticle$LogLevel r1 = com.mparticle.MParticle.LogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.Logger.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class AbstractLogHandler {
        private boolean isLoggable(int i10) {
            boolean z10;
            if (i10 >= Logger.sMinLogLevel.logLevel) {
                z10 = true;
            } else {
                z10 = false;
            }
            try {
                if (isADBLoggable("mParticle", i10)) {
                    return true;
                }
                if (!z10 || !MPUtility.isDevEnv()) {
                    return false;
                }
                return true;
            } catch (RuntimeException | UnsatisfiedLinkError unused) {
                return false;
            }
        }

        public abstract void debug(Throwable th2, String str);

        public abstract void error(Throwable th2, String str);

        public abstract void info(Throwable th2, String str);

        /* access modifiers changed from: protected */
        public boolean isADBLoggable(String str, int i10) {
            return Log.isLoggable(str, i10);
        }

        public void log(MParticle.LogLevel logLevel, Throwable th2, String str) {
            if (str != null && isLoggable(logLevel.logLevel)) {
                int i10 = AnonymousClass1.$SwitchMap$com$mparticle$MParticle$LogLevel[logLevel.ordinal()];
                if (i10 == 1) {
                    error(th2, str);
                } else if (i10 == 2) {
                    warning(th2, str);
                } else if (i10 == 3) {
                    debug(th2, str);
                } else if (i10 == 4) {
                    verbose(th2, str);
                } else if (i10 == 5) {
                    info(th2, str);
                }
            }
        }

        public abstract void verbose(Throwable th2, String str);

        public abstract void warning(Throwable th2, String str);
    }

    public static class DefaultLogHandler extends AbstractLogHandler {
        public void debug(Throwable th2, String str) {
        }

        public void error(Throwable th2, String str) {
        }

        public void info(Throwable th2, String str) {
        }

        public void verbose(Throwable th2, String str) {
        }

        public void warning(Throwable th2, String str) {
        }
    }

    static {
        MParticle.LogLevel logLevel = MParticle.LogLevel.DEBUG;
        DEFAULT_MIN_LOG_LEVEL = logLevel;
        sMinLogLevel = logLevel;
    }

    public static void debug(String... strArr) {
        debug((Throwable) null, strArr);
    }

    public static void error(String... strArr) {
        error((Throwable) null, strArr);
    }

    public static AbstractLogHandler getLogHandler() {
        if (logHandler == null) {
            logHandler = new DefaultLogHandler();
        }
        return logHandler;
    }

    private static String getMessage(String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        for (String append : strArr) {
            sb2.append(append);
        }
        return sb2.toString();
    }

    public static MParticle.LogLevel getMinLogLevel() {
        return sMinLogLevel;
    }

    public static void info(String... strArr) {
        info((Throwable) null, strArr);
    }

    public static void setLogHandler(AbstractLogHandler abstractLogHandler) {
        logHandler = abstractLogHandler;
    }

    public static void setMinLogLevel(MParticle.LogLevel logLevel) {
        setMinLogLevel(logLevel, (Boolean) null);
    }

    public static void verbose(String... strArr) {
        verbose((Throwable) null, strArr);
    }

    public static void warning(String... strArr) {
        warning((Throwable) null, strArr);
    }

    public static void debug(Throwable th2, String... strArr) {
        getLogHandler().log(MParticle.LogLevel.DEBUG, th2, getMessage(strArr));
    }

    public static void error(Throwable th2, String... strArr) {
        getLogHandler().log(MParticle.LogLevel.ERROR, th2, getMessage(strArr));
    }

    public static void info(Throwable th2, String... strArr) {
        getLogHandler().log(MParticle.LogLevel.INFO, th2, getMessage(strArr));
    }

    public static void setMinLogLevel(MParticle.LogLevel logLevel, Boolean bool) {
        if (bool != null) {
            sExplicitlySet = bool.booleanValue();
        }
        if (!sExplicitlySet || bool != null) {
            sMinLogLevel = logLevel;
        }
    }

    public static void verbose(Throwable th2, String... strArr) {
        getLogHandler().log(MParticle.LogLevel.VERBOSE, th2, getMessage(strArr));
    }

    public static void warning(Throwable th2, String... strArr) {
        getLogHandler().log(MParticle.LogLevel.WARNING, th2, getMessage(strArr));
    }
}
