package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.StickerNetwork;
import com.coffeemeetsbagel.models.entities.StickerEntity;
import com.coffeemeetsbagel.models.mappers.StickerMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class StickerRoomDao$fetchStickersOnce$1 extends Lambda implements Function1<List<? extends StickerEntity>, List<? extends StickerNetwork>> {

    /* renamed from: a  reason: collision with root package name */
    public static final StickerRoomDao$fetchStickersOnce$1 f11614a = new StickerRoomDao$fetchStickersOnce$1();

    StickerRoomDao$fetchStickersOnce$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<StickerNetwork> invoke(List<StickerEntity> list) {
        j.g(list, "entities");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (StickerEntity dbToDomain : list) {
            arrayList.add(StickerMapper.INSTANCE.dbToDomain(dbToDomain));
        }
        return arrayList;
    }
}
