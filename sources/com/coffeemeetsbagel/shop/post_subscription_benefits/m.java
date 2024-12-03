package com.coffeemeetsbagel.shop.post_subscription_benefits;

import b6.u;
import com.coffeemeetsbagel.shop.post_subscription_benefits.d;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import kotlin.jvm.internal.j;

public final class m extends u<n, d.b, PostSubscriptionBenefitsCardInteractor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(n nVar, d.b bVar, PostSubscriptionBenefitsCardInteractor postSubscriptionBenefitsCardInteractor) {
        super(nVar, bVar, postSubscriptionBenefitsCardInteractor);
        j.g(nVar, "view");
        j.g(bVar, "component");
        j.g(postSubscriptionBenefitsCardInteractor, "interactor");
    }

    public final void m() {
        PremiumUpsellComponentActivity.f36846j.b(((d.b) e()).i(), new PurchaseSource("bean shop", "bean shop"));
    }
}
