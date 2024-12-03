package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class e2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12496a;

    public /* synthetic */ e2(Function1 function1) {
        this.f12496a = function1;
    }

    public final Object apply(Object obj) {
        return SuggestedRepository.H(this.f12496a, obj);
    }
}
