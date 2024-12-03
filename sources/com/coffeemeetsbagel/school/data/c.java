package com.coffeemeetsbagel.school.data;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class c implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36363a;

    public /* synthetic */ c(Function1 function1) {
        this.f36363a = function1;
    }

    public final Object apply(Object obj) {
        return SchoolRepository.i(this.f36363a, obj);
    }
}
