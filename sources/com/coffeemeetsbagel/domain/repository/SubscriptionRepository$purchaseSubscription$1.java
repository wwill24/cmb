package com.coffeemeetsbagel.domain.repository;

import com.android.billingclient.api.o;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Triple;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import pk.n;
import vb.a;

final class SubscriptionRepository$purchaseSubscription$1 extends Lambda implements n<o, Optional<a>, Optional<String>, Triple<? extends o, ? extends Optional<a>, ? extends Optional<String>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final SubscriptionRepository$purchaseSubscription$1 f12449a = new SubscriptionRepository$purchaseSubscription$1();

    SubscriptionRepository$purchaseSubscription$1() {
        super(3);
    }

    /* renamed from: a */
    public final Triple<o, Optional<a>, Optional<String>> l(o oVar, Optional<a> optional, Optional<String> optional2) {
        j.g(oVar, "skuDetails");
        j.g(optional, "subscription");
        j.g(optional2, "token");
        return new Triple<>(oVar, optional, optional2);
    }
}
