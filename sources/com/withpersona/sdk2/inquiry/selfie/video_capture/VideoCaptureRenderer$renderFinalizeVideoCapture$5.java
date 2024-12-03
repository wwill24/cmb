package com.withpersona.sdk2.inquiry.selfie.video_capture;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflowUtilsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class VideoCaptureRenderer$renderFinalizeVideoCapture$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $context;
    final /* synthetic */ SelfieWorkflow.b $renderProps;
    final /* synthetic */ VideoCaptureRenderer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoCaptureRenderer$renderFinalizeVideoCapture$5(VideoCaptureRenderer videoCaptureRenderer, h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar, SelfieWorkflow.b bVar) {
        super(0);
        this.this$0 = videoCaptureRenderer;
        this.$context = aVar;
        this.$renderProps = bVar;
    }

    public final void invoke() {
        SelfieWorkflowUtilsKt.b(this.this$0.f27437a, this.$context, this.$renderProps);
    }
}
