package com.coffeemeetsbagel.database.daos;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class m0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11818a;

    public /* synthetic */ m0(Function1 function1) {
        this.f11818a = function1;
    }

    public final Object apply(Object obj) {
        return ResourceRoomDao.j(this.f11818a, obj);
    }
}
