package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionBundleRoomDao$getBundleById$1 extends Lambda implements Function1<List<? extends SubscriptionBundleEntity>, Optional<SubscriptionBundleEntity>> {

    /* renamed from: a  reason: collision with root package name */
    public static final SubscriptionBundleRoomDao$getBundleById$1 f11616a = new SubscriptionBundleRoomDao$getBundleById$1();

    SubscriptionBundleRoomDao$getBundleById$1() {
        super(1);
    }

    /* renamed from: a */
    public final Optional<SubscriptionBundleEntity> invoke(List<SubscriptionBundleEntity> list) {
        j.g(list, "list");
        if (list.isEmpty()) {
            return Optional.a();
        }
        return Optional.e(list.get(0));
    }
}
