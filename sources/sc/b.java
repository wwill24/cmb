package sc;

import b6.t;
import com.coffemeetsbagel.hide_report.h;
import fj.g;
import sc.f;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private f.b f41916a;

        /* renamed from: b  reason: collision with root package name */
        private h f41917b;

        private a() {
        }

        public f.a a() {
            g.a(this.f41916a, f.b.class);
            g.a(this.f41917b, h.class);
            return new C0506b(this.f41916a, this.f41917b);
        }

        public a b(h hVar) {
            this.f41917b = (h) g.b(hVar);
            return this;
        }

        public a c(f.b bVar) {
            this.f41916a = (f.b) g.b(bVar);
            return this;
        }
    }

    /* renamed from: sc.b$b  reason: collision with other inner class name */
    private static final class C0506b implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final f.b f41918a;

        /* renamed from: b  reason: collision with root package name */
        private final C0506b f41919b;

        private C0506b(f.b bVar, h hVar) {
            this.f41919b = this;
            this.f41918a = bVar;
        }

        private h c(h hVar) {
            t.a(hVar, g.a(this.f41918a));
            return hVar;
        }

        /* renamed from: b */
        public void l1(h hVar) {
            c(hVar);
        }
    }

    public static a a() {
        return new a();
    }
}
