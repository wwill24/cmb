package com.coffeemeetsbagel.shop.shop;

import b6.d;
import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.shop.shop.h;
import com.coffeemeetsbagel.store.BuyBeansUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import fj.c;
import fj.g;
import lc.k;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private h.c f36518a;

        /* renamed from: b  reason: collision with root package name */
        private h.a f36519b;

        private a() {
        }

        public h.b a() {
            g.a(this.f36518a, h.c.class);
            g.a(this.f36519b, h.a.class);
            return new C0449b(this.f36518a, this.f36519b);
        }

        public a b(h.a aVar) {
            this.f36519b = (h.a) g.b(aVar);
            return this;
        }

        public a c(h.c cVar) {
            this.f36518a = (h.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.shop.shop.b$b  reason: collision with other inner class name */
    private static final class C0449b implements h.b {

        /* renamed from: a  reason: collision with root package name */
        private final h.a f36520a;

        /* renamed from: b  reason: collision with root package name */
        private final C0449b f36521b;

        /* renamed from: c  reason: collision with root package name */
        private fk.a<d> f36522c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<o0> f36523d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<k> f36524e;

        /* renamed from: com.coffeemeetsbagel.shop.shop.b$b$a */
        private static final class a implements fk.a<d> {

            /* renamed from: a  reason: collision with root package name */
            private final h.a f36525a;

            a(h.a aVar) {
                this.f36525a = aVar;
            }

            /* renamed from: a */
            public d get() {
                return (d) g.d(this.f36525a.a());
            }
        }

        private C0449b(h.c cVar, h.a aVar) {
            this.f36521b = this;
            this.f36520a = aVar;
            d(cVar, aVar);
        }

        private void d(h.c cVar, h.a aVar) {
            a aVar2 = new a(aVar);
            this.f36522c = aVar2;
            this.f36523d = c.a(j.b(cVar, aVar2));
            this.f36524e = c.a(i.b(cVar));
        }

        private z l(z zVar) {
            t.a(zVar, this.f36523d.get());
            a0.a(zVar, (a7.a) g.d(this.f36520a.c()));
            a0.b(zVar, (jb.c) g.d(this.f36520a.L0()));
            a0.e(zVar, (d) g.d(this.f36520a.a()));
            a0.f(zVar, this.f36524e.get());
            a0.l(zVar, (ProfileManager) g.d(this.f36520a.d()));
            a0.m(zVar, (PurchaseManager) g.d(this.f36520a.j()));
            a0.p(zVar, (p9.d) g.d(this.f36520a.r0()));
            a0.k(zVar, (com.coffeemeetsbagel.feature.instagram.c) g.d(this.f36520a.U()));
            a0.q(zVar, (UserRepository) g.d(this.f36520a.e()));
            a0.i(zVar, (GetPlayAvailabilityUseCase) g.d(this.f36520a.J0()));
            a0.h(zVar, (wb.c) g.d(this.f36520a.r()));
            a0.j(zVar, (GetSubscriptionBundlesUseCase) g.d(this.f36520a.k()));
            a0.c(zVar, (BuyBeansUseCase) g.d(this.f36520a.I0()));
            a0.d(zVar, (BuySubscriptionUseCase) g.d(this.f36520a.g()));
            a0.g(zVar, (s9.a) g.d(this.f36520a.b()));
            a0.o(zVar, (SubscriptionRepository) g.d(this.f36520a.P()));
            a0.n(zVar, (com.coffeemeetsbagel.experiment.t) g.d(this.f36520a.B()));
            return zVar;
        }

        public com.coffeemeetsbagel.feature.instagram.c U() {
            return (com.coffeemeetsbagel.feature.instagram.c) g.d(this.f36520a.U());
        }

        public d a() {
            return (d) g.d(this.f36520a.a());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f36520a.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f36520a.c());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f36520a.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f36520a.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f36520a.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f36520a.h());
        }

        public androidx.appcompat.app.c i() {
            return (androidx.appcompat.app.c) g.d(this.f36520a.i());
        }

        /* renamed from: j */
        public void l1(z zVar) {
            l(zVar);
        }

        public GetSubscriptionBundlesUseCase k() {
            return (GetSubscriptionBundlesUseCase) g.d(this.f36520a.k());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f36520a.P());
        }

        public androidx.appcompat.app.c n() {
            return (androidx.appcompat.app.c) g.d(this.f36520a.i());
        }

        public p9.d r0() {
            return (p9.d) g.d(this.f36520a.r0());
        }
    }

    public static a a() {
        return new a();
    }
}
