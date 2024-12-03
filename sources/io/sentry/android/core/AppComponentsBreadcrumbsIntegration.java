package io.sentry.android.core;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.f;
import io.sentry.d;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.protocol.Device;
import io.sentry.util.l;
import io.sentry.w;
import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;

public final class AppComponentsBreadcrumbsIntegration implements Integration, Closeable, ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30851a;

    /* renamed from: b  reason: collision with root package name */
    private g0 f30852b;

    /* renamed from: c  reason: collision with root package name */
    private SentryAndroidOptions f30853c;

    public AppComponentsBreadcrumbsIntegration(Context context) {
        this.f30851a = (Context) l.c(context, "Context is required");
    }

    private void e(Integer num) {
        if (this.f30852b != null) {
            d dVar = new d();
            if (num != null) {
                if (num.intValue() >= 40) {
                    dVar.m(FirebaseAnalytics.Param.LEVEL, num);
                } else {
                    return;
                }
            }
            dVar.p("system");
            dVar.l("device.event");
            dVar.o("Low memory");
            dVar.m("action", "LOW_MEMORY");
            dVar.n(SentryLevel.WARNING);
            this.f30852b.q(dVar);
        }
    }

    public void a(g0 g0Var, SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions;
        this.f30852b = (g0) l.c(g0Var, "Hub is required");
        if (sentryOptions instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions) sentryOptions;
        } else {
            sentryAndroidOptions = null;
        }
        SentryAndroidOptions sentryAndroidOptions2 = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f30853c = sentryAndroidOptions2;
        h0 logger = sentryAndroidOptions2.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "AppComponentsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.f30853c.isEnableAppComponentBreadcrumbs()));
        if (this.f30853c.isEnableAppComponentBreadcrumbs()) {
            try {
                this.f30851a.registerComponentCallbacks(this);
                sentryOptions.getLogger().c(sentryLevel, "AppComponentsBreadcrumbsIntegration installed.", new Object[0]);
                c();
            } catch (Throwable th2) {
                this.f30853c.setEnableAppComponentBreadcrumbs(false);
                sentryOptions.getLogger().a(SentryLevel.INFO, th2, "ComponentCallbacks2 is not available.", new Object[0]);
            }
        }
    }

    public void close() throws IOException {
        try {
            this.f30851a.unregisterComponentCallbacks(this);
        } catch (Throwable th2) {
            SentryAndroidOptions sentryAndroidOptions = this.f30853c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().a(SentryLevel.DEBUG, th2, "It was not possible to unregisterComponentCallbacks", new Object[0]);
            }
        }
        SentryAndroidOptions sentryAndroidOptions2 = this.f30853c;
        if (sentryAndroidOptions2 != null) {
            sentryAndroidOptions2.getLogger().c(SentryLevel.DEBUG, "AppComponentsBreadcrumbsIntegration removed.", new Object[0]);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        String str;
        if (this.f30852b != null) {
            Device.DeviceOrientation a10 = f.a(this.f30851a.getResources().getConfiguration().orientation);
            if (a10 != null) {
                str = a10.name().toLowerCase(Locale.ROOT);
            } else {
                str = "undefined";
            }
            d dVar = new d();
            dVar.p("navigation");
            dVar.l("device.orientation");
            dVar.m("position", str);
            dVar.n(SentryLevel.INFO);
            w wVar = new w();
            wVar.i("android:configuration", configuration);
            this.f30852b.t(dVar, wVar);
        }
    }

    public void onLowMemory() {
        e((Integer) null);
    }

    public void onTrimMemory(int i10) {
        e(Integer.valueOf(i10));
    }
}
