package com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.d;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import k6.y;
import kotlin.jvm.internal.j;

public final class n extends u<ViewGroup, d.a, HeightMatchPreferencesImperialInteractor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(y yVar, d.a aVar, HeightMatchPreferencesImperialInteractor heightMatchPreferencesImperialInteractor) {
        super(yVar.getRoot(), aVar, heightMatchPreferencesImperialInteractor);
        j.g(yVar, "binding");
        j.g(aVar, "component");
        j.g(heightMatchPreferencesImperialInteractor, "interactor");
    }

    public final void m(PurchaseSource purchaseSource) {
        j.g(purchaseSource, "purchaseSource");
        PremiumUpsellComponentActivity.f36846j.b(((d.a) e()).a(), purchaseSource);
    }
}
