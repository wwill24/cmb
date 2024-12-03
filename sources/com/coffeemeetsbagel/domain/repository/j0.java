package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class j0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12526a;

    public /* synthetic */ j0(Function1 function1) {
        this.f12526a = function1;
    }

    public final Object apply(Object obj) {
        return ProfileRepository.i(this.f12526a, obj);
    }
}
