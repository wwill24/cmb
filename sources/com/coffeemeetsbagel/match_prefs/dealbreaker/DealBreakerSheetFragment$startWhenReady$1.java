package com.coffeemeetsbagel.match_prefs.dealbreaker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.match_prefs.dealbreaker.DealBreakerSheetFragment$startWhenReady$1", f = "DealBreakerSheetFragment.kt", l = {}, m = "invokeSuspend")
final class DealBreakerSheetFragment$startWhenReady$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ androidx.appcompat.app.c $activity;
    int label;
    final /* synthetic */ DealBreakerSheetFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DealBreakerSheetFragment$startWhenReady$1(androidx.appcompat.app.c cVar, DealBreakerSheetFragment dealBreakerSheetFragment, c<? super DealBreakerSheetFragment$startWhenReady$1> cVar2) {
        super(2, cVar2);
        this.$activity = cVar;
        this.this$0 = dealBreakerSheetFragment;
    }

    /* access modifiers changed from: private */
    public static final void j(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new DealBreakerSheetFragment$startWhenReady$1(this.$activity, this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((DealBreakerSheetFragment$startWhenReady$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            final DealbreakerSheetViewModel dealbreakerSheetViewModel = (DealbreakerSheetViewModel) new i0((l0) this.$activity, (i0.b) this.this$0.F0()).a(DealbreakerSheetViewModel.class);
            LiveData<Boolean> m10 = dealbreakerSheetViewModel.m();
            final androidx.appcompat.app.c cVar = this.$activity;
            final DealBreakerSheetFragment dealBreakerSheetFragment = this.this$0;
            m10.i(cVar, new b(new Function1<Boolean, Unit>() {
                public final void a(Boolean bool) {
                    j.f(bool, "shouldShow");
                    if (bool.booleanValue()) {
                        dealBreakerSheetFragment.show(cVar.getSupportFragmentManager(), DealBreakerSheetFragment.f34567d.a());
                        dealbreakerSheetViewModel.n();
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((Boolean) obj);
                    return Unit.f32013a;
                }
            }));
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
