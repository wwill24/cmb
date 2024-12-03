package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class i2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12524a;

    public /* synthetic */ i2(Function1 function1) {
        this.f12524a = function1;
    }

    public final Object apply(Object obj) {
        return SuggestedRepository.B(this.f12524a, obj);
    }
}
