package com.squareup.workflow1.internal;

import com.squareup.workflow1.Snapshot;
import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"P", "S", "props", "Lcom/squareup/workflow1/Snapshot;", "snapshot", "a", "(Ljava/lang/Object;Lcom/squareup/workflow1/Snapshot;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class ChainedWorkflowInterceptor$onInitialState$chainedProceed$1$1 extends Lambda implements Function2<P, Snapshot, S> {
    final /* synthetic */ Function2<P, Snapshot, S> $proceedAcc;
    final /* synthetic */ m.c $session;
    final /* synthetic */ m $workflowInterceptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChainedWorkflowInterceptor$onInitialState$chainedProceed$1$1(m mVar, Function2<? super P, ? super Snapshot, ? extends S> function2, m.c cVar) {
        super(2);
        this.$workflowInterceptor = mVar;
        this.$proceedAcc = function2;
        this.$session = cVar;
    }

    /* renamed from: a */
    public final S invoke(P p10, Snapshot snapshot) {
        return this.$workflowInterceptor.c(p10, snapshot, this.$proceedAcc, this.$session);
    }
}
