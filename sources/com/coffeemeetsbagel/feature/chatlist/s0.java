package com.coffeemeetsbagel.feature.chatlist;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class s0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12975a;

    public /* synthetic */ s0(Function1 function1) {
        this.f12975a = function1;
    }

    public final Object apply(Object obj) {
        return GetBagelConnectionUseCase.j(this.f12975a, obj);
    }
}
