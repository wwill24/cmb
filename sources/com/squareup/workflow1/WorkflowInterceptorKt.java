package com.squareup.workflow1;

import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ad\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003*\u00020\u00042\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¨\u0006\n"}, d2 = {"P", "S", "O", "R", "Lcom/squareup/workflow1/m;", "Lcom/squareup/workflow1/h;", "workflow", "Lcom/squareup/workflow1/m$c;", "workflowSession", "a", "wf1-workflow-runtime"}, k = 2, mv = {1, 6, 0})
public final class WorkflowInterceptorKt {
    public static final <P, S, O, R> h<P, S, O, R> a(m mVar, h<? super P, S, ? extends O, ? extends R> hVar, m.c cVar) {
        j.g(mVar, "<this>");
        j.g(hVar, "workflow");
        j.g(cVar, "workflowSession");
        if (mVar == d.f23084a) {
            return hVar;
        }
        return new WorkflowInterceptorKt$intercept$1(mVar, hVar, cVar);
    }
}
