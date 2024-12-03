package com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall;

import android.view.View;
import b6.u;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.b;
import k6.b0;
import kotlin.jvm.internal.j;

public final class e extends u<View, b.C0466b, SuggestedUnsubPaywallInteractor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(b0 b0Var, b.C0466b bVar, SuggestedUnsubPaywallInteractor suggestedUnsubPaywallInteractor) {
        super(b0Var.getRoot(), bVar, suggestedUnsubPaywallInteractor);
        j.g(b0Var, "view");
        j.g(bVar, "component");
        j.g(suggestedUnsubPaywallInteractor, "interactor");
    }

    public final void m(PurchaseSource purchaseSource) {
        j.g(purchaseSource, "purchaseSource");
        PremiumUpsellComponentActivity.f36846j.b(((b.C0466b) e()).a(), purchaseSource);
    }
}
