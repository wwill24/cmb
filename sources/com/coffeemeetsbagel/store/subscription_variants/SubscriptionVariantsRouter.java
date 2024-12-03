package com.coffeemeetsbagel.store.subscription_variants;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.feature.purchase.PurchaseDisplayUtils;
import com.coffeemeetsbagel.store.PurchaseFailureType;
import com.coffeemeetsbagel.store.subscription_variants.d;
import gk.f;
import kotlin.Unit;
import r7.h;
import ub.j;

public final class SubscriptionVariantsRouter extends u<View, d.b, SubscriptionVariantsInteractor> {

    /* renamed from: f  reason: collision with root package name */
    private final f f36971f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionVariantsRouter(j jVar, d.b bVar, SubscriptionVariantsInteractor subscriptionVariantsInteractor) {
        super(jVar.getRoot(), bVar, subscriptionVariantsInteractor);
        kotlin.jvm.internal.j.g(jVar, "view");
        kotlin.jvm.internal.j.g(bVar, "component");
        kotlin.jvm.internal.j.g(subscriptionVariantsInteractor, "interactor");
        this.f36971f = b.b(new SubscriptionVariantsRouter$loadingProgressBar$2(bVar));
    }

    private final h n() {
        return (h) this.f36971f.getValue();
    }

    public final void m(PurchaseFailureType purchaseFailureType) {
        kotlin.jvm.internal.j.g(purchaseFailureType, "purchaseFailureType");
        Activity i10 = ((d.b) e()).i();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_FAILURE_MESSAGE", PurchaseDisplayUtils.getErrorForFailedPurchase(purchaseFailureType));
        Unit unit = Unit.f32013a;
        i10.setResult(242, intent.putExtras(bundle));
        ((d.b) e()).i().finish();
    }

    public final void o() {
        CmbLinks.Companion.launchTermsAndConditions(((d.b) e()).i());
    }

    public final void p() {
        SubscriptionVariantsRouter$showCelebrationDialog$cancelListener$1 subscriptionVariantsRouter$showCelebrationDialog$cancelListener$1 = new SubscriptionVariantsRouter$showCelebrationDialog$cancelListener$1(this);
        Context context = l().getContext();
        kotlin.jvm.internal.j.f(context, "view.context");
        new com.coffeemeetsbagel.store.u(context, R.string.subscription_congrats_text, R.string.subscription_congrats_title, R.string.subscription_congrats_cta, R.drawable.confetti, subscriptionVariantsRouter$showCelebrationDialog$cancelListener$1).show();
    }

    public final void q(boolean z10) {
        if (z10) {
            n().show();
        } else {
            n().dismiss();
        }
    }
}
