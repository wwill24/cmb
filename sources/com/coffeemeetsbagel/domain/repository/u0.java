package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class u0 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12586a;

    public /* synthetic */ u0(Function1 function1) {
        this.f12586a = function1;
    }

    public final void accept(Object obj) {
        SubscriptionRepository.Q(this.f12586a, obj);
    }
}
