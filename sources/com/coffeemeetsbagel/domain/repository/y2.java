package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class y2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12613a;

    public /* synthetic */ y2(Function1 function1) {
        this.f12613a = function1;
    }

    public final Object apply(Object obj) {
        return UserRepository.s(this.f12613a, obj);
    }
}
