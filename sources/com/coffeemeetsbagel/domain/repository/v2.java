package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class v2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12592a;

    public /* synthetic */ v2(Function1 function1) {
        this.f12592a = function1;
    }

    public final Object apply(Object obj) {
        return UserRepository.C(this.f12592a, obj);
    }
}
