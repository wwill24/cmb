package com.squareup.workflow1;

import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import pk.n;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"P", "S", "O", "R", "props", "state", "Lcom/squareup/workflow1/m$b;", "interceptor", "a", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/squareup/workflow1/m$b;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class WorkflowInterceptorKt$intercept$1$render$1 extends Lambda implements n<P, S, m.b<P, S, O>, R> {
    final /* synthetic */ h<P, S, O, R>.a $context;
    final /* synthetic */ h<P, S, O, R> $workflow;
    final /* synthetic */ WorkflowInterceptorKt$intercept$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkflowInterceptorKt$intercept$1$render$1(h<? super P, S, ? extends O, ? extends R>.a aVar, h<? super P, S, ? extends O, ? extends R> hVar, WorkflowInterceptorKt$intercept$1 workflowInterceptorKt$intercept$1) {
        super(3);
        this.$context = aVar;
        this.$workflow = hVar;
        this.this$0 = workflowInterceptorKt$intercept$1;
    }

    /* renamed from: a */
    public final R l(P p10, S s10, m.b<P, S, O> bVar) {
        a aVar;
        if (bVar == null) {
            aVar = null;
        } else {
            aVar = new InterceptedRenderContext(this.$context, bVar);
        }
        if (aVar == null) {
            aVar = this.$context;
        }
        return this.$workflow.f(p10, s10, o.a(aVar, this.this$0));
    }
}
