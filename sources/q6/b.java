package q6;

import b6.t;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.store.k0;
import fj.g;
import q6.d;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f17174a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f17175b;

        private a() {
        }

        public d.a a() {
            g.a(this.f17174a, d.b.class);
            g.a(this.f17175b, d.c.class);
            return new C0194b(this.f17174a, this.f17175b);
        }

        public a b(d.b bVar) {
            this.f17174a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f17175b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: q6.b$b  reason: collision with other inner class name */
    private static final class C0194b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f17176a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f17177b;

        /* renamed from: c  reason: collision with root package name */
        private final C0194b f17178c;

        private C0194b(d.b bVar, d.c cVar) {
            this.f17178c = this;
            this.f17176a = bVar;
            this.f17177b = cVar;
        }

        private k b() {
            return e.a(this.f17176a, (v7.d) g.d(this.f17177b.G()));
        }

        private f d(f fVar) {
            t.a(fVar, b());
            h.a(fVar, (s9.a) g.d(this.f17177b.b()));
            h.b(fVar, (k0) g.d(this.f17177b.j()));
            return fVar;
        }

        public ActivityMain a() {
            return (ActivityMain) g.d(this.f17177b.a());
        }

        /* renamed from: c */
        public void l1(f fVar) {
            d(fVar);
        }
    }

    public static a a() {
        return new a();
    }
}
