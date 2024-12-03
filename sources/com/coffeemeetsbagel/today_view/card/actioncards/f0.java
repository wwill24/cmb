package com.coffeemeetsbagel.today_view.card.actioncards;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class f0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f37300a;

    public /* synthetic */ f0(Function1 function1) {
        this.f37300a = function1;
    }

    public final Object apply(Object obj) {
        return GetFirstEligibleActionCardUseCase.q(this.f37300a, obj);
    }
}
