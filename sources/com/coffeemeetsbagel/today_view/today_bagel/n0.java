package com.coffeemeetsbagel.today_view.today_bagel;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import b6.r;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.hidereport.main.HideReportComponentActivity;
import com.coffeemeetsbagel.instant_like.f;
import com.coffeemeetsbagel.instant_like.y;
import com.coffeemeetsbagel.like_pass.view.MatchActionType;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.coffeemeetsbagel.match_view.MatchViewInteractor;
import com.coffeemeetsbagel.match_view.m;
import com.coffeemeetsbagel.match_view.u0;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.dto.MatchContext;
import com.coffeemeetsbagel.shop.ShopComponentActivity;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import com.coffeemeetsbagel.subscription_dialog.dialog.w;
import com.coffeemeetsbagel.today_view.today_bagel.e;
import com.coffeemeetsbagel.util.RequestCode;
import fa.a;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import qj.q;

public final class n0 extends u<ViewGroup, e.b, SuggestedMatchContainerInteractor> {

    /* renamed from: k  reason: collision with root package name */
    public static final a f37468k = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private final ViewGroup f37469f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f37470g = n0.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    private u<?, ?, ?> f37471h;

    /* renamed from: i  reason: collision with root package name */
    private w f37472i;

    /* renamed from: j  reason: collision with root package name */
    private String f37473j;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements y {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n0 f37474a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f37475b;

        b(n0 n0Var, boolean z10) {
            this.f37474a = n0Var;
            this.f37475b = z10;
        }

        public void a() {
            a.C0491a aVar = fa.a.f40771d;
            String m10 = this.f37474a.f37470g;
            j.f(m10, "tag");
            aVar.a(m10, "onInstantLikePurchaseFailed");
            ((SuggestedMatchContainerInteractor) this.f37474a.f()).E3(this.f37475b);
        }

        public void b() {
            ((SuggestedMatchContainerInteractor) this.f37474a.f()).G3(true);
        }

        public void c() {
            a.C0491a aVar = fa.a.f40771d;
            String m10 = this.f37474a.f37470g;
            j.f(m10, "tag");
            aVar.a(m10, "onInstantLikePurchased or Spent");
            ((SuggestedMatchContainerInteractor) this.f37474a.f()).D3();
        }

        public void h() {
            ((SuggestedMatchContainerInteractor) this.f37474a.f()).h();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n0(ViewGroup viewGroup, e.b bVar, SuggestedMatchContainerInteractor suggestedMatchContainerInteractor, ViewGroup viewGroup2) {
        super(viewGroup, bVar, suggestedMatchContainerInteractor);
        j.g(viewGroup, "view");
        j.g(bVar, "component");
        j.g(suggestedMatchContainerInteractor, "interactor");
        j.g(viewGroup2, "parentViewGroup");
        this.f37469f = viewGroup2;
    }

    private final void A() {
        if (this.f37471h != null) {
            u uVar = this.f37471h;
            j.d(uVar);
            ((ViewGroup) l()).addView(uVar.l());
            a(this.f37471h);
        }
    }

    public static /* synthetic */ void G(n0 n0Var, List list, Long l10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        n0Var.F(list, l10);
    }

    private final void x() {
        if (this.f37471h != null) {
            u uVar = this.f37471h;
            j.d(uVar);
            ((ViewGroup) l()).removeView(uVar.l());
            b(this.f37471h);
        }
    }

    public final void B(String str, String str2, boolean z10, boolean z11) {
        j.g(str, "bagelId");
        j.g(str2, "profileId");
        HideReportComponentActivity.f13953j.a(((e.b) e()).n(), str2, str, z11, z10, "suggested_profile", Extra.BAGEL);
    }

    public final void C(PurchaseSource purchaseSource) {
        j.g(purchaseSource, "purchaseSource");
        PremiumUpsellComponentActivity.f36846j.b(((e.b) e()).n(), purchaseSource);
    }

    public final void D(Bagel bagel, MatchViewInteractor.b bVar, q<Boolean> qVar) {
        boolean z10;
        Bagel bagel2 = bagel;
        j.g(bagel2, Extra.BAGEL);
        j.g(bVar, "listener");
        j.g(qVar, "matchIsSeen");
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f37470g;
        j.f(str, "tag");
        aVar.a(str, "showBagel " + bagel2);
        x();
        String id2 = bagel.getId();
        j.f(id2, "bagel.id");
        String profileId = bagel.getProfileId();
        j.f(profileId, "bagel.profileId");
        MatchIdAttribution matchIdAttribution = new MatchIdAttribution(id2, profileId, bagel.getPurchaseAttributionValue());
        String str2 = this.f37470g;
        j.f(str2, "tag");
        aVar.a(str2, "\tmatchIdAttribution " + matchIdAttribution);
        b6.j e10 = e();
        j.f(e10, "component");
        m mVar = new m((m.c) e10);
        ViewGroup viewGroup = this.f37469f;
        Integer valueOf = Integer.valueOf(bagel.getAction());
        boolean isConnected = bagel.isConnected();
        String profileId2 = bagel.getProfileId();
        j.f(profileId2, "bagel.profileId");
        if (bagel.getPairAction() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f37471h = m.c(mVar, viewGroup, true, valueOf, isConnected, matchIdAttribution, profileId2, z10, "today's bagel", false, bVar, qVar, bagel.getPairTotalWoos(), bagel.getTotalWoosSeen(), false, bagel.getPairLikeComment(), (String) null, 40960, (Object) null);
        this.f37473j = bagel.getId();
        A();
    }

    public final void E() {
        u<?, ?, ?> uVar = this.f37471h;
        if (uVar instanceof u0) {
            j.e(uVar, "null cannot be cast to non-null type com.coffeemeetsbagel.match_view.MatchViewRouter");
            ((u0) uVar).n();
        }
    }

    public final void F(List<? extends MatchActionType> list, Long l10) {
        j.g(list, "fabs");
        ((e.b) e()).K0().H4(list, Boolean.TRUE, l10);
    }

    public final void H() {
        u<?, ?, ?> uVar = this.f37471h;
        if (uVar instanceof u0) {
            j.e(uVar, "null cannot be cast to non-null type com.coffeemeetsbagel.match_view.MatchViewRouter");
            ((u0) uVar).p();
        }
    }

    public final void I(String str, boolean z10) {
        j.g(str, "matchId");
        b bVar = new b(this, z10);
        b6.j e10 = e();
        j.f(e10, "component");
        f fVar = new f((f.c) e10);
        View l10 = l();
        j.f(l10, "view");
        a(fVar.b((ViewGroup) l10, bVar, str, z10));
    }

    public final void J() {
        u<?, ?, ?> uVar = this.f37471h;
        if (uVar instanceof u0) {
            j.e(uVar, "null cannot be cast to non-null type com.coffeemeetsbagel.match_view.MatchViewRouter");
            ((u0) uVar).s();
        }
    }

    public final void K() {
        u<?, ?, ?> uVar = this.f37471h;
        if (uVar instanceof u0) {
            j.e(uVar, "null cannot be cast to non-null type com.coffeemeetsbagel.match_view.MatchViewRouter");
            ((u0) uVar).t(true);
        }
    }

    public final void L(MatchContext matchContext) {
        j.g(matchContext, "matchContext");
        u<?, ?, ?> uVar = this.f37471h;
        if (uVar instanceof u0) {
            j.e(uVar, "null cannot be cast to non-null type com.coffeemeetsbagel.match_view.MatchViewRouter");
            ((MatchViewInteractor) ((u0) uVar).f()).a3(matchContext);
        }
    }

    public final void M() {
        u<?, ?, ?> uVar = this.f37471h;
        if (uVar instanceof u0) {
            j.e(uVar, "null cannot be cast to non-null type com.coffeemeetsbagel.match_view.MatchViewRouter");
            ((u0) uVar).u();
        }
    }

    public final void N(PurchaseSource purchaseSource, PurchaseType purchaseType, Price price, com.coffeemeetsbagel.subscription_dialog.dialog.y yVar) {
        j.g(yVar, "subscriptionResultCallback");
        if (this.f37472i == null) {
            b6.j e10 = e();
            j.f(e10, "component");
            w b10 = new com.coffeemeetsbagel.subscription_dialog.dialog.e((e.a) e10).b(((e.b) e()).n(), yVar);
            this.f37472i = b10;
            r.a(b10);
        }
        SubscriptionBenefitAttribution.a aVar = SubscriptionBenefitAttribution.f36723a;
        j.d(purchaseSource);
        SubscriptionBenefitAttribution a10 = aVar.a(purchaseSource);
        w wVar = this.f37472i;
        j.d(wVar);
        wVar.r(a10, purchaseSource, purchaseType, true, price);
    }

    public final void O(int i10) {
        View view;
        if (((e.b) e()).n() instanceof ActivityMain) {
            view = ((e.b) e()).n().getWindow().getDecorView().findViewById(R.id.main_coordinator_layout);
            j.f(view, "{\n            component.…dinator_layout)\n        }");
        } else {
            view = ((e.b) e()).n().getWindow().getDecorView().findViewById(16908290);
            j.f(view, "{\n            component.…d.R.id.content)\n        }");
        }
        sb.a.l(view, i10, 6000);
    }

    public final void P(int i10) {
        u<?, ?, ?> uVar = this.f37471h;
        if (uVar instanceof u0) {
            j.e(uVar, "null cannot be cast to non-null type com.coffeemeetsbagel.match_view.MatchViewRouter");
            ((u0) uVar).w(i10);
        }
    }

    public final String n() {
        return this.f37473j;
    }

    public final void o() {
        ((SuggestedMatchContainerInteractor) f()).d4();
    }

    public final void p() {
        ((SuggestedMatchContainerInteractor) f()).A3();
    }

    public final void q() {
        ((SuggestedMatchContainerInteractor) f()).B3();
    }

    public final void r() {
        ((SuggestedMatchContainerInteractor) f()).C3();
    }

    public final void s() {
        ((SuggestedMatchContainerInteractor) f()).y();
    }

    public final void t() {
        ((SuggestedMatchContainerInteractor) f()).a0();
    }

    public final void u() {
        ((SuggestedMatchContainerInteractor) f()).B0();
    }

    public final void v() {
        fa.a.f40771d.a("TodayBagelRouter", "onTabSelected");
        ((SuggestedMatchContainerInteractor) f()).d4();
        ((e.b) e()).K0().D4();
    }

    public final void w() {
    }

    public final void y(PurchaseType purchaseType, int i10, Price price, int i11) {
        Intent intent = new Intent(((e.b) e()).n(), ShopComponentActivity.class);
        intent.putExtra(Extra.PURCHASE_TYPE, purchaseType);
        intent.putExtra(Extra.ITEM_COUNT, i10);
        intent.putExtra(Extra.PRICE, price);
        intent.putExtra(Extra.EXPECTED_PRICE, i11);
        ((e.b) e()).n().startActivityForResult(intent, RequestCode.BEAN_SHOP);
    }

    public final void z(Bagel bagel) {
        Intent intent = new Intent(((e.b) e()).n(), ChatActivity.class);
        intent.putExtra(Extra.BAGEL, bagel);
        ((e.b) e()).n().startActivityForResult(intent, RequestCode.CHAT);
    }
}
