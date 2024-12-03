package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ConnectionDetailsRoomDao$getConnectionDetails$1 extends Lambda implements Function1<List<? extends ConnectionDetailsEntity>, List<? extends ConnectionDetails>> {
    final /* synthetic */ ConnectionDetailsRoomDao this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionDetailsRoomDao$getConnectionDetails$1(ConnectionDetailsRoomDao connectionDetailsRoomDao) {
        super(1);
        this.this$0 = connectionDetailsRoomDao;
    }

    /* renamed from: a */
    public final List<ConnectionDetails> invoke(List<ConnectionDetailsEntity> list) {
        j.g(list, "list");
        ConnectionDetailsRoomDao connectionDetailsRoomDao = this.this$0;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (ConnectionDetailsEntity n10 : list) {
            arrayList.add(connectionDetailsRoomDao.y(n10));
        }
        return arrayList;
    }
}
