package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12472a;

    public /* synthetic */ b(Function1 function1) {
        this.f12472a = function1;
    }

    public final Object apply(Object obj) {
        return ActionCardRepository.m(this.f12472a, obj);
    }
}
