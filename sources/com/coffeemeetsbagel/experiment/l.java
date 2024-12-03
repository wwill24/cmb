package com.coffeemeetsbagel.experiment;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class l implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12656a;

    public /* synthetic */ l(Function1 function1) {
        this.f12656a = function1;
    }

    public final void accept(Object obj) {
        FeatureFlagRepository.t(this.f12656a, obj);
    }
}
