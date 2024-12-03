package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.protocol.f;
import io.sentry.protocol.o;
import io.sentry.protocol.v;
import io.sentry.protocol.x;
import io.sentry.util.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class f4 implements n0 {

    /* renamed from: a  reason: collision with root package name */
    private final o f31230a = new o();

    /* renamed from: b  reason: collision with root package name */
    private final i4 f31231b;

    /* renamed from: c  reason: collision with root package name */
    private final List<i4> f31232c = new CopyOnWriteArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final g0 f31233d;

    /* renamed from: e  reason: collision with root package name */
    private String f31234e;

    /* renamed from: f  reason: collision with root package name */
    private b f31235f = b.f31249c;

    /* renamed from: g  reason: collision with root package name */
    private final t4 f31236g;

    /* renamed from: h  reason: collision with root package name */
    private volatile TimerTask f31237h;

    /* renamed from: i  reason: collision with root package name */
    private volatile Timer f31238i = null;

    /* renamed from: j  reason: collision with root package name */
    private final Object f31239j = new Object();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final AtomicBoolean f31240k = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    private final c f31241l;

    /* renamed from: m  reason: collision with root package name */
    private TransactionNameSource f31242m;

    /* renamed from: n  reason: collision with root package name */
    private final Map<String, f> f31243n;

    /* renamed from: o  reason: collision with root package name */
    private final Instrumenter f31244o;

    /* renamed from: p  reason: collision with root package name */
    private final Contexts f31245p = new Contexts();

    /* renamed from: q  reason: collision with root package name */
    private final v4 f31246q;

    /* renamed from: r  reason: collision with root package name */
    private final u4 f31247r;

    class a extends TimerTask {
        a() {
        }

        public void run() {
            SpanStatus status = f4.this.getStatus();
            f4 f4Var = f4.this;
            if (status == null) {
                status = SpanStatus.OK;
            }
            f4Var.h(status);
            f4.this.f31240k.set(false);
        }
    }

    private static final class b {

        /* renamed from: c  reason: collision with root package name */
        static final b f31249c = d();
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final boolean f31250a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final SpanStatus f31251b;

        private b(boolean z10, SpanStatus spanStatus) {
            this.f31250a = z10;
            this.f31251b = spanStatus;
        }

        static b c(SpanStatus spanStatus) {
            return new b(true, spanStatus);
        }

        private static b d() {
            return new b(false, (SpanStatus) null);
        }
    }

    f4(s4 s4Var, g0 g0Var, u4 u4Var, t4 t4Var, v4 v4Var) {
        l.c(s4Var, "context is required");
        l.c(g0Var, "hub is required");
        this.f31243n = new ConcurrentHashMap();
        this.f31231b = new i4(s4Var, this, g0Var, u4Var.g(), u4Var);
        this.f31234e = s4Var.q();
        this.f31244o = s4Var.p();
        this.f31233d = g0Var;
        this.f31236g = t4Var;
        this.f31246q = v4Var;
        this.f31242m = s4Var.s();
        this.f31247r = u4Var;
        if (s4Var.o() != null) {
            this.f31241l = s4Var.o();
        } else {
            this.f31241l = new c(g0Var.getOptions().getLogger());
        }
        if (v4Var != null && Boolean.TRUE.equals(E())) {
            v4Var.b(this);
        }
        if (u4Var.f() != null) {
            this.f31238i = new Timer(true);
            l();
        }
    }

    private boolean D() {
        ArrayList<i4> arrayList = new ArrayList<>(this.f31232c);
        if (arrayList.isEmpty()) {
            return true;
        }
        for (i4 a10 : arrayList) {
            if (!a10.a()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(i4 i4Var) {
        b bVar = this.f31235f;
        if (this.f31247r.f() != null) {
            if (!this.f31247r.i() || D()) {
                l();
            }
        } else if (bVar.f31250a) {
            h(bVar.f31251b);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(e2 e2Var, n0 n0Var) {
        if (n0Var == this) {
            e2Var.b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(e2 e2Var) {
        e2Var.y(new e4(this, e2Var));
    }

    private void M() {
        synchronized (this) {
            if (this.f31241l.n()) {
                AtomicReference atomicReference = new AtomicReference();
                this.f31233d.u(new d4(atomicReference));
                this.f31241l.y(this, (x) atomicReference.get(), this.f31233d.getOptions(), B());
                this.f31241l.a();
            }
        }
    }

    private void u() {
        synchronized (this.f31239j) {
            if (this.f31237h != null) {
                this.f31237h.cancel();
                this.f31240k.set(false);
                this.f31237h = null;
            }
        }
    }

    private m0 v(l4 l4Var, String str, String str2, u2 u2Var, Instrumenter instrumenter, m4 m4Var) {
        if (this.f31231b.a()) {
            return o1.p();
        }
        if (!this.f31244o.equals(instrumenter)) {
            return o1.p();
        }
        l.c(l4Var, "parentSpanId is required");
        l.c(str, "operation is required");
        u();
        i4 i4Var = new i4(this.f31231b.x(), l4Var, this, str, this.f31233d, u2Var, m4Var, new b4(this));
        i4Var.c(str2);
        this.f31232c.add(i4Var);
        return i4Var;
    }

    private m0 w(String str, String str2, u2 u2Var, Instrumenter instrumenter, m4 m4Var) {
        if (this.f31231b.a()) {
            return o1.p();
        }
        if (!this.f31244o.equals(instrumenter)) {
            return o1.p();
        }
        if (this.f31232c.size() < this.f31233d.getOptions().getMaxSpans()) {
            return this.f31231b.B(str, str2, u2Var, instrumenter, m4Var);
        }
        this.f31233d.getOptions().getLogger().c(SentryLevel.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
        return o1.p();
    }

    /* access modifiers changed from: package-private */
    public i4 A() {
        return this.f31231b;
    }

    public r4 B() {
        return this.f31231b.u();
    }

    public List<i4> C() {
        return this.f31232c;
    }

    public Boolean E() {
        return this.f31231b.y();
    }

    public Boolean F() {
        return this.f31231b.z();
    }

    /* access modifiers changed from: package-private */
    public m0 K(l4 l4Var, String str, String str2, u2 u2Var, Instrumenter instrumenter, m4 m4Var) {
        return v(l4Var, str, str2, u2Var, instrumenter, m4Var);
    }

    public m0 L(String str, String str2, u2 u2Var, Instrumenter instrumenter, m4 m4Var) {
        return w(str, str2, u2Var, instrumenter, m4Var);
    }

    public boolean a() {
        return this.f31231b.a();
    }

    public void b() {
        h(getStatus());
    }

    public void c(String str) {
        if (!this.f31231b.a()) {
            this.f31231b.c(str);
        }
    }

    public o d() {
        return this.f31230a;
    }

    public TransactionNameSource e() {
        return this.f31242m;
    }

    public p4 f() {
        if (!this.f31233d.getOptions().isTraceSampling()) {
            return null;
        }
        M();
        return this.f31241l.z();
    }

    public boolean g(u2 u2Var) {
        return this.f31231b.g(u2Var);
    }

    public String getDescription() {
        return this.f31231b.getDescription();
    }

    public String getName() {
        return this.f31234e;
    }

    public u2 getStartDate() {
        return this.f31231b.getStartDate();
    }

    public SpanStatus getStatus() {
        return this.f31231b.getStatus();
    }

    public void h(SpanStatus spanStatus) {
        o(spanStatus, (u2) null);
    }

    public m0 i(String str, String str2, u2 u2Var, Instrumenter instrumenter) {
        return L(str, str2, u2Var, instrumenter, new m4());
    }

    public void j(String str, Number number, MeasurementUnit measurementUnit) {
        if (!this.f31231b.a()) {
            this.f31243n.put(str, new f(number, measurementUnit.apiName()));
        }
    }

    public i4 k() {
        ArrayList arrayList = new ArrayList(this.f31232c);
        if (arrayList.isEmpty()) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!((i4) arrayList.get(size)).a()) {
                return (i4) arrayList.get(size);
            }
        }
        return null;
    }

    public void l() {
        synchronized (this.f31239j) {
            u();
            if (this.f31238i != null) {
                this.f31240k.set(true);
                this.f31237h = new a();
                this.f31238i.schedule(this.f31237h, this.f31247r.f().longValue());
            }
        }
    }

    public j4 m() {
        return this.f31231b.m();
    }

    public u2 n() {
        return this.f31231b.n();
    }

    @ApiStatus.Internal
    public void o(SpanStatus spanStatus, u2 u2Var) {
        List<x1> list;
        z1 z1Var;
        SpanStatus spanStatus2;
        u2 n10 = this.f31231b.n();
        if (u2Var == null) {
            u2Var = n10;
        }
        if (u2Var == null) {
            u2Var = this.f31233d.getOptions().getDateProvider().a();
        }
        for (i4 next : this.f31232c) {
            if (next.s().a()) {
                if (spanStatus != null) {
                    spanStatus2 = spanStatus;
                } else {
                    spanStatus2 = m().f31312g;
                }
                next.o(spanStatus2, u2Var);
            }
        }
        this.f31235f = b.c(spanStatus);
        if (this.f31231b.a()) {
            return;
        }
        if (!this.f31247r.i() || D()) {
            v4 v4Var = this.f31246q;
            if (v4Var != null) {
                list = v4Var.a(this);
            } else {
                list = null;
            }
            Boolean bool = Boolean.TRUE;
            if (!bool.equals(F()) || !bool.equals(E())) {
                z1Var = null;
            } else {
                z1Var = this.f31233d.getOptions().getTransactionProfiler().b(this, list);
            }
            if (list != null) {
                list.clear();
            }
            for (i4 next2 : this.f31232c) {
                if (!next2.a()) {
                    next2.A((k4) null);
                    next2.o(SpanStatus.DEADLINE_EXCEEDED, u2Var);
                }
            }
            this.f31231b.o(this.f31235f.f31251b, u2Var);
            this.f31233d.u(new c4(this));
            v vVar = new v(this);
            t4 t4Var = this.f31236g;
            if (t4Var != null) {
                t4Var.a(this);
            }
            if (this.f31238i != null) {
                synchronized (this.f31239j) {
                    if (this.f31238i != null) {
                        this.f31238i.cancel();
                        this.f31238i = null;
                    }
                }
            }
            if (!this.f31232c.isEmpty() || this.f31247r.f() == null) {
                vVar.m0().putAll(this.f31243n);
                this.f31233d.B(vVar, f(), (w) null, z1Var);
                return;
            }
            this.f31233d.getOptions().getLogger().c(SentryLevel.DEBUG, "Dropping idle transaction because it has no child spans", new Object[0]);
        }
    }

    public List<i4> x() {
        return this.f31232c;
    }

    @ApiStatus.Internal
    public Contexts y() {
        return this.f31245p;
    }

    public Map<String, Object> z() {
        return this.f31231b.p();
    }
}
