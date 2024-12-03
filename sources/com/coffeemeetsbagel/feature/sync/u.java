package com.coffeemeetsbagel.feature.sync;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class u implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13457a;

    public /* synthetic */ u(Function1 function1) {
        this.f13457a = function1;
    }

    public final void accept(Object obj) {
        SyncSubscriptionHistoryUseCase.h(this.f13457a, obj);
    }
}
