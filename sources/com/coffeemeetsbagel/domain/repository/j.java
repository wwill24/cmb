package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;

public final /* synthetic */ class j implements vj.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12525a;

    public /* synthetic */ j(Function1 function1) {
        this.f12525a = function1;
    }

    public final Object apply(Object obj) {
        return BaseRepository$getRepository$1.e(this.f12525a, obj);
    }
}
