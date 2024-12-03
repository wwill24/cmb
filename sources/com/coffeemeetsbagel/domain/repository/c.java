package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class c implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12478a;

    public /* synthetic */ c(Function1 function1) {
        this.f12478a = function1;
    }

    public final void accept(Object obj) {
        ActionCardRepository.i(this.f12478a, obj);
    }
}
