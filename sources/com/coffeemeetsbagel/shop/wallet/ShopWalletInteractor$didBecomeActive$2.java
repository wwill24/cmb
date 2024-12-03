package com.coffeemeetsbagel.shop.wallet;

import com.coffeemeetsbagel.models.Price;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ShopWalletInteractor$didBecomeActive$2 extends Lambda implements Function1<List<? extends Price>, Unit> {
    final /* synthetic */ ShopWalletInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopWalletInteractor$didBecomeActive$2(ShopWalletInteractor shopWalletInteractor) {
        super(1);
        this.this$0 = shopWalletInteractor;
    }

    public final void a(List<Price> list) {
        j.g(list, "prices");
        ((j) this.this$0.f7875e).k(this.this$0.U1(list));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
