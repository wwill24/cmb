package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class u2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12588a;

    public /* synthetic */ u2(Function1 function1) {
        this.f12588a = function1;
    }

    public final Object apply(Object obj) {
        return UserRepository.A(this.f12588a, obj);
    }
}
