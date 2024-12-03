package ec;

import b6.s;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor;
import kotlin.jvm.internal.j;
import qj.q;

public final class f extends s<h, i> {

    /* renamed from: f  reason: collision with root package name */
    private final boolean f40674f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f40675g;

    /* renamed from: h  reason: collision with root package name */
    private final q<Boolean> f40676h;

    /* renamed from: j  reason: collision with root package name */
    private final SuggestedUnsubPaywallInteractor.UnsubPaywall f40677j;

    /* renamed from: k  reason: collision with root package name */
    public ProfileContract$Manager f40678k;

    public f(boolean z10, boolean z11, q<Boolean> qVar, SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        j.g(qVar, "canShowDialog");
        this.f40674f = z10;
        this.f40675g = z11;
        this.f40676h = qVar;
        this.f40677j = unsubPaywall;
    }

    public final ProfileContract$Manager H1() {
        ProfileContract$Manager profileContract$Manager = this.f40678k;
        if (profileContract$Manager != null) {
            return profileContract$Manager;
        }
        j.y("profileManager");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall = this.f40677j;
        SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall2 = SuggestedUnsubPaywallInteractor.UnsubPaywall.NO_LIKES;
        if (unsubPaywall == unsubPaywall2) {
            ((i) B1()).q(unsubPaywall2);
            return;
        }
        SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall3 = SuggestedUnsubPaywallInteractor.UnsubPaywall.NO_VIEWS;
        if (unsubPaywall == unsubPaywall3) {
            ((i) B1()).q(unsubPaywall3);
            return;
        }
        NetworkProfile j10 = H1().j();
        j.d(j10);
        if (j10.isOnHold()) {
            ((i) B1()).p();
        } else {
            ((i) B1()).n(this.f40674f, this.f40675g, this.f40676h);
        }
    }
}
