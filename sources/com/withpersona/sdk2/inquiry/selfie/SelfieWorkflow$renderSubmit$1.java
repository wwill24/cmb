package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieWorkflow$renderSubmit$1 extends Lambda implements Function1<SubmitVerificationWorker.b, l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>> {
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderSubmit$1(SelfieWorkflow selfieWorkflow) {
        super(1);
        this.this$0 = selfieWorkflow;
    }

    /* renamed from: a */
    public final l<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c> invoke(final SubmitVerificationWorker.b bVar) {
        j.g(bVar, "it");
        if (bVar instanceof SubmitVerificationWorker.b.C0330b) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass1.f27390a, 1, (Object) null);
        }
        if (bVar instanceof SubmitVerificationWorker.b.a) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit>() {
                public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.d(new SelfieWorkflow.c.C0329c(((SubmitVerificationWorker.b.a) bVar).a()));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
