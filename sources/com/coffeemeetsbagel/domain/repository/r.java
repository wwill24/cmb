package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class r implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12563a;

    public /* synthetic */ r(Function1 function1) {
        this.f12563a = function1;
    }

    public final Object apply(Object obj) {
        return LikesYouMatchRepository.K(this.f12563a, obj);
    }
}
