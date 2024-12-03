package com.coffeemeetsbagel.store.subscription_benefits;

import android.view.View;
import b6.u;
import com.coffeemeetsbagel.store.subscription_benefits.e;
import gk.f;
import kotlin.jvm.internal.j;
import ub.d;

public final class SubscriptionBenefitsRouter extends u<View, e.b, g> {

    /* renamed from: f  reason: collision with root package name */
    private final f f36932f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionBenefitsRouter(d dVar, e.b bVar, g gVar) {
        super(dVar.getRoot(), bVar, gVar);
        j.g(dVar, "view");
        j.g(bVar, "component");
        j.g(gVar, "interactor");
        this.f36932f = b.b(new SubscriptionBenefitsRouter$loadingProgressBar$2(bVar));
    }
}
