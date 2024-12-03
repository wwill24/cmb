package com.coffeemeetsbagel.database.daos;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class q0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11868a;

    public /* synthetic */ q0(Function1 function1) {
        this.f11868a = function1;
    }

    public final Object apply(Object obj) {
        return StickerRoomDao.i(this.f11868a, obj);
    }
}
