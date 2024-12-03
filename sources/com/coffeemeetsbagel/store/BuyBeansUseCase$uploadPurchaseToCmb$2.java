package com.coffeemeetsbagel.store;

import com.android.billingclient.api.Purchase;
import com.coffeemeetsbagel.models.responses.ResponseBeansVerification;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import retrofit2.r;

final class BuyBeansUseCase$uploadPurchaseToCmb$2 extends Lambda implements Function1<r<ResponseBeansVerification>, Pair<? extends Integer, ? extends Purchase>> {
    final /* synthetic */ Purchase $purchase;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuyBeansUseCase$uploadPurchaseToCmb$2(Purchase purchase) {
        super(1);
        this.$purchase = purchase;
    }

    /* renamed from: a */
    public final Pair<Integer, Purchase> invoke(r<ResponseBeansVerification> rVar) {
        int i10;
        j.g(rVar, "response");
        if (rVar.g()) {
            ResponseBeansVerification a10 = rVar.a();
            if (a10 != null) {
                i10 = a10.getNewBeans();
            } else {
                i10 = 0;
            }
            return new Pair<>(Integer.valueOf(i10), this.$purchase);
        }
        int b10 = rVar.b();
        String h10 = rVar.h();
        throw new Throwable("Purchase failure: [" + b10 + "] " + h10);
    }
}
