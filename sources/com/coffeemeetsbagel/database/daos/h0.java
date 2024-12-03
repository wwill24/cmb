package com.coffeemeetsbagel.database.daos;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class h0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11753a;

    public /* synthetic */ h0(Function1 function1) {
        this.f11753a = function1;
    }

    public final Object apply(Object obj) {
        return ProfileRoomDao.v(this.f11753a, obj);
    }
}
