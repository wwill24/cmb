package com.squareup.workflow1.internal;

import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"P", "S", "O", "", "iKey", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "", "iSideEffect", "a", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V"}, k = 3, mv = {1, 6, 0})
final class ChainedWorkflowInterceptor$wrap$1$onRunningSideEffect$1 extends Lambda implements Function2<String, Function1<? super c<? super Unit>, ? extends Object>, Unit> {
    final /* synthetic */ m.b<P, S, O> $inner;
    final /* synthetic */ Function2<String, Function1<? super c<? super Unit>, ? extends Object>, Unit> $proceed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChainedWorkflowInterceptor$wrap$1$onRunningSideEffect$1(m.b<P, S, O> bVar, Function2<? super String, ? super Function1<? super c<? super Unit>, ? extends Object>, Unit> function2) {
        super(2);
        this.$inner = bVar;
        this.$proceed = function2;
    }

    public final void a(String str, Function1<? super c<? super Unit>, ? extends Object> function1) {
        j.g(str, "iKey");
        j.g(function1, "iSideEffect");
        this.$inner.b(str, function1, this.$proceed);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((String) obj, (Function1) obj2);
        return Unit.f32013a;
    }
}
