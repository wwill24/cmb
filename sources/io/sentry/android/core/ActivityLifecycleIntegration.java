package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import io.sentry.Instrumenter;
import io.sentry.Integration;
import io.sentry.MeasurementUnit;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SpanStatus;
import io.sentry.android.core.internal.util.h;
import io.sentry.d;
import io.sentry.e2;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.m0;
import io.sentry.n0;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.s4;
import io.sentry.u2;
import io.sentry.u4;
import io.sentry.util.l;
import io.sentry.v;
import io.sentry.w;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.VisibleForTesting;
import org.jivesoftware.smack.sm.packet.StreamManagement;

public final class ActivityLifecycleIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final Application f30828a;

    /* renamed from: b  reason: collision with root package name */
    private final i0 f30829b;

    /* renamed from: c  reason: collision with root package name */
    private g0 f30830c;

    /* renamed from: d  reason: collision with root package name */
    private SentryAndroidOptions f30831d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30832e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f30833f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f30834g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f30835h = false;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f30836j;

    /* renamed from: k  reason: collision with root package name */
    private v f30837k = null;

    /* renamed from: l  reason: collision with root package name */
    private m0 f30838l;

    /* renamed from: m  reason: collision with root package name */
    private final WeakHashMap<Activity, m0> f30839m = new WeakHashMap<>();

    /* renamed from: n  reason: collision with root package name */
    private u2 f30840n = r.a();

    /* renamed from: p  reason: collision with root package name */
    private final Handler f30841p = new Handler(Looper.getMainLooper());

    /* renamed from: q  reason: collision with root package name */
    private m0 f30842q = null;

    /* renamed from: t  reason: collision with root package name */
    private Future<?> f30843t = null;

    /* renamed from: w  reason: collision with root package name */
    private final WeakHashMap<Activity, n0> f30844w = new WeakHashMap<>();

    /* renamed from: x  reason: collision with root package name */
    private final g f30845x;

    public ActivityLifecycleIntegration(Application application, i0 i0Var, g gVar) {
        Application application2 = (Application) l.c(application, "Application is required");
        this.f30828a = application2;
        this.f30829b = (i0) l.c(i0Var, "BuildInfoProvider is required");
        this.f30845x = (g) l.c(gVar, "ActivityFramesTracker is required");
        if (i0Var.d() >= 29) {
            this.f30834g = true;
        }
        this.f30836j = j0.f(application2);
    }

    private void A0(Bundle bundle) {
        boolean z10;
        if (!this.f30835h) {
            g0 e10 = g0.e();
            if (bundle == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            e10.j(z10);
        }
    }

    private void B0(Activity activity) {
        u2 u2Var;
        u2 u2Var2;
        WeakReference weakReference = new WeakReference(activity);
        if (this.f30832e && !f0(activity) && this.f30830c != null) {
            E0();
            String N = N(activity);
            if (this.f30836j) {
                u2Var = g0.e().d();
            } else {
                u2Var = null;
            }
            Boolean f10 = g0.e().f();
            u4 u4Var = new u4();
            if (this.f30831d.isEnableActivityLifecycleTracingAutoFinish()) {
                u4Var.j(this.f30831d.getIdleTimeout());
                u4Var.d(true);
            }
            u4Var.m(true);
            u4Var.l(new m(this, weakReference, N));
            if (this.f30835h || u2Var == null || f10 == null) {
                u2Var2 = this.f30840n;
            } else {
                u2Var2 = u2Var;
            }
            u4Var.k(u2Var2);
            n0 y10 = this.f30830c.y(new s4(N, TransactionNameSource.COMPONENT, "ui.load"), u4Var);
            if (!(this.f30835h || u2Var == null || f10 == null)) {
                this.f30838l = y10.i(P(f10.booleanValue()), O(f10.booleanValue()), u2Var, Instrumenter.SENTRY);
                C();
            }
            WeakHashMap<Activity, m0> weakHashMap = this.f30839m;
            String c02 = c0(N);
            Instrumenter instrumenter = Instrumenter.SENTRY;
            weakHashMap.put(activity, y10.i("ui.load.initial_display", c02, u2Var2, instrumenter));
            if (!(!this.f30833f || this.f30837k == null || this.f30831d == null)) {
                this.f30842q = y10.i("ui.load.full_display", Y(N), u2Var2, instrumenter);
                this.f30843t = this.f30831d.getExecutorService().schedule(new n(this, activity), 30000);
            }
            this.f30830c.u(new o(this, y10));
            this.f30844w.put(activity, y10);
        }
    }

    private void C() {
        u2 a10 = g0.e().a();
        if (this.f30832e && a10 != null) {
            G(this.f30838l, a10);
        }
    }

    private void E(m0 m0Var) {
        u2 u2Var;
        m0 m0Var2 = this.f30842q;
        if (m0Var2 != null) {
            m0Var2.c(S(m0Var2));
            if (m0Var != null) {
                u2Var = m0Var.n();
            } else {
                u2Var = null;
            }
            if (u2Var == null) {
                u2Var = this.f30842q.getStartDate();
            }
            I(this.f30842q, u2Var, SpanStatus.DEADLINE_EXCEEDED);
        }
    }

    private void E0() {
        for (Map.Entry next : this.f30844w.entrySet()) {
            L((n0) next.getValue(), this.f30839m.get(next.getKey()), true);
        }
    }

    private void F(m0 m0Var) {
        if (m0Var != null && !m0Var.a()) {
            m0Var.b();
        }
    }

    private void G(m0 m0Var, u2 u2Var) {
        I(m0Var, u2Var, (SpanStatus) null);
    }

    private void H0(Activity activity, boolean z10) {
        if (this.f30832e && z10) {
            L(this.f30844w.get(activity), (m0) null, false);
        }
    }

    private void I(m0 m0Var, u2 u2Var, SpanStatus spanStatus) {
        if (m0Var != null && !m0Var.a()) {
            if (spanStatus == null) {
                if (m0Var.getStatus() != null) {
                    spanStatus = m0Var.getStatus();
                } else {
                    spanStatus = SpanStatus.OK;
                }
            }
            m0Var.o(spanStatus, u2Var);
        }
    }

    private void J(m0 m0Var, SpanStatus spanStatus) {
        if (m0Var != null && !m0Var.a()) {
            m0Var.h(spanStatus);
        }
    }

    private void L(n0 n0Var, m0 m0Var, boolean z10) {
        if (n0Var != null && !n0Var.a()) {
            J(m0Var, SpanStatus.DEADLINE_EXCEEDED);
            if (z10) {
                E(m0Var);
            }
            x();
            SpanStatus status = n0Var.getStatus();
            if (status == null) {
                status = SpanStatus.OK;
            }
            n0Var.h(status);
            g0 g0Var = this.f30830c;
            if (g0Var != null) {
                g0Var.u(new j(this, n0Var));
            }
        }
    }

    private String N(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    private String O(boolean z10) {
        return z10 ? "Cold Start" : "Warm Start";
    }

    private String P(boolean z10) {
        return z10 ? "app.start.cold" : "app.start.warm";
    }

    private String S(m0 m0Var) {
        String description = m0Var.getDescription();
        if (description != null && description.endsWith(" - Deadline Exceeded")) {
            return description;
        }
        return m0Var.getDescription() + " - Deadline Exceeded";
    }

    private String Y(String str) {
        return str + " full display";
    }

    private String c0(String str) {
        return str + " initial display";
    }

    private boolean e0(SentryAndroidOptions sentryAndroidOptions) {
        return sentryAndroidOptions.isTracingEnabled() && sentryAndroidOptions.isEnableAutoActivityLifecycleTracing();
    }

    private boolean f0(Activity activity) {
        return this.f30844w.containsKey(activity);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(e2 e2Var, n0 n0Var, n0 n0Var2) {
        if (n0Var2 == null) {
            e2Var.u(n0Var);
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.f30831d;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", n0Var.getName());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void m0(n0 n0Var, e2 e2Var, n0 n0Var2) {
        if (n0Var2 == n0Var) {
            e2Var.b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(WeakReference weakReference, String str, n0 n0Var) {
        Activity activity = (Activity) weakReference.get();
        if (activity != null) {
            this.f30845x.n(activity, n0Var.d());
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.f30831d;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.WARNING, "Unable to track activity frames as the Activity %s has been destroyed.", str);
        }
    }

    private void u(Activity activity, String str) {
        SentryAndroidOptions sentryAndroidOptions = this.f30831d;
        if (sentryAndroidOptions != null && this.f30830c != null && sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs()) {
            d dVar = new d();
            dVar.p("navigation");
            dVar.m("state", str);
            dVar.m("screen", N(activity));
            dVar.l("ui.lifecycle");
            dVar.n(SentryLevel.INFO);
            w wVar = new w();
            wVar.i("android:activity", activity);
            this.f30830c.t(dVar, wVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u0(Activity activity) {
        E(this.f30839m.get(activity));
    }

    private void x() {
        Future<?> future = this.f30843t;
        if (future != null) {
            future.cancel(false);
            this.f30843t = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x0 */
    public void s0(m0 m0Var) {
        SentryAndroidOptions sentryAndroidOptions = this.f30831d;
        if (sentryAndroidOptions == null || m0Var == null) {
            F(m0Var);
            return;
        }
        u2 a10 = sentryAndroidOptions.getDateProvider().a();
        long millis = TimeUnit.NANOSECONDS.toMillis(a10.b(m0Var.getStartDate()));
        Long valueOf = Long.valueOf(millis);
        MeasurementUnit.Duration duration = MeasurementUnit.Duration.MILLISECOND;
        m0Var.j("time_to_initial_display", valueOf, duration);
        m0 m0Var2 = this.f30842q;
        if (m0Var2 != null && m0Var2.a()) {
            this.f30842q.g(a10);
            m0Var.j("time_to_full_display", Long.valueOf(millis), duration);
        }
        G(m0Var, a10);
    }

    public void a(g0 g0Var, SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions;
        if (sentryOptions instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions) sentryOptions;
        } else {
            sentryAndroidOptions = null;
        }
        this.f30831d = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f30830c = (g0) l.c(g0Var, "Hub is required");
        h0 logger = this.f30831d.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "ActivityLifecycleIntegration enabled: %s", Boolean.valueOf(this.f30831d.isEnableActivityLifecycleBreadcrumbs()));
        this.f30832e = e0(this.f30831d);
        this.f30837k = this.f30831d.getFullyDisplayedReporter();
        this.f30833f = this.f30831d.isEnableTimeToFullDisplayTracing();
        if (this.f30831d.isEnableActivityLifecycleBreadcrumbs() || this.f30832e) {
            this.f30828a.registerActivityLifecycleCallbacks(this);
            this.f30831d.getLogger().c(sentryLevel, "ActivityLifecycleIntegration installed.", new Object[0]);
            c();
        }
    }

    public void close() throws IOException {
        this.f30828a.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.f30831d;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "ActivityLifecycleIntegration removed.", new Object[0]);
        }
        this.f30845x.p();
    }

    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        A0(bundle);
        u(activity, "created");
        B0(activity);
        this.f30835h = true;
        v vVar = this.f30837k;
        if (vVar != null) {
            vVar.b(new k(this));
        }
    }

    public synchronized void onActivityDestroyed(Activity activity) {
        u(activity, "destroyed");
        J(this.f30838l, SpanStatus.CANCELLED);
        m0 m0Var = this.f30839m.get(activity);
        J(m0Var, SpanStatus.DEADLINE_EXCEEDED);
        E(m0Var);
        x();
        H0(activity, true);
        this.f30838l = null;
        this.f30839m.remove(activity);
        this.f30842q = null;
        if (this.f30832e) {
            this.f30844w.remove(activity);
        }
    }

    public synchronized void onActivityPaused(Activity activity) {
        if (!this.f30834g) {
            g0 g0Var = this.f30830c;
            if (g0Var == null) {
                this.f30840n = r.a();
            } else {
                this.f30840n = g0Var.getOptions().getDateProvider().a();
            }
        }
        u(activity, "paused");
    }

    public void onActivityPostResumed(@NonNull Activity activity) {
    }

    public void onActivityPrePaused(@NonNull Activity activity) {
        if (this.f30834g) {
            g0 g0Var = this.f30830c;
            if (g0Var == null) {
                this.f30840n = r.a();
            } else {
                this.f30840n = g0Var.getOptions().getDateProvider().a();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public synchronized void onActivityResumed(Activity activity) {
        u2 d10 = g0.e().d();
        u2 a10 = g0.e().a();
        if (d10 != null && a10 == null) {
            g0.e().g();
        }
        C();
        m0 m0Var = this.f30839m.get(activity);
        View findViewById = activity.findViewById(16908290);
        if (this.f30829b.d() < 16 || findViewById == null) {
            this.f30841p.post(new i(this, m0Var));
        } else {
            h.e(findViewById, new h(this, m0Var), this.f30829b);
        }
        u(activity, StreamManagement.Resumed.ELEMENT);
    }

    public synchronized void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        u(activity, "saveInstanceState");
    }

    public synchronized void onActivityStarted(Activity activity) {
        this.f30845x.e(activity);
        u(activity, "started");
    }

    public synchronized void onActivityStopped(Activity activity) {
        u(activity, "stopped");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: v */
    public void v0(e2 e2Var, n0 n0Var) {
        e2Var.y(new p(this, e2Var, n0Var));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: y */
    public void q0(e2 e2Var, n0 n0Var) {
        e2Var.y(new l(n0Var, e2Var));
    }
}
