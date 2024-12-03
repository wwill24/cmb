package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class g2 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12508a;

    public /* synthetic */ g2(Function1 function1) {
        this.f12508a = function1;
    }

    public final void accept(Object obj) {
        SuggestedRepository.E(this.f12508a, obj);
    }
}
