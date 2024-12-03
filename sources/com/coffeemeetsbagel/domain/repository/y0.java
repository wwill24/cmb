package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class y0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12604a;

    public /* synthetic */ y0(Function1 function1) {
        this.f12604a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.j0(this.f12604a, obj);
    }
}
