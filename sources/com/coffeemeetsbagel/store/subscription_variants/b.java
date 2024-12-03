package com.coffeemeetsbagel.store.subscription_variants;

import android.app.Activity;
import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellAnalytics;
import com.coffeemeetsbagel.store.subscription_variants.d;
import fj.g;
import wb.e;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.c f36972a;

        /* renamed from: b  reason: collision with root package name */
        private d.a f36973b;

        private a() {
        }

        public d.b a() {
            g.a(this.f36972a, d.c.class);
            g.a(this.f36973b, d.a.class);
            return new C0455b(this.f36972a, this.f36973b);
        }

        public a b(d.a aVar) {
            this.f36973b = (d.a) g.b(aVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f36972a = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.store.subscription_variants.b$b  reason: collision with other inner class name */
    private static final class C0455b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f36974a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f36975b;

        /* renamed from: c  reason: collision with root package name */
        private final C0455b f36976c;

        private C0455b(d.c cVar, d.a aVar) {
            this.f36976c = this;
            this.f36974a = cVar;
            this.f36975b = aVar;
        }

        private SubscriptionVariantsInteractor c(SubscriptionVariantsInteractor subscriptionVariantsInteractor) {
            t.a(subscriptionVariantsInteractor, e.a(this.f36974a));
            l.e(subscriptionVariantsInteractor, (SubscriptionRepository) g.d(this.f36975b.Z()));
            l.b(subscriptionVariantsInteractor, (BuySubscriptionUseCase) g.d(this.f36975b.g()));
            l.d(subscriptionVariantsInteractor, (e) g.d(this.f36975b.D0()));
            l.a(subscriptionVariantsInteractor, (c6.b) g.d(this.f36975b.e0()));
            l.g(subscriptionVariantsInteractor, (PremiumUpsellAnalytics) g.d(this.f36975b.S()));
            l.h(subscriptionVariantsInteractor, (UserRepository) g.d(this.f36975b.C()));
            l.f(subscriptionVariantsInteractor, (SubscriptionRepository) g.d(this.f36975b.Z()));
            l.c(subscriptionVariantsInteractor, (s9.a) g.d(this.f36975b.b()));
            return subscriptionVariantsInteractor;
        }

        /* renamed from: b */
        public void l1(SubscriptionVariantsInteractor subscriptionVariantsInteractor) {
            c(subscriptionVariantsInteractor);
        }

        public Activity i() {
            return (Activity) g.d(this.f36975b.i());
        }
    }

    public static a a() {
        return new a();
    }
}
