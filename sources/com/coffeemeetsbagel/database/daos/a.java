package com.coffeemeetsbagel.database.daos;

import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActionCardRoomDao f11618a;

    public /* synthetic */ a(ActionCardRoomDao actionCardRoomDao) {
        this.f11618a = actionCardRoomDao;
    }

    public final Object call() {
        return ActionCardRoomDao.n(this.f11618a);
    }
}
