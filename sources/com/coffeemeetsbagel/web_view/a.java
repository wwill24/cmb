package com.coffeemeetsbagel.web_view;

import b6.d;
import com.coffeemeetsbagel.web_view.c;
import fj.g;

public final class a {

    /* renamed from: com.coffeemeetsbagel.web_view.a$a  reason: collision with other inner class name */
    public static final class C0472a {

        /* renamed from: a  reason: collision with root package name */
        private c.b f37594a;

        private C0472a() {
        }

        public c.a a() {
            g.a(this.f37594a, c.b.class);
            return new b(this.f37594a);
        }

        public C0472a b(c.b bVar) {
            this.f37594a = (c.b) g.b(bVar);
            return this;
        }
    }

    private static final class b implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final c.b f37595a;

        /* renamed from: b  reason: collision with root package name */
        private final b f37596b;

        /* renamed from: c  reason: collision with root package name */
        private fk.a<qc.a> f37597c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<qc.a> f37598d;

        private b(c.b bVar) {
            this.f37596b = this;
            this.f37595a = bVar;
            d(bVar);
        }

        private void d(c.b bVar) {
            fk.a<qc.a> a10 = fj.c.a(e.a(bVar));
            this.f37597c = a10;
            this.f37598d = fj.c.a(f.a(bVar, a10));
        }

        public d a() {
            return d.a(this.f37595a);
        }

        public qc.a c() {
            return this.f37598d.get();
        }

        /* renamed from: e */
        public void g0(c cVar) {
        }

        public qc.a j0() {
            return this.f37598d.get();
        }
    }

    public static C0472a a() {
        return new C0472a();
    }
}
