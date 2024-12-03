package com.coffeemeetsbagel.feature.sync;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class s implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13455a;

    public /* synthetic */ s(Function1 function1) {
        this.f13455a = function1;
    }

    public final Object apply(Object obj) {
        return SyncSubscriptionHistoryUseCase.f(this.f13455a, obj);
    }
}
