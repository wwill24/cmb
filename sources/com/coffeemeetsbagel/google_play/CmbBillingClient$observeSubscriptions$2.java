package com.coffeemeetsbagel.google_play;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.i;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class CmbBillingClient$observeSubscriptions$2 extends Lambda implements Function1<Pair<? extends i, ? extends List<? extends Purchase>>, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final CmbBillingClient$observeSubscriptions$2 f13917a = new CmbBillingClient$observeSubscriptions$2();

    CmbBillingClient$observeSubscriptions$2() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(Pair<i, ? extends List<? extends Purchase>> pair) {
        j.g(pair, "pair");
        Object d10 = pair.d();
        j.d(d10);
        List<String> b10 = ((Purchase) CollectionsKt___CollectionsKt.N((List) d10)).b();
        j.f(b10, "pair.second!!.first().products");
        return (String) CollectionsKt___CollectionsKt.N(b10);
    }
}
