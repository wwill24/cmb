package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.models.Bagel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchViewPresenter$didLoad$12 extends Lambda implements Function1<Bagel.STAMP, Unit> {
    final /* synthetic */ MatchViewPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewPresenter$didLoad$12(MatchViewPresenter matchViewPresenter) {
        super(1);
        this.this$0 = matchViewPresenter;
    }

    public final void a(Bagel.STAMP stamp) {
        j.g(stamp, "stampAction");
        this.this$0.c0(stamp);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Bagel.STAMP) obj);
        return Unit.f32013a;
    }
}
