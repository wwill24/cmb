package com.squareup.workflow1;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;

@d(c = "com.squareup.workflow1.InterceptedRenderContext$runningSideEffect$withScopeReceiver$1", f = "WorkflowInterceptor.kt", l = {301}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002H@"}, d2 = {"P", "S", "O", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class InterceptedRenderContext$runningSideEffect$withScopeReceiver$1 extends SuspendLambda implements Function1<c<? super Unit>, Object> {
    final /* synthetic */ Function2<k0, c<? super Unit>, Object> $sideEffect;
    int label;
    final /* synthetic */ InterceptedRenderContext<P, S, O> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InterceptedRenderContext$runningSideEffect$withScopeReceiver$1(Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2, InterceptedRenderContext<P, S, O> interceptedRenderContext, c<? super InterceptedRenderContext$runningSideEffect$withScopeReceiver$1> cVar) {
        super(1, cVar);
        this.$sideEffect = function2;
        this.this$0 = interceptedRenderContext;
    }

    public final c<Unit> create(c<?> cVar) {
        return new InterceptedRenderContext$runningSideEffect$withScopeReceiver$1(this.$sideEffect, this.this$0, cVar);
    }

    /* renamed from: i */
    public final Object invoke(c<? super Unit> cVar) {
        return ((InterceptedRenderContext$runningSideEffect$withScopeReceiver$1) create(cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            Function2<k0, c<? super Unit>, Object> function2 = this.$sideEffect;
            k0 a10 = l0.a(getContext());
            this.label = 1;
            if (function2.invoke(a10, this) == d10) {
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
