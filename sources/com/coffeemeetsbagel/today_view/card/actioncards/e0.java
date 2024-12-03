package com.coffeemeetsbagel.today_view.card.actioncards;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class e0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f37297a;

    public /* synthetic */ e0(Function1 function1) {
        this.f37297a = function1;
    }

    public final Object apply(Object obj) {
        return GetFirstEligibleActionCardUseCase.s(this.f37297a, obj);
    }
}
