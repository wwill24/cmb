package com.withpersona.sdk2.inquiry.selfie;

import androidx.lifecycle.g;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class CameraScreenRunner$showRendering$1$captureImage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ g $lifecycleScope;
    final /* synthetic */ SelfieWorkflow.Screen.CameraScreen.a $mode;
    final /* synthetic */ CameraScreenRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraScreenRunner$showRendering$1$captureImage$1(g gVar, CameraScreenRunner cameraScreenRunner, SelfieWorkflow.Screen.CameraScreen.a aVar) {
        super(0);
        this.$lifecycleScope = gVar;
        this.this$0 = cameraScreenRunner;
        this.$mode = aVar;
    }

    public final void invoke() {
        CameraScreenRunner.u(this.$lifecycleScope, this.this$0, this.$mode);
    }
}
