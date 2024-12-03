package com.coffeemeetsbagel.preferences;

import com.coffeemeetsbagel.match_prefs.dealbreaker.DealBreakerSheetFragment;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.preferences.MatchPreferencesComponentActivity$onCreate$1", f = "MatchPreferencesComponentActivity.kt", l = {}, m = "invokeSuspend")
final class MatchPreferencesComponentActivity$onCreate$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ DealBreakerSheetFragment $dealbreakerSheet;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MatchPreferencesComponentActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPreferencesComponentActivity$onCreate$1(DealBreakerSheetFragment dealBreakerSheetFragment, MatchPreferencesComponentActivity matchPreferencesComponentActivity, c<? super MatchPreferencesComponentActivity$onCreate$1> cVar) {
        super(2, cVar);
        this.$dealbreakerSheet = dealBreakerSheetFragment;
        this.this$0 = matchPreferencesComponentActivity;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        MatchPreferencesComponentActivity$onCreate$1 matchPreferencesComponentActivity$onCreate$1 = new MatchPreferencesComponentActivity$onCreate$1(this.$dealbreakerSheet, this.this$0, cVar);
        matchPreferencesComponentActivity$onCreate$1.L$0 = obj;
        return matchPreferencesComponentActivity$onCreate$1;
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((MatchPreferencesComponentActivity$onCreate$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            this.$dealbreakerSheet.J0((k0) this.L$0, this.this$0);
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
