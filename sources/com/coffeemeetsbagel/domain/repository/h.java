package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class h implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12512a;

    public /* synthetic */ h(Function1 function1) {
        this.f12512a = function1;
    }

    public final Object apply(Object obj) {
        return BaseRepository.h(this.f12512a, obj);
    }
}
