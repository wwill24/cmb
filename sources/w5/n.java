package w5;

import android.app.Activity;
import b6.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import fj.g;
import w5.a;

public final class n {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private a.b f18265a;

        /* renamed from: b  reason: collision with root package name */
        private a.c f18266b;

        private a() {
        }

        public a.C0216a a() {
            g.a(this.f18265a, a.b.class);
            g.a(this.f18266b, a.c.class);
            return new b(this.f18265a, this.f18266b);
        }

        public a b(a.b bVar) {
            this.f18265a = (a.b) g.b(bVar);
            return this;
        }

        public a c(a.c cVar) {
            this.f18266b = (a.c) g.b(cVar);
            return this;
        }
    }

    private static final class b implements a.C0216a {

        /* renamed from: a  reason: collision with root package name */
        private final a.b f18267a;

        /* renamed from: b  reason: collision with root package name */
        private final a.c f18268b;

        /* renamed from: c  reason: collision with root package name */
        private final b f18269c;

        private b(a.b bVar, a.c cVar) {
            this.f18269c = this;
            this.f18267a = bVar;
            this.f18268b = cVar;
        }

        private k b() {
            return b.a(this.f18267a, (Activity) g.d(this.f18268b.i()));
        }

        private h d(h hVar) {
            t.a(hVar, b());
            i.a(hVar, (y5.a) g.d(this.f18268b.S()));
            i.b(hVar, (y5.b) g.d(this.f18268b.W()));
            i.c(hVar, (x5.a) g.d(this.f18268b.E()));
            i.d(hVar, (s9.a) g.d(this.f18268b.b()));
            i.e(hVar, (ProfileRepositoryV2) g.d(this.f18268b.J()));
            i.f(hVar, (UserRepository) g.d(this.f18268b.e()));
            return hVar;
        }

        /* renamed from: c */
        public void l1(h hVar) {
            d(hVar);
        }
    }

    public static a a() {
        return new a();
    }
}
