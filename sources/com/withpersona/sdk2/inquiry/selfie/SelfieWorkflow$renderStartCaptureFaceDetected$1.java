package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieWorkflow$renderStartCaptureFaceDetected$1 extends Lambda implements Function1<SelfieDetectWorker.a, l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>> {
    final /* synthetic */ SelfieState.StartCaptureFaceDetected $renderState;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderStartCaptureFaceDetected$1(SelfieWorkflow selfieWorkflow, SelfieState.StartCaptureFaceDetected startCaptureFaceDetected) {
        super(1);
        this.this$0 = selfieWorkflow;
        this.$renderState = startCaptureFaceDetected;
    }

    /* renamed from: a */
    public final l<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c> invoke(final SelfieDetectWorker.a aVar) {
        j.g(aVar, "output");
        SelfieWorkflow selfieWorkflow = this.this$0;
        final SelfieState.StartCaptureFaceDetected startCaptureFaceDetected = this.$renderState;
        return Workflows__StatefulWorkflowKt.d(selfieWorkflow, (String) null, new Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit>() {
            public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
                j.g(cVar, "$this$action");
                if (aVar instanceof SelfieDetectWorker.a.C0327a) {
                    cVar.e(new SelfieState.StartCapture(false, ((SelfieDetectWorker.a.C0327a) aVar).a(), startCaptureFaceDetected.f(), startCaptureFaceDetected.d(), false, 17, (DefaultConstructorMarker) null));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}
