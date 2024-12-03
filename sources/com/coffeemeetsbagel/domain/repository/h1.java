package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class h1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12514a;

    public /* synthetic */ h1(Function1 function1) {
        this.f12514a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.d0(this.f12514a, obj);
    }
}
