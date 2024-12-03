package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class WorkflowInterceptorKt$intercept$1$initialState$1 extends FunctionReferenceImpl implements Function2<P, Snapshot, S> {
    WorkflowInterceptorKt$intercept$1$initialState$1(Object obj) {
        super(2, obj, h.class, "initialState", "initialState(Ljava/lang/Object;Lcom/squareup/workflow1/Snapshot;)Ljava/lang/Object;", 0);
    }

    /* renamed from: c */
    public final S invoke(P p10, Snapshot snapshot) {
        return ((h) this.receiver).d(p10, snapshot);
    }
}
