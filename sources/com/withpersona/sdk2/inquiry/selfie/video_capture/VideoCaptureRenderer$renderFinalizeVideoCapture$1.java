package com.withpersona.sdk2.inquiry.selfie.video_capture;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s0;

@d(c = "com.withpersona.sdk2.inquiry.selfie.video_capture.VideoCaptureRenderer$renderFinalizeVideoCapture$1", f = "VideoCaptureRenderer.kt", l = {25}, m = "invokeSuspend")
final class VideoCaptureRenderer$renderFinalizeVideoCapture$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $context;
    final /* synthetic */ SelfieState.FinalizeVideoCapture $renderState;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoCaptureRenderer$renderFinalizeVideoCapture$1(SelfieState.FinalizeVideoCapture finalizeVideoCapture, h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar, c<? super VideoCaptureRenderer$renderFinalizeVideoCapture$1> cVar) {
        super(2, cVar);
        this.$renderState = finalizeVideoCapture;
        this.$context = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new VideoCaptureRenderer$renderFinalizeVideoCapture$1(this.$renderState, this.$context, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((VideoCaptureRenderer$renderFinalizeVideoCapture$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            long j10 = this.$renderState.j();
            this.label = 1;
            if (s0.a(j10, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$context.c().d(Workflows__WorkflowActionKt.c((String) null, AnonymousClass1.f27438a, 1, (Object) null));
        return Unit.f32013a;
    }
}
