package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;

/* synthetic */ class SelfieCameraScreenViewFactory$1$1$1$1 extends FunctionReferenceImpl implements Function2<SelfieWorkflow.Screen.CameraScreen, p, Unit> {
    SelfieCameraScreenViewFactory$1$1$1$1(Object obj) {
        super(2, obj, CameraScreenRunner.class, "showRendering", "showRendering(Lcom/withpersona/sdk2/inquiry/selfie/SelfieWorkflow$Screen$CameraScreen;Lcom/squareup/workflow1/ui/ViewEnvironment;)V", 0);
    }

    public final void c(SelfieWorkflow.Screen.CameraScreen cameraScreen, p pVar) {
        j.g(cameraScreen, "p0");
        j.g(pVar, "p1");
        ((CameraScreenRunner) this.receiver).a(cameraScreen, pVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        c((SelfieWorkflow.Screen.CameraScreen) obj, (p) obj2);
        return Unit.f32013a;
    }
}
