package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class r1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12567a;

    public /* synthetic */ r1(Function1 function1) {
        this.f12567a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository$getActiveSubscription$1.d(this.f12567a, obj);
    }
}
