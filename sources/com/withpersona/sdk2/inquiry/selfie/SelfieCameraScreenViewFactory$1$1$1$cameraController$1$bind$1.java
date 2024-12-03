package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.camera.CameraError;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieCameraScreenViewFactory$1$1$1$cameraController$1$bind$1 extends Lambda implements Function1<CameraError, Unit> {
    final /* synthetic */ SelfieWorkflow.Screen.CameraScreen $initialRendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieCameraScreenViewFactory$1$1$1$cameraController$1$bind$1(SelfieWorkflow.Screen.CameraScreen cameraScreen) {
        super(1);
        this.$initialRendering = cameraScreen;
    }

    public final void a(CameraError cameraError) {
        j.g(cameraError, "it");
        this.$initialRendering.d().invoke(cameraError);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((CameraError) obj);
        return Unit.f32013a;
    }
}
