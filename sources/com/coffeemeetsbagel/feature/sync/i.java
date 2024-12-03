package com.coffeemeetsbagel.feature.sync;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class i implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13442a;

    public /* synthetic */ i(Function1 function1) {
        this.f13442a = function1;
    }

    public final Object apply(Object obj) {
        return SyncBillingUseCase.v(this.f13442a, obj);
    }
}
