package com.coffeemeetsbagel.store.subscription_variants;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellAnalytics;
import kotlin.Pair;
import wb.e;

public final class d extends b6.c<SubscriptionVariantsRouter, a> {

    public interface a {
        UserRepository C();

        e D0();

        PremiumUpsellAnalytics S();

        SubscriptionRepository Z();

        s9.a b();

        c6.b e0();

        BuySubscriptionUseCase g();

        Activity i();
    }

    public interface b extends j<SubscriptionVariantsInteractor> {
        Activity i();
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ub.j f36977a;

        /* renamed from: b  reason: collision with root package name */
        private final p f36978b;

        public c(ub.j jVar, p pVar) {
            kotlin.jvm.internal.j.g(jVar, "binding");
            kotlin.jvm.internal.j.g(pVar, "userInteractionListener");
            this.f36977a = jVar;
            this.f36978b = pVar;
        }

        public final o a() {
            return new o(this.f36977a, this.f36978b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final SubscriptionVariantsRouter b(ViewGroup viewGroup, PurchaseSource purchaseSource, vb.c cVar, boolean z10, Pair<vb.a, vb.c> pair) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(purchaseSource, "purchaseSource");
        kotlin.jvm.internal.j.g(cVar, "bundle");
        SubscriptionVariantsInteractor subscriptionVariantsInteractor = new SubscriptionVariantsInteractor(purchaseSource, cVar, z10, pair);
        ub.j c10 = ub.j.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        b a10 = b.a().c(new c(c10, subscriptionVariantsInteractor)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new SubscriptionVariantsRouter(c10, a10, subscriptionVariantsInteractor);
    }
}
