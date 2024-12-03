package ic;

import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor;
import com.coffeemeetsbagel.today_view.main.h;
import qj.q;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f40960a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f40961b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f40962c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ q f40963d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SuggestedUnsubPaywallInteractor.UnsubPaywall f40964e;

    public /* synthetic */ m(h hVar, boolean z10, boolean z11, q qVar, SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        this.f40960a = hVar;
        this.f40961b = z10;
        this.f40962c = z11;
        this.f40963d = qVar;
        this.f40964e = unsubPaywall;
    }

    public final void run() {
        this.f40960a.r(this.f40961b, this.f40962c, this.f40963d, this.f40964e);
    }
}
