package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class f1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12502a;

    public /* synthetic */ f1(Function1 function1) {
        this.f12502a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.b0(this.f12502a, obj);
    }
}
