package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class f0 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36805a;

    public /* synthetic */ f0(Function1 function1) {
        this.f36805a = function1;
    }

    public final void accept(Object obj) {
        PriceRepository.j(this.f36805a, obj);
    }
}
