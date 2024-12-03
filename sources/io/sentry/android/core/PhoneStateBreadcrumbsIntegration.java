package io.sentry.android.core;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.i;
import io.sentry.d;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.util.l;
import java.io.Closeable;
import java.io.IOException;

public final class PhoneStateBreadcrumbsIntegration implements Integration, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30885a;

    /* renamed from: b  reason: collision with root package name */
    private SentryAndroidOptions f30886b;

    /* renamed from: c  reason: collision with root package name */
    a f30887c;

    /* renamed from: d  reason: collision with root package name */
    private TelephonyManager f30888d;

    static final class a extends PhoneStateListener {

        /* renamed from: a  reason: collision with root package name */
        private final g0 f30889a;

        a(g0 g0Var) {
            this.f30889a = g0Var;
        }

        public void onCallStateChanged(int i10, String str) {
            if (i10 == 1) {
                d dVar = new d();
                dVar.p("system");
                dVar.l("device.event");
                dVar.m("action", "CALL_STATE_RINGING");
                dVar.o("Device ringing");
                dVar.n(SentryLevel.INFO);
                this.f30889a.q(dVar);
            }
        }
    }

    public PhoneStateBreadcrumbsIntegration(Context context) {
        this.f30885a = (Context) l.c(context, "Context is required");
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
        this.f30886b = sentryAndroidOptions2;
        h0 logger = sentryAndroidOptions2.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "enableSystemEventBreadcrumbs enabled: %s", Boolean.valueOf(this.f30886b.isEnableSystemEventBreadcrumbs()));
        if (this.f30886b.isEnableSystemEventBreadcrumbs() && i.a(this.f30885a, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) this.f30885a.getSystemService("phone");
            this.f30888d = telephonyManager;
            if (telephonyManager != null) {
                try {
                    a aVar = new a(g0Var);
                    this.f30887c = aVar;
                    this.f30888d.listen(aVar, 32);
                    sentryOptions.getLogger().c(sentryLevel, "PhoneStateBreadcrumbsIntegration installed.", new Object[0]);
                    c();
                } catch (Throwable th2) {
                    this.f30886b.getLogger().a(SentryLevel.INFO, th2, "TelephonyManager is not available or ready to use.", new Object[0]);
                }
            } else {
                this.f30886b.getLogger().c(SentryLevel.INFO, "TelephonyManager is not available", new Object[0]);
            }
        }
    }

    public void close() throws IOException {
        a aVar;
        TelephonyManager telephonyManager = this.f30888d;
        if (telephonyManager != null && (aVar = this.f30887c) != null) {
            telephonyManager.listen(aVar, 0);
            this.f30887c = null;
            SentryAndroidOptions sentryAndroidOptions = this.f30886b;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "PhoneStateBreadcrumbsIntegration removed.", new Object[0]);
            }
        }
    }
}
