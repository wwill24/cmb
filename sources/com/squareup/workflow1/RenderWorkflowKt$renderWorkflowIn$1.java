package com.squareup.workflow1;

import com.squareup.workflow1.internal.WorkflowRunner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.k0;

@d(c = "com.squareup.workflow1.RenderWorkflowKt$renderWorkflowIn$1", f = "RenderWorkflow.kt", l = {136, 145}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u0003H@"}, d2 = {"PropsT", "OutputT", "RenderingT", "Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class RenderWorkflowKt$renderWorkflowIn$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ Function2<OutputT, c<? super Unit>, Object> $onOutput;
    final /* synthetic */ i<e<RenderingT>> $renderingsAndSnapshots;
    final /* synthetic */ WorkflowRunner<PropsT, OutputT, RenderingT> $runner;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RenderWorkflowKt$renderWorkflowIn$1(WorkflowRunner<PropsT, OutputT, RenderingT> workflowRunner, i<e<RenderingT>> iVar, Function2<? super OutputT, ? super c<? super Unit>, ? extends Object> function2, c<? super RenderWorkflowKt$renderWorkflowIn$1> cVar) {
        super(2, cVar);
        this.$runner = workflowRunner;
        this.$renderingsAndSnapshots = iVar;
        this.$onOutput = function2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        RenderWorkflowKt$renderWorkflowIn$1 renderWorkflowKt$renderWorkflowIn$1 = new RenderWorkflowKt$renderWorkflowIn$1(this.$runner, this.$renderingsAndSnapshots, this.$onOutput, cVar);
        renderWorkflowKt$renderWorkflowIn$1.L$0 = obj;
        return renderWorkflowKt$renderWorkflowIn$1;
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((RenderWorkflowKt$renderWorkflowIn$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.k0 r1 = (kotlinx.coroutines.k0) r1
            gk.g.b(r9)
            r9 = r1
            goto L_0x002f
        L_0x0017:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001f:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.k0 r1 = (kotlinx.coroutines.k0) r1
            gk.g.b(r9)
            r4 = r8
            goto L_0x0047
        L_0x0028:
            gk.g.b(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.k0 r9 = (kotlinx.coroutines.k0) r9
        L_0x002f:
            r1 = r8
        L_0x0030:
            boolean r4 = kotlinx.coroutines.l0.i(r9)
            if (r4 == 0) goto L_0x0073
            com.squareup.workflow1.internal.WorkflowRunner<PropsT, OutputT, RenderingT> r4 = r1.$runner
            r1.L$0 = r9
            r1.label = r3
            java.lang.Object r4 = r4.f(r1)
            if (r4 != r0) goto L_0x0043
            return r0
        L_0x0043:
            r7 = r1
            r1 = r9
            r9 = r4
            r4 = r7
        L_0x0047:
            com.squareup.workflow1.n r9 = (com.squareup.workflow1.n) r9
            boolean r5 = kotlinx.coroutines.l0.i(r1)
            if (r5 != 0) goto L_0x0052
            kotlin.Unit r9 = kotlin.Unit.f32013a
            return r9
        L_0x0052:
            kotlinx.coroutines.flow.i<com.squareup.workflow1.e<RenderingT>> r5 = r4.$renderingsAndSnapshots
            com.squareup.workflow1.internal.WorkflowRunner<PropsT, OutputT, RenderingT> r6 = r4.$runner
            com.squareup.workflow1.e r6 = r6.g()
            r5.setValue(r6)
            if (r9 != 0) goto L_0x0062
        L_0x005f:
            r9 = r1
            r1 = r4
            goto L_0x0030
        L_0x0062:
            kotlin.jvm.functions.Function2<OutputT, kotlin.coroutines.c<? super kotlin.Unit>, java.lang.Object> r5 = r4.$onOutput
            java.lang.Object r9 = r9.a()
            r4.L$0 = r1
            r4.label = r2
            java.lang.Object r9 = r5.invoke(r9, r4)
            if (r9 != r0) goto L_0x005f
            return r0
        L_0x0073:
            kotlin.Unit r9 = kotlin.Unit.f32013a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.RenderWorkflowKt$renderWorkflowIn$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
