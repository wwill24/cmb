package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class g1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12507a;

    public /* synthetic */ g1(Function1 function1) {
        this.f12507a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.h0(this.f12507a, obj);
    }
}
