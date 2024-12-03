package com.coffeemeetsbagel.profile;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class g implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36091a;

    public /* synthetic */ g(Function1 function1) {
        this.f36091a = function1;
    }

    public final Object apply(Object obj) {
        return GetProfileAvatarUseCase.c(this.f36091a, obj);
    }
}
