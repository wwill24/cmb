package com.squareup.workflow1.ui;

import androidx.lifecycle.a0;
import com.squareup.workflow1.e;
import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;

@d(c = "com.squareup.workflow1.ui.AndroidRenderWorkflowKt$renderWorkflowIn$4", f = "AndroidRenderWorkflow.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003H@"}, d2 = {"PropsT", "OutputT", "RenderingT", "Lcom/squareup/workflow1/e;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class AndroidRenderWorkflowKt$renderWorkflowIn$4 extends SuspendLambda implements Function2<e<? extends RenderingT>, c<? super Unit>, Object> {
    final /* synthetic */ a0 $savedStateHandle;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidRenderWorkflowKt$renderWorkflowIn$4(a0 a0Var, c<? super AndroidRenderWorkflowKt$renderWorkflowIn$4> cVar) {
        super(2, cVar);
        this.$savedStateHandle = a0Var;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        AndroidRenderWorkflowKt$renderWorkflowIn$4 androidRenderWorkflowKt$renderWorkflowIn$4 = new AndroidRenderWorkflowKt$renderWorkflowIn$4(this.$savedStateHandle, cVar);
        androidRenderWorkflowKt$renderWorkflowIn$4.L$0 = obj;
        return androidRenderWorkflowKt$renderWorkflowIn$4;
    }

    /* renamed from: i */
    public final Object invoke(e<? extends RenderingT> eVar, c<? super Unit> cVar) {
        return ((AndroidRenderWorkflowKt$renderWorkflowIn$4) create(eVar, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            e eVar = (e) this.L$0;
            a0 a0Var = this.$savedStateHandle;
            if (a0Var != null) {
                a0Var.i("com.squareup.workflow1.ui.renderWorkflowIn-snapshot", new PickledTreesnapshot(eVar.b()));
            }
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
