package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.ActionCardEntity;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class ActionCardRoomDao$clearAndInsert$3 extends Lambda implements Function1<List<? extends Long>, b0<? extends List<? extends ActionCardEntity>>> {
    final /* synthetic */ ActionCardRoomDao this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardRoomDao$clearAndInsert$3(ActionCardRoomDao actionCardRoomDao) {
        super(1);
        this.this$0 = actionCardRoomDao;
    }

    /* renamed from: a */
    public final b0<? extends List<ActionCardEntity>> invoke(List<Long> list) {
        j.g(list, "it");
        return this.this$0.v();
    }
}
