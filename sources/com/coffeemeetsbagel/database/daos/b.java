package com.coffeemeetsbagel.database.daos;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11645a;

    public /* synthetic */ b(Function1 function1) {
        this.f11645a = function1;
    }

    public final Object apply(Object obj) {
        return ActionCardRoomDao.t(this.f11645a, obj);
    }
}
