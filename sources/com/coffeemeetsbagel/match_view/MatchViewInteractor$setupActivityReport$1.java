package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.models.ActivityReport;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MatchViewInteractor$setupActivityReport$1 extends Lambda implements Function1<Pair<? extends Boolean, ? extends ActivityReport>, Unit> {
    final /* synthetic */ MatchViewInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewInteractor$setupActivityReport$1(MatchViewInteractor matchViewInteractor) {
        super(1);
        this.this$0 = matchViewInteractor;
    }

    public final void a(Pair<Boolean, ActivityReport> pair) {
        this.this$0.j3(pair.c().booleanValue(), pair.d());
        if (pair.c().booleanValue()) {
            this.this$0.T.accept("Unlocked");
        } else {
            this.this$0.T.accept("Locked");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
