package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionBundleRoomDao$getHighestTierBundle$2 extends Lambda implements Function1<List<? extends SubscriptionBundleEntity>, Optional<SubscriptionBundleEntity>> {
    final /* synthetic */ String $intent;
    final /* synthetic */ SubscriptionBundleRoomDao this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionBundleRoomDao$getHighestTierBundle$2(SubscriptionBundleRoomDao subscriptionBundleRoomDao, String str) {
        super(1);
        this.this$0 = subscriptionBundleRoomDao;
        this.$intent = str;
    }

    /* renamed from: a */
    public final Optional<SubscriptionBundleEntity> invoke(List<SubscriptionBundleEntity> list) {
        j.g(list, "bundles");
        if (list.isEmpty()) {
            return Optional.a();
        }
        return Optional.e((SubscriptionBundleEntity) CollectionsKt___CollectionsKt.Y(this.this$0.x(list, this.$intent)));
    }
}
