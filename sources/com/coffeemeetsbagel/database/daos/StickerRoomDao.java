package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.StickerNetwork;
import com.coffeemeetsbagel.models.dto.StickerDataContract;
import com.coffeemeetsbagel.models.entities.StickerEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.w;
import u6.n;

public abstract class StickerRoomDao implements l<StickerEntity>, n {
    /* access modifiers changed from: private */
    public static final List i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    public w<List<StickerNetwork>> a() {
        w<R> D = j().D(new q0(StickerRoomDao$fetchStickersOnce$1.f11614a));
        j.f(D, "selectStickers().map { e…Mapper.dbToDomain(it) } }");
        return D;
    }

    public int c(List<? extends StickerDataContract> list) {
        j.g(list, "stickers");
        g();
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (StickerDataContract n10 : list) {
            arrayList.add(n(n10));
        }
        return s(arrayList).size();
    }

    public abstract int g();

    public abstract w<List<StickerEntity>> j();

    public final StickerEntity n(StickerDataContract stickerDataContract) {
        j.g(stickerDataContract, "<this>");
        return new StickerEntity(stickerDataContract.getName(), stickerDataContract.getDescription(), stickerDataContract.getImageUrl());
    }
}
