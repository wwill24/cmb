package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import wk.c;
import wk.m;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\"!\u0010\u0007\u001a\u00020\u0002*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lwk/m;", "type", "Lcom/squareup/workflow1/WorkflowIdentifier;", "b", "Lcom/squareup/workflow1/k;", "a", "(Lcom/squareup/workflow1/k;)Lcom/squareup/workflow1/WorkflowIdentifier;", "identifier", "wf1-workflow-core"}, k = 5, mv = {1, 6, 0}, xs = "com/squareup/workflow1/Workflows")
final /* synthetic */ class Workflows__WorkflowIdentifierKt {
    public static final WorkflowIdentifier a(k<?, ?, ?> kVar) {
        c cVar;
        WorkflowIdentifier workflowIdentifier;
        j.g(kVar, "<this>");
        Workflows__WorkflowIdentifierKt$identifier$1$1 workflows__WorkflowIdentifierKt$identifier$1$1 = null;
        if (kVar instanceof c) {
            cVar = (c) kVar;
        } else {
            cVar = null;
        }
        c b10 = l.b(kVar.getClass());
        if (cVar == null) {
            workflowIdentifier = null;
        } else {
            workflowIdentifier = cVar.c();
        }
        if (cVar != null) {
            workflows__WorkflowIdentifierKt$identifier$1$1 = new Workflows__WorkflowIdentifierKt$identifier$1$1(cVar);
        }
        return new WorkflowIdentifier(b10, workflowIdentifier, workflows__WorkflowIdentifierKt$identifier$1$1);
    }

    public static final WorkflowIdentifier b(m mVar) {
        j.g(mVar, "type");
        return new WorkflowIdentifier(mVar, (WorkflowIdentifier) null, (Function0) null, 6, (DefaultConstructorMarker) null);
    }
}
