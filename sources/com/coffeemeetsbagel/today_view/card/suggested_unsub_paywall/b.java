package com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.d;
import k6.b0;

public final class b extends b6.c<e, a> {

    public interface a {
        ActivityMain a();
    }

    /* renamed from: com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.b$b  reason: collision with other inner class name */
    public interface C0466b extends j<SuggestedUnsubPaywallInteractor> {
        ActivityMain a();
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final b0 f37348a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f37349b;

        public c(b0 b0Var, d.a aVar) {
            kotlin.jvm.internal.j.g(b0Var, "binding");
            kotlin.jvm.internal.j.g(aVar, "listener");
            this.f37348a = b0Var;
            this.f37349b = aVar;
        }

        public final d a() {
            return new d(this.f37348a, this.f37349b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final e b(ViewGroup viewGroup, SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(unsubPaywall, "paywall");
        SuggestedUnsubPaywallInteractor suggestedUnsubPaywallInteractor = new SuggestedUnsubPaywallInteractor(unsubPaywall);
        b0 c10 = b0.c(LayoutInflater.from(((a) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        C0466b a10 = a.a().c(new c(c10, suggestedUnsubPaywallInteractor)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new e(c10, a10, suggestedUnsubPaywallInteractor);
    }
}
