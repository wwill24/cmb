package com.coffeemeetsbagel.experiment;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class h implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12652a;

    public /* synthetic */ h(Function1 function1) {
        this.f12652a = function1;
    }

    public final Object apply(Object obj) {
        return FeatureFlagRepository.v(this.f12652a, obj);
    }
}
