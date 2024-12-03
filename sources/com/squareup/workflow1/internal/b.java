package com.squareup.workflow1.internal;

import com.squareup.workflow1.d;
import com.squareup.workflow1.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¨\u0006\u0003"}, d2 = {"", "Lcom/squareup/workflow1/m;", "a", "wf1-workflow-runtime"}, k = 2, mv = {1, 6, 0})
public final class b {
    public static final m a(List<? extends m> list) {
        j.g(list, "<this>");
        if (list.isEmpty()) {
            return d.f23084a;
        }
        if (list.size() == 1) {
            return (m) CollectionsKt___CollectionsKt.m0(list);
        }
        return new ChainedWorkflowInterceptor(list);
    }
}
