package com.coffeemeetsbagel.feature.sync;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class m implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13446a;

    public /* synthetic */ m(Function1 function1) {
        this.f13446a = function1;
    }

    public final Object apply(Object obj) {
        return SyncBillingUseCase.r(this.f13446a, obj);
    }
}
