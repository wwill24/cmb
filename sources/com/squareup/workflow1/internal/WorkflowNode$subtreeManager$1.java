package com.squareup.workflow1.internal;

import com.squareup.workflow1.l;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class WorkflowNode$subtreeManager$1 extends FunctionReferenceImpl implements Function1<l<? super PropsT, StateT, ? extends OutputT>, Object> {
    WorkflowNode$subtreeManager$1(Object obj) {
        super(1, obj, WorkflowNode.class, "applyAction", "applyAction(Lcom/squareup/workflow1/WorkflowAction;)Ljava/lang/Object;", 0);
    }

    /* renamed from: c */
    public final Object invoke(l<? super PropsT, StateT, ? extends OutputT> lVar) {
        j.g(lVar, "p0");
        return ((WorkflowNode) this.receiver).c(lVar);
    }
}
