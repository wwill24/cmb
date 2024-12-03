package io.sentry.android.core;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.l;
import com.leanplum.internal.Constants;
import io.sentry.SentryLevel;
import io.sentry.Session;
import io.sentry.android.core.internal.util.c;
import io.sentry.d;
import io.sentry.e2;
import io.sentry.g0;
import io.sentry.transport.m;
import io.sentry.transport.o;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

final class LifecycleWatcher implements DefaultLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f30860a;

    /* renamed from: b  reason: collision with root package name */
    private final long f30861b;

    /* renamed from: c  reason: collision with root package name */
    private TimerTask f30862c;

    /* renamed from: d  reason: collision with root package name */
    private final Timer f30863d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f30864e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final g0 f30865f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f30866g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f30867h;

    /* renamed from: j  reason: collision with root package name */
    private final o f30868j;

    class a extends TimerTask {
        a() {
        }

        public void run() {
            LifecycleWatcher.this.f("end");
            LifecycleWatcher.this.f30865f.w();
        }
    }

    LifecycleWatcher(g0 g0Var, long j10, boolean z10, boolean z11) {
        this(g0Var, j10, z10, z11, m.a());
    }

    private void d(String str) {
        if (this.f30867h) {
            d dVar = new d();
            dVar.p("navigation");
            dVar.m("state", str);
            dVar.l("app.lifecycle");
            dVar.n(SentryLevel.INFO);
            this.f30865f.q(dVar);
        }
    }

    /* access modifiers changed from: private */
    public void f(String str) {
        this.f30865f.q(c.a(str));
    }

    private void g() {
        synchronized (this.f30864e) {
            TimerTask timerTask = this.f30862c;
            if (timerTask != null) {
                timerTask.cancel();
                this.f30862c = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(e2 e2Var) {
        Session n10;
        if (this.f30860a.get() == 0 && (n10 = e2Var.n()) != null && n10.j() != null) {
            this.f30860a.set(n10.j().getTime());
        }
    }

    private void j() {
        synchronized (this.f30864e) {
            g();
            if (this.f30863d != null) {
                a aVar = new a();
                this.f30862c = aVar;
                this.f30863d.schedule(aVar, this.f30861b);
            }
        }
    }

    private void k() {
        if (this.f30866g) {
            g();
            long currentTimeMillis = this.f30868j.getCurrentTimeMillis();
            this.f30865f.u(new s0(this));
            long j10 = this.f30860a.get();
            if (j10 == 0 || j10 + this.f30861b <= currentTimeMillis) {
                f("start");
                this.f30865f.C();
            }
            this.f30860a.set(currentTimeMillis);
        }
    }

    public void onStart(l lVar) {
        k();
        d("foreground");
        h0.a().c(false);
    }

    public void onStop(l lVar) {
        if (this.f30866g) {
            this.f30860a.set(this.f30868j.getCurrentTimeMillis());
            j();
        }
        h0.a().c(true);
        d(Constants.Params.BACKGROUND);
    }

    LifecycleWatcher(g0 g0Var, long j10, boolean z10, boolean z11, o oVar) {
        this.f30860a = new AtomicLong(0);
        this.f30864e = new Object();
        this.f30861b = j10;
        this.f30866g = z10;
        this.f30867h = z11;
        this.f30865f = g0Var;
        this.f30868j = oVar;
        if (z10) {
            this.f30863d = new Timer(true);
        } else {
            this.f30863d = null;
        }
    }
}
