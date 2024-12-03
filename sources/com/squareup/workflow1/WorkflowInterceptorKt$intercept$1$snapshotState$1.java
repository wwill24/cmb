package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class WorkflowInterceptorKt$intercept$1$snapshotState$1 extends FunctionReferenceImpl implements Function1<S, Snapshot> {
    WorkflowInterceptorKt$intercept$1$snapshotState$1(Object obj) {
        super(1, obj, h.class, "snapshotState", "snapshotState(Ljava/lang/Object;)Lcom/squareup/workflow1/Snapshot;", 0);
    }

    /* renamed from: c */
    public final Snapshot invoke(S s10) {
        return ((h) this.receiver).g(s10);
    }
}
