package com.coffeemeetsbagel.instant_like;

import c6.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InstantLikeBottomSheetInteractor$didBecomeActive$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ InstantLikeBottomSheetInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeBottomSheetInteractor$didBecomeActive$1(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
        super(1);
        this.this$0 = instantLikeBottomSheetInteractor;
    }

    public final void a(a aVar) {
        InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor = this.this$0;
        j.f(aVar, "activityResult");
        instantLikeBottomSheetInteractor.u2(aVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return Unit.f32013a;
    }
}
