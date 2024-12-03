package com.coffeemeetsbagel.feature.chat.header;

import kotlin.jvm.functions.Function1;
import vj.l;

public final /* synthetic */ class e implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12847a;

    public /* synthetic */ e(Function1 function1) {
        this.f12847a = function1;
    }

    public final boolean test(Object obj) {
        return ChatHeaderInteractor.U1(this.f12847a, obj);
    }
}
