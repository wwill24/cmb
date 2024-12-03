package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.ActiveSubscriptionEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.a;
import qj.h;
import u6.b;

public abstract class ActiveSubscriptionRoomDao implements l<ActiveSubscriptionEntity>, b {
    /* access modifiers changed from: private */
    public static final Optional n(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void v(ActiveSubscriptionRoomDao activeSubscriptionRoomDao, ActiveSubscriptionEntity activeSubscriptionEntity) {
        j.g(activeSubscriptionRoomDao, "this$0");
        activeSubscriptionRoomDao.w(activeSubscriptionEntity);
    }

    public a a(ActiveSubscriptionEntity activeSubscriptionEntity) {
        a w10 = a.w(new e(this, activeSubscriptionEntity));
        j.f(w10, "fromAction { updateActiv…ion(activeSubscription) }");
        return w10;
    }

    public h<Optional<String>> c() {
        h<R> Y = u().Y(new f(ActiveSubscriptionRoomDao$getActiveSubscriptionPurchaseToken$1.f11605a));
        j.f(Y, "selectPurchaseToken().ma…)\n            }\n        }");
        return Y;
    }

    public h<List<ActiveSubscriptionEntity>> f() {
        return t();
    }

    public abstract int j();

    public abstract h<List<ActiveSubscriptionEntity>> t();

    public abstract h<List<String>> u();

    public void w(ActiveSubscriptionEntity activeSubscriptionEntity) {
        j();
        if (activeSubscriptionEntity != null) {
            s(p.e(activeSubscriptionEntity));
        }
    }
}
