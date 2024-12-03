package com.coffeemeetsbagel.match_view;

import com.uber.autodispose.t;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchViewInteractor$processWooReceived$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ int $count;
    final /* synthetic */ String $matchId;
    final /* synthetic */ MatchViewInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewInteractor$processWooReceived$2(MatchViewInteractor matchViewInteractor, String str, int i10) {
        super(1);
        this.this$0 = matchViewInteractor;
        this.$matchId = str;
        this.$count = i10;
    }

    public final void a(Boolean bool) {
        j.f(bool, "isSeen");
        if (bool.booleanValue()) {
            a.C0491a aVar = a.f40771d;
            MatchViewInteractor matchViewInteractor = this.this$0;
            aVar.a("MatchViewInteractor", "match is seen/ checked; we can now send 'total_woos_seen' to API " + matchViewInteractor);
            ((t) this.this$0.J2().a(this.$matchId, this.$count).g(com.uber.autodispose.a.a(this.this$0))).d();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Boolean) obj);
        return Unit.f32013a;
    }
}
