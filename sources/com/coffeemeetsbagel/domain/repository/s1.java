package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class s1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12572a;

    public /* synthetic */ s1(Function1 function1) {
        this.f12572a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository$getHighestTierSubscriptionBundleByIntent$1.d(this.f12572a, obj);
    }
}
