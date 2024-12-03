package com.coffeemeetsbagel.feature.sync;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class k implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13444a;

    public /* synthetic */ k(Function1 function1) {
        this.f13444a = function1;
    }

    public final Object apply(Object obj) {
        return SyncBillingUseCase.D(this.f13444a, obj);
    }
}
