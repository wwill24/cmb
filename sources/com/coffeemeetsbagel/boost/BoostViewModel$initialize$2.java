package com.coffeemeetsbagel.boost;

import androidx.lifecycle.g0;
import com.coffeemeetsbagel.utils.model.Optional;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

@d(c = "com.coffeemeetsbagel.boost.BoostViewModel$initialize$2", f = "BoostViewModel.kt", l = {}, m = "invokeSuspend")
final class BoostViewModel$initialize$2 extends SuspendLambda implements Function2<k0, c<? super s1>, Object> {
    int label;
    final /* synthetic */ BoostViewModel this$0;

    @d(c = "com.coffeemeetsbagel.boost.BoostViewModel$initialize$2$1", f = "BoostViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.boost.BoostViewModel$initialize$2$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(boostViewModel, i10, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = b.d();
            if (this.label == 0) {
                g.b(obj);
                if (!j.b(boostViewModel.f11442k.f(), a.a(i10.d()))) {
                    boostViewModel.f11442k.o(a.a(i10.d()));
                }
                return Unit.f32013a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoostViewModel$initialize$2(BoostViewModel boostViewModel, c<? super BoostViewModel$initialize$2> cVar) {
        super(2, cVar);
        this.this$0 = boostViewModel;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new BoostViewModel$initialize$2(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super s1> cVar) {
        return ((BoostViewModel$initialize$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            final Optional i10 = this.this$0.w().T().i(Optional.a());
            k0 a10 = g0.a(this.this$0);
            final BoostViewModel boostViewModel = this.this$0;
            return j.d(a10, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
