package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class CameraScreenRunner$showRendering$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SelfieWorkflow.Screen.CameraScreen.a $mode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraScreenRunner$showRendering$1$2(SelfieWorkflow.Screen.CameraScreen.a aVar) {
        super(0);
        this.$mode = aVar;
    }

    public final void invoke() {
        ((SelfieWorkflow.Screen.CameraScreen.a.f) this.$mode).b().invoke();
    }
}
