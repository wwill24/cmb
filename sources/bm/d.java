package bm;

import am.r;
import cm.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import xl.h;
import xl.m;
import xl.n;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<e> f18967a;

    /* renamed from: b  reason: collision with root package name */
    private final List<dm.a> f18968b;

    /* renamed from: c  reason: collision with root package name */
    private final c f18969c;

    /* renamed from: d  reason: collision with root package name */
    private final List<e> f18970d;

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<e> f18971a = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final List<dm.a> f18972b = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final List<e> f18973c = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Set<Class<? extends am.a>> f18974d = h.s();

        /* renamed from: e  reason: collision with root package name */
        private c f18975e;

        class a implements c {
            a() {
            }

            public a a(b bVar) {
                return new n(bVar);
            }
        }

        /* access modifiers changed from: private */
        public c g() {
            c cVar = this.f18975e;
            if (cVar != null) {
                return cVar;
            }
            return new a();
        }

        public d f() {
            return new d(this);
        }
    }

    private h a() {
        return new h(this.f18967a, this.f18969c, this.f18968b);
    }

    private r c(r rVar) {
        for (e a10 : this.f18970d) {
            rVar = a10.a(rVar);
        }
        return rVar;
    }

    public r b(String str) {
        if (str != null) {
            return c(a().u(str));
        }
        throw new NullPointerException("input must not be null");
    }

    private d(b bVar) {
        this.f18967a = h.l(bVar.f18971a, bVar.f18974d);
        c c10 = bVar.g();
        this.f18969c = c10;
        this.f18970d = bVar.f18973c;
        List<dm.a> e10 = bVar.f18972b;
        this.f18968b = e10;
        c10.a(new m(e10, Collections.emptyMap()));
    }
}
