package com.coffeemeetsbagel.discover;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class a implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12169a;

    public /* synthetic */ a(Function1 function1) {
        this.f12169a = function1;
    }

    public final void accept(Object obj) {
        DiscoverMatchRepository.e(this.f12169a, obj);
    }
}
