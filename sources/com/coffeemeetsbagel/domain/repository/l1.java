package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class l1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12537a;

    public /* synthetic */ l1(Function1 function1) {
        this.f12537a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.F0(this.f12537a, obj);
    }
}
