package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"P", "S", "O", "Lcom/squareup/workflow1/l;", "interceptedAction", "", "a", "(Lcom/squareup/workflow1/l;)V"}, k = 3, mv = {1, 6, 0})
final class InterceptedRenderContext$send$1 extends Lambda implements Function1<l<? super P, S, ? extends O>, Unit> {
    final /* synthetic */ InterceptedRenderContext<P, S, O> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InterceptedRenderContext$send$1(InterceptedRenderContext<P, S, O> interceptedRenderContext) {
        super(1);
        this.this$0 = interceptedRenderContext;
    }

    public final void a(l<? super P, S, ? extends O> lVar) {
        j.g(lVar, "interceptedAction");
        this.this$0.f23052a.c().d(lVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l) obj);
        return Unit.f32013a;
    }
}
