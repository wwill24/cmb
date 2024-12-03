package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.discoverV2.DiscoverViewModel$setUpsellClosed$1", f = "DiscoverViewModel.kt", l = {}, m = "invokeSuspend")
final class DiscoverViewModel$setUpsellClosed$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiscoverViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverViewModel$setUpsellClosed$1(DiscoverViewModel discoverViewModel, c<? super DiscoverViewModel$setUpsellClosed$1> cVar) {
        super(2, cVar);
        this.this$0 = discoverViewModel;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new DiscoverViewModel$setUpsellClosed$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((DiscoverViewModel$setUpsellClosed$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            this.this$0.B.o(DiscoverViewModel.UpsellViewState.CLOSED_BY_USER);
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
