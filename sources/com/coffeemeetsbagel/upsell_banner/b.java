package com.coffeemeetsbagel.upsell_banner;

import b6.t;
import com.coffeemeetsbagel.upsell_banner.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private g.b f37556a;

        /* renamed from: b  reason: collision with root package name */
        private g.c f37557b;

        private a() {
        }

        public g.a a() {
            fj.g.a(this.f37556a, g.b.class);
            fj.g.a(this.f37557b, g.c.class);
            return new C0471b(this.f37556a, this.f37557b);
        }

        public a b(g.b bVar) {
            this.f37556a = (g.b) fj.g.b(bVar);
            return this;
        }

        public a c(g.c cVar) {
            this.f37557b = (g.c) fj.g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.upsell_banner.b$b  reason: collision with other inner class name */
    private static final class C0471b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        private final g.b f37558a;

        /* renamed from: b  reason: collision with root package name */
        private final g.c f37559b;

        /* renamed from: c  reason: collision with root package name */
        private final C0471b f37560c;

        private C0471b(g.b bVar, g.c cVar) {
            this.f37560c = this;
            this.f37558a = bVar;
            this.f37559b = cVar;
        }

        private i c(i iVar) {
            t.a(iVar, h.a(this.f37558a));
            j.a(iVar, (a7.a) fj.g.d(this.f37559b.c()));
            return iVar;
        }

        /* renamed from: b */
        public void l1(i iVar) {
            c(iVar);
        }
    }

    public static a a() {
        return new a();
    }
}
