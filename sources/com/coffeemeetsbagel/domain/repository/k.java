package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class k implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12529a;

    public /* synthetic */ k(Function1 function1) {
        this.f12529a = function1;
    }

    public final Object apply(Object obj) {
        return BaseRepository$getRepository$1.f(this.f12529a, obj);
    }
}
