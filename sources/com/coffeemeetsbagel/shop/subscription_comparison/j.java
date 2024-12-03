package com.coffeemeetsbagel.shop.subscription_comparison;

import android.view.View;
import b6.u;
import com.coffeemeetsbagel.shop.subscription_comparison.e;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;

public final class j extends u<View, e.b, SubscriptionComparisonInteractor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(View view, e.b bVar, SubscriptionComparisonInteractor subscriptionComparisonInteractor) {
        super(view, bVar, subscriptionComparisonInteractor);
        kotlin.jvm.internal.j.g(view, "view");
        kotlin.jvm.internal.j.g(bVar, "component");
        kotlin.jvm.internal.j.g(subscriptionComparisonInteractor, "interactor");
    }

    public static /* synthetic */ void n(j jVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        jVar.m(z10);
    }

    public final void m(boolean z10) {
        PremiumUpsellComponentActivity.f36846j.c(((e.b) e()).i(), new PurchaseSource("bean shop", "bean shop"), z10);
    }
}
