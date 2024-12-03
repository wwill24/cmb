package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class k1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12531a;

    public /* synthetic */ k1(Function1 function1) {
        this.f12531a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.D0(this.f12531a, obj);
    }
}
