package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class p implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12555a;

    public /* synthetic */ p(Function1 function1) {
        this.f12555a = function1;
    }

    public final Object apply(Object obj) {
        return LikesYouMatchRepository.F(this.f12555a, obj);
    }
}
