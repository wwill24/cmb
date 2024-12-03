package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class CameraScreenRunner$showRendering$1$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GovernmentIdWorkflow.Screen.CameraScreen $rendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraScreenRunner$showRendering$1$5(GovernmentIdWorkflow.Screen.CameraScreen cameraScreen) {
        super(0);
        this.$rendering = cameraScreen;
    }

    public final void invoke() {
        this.$rendering.m().invoke();
    }
}
