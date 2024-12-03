package com.coffeemeetsbagel.store;

import gk.h;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import vb.b;

final class SubscriptionDefaults$subscriptionBenefits$2 extends Lambda implements Function0<Map<String, ? extends b>> {
    final /* synthetic */ SubscriptionDefaults this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionDefaults$subscriptionBenefits$2(SubscriptionDefaults subscriptionDefaults) {
        super(0);
        this.this$0 = subscriptionDefaults;
    }

    public final Map<String, b> invoke() {
        return h0.l(h.a("likes_you", this.this$0.f()), h.a("read_receipt", this.this$0.g()), h.a("activity_reports", this.this$0.d()));
    }
}
