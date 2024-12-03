package com.coffeemeetsbagel.store.premium_upsell;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class h implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36893a;

    public /* synthetic */ h(Function1 function1) {
        this.f36893a = function1;
    }

    public final void accept(Object obj) {
        PremiumUpsellAnalytics.d(this.f36893a, obj);
    }
}
