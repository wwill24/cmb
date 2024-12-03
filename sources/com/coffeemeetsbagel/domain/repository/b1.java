package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class b1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12474a;

    public /* synthetic */ b1(Function1 function1) {
        this.f12474a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.w0(this.f12474a, obj);
    }
}
