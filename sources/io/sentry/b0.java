package io.sentry;

import io.sentry.clientreport.DiscardReason;
import io.sentry.e2;
import io.sentry.hints.k;
import io.sentry.n4;
import io.sentry.protocol.o;
import io.sentry.protocol.v;
import io.sentry.protocol.x;
import io.sentry.util.c;
import io.sentry.util.i;
import io.sentry.util.l;
import io.sentry.util.m;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.jetbrains.annotations.ApiStatus;

public final class b0 implements g0 {

    /* renamed from: a  reason: collision with root package name */
    private volatile o f31133a;

    /* renamed from: b  reason: collision with root package name */
    private final SentryOptions f31134b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f31135c;

    /* renamed from: d  reason: collision with root package name */
    private final n4 f31136d;

    /* renamed from: e  reason: collision with root package name */
    private final q4 f31137e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Throwable, m<WeakReference<m0>, String>> f31138f;

    /* renamed from: g  reason: collision with root package name */
    private final v4 f31139g;

    public b0(SentryOptions sentryOptions) {
        this(sentryOptions, g(sentryOptions));
    }

    private void c(p3 p3Var) {
        m mVar;
        m0 m0Var;
        if (this.f31134b.isTracingEnabled() && p3Var.O() != null && (mVar = this.f31138f.get(c.a(p3Var.O()))) != null) {
            WeakReference weakReference = (WeakReference) mVar.a();
            if (!(p3Var.C().e() != null || weakReference == null || (m0Var = (m0) weakReference.get()) == null)) {
                p3Var.C().n(m0Var.m());
            }
            String str = (String) mVar.b();
            if (p3Var.s0() == null && str != null) {
                p3Var.A0(str);
            }
        }
    }

    private e2 d(e2 e2Var, f2 f2Var) {
        if (f2Var != null) {
            try {
                e2 e2Var2 = new e2(e2Var);
                f2Var.a(e2Var2);
                return e2Var2;
            } catch (Throwable th2) {
                this.f31134b.getLogger().b(SentryLevel.ERROR, "Error in the 'ScopeCallback' callback.", th2);
            }
        }
        return e2Var;
    }

