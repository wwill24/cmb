package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class l0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12536a;

    public /* synthetic */ l0(Function1 function1) {
        this.f12536a = function1;
    }

    public final Object apply(Object obj) {
        return ProfileRepository.f(this.f12536a, obj);
    }
}
