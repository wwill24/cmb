package io.sentry.android.core;

import android.util.Log;
import io.sentry.SentryLevel;
import io.sentry.h0;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class s implements h0 {

    /* renamed from: a  reason: collision with root package name */
    private final String f31102a;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31103a;

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
                io.sentry.SentryLevel[] r0 = io.sentry.SentryLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31103a = r0
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31103a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.WARNING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31103a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31103a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.FATAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31103a     // Catch:{ NoSuchFieldError -> 0x003e }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.s.a.<clinit>():void");
        }
    }

    public s() {
        this("Sentry");
    }

    private int e(SentryLevel sentryLevel) {
        int i10 = a.f31103a[sentryLevel.ordinal()];
        if (i10 == 1) {
            return 4;
        }
        if (i10 != 2) {
            return i10 != 4 ? 3 : 7;
        }
        return 5;
    }

    public void a(SentryLevel sentryLevel, Throwable th2, String str, Object... objArr) {
        b(sentryLevel, String.format(str, objArr), th2);
    }

    public void b(SentryLevel sentryLevel, String str, Throwable th2) {
        if (a.f31103a[sentryLevel.ordinal()] == 4) {
            Log.wtf(this.f31102a, str, th2);
        }
    }

    public void c(SentryLevel sentryLevel, String str, Object... objArr) {
        Log.println(e(sentryLevel), this.f31102a, String.format(str, objArr));
    }

    public boolean d(SentryLevel sentryLevel) {
        return true;
    }

    public s(String str) {
        this.f31102a = str;
    }
}
