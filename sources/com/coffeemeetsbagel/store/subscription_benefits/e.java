package com.coffeemeetsbagel.store.subscription_benefits;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import b6.j;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.SubscriptionDefaults;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellAnalytics;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellInteractor;
import com.coffeemeetsbagel.store.subscription_benefits.b;
import ub.d;

public final class e extends b6.c<SubscriptionBenefitsRouter, a> {

    public interface a {
        a7.a T();

        SubscriptionRepository Z();

        PremiumUpsellAnalytics c();

        Activity i();
    }

    public interface b extends j<g> {
        Activity i();
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final d f36940a;

        /* renamed from: b  reason: collision with root package name */
        private final Window f36941b;

        /* renamed from: c  reason: collision with root package name */
        private final k f36942c;

        public c(d dVar, Window window, k kVar) {
            kotlin.jvm.internal.j.g(dVar, "binding");
            kotlin.jvm.internal.j.g(window, "window");
            kotlin.jvm.internal.j.g(kVar, "userInteractionListener");
            this.f36940a = dVar;
            this.f36941b = window;
            this.f36942c = kVar;
        }

        public final j a() {
            return new j(this.f36940a, this.f36941b, this.f36942c);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final SubscriptionBenefitsRouter b(ViewGroup viewGroup, PurchaseSource purchaseSource, PremiumUpsellInteractor.a aVar, vb.c cVar) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(purchaseSource, "purchaseSource");
        kotlin.jvm.internal.j.g(aVar, "parentListener");
        kotlin.jvm.internal.j.g(cVar, "bundle");
        Context context = viewGroup.getContext();
        kotlin.jvm.internal.j.f(context, "parentViewGroup.context");
        g gVar = new g(purchaseSource, CollectionsKt___CollectionsKt.x0(new SubscriptionDefaults(context).e().values()), aVar, cVar);
        d c10 = d.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        Window window = ((a) a()).i().getWindow();
        b.a a10 = b.a();
        kotlin.jvm.internal.j.f(window, "window");
        b a11 = a10.c(new c(c10, window, gVar)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a11, "component");
        return new SubscriptionBenefitsRouter(c10, a11, gVar);
    }
}
