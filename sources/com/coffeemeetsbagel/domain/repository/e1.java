package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class e1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12495a;

    public /* synthetic */ e1(Function1 function1) {
        this.f12495a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.p0(this.f12495a, obj);
    }
}
