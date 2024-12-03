package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;

final class SubscriptionBundleRoomDao$getHighestTierBundle$1 extends Lambda implements Function1<List<? extends Integer>, a<? extends Optional<SubscriptionBundleEntity>>> {
    final /* synthetic */ SubscriptionBundleRoomDao this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionBundleRoomDao$getHighestTierBundle$1(SubscriptionBundleRoomDao subscriptionBundleRoomDao) {
        super(1);
        this.this$0 = subscriptionBundleRoomDao;
    }

    /* access modifiers changed from: private */
    public static final Optional d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* renamed from: c */
    public final a<? extends Optional<SubscriptionBundleEntity>> invoke(List<Integer> list) {
        j.g(list, "tierList");
        if (CollectionsKt___CollectionsKt.K(list).isEmpty()) {
            return h.X(Optional.a());
        }
        SubscriptionBundleRoomDao subscriptionBundleRoomDao = this.this$0;
        Integer num = list.get(0);
        j.d(num);
        return subscriptionBundleRoomDao.E(num.intValue()).Y(new x0(AnonymousClass1.f11617a));
    }
}
