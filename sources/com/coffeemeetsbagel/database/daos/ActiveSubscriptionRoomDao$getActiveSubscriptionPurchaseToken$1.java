package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ActiveSubscriptionRoomDao$getActiveSubscriptionPurchaseToken$1 extends Lambda implements Function1<List<? extends String>, Optional<String>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ActiveSubscriptionRoomDao$getActiveSubscriptionPurchaseToken$1 f11605a = new ActiveSubscriptionRoomDao$getActiveSubscriptionPurchaseToken$1();

    ActiveSubscriptionRoomDao$getActiveSubscriptionPurchaseToken$1() {
        super(1);
    }

    /* renamed from: a */
    public final Optional<String> invoke(List<String> list) {
        j.g(list, "list");
        if (list.size() != 1) {
            return Optional.a();
        }
        return Optional.e(list.get(0));
    }
}
