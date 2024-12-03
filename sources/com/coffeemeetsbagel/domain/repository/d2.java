package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class d2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12488a;

    public /* synthetic */ d2(Function1 function1) {
        this.f12488a = function1;
    }

    public final Object apply(Object obj) {
        return SuggestedRepository.M(this.f12488a, obj);
    }
}
