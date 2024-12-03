package com.coffeemeetsbagel.feature.sync;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class h implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13441a;

    public /* synthetic */ h(Function1 function1) {
        this.f13441a = function1;
    }

    public final Object apply(Object obj) {
        return SyncBillingUseCase.u(this.f13441a, obj);
    }
}
