package com.coffeemeetsbagel.feature.sync;

import com.android.billingclient.api.Purchase;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SyncBillingUseCase$consumeUnconsumed$1 extends Lambda implements Function1<List<? extends Purchase>, Iterable<? extends Purchase>> {

    /* renamed from: a  reason: collision with root package name */
    public static final SyncBillingUseCase$consumeUnconsumed$1 f13414a = new SyncBillingUseCase$consumeUnconsumed$1();

    SyncBillingUseCase$consumeUnconsumed$1() {
        super(1);
    }

    /* renamed from: a */
    public final Iterable<Purchase> invoke(List<? extends Purchase> list) {
        j.g(list, "it");
        return list;
    }
}
