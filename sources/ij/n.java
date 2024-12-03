package ij;

import am.b;
import am.c;
import am.d;
import am.e;
import am.f;
import am.g;
import am.h;
import am.i;
import am.j;
import am.k;
import am.m;
import am.o;
import am.q;
import am.r;
import am.s;
import am.t;
import am.u;
import am.v;
import am.w;
import am.x;
import androidx.annotation.NonNull;
import ij.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class n implements l {

    /* renamed from: a  reason: collision with root package name */
    private final g f30002a;

    /* renamed from: b  reason: collision with root package name */
    private final q f30003b;

    /* renamed from: c  reason: collision with root package name */
    private final t f30004c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<? extends r>, l.c<? extends r>> f30005d;

    /* renamed from: e  reason: collision with root package name */
    private final l.a f30006e;

    static class a implements l.b {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<? extends r>, l.c<? extends r>> f30007a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private l.a f30008b;

        a() {
        }

        @NonNull
        public l a(@NonNull g gVar, @NonNull q qVar) {
            l.a aVar = this.f30008b;
            if (aVar == null) {
                aVar = new b();
            }
            return new n(gVar, qVar, new t(), Collections.unmodifiableMap(this.f30007a), aVar);
        }

        @NonNull
        public <N extends r> l.b b(@NonNull Class<N> cls, l.c<? super N> cVar) {
            if (cVar == null) {
                this.f30007a.remove(cls);
            } else {
                this.f30007a.put(cls, cVar);
            }
            return this;
        }
    }

    n(@NonNull g gVar, @NonNull q qVar, @NonNull t tVar, @NonNull Map<Class<? extends r>, l.c<? extends r>> map, @NonNull l.a aVar) {
        this.f30002a = gVar;
        this.f30003b = qVar;
        this.f30004c = tVar;
        this.f30005d = map;
        this.f30006e = aVar;
    }

    private void G(@NonNull r rVar) {
        l.c cVar = this.f30005d.get(rVar.getClass());
        if (cVar != null) {
            cVar.a(this, rVar);
        } else {
            d(rVar);
        }
    }

    public void A(t tVar) {
        G(tVar);
    }

    public void B(o oVar) {
        G(oVar);
    }

    public void C(h hVar) {
        G(hVar);
    }

    public void D(k kVar) {
        G(kVar);
    }

    public void E(s sVar) {
        G(sVar);
    }

    public <N extends r> void F(@NonNull Class<N> cls, int i10) {
        s sVar = this.f30002a.c().get(cls);
        if (sVar != null) {
            b(i10, sVar.a(this.f30002a, this.f30003b));
        }
    }

    public void a(q qVar) {
        G(qVar);
    }

    public void b(int i10, Object obj) {
        t tVar = this.f30004c;
        t.j(tVar, obj, i10, tVar.length());
    }

    @NonNull
    public t builder() {
        return this.f30004c;
    }

    public void c(e eVar) {
        G(eVar);
    }

    public void d(@NonNull r rVar) {
        r c10 = rVar.c();
        while (c10 != null) {
            r e10 = c10.e();
            c10.a(this);
            c10 = e10;
        }
    }

    public void e(b bVar) {
        G(bVar);
    }

    public void f(u uVar) {
        G(uVar);
    }

    public void g(g gVar) {
        G(gVar);
    }

    public void h(i iVar) {
        G(iVar);
    }

    public <N extends r> void i(@NonNull N n10, int i10) {
        F(n10.getClass(), i10);
    }

    @NonNull
    public q j() {
        return this.f30003b;
    }

    public void k(@NonNull r rVar) {
        this.f30006e.a(this, rVar);
    }

    public void l(am.l lVar) {
        G(lVar);
    }

    public int length() {
        return this.f30004c.length();
    }

    public void m(v vVar) {
        G(vVar);
    }

    public void n(w wVar) {
        G(wVar);
    }

    public void o(f fVar) {
        G(fVar);
    }

    public void p(c cVar) {
        G(cVar);
    }

    public void q(@NonNull r rVar) {
        this.f30006e.b(this, rVar);
    }

    @NonNull
    public g r() {
        return this.f30002a;
    }

    public void s(x xVar) {
        G(xVar);
    }

    public void t() {
        this.f30004c.append(10);
    }

    public void u(m mVar) {
        G(mVar);
    }

    public boolean v(@NonNull r rVar) {
        return rVar.e() != null;
    }

    public void w(j jVar) {
        G(jVar);
    }

    public void x(am.n nVar) {
        G(nVar);
    }

    public void y(d dVar) {
        G(dVar);
    }

    public void z() {
        if (this.f30004c.length() > 0 && 10 != this.f30004c.h()) {
            this.f30004c.append(10);
        }
    }
}
