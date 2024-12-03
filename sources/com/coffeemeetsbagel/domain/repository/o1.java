package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class o1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12553a;

    public /* synthetic */ o1(Function1 function1) {
        this.f12553a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.s0(this.f12553a, obj);
    }
}
