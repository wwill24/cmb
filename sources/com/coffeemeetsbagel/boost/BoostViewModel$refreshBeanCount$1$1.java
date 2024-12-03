package com.coffeemeetsbagel.boost;

import androidx.lifecycle.t;
import com.coffeemeetsbagel.models.NetworkProfile;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.boost.BoostViewModel$refreshBeanCount$1$1", f = "BoostViewModel.kt", l = {}, m = "invokeSuspend")
final class BoostViewModel$refreshBeanCount$1$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ BoostViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoostViewModel$refreshBeanCount$1$1(BoostViewModel boostViewModel, c<? super BoostViewModel$refreshBeanCount$1$1> cVar) {
        super(2, cVar);
        this.this$0 = boostViewModel;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new BoostViewModel$refreshBeanCount$1$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((BoostViewModel$refreshBeanCount$1$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            Long l10 = (Long) this.this$0.f11440i.f();
            NetworkProfile j10 = this.this$0.t().j();
            j.d(j10);
            long beans = j10.getBeans();
            if (l10 == null || l10.longValue() != beans) {
                t g10 = this.this$0.f11440i;
                NetworkProfile j11 = this.this$0.t().j();
                j.d(j11);
                g10.o(a.c(j11.getBeans()));
            }
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
