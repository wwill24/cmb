package com.coffeemeetsbagel.experiment;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class j implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12654a;

    public /* synthetic */ j(Function1 function1) {
        this.f12654a = function1;
    }

    public final void accept(Object obj) {
        FeatureFlagRepository.G(this.f12654a, obj);
    }
}
