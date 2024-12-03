package com.coffeemeetsbagel.today_view.card.actioncards;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class h0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f37304a;

    public /* synthetic */ h0(Function1 function1) {
        this.f37304a = function1;
    }

    public final Object apply(Object obj) {
        return GetFirstEligibleActionCardUseCase.m(this.f37304a, obj);
    }
}
