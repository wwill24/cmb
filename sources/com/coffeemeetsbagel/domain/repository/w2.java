package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class w2 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12596a;

    public /* synthetic */ w2(Function1 function1) {
        this.f12596a = function1;
    }

    public final Object apply(Object obj) {
        return UserRepository.n(this.f12596a, obj);
    }
}
