package com.withpersona.sdk2.inquiry.governmentid.video_capture;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.governmentid.capture_tips.d;
import com.withpersona.sdk2.inquiry.permissions.b;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class VideoCaptureRenderer {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f26016a;

    public VideoCaptureRenderer(Context context) {
        j.g(context, "applicationContext");
        this.f26016a = context;
    }

    public final Object b(GovernmentIdWorkflow.a aVar, GovernmentIdState.FinalizeVideo finalizeVideo, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2) {
        IdPart.SideIdPart sideIdPart;
        IdConfig.Side side;
        GovernmentIdWorkflow.a aVar3 = aVar;
        GovernmentIdState.FinalizeVideo finalizeVideo2 = finalizeVideo;
        h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar4 = aVar2;
        j.g(aVar3, "renderProps");
        j.g(finalizeVideo2, "renderState");
        j.g(aVar4, IdentityHttpResponse.CONTEXT);
        aVar4.a("finalize_delay", new VideoCaptureRenderer$renderFinalizeVideo$1(finalizeVideo2, aVar4, (c<? super VideoCaptureRenderer$renderFinalizeVideo$1>) null));
        IdPart n10 = finalizeVideo.n();
        if (n10 instanceof IdPart.SideIdPart) {
            sideIdPart = (IdPart.SideIdPart) n10;
        } else {
            sideIdPart = null;
        }
        if (sideIdPart == null || (side = sideIdPart.a()) == null) {
            side = IdConfig.Side.Front;
        }
        IdConfig.Side side2 = side;
        IdConfig.IdSideConfig d10 = finalizeVideo.o().d(side2);
        String n11 = aVar.r().n();
        String m10 = aVar.r().m();
        GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture manualCapture = GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Disabled;
        GovernmentIdWorkflow.Screen.Overlay d11 = d10.d();
        boolean a10 = aVar.a();
        boolean b10 = aVar.b();
        List j10 = q.j();
        int h10 = finalizeVideo.h();
        StepStyles$GovernmentIdStepStyle s10 = aVar.s();
        Function1<Throwable, Unit> d12 = GovernmentIdWorkflowUtilsKt.d(aVar2);
        boolean b11 = aVar.u().b();
        long a11 = aVar.u().a();
        boolean q10 = finalizeVideo.q();
        VideoCaptureRenderer$renderFinalizeVideo$2 videoCaptureRenderer$renderFinalizeVideo$2 = VideoCaptureRenderer$renderFinalizeVideo$2.f26018a;
        VideoCaptureRenderer$renderFinalizeVideo$3 videoCaptureRenderer$renderFinalizeVideo$3 = new VideoCaptureRenderer$renderFinalizeVideo$3(aVar4);
        VideoCaptureRenderer$renderFinalizeVideo$4 videoCaptureRenderer$renderFinalizeVideo$4 = r4;
        VideoCaptureRenderer$renderFinalizeVideo$4 videoCaptureRenderer$renderFinalizeVideo$42 = new VideoCaptureRenderer$renderFinalizeVideo$4(aVar4);
        VideoCaptureRenderer$renderFinalizeVideo$5 videoCaptureRenderer$renderFinalizeVideo$5 = VideoCaptureRenderer$renderFinalizeVideo$5.f26020a;
        VideoCaptureRenderer$renderFinalizeVideo$6 videoCaptureRenderer$renderFinalizeVideo$6 = VideoCaptureRenderer$renderFinalizeVideo$6.f26021a;
        VideoCaptureRenderer$renderFinalizeVideo$7 videoCaptureRenderer$renderFinalizeVideo$7 = r4;
        GovernmentIdWorkflow.Screen.CameraScreen cameraScreen = r5;
        VideoCaptureRenderer$renderFinalizeVideo$7 videoCaptureRenderer$renderFinalizeVideo$72 = new VideoCaptureRenderer$renderFinalizeVideo$7(this, aVar4, aVar3);
        VideoCaptureRenderer$renderFinalizeVideo$8 videoCaptureRenderer$renderFinalizeVideo$8 = r4;
        VideoCaptureRenderer$renderFinalizeVideo$8 videoCaptureRenderer$renderFinalizeVideo$82 = new VideoCaptureRenderer$renderFinalizeVideo$8(finalizeVideo2, aVar4, aVar3);
        GovernmentIdWorkflow.Screen.CameraScreen cameraScreen2 = new GovernmentIdWorkflow.Screen.CameraScreen(n11, m10, side2, manualCapture, d11, videoCaptureRenderer$renderFinalizeVideo$2, a10, b10, videoCaptureRenderer$renderFinalizeVideo$3, videoCaptureRenderer$renderFinalizeVideo$4, false, j10, h10, s10, (Function1) null, videoCaptureRenderer$renderFinalizeVideo$5, d12, 0, videoCaptureRenderer$renderFinalizeVideo$6, videoCaptureRenderer$renderFinalizeVideo$7, b11, q10, videoCaptureRenderer$renderFinalizeVideo$8, false, a11, true, (String) null, (d) null, 201342976, (DefaultConstructorMarker) null);
        return new com.squareup.workflow1.ui.modal.c(b.c(cameraScreen), (List) null, 2, (DefaultConstructorMarker) null);
    }
}
