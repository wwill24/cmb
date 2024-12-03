package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class c0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12479a;

    public /* synthetic */ c0(Function1 function1) {
        this.f12479a = function1;
    }

    public final Object apply(Object obj) {
        return PhotoRepository.g(this.f12479a, obj);
    }
}
