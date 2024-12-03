package com.coffeemeetsbagel.experiment;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class m implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12657a;

    public /* synthetic */ m(Function1 function1) {
        this.f12657a = function1;
    }

    public final Object apply(Object obj) {
        return FeatureFlagRepository.L(this.f12657a, obj);
    }
}
