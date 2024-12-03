package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class t0 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12576a;

    public /* synthetic */ t0(Function1 function1) {
        this.f12576a = function1;
    }

    public final void accept(Object obj) {
        SubscriptionRepository.P(this.f12576a, obj);
    }
}
