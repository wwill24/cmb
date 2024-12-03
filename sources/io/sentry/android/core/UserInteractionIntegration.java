package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.gestures.b;
import io.sentry.android.core.internal.gestures.g;
import io.sentry.android.core.internal.gestures.h;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.util.l;
import java.io.Closeable;
import java.io.IOException;

public final class UserInteractionIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final Application f30907a;

    /* renamed from: b  reason: collision with root package name */
    private g0 f30908b;

    /* renamed from: c  reason: collision with root package name */
    private SentryAndroidOptions f30909c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f30910d;

    public UserInteractionIntegration(Application application, t0 t0Var) {
        this.f30907a = (Application) l.c(application, "Application is required");
        this.f30910d = t0Var.b("androidx.core.view.GestureDetectorCompat", this.f30909c);
    }

    private void e(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            SentryAndroidOptions sentryAndroidOptions = this.f30909c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "Window was null in startTracking", new Object[0]);
            }
        } else if (this.f30908b != null && this.f30909c != null) {
            Window.Callback callback = window.getCallback();
            if (callback == null) {
                callback = new b();
            }
            window.setCallback(new h(callback, activity, new g(activity, this.f30908b, this.f30909c), this.f30909c));
        }
    }

    private void f(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            SentryAndroidOptions sentryAndroidOptions = this.f30909c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "Window was null in stopTracking", new Object[0]);
                return;
            }
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof h) {
            h hVar = (h) callback;
            hVar.c();
            if (hVar.a() instanceof b) {
                window.setCallback((Window.Callback) null);
            } else {
                window.setCallback(hVar.a());
            }
        }
    }

    public void a(g0 g0Var, SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions;
        boolean z10;
        if (sentryOptions instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions) sentryOptions;
        } else {
            sentryAndroidOptions = null;
        }
        this.f30909c = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f30908b = (g0) l.c(g0Var, "Hub is required");
        if (this.f30909c.isEnableUserInteractionBreadcrumbs() || this.f30909c.isEnableUserInteractionTracing()) {
            z10 = true;
        } else {
            z10 = false;
        }
        h0 logger = this.f30909c.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "UserInteractionIntegration enabled: %s", Boolean.valueOf(z10));
        if (!z10) {
            return;
        }
        if (this.f30910d) {
            this.f30907a.registerActivityLifecycleCallbacks(this);
            this.f30909c.getLogger().c(sentryLevel, "UserInteractionIntegration installed.", new Object[0]);
            c();
            return;
        }
        sentryOptions.getLogger().c(SentryLevel.INFO, "androidx.core is not available, UserInteractionIntegration won't be installed", new Object[0]);
    }

    public void close() throws IOException {
        this.f30907a.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.f30909c;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "UserInteractionIntegration removed.", new Object[0]);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        f(activity);
    }

    public void onActivityResumed(Activity activity) {
        e(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
