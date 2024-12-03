package dc;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.today_view.main.e;
import dc.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f40589a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f40590b;

        private a() {
        }

        public d.a a() {
            g.a(this.f40589a, d.b.class);
            g.a(this.f40590b, d.c.class);
            return new C0485b(this.f40589a, this.f40590b);
        }

        public a b(d.b bVar) {
            this.f40589a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f40590b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: dc.b$b  reason: collision with other inner class name */
    private static final class C0485b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f40591a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f40592b;

        /* renamed from: c  reason: collision with root package name */
        private final C0485b f40593c;

        private C0485b(d.b bVar, d.c cVar) {
            this.f40593c = this;
            this.f40591a = bVar;
            this.f40592b = cVar;
        }

        private f c(f fVar) {
            t.a(fVar, e.a(this.f40591a));
            g.b(fVar, (ProfileContract$Manager) g.d(this.f40592b.d()));
            g.c(fVar, (e.a) g.d(this.f40592b.r()));
            g.a(fVar, (a7.a) g.d(this.f40592b.c()));
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
