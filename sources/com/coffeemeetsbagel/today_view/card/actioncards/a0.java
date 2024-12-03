package com.coffeemeetsbagel.today_view.card.actioncards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.feature.likepassflow.ActivityLikePassFlow;
import com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.preferences.MatchPreferencesComponentActivity;
import com.coffeemeetsbagel.shop.ShopComponentActivity;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.today_view.card.actioncards.b;
import com.coffeemeetsbagel.today_view.today_question.d;
import com.coffeemeetsbagel.today_view.today_question.x;
import com.coffeemeetsbagel.util.RequestCode;
import fc.d;
import fc.k;
import kotlin.jvm.internal.j;
import lc.a;

public final class a0 extends u<ViewGroup, b.a, ActionCardInteractor> {

    /* renamed from: f  reason: collision with root package name */
    private u<?, ?, ?> f37278f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a0(ViewGroup viewGroup, b.a aVar, ActionCardInteractor actionCardInteractor) {
        super(viewGroup, aVar, actionCardInteractor);
        j.g(viewGroup, "view");
        j.g(aVar, "component");
        j.g(actionCardInteractor, "interactor");
    }

    /* access modifiers changed from: private */
    public static final void r(b0 b0Var, a0 a0Var, boolean z10, boolean z11, boolean z12, View view) {
        j.g(b0Var, "$this_apply");
        j.g(a0Var, "this$0");
        b0Var.dismiss();
        ((ActionCardInteractor) a0Var.f()).c3(z10, z11);
        a0Var.w(z10, z12);
    }

    private final void w(boolean z10, boolean z11) {
        Intent intent;
        if (z11) {
            intent = new Intent(((b.a) e()).a(), ProfileCompletionHelperActivity.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("EXTRA_IS_LIKE_FLOW_FIRST", z10);
            intent.putExtras(bundle);
        } else {
            intent = new Intent(((b.a) e()).a(), ActivityLikePassFlow.class);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("EXTRA_IS_LIKE_FLOW_FIRST", z10);
            intent.putExtras(bundle2);
        }
        a.d(((b.a) e()).a(), intent, 2000);
    }

    public final void n() {
        ((b.a) e()).a().X3();
    }

    public final void o() {
        ((b.a) e()).a().B2();
    }

    public final void p() {
        ((b.a) e()).a().C2("end of suggested action card");
    }

    public final void q(boolean z10, boolean z11, boolean z12) {
        ((ViewGroup) l()).removeAllViews();
        k b10 = new d((d.c) e()).b((ViewGroup) l());
        if (b10 != null) {
            a(b10);
            ((ViewGroup) l()).addView(b10.l());
        } else {
            b10 = null;
        }
        this.f37278f = b10;
        b0 b0Var = new b0(((ViewGroup) l()).getContext(), R.string.like_pass_dialog_title, R.string.like_pass_dialog_prompt, R.string.like_pass_dialog_view_profile, false);
        b0Var.b(new z(b0Var, this, z10, z11, z12));
        b0Var.show();
    }

    public final void s() {
        ((b.a) e()).a().D2();
    }

    public final void t(PurchaseSource purchaseSource) {
        j.g(purchaseSource, "purchaseSource");
        PremiumUpsellComponentActivity.a aVar = PremiumUpsellComponentActivity.f36846j;
        ActivityMain a10 = ((b.a) e()).a();
        j.e(a10, "null cannot be cast to non-null type android.app.Activity");
        aVar.b(a10, purchaseSource);
    }

    public final void u() {
        ((ViewGroup) l()).removeAllViews();
        k b10 = new d((d.c) e()).b((ViewGroup) l());
        if (b10 != null) {
            a(b10);
            ((ViewGroup) l()).addView(b10.l());
        } else {
            b10 = null;
        }
        this.f37278f = b10;
    }

    public final void v() {
        ((ViewGroup) l()).removeAllViews();
        b6.j e10 = e();
        j.f(e10, "component");
        com.coffeemeetsbagel.today_view.today_question.d dVar = new com.coffeemeetsbagel.today_view.today_question.d((d.a) e10);
        View l10 = l();
        j.f(l10, "view");
        x b10 = dVar.b((ViewGroup) l10);
        a(b10);
        ((ViewGroup) l()).addView(b10.l());
        this.f37278f = b10;
    }

    public final void x(PurchaseType purchaseType, int i10, Price price, int i11) {
        j.g(purchaseType, ModelDeeplinkData.VALUE_PAGE_BOOST);
        j.g(price, "boostPrice");
        PurchaseType purchaseType2 = purchaseType;
        int i12 = i10;
        Price price2 = price;
        ((b.a) e()).a().startActivityForResult(ShopComponentActivity.U0(((b.a) e()).a(), purchaseType2, i12, price2, (long) i11, new PurchaseSource(ModelDeeplinkData.VALUE_PAGE_SUGGESTED, "end of suggested action card")), RequestCode.BEAN_SHOP);
    }

    public final void y() {
        ((b.a) e()).a().startActivity(MatchPreferencesComponentActivity.f35786j.a(((b.a) e()).a()));
    }
}
