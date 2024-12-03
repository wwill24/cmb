package com.coffeemeetsbagel.experiment;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class o implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12661a;

    public /* synthetic */ o(Function1 function1) {
        this.f12661a = function1;
    }

    public final void accept(Object obj) {
        FeatureFlagRepository.D(this.f12661a, obj);
    }
}
