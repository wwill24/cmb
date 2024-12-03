package com.coffeemeetsbagel.store.premium_upsell;

import android.app.Activity;
import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import com.coffeemeetsbagel.store.premium_upsell.k;
import fj.c;
import fj.g;
import wb.e;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private k.c f36880a;

        /* renamed from: b  reason: collision with root package name */
        private k.a f36881b;

        private a() {
        }

        public k.b a() {
            g.a(this.f36880a, k.c.class);
            g.a(this.f36881b, k.a.class);
            return new C0453b(this.f36880a, this.f36881b);
        }

        public a b(k.a aVar) {
            this.f36881b = (k.a) g.b(aVar);
            return this;
        }

        public a c(k.c cVar) {
            this.f36880a = (k.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.store.premium_upsell.b$b  reason: collision with other inner class name */
    private static final class C0453b implements k.b {

        /* renamed from: a  reason: collision with root package name */
        private final k.c f36882a;

        /* renamed from: b  reason: collision with root package name */
        private final k.a f36883b;

        /* renamed from: c  reason: collision with root package name */
        private final C0453b f36884c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<a7.a> f36885d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<PremiumUpsellAnalytics> f36886e;

        /* renamed from: com.coffeemeetsbagel.store.premium_upsell.b$b$a */
        private static final class a implements fk.a<a7.a> {

            /* renamed from: a  reason: collision with root package name */
            private final k.a f36887a;

            a(k.a aVar) {
                this.f36887a = aVar;
            }

            /* renamed from: a */
            public a7.a get() {
                return (a7.a) g.d(this.f36887a.T());
            }
        }

        private C0453b(k.c cVar, k.a aVar) {
            this.f36884c = this;
            this.f36882a = cVar;
            this.f36883b = aVar;
            e(cVar, aVar);
        }

        private GetSubscriptionBundlesUseCase d() {
            return new GetSubscriptionBundlesUseCase((SubscriptionRepository) g.d(this.f36883b.Z()));
        }

        private void e(k.c cVar, k.a aVar) {
            a aVar2 = new a(aVar);
            this.f36885d = aVar2;
            this.f36886e = c.a(m.a(cVar, aVar2));
        }

        private PremiumUpsellInteractor h(PremiumUpsellInteractor premiumUpsellInteractor) {
            t.a(premiumUpsellInteractor, l.a(this.f36882a));
            u.c(premiumUpsellInteractor, this.f36886e.get());
            u.a(premiumUpsellInteractor, (s9.a) g.d(this.f36883b.b()));
            u.b(premiumUpsellInteractor, d());
            return premiumUpsellInteractor;
        }

        public UserRepository C() {
            return (UserRepository) g.d(this.f36883b.C());
        }

        public e D0() {
            return (e) g.d(this.f36883b.D0());
        }

        public PremiumUpsellAnalytics S() {
            return this.f36886e.get();
        }

        public a7.a T() {
            return (a7.a) g.d(this.f36883b.T());
        }

        public SubscriptionRepository Z() {
            return (SubscriptionRepository) g.d(this.f36883b.Z());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f36883b.b());
        }

        public PremiumUpsellAnalytics c() {
            return this.f36886e.get();
        }

        public c6.b e0() {
            return (c6.b) g.d(this.f36883b.a0());
        }

        /* renamed from: f */
        public void l1(PremiumUpsellInteractor premiumUpsellInteractor) {
            h(premiumUpsellInteractor);
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f36883b.g());
        }

        public Activity i() {
            return (Activity) g.d(this.f36883b.i());
        }
    }

    public static a a() {
        return new a();
    }
}
