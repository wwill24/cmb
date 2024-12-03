package io.sentry;

import io.sentry.protocol.o;
import io.sentry.util.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class i4 implements m0 {

    /* renamed from: a  reason: collision with root package name */
    private u2 f31277a;

    /* renamed from: b  reason: collision with root package name */
    private u2 f31278b;

    /* renamed from: c  reason: collision with root package name */
    private final j4 f31279c;

    /* renamed from: d  reason: collision with root package name */
    private final f4 f31280d;

    /* renamed from: e  reason: collision with root package name */
    private Throwable f31281e;

    /* renamed from: f  reason: collision with root package name */
    private final g0 f31282f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f31283g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    private final m4 f31284h;

    /* renamed from: i  reason: collision with root package name */
    private k4 f31285i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, Object> f31286j = new ConcurrentHashMap();

    i4(o oVar, l4 l4Var, f4 f4Var, String str, g0 g0Var, u2 u2Var, m4 m4Var, k4 k4Var) {
        this.f31279c = new j4(oVar, new l4(), str, l4Var, f4Var.B());
        this.f31280d = (f4) l.c(f4Var, "transaction is required");
        this.f31282f = (g0) l.c(g0Var, "hub is required");
        this.f31284h = m4Var;
        this.f31285i = k4Var;
        if (u2Var != null) {
            this.f31277a = u2Var;
        } else {
            this.f31277a = g0Var.getOptions().getDateProvider().a();
        }
    }

    private void C(u2 u2Var) {
        this.f31277a = u2Var;
    }

    private List<i4> q() {
        ArrayList arrayList = new ArrayList();
        for (i4 next : this.f31280d.C()) {
            if (next.t() != null && next.t().equals(v())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void A(k4 k4Var) {
        this.f31285i = k4Var;
    }

    public m0 B(String str, String str2, u2 u2Var, Instrumenter instrumenter, m4 m4Var) {
        if (this.f31283g.get()) {
            return o1.p();
        }
        return this.f31280d.K(this.f31279c.g(), str, str2, u2Var, instrumenter, m4Var);
    }

    public boolean a() {
        return this.f31283g.get();
    }

    public void b() {
        h(this.f31279c.h());
    }

    public void c(String str) {
        if (!this.f31283g.get()) {
            this.f31279c.k(str);
        }
    }

    public boolean g(u2 u2Var) {
        if (this.f31278b == null) {
            return false;
        }
        this.f31278b = u2Var;
        return true;
    }

    public String getDescription() {
        return this.f31279c.a();
    }

    public u2 getStartDate() {
        return this.f31277a;
    }

    public SpanStatus getStatus() {
        return this.f31279c.h();
    }

    public void h(SpanStatus spanStatus) {
        o(spanStatus, this.f31282f.getOptions().getDateProvider().a());
    }

    public void j(String str, Number number, MeasurementUnit measurementUnit) {
        this.f31280d.j(str, number, measurementUnit);
    }

    public j4 m() {
        return this.f31279c;
    }

    public u2 n() {
        return this.f31278b;
    }

    public void o(SpanStatus spanStatus, u2 u2Var) {
        List<i4> list;
        u2 u2Var2;
        if (this.f31283g.compareAndSet(false, true)) {
            this.f31279c.m(spanStatus);
            if (u2Var == null) {
                u2Var = this.f31282f.getOptions().getDateProvider().a();
            }
            this.f31278b = u2Var;
            if (this.f31284h.c() || this.f31284h.b()) {
                if (this.f31280d.A().v().equals(v())) {
                    list = this.f31280d.x();
                } else {
                    list = q();
                }
                u2 u2Var3 = null;
                u2 u2Var4 = null;
                for (i4 next : list) {
                    if (u2Var3 == null || next.getStartDate().d(u2Var3)) {
                        u2Var3 = next.getStartDate();
                    }
                    if (u2Var4 == null || (next.n() != null && next.n().c(u2Var4))) {
                        u2Var4 = next.n();
                    }
                }
                if (this.f31284h.c() && u2Var3 != null && this.f31277a.d(u2Var3)) {
                    C(u2Var3);
                }
                if (this.f31284h.b() && u2Var4 != null && ((u2Var2 = this.f31278b) == null || u2Var2.c(u2Var4))) {
                    g(u2Var4);
                }
            }
            Throwable th2 = this.f31281e;
            if (th2 != null) {
                this.f31282f.v(th2, this, this.f31280d.getName());
            }
            k4 k4Var = this.f31285i;
            if (k4Var != null) {
                k4Var.a(this);
            }
        }
    }

    public Map<String, Object> p() {
        return this.f31286j;
    }

    public String r() {
        return this.f31279c.b();
    }

    /* access modifiers changed from: package-private */
    public m4 s() {
        return this.f31284h;
    }

    public l4 t() {
        return this.f31279c.c();
    }

    public r4 u() {
        return this.f31279c.f();
    }

    public l4 v() {
        return this.f31279c.g();
    }

    public Map<String, String> w() {
        return this.f31279c.i();
    }

    public o x() {
        return this.f31279c.j();
    }

    public Boolean y() {
        return this.f31279c.d();
    }

    public Boolean z() {
        return this.f31279c.e();
    }

    public i4(s4 s4Var, f4 f4Var, g0 g0Var, u2 u2Var, m4 m4Var) {
        this.f31279c = (j4) l.c(s4Var, "context is required");
        this.f31280d = (f4) l.c(f4Var, "sentryTracer is required");
        this.f31282f = (g0) l.c(g0Var, "hub is required");
        this.f31285i = null;
        if (u2Var != null) {
            this.f31277a = u2Var;
        } else {
            this.f31277a = g0Var.getOptions().getDateProvider().a();
        }
        this.f31284h = m4Var;
    }
}
