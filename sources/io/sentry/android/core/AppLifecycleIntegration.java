package io.sentry.android.core;

import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.b;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.util.l;
import java.io.Closeable;
import java.io.IOException;

public final class AppLifecycleIntegration implements Integration, Closeable {

    /* renamed from: a  reason: collision with root package name */
    volatile LifecycleWatcher f30854a;

    /* renamed from: b  reason: collision with root package name */
    private SentryAndroidOptions f30855b;

    /* renamed from: c  reason: collision with root package name */
    private final u0 f30856c;

    public AppLifecycleIntegration() {
        this(new u0());
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void k(g0 g0Var) {
        SentryAndroidOptions sentryAndroidOptions = this.f30855b;
        if (sentryAndroidOptions != null) {
            this.f30854a = new LifecycleWatcher(g0Var, sentryAndroidOptions.getSessionTrackingIntervalMillis(), this.f30855b.isEnableAutoSessionTracking(), this.f30855b.isEnableAppLifecycleBreadcrumbs());
            try {
                ProcessLifecycleOwner.l().getLifecycle().a(this.f30854a);
                this.f30855b.getLogger().c(SentryLevel.DEBUG, "AppLifecycleIntegration installed.", new Object[0]);
                c();
            } catch (Throwable th2) {
                this.f30854a = null;
                this.f30855b.getLogger().b(SentryLevel.ERROR, "AppLifecycleIntegration failed to get Lifecycle and could not be installed.", th2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void h() {
        LifecycleWatcher lifecycleWatcher = this.f30854a;
        if (lifecycleWatcher != null) {
            ProcessLifecycleOwner.l().getLifecycle().d(lifecycleWatcher);
            SentryAndroidOptions sentryAndroidOptions = this.f30855b;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "AppLifecycleIntegration removed.", new Object[0]);
            }
        }
        this.f30854a = null;
    }

    public void a(g0 g0Var, SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions;
        l.c(g0Var, "Hub is required");
        if (sentryOptions instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions) sentryOptions;
        } else {
            sentryAndroidOptions = null;
        }
        SentryAndroidOptions sentryAndroidOptions2 = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f30855b = sentryAndroidOptions2;
        h0 logger = sentryAndroidOptions2.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "enableSessionTracking enabled: %s", Boolean.valueOf(this.f30855b.isEnableAutoSessionTracking()));
        this.f30855b.getLogger().c(sentryLevel, "enableAppLifecycleBreadcrumbs enabled: %s", Boolean.valueOf(this.f30855b.isEnableAppLifecycleBreadcrumbs()));
        if (this.f30855b.isEnableAutoSessionTracking() || this.f30855b.isEnableAppLifecycleBreadcrumbs()) {
            try {
                ProcessLifecycleOwner.b bVar = ProcessLifecycleOwner.f5952j;
                if (b.e().a()) {
                    k(g0Var);
                } else {
                    this.f30856c.b(new f0(this, g0Var));
                }
            } catch (ClassNotFoundException e10) {
                sentryOptions.getLogger().b(SentryLevel.INFO, "androidx.lifecycle is not available, AppLifecycleIntegration won't be installed", e10);
            } catch (IllegalStateException e11) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "AppLifecycleIntegration could not be installed", e11);
            }
        }
    }

    public void close() throws IOException {
        if (this.f30854a != null) {
            if (b.e().a()) {
                h();
            } else {
                this.f30856c.b(new e0(this));
            }
        }
    }

    AppLifecycleIntegration(u0 u0Var) {
        this.f30856c = u0Var;
    }
}
