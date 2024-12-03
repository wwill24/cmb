package com.squareup.workflow1.internal;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;

@d(c = "com.squareup.workflow1.internal.WorkflowRunner$propsChannel$1", f = "WorkflowRunner.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H@"}, d2 = {"PropsT", "OutputT", "RenderingT", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class WorkflowRunner$propsChannel$1 extends SuspendLambda implements Function2<PropsT, c<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WorkflowRunner<PropsT, OutputT, RenderingT> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkflowRunner$propsChannel$1(WorkflowRunner<PropsT, OutputT, RenderingT> workflowRunner, c<? super WorkflowRunner$propsChannel$1> cVar) {
        super(2, cVar);
        this.this$0 = workflowRunner;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        WorkflowRunner$propsChannel$1 workflowRunner$propsChannel$1 = new WorkflowRunner$propsChannel$1(this.this$0, cVar);
        workflowRunner$propsChannel$1.L$0 = obj;
        return workflowRunner$propsChannel$1;
    }

    /* renamed from: i */
    public final Object invoke(PropsT propst, c<? super Boolean> cVar) {
        return ((WorkflowRunner$propsChannel$1) create(propst, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            return a.a(j.b(this.L$0, this.this$0.f23116c));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
