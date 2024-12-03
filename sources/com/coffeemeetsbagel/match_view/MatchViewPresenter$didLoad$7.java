package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.profile.ProfileView;
import j5.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MatchViewPresenter$didLoad$7 extends Lambda implements Function1<x, Unit> {
    final /* synthetic */ MatchViewPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewPresenter$didLoad$7(MatchViewPresenter matchViewPresenter) {
        super(1);
        this.this$0 = matchViewPresenter;
    }

    public final void a(x xVar) {
        ((ProfileView) this.this$0.f7869c).v0(this.this$0.f34644e);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((x) obj);
        return Unit.f32013a;
    }
}
