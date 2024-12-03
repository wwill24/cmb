package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.R;
import j5.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MatchViewPresenter$didLoad$8 extends Lambda implements Function1<x, Unit> {
    final /* synthetic */ MatchViewPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewPresenter$didLoad$8(MatchViewPresenter matchViewPresenter) {
        super(1);
        this.this$0 = matchViewPresenter;
    }

    public final void a(x xVar) {
        this.this$0.f34645f.G0(false);
        final MatchViewPresenter matchViewPresenter = this.this$0;
        matchViewPresenter.P0(R.drawable.ic_report, R.string.report_post_connection_title, R.string.report_post_connection_description, new Function0<Unit>() {
            public final void invoke() {
                matchViewPresenter.f34645f.K0();
            }
        });
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((x) obj);
        return Unit.f32013a;
    }
}
