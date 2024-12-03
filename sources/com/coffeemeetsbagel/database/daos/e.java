package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.ActiveSubscriptionEntity;
import vj.a;

public final /* synthetic */ class e implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActiveSubscriptionRoomDao f11703a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActiveSubscriptionEntity f11704b;

    public /* synthetic */ e(ActiveSubscriptionRoomDao activeSubscriptionRoomDao, ActiveSubscriptionEntity activeSubscriptionEntity) {
        this.f11703a = activeSubscriptionRoomDao;
        this.f11704b = activeSubscriptionEntity;
    }

    public final void run() {
        ActiveSubscriptionRoomDao.v(this.f11703a, this.f11704b);
    }
}
