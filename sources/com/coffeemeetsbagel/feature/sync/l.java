package com.coffeemeetsbagel.feature.sync;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class l implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13445a;

    public /* synthetic */ l(Function1 function1) {
        this.f13445a = function1;
    }

    public final Object apply(Object obj) {
        return SyncBillingUseCase.q(this.f13445a, obj);
    }
}
