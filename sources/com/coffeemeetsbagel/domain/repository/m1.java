package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class m1 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12543a;

    public /* synthetic */ m1(Function1 function1) {
        this.f12543a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.G0(this.f12543a, obj);
    }
}
