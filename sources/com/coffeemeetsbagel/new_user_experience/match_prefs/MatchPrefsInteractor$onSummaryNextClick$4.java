package com.coffeemeetsbagel.new_user_experience.match_prefs;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import na.b;

final class MatchPrefsInteractor$onSummaryNextClick$4 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ MatchPrefsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPrefsInteractor$onSummaryNextClick$4(MatchPrefsInteractor matchPrefsInteractor) {
        super(1);
        this.this$0 = matchPrefsInteractor;
    }

    public final void a(Throwable th2) {
        b Z1 = this.this$0.Z1();
        String z10 = ((MatchPrefsPresenter) this.this$0.f7875e).z();
        j.f(z10, "presenter.serverError");
        Z1.onError(z10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
