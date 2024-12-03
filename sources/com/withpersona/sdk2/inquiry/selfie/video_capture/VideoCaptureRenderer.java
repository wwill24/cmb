package com.withpersona.sdk2.inquiry.selfie.video_capture;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflowUtilsKt;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;

public final class VideoCaptureRenderer {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f27437a;

    public VideoCaptureRenderer(Context context) {
        j.g(context, "applicationContext");
        this.f27437a = context;
    }

    public final Object b(SelfieWorkflow.b bVar, SelfieState.FinalizeVideoCapture finalizeVideoCapture, h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar) {
        SelfieWorkflow.Screen.CameraScreen.Overlay overlay;
        j.g(bVar, "renderProps");
        j.g(finalizeVideoCapture, "renderState");
        j.g(aVar, IdentityHttpResponse.CONTEXT);
        aVar.a("finalize_delay", new VideoCaptureRenderer$renderFinalizeVideoCapture$1(finalizeVideoCapture, aVar, (c<? super VideoCaptureRenderer$renderFinalizeVideoCapture$1>) null));
        StepStyles$SelfieStepStyle s10 = bVar.s();
        boolean k10 = finalizeVideoCapture.k();
        if (finalizeVideoCapture.l()) {
            overlay = SelfieWorkflow.Screen.CameraScreen.Overlay.COMPLETE;
        } else {
            overlay = SelfieWorkflow.Screen.CameraScreen.Overlay.FINALIZING;
        }
        return new SelfieWorkflow.Screen.CameraScreen((String) null, new SelfieWorkflow.Screen.CameraScreen.a.c(new VideoCaptureRenderer$renderFinalizeVideoCapture$2(aVar), new VideoCaptureRenderer$renderFinalizeVideoCapture$3(aVar), k10, overlay), s10, new VideoCaptureRenderer$renderFinalizeVideoCapture$4(aVar), SelfieWorkflowUtilsKt.a(aVar), new VideoCaptureRenderer$renderFinalizeVideoCapture$5(this, aVar, bVar), bVar.t().b());
    }
}
