package com.coffeemeetsbagel.instant_like;

import com.coffeemeetsbagel.models.Price;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InstantLikeBottomSheetInteractor$didBecomeActive$2 extends Lambda implements Function1<Pair<? extends Price, ? extends Long>, Unit> {
    final /* synthetic */ InstantLikeBottomSheetInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeBottomSheetInteractor$didBecomeActive$2(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
        super(1);
        this.this$0 = instantLikeBottomSheetInteractor;
    }

    public final void a(Pair<Price, Long> pair) {
        boolean z10;
        Price c10 = pair.c();
        Long d10 = pair.d();
        ((InstantLikeBottomSheetRouter) this.this$0.B1()).s();
        j.f(d10, "beanBalances");
        boolean z11 = true;
        if (d10.longValue() > ((long) c10.getBeans())) {
            z10 = true;
        } else {
            z10 = false;
        }
        InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor = this.this$0;
        if (c10.getFreeItemCount() <= 0 && d10.longValue() <= ((long) c10.getBeans())) {
            z11 = false;
        }
        instantLikeBottomSheetInteractor.f13997x = Boolean.valueOf(z11);
        j.f(c10, FirebaseAnalytics.Param.PRICE);
        ((InstantLikeBottomSheetPresenter) this.this$0.f7875e).r(c10, z10, this.this$0.f13986g);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
