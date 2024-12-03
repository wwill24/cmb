package com.coffeemeetsbagel.discover;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12170a;

    public /* synthetic */ b(Function1 function1) {
        this.f12170a = function1;
    }

    public final Object apply(Object obj) {
        return DiscoverMatchRepository.f(this.f12170a, obj);
    }
}
