package com.coffeemeetsbagel.feature.sync;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class n implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13447a;

    public /* synthetic */ n(Function1 function1) {
        this.f13447a = function1;
    }

    public final Object apply(Object obj) {
        return SyncBillingUseCase.s(this.f13447a, obj);
    }
}
