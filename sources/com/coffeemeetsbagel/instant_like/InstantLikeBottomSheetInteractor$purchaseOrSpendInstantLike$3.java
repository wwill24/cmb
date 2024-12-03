package com.coffeemeetsbagel.instant_like;

import android.os.Bundle;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.store.k0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import v8.a;

final class InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$3 extends Lambda implements Function1<Bagel, Unit> {
    final /* synthetic */ InstantLikeBottomSheetInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$3(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
        super(1);
        this.this$0 = instantLikeBottomSheetInteractor;
    }

    public final void a(Bagel bagel) {
        this.this$0.m2().e(new Bundle(), (a) null);
        this.this$0.p2().refreshPricesFromApi((k0.a) null);
        this.this$0.h2().u(bagel);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Bagel) obj);
        return Unit.f32013a;
    }
}
