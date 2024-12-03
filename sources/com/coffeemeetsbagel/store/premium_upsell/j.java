package com.coffeemeetsbagel.store.premium_upsell;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class j implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36895a;

    public /* synthetic */ j(Function1 function1) {
        this.f36895a = function1;
    }

    public final void accept(Object obj) {
        PremiumUpsellAnalytics.f(this.f36895a, obj);
    }
}
