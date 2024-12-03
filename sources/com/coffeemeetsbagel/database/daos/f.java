package com.coffeemeetsbagel.database.daos;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class f implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11718a;

    public /* synthetic */ f(Function1 function1) {
        this.f11718a = function1;
    }

    public final Object apply(Object obj) {
        return ActiveSubscriptionRoomDao.n(this.f11718a, obj);
    }
}
