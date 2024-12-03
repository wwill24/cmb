package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/squareup/workflow1/WorkflowIdentifier;", "it", "", "a", "(Lcom/squareup/workflow1/WorkflowIdentifier;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
final class WorkflowIdentifier$toString$1 extends Lambda implements Function1<WorkflowIdentifier, CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final WorkflowIdentifier$toString$1 f23072a = new WorkflowIdentifier$toString$1();

    WorkflowIdentifier$toString$1() {
        super(1);
    }

    /* renamed from: a */
    public final CharSequence invoke(WorkflowIdentifier workflowIdentifier) {
        j.g(workflowIdentifier, "it");
        return workflowIdentifier.d();
    }
}
