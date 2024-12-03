package com.coffeemeetsbagel.feature.sync;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class t implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13456a;

    public /* synthetic */ t(Function1 function1) {
        this.f13456a = function1;
    }

    public final Object apply(Object obj) {
        return SyncSubscriptionHistoryUseCase.g(this.f13456a, obj);
    }
}
