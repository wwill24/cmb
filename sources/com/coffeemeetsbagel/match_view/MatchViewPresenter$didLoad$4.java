package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.profile.ActivityReportViewedState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchViewPresenter$didLoad$4 extends Lambda implements Function1<ActivityReportViewedState, Unit> {
    final /* synthetic */ MatchViewPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewPresenter$didLoad$4(MatchViewPresenter matchViewPresenter) {
        super(1);
        this.this$0 = matchViewPresenter;
    }

    public final void a(ActivityReportViewedState activityReportViewedState) {
        j.g(activityReportViewedState, "state");
        this.this$0.d0(activityReportViewedState);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ActivityReportViewedState) obj);
        return Unit.f32013a;
    }
}
