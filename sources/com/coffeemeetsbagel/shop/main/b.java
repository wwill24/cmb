package com.coffeemeetsbagel.shop.main;

import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.shop.main.d;
import com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase;
import com.coffeemeetsbagel.store.BuyBeansUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import fj.c;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f36434a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f36435b;

        private a() {
        }

        public d.a a() {
            g.a(this.f36434a, d.b.class);
            g.a(this.f36435b, d.c.class);
            return new C0447b(this.f36434a, this.f36435b);
        }

        public a b(d.b bVar) {
            this.f36434a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f36435b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.shop.main.b$b  reason: collision with other inner class name */
    private static final class C0447b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f36436a;

        /* renamed from: b  reason: collision with root package name */
        private final C0447b f36437b;

        /* renamed from: c  reason: collision with root package name */
        private fk.a<b6.d> f36438c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<n> f36439d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<MainShopTabs> f36440e;

        /* renamed from: com.coffeemeetsbagel.shop.main.b$b$a */
        private static final class a implements fk.a<b6.d> {

            /* renamed from: a  reason: collision with root package name */
            private final d.c f36441a;

            a(d.c cVar) {
                this.f36441a = cVar;
            }

            /* renamed from: a */
            public b6.d get() {
                return (b6.d) g.d(this.f36441a.a());
            }
        }

        private C0447b(d.b bVar, d.c cVar) {
            this.f36437b = this;
            this.f36436a = cVar;
            l(bVar, cVar);
        }

        private void l(d.b bVar, d.c cVar) {
            a aVar = new a(cVar);
            this.f36438c = aVar;
            this.f36439d = c.a(f.b(bVar, aVar));
            this.f36440e = c.a(e.a(bVar));
        }

        private k o(k kVar) {
            t.a(kVar, this.f36439d.get());
            l.a(kVar, (d6.a) g.d(this.f36436a.N0()));
            l.b(kVar, (a7.a) g.d(this.f36436a.c()));
            l.d(kVar, (kb.c) g.d(this.f36436a.O0()));
            l.e(kVar, (hb.c) g.d(this.f36436a.H()));
            l.c(kVar, this.f36440e.get());
            return kVar;
        }

        public com.coffeemeetsbagel.experiment.t B() {
            return (com.coffeemeetsbagel.experiment.t) g.d(this.f36436a.B());
        }

        public BuyBeansUseCase I0() {
            return (BuyBeansUseCase) g.d(this.f36436a.I0());
        }

        public GetPlayAvailabilityUseCase J0() {
            return (GetPlayAvailabilityUseCase) g.d(this.f36436a.J0());
        }

        public jb.c L0() {
            return (jb.c) g.d(this.f36436a.L0());
        }

        public kb.a M0() {
            return (kb.a) g.d(this.f36436a.M0());
        }

        public SubscriptionRepository P() {
            return (SubscriptionRepository) g.d(this.f36436a.P());
        }

        public com.coffeemeetsbagel.feature.instagram.c U() {
            return (com.coffeemeetsbagel.feature.instagram.c) g.d(this.f36436a.U());
        }

        public b6.d a() {
            return (b6.d) g.d(this.f36436a.a());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f36436a.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f36436a.c());
        }

        public ProfileManager d() {
            return (ProfileManager) g.d(this.f36436a.d());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f36436a.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f36436a.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f36436a.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f36436a.h());
        }

        public androidx.appcompat.app.c i() {
            return (androidx.appcompat.app.c) g.d(this.f36436a.i());
        }

        public PurchaseManager j() {
            return (PurchaseManager) g.d(this.f36436a.j());
        }

        public GetSubscriptionBundlesUseCase k() {
            return new GetSubscriptionBundlesUseCase((SubscriptionRepository) g.d(this.f36436a.P()));
        }

        /* renamed from: m */
        public void l1(k kVar) {
            o(kVar);
        }

        public wb.c r() {
            return (wb.c) g.d(this.f36436a.r());
        }

        public p9.d r0() {
            return (p9.d) g.d(this.f36436a.r0());
        }
    }

    public static a a() {
        return new a();
    }
}
