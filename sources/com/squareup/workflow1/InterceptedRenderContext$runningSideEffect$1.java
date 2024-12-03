package com.squareup.workflow1;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"P", "S", "O", "", "iKey", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "", "iSideEffect", "a", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V"}, k = 3, mv = {1, 6, 0})
final class InterceptedRenderContext$runningSideEffect$1 extends Lambda implements Function2<String, Function1<? super c<? super Unit>, ? extends Object>, Unit> {
    final /* synthetic */ InterceptedRenderContext<P, S, O> this$0;

    @d(c = "com.squareup.workflow1.InterceptedRenderContext$runningSideEffect$1$1", f = "WorkflowInterceptor.kt", l = {306}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u0003H@"}, d2 = {"P", "S", "O", "Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    /* renamed from: com.squareup.workflow1.InterceptedRenderContext$runningSideEffect$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(function1, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                Function1<c<? super Unit>, Object> function1 = function1;
                this.label = 1;
                if (function1.invoke(this) == d10) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InterceptedRenderContext$runningSideEffect$1(InterceptedRenderContext<P, S, O> interceptedRenderContext) {
        super(2);
        this.this$0 = interceptedRenderContext;
    }

    public final void a(String str, final Function1<? super c<? super Unit>, ? extends Object> function1) {
        j.g(str, "iKey");
        j.g(function1, "iSideEffect");
        this.this$0.f23052a.a(str, new AnonymousClass1((c<? super AnonymousClass1>) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((String) obj, (Function1) obj2);
        return Unit.f32013a;
    }
}
