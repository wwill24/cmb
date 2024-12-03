package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class f implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12499a;

    public /* synthetic */ f(Function1 function1) {
        this.f12499a = function1;
    }

    public final Object apply(Object obj) {
        return BaseRepository.k(this.f12499a, obj);
    }
}
