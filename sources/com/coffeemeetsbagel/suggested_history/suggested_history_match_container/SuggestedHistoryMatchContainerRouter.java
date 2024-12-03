package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import b6.d;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.hidereport.main.HideReportComponentActivity;
import com.coffeemeetsbagel.like_pass.view.CustomFabLikeButton;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.coffeemeetsbagel.match_view.MatchViewInteractor;
import com.coffeemeetsbagel.match_view.m;
import com.coffeemeetsbagel.match_view.u0;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.shop.ShopComponentActivity;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.suggested_history.suggested_history_match_container.e;
import com.coffeemeetsbagel.util.RequestCode;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import qj.q;
import sb.a;
import zb.b;

public final class SuggestedHistoryMatchContainerRouter extends u<View, e.b, SuggestedHistoryMatchContainerInteractor> {

    /* renamed from: f  reason: collision with root package name */
    private final b f37190f;

    /* renamed from: g  reason: collision with root package name */
    private final d<?, ?> f37191g;

    /* renamed from: h  reason: collision with root package name */
    private u0 f37192h;

    /* renamed from: i  reason: collision with root package name */
    private final FrameLayout f37193i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestedHistoryMatchContainerRouter(b bVar, e.b bVar2, SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor) {
        super(bVar.getRoot(), bVar2, suggestedHistoryMatchContainerInteractor);
        j.g(bVar, "binding");
        j.g(bVar2, "component");
        j.g(suggestedHistoryMatchContainerInteractor, "interactor");
        this.f37190f = bVar;
        d<?, ?> a10 = bVar2.a();
        this.f37191g = a10;
        View findViewById = a10.findViewById(R.id.main_content);
        j.f(findViewById, "activity.findViewById(R.id.main_content)");
        this.f37193i = (FrameLayout) findViewById;
    }

    public final void m() {
        Balloon a10 = new Balloon.a(((e.b) e()).n()).m1(((e.b) e()).n()).c1(BalloonAnimation.ELASTIC).E1(R.string.suggested_history_rewind_tooltip).B1(R.color.dark_gray).F1(14.0f).C1(8388611).G1(1.0f).d1(12.0f).o1(R.dimen.baseline_2x).n1(R.dimen.baseline_1x).y1(R.dimen.baseline_2x).b1(R.color.white).k1(true).Z0(10).X0(0.5f).Y0(ArrowPositionRules.ALIGN_BALLOON).u1(R.color.black).s1(new SuggestedHistoryMatchContainerRouter$buildUnlockedRewindsTooltip$1(this)).t1(new SuggestedHistoryMatchContainerRouter$buildUnlockedRewindsTooltip$2(this)).a();
        CustomFabLikeButton customFabLikeButton = this.f37190f.f42233e;
        j.f(customFabLikeButton, "binding.buttonRewind");
        Balloon.G0(a10, customFabLikeButton, 0, 0, 6, (Object) null);
    }

    public final void n() {
        ((e.b) e()).a().onBackPressed();
    }

    public final void o() {
        PremiumUpsellComponentActivity.f36846j.b(((e.b) e()).n(), new PurchaseSource("suggested history", "suggested history"));
    }

    public final void p(PurchaseType purchaseType, int i10, Price price, int i11) {
        Intent intent = new Intent(((e.b) e()).n(), ShopComponentActivity.class);
        intent.putExtra(Extra.PURCHASE_TYPE, purchaseType);
        intent.putExtra(Extra.ITEM_COUNT, i10);
        intent.putExtra(Extra.PRICE, price);
        intent.putExtra(Extra.EXPECTED_PRICE, i11);
        ((e.b) e()).n().startActivityForResult(intent, RequestCode.BEAN_SHOP);
    }

    public final void q(String str, String str2, boolean z10, boolean z11) {
        j.g(str, "bagelId");
        j.g(str2, "profileId");
        HideReportComponentActivity.f13953j.a(((e.b) e()).n(), str2, str, z11, z10, "suggested_history_profile", Extra.BAGEL);
    }

    public final void r() {
        u0 u0Var = this.f37192h;
        if (u0Var == null) {
            j.y("currentChildRouter");
            u0Var = null;
        }
        u0Var.n();
    }

    public final void s(d dVar, Bagel bagel) {
        d dVar2 = dVar;
        Bagel bagel2 = bagel;
        j.g(dVar2, "parentListener");
        j.g(bagel2, Extra.BAGEL);
        ((e.b) e()).n().getResources();
        DialogPrimarySecondaryVertical.a.c(DialogPrimarySecondaryVertical.f12065a, ((e.b) e()).n(), (DialogPrimarySecondaryVertical.PrimaryCtaStyle) null, (Integer) null, R.string.its_a_match, R.string.you_liked_each_other, R.string.start_chatting, new SuggestedHistoryMatchContainerRouter$showConnectionDialog$1(dVar2, bagel2), Integer.valueOf(R.string.not_now), (Function0) null, (Function0) null, 774, (Object) null);
    }

    public final void t() {
        u0 u0Var = this.f37192h;
        if (u0Var == null) {
            j.y("currentChildRouter");
            u0Var = null;
        }
        u0Var.p();
    }

    public final void u(boolean z10) {
        u0 u0Var = this.f37192h;
        if (u0Var == null) {
            j.y("currentChildRouter");
            u0Var = null;
        }
        u0Var.q(z10);
    }

    public final void v(String str, MatchViewInteractor.b bVar, q<Boolean> qVar, int i10, boolean z10, boolean z11, String str2, MatchIdAttribution matchIdAttribution) {
        MatchIdAttribution matchIdAttribution2 = matchIdAttribution;
        j.g(str, "profileId");
        j.g(bVar, "listener");
        j.g(qVar, "matchIsSeen");
        m mVar = r2;
        b6.j e10 = e();
        j.f(e10, "component");
        m mVar2 = new m((m.c) e10);
        FrameLayout frameLayout = this.f37193i;
        Integer valueOf = Integer.valueOf(i10);
        u0 c10 = m.c(mVar, frameLayout, true, valueOf, z10, matchIdAttribution2, str, z11, "suggested history", true, bVar, qVar, 0, 0, false, str2, (String) null, 47104, (Object) null);
        this.f37192h = c10;
        this.f37193i.addView(c10.l());
        a(c10);
    }

    public final void w(int i10) {
        View view;
        if (((e.b) e()).n() instanceof ActivityMain) {
            view = ((e.b) e()).n().getWindow().getDecorView().findViewById(R.id.main_coordinator_layout);
            j.f(view, "{\n            component.…dinator_layout)\n        }");
        } else {
            view = ((e.b) e()).n().getWindow().getDecorView().findViewById(16908290);
            j.f(view, "{\n            component.…d.R.id.content)\n        }");
        }
        a.l(view, i10, 6000);
    }
}
