package com.coffeemeetsbagel.today_view.card.actioncards;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class g0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f37302a;

    public /* synthetic */ g0(Function1 function1) {
        this.f37302a = function1;
    }

    public final Object apply(Object obj) {
        return GetFirstEligibleActionCardUseCase.o(this.f37302a, obj);
    }
}
