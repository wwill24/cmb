package oa;

import b6.t;
import fj.g;
import oa.d;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.c f41311a;

        /* renamed from: b  reason: collision with root package name */
        private d.a f41312b;

        private a() {
        }

        public d.b a() {
            g.a(this.f41311a, d.c.class);
            g.a(this.f41312b, d.a.class);
            return new C0501b(this.f41311a, this.f41312b);
        }

        public a b(d.a aVar) {
            this.f41312b = (d.a) g.b(aVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f41311a = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: oa.b$b  reason: collision with other inner class name */
    private static final class C0501b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f41313a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f41314b;

        /* renamed from: c  reason: collision with root package name */
        private final C0501b f41315c;

        private C0501b(d.c cVar, d.a aVar) {
            this.f41315c = this;
            this.f41313a = cVar;
            this.f41314b = aVar;
        }

        private f c(f fVar) {
            t.a(fVar, e.a(this.f41313a));
            g.a(fVar, (na.b) g.d(this.f41314b.j()));
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
