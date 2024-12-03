package com.squareup.workflow1.internal;

import com.squareup.workflow1.n;
import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.h;

@d(c = "com.squareup.workflow1.internal.WorkflowRunner$nextOutput$2$1", f = "WorkflowRunner.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@"}, d2 = {"PropsT", "OutputT", "RenderingT", "Lkotlinx/coroutines/channels/h;", "channelResult", "Lcom/squareup/workflow1/n;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class WorkflowRunner$nextOutput$2$1 extends SuspendLambda implements Function2<h<? extends PropsT>, c<? super n<? extends OutputT>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WorkflowRunner<PropsT, OutputT, RenderingT> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkflowRunner$nextOutput$2$1(WorkflowRunner<PropsT, OutputT, RenderingT> workflowRunner, c<? super WorkflowRunner$nextOutput$2$1> cVar) {
        super(2, cVar);
        this.this$0 = workflowRunner;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        WorkflowRunner$nextOutput$2$1 workflowRunner$nextOutput$2$1 = new WorkflowRunner$nextOutput$2$1(this.this$0, cVar);
        workflowRunner$nextOutput$2$1.L$0 = obj;
        return workflowRunner$nextOutput$2$1;
    }

    public final Object i(Object obj, c<? super n<? extends OutputT>> cVar) {
        return ((WorkflowRunner$nextOutput$2$1) create(h.b(obj), cVar)).invokeSuspend(Unit.f32013a);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return i(((h) obj).l(), (c) obj2);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            Object l10 = ((h) this.L$0).l();
            Throwable e10 = h.e(l10);
            if (e10 == null) {
                Object f10 = h.f(l10);
                if (f10 == null) {
                    return null;
                }
                WorkflowRunner<PropsT, OutputT, RenderingT> workflowRunner = this.this$0;
                if (j.b(workflowRunner.f23116c, f10)) {
                    return null;
                }
                workflowRunner.f23116c = f10;
                return null;
            }
            throw e10;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
