package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class i0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12521a;

    public /* synthetic */ i0(Function1 function1) {
        this.f12521a = function1;
    }

    public final Object apply(Object obj) {
        return ProfileRepository.q(this.f12521a, obj);
    }
}
