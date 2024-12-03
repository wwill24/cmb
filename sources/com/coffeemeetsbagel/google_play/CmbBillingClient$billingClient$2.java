package com.coffeemeetsbagel.google_play;

import android.content.Context;
import com.android.billingclient.api.e;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class CmbBillingClient$billingClient$2 extends Lambda implements Function0<e> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CmbBillingClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CmbBillingClient$billingClient$2(Context context, CmbBillingClient cmbBillingClient) {
        super(0);
        this.$context = context;
        this.this$0 = cmbBillingClient;
    }

    /* renamed from: a */
    public final e invoke() {
        e a10 = e.f(this.$context).c(this.this$0.f13910d).b().a();
        j.f(a10, "newBuilder(context)\n    …es()\n            .build()");
        return a10;
    }
}
