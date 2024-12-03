package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class b2 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12475a;

    public /* synthetic */ b2(Function1 function1) {
        this.f12475a = function1;
    }

    public final void accept(Object obj) {
        SuggestedRepository.K(this.f12475a, obj);
    }
}
