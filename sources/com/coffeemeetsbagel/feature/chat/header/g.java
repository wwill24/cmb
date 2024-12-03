package com.coffeemeetsbagel.feature.chat.header;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12849a;

    public /* synthetic */ g(Function1 function1) {
        this.f12849a = function1;
    }

    public final void accept(Object obj) {
        ChatHeaderInteractor$didBecomeActive$2.d(this.f12849a, obj);
    }
}
