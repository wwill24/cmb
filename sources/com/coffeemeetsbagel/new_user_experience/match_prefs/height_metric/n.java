package com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.d;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import k6.z;
import kotlin.jvm.internal.j;

public final class n extends u<ViewGroup, d.a, HeightMatchPreferencesMetricInteractor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(z zVar, d.a aVar, HeightMatchPreferencesMetricInteractor heightMatchPreferencesMetricInteractor) {
        super(zVar.getRoot(), aVar, heightMatchPreferencesMetricInteractor);
        j.g(zVar, "binding");
        j.g(aVar, "component");
        j.g(heightMatchPreferencesMetricInteractor, "interactor");
    }

    public final void m(PurchaseSource purchaseSource) {
        j.g(purchaseSource, "purchaseSource");
        PremiumUpsellComponentActivity.f36846j.b(((d.a) e()).a(), purchaseSource);
    }
}
