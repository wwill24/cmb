package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.d;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.UpsellErrorDialog;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import kotlin.jvm.internal.j;

public final class w extends u<ViewGroup, d.c, PremiumPreferenceInteractor> {

    /* renamed from: f  reason: collision with root package name */
    private final String f35269f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(String str, ia.d dVar, d.c cVar, PremiumPreferenceInteractor premiumPreferenceInteractor) {
        super(dVar.getRoot(), cVar, premiumPreferenceInteractor);
        j.g(str, "trackingName");
        j.g(dVar, "binding");
        j.g(cVar, "component");
        j.g(premiumPreferenceInteractor, "interactor");
        this.f35269f = str;
    }

    public final String m() {
        return this.f35269f;
    }

    public final void n() {
        UpsellErrorDialog.f36742a.a(((d.c) e()).n());
    }

    public final void o(PurchaseSource purchaseSource) {
        j.g(purchaseSource, "purchaseSource");
        PremiumUpsellComponentActivity.f36846j.b(((d.c) e()).n(), purchaseSource);
    }
}
