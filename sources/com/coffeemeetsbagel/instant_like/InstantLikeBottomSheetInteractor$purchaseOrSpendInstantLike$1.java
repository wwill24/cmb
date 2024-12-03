package com.coffeemeetsbagel.instant_like;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tj.b;

final class InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ InstantLikeBottomSheetInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$1(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
        super(1);
        this.this$0 = instantLikeBottomSheetInteractor;
    }

    public final void a(b bVar) {
        ((InstantLikeBottomSheetPresenter) this.this$0.f7875e).v(true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}
