package com.coffeemeetsbagel.database.daos;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class f0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11719a;

    public /* synthetic */ f0(Function1 function1) {
        this.f11719a = function1;
    }

    public final Object apply(Object obj) {
        return ProfileRoomDao.y(this.f11719a, obj);
    }
}
