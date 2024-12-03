package r6;

import b6.t;
import b7.c;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.k0;
import fj.g;
import l8.h;
import lc.k;
import r6.e;
import s6.m;
import v7.d;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e.b f17287a;

        /* renamed from: b  reason: collision with root package name */
        private e.c f17288b;

        private a() {
        }

        public e.a a() {
            g.a(this.f17287a, e.b.class);
            g.a(this.f17288b, e.c.class);
            return new C0202b(this.f17287a, this.f17288b);
        }

        public a b(e.b bVar) {
            this.f17287a = (e.b) g.b(bVar);
            return this;
        }

        public a c(e.c cVar) {
            this.f17288b = (e.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: r6.b$b  reason: collision with other inner class name */
    private static final class C0202b implements e.a {

        /* renamed from: a  reason: collision with root package name */
        private final e.b f17289a;

        /* renamed from: b  reason: collision with root package name */
        private final e.c f17290b;

        /* renamed from: c  reason: collision with root package name */
        private final C0202b f17291c;

        private C0202b(e.b bVar, e.c cVar) {
            this.f17291c = this;
            this.f17289a = bVar;
            this.f17290b = cVar;
        }

        private f0 d() {
            return g.a(this.f17289a, (ProfileContract$Manager) g.d(this.f17290b.d()), (k0) g.d(this.f17290b.j()), (s9.a) g.d(this.f17290b.b()), (a6.a) g.d(this.f17290b.x()));
        }

        private u k(u uVar) {
            t.a(uVar, d());
            x.h(uVar, (d) g.d(this.f17290b.G()));
            x.j(uVar, (ActivityMain) g.d(this.f17290b.a()));
            x.f(uVar, (t7.a) g.d(this.f17290b.Q()));
            x.q(uVar, (k0) g.d(this.f17290b.j()));
            x.c(uVar, (j) g.d(this.f17290b.l()));
            x.n(uVar, (ProfileContract$Manager) g.d(this.f17290b.d()));
            x.b(uVar, (c) g.d(this.f17290b.K()));
            x.a(uVar, (a7.a) g.d(this.f17290b.c()));
            x.k(uVar, (m1) g.d(this.f17290b.i0()));
            x.e(uVar, (k) g.d(this.f17290b.q0()));
            x.g(uVar, (m.b) g.d(this.f17290b.G0()));
            x.m(uVar, (h) g.d(this.f17290b.t()));
            x.i(uVar, (wb.c) g.d(this.f17290b.F0()));
            x.o(uVar, (ProfileRepositoryV2) g.d(this.f17290b.A0()));
            x.l(uVar, (z) g.d(this.f17290b.F()));
            x.d(uVar, (a6.a) g.d(this.f17290b.x()));
            x.p(uVar, (com.coffeemeetsbagel.store.alc.d) g.d(this.f17290b.C0()));
            return uVar;
        }

        public ActivityMain a() {
            return (ActivityMain) g.d(this.f17290b.a());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f17290b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f17290b.c());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f17290b.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f17290b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f17290b.D0());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f17290b.E0());
        }

        /* renamed from: j */
        public void l1(u uVar) {
            k(uVar);
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f17290b.m());
        }

        public androidx.appcompat.app.c n() {
            return f.a(this.f17289a, (ActivityMain) g.d(this.f17290b.a()));
        }
    }

    public static a a() {
        return new a();
    }
}
