package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.match_view.MatchViewPresenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchViewPresenter$didLoad$13 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ MatchViewPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewPresenter$didLoad$13(MatchViewPresenter matchViewPresenter) {
        super(1);
        this.this$0 = matchViewPresenter;
    }

    public final void a(Integer num) {
        MatchViewPresenter.b D = this.this$0.f34645f;
        j.f(num, "photoPosition");
        D.m0(num.intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Integer) obj);
        return Unit.f32013a;
    }
}
