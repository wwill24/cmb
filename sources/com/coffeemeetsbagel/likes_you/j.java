package com.coffeemeetsbagel.likes_you;

import kotlin.jvm.functions.Function1;

public final /* synthetic */ class j implements vj.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f34206a;

    public /* synthetic */ j(Function1 function1) {
        this.f34206a = function1;
    }

    public final Object apply(Object obj) {
        return LikesYouGroupRoomDao.w(this.f34206a, obj);
    }
}
