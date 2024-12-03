package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$run$4", f = "DocumentWorkflow.kt", l = {}, m = "invokeSuspend")
final class DocumentWorkflow$render$run$4 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ h<DocumentWorkflow.b, DocumentWorkflow.State, DocumentWorkflow.c, Object>.a $context;
    int label;
    final /* synthetic */ DocumentWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentWorkflow$render$run$4(h<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c, ? extends Object>.a aVar, DocumentWorkflow documentWorkflow, c<? super DocumentWorkflow$render$run$4> cVar) {
        super(2, cVar);
        this.$context = aVar;
        this.this$0 = documentWorkflow;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new DocumentWorkflow$render$run$4(this.$context, this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((DocumentWorkflow$render$run$4) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            this.$context.c().d(Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass1.f25128a, 1, (Object) null));
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
