package com.squareup.workflow1;

import com.squareup.workflow1.internal.WorkflowRunner;
import com.squareup.workflow1.internal.b;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.r;
import kotlinx.coroutines.flow.s;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00130\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"PropsT", "OutputT", "RenderingT", "Lcom/squareup/workflow1/k;", "workflow", "Lkotlinx/coroutines/k0;", "scope", "Lkotlinx/coroutines/flow/r;", "props", "Lcom/squareup/workflow1/TreeSnapshot;", "initialSnapshot", "", "Lcom/squareup/workflow1/m;", "interceptors", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "onOutput", "Lcom/squareup/workflow1/e;", "a", "(Lcom/squareup/workflow1/k;Lkotlinx/coroutines/k0;Lkotlinx/coroutines/flow/r;Lcom/squareup/workflow1/TreeSnapshot;Ljava/util/List;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/r;", "wf1-workflow-runtime"}, k = 2, mv = {1, 6, 0})
public final class RenderWorkflowKt {
    public static final <PropsT, OutputT, RenderingT> r<e<RenderingT>> a(k<? super PropsT, ? extends OutputT, ? extends RenderingT> kVar, k0 k0Var, r<? extends PropsT> rVar, TreeSnapshot treeSnapshot, List<? extends m> list, Function2<? super OutputT, ? super c<? super Unit>, ? extends Object> function2) {
        j.g(kVar, "workflow");
        j.g(k0Var, "scope");
        j.g(rVar, "props");
        j.g(list, "interceptors");
        j.g(function2, "onOutput");
        WorkflowRunner workflowRunner = new WorkflowRunner(k0Var, kVar, rVar, treeSnapshot, b.a(list));
        CancellationException cancellationException = null;
        try {
            i a10 = s.a(workflowRunner.g());
            s1 unused = j.d(k0Var, (CoroutineContext) null, (CoroutineStart) null, new RenderWorkflowKt$renderWorkflowIn$1(workflowRunner, a10, function2, (c<? super RenderWorkflowKt$renderWorkflowIn$1>) null), 3, (Object) null);
            return a10;
        } catch (Throwable th2) {
            if (th2 instanceof CancellationException) {
                cancellationException = th2;
            }
            if (cancellationException == null) {
                cancellationException = i1.a("Workflow runtime failed", th2);
            }
            workflowRunner.e(cancellationException);
            throw th2;
        }
    }
}
