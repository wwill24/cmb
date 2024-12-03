package com.coffeemeetsbagel.domain.repository;

import com.android.billingclient.api.Purchase;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.mparticle.kits.AppsFlyerKit;
import fa.a;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionRepository$purchaseSubscription$3 extends Lambda implements Function1<Purchase, Unit> {
    final /* synthetic */ String $sku;
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$purchaseSubscription$3(SubscriptionRepository subscriptionRepository, String str) {
        super(1);
        this.this$0 = subscriptionRepository;
        this.$sku = str;
    }

    public final void a(Purchase purchase) {
        a.C0491a aVar = a.f40771d;
        String J = this.this$0.f12436j;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Purchased skus: ");
        ArrayList<String> f10 = purchase.f();
        j.f(f10, "purchase.skus");
        sb2.append(CollectionsKt___CollectionsKt.W(f10, AppsFlyerKit.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        aVar.a(J, sb2.toString());
        String J2 = this.this$0.f12436j;
        aVar.a(J2, "Purchase Token:" + purchase.d());
        this.this$0.m0().accept(new SubscriptionRepository.a(this.$sku, true));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Purchase) obj);
        return Unit.f32013a;
    }
}
