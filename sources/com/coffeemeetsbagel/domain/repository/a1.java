package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.l;

public final /* synthetic */ class a1 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12469a;

    public /* synthetic */ a1(Function1 function1) {
        this.f12469a = function1;
    }

    public final boolean test(Object obj) {
        return SubscriptionRepository.v0(this.f12469a, obj);
    }
}
