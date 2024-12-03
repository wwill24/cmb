package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class k2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12532a;

    public /* synthetic */ k2(Function1 function1) {
        this.f12532a = function1;
    }

    public final Object apply(Object obj) {
        return SuggestedRepository.D(this.f12532a, obj);
    }
}
