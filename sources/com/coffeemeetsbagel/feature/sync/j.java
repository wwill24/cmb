package com.coffeemeetsbagel.feature.sync;

import kotlin.jvm.functions.Function1;

public final /* synthetic */ class j implements vj.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13443a;

    public /* synthetic */ j(Function1 function1) {
        this.f13443a = function1;
    }

    public final Object apply(Object obj) {
        return SyncBillingUseCase.w(this.f13443a, obj);
    }
}
