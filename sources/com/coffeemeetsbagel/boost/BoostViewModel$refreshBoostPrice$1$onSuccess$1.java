package com.coffeemeetsbagel.boost;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.boost.BoostViewModel$refreshBoostPrice$1$onSuccess$1", f = "BoostViewModel.kt", l = {}, m = "invokeSuspend")
final class BoostViewModel$refreshBoostPrice$1$onSuccess$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ BoostViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoostViewModel$refreshBoostPrice$1$onSuccess$1(BoostViewModel boostViewModel, c<? super BoostViewModel$refreshBoostPrice$1$onSuccess$1> cVar) {
        super(2, cVar);
        this.this$0 = boostViewModel;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new BoostViewModel$refreshBoostPrice$1$onSuccess$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((BoostViewModel$refreshBoostPrice$1$onSuccess$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            Price price = this.this$0.v().getPrice(PurchaseType.BOOST);
            if (!j.b(this.this$0.f11441j.f(), price)) {
                this.this$0.f11441j.o(price);
            }
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
