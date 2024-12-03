package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class i implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12520a;

    public /* synthetic */ i(Function1 function1) {
        this.f12520a = function1;
    }

    public final void accept(Object obj) {
        BaseRepository.i(this.f12520a, obj);
    }
}
