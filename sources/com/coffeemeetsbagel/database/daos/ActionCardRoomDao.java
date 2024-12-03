package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.ActionCardEntity;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import u6.a;

public abstract class ActionCardRoomDao implements l<ActionCardEntity>, a {
    /* access modifiers changed from: private */
    public static final Integer n(ActionCardRoomDao actionCardRoomDao) {
        j.g(actionCardRoomDao, "this$0");
        return Integer.valueOf(actionCardRoomDao.j());
    }

    /* access modifiers changed from: private */
    public static final b0 t(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 u(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public w<List<ActionCardEntity>> a() {
        return v();
    }

    public w<List<ActionCardEntity>> c(List<ActionCardEntity> list) {
        j.g(list, "entities");
        w<List<ActionCardEntity>> v10 = w.A(new a(this)).v(new b(new ActionCardRoomDao$clearAndInsert$2(this, list))).v(new c(new ActionCardRoomDao$clearAndInsert$3(this)));
        j.f(v10, "override fun clearAndIns…)\n                }\n    }");
        return v10;
    }

    public abstract int j();

    public abstract w<List<ActionCardEntity>> v();
}
