package u9;

import b6.d;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.match.j;
import com.coffemeetsbagel.hide_report.f;
import fj.g;
import u9.e;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e.b f18022a;

        /* renamed from: b  reason: collision with root package name */
        private f f18023b;

        private a() {
        }

        public e.a a() {
            g.a(this.f18022a, e.b.class);
            g.a(this.f18023b, f.class);
            return new C0213b(this.f18022a, this.f18023b);
        }

        public a b(f fVar) {
            this.f18023b = (f) g.b(fVar);
            return this;
        }

        public a c(e.b bVar) {
            this.f18022a = (e.b) g.b(bVar);
            return this;
        }
    }

    /* renamed from: u9.b$b  reason: collision with other inner class name */
    private static final class C0213b implements e.a {

        /* renamed from: a  reason: collision with root package name */
        private final e.b f18024a;

        /* renamed from: b  reason: collision with root package name */
        private final f f18025b;

        /* renamed from: c  reason: collision with root package name */
        private final C0213b f18026c;

        private C0213b(e.b bVar, f fVar) {
            this.f18026c = this;
            this.f18024a = bVar;
            this.f18025b = fVar;
        }

        public ProfileRepository A() {
            return (ProfileRepository) g.d(this.f18025b.A());
        }

        public c9.a I() {
            return (c9.a) g.d(this.f18025b.I());
        }

        public a0 L() {
            return (a0) g.d(this.f18025b.L());
        }

        public d<?, ?> a() {
            return f.a(this.f18024a);
        }

        public a7.a c() {
            return (a7.a) g.d(this.f18025b.c());
        }

        /* renamed from: e */
        public void g0(e eVar) {
        }

        public j l() {
            return (j) g.d(this.f18025b.l());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f18025b.p());
        }
    }

    public static a a() {
        return new a();
    }
}
