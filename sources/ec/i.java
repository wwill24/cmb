package ec;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.today_view.card.actioncards.b;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.b;
import dc.d;
import ec.d;
import kotlin.jvm.internal.j;
import qj.q;

public final class i extends u<ViewGroup, d.b, f> {

    /* renamed from: f  reason: collision with root package name */
    private final ViewGroup f40679f;

    /* renamed from: g  reason: collision with root package name */
    private u<?, ?, ?> f40680g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(ViewGroup viewGroup, d.b bVar, f fVar, ViewGroup viewGroup2) {
        super(viewGroup, bVar, fVar);
        j.g(viewGroup, "view");
        j.g(bVar, "component");
        j.g(fVar, "interactor");
        j.g(viewGroup2, "parentViewGroup");
        this.f40679f = viewGroup2;
    }

    private final void m() {
        u uVar = this.f40680g;
        if (uVar != null) {
            ((ViewGroup) l()).removeView(uVar.l());
            b(uVar);
        }
    }

    private final void o() {
        u uVar = this.f40680g;
        if (uVar != null) {
            ((ViewGroup) l()).addView(uVar.l());
            a(uVar);
        }
    }

    public final void n(boolean z10, boolean z11, q<Boolean> qVar) {
        j.g(qVar, "isVisible");
        m();
        b6.j e10 = e();
        j.f(e10, "component");
        this.f40680g = new b((b.c) e10).b(this.f40679f, z10, z11, qVar);
        o();
    }

    public final void p() {
        m();
        dc.j b10 = new dc.d((d.c) e()).b(this.f40679f);
        j.d(b10);
        this.f40680g = b10;
        o();
    }

    public final void q(SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        j.g(unsubPaywall, "paywall");
        m();
        b6.j e10 = e();
        j.f(e10, "component");
        this.f40680g = new com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.b((b.a) e10).b(this.f40679f, unsubPaywall);
        o();
    }
}
