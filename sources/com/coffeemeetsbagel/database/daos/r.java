package com.coffeemeetsbagel.database.daos;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class r implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11869a;

    public /* synthetic */ r(Function1 function1) {
        this.f11869a = function1;
    }

    public final Object apply(Object obj) {
        return ConnectionDetailsRoomDao.u(this.f11869a, obj);
    }
}
