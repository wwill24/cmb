package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieWorkflow$renderCountdownToCapture$1 extends Lambda implements Function1<SelfieDetectWorker.a, l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>> {
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderCountdownToCapture$1(SelfieWorkflow selfieWorkflow) {
        super(1);
        this.this$0 = selfieWorkflow;
    }

    /* renamed from: a */
    public final l<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c> invoke(final SelfieDetectWorker.a aVar) {
        j.g(aVar, "output");
        return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit>() {
            public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
                SelfieState.CountdownToCapture countdownToCapture;
                j.g(cVar, "$this$action");
                Object c10 = cVar.c();
                if (c10 instanceof SelfieState.CountdownToCapture) {
                    countdownToCapture = (SelfieState.CountdownToCapture) c10;
                } else {
                    countdownToCapture = null;
                }
                SelfieState.CountdownToCapture countdownToCapture2 = countdownToCapture;
                if (countdownToCapture2 != null) {
                    SelfieDetectWorker.a aVar = aVar;
                    if (aVar instanceof SelfieDetectWorker.a.C0327a) {
                        cVar.e(SelfieState.CountdownToCapture.i(countdownToCapture2, 0, ((SelfieDetectWorker.a.C0327a) aVar).a(), (List) null, 0, 13, (Object) null));
                    }
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}
