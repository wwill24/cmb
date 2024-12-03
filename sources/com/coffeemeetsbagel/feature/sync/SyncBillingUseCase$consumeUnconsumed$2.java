package com.coffeemeetsbagel.feature.sync;

import com.android.billingclient.api.Purchase;
import com.coffeemeetsbagel.models.BeansPurchaseRequest;
import com.coffeemeetsbagel.models.responses.ResponseBeansVerification;
import fa.a;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;
import retrofit2.r;

final class SyncBillingUseCase$consumeUnconsumed$2 extends Lambda implements Function1<Purchase, f> {
    final /* synthetic */ SyncBillingUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SyncBillingUseCase$consumeUnconsumed$2(SyncBillingUseCase syncBillingUseCase) {
        super(1);
        this.this$0 = syncBillingUseCase;
    }

    /* renamed from: a */
    public final f invoke(Purchase purchase) {
        j.g(purchase, "purchase");
        a.C0491a aVar = a.f40771d;
        String n10 = this.this$0.f13412g;
        List<String> b10 = purchase.b();
        aVar.a(n10, "Found unconsumed purchase " + b10 + ".");
        r<ResponseBeansVerification> f10 = this.this$0.f13408c.a(new BeansPurchaseRequest(purchase.a(), purchase.e())).f();
        if (f10.g()) {
            return this.this$0.f13407b.D(purchase);
        }
        List<String> b11 = purchase.b();
        String h10 = f10.h();
        throw new Throwable("Failed to verify unconsumed purchase: " + b11 + ", " + h10);
    }
}
