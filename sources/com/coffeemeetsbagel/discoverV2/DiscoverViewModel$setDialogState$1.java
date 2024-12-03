package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import gk.g;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.discoverV2.DiscoverViewModel$setDialogState$1", f = "DiscoverViewModel.kt", l = {}, m = "invokeSuspend")
final class DiscoverViewModel$setDialogState$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ GiveTake $giveTake;
    final /* synthetic */ PurchaseType $purchaseType;
    final /* synthetic */ DiscoverViewModel.DialogViewState $state;
    int label;
    final /* synthetic */ DiscoverViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverViewModel$setDialogState$1(DiscoverViewModel discoverViewModel, DiscoverViewModel.DialogViewState dialogViewState, GiveTake giveTake, PurchaseType purchaseType, c<? super DiscoverViewModel$setDialogState$1> cVar) {
        super(2, cVar);
        this.this$0 = discoverViewModel;
        this.$state = dialogViewState;
        this.$giveTake = giveTake;
        this.$purchaseType = purchaseType;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new DiscoverViewModel$setDialogState$1(this.this$0, this.$state, this.$giveTake, this.$purchaseType, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((DiscoverViewModel$setDialogState$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            this.this$0.F.o(new Triple(this.$state, this.$giveTake, this.$purchaseType));
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
