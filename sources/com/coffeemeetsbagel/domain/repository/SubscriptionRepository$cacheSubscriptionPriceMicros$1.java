package com.coffeemeetsbagel.domain.repository;

import com.android.billingclient.api.o;
import fa.a;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionRepository$cacheSubscriptionPriceMicros$1 extends Lambda implements Function1<List<? extends o>, Unit> {
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$cacheSubscriptionPriceMicros$1(SubscriptionRepository subscriptionRepository) {
        super(1);
        this.this$0 = subscriptionRepository;
    }

    public final void a(List<o> list) {
        j.f(list, "skuDetailsList");
        SubscriptionRepository subscriptionRepository = this.this$0;
        for (o oVar : list) {
            a.C0491a aVar = a.f40771d;
            String J = subscriptionRepository.f12436j;
            aVar.a(J, "Cached price for " + oVar.b());
            HashMap H = subscriptionRepository.f12437k;
            String b10 = oVar.b();
            j.f(b10, "skuDetails.productId");
            H.put(b10, oVar);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
