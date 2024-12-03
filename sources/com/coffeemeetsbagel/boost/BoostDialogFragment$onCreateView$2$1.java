package com.coffeemeetsbagel.boost;

import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.boost.BoostDialogFragment$onCreateView$2$1", f = "BoostDialogFragment.kt", l = {169}, m = "invokeSuspend")
final class BoostDialogFragment$onCreateView$2$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ BoostDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoostDialogFragment$onCreateView$2$1(BoostDialogFragment boostDialogFragment, c<? super BoostDialogFragment$onCreateView$2$1> cVar) {
        super(2, cVar);
        this.this$0 = boostDialogFragment;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new BoostDialogFragment$onCreateView$2$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((BoostDialogFragment$onCreateView$2$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            BoostViewModel L0 = this.this$0.f11422j;
            if (L0 == null) {
                j.y("viewModel");
                L0 = null;
            }
            this.label = 1;
            if (L0.B(this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
