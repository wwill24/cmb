package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class z2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12628a;

    public /* synthetic */ z2(Function1 function1) {
        this.f12628a = function1;
    }

    public final Object apply(Object obj) {
        return UserRepository.y(this.f12628a, obj);
    }
}
