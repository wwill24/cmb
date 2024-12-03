package com.coffeemeetsbagel.store.premium_upsell;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.x;
import com.coffeemeetsbagel.store.subscription_benefits.e;
import com.coffeemeetsbagel.store.subscription_variants.d;
import wb.e;
import xb.e;

public final class k extends b6.c<PremiumUpsellRouter, a> {

    public interface a {
        UserRepository C();

        e D0();

        a7.a T();

        SubscriptionRepository Z();

        c6.b a0();

        s9.a b();

        BuySubscriptionUseCase g();

        Activity i();
    }

    public interface b extends j<PremiumUpsellInteractor>, e.a, d.a, e.a {
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ub.b f36896a;

        /* renamed from: b  reason: collision with root package name */
        private final x.a f36897b;

        /* renamed from: c  reason: collision with root package name */
        private final PurchaseSource f36898c;

        /* renamed from: d  reason: collision with root package name */
        private final UserRepository f36899d;

        /* renamed from: e  reason: collision with root package name */
        private final SubscriptionRepository f36900e;

        public c(ub.b bVar, x.a aVar, PurchaseSource purchaseSource, UserRepository userRepository, SubscriptionRepository subscriptionRepository) {
            kotlin.jvm.internal.j.g(bVar, "binding");
            kotlin.jvm.internal.j.g(aVar, "userInteractionListener");
            kotlin.jvm.internal.j.g(purchaseSource, "purchaseSource");
            kotlin.jvm.internal.j.g(userRepository, "userRepository");
            kotlin.jvm.internal.j.g(subscriptionRepository, "subscriptionRepository");
            this.f36896a = bVar;
            this.f36897b = aVar;
            this.f36898c = purchaseSource;
            this.f36899d = userRepository;
            this.f36900e = subscriptionRepository;
        }

        public final x a() {
            return new x(this.f36896a, this.f36897b);
        }

        public final PremiumUpsellAnalytics b(a7.a aVar) {
            kotlin.jvm.internal.j.g(aVar, "analyticsManager");
            return new PremiumUpsellAnalytics(aVar, this.f36898c, this.f36899d, this.f36900e);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final PremiumUpsellRouter b(ViewGroup viewGroup, PurchaseSource purchaseSource, boolean z10) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(purchaseSource, "purchaseSource");
        PremiumUpsellInteractor premiumUpsellInteractor = new PremiumUpsellInteractor(purchaseSource, z10);
        ub.b c10 = ub.b.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        b a10 = b.a().c(new c(c10, premiumUpsellInteractor, purchaseSource, ((a) a()).C(), ((a) a()).Z())).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new PremiumUpsellRouter(c10, a10, premiumUpsellInteractor);
    }
}
