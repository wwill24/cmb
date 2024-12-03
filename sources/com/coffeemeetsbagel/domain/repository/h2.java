package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class h2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12515a;

    public /* synthetic */ h2(Function1 function1) {
        this.f12515a = function1;
    }

    public final Object apply(Object obj) {
        return SuggestedRepository.A(this.f12515a, obj);
    }
}
