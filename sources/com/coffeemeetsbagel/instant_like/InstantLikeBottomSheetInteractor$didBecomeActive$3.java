package com.coffeemeetsbagel.instant_like;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InstantLikeBottomSheetInteractor$didBecomeActive$3 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ InstantLikeBottomSheetInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeBottomSheetInteractor$didBecomeActive$3(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
        super(1);
        this.this$0 = instantLikeBottomSheetInteractor;
    }

    public final void a(Throwable th2) {
        ((InstantLikeBottomSheetPresenter) this.this$0.f7875e).q();
        a.C0491a aVar = a.f40771d;
        String X1 = this.this$0.f13996w;
        j.f(X1, "tag");
        j.f(th2, "it");
        aVar.c(X1, "problem getting price", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
