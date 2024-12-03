package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.dto.PendingMessage;
import com.coffeemeetsbagel.models.entities.PendingMessageEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PendingMessageRoomDao$getPendingMessages$1 extends Lambda implements Function1<List<? extends PendingMessageEntity>, List<? extends PendingMessage>> {

    /* renamed from: a  reason: collision with root package name */
    public static final PendingMessageRoomDao$getPendingMessages$1 f11610a = new PendingMessageRoomDao$getPendingMessages$1();

    PendingMessageRoomDao$getPendingMessages$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<PendingMessage> invoke(List<PendingMessageEntity> list) {
        j.g(list, "t");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (PendingMessageEntity add : list) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
