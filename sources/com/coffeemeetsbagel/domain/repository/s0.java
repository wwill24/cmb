package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class s0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12571a;

    public /* synthetic */ s0(Function1 function1) {
        this.f12571a = function1;
    }

    public final Object apply(Object obj) {
        return SubscriptionRepository.U(this.f12571a, obj);
    }
}
