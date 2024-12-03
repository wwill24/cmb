package com.coffeemeetsbagel.database.daos;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class z implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11971a;

    public /* synthetic */ z(Function1 function1) {
        this.f11971a = function1;
    }

    public final Object apply(Object obj) {
        return PendingMessageRoomDao.w(this.f11971a, obj);
    }
}
