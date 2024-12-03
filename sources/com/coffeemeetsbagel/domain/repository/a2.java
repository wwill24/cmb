package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class a2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12470a;

    public /* synthetic */ a2(Function1 function1) {
        this.f12470a = function1;
    }

    public final Object apply(Object obj) {
        return SuggestedRepository.J(this.f12470a, obj);
    }
}
