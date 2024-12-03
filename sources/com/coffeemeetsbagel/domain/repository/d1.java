package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class d1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12487a;

    public /* synthetic */ d1(Function1 function1) {
        this.f12487a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.Z(this.f12487a, obj);
    }
}
