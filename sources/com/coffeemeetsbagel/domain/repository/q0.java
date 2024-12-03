package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class q0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12560a;

    public /* synthetic */ q0(Function1 function1) {
        this.f12560a = function1;
    }

    public final Object apply(Object obj) {
        return SkuDetailsRepository.n(this.f12560a, obj);
    }
}
