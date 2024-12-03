package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.ActionCardEntity;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class ActionCardRoomDao$clearAndInsert$2 extends Lambda implements Function1<Integer, b0<? extends List<? extends Long>>> {
    final /* synthetic */ List<ActionCardEntity> $entities;
    final /* synthetic */ ActionCardRoomDao this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardRoomDao$clearAndInsert$2(ActionCardRoomDao actionCardRoomDao, List<ActionCardEntity> list) {
        super(1);
        this.this$0 = actionCardRoomDao;
        this.$entities = list;
    }

    /* renamed from: a */
    public final b0<? extends List<Long>> invoke(Integer num) {
        j.g(num, "it");
        return this.this$0.l(this.$entities);
    }
}
