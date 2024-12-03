package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class c1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12480a;

    public /* synthetic */ c1(Function1 function1) {
        this.f12480a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.o0(this.f12480a, obj);
    }
}
