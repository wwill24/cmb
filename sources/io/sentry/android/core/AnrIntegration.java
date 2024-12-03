package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.p3;
import io.sentry.protocol.g;
import io.sentry.util.i;
import io.sentry.util.l;
import java.io.Closeable;
import java.io.IOException;

public final class AnrIntegration implements Integration, Closeable {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static b f30846c;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f30847d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f30848a;

    /* renamed from: b  reason: collision with root package name */
    private SentryOptions f30849b;

    static final class a implements io.sentry.hints.a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f30850a;

        a(boolean z10) {
            this.f30850a = z10;
        }

        public boolean a() {
            return true;
        }

        public String b() {
            return this.f30850a ? "anr_background" : "anr_foreground";
        }
    }

    public AnrIntegration(Context context) {
        this.f30848a = context;
    }

    private Throwable f(boolean z10, SentryAndroidOptions sentryAndroidOptions, ApplicationNotResponding applicationNotResponding) {
        String str = "ANR for at least " + sentryAndroidOptions.getAnrTimeoutIntervalMillis() + " ms.";
        if (z10) {
            str = "Background " + str;
        }
        ApplicationNotResponding applicationNotResponding2 = new ApplicationNotResponding(str, applicationNotResponding.a());
        g gVar = new g();
        gVar.j("ANR");
        return new ExceptionMechanismException(gVar, applicationNotResponding2, applicationNotResponding2.a(), true);
    }

    private void h(g0 g0Var, SentryAndroidOptions sentryAndroidOptions) {
        h0 logger = sentryAndroidOptions.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "AnrIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isAnrEnabled()));
        if (sentryAndroidOptions.isAnrEnabled()) {
            synchronized (f30847d) {
                if (f30846c == null) {
                    sentryAndroidOptions.getLogger().c(sentryLevel, "ANR timeout in milliseconds: %d", Long.valueOf(sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                    b bVar = new b(sentryAndroidOptions.getAnrTimeoutIntervalMillis(), sentryAndroidOptions.isAnrReportInDebug(), new d0(this, g0Var, sentryAndroidOptions), sentryAndroidOptions.getLogger(), this.f30848a);
                    f30846c = bVar;
                    bVar.start();
                    sentryAndroidOptions.getLogger().c(sentryLevel, "AnrIntegration installed.", new Object[0]);
                    c();
                }
            }
        }
    }

    public final void a(g0 g0Var, SentryOptions sentryOptions) {
        this.f30849b = (SentryOptions) l.c(sentryOptions, "SentryOptions is required");
        h(g0Var, (SentryAndroidOptions) sentryOptions);
    }

    public void close() throws IOException {
        synchronized (f30847d) {
            b bVar = f30846c;
            if (bVar != null) {
                bVar.interrupt();
                f30846c = null;
                SentryOptions sentryOptions = this.f30849b;
                if (sentryOptions != null) {
                    sentryOptions.getLogger().c(SentryLevel.DEBUG, "AnrIntegration removed.", new Object[0]);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void g(g0 g0Var, SentryAndroidOptions sentryAndroidOptions, ApplicationNotResponding applicationNotResponding) {
        sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "ANR triggered with message: %s", applicationNotResponding.getMessage());
        boolean equals = Boolean.TRUE.equals(h0.a().b());
        p3 p3Var = new p3(f(equals, sentryAndroidOptions, applicationNotResponding));
        p3Var.x0(SentryLevel.ERROR);
        g0Var.x(p3Var, i.e(new a(equals)));
    }
}
