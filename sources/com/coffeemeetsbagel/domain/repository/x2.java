package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class x2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12600a;

    public /* synthetic */ x2(Function1 function1) {
        this.f12600a = function1;
    }

    public final Object apply(Object obj) {
        return UserRepository.q(this.f12600a, obj);
    }
}
