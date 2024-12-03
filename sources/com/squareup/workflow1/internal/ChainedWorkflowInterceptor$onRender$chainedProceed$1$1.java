package com.squareup.workflow1.internal;

import com.squareup.workflow1.a;
import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import pk.n;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"P", "S", "O", "R", "props", "state", "Lcom/squareup/workflow1/m$b;", "outerContextInterceptor", "a", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/squareup/workflow1/m$b;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class ChainedWorkflowInterceptor$onRender$chainedProceed$1$1 extends Lambda implements n<P, S, m.b<P, S, O>, R> {
    final /* synthetic */ a<P, S, O> $context;
    final /* synthetic */ n<P, S, m.b<P, S, O>, R> $proceedAcc;
    final /* synthetic */ m.c $session;
    final /* synthetic */ m $workflowInterceptor;
    final /* synthetic */ ChainedWorkflowInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChainedWorkflowInterceptor$onRender$chainedProceed$1$1(m mVar, a<? extends P, S, ? super O> aVar, m.c cVar, ChainedWorkflowInterceptor chainedWorkflowInterceptor, n<? super P, ? super S, ? super m.b<P, S, O>, ? extends R> nVar) {
        super(3);
        this.$workflowInterceptor = mVar;
        this.$context = aVar;
        this.$session = cVar;
        this.this$0 = chainedWorkflowInterceptor;
        this.$proceedAcc = nVar;
    }

    /* renamed from: a */
    public final R l(P p10, S s10, final m.b<P, S, O> bVar) {
        m mVar = this.$workflowInterceptor;
        a<P, S, O> aVar = this.$context;
        final ChainedWorkflowInterceptor chainedWorkflowInterceptor = this.this$0;
        final n<P, S, m.b<P, S, O>, R> nVar = this.$proceedAcc;
        return mVar.a(p10, s10, aVar, new n<P, S, m.b<P, S, O>, R>() {
            /* renamed from: a */
            public final R l(P p10, S s10, m.b<P, S, O> bVar) {
                return nVar.l(p10, s10, chainedWorkflowInterceptor.g(bVar, bVar));
            }
        }, this.$session);
    }
}
