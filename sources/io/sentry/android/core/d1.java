package io.sentry.android.core;

import android.content.Context;
import android.os.SystemClock;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.c;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.n2;
import io.sentry.t1;
import io.sentry.u2;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public final class d1 {

    /* renamed from: a  reason: collision with root package name */
    private static final u2 f30960a = r.a();

    /* renamed from: b  reason: collision with root package name */
    private static final long f30961b = SystemClock.uptimeMillis();

    private static void c(SentryOptions sentryOptions, boolean z10, boolean z11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Integration next : sentryOptions.getIntegrations()) {
            if (z10 && (next instanceof FragmentLifecycleIntegration)) {
                arrayList2.add(next);
            }
            if (z11 && (next instanceof SentryTimberIntegration)) {
                arrayList.add(next);
            }
        }
        if (arrayList2.size() > 1) {
            for (int i10 = 1; i10 < arrayList2.size(); i10++) {
                sentryOptions.getIntegrations().remove((Integration) arrayList2.get(i10));
            }
        }
        if (arrayList.size() > 1) {
            for (int i11 = 1; i11 < arrayList.size(); i11++) {
                sentryOptions.getIntegrations().remove((Integration) arrayList.get(i11));
            }
        }
    }

    public static void d(Context context, h0 h0Var) {
        e(context, h0Var, new b1());
    }

    public static synchronized void e(Context context, h0 h0Var, n2.a<SentryAndroidOptions> aVar) {
        synchronized (d1.class) {
            g0.e().i(f30961b, f30960a);
            try {
                n2.l(t1.a(SentryAndroidOptions.class), new c1(h0Var, context, aVar), true);
                g0 k10 = n2.k();
                if (k10.getOptions().isEnableAutoSessionTracking() && j0.f(context)) {
                    k10.q(c.a("session.start"));
                    k10.C();
                }
            } catch (IllegalAccessException e10) {
                h0Var.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e10);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e10);
            } catch (InstantiationException e11) {
                h0Var.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e11);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e11);
            } catch (NoSuchMethodException e12) {
                h0Var.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e12);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e12);
            } catch (InvocationTargetException e13) {
                h0Var.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e13);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e13);
            }
        }
    }

    public static void f(Context context, n2.a<SentryAndroidOptions> aVar) {
        e(context, new s(), aVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g(SentryAndroidOptions sentryAndroidOptions) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h(h0 h0Var, Context context, n2.a aVar, SentryAndroidOptions sentryAndroidOptions) {
        boolean z10;
        t0 t0Var = new t0();
        boolean b10 = t0Var.b("timber.log.Timber", sentryAndroidOptions);
        boolean z11 = true;
        if (!t0Var.b("androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks", sentryAndroidOptions) || !t0Var.b("io.sentry.android.fragment.FragmentLifecycleIntegration", sentryAndroidOptions)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!b10 || !t0Var.b("io.sentry.android.timber.SentryTimberIntegration", sentryAndroidOptions)) {
            z11 = false;
        }
        i0 i0Var = new i0(h0Var);
        t0 t0Var2 = new t0();
        w.k(sentryAndroidOptions, context, h0Var, i0Var);
        aVar.a(sentryAndroidOptions);
        w.f(sentryAndroidOptions, context, i0Var, t0Var2, z10, z11);
        c(sentryAndroidOptions, z10, z11);
    }
}
