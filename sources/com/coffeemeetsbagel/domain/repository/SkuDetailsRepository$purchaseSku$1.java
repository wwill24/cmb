package com.coffeemeetsbagel.domain.repository;

import android.app.Activity;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.o;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class SkuDetailsRepository$purchaseSku$1 extends Lambda implements Function1<o, b0<? extends Purchase>> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ SkuDetailsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SkuDetailsRepository$purchaseSku$1(SkuDetailsRepository skuDetailsRepository, Activity activity) {
        super(1);
        this.this$0 = skuDetailsRepository;
        this.$activity = activity;
    }

    /* renamed from: a */
    public final b0<? extends Purchase> invoke(o oVar) {
        j.g(oVar, "skuDetails");
        return CmbBillingClient.N(this.this$0.f12422a, this.$activity, oVar, (String) null, this.this$0.h(), 4, (Object) null);
    }
}
