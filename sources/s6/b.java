package s6;

import b6.t;
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
import s6.d;
import s6.m;
import wb.c;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f17492a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f17493b;

        private a() {
        }

        public d.a a() {
            g.a(this.f17492a, d.b.class);
            g.a(this.f17493b, d.c.class);
            return new C0203b(this.f17492a, this.f17493b);
        }

        public a b(d.b bVar) {
            this.f17492a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f17493b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: s6.b$b  reason: collision with other inner class name */
    private static final class C0203b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f17494a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f17495b;

        /* renamed from: c  reason: collision with root package name */
        private final C0203b f17496c;

        private C0203b(d.b bVar, d.c cVar) {
            this.f17496c = this;
            this.f17494a = bVar;
            this.f17495b = cVar;
        }

        private m h(m mVar) {
            t.a(mVar, e.a(this.f17494a));
            n.b(mVar, (v7.d) g.d(this.f17495b.G()));
            n.d(mVar, (ActivityMain) g.d(this.f17495b.D()));
            n.a(mVar, (a7.a) g.d(this.f17495b.c()));
            n.f(mVar, (UserRepository) g.d(this.f17495b.e()));
            n.e(mVar, (k0) g.d(this.f17495b.j()));
            n.c(mVar, (c) g.d(this.f17495b.r()));
            return mVar;
        }

        public ProfileRepositoryV2 A0() {
            return (ProfileRepositoryV2) g.d(this.f17495b.A0());
        }

        public com.coffeemeetsbagel.store.alc.d C0() {
            return (com.coffeemeetsbagel.store.alc.d) g.d(this.f17495b.C0());
        }

        public BuySubscriptionUseCase D0() {
            return (BuySubscriptionUseCase) g.d(this.f17495b.D0());
        }

        public GetMyOwnProfileLocalUseCase E0() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f17495b.E0());
        }

        public z F() {
            return (z) g.d(this.f17495b.F());
        }

        public c F0() {
            return (c) g.d(this.f17495b.r());
        }

        public v7.d G() {
            return (v7.d) g.d(this.f17495b.G());
        }

        public m.b G0() {
            return f.a(this.f17494a);
        }

        public b7.c K() {
            return (b7.c) g.d(this.f17495b.K());
        }

        public t7.a Q() {
            return (t7.a) g.d(this.f17495b.Q());
        }

        public ActivityMain a() {
            return (ActivityMain) g.d(this.f17495b.D());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f17495b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f17495b.c());
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f17495b.d());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f17495b.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f17495b.f());
        }

        /* renamed from: g */
        public void l1(m mVar) {
            h(mVar);
        }

        public m1 i0() {
            return (m1) g.d(this.f17495b.i0());
        }

        public k0 j() {
            return (k0) g.d(this.f17495b.j());
        }

        public j l() {
            return (j) g.d(this.f17495b.l());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f17495b.m());
        }

        public k q0() {
            return (k) g.d(this.f17495b.q0());
        }

        public h t() {
            return (h) g.d(this.f17495b.t());
        }

        public a6.a x() {
            return (a6.a) g.d(this.f17495b.x());
        }
    }

    public static a a() {
        return new a();
    }
}
