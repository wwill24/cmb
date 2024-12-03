package ic;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor;
import com.coffeemeetsbagel.today_view.main.h;
import qj.q;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f40965a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bagel f40966b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f40967c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f40968d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ q f40969e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ SuggestedUnsubPaywallInteractor.UnsubPaywall f40970f;

    public /* synthetic */ n(h hVar, Bagel bagel, boolean z10, boolean z11, q qVar, SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        this.f40965a = hVar;
        this.f40966b = bagel;
        this.f40967c = z10;
        this.f40968d = z11;
        this.f40969e = qVar;
        this.f40970f = unsubPaywall;
    }

    public final void run() {
        this.f40965a.t(this.f40966b, this.f40967c, this.f40968d, this.f40969e, this.f40970f);
    }
}
