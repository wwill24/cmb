package com.coffeemeetsbagel.subscription_dialog.dialog;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.feature.purchase.PurchaseDisplayUtils;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.shop.ShopComponentActivity;
import com.coffeemeetsbagel.store.PurchaseFailureType;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.subscription_dialog.benefits_carousel.a;
import com.coffeemeetsbagel.subscription_dialog.benefits_carousel.h;
import com.coffeemeetsbagel.subscription_dialog.benefits_carousel.i;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import com.coffeemeetsbagel.subscription_dialog.variants_carousel.e;
import com.coffeemeetsbagel.subscription_dialog.variants_carousel.l;
import com.coffeemeetsbagel.subscription_dialog.variants_carousel.m;
import com.coffeemeetsbagel.util.RequestCode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.j;

public final class w extends u<x, e.b, SubscriptionDialogInteractor> {

    /* renamed from: f  reason: collision with root package name */
    private h f37071f;

    /* renamed from: g  reason: collision with root package name */
    private l f37072g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(x xVar, e.b bVar, SubscriptionDialogInteractor subscriptionDialogInteractor) {
        super(xVar, bVar, subscriptionDialogInteractor);
        j.g(xVar, "view");
        j.g(bVar, "component");
        j.g(subscriptionDialogInteractor, "interactor");
    }

    public final void m(ViewGroup viewGroup, SubscriptionBenefitAttribution subscriptionBenefitAttribution) {
        i iVar;
        j.g(viewGroup, "parentViewGroup");
        j.g(subscriptionBenefitAttribution, "topBenefit");
        if (this.f37071f == null) {
            b6.j e10 = e();
            j.f(e10, "component");
            a aVar = new a((a.c) e10);
            Context context = viewGroup.getContext();
            j.f(context, "parentViewGroup.context");
            h b10 = aVar.b(context, subscriptionBenefitAttribution);
            this.f37071f = b10;
            if (b10 != null) {
                iVar = (i) b10.l();
            } else {
                iVar = null;
            }
            viewGroup.addView(iVar);
            a(this.f37071f);
        }
    }

    public final void n(ViewGroup viewGroup) {
        m mVar;
        j.g(viewGroup, "parentLayout");
        if (this.f37072g == null) {
            b6.j e10 = e();
            j.f(e10, "component");
            com.coffeemeetsbagel.subscription_dialog.variants_carousel.e eVar = new com.coffeemeetsbagel.subscription_dialog.variants_carousel.e((e.a) e10);
            Context context = viewGroup.getContext();
            j.f(context, "parentLayout.context");
            l b10 = eVar.b(context);
            this.f37072g = b10;
            if (b10 != null) {
                mVar = (m) b10.l();
            } else {
                mVar = null;
            }
            viewGroup.addView(mVar);
            a(this.f37072g);
        }
    }

    public final void o(PurchaseFailureType purchaseFailureType) {
        View view;
        int errorForFailedPurchase = PurchaseDisplayUtils.getErrorForFailedPurchase(purchaseFailureType);
        if (((e.b) e()).n() instanceof ActivityMain) {
            view = ((e.b) e()).n().getWindow().getDecorView().findViewById(R.id.main_coordinator_layout);
            j.f(view, "{\n            component.…dinator_layout)\n        }");
        } else {
            view = ((e.b) e()).n().getWindow().getDecorView().findViewById(16908290);
            j.f(view, "{\n            component.…d.R.id.content)\n        }");
        }
        sb.a.g(view, errorForFailedPurchase);
    }

    public final void p(PurchaseType purchaseType, Price price) {
        j.g(purchaseType, "purchaseType");
        j.g(price, FirebaseAnalytics.Param.PRICE);
        Intent intent = new Intent(((e.b) e()).n(), ShopComponentActivity.class);
        intent.putExtra(Extra.PURCHASE_TYPE, purchaseType);
        intent.putExtra(Extra.PRICE, price);
        intent.putExtra(Extra.ITEM_COUNT, 1);
        lc.a.d(((e.b) e()).n(), intent, RequestCode.BEAN_SHOP);
    }

    public final void q() {
        CmbLinks.Companion.launchSubscriptionTerms(((e.b) e()).n());
    }

    public final void r(SubscriptionBenefitAttribution subscriptionBenefitAttribution, PurchaseSource purchaseSource, PurchaseType purchaseType, boolean z10, Price price) {
        j.g(subscriptionBenefitAttribution, "topBenefit");
        j.g(purchaseSource, "purchaseSource");
        ((SubscriptionDialogInteractor) f()).i2(subscriptionBenefitAttribution, purchaseSource, purchaseType, z10, price);
    }
}
