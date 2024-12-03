package com.coffeemeetsbagel.database.daos;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class c implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11661a;

    public /* synthetic */ c(Function1 function1) {
        this.f11661a = function1;
    }

    public final Object apply(Object obj) {
        return ActionCardRoomDao.u(this.f11661a, obj);
    }
}
