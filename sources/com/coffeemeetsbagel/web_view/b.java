package com.coffeemeetsbagel.web_view;

import b6.t;
import com.coffeemeetsbagel.web_view.g;
import pc.f;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private g.c f37599a;

        /* renamed from: b  reason: collision with root package name */
        private g.a f37600b;

        private a() {
        }

        public g.b a() {
            fj.g.a(this.f37599a, g.c.class);
            fj.g.a(this.f37600b, g.a.class);
            return new C0473b(this.f37599a, this.f37600b);
        }

        public a b(g.a aVar) {
            this.f37600b = (g.a) fj.g.b(aVar);
            return this;
        }

        public a c(g.c cVar) {
            this.f37599a = (g.c) fj.g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.web_view.b$b  reason: collision with other inner class name */
    private static final class C0473b implements g.b {

        /* renamed from: a  reason: collision with root package name */
        private final g.c f37601a;

        /* renamed from: b  reason: collision with root package name */
        private final g.a f37602b;

        /* renamed from: c  reason: collision with root package name */
        private final C0473b f37603c;

        private C0473b(g.c cVar, g.a aVar) {
            this.f37603c = this;
            this.f37601a = cVar;
            this.f37602b = aVar;
        }

        private f c(f fVar) {
            t.a(fVar, h.a(this.f37601a));
            pc.g.a(fVar, (qc.a) fj.g.d(this.f37602b.c()));
            return fVar;
        }

        /* renamed from: b */
        public void l1(f fVar) {
            c(fVar);
        }
    }

    public static a a() {
        return new a();
    }
}
