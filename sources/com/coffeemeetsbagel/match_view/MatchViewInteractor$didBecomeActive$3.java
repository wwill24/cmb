package com.coffeemeetsbagel.match_view;

import java.util.OptionalInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MatchViewInteractor$didBecomeActive$3 extends Lambda implements Function1<OptionalInt, Unit> {
    final /* synthetic */ MatchViewInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewInteractor$didBecomeActive$3(MatchViewInteractor matchViewInteractor) {
        super(1);
        this.this$0 = matchViewInteractor;
    }

    public final void a(OptionalInt optionalInt) {
        ((MatchViewPresenter) this.this$0.f7875e).Z0(optionalInt.isPresent() && optionalInt.getAsInt() > 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((OptionalInt) obj);
        return Unit.f32013a;
    }
}
