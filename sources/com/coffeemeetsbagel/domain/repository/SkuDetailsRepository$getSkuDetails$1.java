package com.coffeemeetsbagel.domain.repository;

import com.android.billingclient.api.o;
import com.coffeemeetsbagel.google_play.BillingItemUnavailable;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SkuDetailsRepository$getSkuDetails$1 extends Lambda implements Function1<List<? extends o>, o> {
    final /* synthetic */ String $sku;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SkuDetailsRepository$getSkuDetails$1(String str) {
        super(1);
        this.$sku = str;
    }

    /* renamed from: a */
    public final o invoke(List<o> list) {
        j.g(list, "list");
        if (list.size() == 1) {
            return list.get(0);
        }
        throw new BillingItemUnavailable("Couldn't find details for " + this.$sku + '.');
    }
}
