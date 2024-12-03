package com.squareup.workflow1.internal;

import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import pk.n;

@Metadata(bv = {}, d1 = {"\u0000\u0004\n\u0002\b\u0007\u0010\u0005\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"P", "S", "old", "new", "state", "l", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class ChainedWorkflowInterceptor$onPropsChanged$chainedProceed$1$1 extends Lambda implements n<P, P, S, S> {
    final /* synthetic */ n<P, P, S, S> $proceedAcc;
    final /* synthetic */ m.c $session;
    final /* synthetic */ m $workflowInterceptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChainedWorkflowInterceptor$onPropsChanged$chainedProceed$1$1(m mVar, n<? super P, ? super P, ? super S, ? extends S> nVar, m.c cVar) {
        super(3);
        this.$workflowInterceptor = mVar;
        this.$proceedAcc = nVar;
        this.$session = cVar;
    }

    public final S l(P p10, P p11, S s10) {
        return this.$workflowInterceptor.e(p10, p11, s10, this.$proceedAcc, this.$session);
    }
}
