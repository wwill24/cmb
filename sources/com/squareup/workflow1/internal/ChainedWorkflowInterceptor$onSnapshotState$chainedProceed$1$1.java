package com.squareup.workflow1.internal;

import com.squareup.workflow1.Snapshot;
import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"S", "state", "Lcom/squareup/workflow1/Snapshot;", "a", "(Ljava/lang/Object;)Lcom/squareup/workflow1/Snapshot;"}, k = 3, mv = {1, 6, 0})
final class ChainedWorkflowInterceptor$onSnapshotState$chainedProceed$1$1 extends Lambda implements Function1<S, Snapshot> {
    final /* synthetic */ Function1<S, Snapshot> $proceedAcc;
    final /* synthetic */ m.c $session;
    final /* synthetic */ m $workflowInterceptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChainedWorkflowInterceptor$onSnapshotState$chainedProceed$1$1(m mVar, Function1<? super S, Snapshot> function1, m.c cVar) {
        super(1);
        this.$workflowInterceptor = mVar;
        this.$proceedAcc = function1;
        this.$session = cVar;
    }

    /* renamed from: a */
    public final Snapshot invoke(S s10) {
        return this.$workflowInterceptor.b(s10, this.$proceedAcc, this.$session);
    }
}
