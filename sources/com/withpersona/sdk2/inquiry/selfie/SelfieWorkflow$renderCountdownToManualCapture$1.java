package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s0;

@d(c = "com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$renderCountdownToManualCapture$1", f = "SelfieWorkflow.kt", l = {524}, m = "invokeSuspend")
final class SelfieWorkflow$renderCountdownToManualCapture$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $context;
    int label;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderCountdownToManualCapture$1(h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar, SelfieWorkflow selfieWorkflow, c<? super SelfieWorkflow$renderCountdownToManualCapture$1> cVar) {
        super(2, cVar);
        this.$context = aVar;
        this.this$0 = selfieWorkflow;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SelfieWorkflow$renderCountdownToManualCapture$1(this.$context, this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((SelfieWorkflow$renderCountdownToManualCapture$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            this.label = 1;
            if (s0.a(1000, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$context.c().d(Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass1.f27381a, 1, (Object) null));
        return Unit.f32013a;
    }
}
