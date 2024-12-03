package com.coffeemeetsbagel.school.data;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36362a;

    public /* synthetic */ b(Function1 function1) {
        this.f36362a = function1;
    }

    public final Object apply(Object obj) {
        return SchoolRepository.h(this.f36362a, obj);
    }
}
