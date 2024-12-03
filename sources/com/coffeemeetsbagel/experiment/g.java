package com.coffeemeetsbagel.experiment;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class g implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12651a;

    public /* synthetic */ g(Function1 function1) {
        this.f12651a = function1;
    }

    public final Object apply(Object obj) {
        return FeatureFlagRepository.J(this.f12651a, obj);
    }
}
