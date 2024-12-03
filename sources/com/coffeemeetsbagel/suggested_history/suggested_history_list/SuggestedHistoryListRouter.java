package com.coffeemeetsbagel.suggested_history.suggested_history_list;

import android.view.View;
import android.widget.FrameLayout;
import b6.u;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.suggested_history.suggested_history_list.f;
import com.coffeemeetsbagel.upsell_banner.g;
import com.coffeemeetsbagel.upsell_banner.i;
import com.coffeemeetsbagel.upsell_banner.n;
import kotlin.jvm.internal.j;
import zb.a;

public final class SuggestedHistoryListRouter extends u<View, f.b, SuggestedHistoryListInteractor> {

    /* renamed from: f  reason: collision with root package name */
    private final gk.f f37149f = b.b(new SuggestedHistoryListRouter$bannerContainer$2(this));

    /* renamed from: g  reason: collision with root package name */
    private n f37150g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestedHistoryListRouter(a aVar, f.b bVar, SuggestedHistoryListInteractor suggestedHistoryListInteractor) {
        super(aVar.getRoot(), bVar, suggestedHistoryListInteractor);
        j.g(aVar, "view");
        j.g(bVar, "component");
        j.g(suggestedHistoryListInteractor, "interactor");
    }

    private final FrameLayout m() {
        return (FrameLayout) this.f37149f.getValue();
    }

    public final void n(PurchaseSource purchaseSource) {
        j.g(purchaseSource, "purchaseSource");
        PremiumUpsellComponentActivity.f36846j.b(((f.b) e()).a(), purchaseSource);
    }

    public final void o() {
        n nVar = this.f37150g;
        if (nVar != null) {
            b(nVar);
            m().removeAllViews();
        }
    }

    public final void p(boolean z10, String str, int i10, i.a aVar) {
        View view;
        String str2 = str;
        j.g(str, "ctaText");
        j.g(aVar, "listener");
        if (this.f37150g == null) {
            b6.j e10 = e();
            j.f(e10, "component");
            g gVar = new g((g.c) e10);
            FrameLayout m10 = m();
            j.f(m10, "bannerContainer");
            String string = ((f.b) e()).a().getString(i10);
            j.f(string, "component.componentActiv…().getString(description)");
            this.f37150g = g.c(gVar, m10, (kc.a) null, aVar, z10, str, string, "suggested history", 2, (Object) null);
        }
        a(this.f37150g);
        FrameLayout m11 = m();
        j.f(m11, "bannerContainer");
        n nVar = this.f37150g;
        if (nVar != null) {
            view = nVar.l();
        } else {
            view = null;
        }
        o.b(m11, view);
    }
}
