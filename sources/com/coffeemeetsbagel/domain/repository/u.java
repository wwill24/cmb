package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class u implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12585a;

    public /* synthetic */ u(Function1 function1) {
        this.f12585a = function1;
    }

    public final Object apply(Object obj) {
        return LikesYouMatchRepository.t(this.f12585a, obj);
    }
}
