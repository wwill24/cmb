package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieWorkflow$renderCapture$1 extends Lambda implements Function1<SelfieAnalyzeWorker.c, l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>> {
    final /* synthetic */ SelfieWorkflow.b $renderProps;
    final /* synthetic */ SelfieState.Capture $renderState;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderCapture$1(SelfieWorkflow selfieWorkflow, SelfieState.Capture capture, SelfieWorkflow.b bVar) {
        super(1);
        this.this$0 = selfieWorkflow;
        this.$renderState = capture;
        this.$renderProps = bVar;
    }

    /* renamed from: a */
    public final l<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c> invoke(final SelfieAnalyzeWorker.c cVar) {
        j.g(cVar, "output");
        final SelfieWorkflow selfieWorkflow = this.this$0;
        final SelfieState.Capture capture = this.$renderState;
        final SelfieWorkflow.b bVar = this.$renderProps;
        return Workflows__StatefulWorkflowKt.d(selfieWorkflow, (String) null, new Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit>() {
            public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
                j.g(cVar, "$this$action");
                SelfieAnalyzeWorker.c cVar2 = cVar;
                if (cVar2 instanceof SelfieAnalyzeWorker.c.b) {
                    cVar.e(selfieWorkflow.k(capture, bVar, ((SelfieAnalyzeWorker.c.b) cVar2).a()));
                } else if (cVar2 instanceof SelfieAnalyzeWorker.c.a) {
                    cVar.e(SelfieState.Capture.i(capture, (List) null, (List) null, (SelfieError) null, 0, false, 15, (Object) null));
                } else if (cVar2 instanceof SelfieAnalyzeWorker.c.C0326c) {
                    cVar.e(SelfieState.Capture.i(capture, (List) null, (List) null, ((SelfieAnalyzeWorker.c.C0326c) cVar2).a(), 0, false, 27, (Object) null));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}
