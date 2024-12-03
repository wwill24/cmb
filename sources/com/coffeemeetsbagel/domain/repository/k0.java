package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class k0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12530a;

    public /* synthetic */ k0(Function1 function1) {
        this.f12530a = function1;
    }

    public final Object apply(Object obj) {
        return ProfileRepository.m(this.f12530a, obj);
    }
}