    private o e(p3 p3Var, w wVar, f2 f2Var) {
        o oVar = o.f31517b;
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
            return oVar;
        } else if (p3Var == null) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "captureEvent called with null parameter.", new Object[0]);
            return oVar;
        } else {
            try {
                c(p3Var);
                n4.a a10 = this.f31136d.a();
                oVar = a10.a().a(p3Var, d(a10.c(), f2Var), wVar);
                this.f31133a = oVar;
                return oVar;
            } catch (Throwable th2) {
                h0 logger = this.f31134b.getLogger();
                SentryLevel sentryLevel = SentryLevel.ERROR;
                logger.b(sentryLevel, "Error while capturing event with id: " + p3Var.G(), th2);
                return oVar;
            }
        }
    }

    private o f(Throwable th2, w wVar, f2 f2Var) {
        o oVar = o.f31517b;
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureException' call is a no-op.", new Object[0]);
        } else if (th2 == null) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "captureException called with null parameter.", new Object[0]);
        } else {
            try {
                n4.a a10 = this.f31136d.a();
                p3 p3Var = new p3(th2);
                c(p3Var);
                oVar = a10.a().a(p3Var, d(a10.c(), f2Var), wVar);
            } catch (Throwable th3) {
                h0 logger = this.f31134b.getLogger();
                SentryLevel sentryLevel = SentryLevel.ERROR;
                logger.b(sentryLevel, "Error while capturing exception: " + th2.getMessage(), th3);
            }
        }
        this.f31133a = oVar;
        return oVar;
    }

    private static n4.a g(SentryOptions sentryOptions) {
        j(sentryOptions);
        return new n4.a(sentryOptions, new s2(sentryOptions), new e2(sentryOptions));
    }

    private n0 h(s4 s4Var, u4 u4Var) {
        n0 n0Var;
        l.c(s4Var, "transactionContext is required");
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            n0Var = p1.p();
        } else if (!this.f31134b.getInstrumenter().equals(s4Var.p())) {
            this.f31134b.getLogger().c(SentryLevel.DEBUG, "Returning no-op for instrumenter %s as the SDK has been configured to use instrumenter %s", s4Var.p(), this.f31134b.getInstrumenter());
            n0Var = p1.p();
        } else if (!this.f31134b.isTracingEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.INFO, "Tracing is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            n0Var = p1.p();
        } else {
            u4Var.e();
            r4 a10 = this.f31137e.a(new d2(s4Var, (f) null));
            s4Var.l(a10);
            f4 f4Var = new f4(s4Var, this, u4Var, (t4) null, this.f31139g);
            if (a10.c().booleanValue() && a10.a().booleanValue()) {
                this.f31134b.getTransactionProfiler().a(f4Var);
            }
            n0Var = f4Var;
        }
        if (u4Var.h()) {
            u(new a0(n0Var));
        }
        return n0Var;
    }

    private static void j(SentryOptions sentryOptions) {
        l.c(sentryOptions, "SentryOptions is required.");
        if (sentryOptions.getDsn() == null || sentryOptions.getDsn().isEmpty()) {
            throw new IllegalArgumentException("Hub requires a DSN to be instantiated. Considering using the NoOpHub if no DSN is available.");
        }
    }

    public o A(Throwable th2, w wVar) {
        return f(th2, wVar, (f2) null);
    }

    @ApiStatus.Internal
    public o B(v vVar, p4 p4Var, w wVar, z1 z1Var) {
        l.c(vVar, "transaction is required");
        o oVar = o.f31517b;
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return oVar;
        } else if (!vVar.p0()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Transaction: %s is not finished and this 'captureTransaction' call is a no-op.", vVar.G());
            return oVar;
        } else if (!Boolean.TRUE.equals(Boolean.valueOf(vVar.q0()))) {
            this.f31134b.getLogger().c(SentryLevel.DEBUG, "Transaction %s was dropped due to sampling decision.", vVar.G());
            this.f31134b.getClientReportRecorder().a(DiscardReason.SAMPLE_RATE, DataCategory.Transaction);
            return oVar;
        } else {
            try {
                n4.a a10 = this.f31136d.a();
                return a10.a().c(vVar, p4Var, a10.c(), wVar, z1Var);
            } catch (Throwable th2) {
                h0 logger = this.f31134b.getLogger();
                SentryLevel sentryLevel = SentryLevel.ERROR;
                logger.b(sentryLevel, "Error while capturing transaction with id: " + vVar.G(), th2);
                return oVar;
            }
        }
    }

    public void C() {
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
            return;
        }
        n4.a a10 = this.f31136d.a();
        e2.c w10 = a10.c().w();
        if (w10 != null) {
            if (w10.b() != null) {
                a10.a().b(w10.b(), i.e(new io.sentry.hints.i()));
            }
            a10.a().b(w10.a(), i.e(new k()));
            return;
        }
        this.f31134b.getLogger().c(SentryLevel.WARNING, "Session could not be started.", new Object[0]);
    }

    public void a(String str, String str2) {
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'setExtra' call is a no-op.", new Object[0]);
        } else if (str == null || str2 == null) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "setExtra called with null parameter.", new Object[0]);
        } else {
            this.f31136d.a().c().t(str, str2);
        }
    }

    public void close() {
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
            return;
        }
        try {
            for (Integration next : this.f31134b.getIntegrations()) {
                if (next instanceof Closeable) {
                    ((Closeable) next).close();
                }
            }
            this.f31134b.getExecutorService().a(this.f31134b.getShutdownTimeoutMillis());
            this.f31136d.a().a().close();
        } catch (Throwable th2) {
            this.f31134b.getLogger().b(SentryLevel.ERROR, "Error while closing the Hub.", th2);
        }
        this.f31135c = false;
    }

    public SentryOptions getOptions() {
        return this.f31136d.a().b();
    }

    public boolean isEnabled() {
        return this.f31135c;
    }

    public void o(long j10) {
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
            return;
        }
        try {
            this.f31136d.a().a().o(j10);
        } catch (Throwable th2) {
            this.f31134b.getLogger().b(SentryLevel.ERROR, "Error in the 'client.flush'.", th2);
        }
    }

    public void p(x xVar) {
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'setUser' call is a no-op.", new Object[0]);
        } else {
            this.f31136d.a().c().v(xVar);
        }
    }

    @ApiStatus.Internal
    public o r(w2 w2Var, w wVar) {
        l.c(w2Var, "SentryEnvelope is required.");
        o oVar = o.f31517b;
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
            return oVar;
        }
        try {
            o r10 = this.f31136d.a().a().r(w2Var, wVar);
            if (r10 != null) {
                return r10;
            }
            return oVar;
        } catch (Throwable th2) {
            this.f31134b.getLogger().b(SentryLevel.ERROR, "Error while capturing envelope.", th2);
            return oVar;
        }
    }

    public void t(d dVar, w wVar) {
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        } else if (dVar == null) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "addBreadcrumb called with null parameter.", new Object[0]);
        } else {
            this.f31136d.a().c().a(dVar, wVar);
        }
    }

    public void u(f2 f2Var) {
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            f2Var.a(this.f31136d.a().c());
        } catch (Throwable th2) {
            this.f31134b.getLogger().b(SentryLevel.ERROR, "Error in the 'configureScope' callback.", th2);
        }
    }

    @ApiStatus.Internal
    public void v(Throwable th2, m0 m0Var, String str) {
        l.c(th2, "throwable is required");
        l.c(m0Var, "span is required");
        l.c(str, "transactionName is required");
        Throwable a10 = c.a(th2);
        if (!this.f31138f.containsKey(a10)) {
            this.f31138f.put(a10, new m(new WeakReference(m0Var), str));
        }
    }

    public void w() {
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
            return;
        }
        n4.a a10 = this.f31136d.a();
        Session d10 = a10.c().d();
        if (d10 != null) {
            a10.a().b(d10, i.e(new io.sentry.hints.i()));
        }
    }

    public o x(p3 p3Var, w wVar) {
        return e(p3Var, wVar, (f2) null);
    }

    @ApiStatus.Internal
    public n0 y(s4 s4Var, u4 u4Var) {
        return h(s4Var, u4Var);
    }

    private b0(SentryOptions sentryOptions, n4 n4Var) {
        this.f31138f = Collections.synchronizedMap(new WeakHashMap());
        j(sentryOptions);
        this.f31134b = sentryOptions;
        this.f31137e = new q4(sentryOptions);
        this.f31136d = n4Var;
        this.f31133a = o.f31517b;
        this.f31139g = sentryOptions.getTransactionPerformanceCollector();
        this.f31135c = true;
    }

    public g0 clone() {
        if (!isEnabled()) {
            this.f31134b.getLogger().c(SentryLevel.WARNING, "Disabled Hub cloned.", new Object[0]);
        }
        return new b0(this.f31134b, new n4(this.f31136d));
    }

    private b0(SentryOptions sentryOptions, n4.a aVar) {
        this(sentryOptions, new n4(sentryOptions.getLogger(), aVar));
    }
}
