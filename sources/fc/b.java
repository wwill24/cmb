package fc;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.today_view.main.e;
import fc.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f40778a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f40779b;

        private a() {
        }

        public d.a a() {
            g.a(this.f40778a, d.b.class);
            g.a(this.f40779b, d.c.class);
            return new C0492b(this.f40778a, this.f40779b);
        }

        public a b(d.b bVar) {
            this.f40778a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f40779b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: fc.b$b  reason: collision with other inner class name */
    private static final class C0492b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f40780a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f40781b;

        /* renamed from: c  reason: collision with root package name */
        private final C0492b f40782c;

        private C0492b(d.b bVar, d.c cVar) {
            this.f40782c = this;
            this.f40780a = bVar;
            this.f40781b = cVar;
        }

        private g c(g gVar) {
            t.a(gVar, e.a(this.f40780a));
            h.d(gVar, (ProfileContract$Manager) g.d(this.f40781b.d()));
            h.b(gVar, (a6.a) g.d(this.f40781b.x()));
            h.c(gVar, (e.a) g.d(this.f40781b.g()));
            h.a(gVar, (a7.a) g.d(this.f40781b.c()));
            return gVar;
        }

        /* renamed from: b */
        public void l1(g gVar) {
            c(gVar);
        }
    }

    public static a a() {
        return new a();
    }
}
