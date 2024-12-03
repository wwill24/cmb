package com.coffeemeetsbagel.shop;

import b6.d;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.shop.b;
import com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase;
import com.coffeemeetsbagel.store.BuyBeansUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import fj.g;
import ib.c;

public final class a {

    /* renamed from: com.coffeemeetsbagel.shop.a$a  reason: collision with other inner class name */
    public static final class C0445a {

        /* renamed from: a  reason: collision with root package name */
        private b.C0446b f36405a;

        /* renamed from: b  reason: collision with root package name */
        private c f36406b;

        private C0445a() {
        }

        public b.a a() {
            g.a(this.f36405a, b.C0446b.class);
            g.a(this.f36406b, c.class);
            return new b(this.f36405a, this.f36406b);
        }

        public C0445a b(b.C0446b bVar) {
            this.f36405a = (b.C0446b) g.b(bVar);
            return this;
        }

        public C0445a c(c cVar) {
            this.f36406b = (c) g.b(cVar);
            return this;
        }
    }

    private static final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final b.C0446b f36407a;

        /* renamed from: b  reason: collision with root package name */
        private final c f36408b;

        /* renamed from: c  reason: collision with root package name */
        private final b f36409c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<jb.b> f36410d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<jb.c> f36411e;

        /* renamed from: f  reason: collision with root package name */
        private fk.a<kb.b> f36412f;

        /* renamed from: g  reason: collision with root package name */
        private fk.a<kb.a> f36413g;

        /* renamed from: h  reason: collision with root package name */
        private fk.a<kb.c> f36414h;

        /* renamed from: j  reason: collision with root package name */
        private fk.a<jb.a> f36415j;

        private b(b.C0446b bVar, c cVar) {
            this.f36409c = this;
            this.f36407a = bVar;
            this.f36408b = cVar;
            k(bVar, cVar);
        }

        private void k(b.C0446b bVar, c cVar) {
            fk.a<jb.b> a10 = fj.c.a(f.b(bVar));
            this.f36410d = a10;
            this.f36411e = fj.c.a(g.b(bVar, a10));
            fk.a<kb.b> a11 = fj.c.a(j.a(bVar));
            this.f36412f = a11;
            this.f36413g = fj.c.a(i.a(bVar, a11));
            this.f36414h = fj.c.a(k.a(bVar, this.f36412f));
            this.f36415j = fj.c.a(e.b(bVar, this.f36410d));
        }

        public t B() {
            return (t) g.d(this.f36408b.B());
        }

        public hb.c H() {
            return (hb.c) g.d(this.f36408b.H());
        }

        public BuyBeansUseCase I0() {
            return (BuyBeansUseCase) g.d(this.f36408b.I0());
        }

        public GetPlayAvailabilityUseCase J0() {
            return (GetPlayAvailabilityUseCase) g.d(this.f36408b.J0());
        }

        public jb.c L0() {
            return this.f36411e.get();
        }

        public kb.a M0() {
            return this.f36413g.get();
        }

        public d6.a N0() {
            return d.a(this.f36407a);
        }

        public kb.c O0() {
            return this.f36414h.get();
        }

        public SubscriptionRepository P() {
            return (SubscriptionRepository) g.d(this.f36408b.P());
        }

        public com.coffeemeetsbagel.feature.instagram.c U() {
            return (com.coffeemeetsbagel.feature.instagram.c) g.d(this.f36408b.U());
        }

        public d a() {
            return h.a(this.f36407a);
        }

        public s9.a b() {
            return (s9.a) g.d(this.f36408b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f36408b.c());
        }

        public ProfileManager d() {
            return (ProfileManager) g.d(this.f36408b.d());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f36408b.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f36408b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f36408b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f36408b.h());
        }

        public androidx.appcompat.app.c i() {
            return c.a(this.f36407a);
        }

        public PurchaseManager j() {
            return (PurchaseManager) g.d(this.f36408b.j());
        }

        public jb.a k0() {
            return this.f36415j.get();
        }

        /* renamed from: l */
        public void g0(b bVar) {
        }

        public wb.c r() {
            return (wb.c) g.d(this.f36408b.r());
        }

        public p9.d r0() {
            return (p9.d) g.d(this.f36408b.r0());
        }
    }

    public static C0445a a() {
        return new C0445a();
    }
}
