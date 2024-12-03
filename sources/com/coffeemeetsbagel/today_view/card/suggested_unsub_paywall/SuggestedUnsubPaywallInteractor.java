package com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall;

import b6.s;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.d;
import kotlin.jvm.internal.j;

public final class SuggestedUnsubPaywallInteractor extends s<d, e> implements d.a {

    /* renamed from: f  reason: collision with root package name */
    private final UnsubPaywall f37339f;

    public enum UnsubPaywall {
        NO_LIKES,
        NO_VIEWS
    }

    public SuggestedUnsubPaywallInteractor(UnsubPaywall unsubPaywall) {
        j.g(unsubPaywall, "paywall");
        this.f37339f = unsubPaywall;
    }

    public void k() {
        String str;
        if (this.f37339f == UnsubPaywall.NO_VIEWS) {
            str = "suggested out of bagels";
        } else {
            str = "suggested out of likes";
        }
        ((e) B1()).m(new PurchaseSource(str, "suggested limits empty screen"));
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((d) this.f7875e).l(this.f37339f);
    }
}
