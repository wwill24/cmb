package com.squareup.workflow1.internal;

import com.squareup.workflow1.l;
import com.squareup.workflow1.n;
import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;

@d(c = "com.squareup.workflow1.internal.WorkflowNode$tick$1$1", f = "WorkflowNode.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u00042\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005H@"}, d2 = {"T", "PropsT", "StateT", "OutputT", "RenderingT", "Lcom/squareup/workflow1/l;", "action", "Lcom/squareup/workflow1/n;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class WorkflowNode$tick$1$1 extends SuspendLambda implements Function2<l<? super PropsT, StateT, ? extends OutputT>, c<? super n<? extends T>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WorkflowNode<PropsT, StateT, OutputT, RenderingT> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkflowNode$tick$1$1(WorkflowNode<PropsT, StateT, OutputT, RenderingT> workflowNode, c<? super WorkflowNode$tick$1$1> cVar) {
        super(2, cVar);
        this.this$0 = workflowNode;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        WorkflowNode$tick$1$1 workflowNode$tick$1$1 = new WorkflowNode$tick$1$1(this.this$0, cVar);
        workflowNode$tick$1$1.L$0 = obj;
        return workflowNode$tick$1$1;
    }

    /* renamed from: i */
    public final Object invoke(l<? super PropsT, StateT, ? extends OutputT> lVar, c<? super n<? extends T>> cVar) {
        return ((WorkflowNode$tick$1$1) create(lVar, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            return this.this$0.c((l) this.L$0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
