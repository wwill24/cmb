package com.withpersona.sdk2.inquiry.selfie.video_capture;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class VideoCaptureRenderer$renderFinalizeVideoCapture$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoCaptureRenderer$renderFinalizeVideoCapture$4(h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar) {
        super(0);
        this.$context = aVar;
    }

    public final void invoke() {
        this.$context.c().d(Workflows__WorkflowActionKt.c((String) null, AnonymousClass1.f27440a, 1, (Object) null));
    }
}
