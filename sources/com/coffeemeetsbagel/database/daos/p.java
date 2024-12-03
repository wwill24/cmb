package com.coffeemeetsbagel.database.daos;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class p implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11848a;

    public /* synthetic */ p(Function1 function1) {
        this.f11848a = function1;
    }

    public final Object apply(Object obj) {
        return CapabilityRoomDao.i(this.f11848a, obj);
    }
}
