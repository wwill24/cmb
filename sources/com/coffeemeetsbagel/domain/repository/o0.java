package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class o0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12552a;

    public /* synthetic */ o0(Function1 function1) {
        this.f12552a = function1;
    }

    public final Object apply(Object obj) {
        return SkuDetailsRepository.l(this.f12552a, obj);
    }
}
