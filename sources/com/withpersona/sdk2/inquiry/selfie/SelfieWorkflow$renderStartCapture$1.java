package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieWorkflow$renderStartCapture$1 extends Lambda implements Function1<SelfieDetectWorker.a, l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>> {
    final /* synthetic */ SelfieState.StartCapture $renderState;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderStartCapture$1(SelfieWorkflow selfieWorkflow, SelfieState.StartCapture startCapture) {
        super(1);
        this.this$0 = selfieWorkflow;
        this.$renderState = startCapture;
    }

    /* renamed from: a */
    public final l<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c> invoke(final SelfieDetectWorker.a aVar) {
        j.g(aVar, "output");
        SelfieWorkflow selfieWorkflow = this.this$0;
        final SelfieState.StartCapture startCapture = this.$renderState;
        return Workflows__StatefulWorkflowKt.d(selfieWorkflow, (String) null, new Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit>() {
            public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
                Object obj;
                j.g(cVar, "$this$action");
                Object c10 = cVar.c();
                j.e(c10, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.selfie.SelfieState.StartCapture");
                SelfieState.StartCapture startCapture = (SelfieState.StartCapture) c10;
                SelfieDetectWorker.a aVar = aVar;
                if (j.b(aVar, SelfieDetectWorker.a.b.f27219a)) {
                    obj = new SelfieState.StartCaptureFaceDetected(startCapture.f(), startCapture.d());
                } else if (!(aVar instanceof SelfieDetectWorker.a.C0327a)) {
                    throw new NoWhenBranchMatchedException();
                } else if (((SelfieDetectWorker.a.C0327a) aVar).a() == SelfieError.FaceDetectionUnsupported) {
                    obj = SelfieState.StartCapture.i(startCapture, false, (SelfieError) null, (List) null, 0, false, 14, (Object) null);
                } else {
                    obj = SelfieState.StartCapture.i(startCapture, false, ((SelfieDetectWorker.a.C0327a) aVar).a(), (List) null, 0, false, 28, (Object) null);
                }
                cVar.e(obj);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}
