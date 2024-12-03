package com.coffeemeetsbagel.feature.sync;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class o implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13448a;

    public /* synthetic */ o(Function1 function1) {
        this.f13448a = function1;
    }

    public final Object apply(Object obj) {
        return SyncBillingUseCase.B(this.f13448a, obj);
    }
}
