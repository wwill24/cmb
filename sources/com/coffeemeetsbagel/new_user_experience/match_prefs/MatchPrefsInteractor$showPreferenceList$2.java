package com.coffeemeetsbagel.new_user_experience.match_prefs;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import na.b;

final class MatchPrefsInteractor$showPreferenceList$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ MatchPrefsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPrefsInteractor$showPreferenceList$2(MatchPrefsInteractor matchPrefsInteractor) {
        super(1);
        this.this$0 = matchPrefsInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String R1 = this.this$0.f35133g;
        j.f(th2, "throwable");
        aVar.c(R1, "Failed to show match preferences.", th2);
        if (this.this$0.f35132f) {
            b Z1 = this.this$0.Z1();
            String z10 = ((MatchPrefsPresenter) this.this$0.f7875e).z();
            j.f(z10, "presenter.serverError");
            Z1.onError(z10);
            return;
        }
        this.this$0.a2().onError(((MatchPrefsPresenter) this.this$0.f7875e).z());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
